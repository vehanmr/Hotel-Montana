package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.ConnectionPro;

/**
 * Servlet implementation class FeedBack
 */
@WebServlet("/FeedBack")
public class FeedBack extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedBack() {
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
		
		System.out.println("this hiiiii");
		 String radio=request.getParameter("view");
         String comment=request.getParameter("comments");
         String name=request.getParameter("name");
         String email=request.getParameter("email");
         String subject=request.getParameter("num");
		System.out.println("this");
		try
		{
			  Connection con=ConnectionPro.createconnection();
			   String query = "INSERT INTO `feedbacks`( `subject`, `name`, `email`, `message`, `review`) VALUES  (?,?,?,?,?)";
	           
	           PreparedStatement pt = con.prepareStatement(query);
	           pt.setString(1, subject);
	           pt.setString(2, name);
	           pt.setString(3,email);
	           pt.setString(4, comment);
	           pt.setString(5, radio);
	           pt.executeUpdate();
	           
	            String msg="Successfully Sent !!!";
		    	request.setAttribute("sent", msg);
		    	request.getRequestDispatcher("contact.jsp").forward(request, response);
			
		}
		catch(Exception ex)
		{
			
			System.out.println(ex);
			
		}
		
		
		
	}

}
