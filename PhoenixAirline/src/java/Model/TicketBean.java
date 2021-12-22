/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.BaseException;
import Controller.Exceptions;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Buddhima
 */
public class TicketBean extends FlightBean {

    DbConnection db = new DbConnection();

    ResultSet rs = null;
    ResultSet rs1 = null;
    ResultSet rs2 = null;
    ResultSet rs3 = null;
    ResultSet rs4 = null;
    PreparedStatement ps = null;
    Connection connectToDb = null;

    //Ticket
    private String ticketNo;
    private String platform;
    private String ticketStatus;
    private Date departDate;
    private String flightClass;
    private Timestamp ticketPlacedTime;
    private float total;
    private String paymentMethod;
    private String cashier;
    private Timestamp paymentTime;
    private Timestamp refundedTime;

    private int ticketCount;
    Timestamp departTimestamp;
    Timestamp currentTimestamp;
    int ticketSearchAvailability;

    long msDiff;
    int sDiff;
    int hDiff;
    int state = 0;

    //Client
    private String clientEmail;
    private String clientName;

    /**
     * @return the ticketCount
     */
    public int getTicketCount() {
        return ticketCount;
    }

    /**
     * @param ticketCount the ticketCount to set
     */
    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    /**
     * @return the departDate
     */
    public Date getDepartDate() {
        return departDate;
    }

