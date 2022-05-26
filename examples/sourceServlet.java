/*
 * SourceServlet.java
 * 
 * Copyright 2022 Rodney <>
 * 
 * 
 */

@WebServlet("/sourceServlet")
public class SourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("userName");
		
		// instantiate a session objection
		HttpSession session = request.getSession();
		
		// set an attribute that can be retrieved by the next servlet
		session.setAttribute("user", username);
		
		// create a hyperlink to go to the next servlet which will process the request
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<a href='targetServlet'>Click Here to get the UserName</a>");
	}
}

