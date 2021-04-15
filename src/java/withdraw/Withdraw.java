/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package withdraw;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author root
 */
@WebServlet(name = "Withdraw", urlPatterns = {"/Withdraw"})
public class Withdraw extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                   
            String sAmount = request.getParameter("amount");
            String nonce=request.getParameter("nonce");
            
            HttpSession session = request.getSession(false);
            
            boolean idMatches=false;
            boolean nonceMatches=false;
            
            Cookie[] cookies = request.getCookies();
            String jsessid="";
            
            if (cookies != null) 
            {
                for (Cookie cookie : cookies) 
                {
                    if (cookie.getName().equals("JSESSIONID")) 
                    {
                        jsessid=cookie.getValue();
                        if (jsessid.equals(session.getId()))
                            idMatches=true;
                    }
                }
            }
            
            if (nonce!=null && nonce.equals(session.getAttribute("nonce").toString()))
                nonceMatches=true;
            
            if (idMatches==true && nonceMatches==true && sAmount!=null && !sAmount.equals(""))
            {
                float balance = (Float)session.getAttribute("balance");
                float amount = Float.parseFloat(sAmount);
                
                balance = balance - amount;
                
                session.setAttribute("balance", new Float(balance));
                
                response.sendRedirect("mainpage.jsp?message=Withdrawal successful");
            }
            else
                response.sendRedirect("Logout");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
