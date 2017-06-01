package controller;
import model.*;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Send
 */
@WebServlet("/send")
public class Send extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Send() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		String s1=request.getParameter("Name");
		String s2=request.getParameter("countryCode");
		String s=request.getParameter("Mobile");
		s2=s2.concat("-");
		s2=s2.concat(s);
		String s3=request.getParameter("email");
		String s4=request.getParameter("address");
		String s5=request.getParameter("desi");
		String s6=request.getParameter("Company");
		Database d=new Database();
		try{
			int sno=d.Insert(s1,s2,s3,s4,s5,s6);
			if(sno!=0)
			{request.setAttribute("ID", sno );
			RequestDispatcher rd=request.getRequestDispatcher("/Success.jsp");
			rd.forward(request, response);
			}
			else
			{
				request.setAttribute("ID", "DATABASE BUSY PLEASE TRY AGAIN LATTER" );
				RequestDispatcher rd=request.getRequestDispatcher("/Success.jsp");
				rd.forward(request, response);
			}
			
		}
		catch(Exception e)
		{   System.out.println(e);
			System.out.println("SORRYYYY");
		}
		
		
	}

}
