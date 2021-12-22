/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.BaseException;
import Controller.Exceptions;
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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
public class ClientBean {
    
    DbConnection db = new DbConnection();
    
    ResultSet rs = null;
    ResultSet rs1 = null;
    ResultSet rs2 = null;
    PreparedStatement ps = null;
    Connection connectToDb = null;
    
    private String clientName;
    private Date clientDOB;
    private String clientGender;
    private String clientEmail;
    private String clientTel;
    private String clientHouseNo;
    private String clientStreetName;
    private String clientCity;
    private String clientProvince;
    private String clientPassword;
    private Part profilePhoto;
    private String clientSecurityQuestion;
    private String clientAnswer;
    private Timestamp clientLastLogin; 
    private String clientIP;
    private String clientNewEmail;
    
    String algorithm = "SHA-256";
    String hashedClientPassword = null;
    String hashedSecurityAnswer = null;
    byte[] clientPasswordSalt = createSalt();
    byte[] securityAnswerSalt = createSalt();
    String clientProfilePhoto = null;
    String rehasedClientPassword = null;
    String rehashedSecurityAnswer = null;
    
    int state = 0;
    

    /**
     * @return the clientName
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * @param clientName the clientName to set
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * @return the clientDOB
     */
    public Date getClientDOB() {
        return clientDOB;
    }

    /**
     * @param clientDOB the clientDOB to set
     */
    public void setClientDOB(Date clientDOB) {
        this.clientDOB = clientDOB;
    }

    /**
     * @return the clientGender
     */
    public String getClientGender() {
        return clientGender;
    }

    /**
     * @param clientGender the clientGender to set
     */
    public void setClientGender(String clientGender) {
        this.clientGender = clientGender;
    }

    /**
     * @return the clientEmail
     */
    public String getClientEmail() {
        return clientEmail;
    }

    /**
     * @param clientEmail the clientEmail to set
     */
    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    /**
     * @return the clientTel
     */
    public String getClientTel() {
        return clientTel;
    }

    /**
     * @param clientTel the clientTel to set
     */
    public void setClientTel(String clientTel) {
        this.clientTel = clientTel;
    }

    /**
     * @return the clientHouseNo
     */
    public String getClientHouseNo() {
        return clientHouseNo;
    }

    /**
     * @param clientHouseNo the clientHouseNo to set
     */
    public void setClientHouseNo(String clientHouseNo) {
        this.clientHouseNo = clientHouseNo;
    }

    /**
     * @return the clientStreetName
     */
    public String getClientStreetName() {
        return clientStreetName;
    }

    /**
     * @param clientStreetName the clientStreetName to set
     */
    public void setClientStreetName(String clientStreetName) {
        this.clientStreetName = clientStreetName;
    }

    /**
     * @return the clientCity
     */
    public String getClientCity() {
        return clientCity;
    }

    /**
     * @param clientCity the clientCity to set
     */
    public void setClientCity(String clientCity) {
        this.clientCity = clientCity;
    }

    /**
     * @return the clientProvince
     */
    public String getClientProvince() {
        return clientProvince;
    }

    /**
     * @param clientProvince the clientProvince to set
     */
    public void setClientProvince(String clientProvince) {
        this.clientProvince = clientProvince;
    }

    /**
     * @return the clientPassword
     */
    public String getClientPassword() {
        return clientPassword;
    }

    /**
     * @param clientPassword the clientPassword to set
     */
    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
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
     * @return the clientSecurityQuestion
     */
    public String getClientSecurityQuestion() {
        return clientSecurityQuestion;
    }

    /**
     * @param clientSecurityQuestion the clientSecurityQuestion to set
     */
    public void setClientSecurityQuestion(String clientSecurityQuestion) {
        this.clientSecurityQuestion = clientSecurityQuestion;
    }

    /**
     * @return the clientAnswer
     */
    public String getClientAnswer() {
        return clientAnswer;
    }

    /**
     * @param clientAnswer the clientAnswer to set
     */
    public void setClientAnswer(String clientAnswer) {
        this.clientAnswer = clientAnswer;
    }

    /**
     * @return the clientIP
     */
    public String getClientIP() {
        return clientIP;
    }

    /**
     * @param clientIP the clientIP to set
     */
    public void setClientIP(String clientIP) {
        this.clientIP = clientIP;
    }

    /**
     * @return the clientLastLogin
     */
    public Timestamp getClientLastLogin() {
        return clientLastLogin;
    }

    /**
     * @param clientLastLogin the clientLastLogin to set
     */
    public void setClientLastLogin(Timestamp clientLastLogin) {
        this.clientLastLogin = clientLastLogin;
    }
    
    /**
     * @return the clientNewEmail
     */
    public String getClientNewEmail() {
        return clientNewEmail;
    }

    /**
     * @param clientNewEmail the clientNewEmail to set
     */
    public void setClientNewEmail(String clientNewEmail) {
        this.clientNewEmail = clientNewEmail;
    }
    
    
    
