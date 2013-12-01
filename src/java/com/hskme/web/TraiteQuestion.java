/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hskme.web;

import com.hskme.model.Questionnaire;
import com.hskme.model.Statistique;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author root
 */
public class TraiteQuestion extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String page = "question.jsp";
        int numero = (Integer)request.getSession().getAttribute("numero");
        int nb = (Integer)request.getSession().getAttribute("nb");
        String reponse = request.getParameter("reponse");
        Questionnaire questionnaire = (Questionnaire)request.getSession().getAttribute("questionnaire");
        
        //validation de la reponse  
        questionnaire.setReponse(numero, reponse);
        request.getSession().setAttribute("questionnaire", questionnaire);
        
        if(isQuestFinish(numero, nb))  {
          //fin questionnaire
          Statistique stats = new Statistique(questionnaire);
          request.setAttribute("stats", stats.calculPercentageBonReponses(stats.calculNbBonneReponses()));
          page = "results.jsp";
        } else {
          //question suivante
          request.getSession().setAttribute("numero", numero+1);
        }

        RequestDispatcher view = request.getRequestDispatcher(page);
        view.forward(request, response);
    }

    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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

    private boolean isQuestFinish(int compteur, int nb) {
        if(compteur >= nb - 1) {
                return true;
            } else { 
                return false;
        }
    }
}
