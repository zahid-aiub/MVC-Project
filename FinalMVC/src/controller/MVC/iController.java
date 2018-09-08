package controller.MVC;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.net.*;

/**
 * This interface has only one method doProcess
 * 
 * @author zahid
 * @version 1.0
 * @since 2018-05-02
 *
 */
public interface iController{
		
		public void doProcess(HttpServletRequest request,
				HttpServletResponse response,String view)throws IOException,ServletException;
		
}

