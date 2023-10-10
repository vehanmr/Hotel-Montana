package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.mail.Session;

import DB.ConnectionPro;

/**
 * Servlet implementation class BookNow
 */
@WebServlet("/BookNow")
public class BookNow extends HttpServlet  {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookNow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		try
		{
		book b1;
			
			String in=request.getParameter("in");
			String out=request.getParameter("out");
			String id=request.getParameter("r_id");
			String price=request.getParameter("r_price");
			String roomt=request.getParameter("r_t");
			String c=request.getParameter("count");
			int count=Integer.parseInt(c);
			   SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
			   Date d= formatter.parse(out);
			   Date d2=formatter.parse(in);
			   long diff=(d.getDate()-d2.getDate());
			   String sdiff=Long.toString(diff);
			   System.out.println(sdiff);
		       int dates= Integer.parseInt(sdiff);
		       int finalprice=dates*Integer.parseInt(price);
			//Thread 
	         b1=new book(count, 1);
	         b1.reserve(count, 1);//reserve
	         b1.run();//run thread
	         String msg=b1.getmsg();
		       
		       //Send email
		     
               String host = "smtp.gmail.com";
               String user = "kelsolankaproject@gmail.com";
               String pass = "finalproject";
               String to = request.getParameter("email");
               System.out.println(to);
		       // your host email smtp server details
	            Properties pr = new Properties();
	            pr.setProperty("mail.smtp.host", "smtp.gmail.com");
	            pr.setProperty("mail.smtp.port", "587");
	            pr.setProperty("mail.smtp.auth", "true");
	            pr.setProperty("mail.smtp.starttls.enable", "true");
	            pr.put("mail.smtp.socketFactory.port", "587");
	            pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	 
	            //get session to authenticate the host email address and password
	            Session session = Session.getInstance(pr, new Authenticator() {
	                @Override
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(user, pass);
	                }
	            });

	            //set email message details
	            Message mess = new MimeMessage(session);

	    		//set from email address
	            mess.setFrom(new InternetAddress(user));
	    		//set to email address or destination email address
	            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
	    		
	    		//set email subject
	            mess.setSubject("Thank You For Choosing Us!!(Montana Group)");
	            
	    		//set message text
	            mess.setText("You Sucessfully Booked a Room \n"+"Room Type : "+roomt+"\n"+"In Date: "+in+"\n"+"Out Date: "+out+"\n"+"Room Price: "+finalprice+" LKR"+"");
	            //send the message
	            Transport.send(mess);
	            
	            //end of send email
			       
	            request.setAttribute("room_type",roomt);
		    	request.setAttribute("finalprice",Integer.toString(finalprice));
		    	request.setAttribute("days", Integer.toString(dates));
		    	request.setAttribute("msg", msg);
		    	
		    	request.getRequestDispatcher("Payment.jsp").forward(request, response);
		    	  Connection con=ConnectionPro.createconnection();
				   String query = "INSERT INTO `room_book`( `checkin`, `checkout`, `room_id`) VALUES ('"+in+"','"+out+"','"+id+"')";
		           
		           PreparedStatement pt = con.prepareStatement(query);
		           pt.executeUpdate();
		           System.out.println(roomt);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

               
               
             
			
		}
		
		
	

}
