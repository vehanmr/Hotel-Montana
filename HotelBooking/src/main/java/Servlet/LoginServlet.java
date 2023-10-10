package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.ConnectionPro;
import Model.UserModel;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		
		
		
		String email,password;
		email=request.getParameter("email");
		password=request.getParameter("password");
		UserModel n;
		try
		{
			Connection con=ConnectionPro.createconnection();
			PreparedStatement ps=(PreparedStatement)con.prepareStatement("select * from users where email=? and password=?  ");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				int userid=0,contact=0;
				String name="",gender="",cat="";
				userid=rs.getInt("user_id");
				contact=rs.getInt("contact_no");
				name=rs.getString("full_name");
				gender=rs.getString("gender");
				cat=rs.getString("category");
			    n=new UserModel(userid, contact, name, email, gender, password, cat);
			    
			   
			   if(cat.equals("Admin"))
			    {
			    	request.setAttribute("usermodel", n);
			    	request.getRequestDispatcher("viewFeedback.jsp").forward(request, response);
			    	System.out.println("Admin");
			    }
			    else if(cat.equals("User"))
			    {
			    	request.setAttribute("usermodel", n);
			    	request.getRequestDispatcher("user.jsp").forward(request, response);
			    	System.out.println("user");
			    }
				
			 
			}
			 if(rs.getRow()==0)
			    {
			    	String err="Username Or Password Incorrect";
			    	request.setAttribute("ErrorMsg", err);
			    	request.getRequestDispatcher("index.jsp").forward(request, response);
			    	System.out.println("Incorrect");
			    }
			
			
		}
		
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
