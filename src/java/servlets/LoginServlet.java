package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;


public class LoginServlet extends HttpServlet {
    
    @Override
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        
        if (request.getParameterMap().containsKey("logout")){
            
            String logout = "You have successfully logged out.";
            request.setAttribute("message", logout);
            session.setAttribute("user", null);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            
        }else if (user != null){
            
            response.sendRedirect("home");
            
        }else{
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            
        }
    }

    @Override
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        AccountService accountService = new AccountService();
        User user = accountService.login(username, password);
        session.setAttribute("user", user);
        
        if (user == null){
            
            request.setAttribute("message", "Incorrect username and password.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            
        }else{
            
            response.sendRedirect("home");
            
        }
    }
}
