/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import ws.Calculator_Service;

/**
 *
 * @author 8402-01
 */
@WebServlet(name = "calculatorServlet", urlPatterns = {"/calculatorServlet"})
public class calculatorServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/wsprovider/calculator.wsdl")
    private Calculator_Service service;

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
            out.println("<title>Servlet calculatorServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Calculator </h1>");

            out.println("<h2>Your Input Number : 523.00 and 200.00 </h2>");
            out.println("<h2>sign is +  (add) </h2>");
            out.println("<h2>Result is " + addNumber(532, 200) + " </h2>");

            out.println("<h2>-------------------------------------</h2>");
            out.println("<h2>Your Input Number : 5 and 200.00 </h2>");
            out.println("<h2>sign is /  (divide) </h2>");
            out.println("<h2>Result is " + dividenumber(5, 200) + " </h2>");

            out.println("<h2>-------------------------------------</h2>");
            out.println("<h2>Your Input Number : 5 and 50 </h2>");
            out.println("<h2>sign is *  (multiply) </h2>");
            out.println("<h2>Result is " + multiplynamber(5, 5) + " </h2>");
            out.println("<h2>-------------------------------------</h2>");
            out.println("<h2>Your Input Number : 10 and 5 </h2>");
            out.println("<h2>sign is -  (subtract) </h2>");
            out.println("<h2>Result is " + subtraNumber(10, 5) + " </h2>");
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

    private double addNumber(double a, double b) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.Calculator port = service.getCalculatorPort();
        return port.addNumber(a, b);
    }

    private double dividenumber(double a, double b) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.Calculator port = service.getCalculatorPort();
        return port.dividenumber(a, b);
    }

    private double multiplynamber(double a, double b) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.Calculator port = service.getCalculatorPort();
        return port.multiplynamber(a, b);
    }

    private double subtraNumber(double a, double b) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.Calculator port = service.getCalculatorPort();
        return port.subtraNumber(a, b);
    }

}