    public boolean registerClient(String clientName, Date clientDOB, String clientGender, String clientEmail, String clientTel, String clientHouseNo, String clientStreetName, String clientCity, String clientProvince, String clientPassword, Part profilePhoto, String clientSecurityQuestion, String clientAnswer) throws BaseException {
        
        hashedClientPassword = generateHash(algorithm, clientPassword, clientPasswordSalt);
        
        clientProfilePhoto = uploadClientProfilePhoto(profilePhoto);
        
        hashedSecurityAnswer = generateHash(algorithm, clientAnswer, securityAnswerSalt);
        
        String clientJoinedDate = LocalDate.now().toString();
        
        String sql = "INSERT INTO client (accountStatus,clientJoinedDate,clientName,clientDOB,clientGender,clientEmail,clientTel,clientHouseNo,clientStreetName,clientCity,clientProvince,clientHashedPassword,clientPasswordSalt,clientProfilePhoto,securityQuestion,hashedSecurityAnswer,securityAnswerSalt) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, "active");
            ps.setString(2, clientJoinedDate);
            ps.setString(3, clientName);
            ps.setDate(4, clientDOB);
            ps.setString(5, clientGender);
            ps.setString(6, clientEmail );
            ps.setString(7, clientTel);
            ps.setString(8, clientHouseNo);
            ps.setString(9, clientStreetName);
            ps.setString(10, clientCity);
            ps.setString(11, clientProvince);
            ps.setString(12, hashedClientPassword);
            ps.setObject(13, clientPasswordSalt);
            ps.setString(14, clientProfilePhoto);
            ps.setString(15, clientSecurityQuestion);
            ps.setString(16, hashedSecurityAnswer);
            ps.setObject(17, securityAnswerSalt);
            state = ps.executeUpdate();
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClientBean.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exceptions.accountAlreadyExists("You already have an account with this email");
        }
        
