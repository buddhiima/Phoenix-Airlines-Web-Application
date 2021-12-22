/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Buddhima
 */
public class Exceptions {
    
    // Client
    public static class accountAlreadyExists extends BaseException {
        
        public accountAlreadyExists(String message) {
            super(message);
        }
    }
    
    
    // Client
    public static class invalidCredentials extends BaseException {
    
        public invalidCredentials(String message) {
            super(message);
        }
    }
    
    
    // Ticket
    public static class noSuchTicketExists extends BaseException {
        
        public noSuchTicketExists(String message) {
            super(message);
        }
    }
    
}
