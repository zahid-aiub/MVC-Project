package devloper.MVC;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import controller.MVC.iController;

import java.util.*;
import java.net.*;

public class RegistrationController implements iController{
		 

	public void doProcess(HttpServletRequest request,HttpServletResponse response,String view)
	throws IOException,ServletException{

		RequestDispatcher rs = request.getRequestDispatcher(view);
		rs.forward(request,response);
		
	}

	public String toString() {
	    return getClass().getName();
	}	
}