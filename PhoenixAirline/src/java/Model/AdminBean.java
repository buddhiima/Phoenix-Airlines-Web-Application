/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;

/**
 *
 * @author Buddhima
 */
public class AdminBean {
    
    DbConnection db = new DbConnection();
    
    ResultSet rs = null;
    PreparedStatement ps = null;
    Connection connectToDb = null;
    
    private String adminName;
    private String adminEmail;
    private String adminGender;
    private String adminTel;
    private String adminPassword;
    private Part profilePhoto;
    String adminProfilePhoto = null;
    String algorithm = "SHA-256";
    String hashedAdminPassword = null;
    String rehasedAdminPassword = null;
    byte[] salt = createSalt();
    
    int state = 0;
    

    /**
     * @return the adminName
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * @param adminName the adminName to set
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    /**
     * @return the adminEmail
     */
    public String getAdminEmail() {
        return adminEmail;
    }

    /**
     * @param adminEmail the adminEmail to set
     */
    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    /**
     * @return the adminGender
     */
    public String getAdminGender() {
        return adminGender;
    }

    /**
     * @param adminGender the adminGender to set
     */
    public void setAdminGender(String adminGender) {
        this.adminGender = adminGender;
    }

    /**
     * @return the adminTel
     */
    public String getAdminTel() {
        return adminTel;
    }

    /**
     * @param adminTel the adminTel to set
     */
    public void setAdminTel(String adminTel) {
        this.adminTel = adminTel;
    }

    /**
     * @return the adminPassword
     */
    public String getAdminPassword() {
        return adminPassword;
    }

    /**
     * @param adminPassword the adminPassword to set
     */
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    /**
     * @return the profilePhoto
     */
    public Part getProfilePhoto() {
        return profilePhoto;
    }

