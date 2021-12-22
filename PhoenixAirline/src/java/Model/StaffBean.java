/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDate;

/**
 *
 * @author Buddhima
 */
public class StaffBean {
    
    DbConnection db = new DbConnection();
    
    ResultSet rs = null;
    PreparedStatement ps = null;
    Connection connectToDb = null;
    
    private String role;
    private String staffName;
    private String staffEmail;
    private String staffGender;
    private String staffTel;
    private String staffPassword;
    private String staffIP;
    private Part profilePhoto;
    private Timestamp staffLastLogin; 
    private String staffJoinedDate;
    
    String staffProfilePhoto;
    String algorithm = "SHA-256";
    byte[] salt = createSalt();
    String hashedStaffPassword = null;
    String rehashedStaffPassword = null;
    String retrievedRole = null;
    String retrievedApprovalStatus = null;
    
    int state = 0;
    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return the staffName
     */
    public String getStaffName() {
        return staffName;
    }

    /**
     * @param staffName the staffName to set
     */
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    /**
     * @return the staffEmail
     */
    public String getStaffEmail() {
        return staffEmail;
    }

    /**
     * @param staffEmail the staffEmail to set
     */
    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    /**
     * @return the staffGender
     */
    public String getStaffGender() {
        return staffGender;
    }

    /**
     * @param staffGender the staffGender to set
     */
    public void setStaffGender(String staffGender) {
        this.staffGender = staffGender;
    }

    /**
     * @return the staffTel
     */
    public String getStaffTel() {
        return staffTel;
    }

    /**
     * @param staffTel the staffTel to set
     */
    public void setStaffTel(String staffTel) {
        this.staffTel = staffTel;
    }

    /**
     * @return the staffPassword
     */
    public String getStaffPassword() {
        return staffPassword;
    }

    /**
     * @param staffPassword the staffPassword to set
     */
    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
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
    
    /**
     * @return the staffJoinedDate
     */
    public String getStaffJoinedDate() {
        return staffJoinedDate;
    }

    /**
     * @param staffJoinedDate the staffJoinedDate to set
     */
    public void setStaffJoinedDate(String staffJoinedDate) {
        this.staffJoinedDate = staffJoinedDate;
    }
    
    /**
     * @return the staffIP
     */
    public String getStaffIP() {
        return staffIP;
    }

    /**
     * @param staffIP the staffIP to set
     */
    public void setStaffIP(String staffIP) {
        this.staffIP = staffIP;
    }

    /**
     * @return the staffLastLogin
     */
    public Timestamp getStaffLastLogin() {
        return staffLastLogin;
    }

    /**
     * @param staffLastLogin the staffLastLogin to set
     */
    public void setStaffLastLogin(Timestamp staffLastLogin) {
        this.staffLastLogin = staffLastLogin;
    }
    
    
    
    public boolean registerStaff(String role, String staffName, String staffEmail, String staffGender, String staffTel, String staffPassword, Part profilePhoto) {
        
        hashedStaffPassword = generateHash(algorithm, staffPassword, salt);
            
        staffProfilePhoto = uploadStaffProfilePhoto(profilePhoto);
        
        setStaffJoinedDate(LocalDate.now().toString());
            
        String sql = "INSERT INTO staff (role,approvalStatus,staffJoinedDate,staffName,staffEmail,staffGender,staffTel,staffHashedPassword,salt,staffProfilePhoto) VALUES (?,?,?,?,?,?,?,?,?,?)";
            
        try {    
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, role);
            ps.setString(2, "pending");
            ps.setString(3, getStaffJoinedDate());
            ps.setString(4, staffName);
            ps.setString(5, staffEmail);
            ps.setString(6, staffGender);
            ps.setString(7, staffTel);
            ps.setString(8, hashedStaffPassword);
            ps.setObject(9, salt);
            ps.setString(10, staffProfilePhoto);
            
            state = ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(StaffBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {ps.close();} catch (SQLException e) {}
            try {db.connectToDb().close();} catch (ClassNotFoundException | SQLException e) {}
        }
        return state  == 1;
    }
    
    
    
    private byte[] createSalt() {
        
        byte[] bytes = new byte[20];
        SecureRandom sr = new SecureRandom();
        sr.nextBytes(bytes);
        return bytes;
    }
    
    
    