    /**
     * @param departDate the departDate to set
     */
    public void setDepartDate(Date departDate) {
        this.departDate = departDate;
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
     * @return the ticketNo
     */
    public String getTicketNo() {
        return ticketNo;
    }

    /**
     * @param ticketNo the ticketNo to set
     */
    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    /**
     * @return the platform
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * @param platform the platform to set
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * @return the ticketStatus
     */
    public String getTicketStatus() {
        return ticketStatus;
    }

    /**
     * @param ticketStatus the ticketStatus to set
     */
    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    /**
     * @return the flightClass
     */
    public String getFlightClass() {
        return flightClass;
    }

    /**
     * @param flightClass the flightClass to set
     */
    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    /**
     * @return the ticketPlacedTime
     */
    public Timestamp getTicketPlacedTime() {
        return ticketPlacedTime;
    }

    /**
     * @param ticketPlacedTime the ticketPlacedTime to set
     */
    public void setTicketPlacedTime(Timestamp ticketPlacedTime) {
        this.ticketPlacedTime = ticketPlacedTime;
    }

    /**
     * @return the total
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(float total) {
        this.total = total;
    }

    /**
     * @return the paymentMethod
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * @param paymentMethod the paymentMethod to set
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * @return the cashier
     */
    public String getCashier() {
        return cashier;
    }

    /**
     * @param cashier the cashier to set
     */
    public void setCashier(String flightClass) {
        this.cashier = cashier;
    }

    /**
     * @return the paymentTime
     */
    public Timestamp getPaymentTime() {
        return paymentTime;
    }

    /**
     * @param paymentTime the paymentTime to set
     */
    public void setPaymentTime(Timestamp paymentTime) {
        this.paymentTime = paymentTime;
    }

    /**
     * @return the refundedTime
     */
    public Timestamp getRefundedTime() {
        return refundedTime;
    }

    /**
     * @param refundedTime the refundedTime to set
     */
    public void setRefundedTime(Timestamp refundedTime) {
        this.refundedTime = refundedTime;
    }

    /**
     * @return the msDiff
     */
    public long getMsDiff() {
        return msDiff;
    }

    /**
     * @param msDiff the sDiff to set
     */
    public void setMsDiff(long msDiff) {
        this.msDiff = msDiff;
    }

    /**
     * @return the sDiff
     */
    public int getSDiff() {
        return sDiff;
    }

    /**
     * @param sDiff the sDiff to set
     */
    public void setSDiff(int sDiff) {
        this.sDiff = sDiff;
    }

    /**
     * @param hDiff the hDiff to set
     */
    public void setHDiff(int hDiff) {
        this.hDiff = hDiff;
    }

    /**
     * @return the hDiff
     */
    public int getHDiff() {
        return hDiff;
    }
    

    public boolean addTicket(String destination, String availableDay, Date departDate, Time departTime, String flightID, String flightClass, float total, String clientEmail, Timestamp ticketPlacedTime) {

        String sql = "INSERT INTO ticket (platform,ticketStatus,clientEmail,flightID,destination,availableDay,departTime,departDate,class,ticketPlacedTime,total) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, "Online");
            ps.setString(2, "Payment pending");
            ps.setString(3, clientEmail);
            ps.setString(4, flightID);
            ps.setString(5, destination);
            ps.setString(6, availableDay);
            ps.setTime(7, departTime);
            ps.setDate(8, departDate);
            ps.setString(9, flightClass);
            ps.setTimestamp(10, ticketPlacedTime);
            ps.setFloat(11, total);
            state = ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TicketBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
            }
            try {
                db.connectToDb().close();
            } catch (ClassNotFoundException | SQLException e) {
            }
        }
        return state == 1;
    }
    
    
    public List getTicketSearchAvailability(String ticketNo) {
        
        List ticketList = new ArrayList();
        
        String sql1 = "SELECT ticketNo FROM ticket WHERE EXISTS (SELECT ticketNo FROM ticket WHERE ticketNo=?";
        String sql2 = "SELECT * FROM ticket WHERE ticketNo=?";
        
       

        try {
            ps = db.connectToDb().prepareStatement(sql1);
            ps.setString(1, ticketNo);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                ps = db.connectToDb().prepareStatement(sql2);
                ps.setString(1, ticketNo);
                rs1 = ps.executeQuery();
            
                while (rs1.next()) {
                    ticketList.add(rs1.getString("ticketNo"));
                    ticketList.add(rs1.getString("platform"));
                    ticketList.add(rs1.getString("ticketStatus"));
                    ticketList.add(rs1.getString("clientEmail"));
                    ticketList.add(rs1.getString("flightID"));
                    ticketList.add(rs1.getString("destination"));
                    ticketList.add(rs1.getString("availableDay"));
                    ticketList.add(rs1.getTime("departTime"));
                    ticketList.add(rs1.getDate("departDate"));
                    ticketList.add(rs1.getString("class"));
                    ticketList.add(rs1.getTimestamp("ticketPlacedTime"));
                    ticketList.add(rs1.getFloat("total"));
                    ticketList.add(rs1.getString("refundStatus"));
                }
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TicketBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ticketList;
    }


    public List viewTicket(String ticketNo) throws BaseException {

        List ticketList = new ArrayList();

        String sql1 = "SELECT * FROM ticket WHERE ticketNo=?";
        
        try {
            setTicketRefundStatus(ticketNo);

            setExpiredTicketStatus(ticketNo);

            ps = db.connectToDb().prepareStatement(sql1);
            ps.setString(1, ticketNo);
            rs = ps.executeQuery();
            
                while (rs.next()) {
                    ticketList.add(rs.getString("ticketNo"));
                    ticketList.add(rs.getString("platform"));
                    ticketList.add(rs.getString("ticketStatus"));
                    ticketList.add(rs.getString("clientEmail"));
                    ticketList.add(rs.getString("flightID"));
                    ticketList.add(rs.getString("destination"));
                    ticketList.add(rs.getString("availableDay"));
                    ticketList.add(rs.getTime("departTime"));
                    ticketList.add(rs.getDate("departDate"));
                    ticketList.add(rs.getString("class"));
                    ticketList.add(rs.getTimestamp("ticketPlacedTime"));
                    ticketList.add(rs.getFloat("total"));
                    ticketList.add(rs.getString("refundStatus"));
            }
            
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TicketBean.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exceptions.noSuchTicketExists("No such ticket exists");
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
            }
            try {
                ps.close();
            } catch (SQLException e) {
            }
            try {
                db.connectToDb().close();
            } catch (ClassNotFoundException | SQLException e) {
            }
        }

        return ticketList;
    }

    public void setTicketRefundStatus(String ticketNo) {

        String sql1 = "SELECT ticketPlacedTime FROM ticket WHERE ticketNo=?";
        String sql2 = "SELECT ticketStatus FROM ticket WHERE ticketNo=?";
        String sql3 = "UPDATE ticket SET refundStatus=? WHERE ticketNo=?";

        try {
            ps = db.connectToDb().prepareStatement(sql1);
            ps.setString(1, ticketNo);
            rs1 = ps.executeQuery();
            if (rs1.next()) {
                setTicketPlacedTime(rs1.getTimestamp("ticketPlacedTime"));
            }

            ticketPlacedTime = getTicketPlacedTime();

            ps = db.connectToDb().prepareStatement(sql2);
            ps.setString(1, ticketNo);
            rs2 = ps.executeQuery();
            if (rs2.next()) {
                setTicketStatus(rs2.getString("ticketStatus"));
            }

            ticketStatus = getTicketStatus();

            // getting current Timestamp
            java.util.Date date = new java.util.Date();
            long time = date.getTime();

            currentTimestamp = new Timestamp(time);

            // getting the difference between the Timestamps in hours
            setMsDiff(currentTimestamp.getTime() - ticketPlacedTime.getTime());
            msDiff = getMsDiff();

            setSDiff((int) msDiff / 1000);
            sDiff = getSDiff();

            setHDiff(sDiff / 3600);
            hDiff = getHDiff();

            // checking the conditions
            if (hDiff < 24 && ticketStatus.equals("Payment received")) {
                ps = db.connectToDb().prepareStatement(sql3);
                ps.setString(1, "Eligible for refund");
                ps.setString(2, ticketNo);
                state = ps.executeUpdate();
            }

            if (hDiff < 24 && ticketStatus.equals("Payment pending")) {
                ps = db.connectToDb().prepareStatement(sql3);
                ps.setString(1, "Eligible to cancel. Payment not required");
                ps.setString(2, ticketNo);
                state = ps.executeUpdate();
            }

            if (hDiff > 24 && ticketStatus.equals("Payment received")) {
                ps = db.connectToDb().prepareStatement(sql3);
                ps.setString(1, "Not eligible for refund");
                ps.setString(2, ticketNo);
                state = ps.executeUpdate();
            }

            if (hDiff > 24 && ticketStatus.equals("Payment pending")) {
                ps = db.connectToDb().prepareStatement(sql3);
                ps.setString(1, "Need payment to cancel");
                ps.setString(2, ticketNo);
                state = ps.executeUpdate();
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TicketBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs1.close();
            } catch (SQLException ex) {
            }
            try {
                rs2.close();
            } catch (SQLException ex) {
            }
            try {
                ps.close();
            } catch (SQLException e) {
            }
            try {
                db.connectToDb().close();
            } catch (ClassNotFoundException | SQLException e) {
            }
        }
    }

    public void setExpiredTicketStatus(String ticketNo) {

        String sql1 = "SELECT CONCAT(departDate, ' ', departTime) AS departTimestamp FROM ticket WHERE ticketNo=?";
        String sql2 = "SELECT ticketStatus FROM ticket WHERE ticketNo=?";
        String sql3 = "UPDATE ticket SET ticketStatus=? WHERE ticketNo=?";
        String sql4 = "UPDATE ticket SET refundStatus=? WHERE ticketNo=?";

        try {
            ps = db.connectToDb().prepareStatement(sql1);
            ps.setString(1, ticketNo);
            rs1 = ps.executeQuery();

            if (rs1.next()) {

                departTimestamp = rs1.getTimestamp(1);

                // getting current Timestamp
                java.util.Date date = new java.util.Date();
                long time = date.getTime();

                currentTimestamp = new Timestamp(time);

                if (currentTimestamp.getTime() > departTimestamp.getTime()) {  

                    ps = db.connectToDb().prepareStatement(sql2);
                    ps.setString(1, ticketNo);
                    rs2 = ps.executeQuery();

                    if (rs2.next()) {
                        setTicketStatus(rs2.getString("ticketStatus"));

                        if (getTicketStatus().equals("Payment received")) {

                            ps = db.connectToDb().prepareStatement(sql3);
                            ps.setString(1, "Passenger did not board");
                            ps.setString(2, ticketNo);
                            state = ps.executeUpdate();
                        }

                        if (getTicketStatus().equals("Payment pending")) {

                            ps = db.connectToDb().prepareStatement(sql3);
                            ps.setString(1, "Expired without payment");
                            ps.setString(2, ticketNo);
                            state = ps.executeUpdate();
                        }

                        ps = db.connectToDb().prepareStatement(sql4);
                        ps.setString(1, "Not applicable for expired tickets");
                        ps.setString(2, ticketNo);
                        state = ps.executeUpdate();
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TicketBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs1.close();
            } catch (SQLException ex) {
            }
            try {
                rs2.close();
            } catch (SQLException ex) {
            }
            try {
                ps.close();
            } catch (SQLException e) {
            }
            try {
                db.connectToDb().close();
            } catch (ClassNotFoundException | SQLException e) {
            }
        }
    }
    
    
    
    
    public List viewReceipt(String ticketNo) {

        List ticketList = new ArrayList();

        String sql1 = "SELECT * FROM ticket WHERE ticketNo=?";
        String sql2 = "SELECT * FROM ticket_receipt WHERE ticketNo=?";

        try {
            ps = db.connectToDb().prepareStatement(sql1);
            ps.setString(1, ticketNo);
            rs = ps.executeQuery();
            while (rs.next()) {
                ticketList.add(rs.getString("ticketNo"));
                ticketList.add(rs.getString("platform"));
                ticketList.add(rs.getString("ticketStatus"));
                ticketList.add(rs.getString("clientEmail"));
                ticketList.add(rs.getString("flightID"));
                ticketList.add(rs.getString("destination"));
                ticketList.add(rs.getString("availableDay"));
                ticketList.add(rs.getTime("departTime"));
                ticketList.add(rs.getDate("departDate"));
                ticketList.add(rs.getString("class"));
                ticketList.add(rs.getTimestamp("ticketPlacedTime"));
                ticketList.add(rs.getFloat("total"));
            }

            ps = db.connectToDb().prepareStatement(sql2);
            ps.setString(1, ticketNo);
            rs = ps.executeQuery();
            while (rs.next()) {
                ticketList.add(rs.getString("receiptNo"));
                ticketList.add(rs.getString("paymentMethod"));
                ticketList.add(rs.getTimestamp("paymentTime"));
                ticketList.add(rs.getString("cashier"));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TicketBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
            }
            try {
                ps.close();
            } catch (SQLException e) {
            }
            try {
                db.connectToDb().close();
            } catch (ClassNotFoundException | SQLException e) {
            }
        }
        return ticketList;
    }

    public List viewRefund(String ticketNo) {

        List refundList = new ArrayList();

        String sql1 = "SELECT * FROM ticket WHERE ticketNo=?";
        String sql2 = "SELECT receiptNo, paymentTime FROM ticket_receipt WHERE ticketNo=?";
        String sql3 = "SELECT * from ticket_refund WHERE ticketNo=?";

        try {
            ps = db.connectToDb().prepareStatement(sql1);
            ps.setString(1, ticketNo);
            rs = ps.executeQuery();
            while (rs.next()) {
                refundList.add(rs.getString("ticketNo"));
                refundList.add(rs.getString("platform"));
                refundList.add(rs.getString("ticketStatus"));
                refundList.add(rs.getString("clientEmail"));
                refundList.add(rs.getString("flightID"));
                refundList.add(rs.getString("destination"));
                refundList.add(rs.getString("availableDay"));
                refundList.add(rs.getTime("departTime"));
                refundList.add(rs.getDate("departDate"));
                refundList.add(rs.getString("class"));
                refundList.add(rs.getTimestamp("ticketPlacedTime"));
                refundList.add(rs.getFloat("total"));
            }

            ps = db.connectToDb().prepareStatement(sql2);
            ps.setString(1, ticketNo);
            rs = ps.executeQuery();
            while (rs.next()) {
                refundList.add(rs.getString("receiptNo"));
                refundList.add(rs.getTimestamp("paymentTime"));
            }

            ps = db.connectToDb().prepareStatement(sql3);
            ps.setString(1, ticketNo);
            rs = ps.executeQuery();
            while (rs.next()) {
                refundList.add(rs.getString("refundVoucherNo"));
                refundList.add(rs.getTimestamp("refundedTime"));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TicketBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
            }
            try {
                ps.close();
            } catch (SQLException e) {
            }
            try {
                db.connectToDb().close();
            } catch (ClassNotFoundException | SQLException e) {
            }
        }
        return refundList;
    }
    
    

    public List getAvailableFlights(String destination, Date departDate, String availableDay) {

        List availableFlightsList = new ArrayList();
        
        String sql1 = "SELECT * FROM flight WHERE destination=? AND availableDay=?";
        String sql2 = "SELECT COUNT(ticketNo) AS ticketCount FROM ticket WHERE flightID=? AND destination=? AND availableDay=?";
        String sql3 = "SELECT flightID, destination, availableDay, departTime FROM flight WHERE flightID=? AND destination=? AND availableDay=?";
        String sql4 = "SELECT pricePerTicket FROM seat_price WHERE flightID=? AND destination=? AND availableDay=? AND class=?";
        String sql5 = "SELECT pricePerTicket FROM seat_price WHERE flightID=? AND destination=? AND availableDay=? AND class=?";

        try {

            ps = db.connectToDb().prepareStatement(sql1);
            ps.setString(1, destination);
            ps.setString(2, availableDay);
            rs = ps.executeQuery();

            while (rs.next()) {

                setFlightID(rs.getString("flightID"));
                setDestination(rs.getString("destination"));
                setAvailableDay(rs.getString("availableDay"));
                setDepartTime(rs.getTime("departTime"));
                setNoOfSeats(rs.getInt("noOfSeats"));

                ps = db.connectToDb().prepareStatement(sql2);
                ps.setString(1, getFlightID());
                ps.setString(2, getDestination());
                ps.setString(3, getAvailableDay());
                rs1 = ps.executeQuery();

                if (rs1.next()) {

                    setTicketCount(rs1.getInt(1));

                    if (getTicketCount() < getNoOfSeats()) {

                        ps = db.connectToDb().prepareStatement(sql3);
                        ps.setString(1, getFlightID());
                        ps.setString(2, getDestination());
                        ps.setString(3, getAvailableDay());
                        rs2 = ps.executeQuery();

                        // Business class
                        while (rs2.next()) {
                            
                            availableFlightsList.add(rs2.getString("flightID"));
                            availableFlightsList.add(rs2.getTime("departTime"));

                            availableFlightsList.add(rs2.getString("destination"));
                            availableFlightsList.add(rs2.getString("availableDay"));
                            availableFlightsList.add(departDate);
                            availableFlightsList.add(rs2.getTime("departTime"));
                            availableFlightsList.add(rs2.getString("flightID"));

                            ps = db.connectToDb().prepareStatement(sql4);
                            ps.setString(1, getFlightID());
                            ps.setString(2, getDestination());
                            ps.setString(3, getAvailableDay());
                            ps.setString(4, "Business");
                            rs3 = ps.executeQuery();

                            while (rs3.next()) {
                                availableFlightsList.add(rs3.getFloat("pricePerTicket"));
                                availableFlightsList.add(rs3.getString("pricePerTicket"));
                            }

                            // Economy class
                            availableFlightsList.add(rs2.getString("destination"));
                            availableFlightsList.add(rs2.getString("availableDay"));
                            availableFlightsList.add(departDate);
                            availableFlightsList.add(rs2.getTime("departTime"));
                            availableFlightsList.add(rs2.getString("flightID"));
                            ps = db.connectToDb().prepareStatement(sql5);
                            ps.setString(1, getFlightID());
                            ps.setString(2, getDestination());
                            ps.setString(3, getAvailableDay());
                            ps.setString(4, "Economy");
                            rs4 = ps.executeQuery();

                            while (rs4.next()) {
                                availableFlightsList.add(rs4.getFloat("pricePerTicket"));
                                availableFlightsList.add(rs4.getString("pricePerTicket"));
                            }
                        }
                        availableFlightsList.add("Flights are available");
                    }
                   
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FlightBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {rs.close();} catch (SQLException ex) {}
            try {ps.close();} catch (SQLException e) {}
            try {db.connectToDb().close();} catch (ClassNotFoundException | SQLException e) {}
        }
        return availableFlightsList;
    }

    
    
    public String getClientName(String clientEmail) {

        String sql = "SELECT clientName from client WHERE clientEmail=?";

        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, clientEmail);
            rs = ps.executeQuery();
            while (rs.next()) {
                clientName = rs.getString("clientName");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TicketBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
            }
            try {
                ps.close();
            } catch (SQLException e) {
            }
            try {
                db.connectToDb().close();
            } catch (ClassNotFoundException | SQLException e) {
            }
        }
        return clientName;
    }

    public String getTicketNo(String clientEmail, Timestamp ticketPlacedTime) {

        String sql = "SELECT ticketNo FROM ticket WHERE clientEmail=? AND ticketPlacedTime=?";

        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, clientEmail);
            ps.setTimestamp(2, ticketPlacedTime);
            rs = ps.executeQuery();
            while (rs.next()) {
                ticketNo = rs.getString("ticketNo");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TicketBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
            }
            try {
                ps.close();
            } catch (SQLException e) {
            }
            try {
                db.connectToDb().close();
            } catch (ClassNotFoundException | SQLException e) {
            }
        }
        return ticketNo;
    }

    public List getTicketDetails(String ticketNo) {

        List ticketDetailsList = new ArrayList();

        String sql = "SELECT platform,flightID,destination,availableDay,departTime,departDate,class,ticketPlacedTime FROM ticket WHERE ticketNo=?";

        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, ticketNo);
            rs = ps.executeQuery();
            while (rs.next()) {
                ticketDetailsList.add(rs.getString("platform"));
                ticketDetailsList.add(rs.getString("flightID"));
                ticketDetailsList.add(rs.getString("destination"));
                ticketDetailsList.add(rs.getString("availableDay"));
                ticketDetailsList.add(rs.getTime("departTime"));
                ticketDetailsList.add(rs.getDate("departDate"));
                ticketDetailsList.add(rs.getString("class"));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TicketBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
            }
            try {
                ps.close();
            } catch (SQLException e) {
            }
            try {
                db.connectToDb().close();
            } catch (ClassNotFoundException | SQLException e) {
            }
        }
        return ticketDetailsList;
    }

    public boolean addTicketPayement(String ticketNo, String paymentMethod, Timestamp paymentTime, String cashier) {

        String sql1 = "UPDATE ticket SET ticketStatus=? WHERE ticketNo=?";
        String sql2 = "INSERT INTO ticket_receipt (ticketNo, paymentMethod, paymentTime, cashier) VALUES (?,?,?,?)";

        try {
            ps = db.connectToDb().prepareStatement(sql1);
            ps.setString(1, "Payment received");
            ps.setString(2, ticketNo);
            ps.executeUpdate();

            ps = db.connectToDb().prepareStatement(sql2);
            ps.setString(1, ticketNo);
            ps.setString(2, paymentMethod);
            ps.setTimestamp(3, paymentTime);
            ps.setString(4, cashier);
            state = ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TicketBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
            }
            try {
                db.connectToDb().close();
            } catch (ClassNotFoundException | SQLException e) {
            }
        }
        return state == 1;
    }

    public boolean addRefund(String ticketNo, Timestamp refundedTime, String cashier) {

        String sql = "INSERT INTO ticket_refund (ticketNo, refundedTime, cashier) VALUES (?,?,?)";

        try {

            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, ticketNo);
            ps.setTimestamp(2, refundedTime);
            ps.setString(3, cashier);
            state = ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TicketBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
            }
            try {
                db.connectToDb().close();
            } catch (ClassNotFoundException | SQLException e) {
            }
        }

        return state == 1;
    }

    public boolean deleteTicket(String ticketNo) {

        String sql = "DELETE FROM ticket WHERE ticketNo=?";

        try {
            ps = db.connectToDb().prepareStatement(sql);
            ps.setString(1, ticketNo);
            state = ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TicketBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state == 1;
    }

    public List getClientContact(String ticketNo) {

        List clientContactList = new ArrayList();

        String sql1 = "SELECT clientEmail FROM ticket WHERE ticketNo=?";
        String sql2 = "SELECT clientName, clientEmail, clientTel, clientHouseNo, clientStreetName, clientCity, clientProvince FROM client WHERE clientEmail=?";

        try {
            ps = db.connectToDb().prepareStatement(sql1);
            ps.setString(1, ticketNo);
            rs = ps.executeQuery();

            while (rs.next()) {
                setClientEmail(rs.getString("clientEmail"));
            }

            clientEmail = getClientEmail();

            ps = db.connectToDb().prepareStatement(sql2);
            ps.setString(1, clientEmail);
            rs = ps.executeQuery();

            while (rs.next()) {
                clientContactList.add(rs.getString("clientName"));
                clientContactList.add(rs.getString("clientEmail"));
                clientContactList.add(rs.getString("clientTel"));
                clientContactList.add(rs.getString("clientHouseNo"));
                clientContactList.add(rs.getString("clientStreetName"));
                clientContactList.add(rs.getString("clientCity"));
                clientContactList.add(rs.getString("clientProvince"));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TicketBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientContactList;
    }
    
    
    
    public List getClientTickets(String clientEmail) {
        
        List clientTicketsList = new ArrayList();
        
        String sql1 = "SELECT ticketNo FROM ticket WHERE clientEmail=?";
        String sql2 = "SELECT destination, availableDay, departDate, departTime, ticketNo, ticketStatus FROM ticket WHERE clientEmail=?";
        
        try{
            
            ps = db.connectToDb().prepareStatement(sql1);
            ps.setString(1, clientEmail);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                setTicketNo(rs.getString("ticketNo"));
                ticketNo = getTicketNo();
                
                setTicketRefundStatus(ticketNo);
                setExpiredTicketStatus(ticketNo);
            }
            
            ps = db.connectToDb().prepareStatement(sql2);
            ps.setString(1, clientEmail);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                clientTicketsList.add(rs.getString("destination"));
                clientTicketsList.add(rs.getString("availableDay"));
                clientTicketsList.add(rs.getDate("departDate"));
                clientTicketsList.add(rs.getTime("departTime"));
                clientTicketsList.add(rs.getString("ticketNo"));
                clientTicketsList.add(rs.getString("ticketStatus"));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClientBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientTicketsList;
    }

}