    /**
     * @param profilePhoto the profilePhoto to set
     */
    public void setProfilePhoto(Part profilePhoto) {
        this.profilePhoto = profilePhoto;
    }
    
    
    public boolean registerAdmin(String adminName, String adminEmail, String adminGender, String adminTel, String adminPassword, Part profilePhoto) {
        
        hashedAdminPassword = generateHash(algorithm, adminPassword, salt);
            
        adminProfilePhoto = uploadAdminProfilePhoto(profilePhoto);
            
        String adminJoinedDate = LocalDate.now().toString();
            
        String sql = "INSERT INTO admin (adminJoinedDate,adminName,adminEmail,adminGender,adminTel,adminHashedPassword,salt,adminProfilePhoto) VALUES (?,?,?,?,?,?,?,?)";
            
        try {    
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, adminJoinedDate);
            ps.setString(2, adminName);
            ps.setString(3, adminEmail);
            ps.setString(4, adminGender);
            ps.setString(5, adminTel);
            ps.setString(6, hashedAdminPassword);
            ps.setObject(7, salt);
            ps.setString(8, adminProfilePhoto);
            state = ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdminBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {ps.close();} catch (SQLException e) {}
            try {db.connectToDb().close();} catch (ClassNotFoundException | SQLException e) {}
        }
        return state == 1;
    }

    
    
    private byte[] createSalt() {
        
        byte[] bytes = new byte[20];
        SecureRandom sr = new SecureRandom();
        sr.nextBytes(bytes);
        return bytes;
    }

    
    
    public String generateHash(String algorithm, String adminPassword, byte[] salt) {
        
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.reset();
            md.update(salt);
            byte[] hash =  md.digest(adminPassword.getBytes());
            
            StringBuilder sb = new StringBuilder();
            
            for(byte b : hash) {
                sb.append(String.format("%02x",b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AdminBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    
    
    private String uploadAdminProfilePhoto(Part profilePhoto) {
        
        
        String fileName = profilePhoto.getSubmittedFileName();
        String uploadPath = "D:/Projects/Web Applications/Phoneix Airline/PhoenixAirline/web/Images/Profile Photos/Admin/"+fileName;
            
        try {
            FileOutputStream fos = new FileOutputStream(uploadPath);
            InputStream is = profilePhoto.getInputStream();
            byte[] data = new byte[is.available()];
            is.read(data);
            fos.write(data);
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(AdminBean.class.getName()).log(Level.SEVERE, null, ex);
        }
       return  fileName;
    }

    
    
    public List loginAdmin(String adminEmail, String adminPassword) {
        
        List adminData = new ArrayList();
        
        String sql1  = "SELECT salt FROM admin WHERE adminEmail=?";
        String sql2 = "SELECT * FROM admin WHERE adminEmail=? AND adminHashedPassword=?";
        
        try {
            ps = db.connectToDb().prepareStatement(sql1);
            ps.setString(1, adminEmail);
            rs = ps.executeQuery();
            
            if(rs.next()) {
                
                byte[] retrievedSalt = rs.getBytes("salt");
                
                rehasedAdminPassword = generateHash(algorithm, adminPassword, retrievedSalt);
                
                ps = db.connectToDb().prepareStatement(sql2);
                ps.setString(1, adminEmail);
                ps.setString(2, rehasedAdminPassword);
                rs = ps.executeQuery();
                
                while(rs.next()) {
                    adminData.add(rs.getString("adminProfilePhoto"));
                    adminData.add(rs.getString("adminName"));
                    adminData.add(rs.getString("adminEmail"));
                    adminData.add(rs.getString("adminGender"));
                    adminData.add(rs.getString("adminTel"));
                    adminData.add(rs.getString("adminJoinedDate"));
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {rs.close();} catch (SQLException ex) {}
            try {ps.close();} catch (SQLException e) {}
            try {db.connectToDb().close();} catch (ClassNotFoundException | SQLException e) {}
        }
        return adminData;
    }
    
    
    
    public boolean deleteAdmin(String adminEmail) {
        
        String sql1 = "SELECT adminProfilePhoto FROM admin WHERE adminEmail=?";
        String sql2 = "DELETE FROM admin WHERE adminEmail=?";
        
        try {
            ps = db.connectToDb().prepareStatement(sql1);
            ps.setString(1, adminEmail);
            rs = ps.executeQuery();
            if(rs.next()) {
                String fileName = rs.getString("adminProfilePhoto");
                Path profilePhotoPath = Paths.get("D:/Projects/Web Applications/Phoneix Airline/PhoenixAirline/web/Images/Profile Photos/Admin/"+fileName);
                Files.delete(profilePhotoPath);
            }
            
            ps = db.connectToDb().prepareStatement(sql2);
            ps.setString(1, adminEmail);
            state = ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(AdminBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {ps.close();} catch (SQLException e) {}
            try {db.connectToDb().close();} catch (ClassNotFoundException | SQLException e) {}
        }
        return state == 1;    
    }

    
    
    public boolean updateAdminPassword(String adminEmail, String adminPassword) {
        
        String sql = "UPDATE admin SET adminHashedPassword=?, salt=? WHERE adminEmail=?";
        
        hashedAdminPassword = generateHash(algorithm, adminPassword, salt);
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, hashedAdminPassword);
            ps.setObject(2, salt );
            ps.setString(3, adminEmail);
            state = ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClientBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state == 1;
    }

    
    
    public boolean updateAdminGender(String adminEmail, String adminGender) {
        
        String sql = "UPDATE admin SET adminGender=? WHERE adminEmail=?";
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, adminGender);
            ps.setString(2, adminEmail );
            state = ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClientBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state == 1;
    }

    
    
    public boolean updateAdminName(String adminEmail, String adminName) {
        
        String sql = "UPDATE admin SET adminName=? WHERE adminEmail=?";
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, adminName);
            ps.setString(2, adminEmail );
            state = ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClientBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state == 1;
    }

    
    
    public boolean updateAdminTel(String adminEmail, String adminTel) {
        
        String sql = "UPDATE admin SET adminTel=? WHERE adminEmail=?";
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, adminTel);
            ps.setString(2, adminEmail );
            state = ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClientBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state == 1;
    }

    
    
    public boolean updateProfilePhoto(String adminEmail, Part profilePhoto) {
        
        String sql = "UPDATE admin SET adminProfilePhoto=? WHERE adminEmail=?";
        
        adminProfilePhoto = uploadAdminProfilePhoto(profilePhoto);
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, adminProfilePhoto);
            ps.setString(2, adminEmail );
            state = ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClientBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state == 1;
    }

    
    
    public String recoverAdminPassword(String adminEmail, String adminTel) {
        
        String sq1 = "SELECT adminTel FROM admin WHERE adminEmail=?";
        
        try {
            ps = db.connectToDb().prepareStatement(sq1);
            ps.setString(1, adminEmail);
            rs = ps.executeQuery();
            
            if(rs.next()) {
                if(rs.getString("adminTel").equals(adminTel)) {
                    return adminEmail;
                }
            }
                
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClientBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
}