        return state == 1;
    }

    
    
    private byte[] createSalt() {
        
        byte[] bytes = new byte[20];
        SecureRandom sr = new SecureRandom();
        sr.nextBytes(bytes);
        return bytes;
    }
    
    

    private String generateHash(String algorithm, String clientPassword, byte[] salt) {
        
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.reset();
            md.update(salt);
            byte[] hash = md.digest(clientPassword.getBytes());
            
            StringBuilder sb = new StringBuilder();
            
            for(byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ClientBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    

    private String uploadClientProfilePhoto(Part profilePhoto) {
        
        String fileName = profilePhoto.getSubmittedFileName();
        String uploadPath = "D:/Projects/Web Applications/Phoneix Airline/PhoenixAirline/web/Images/Profile Photos/Client/"+fileName;
        
        try {
            FileOutputStream fos = new FileOutputStream(uploadPath);
            InputStream is = profilePhoto.getInputStream();
            byte[] data = new byte[is.available()];
            is.read(data);
            fos.write(data);
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fileName;
    }

    
    
    public List loginClient(String clientEmail, String clientPassword) throws BaseException {
        
        List clientList = new ArrayList();
        
        String sql1 = "SELECT clientPasswordSalt from client WHERE clientEmail=?";
        String sql2 = "SELECT * from client WHERE clientEmail=? AND clientHashedPassword=?";
        
        try {
            ps = db.connectToDb().prepareStatement(sql1);
            ps.setString(1, clientEmail);
            rs = ps.executeQuery();
            
            if(rs.next()) {
                
                byte[] retrievedClientPasswordSalt = rs.getBytes("clientPasswordSalt");
                
                rehasedClientPassword = generateHash(algorithm,clientPassword,retrievedClientPasswordSalt);
                
                ps = db.connectToDb().prepareStatement(sql2);
                ps.setString(1, clientEmail);
                ps.setString(2, rehasedClientPassword);
                rs = ps.executeQuery();
                
                while(rs.next()) {
                    clientList.add(rs.getString("clientProfilePhoto"));
                    clientList.add(rs.getString("clientName"));
                    clientList.add(rs.getString("clientEmail"));
                    clientList.add(rs.getString("clientGender"));
                    clientList.add(rs.getString("clientTel"));
                    clientList.add(rs.getString("clientDOB"));
                    clientList.add(rs.getString("clientHouseNo"));
                    clientList.add(rs.getString("clientStreetName"));
                    clientList.add(rs.getString("clientCity"));
                    clientList.add(rs.getString("clientProvince"));
                    clientList.add(rs.getString("clientJoinedDate"));
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClientBean.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exceptions.invalidCredentials("Username or password is incorrect");
        }
        return clientList;
    }
    
    
    
    public void getClientIPAndLastLogin(String clientEmail) {
        
        String sql1 = "UPDATE client SET clientIP=?, clientLastLogin=? WHERE clientEmail=?";
          
        try{
            ps = db.connectToDb().prepareStatement(sql1);
            ps.setString(1, getClientIP());
            ps.setTimestamp(2, getClientLastLogin());
            ps.setString(3, clientEmail);
            state = ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(StaffBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
                try {ps.close();} catch (SQLException e) {}
                try {db.connectToDb().close();} catch (ClassNotFoundException | SQLException e) {}
        }
    }
    
     
     
    public boolean deleteClient(String clientEmail) {
        
        String sql1 = "SELECT clientProfilePhoto FROM client WHERE clientEmail=?";
        String sql2 = "DELETE FROM client WHERE clientEmail=?";
        
        try{
            ps = db.connectToDb().prepareStatement(sql1);
            ps.setString(1, clientEmail);
            rs = ps.executeQuery();
            if(rs.next()) {
                String fileName = rs.getString("clientProfilePhoto");
                Path profilePhotoPath = Paths.get("D:/Projects/Web Applications/Phoneix Airline/PhoenixAirline/web/Images/Profile Photos/Client/"+fileName);
                Files.delete(profilePhotoPath);
            }
            
            ps = db.connectToDb().prepareStatement(sql2);
            ps.setString(1, clientEmail);
            state = ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(ClientBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return state == 1;
    }
    
    

    public String recoverClientPassword(String clientEmail, String clientSecurityQuestion, String clientAnswer) {
        
        String sq11 = "SELECT securityQuestion, securityAnswerSalt FROM client WHERE clientEmail=?";
        String sql2 = "SELECT clientEmail FROM client WHERE securityQuestion=? && hashedSecurityAnswer=?";
        
        try {
            ps = db.connectToDb().prepareStatement(sq11);
            ps.setString(1, clientEmail);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                
                setClientSecurityQuestion(rs.getString("securityQuestion"));
                clientSecurityQuestion = getClientSecurityQuestion();
                
                byte[] retrievedSecurityAnswerSalt = rs.getBytes("securityAnswerSalt");
                
                rehashedSecurityAnswer = generateHash(algorithm,clientAnswer,retrievedSecurityAnswerSalt);
                
                ps = db.connectToDb().prepareStatement(sql2);
                ps.setString(1, clientSecurityQuestion);
                ps.setString(2, rehashedSecurityAnswer);
                rs = ps.executeQuery();
                
                if(rs.next()) {
                    setClientEmail(rs.getString("clientEmail"));
                    clientEmail = getClientEmail();
                }
                
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClientBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientEmail;
    }

    
    
    public boolean updateClientName(String clientEmail, String clientName) {
        
        String sql = "UPDATE client SET clientName=? WHERE clientEmail=?";
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, clientName);
            ps.setString(2, clientEmail );
            state = ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClientBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state == 1;
    }

    
    
    public boolean updateClientEmail(String clientEmail, String clientNewEmail) {
       
        String sql = "UPDATE client SET clientEmail=? WHERE clientEmail=?";
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, clientNewEmail);
            ps.setString(2, clientEmail );
            state = ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClientBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state == 1;
    }

    
    
    public boolean updateClientGender(String clientEmail, String clientGender) {
        
        String sql = "UPDATE client SET clientGender=? WHERE clientEmail=?";
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, clientGender);
            ps.setString(2, clientEmail );
            state = ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClientBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state == 1;
    }

    
    
    public boolean updateClientTel(String clientEmail, String clientTel) {
        
        String sql = "UPDATE client SET clientTel=? WHERE clientEmail=?";
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, clientTel);
            ps.setString(2, clientEmail );
            state = ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClientBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state == 1;
    }

    
    
    public boolean updateClientAddress(String clientEmail, String clientHouseNo, String clientStreetName, String clientCity, String clientProvince) {
        
        String sql = "UPDATE client SET clientHouseNo=?,clientStreetName=?,clientCity=?,clientProvince=?  WHERE clientEmail=?";
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, clientHouseNo);
            ps.setString(2, clientStreetName);
            ps.setString(3, clientCity);
            ps.setString(4, clientProvince );
            ps.setString(5, clientEmail );
            state = ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClientBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state == 1;
    }

    
    
    public boolean updateProfilePhoto(String clientEmail, Part profilePhoto) {
        
        String sql = "UPDATE client SET clientProfilePhoto=? WHERE clientEmail=?";
        
        clientProfilePhoto = uploadClientProfilePhoto(profilePhoto);
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, clientProfilePhoto);
            ps.setString(2, clientEmail );
            state = ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClientBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state == 1;
    }

    
    
    public boolean updateClientPassword(String clientEmail, String clientPassword) {
        
        String sql = "UPDATE client SET clientHashedPassword=?, clientPasswordSalt=? WHERE clientEmail=?";
        
        hashedClientPassword = generateHash(algorithm, clientPassword, clientPasswordSalt);
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, hashedClientPassword);
            ps.setObject(2, clientPasswordSalt);
            ps.setString(3, clientEmail);
            state = ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClientBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state == 1;
    }

}
