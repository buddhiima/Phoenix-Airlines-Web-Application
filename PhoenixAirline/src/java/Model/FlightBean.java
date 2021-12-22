/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Buddhima
 */
public class FlightBean {
    
    DbConnection db = new DbConnection();
    
    ResultSet rs = null;
    PreparedStatement ps = null;
    Connection connectToDb = null;
    
    private String flightID;
    private String destination;
    private String availableDay;
    private Time departTime;
    private int noOfSeats;
    
    int state = 0;
    
     /**
     * @return the flightID
     */
    public String getFlightID() {
        return flightID;
    }

    /**
     * @param flightID the flightID to set
     */
    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @return the availableDay
     */
    public String getAvailableDay() {
        return availableDay;
    }

    /**
     * @param availableDay the availableDay to set
     */
    public void setAvailableDay(String availableDay) {
        this.availableDay = availableDay;
    }

    /**
     * @return the departTime
     */
    public Time getDepartTime() {
        return departTime;
    }

    /**
     * @param departTime the departTime to set
     */
    public void setDepartTime(Time departTime) {
        this.departTime = departTime;
    }

    /**
     * @return the noOfSeats
     */
    public int getNoOfSeats() {
        return noOfSeats;
    }

    /**
     * @param noOfSeats the noOfSeats to set
     */
    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }
    
    public boolean addFlight(String flightID, String destination, String availableDay, Time departTime, int noOfSeats) {
        
        String sql = "INSERT INTO flight (flightID,destination,availableDay,departTime,noOfSeats) VALUES (?,?,?,?,?)";
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            
            ps.setString(1, flightID);
            ps.setString(2, destination);
            ps.setString(3, availableDay);
            ps.setTime(4, departTime);
            ps.setInt(5, noOfSeats);
            
            state = ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FlightBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {ps.close();} catch (SQLException e) {}
            try {db.connectToDb().close();} catch (ClassNotFoundException | SQLException e) {}
        }
        return state == 1;
    }
    

    
    public List viewFlights() {
        
        List flightList  = new ArrayList();
            
        String sql = "SELECT * FROM flight";
            
        try {
            ps = db.connectToDb().prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            while(rs.next()) {
                flightList.add(rs.getString("flightID"));
                flightList.add(rs.getString("destination"));
                flightList.add(rs.getString("availableDay"));
                flightList.add(rs.getTime("departTime"));
                flightList.add(rs.getInt("noOfSeats"));
                flightList.add(rs.getString("flightID"));
                flightList.add(rs.getString("flightID"));
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FlightBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {rs.close();} catch (SQLException ex) {}
            try {ps.close();} catch (SQLException e) {}
            try {db.connectToDb().close();} catch (ClassNotFoundException | SQLException e) {}
        }
        return flightList;
    }
    
    

    public boolean updateFlight(String flightID, String destination, String availableDay, Time departTime, int noOfSeats) {
        
        String sql = "UPDATE flight SET destination=?, availableDay=?, departTime=?, noOfSeats=? WHERE flightID=?";
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, destination);
            ps.setString(2, availableDay);
            ps.setTime(3, departTime);
            ps.setInt(4, noOfSeats);
            ps.setString(5, flightID);
            state = ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FlightBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {ps.close();} catch (SQLException e) {}
            try {db.connectToDb().close();} catch (ClassNotFoundException | SQLException e) {}
        }
        return state == 1;
    }

    
    
    public boolean deleteflight(String flightID) {
        
        String sql = "DELETE FROM flight WHERE flightID=?";
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, flightID);
            state = ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {ps.close();} catch (SQLException e) {}
            try {db.connectToDb().close();} catch (ClassNotFoundException | SQLException e) {}
        }
        return state == 1;
    }

    
    
    public List filterFlightByDestination(String destination) {
        
        List flightList = new ArrayList();
            
        String sql = "SELECT * FROM flight WHERE destination LIKE ?";
        
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, "%"+destination+"%");
            rs = ps.executeQuery();
            while(rs.next()) {
                flightList.add(rs.getString("flightID"));
                flightList.add(rs.getString("destination"));
                flightList.add(rs.getString("availableDay"));
                flightList.add(rs.getTime("departTime"));
                flightList.add(rs.getInt("noOfSeats"));
                flightList.add(rs.getString("flightID"));
                flightList.add(rs.getString("flightID"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FlightBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {rs.close();} catch (SQLException ex) {}
            try {ps.close();} catch (SQLException e) {}
            try {db.connectToDb().close();} catch (ClassNotFoundException | SQLException e) {}
        }
        return flightList;
    }

    
    
    public List filterFlightByAvailableDay(String availableDay) {
        
        List flightList = new ArrayList();
            
        String sql = "SELECT * FROM flight WHERE availableDay=?";
        
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, availableDay);
            rs = ps.executeQuery();
            while(rs.next()) {
                flightList.add(rs.getString("flightID"));
                flightList.add(rs.getString("destination"));
                flightList.add(rs.getString("availableDay"));
                flightList.add(rs.getTime("departTime"));
                flightList.add(rs.getInt("noOfSeats"));
                flightList.add(rs.getString("flightID"));
                flightList.add(rs.getString("flightID"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FlightBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {rs.close();} catch (SQLException ex) {}
            try {ps.close();} catch (SQLException e) {}
            try {db.connectToDb().close();} catch (ClassNotFoundException | SQLException e) {}
        }
        return flightList;
    }
    
    

    public List getFlightDestinations() {
        
        List flightDestinationsList = new ArrayList();
        
        String sql = "SELECT DISTINCT destination FROM flight"; 
        
        try {
            ps = db.connectToDb().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                flightDestinationsList.add(rs.getString("destination"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FlightBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {rs.close();} catch (SQLException ex) {}
            try {ps.close();} catch (SQLException e) {}
            try {db.connectToDb().close();} catch (ClassNotFoundException | SQLException e) {}
        }
        return flightDestinationsList;
    }

}
