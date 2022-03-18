///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package services;
//
//import interfaces.Ipost;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Properties;
//import javafx.event.ActionEvent;
//import model.post;
//import model.user;
//import util.maConnexion;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;

//
//
//
///**
// *
// * @author ouni
// */
//
//public class ServicePost implements Ipost {
//    
//    //var
//    Connection cnx = maConnexion.getInstance().getCnx();
//
//    
//    @Override
//    public void ajouterpost(post p) {
//        if(p.getPost().contains("mauvais")|| p.getPost().contains("bonjour")|| p.getPost().contains("prix"))
//        {
//            System.out.println("votre post n'est pas accepté");}
//            else{
//
//        String request = "INSERT INTO `post`( `post`,`date_post`,`like_nbr`, `id_user`) VALUES ('"+p.getPost()+"','"+p.getDate_post()+"','"+p.getLike_nbr()+"','"+p.getId_user()+"')";
//        try {
//            Statement st = cnx.createStatement();
//            st.executeUpdate(request);
//            System.out.println("post ajoutee avec succes");
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        
//    }
//    }
//    
//        
//    public static void SendMail(String a) {
//
//       // Recipient's email ID needs to be mentioned.
//        String to = a;
//
//        // Sender's email ID neyeds to be mentioned
//        String from = "techgatepidev@gmail.com";
//
//        // Assuming you are sending email from through gmails smtp
//        String host = "smtp.gmail.com";
//
//        // Get system properties
//        Properties properties = System.getProperties();
//
//        // Setup mail server
//        properties.put("mail.smtp.host", host);
//        properties.put("mail.smtp.port", "465");
//        properties.put("mail.smtp.ssl.enable", "true");
//        properties.put("mail.smtp.auth", "true");
//
//        // Get the Session object.// and pass username and password
//        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
//
//            protected PasswordAuthentication getPasswordAuthentication() {
//
//                return new PasswordAuthentication("techgatepidev@gmail.com", "espritesprit");
//
//            }
//
//        });
//        javax.mail.Authenticator auth = new javax.mail.Authenticator() {
//
//            protected PasswordAuthentication getPasswordAuthentication() {
//
//                return new PasswordAuthentication("techgatepidev@gmail.com", "espritesprit");
//
//            }
//
//        };
//        
//
//        // Used to debug SMTP issues
//        session.setDebug(true);
//
//        try {
//            // Create a default MimeMessage object.
//            MimeMessage message = new MimeMessage(session);
//
//            // Set From: header field of the header.
//            message.setFrom(new InternetAddress(from));
//          // Set To: header field of the header.
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//            // Set Subject: header field
//            message.setSubject("TECHGATE");
//
//            // Now set the actual message
//            message.setText("RANIAWEJDEN");
//
//            System.out.println("sending...");
//            // Send message
//            Transport.send(message);
//            System.out.println("Sent message successfully....");
//        } catch (MessagingException mex) {
//            mex.printStackTrace();
//        }
//    }
//
//    
//
//  
//    @Override
//    public void SupprimerParID(int id_post){
//    try{
//    String query="DELETE FROM `post` WHERE id_post="+id_post;
//    Statement st = cnx.createStatement();
//    st.executeUpdate(query);
//        System.out.println("Done post bien supprime ");
//    }catch(SQLException e){
//        System.out.println(e.getMessage());
//    
//    }
//    
//    
//    };
//    @Override
//        public void Modifierpost (post p){
//        try{
//        
//       String query="UPDATE `post` SET `post`='"+p.getPost()+"',`date_post`='"+p.getDate_post()+"'  WHERE id_post="+p.getId_post()+"";
//        Statement st = cnx.createStatement();
//        st.executeUpdate(query);
//        System.out.println("Done post bien modifier ");
//        }catch(SQLException e){
//        System.out.println(e.getMessage());
//    
//    }     
//        }
//
//    @Override
//    public List<post> afficherpost() {
//          List<post> post = new ArrayList<>();
//        
//        String query = "SELECT * FROM post";
//        
//        try {
//            Statement st = cnx.createStatement();
//            ResultSet rs = st.executeQuery(query);
//            while (rs.next()) {                
//                post.add(new post(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5) ));
//            }
//            
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//          return post;
//    }
//    public HashMap<user,List<post>> getAllForums(){
//        
//         String req = "select * from user u inner join post p on u.id_user = p.id_user";
//        
//            HashMap<user,List<post>> map = new HashMap();
//    
//        try {
//            Statement st = cnx.createStatement();
//            ResultSet rs = st.executeQuery(req);
//        
//            
//            while (rs.next()) {
//                user u = new user(rs.getInt("id_user"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("password"),rs.getString("role"));
//                post p = new post(rs.getInt("id_post"),  rs.getString("post"),rs.getDate("date").toString());
//                    System.out.println(u);
//                if(map.containsKey(p)){
//                    List<post> list  =  map.get(u);
//                   
//                    list.add(p);
//                    
//                    map.put(u,list);
//                }
//                else{
//                     List<post> list  =  new ArrayList();
//                     list.add(p);
//                     map.put(u, list);
//                   
//                }
//                
//            }
//            
//            return map;
//            
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return map;
//
//        
//        //;
//        
//        
//        
//        
//    }
//
//
//  
//
//}
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//
