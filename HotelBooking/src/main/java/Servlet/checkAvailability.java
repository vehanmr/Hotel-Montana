package Servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.UserModel;



/**
 * Servlet implementation class checkAvailability
 */
@WebServlet("/checkAvailability")
public class checkAvailability extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkAvailability() {
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
		
		
		
		try {
			String in,out,room_type,room_no;
			String mail=request.getParameter("email");
			in=request.getParameter("in");
			out=request.getParameter("out");
			room_type=request.getParameter("type");
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			
		
			//room_no=request.getParameter("no");
			Date d=dateFormat.parse(in);
			Date d2=dateFormat.parse(out);
			in=dateFormat.format(d);
			out=dateFormat.format(d2);
			request.setAttribute("in",in);
			request.setAttribute("out",out);
			request.setAttribute("type",room_type);
			request.setAttribute("email", mail);
			//request.setAttribute("roomno",room_no);
	    	request.getRequestDispatcher("availablerooms.jsp").forward(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    
		
			
			
			
			
		
		
		
		
	}

}
