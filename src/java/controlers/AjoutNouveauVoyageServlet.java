/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.AchatBillet;
import models.ActiviteBouquet;
import models.Voyage;

/**
 *
 * @author Ny Aina Ratolo
 */
public class AjoutNouveauVoyageServlet extends HttpServlet {

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
            out.println("<title>Servlet AjoutNouveauVoyageServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AjoutNouveauVoyageServlet at " + request.getContextPath() + "</h1>");
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
        try {
            String nom = request.getParameter("nom");
            int localisation = Integer.parseInt(request.getParameter("localisation"));
            int bouquet = Integer.parseInt(request.getParameter("bouquet"));
            int duree = Integer.parseInt(request.getParameter("duree"));
            int nombre = Integer.parseInt(request.getParameter("nombre"));
            
            try {
                
                ActiviteBouquet ab = new ActiviteBouquet();
                int idB = ab.getActiviteByIdBouquet(bouquet).get(0).getIdBouquet();
                ArrayList<ActiviteBouquet> lsab = ab.getActiviteByIdBouquet(idB);
                
                AchatBillet acb = new AchatBillet();
                boolean b;
                b = acb.isBilletEnougth(lsab, nombre);
                if(b = true){
                    for (int i = 0; i < lsab.size(); i++) {
                        acb.insertEntreeBillet(lsab.get(i).getIdActivite(), (-1)*nombre*lsab.get(i).getNombre());
                    }
                    Voyage v = new Voyage();
                    v.insertVoyage(nom,localisation, bouquet, duree);
                    response.sendRedirect("NouveauVoyage.jsp");
                }
                
            } catch (Exception e) {
                request.setAttribute("exception", e);
                RequestDispatcher rqs = request.getRequestDispatcher("NouveauVoyage.jsp");
                rqs.forward(request, response);
            }
        } catch (Exception e) {
            Logger.getLogger(AjoutNouveauVoyageServlet.class.getName()).log(Level.SEVERE, null, e);
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
