

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
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
		
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		
		boolean checkUsername = isValidUsername(uname);
		
		
		if (checkUsername && password.equals("1234")) 
		{
			response.sendRedirect("member.jsp");
		}
		else {
			response.sendRedirect("error.jsp");
		}
		
	}
	public boolean isValidUsername(String name)
    {
  
		// Regex to check valid username.
		String regex = "^[A-Za-z]\\w{3,25}$";

		// Compile the ReGex
		Pattern p = Pattern.compile(regex);

		// If the username is empty
		// return false
		if (name == null) {
			return false;
		}

		Matcher m = p.matcher(name);

		return m.matches();
    }
}
