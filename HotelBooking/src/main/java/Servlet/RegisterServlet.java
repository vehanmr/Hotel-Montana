package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EntityDB.UserAction;
import Model.UserModel;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
	
		String contact;
		String name,email,gender,password,confirmpass;
		contact=request.getParameter("Contact Number");
		name=request.getParameter("name");
		email=request.getParameter("email");
		gender=request.getParameter("gender");
		password=request.getParameter("password");
		confirmpass=request.getParameter("cpassword");
		String cat="User";
		int c=Integer.parseInt(contact);
		UserModel n=new UserModel(0,c,name,email,gender,password,cat);
		UserAction usr=new UserAction();
		if(!password.equals(confirmpass))
		{
			String msg="Successfull";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("Registration.jsp").forward(request, response);
		}
		else
		{
			if(usr.saveuser(n))
			{
				String msg="Successfull";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}	
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
