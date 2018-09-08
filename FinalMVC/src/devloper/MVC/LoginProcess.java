package devloper.MVC;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import controller.MVC.iController;

/**
 * This class LoginProcess implement the iController interface
 * and override the doProcess method. This class check the user
 * authentication if user is valid it dispatch
 * the request to the homepage 
 * 
 * @author zahid
 * @version 1.0
 * @since 2018-05-02
 *
 */
public class LoginProcess implements iController {

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response, String view)
			throws IOException, ServletException {
		
		System.out.println("aaaaaaaaa......");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		/**
		 * creating the obj
		 */
		LoginProcessHelper helper = new LoginProcessHelper();
		
		HttpSession session = request.getSession();
		String url = null;
			if (!email.equals("") && !password.equals("")) {
				/**
				 * check from database user is valid or not
				 * if valid set the session to identify the user
				 */
				if (helper.checkInfo(email, password) == true) {
					// ------redirect to HomePage---------
					
					session.setAttribute(email, "uname");
					session.setAttribute(password, "upass");
					
					url="homePage";
					System.out.println("Login successful...!!");
				} 
				else {
					System.out.println("Failed to login");
					url="loginView";
				}
			}
			else {
				//out.println("Please fill all sections");
				url="loginView";
				}
			if (session.getAttribute("uname") != "") {
				RequestDispatcher rd = request.getRequestDispatcher(url);
				rd.forward(request, response);
			}
			else {
				//url="loginView";
				RequestDispatcher rd = request.getRequestDispatcher(url);
				rd.forward(request, response);
			}
		
	}
		 

}
