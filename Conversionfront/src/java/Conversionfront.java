/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rishi
 */
public class Conversionfront extends HttpServlet {

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
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            String reg=request.getParameter("region");
//            out.println("<html>\n" +
//"    <head>\n" +
//"        <title>TODO supply a title</title>\n" +
//"        <meta charset=\"UTF-8\">\n" +
//"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
//"    </head>\n" +
//"    <body>\n" +
//"        <h1>From                                                   To: "+reg+"</h1>\n" +
//"         <form method=\"POST\" action=\"http://192.168.43.146:8080/Conversionback/Conversion\">\n" +
//"            AMOUNT: <input type=\"text\" name=\"amount\" > USD<input type=\"radio\" name=\"atype\" value=\"usd\"> EURO<input type=\"radio\" name=\"atype\" value=\"euro\"><br><br>\n" +
//"            VOLUME:     <input type=\"text\" name=\"volume\"><br><br>\n" +
//"                   \n" +
//"            INDIA<input type=\"radio\" name=\"region\" value=\"india\"> USA<input type=\"radio\" name=\"region\" value=\"usa\">\n" +
//"            <br><br>\n" +
//"                   \n" +
//        "<input type=\"hidden\" value="+reg+" name=\"returnValue1\">\n"+
//"            <input type=\"submit\" value=\"SUBMIT\">\n" +
//"            \n" +
//"        </form>\n" +
//"    </body>\n" +
//"</html>\n" +
//"");
//        }
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
          try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String reg=request.getParameter("region");
            out.println("<html>\n" +
"    <head>\n" +
"        <title>TODO supply a title</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
         " <style>\n"+
                    "div{\n"+
                           "box-sizing: border-box;\n"+
                           "font-size:1.5em;\n"+
                           "padding:20px;\n"+
                           "border-width:1px;\n"+
                           "border-color:black;\n"+
                           "border-style:solid;\n"+
                           "margin:10%;\n"+
          "}"+
          "</style>"+          
"    </head>\n" +
"    <body>\n" +
         "<div align=\"center\">"+           
"        <h1>From                                                   To: "+reg+"</h1>\n" +
          
"         <form method=\"POST\" action=\"http://192.168.43.146:8080/Conversionback/Conversion\">\n" +
"            AMOUNT: <input type=\"text\" name=\"amount\" >\n "+
           "<br>"+
        "<br>"+
         "USD<input type=\"radio\" name=\"atype\" value=\"usd\"> EURO<input type=\"radio\" name=\"atype\" value=\"euro\"><br><br>\n" +
"            VOLUME:     <input type=\"text\" name=\"volume\"><br><br>\n" +
"                   \n" +
"            INDIA<input type=\"radio\" name=\"region\" value=\"india\"> USA<input type=\"radio\" name=\"region\" value=\"usa\">\n" +
"            <br><br>\n" +
"                   \n" +
        "<input type=\"hidden\" value="+reg+" name=\"returnValue1\">\n"+
"            <input type=\"submit\" value=\"SUBMIT\">\n" +
"            \n" +
"        </form>\n" +
         "</div>\n"+       
"    </body>\n" +
"</html>\n" +
"");
        }
    
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