    private String generateHash(String algorithm, String staffPassword, byte[] salt) {
        
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.reset();
            md.update(salt);
            byte[] hash = md.digest(staffPassword.getBytes());
            
            StringBuilder sb = new StringBuilder();
            
            for(byte b : hash) {
                sb.append(String.format("%02x", b));  // x means convert to hex. print atleast 2 digits. If there's less, preprend it with 0s.
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(StaffBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    
    
     private String uploadStaffProfilePhoto(Part profilePhoto) {
        
        String fileName = profilePhoto.getSubmittedFileName();
        String uploadPath = "D:/Projects/Web Applications/Phoneix Airline/PhoenixAirline/web/Images/Profile Photos/Staff/"+fileName;
            
        try {
            FileOutputStream fos = new FileOutputStream(uploadPath);   // used to write image data.
            InputStream is = profilePhoto.getInputStream();   // used to read data from a file.
            byte[] data = new byte[is.available()];   // is.available returns the estimate of the no of bytes that can be read.
            is.read(data);
            fos.write(data);
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(StaffBean.class.getName()).log(Level.SEVERE, null, ex);
        }
         return fileName;
    }
    
     
     
     public List loginStaff(String staffEmail, String staffPassword) {
         
        List staffData = new ArrayList();
            
            String sql1  = "SELECT salt FROM staff WHERE staffEmail=?";
            String sql2 = "SELECT * FROM staff WHERE staffEmail=? AND staffHashedPassword=?";
            

            try {
                ps = db.connectToDb().prepareStatement(sql1);
                ps.setString(1, staffEmail);
                rs = ps.executeQuery();

                if(rs.next()) {

                    byte[] retrievedSalt = rs.getBytes("salt");

                    rehashedStaffPassword = generateHash(algorithm, staffPassword, retrievedSalt);

                    ps = db.connectToDb().prepareStatement(sql2);
                    ps.setString(1, staffEmail);
                    ps.setString(2, rehashedStaffPassword);
                    rs = ps.executeQuery();

                    while(rs.next()) {
                        staffData.add(rs.getString("staffProfilePhoto"));
                        staffData.add(rs.getString("staffName"));
                        staffData.add(rs.getString("staffEmail"));
                        staffData.add(rs.getString("role"));
                        staffData.add(rs.getString("staffGender"));
                        staffData.add(rs.getString("staffTel"));
                        staffData.add(rs.getString("staffJoinedDate"));
                    }
                }
                
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(StaffBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally {
                try {rs.close();} catch (SQLException ex) {}
                try {ps.close();} catch (SQLException e) {}
                try {db.connectToDb().close();} catch (ClassNotFoundException | SQLException e) {}
            }
        return staffData;
    }
     

 
     public void getStaffIPAndLastLogin(String staffEmail) {
        
        String sql1 = "UPDATE staff SET staffIP=?, staffLastLogin=? WHERE staffEmail=?";
          
        try{
            ps = db.connectToDb().prepareStatement(sql1);
            ps.setString(1, getStaffIP());
            ps.setTimestamp(2, getStaffLastLogin());
            ps.setString(3, staffEmail);
            state = ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(StaffBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
                try {ps.close();} catch (SQLException e) {}
                try {db.connectToDb().close();} catch (ClassNotFoundException | SQLException e) {}
        }
    }
      
      
      
     public String getRole(String staffEmail) {
         
        String sql = "SELECT role FROM staff where staffEmail=?";
         
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, staffEmail);
            rs = ps.executeQuery();
            if(rs.next()) {
                retrievedRole = rs.getString("role");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(StaffBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {rs.close();} catch (SQLException ex) {}
            try {ps.close();} catch (SQLException e) {}
            try {db.connectToDb().close();} catch (ClassNotFoundException | SQLException e) {}
        }
        return retrievedRole;
    }
     
     
     
    public String getApprovalStatus(String staffEmail) {
        
        String sql = "SELECT approvalStatus FROM staff WHERE staffEmail=?";
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, staffEmail);
            rs = ps.executeQuery();
            if(rs.next()) {
                retrievedApprovalStatus = rs.getString("approvalStatus");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(StaffBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {rs.close();} catch (SQLException ex) {}
            try {ps.close();} catch (SQLException e) {}
            try {db.connectToDb().close();} catch (ClassNotFoundException | SQLException e) {}
        }
        return retrievedApprovalStatus;
    }
    
    
    
    public boolean approveStaff(String staffEmail) {
       
        String sql = "UPDATE staff SET approvalStatus=? WHERE staffEmail=?";
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, "approved");
            ps.setString(2, staffEmail);
            state = ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StaffBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {ps.close();} catch (SQLException e) {}
            try {db.connectToDb().close();} catch (ClassNotFoundException | SQLException e) {}
        }
        return state == 1;
    }

    
    
    public boolean declineStaff(String staffEmail) {
        
        String sql = "DELETE FROM staff WHERE staffEmail=?";
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, staffEmail);
            state = ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StaffBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {ps.close();} catch (SQLException e) {}
            try {db.connectToDb().close();} catch (ClassNotFoundException | SQLException e) {}
        }
        return state == 1;
    }
    
    
    
    public List viewStaff() {

           List staffList  = new ArrayList();

           String sql = "SELECT * FROM staff WHERE approvalStatus=?";

           try {
               ps = db.connectToDb().prepareStatement(sql);
               ps.setString(1, "approved");
               rs = ps.executeQuery();

               while(rs.next()) {
                   staffList.add(rs.getString("staffProfilePhoto"));
                   staffList.add(rs.getString("staffEmail"));   // to update staff profile photo
                   staffList.add(rs.getString("role"));
                   staffList.add(rs.getString("staffEmail"));   // to update staff role
                   staffList.add(rs.getString("staffJoinedDate"));
                   staffList.add(rs.getString("staffName"));
                   staffList.add(rs.getString("staffEmail"));   // to update staff name
                   staffList.add(rs.getString("staffEmail"));
                   staffList.add(rs.getString("staffGender"));
                   staffList.add(rs.getString("staffEmail"));   // to update staff gender
                   staffList.add(rs.getString("staffTel"));
                   staffList.add(rs.getString("staffEmail"));   // to update staff email
                   staffList.add(rs.getString("staffIP"));
                   staffList.add(rs.getTimestamp("staffLastLogin"));
                   staffList.add(rs.getString("staffEmail"));
               }

           } catch (SQLException | ClassNotFoundException ex) {
               Logger.getLogger(StaffBean.class.getName()).log(Level.SEVERE, null, ex);
           }
           finally {
               try {rs.close();} catch (SQLException ex) {}
               try {ps.close();} catch (SQLException e) {}
               try {db.connectToDb().close();} catch (ClassNotFoundException | SQLException e) {}
           }
           return staffList;
       }
    
    
    
    public boolean deleteStaff(String staffEmail) {
        
        String sql1 = "SELECT staffProfilePhoto FROM staff WHERE staffEmail=?";
        String sql2 = "DELETE FROM staff WHERE staffEmail=?";
        
        try {
            ps = db.connectToDb().prepareStatement(sql1);
            ps.setString(1, staffEmail);
            rs = ps.executeQuery();
            if(rs.next()) {
                String fileName = rs.getString("staffProfilePhoto");
                Path profilePhotoPath = Paths.get("D:/Projects/Web Applications/Phoneix Airline/PhoenixAirline/web/Images/Profile Photos/Staff/"+fileName);
                Files.delete(profilePhotoPath);
            }
            
            ps = db.connectToDb().prepareStatement(sql2);
            ps.setString(1, staffEmail);
            state = ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(StaffBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {ps.close();} catch (SQLException e) {}
            try {db.connectToDb().close();} catch (ClassNotFoundException | SQLException e) {}
        }
        return state == 1;  
    }

    
    
    public List viewPendingRegistrations() {
        
        List pendingRegistrations = new ArrayList();
        
        String sql = "SELECT role, staffJoinedDate, staffName, staffEmail FROM staff WHERE approvalStatus=?";
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, "pending");
            rs = ps.executeQuery();
            
            while(rs.next()) {
                pendingRegistrations.add(rs.getString("role"));
                pendingRegistrations.add(rs.getString("staffJoinedDate"));
                pendingRegistrations.add(rs.getString("staffName"));
                pendingRegistrations.add(rs.getString("staffEmail"));
                pendingRegistrations.add(rs.getString("staffEmail"));
                pendingRegistrations.add(rs.getString("staffEmail"));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(StaffBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {rs.close();} catch (SQLException ex) {}
            try {ps.close();} catch (SQLException e) {}
            try {db.connectToDb().close();} catch (ClassNotFoundException | SQLException e) {}
        }
        return pendingRegistrations;
    }
    
    
    
    public List filterStaffByRole(String role) {
        
        List staffList = new ArrayList();
            
        String sql = "SELECT * FROM staff WHERE approvalStatus=? AND role=?";
        
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, "approved");
            ps.setString(2, role);
            rs = ps.executeQuery();
            while(rs.next()) {
                   staffList.add(rs.getString("staffProfilePhoto"));
                   staffList.add(rs.getString("role"));
                   staffList.add(rs.getString("staffJoinedDate"));
                   staffList.add(rs.getString("staffName"));
                   staffList.add(rs.getString("staffEmail"));
                   staffList.add(rs.getString("staffGender"));
                   staffList.add(rs.getString("staffTel"));
                   staffList.add(rs.getString("staffIP"));
                   staffList.add(rs.getTimestamp("staffLastLogin"));
                   staffList.add(rs.getString("staffEmail"));
                   staffList.add(rs.getString("staffEmail"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StaffBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {rs.close();} catch (SQLException ex) {}
            try {ps.close();} catch (SQLException e) {}
            try {db.connectToDb().close();} catch (ClassNotFoundException | SQLException e) {}
        }
        return staffList;
    }
    
    
    
    public List filterStaffByGender(String staffGender) {
        
        List staffList = new ArrayList();
            
        String sql = "SELECT * FROM staff WHERE approvalStatus=? AND staffGender=?";
        
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, "approved");
            ps.setString(2, staffGender);
            rs = ps.executeQuery();
            while(rs.next()) {
                   staffList.add(rs.getString("staffProfilePhoto"));
                   staffList.add(rs.getString("role"));
                   staffList.add(rs.getString("staffJoinedDate"));
                   staffList.add(rs.getString("staffName"));
                   staffList.add(rs.getString("staffEmail"));
                   staffList.add(rs.getString("staffGender"));
                   staffList.add(rs.getString("staffTel"));
                   staffList.add(rs.getString("staffIP"));
                   staffList.add(rs.getTimestamp("staffLastLogin"));
                   staffList.add(rs.getString("staffEmail"));
                   staffList.add(rs.getString("staffEmail"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StaffBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {rs.close();} catch (SQLException ex) {}
            try {ps.close();} catch (SQLException e) {}
            try {db.connectToDb().close();} catch (ClassNotFoundException | SQLException e) {}
        }
        return staffList;
    }
    
    
    
    public List filterStaffByJoinedDate(String staffJoinedDate) {
        
        List staffList = new ArrayList();
        
        String sql = "SELECT * FROM staff WHERE approvalStatus=? AND staffJoinedDate LIKE ?";
        
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, "approved");
            ps.setString(2, "%"+staffJoinedDate+"%");
            rs = ps.executeQuery();
            while(rs.next()) {
                   staffList.add(rs.getString("staffProfilePhoto"));
                   staffList.add(rs.getString("role"));
                   staffList.add(rs.getString("staffJoinedDate"));
                   staffList.add(rs.getString("staffName"));
                   staffList.add(rs.getString("staffEmail"));
                   staffList.add(rs.getString("staffGender"));
                   staffList.add(rs.getString("staffTel"));
                   staffList.add(rs.getString("staffIP"));
                   staffList.add(rs.getTimestamp("staffLastLogin"));
                   staffList.add(rs.getString("staffEmail"));
                   staffList.add(rs.getString("staffEmail"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StaffBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {rs.close();} catch (SQLException ex) {}
            try {ps.close();} catch (SQLException e) {}
            try {db.connectToDb().close();} catch (ClassNotFoundException | SQLException e) {}
        }
        return staffList;
    }

    
    
    public boolean updateStaffGender(String staffEmail, String staffGender) {
        String sql = "UPDATE staff SET staffGender=? WHERE staffEmail=?";
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, staffGender);
            ps.setString(2, staffEmail);
            state = ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClientBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state == 1;
    }

    
    
    public boolean updateAdminName(String staffEmail, String staffName) {
        
        String sql = "UPDATE staff SET staffName=? WHERE staffEmail=?";
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, staffName);
            ps.setString(2, staffEmail);
            state = ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClientBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state == 1;
    }

    
    
    public boolean updateStaffTel(String staffEmail, String staffTel) {
        
        String sql = "UPDATE staff SET staffTel=? WHERE staffEmail=?";
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, staffTel);
            ps.setString(2, staffEmail);
            state = ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClientBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state == 1;
    }
    
    

    public boolean updateProfilePhoto(String staffEmail, Part profilePhoto) {
        
        String sql = "UPDATE staff SET staffProfilePhoto=? WHERE staffEmail=?";
        
        staffProfilePhoto = uploadStaffProfilePhoto(profilePhoto);
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, staffProfilePhoto);
            ps.setString(2, staffEmail);
            state = ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClientBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state == 1;
    }

    
    public boolean updateStaffRole(String staffEmail, String role) {
        
        String sql = "UPDATE staff SET role=?, staffEmail=? WHERE staffEmail=?";
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, role);
            ps.setString(2, staffEmail);
            ps.setString(3, staffEmail);
            state = ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClientBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state == 1;
    }
}
