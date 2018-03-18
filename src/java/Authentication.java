/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Priyanka
 */
@WebServlet(urlPatterns = {"/Authentication"})
public class Authentication extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Authentication</title>");            
            out.println("</head>");
            out.println("<body>");
            String userName = (String)request.getAttribute("UName");
            String userPassword=(String)request.getAttribute("UPassword");
            String token = null;
            String region = null;
             try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull", "root", "");
                con.setAutoCommit(false);
                Statement st = con.createStatement(); 
                
                String username=request.getParameter("userName");
                out.println(username);
                String userpassword=request.getParameter("userPassword");
                
                ResultSet rs = st.executeQuery("SELECT  * FROM info WHERE name ='"+username+"'");
                String site="http://localhost:8080/ConvertionTool/Login";
                
                if(rs.next()){
                    if(userpassword.equals(rs.getString(2)))
                    {
                        site=site+"?token=true";
                       site+="&region="+rs.getString("region");
                    } 
                    site=site+"?token=false";
                }
                else{
                    site=site+"?token=false";
                }
                System.out.println("site=="+site);
                response.sendRedirect(site);
//                while(rs.next()) {
//                    String s=rs.getString(2);
//                    if(s.equals(userPassword)){
//                          token="true";
//                           region = rs.getString("region"); 
//                          
//                    }
//                    else{
//                        token="false";  
//                        String site="http://localhost:8080/ConvertionTool/";
//                       site=site+"?token='false'";
//                       response.setStatus(response.SC_MOVED_TEMPORARILY);
//                       response.setHeader("Location",site);
//                    }
//                }
//                        
//                        request.setAttribute("Atoken",token);
//                        request.setAttribute("Region",region);
//                        //System.out.println(token);
//                        RequestDispatcher rd = request.getRequestDispatcher("/Login");  
//                        rd.forward(request, response);
//                con.close();
            } catch (ClassNotFoundException ex) {
                out.println("<h1>ClassNotFoundException</h1>");
            } catch (SQLException ex) {
                out.println("<h1>SQLException</h1>");
            }
            out.println("</body>");
            out.println("</html>");
        }
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
