/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hskme.web;

import com.hskme.model.Dictionnaire;
import com.hskme.model.Questionnaire;
import com.hskme.model.Statistique;
import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

/**
 *
 * @author root
 */
public class CommenceTest extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(CommenceTest.class);
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
        
        //Recupere les parametres de la requete
        String niveau = request.getParameter("hsk");
        String nb = request.getParameter("nb");
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        
        //à mettre dans un filtre
        BasicConfigurator.configure();
    	LOGGER.info("INFO : from " + from + " , to : " + to);

        //creation des objets dictionnaire et questionnaire pour 
        int nbquest = Integer.parseInt(nb);
        Dictionnaire dico = new Dictionnaire();
        if(niveau.equals("2")) dico.loadVocab(new File(getServletContext().getRealPath("/WEB-INF/dico/hsk2")));
        else if(niveau.equals("3")) dico.loadVocab(new File(getServletContext().getRealPath("/WEB-INF/dico/hsk3")));
        Questionnaire quest = new Questionnaire();
        quest.setQuestion(nbquest, dico, from, to);
        
        //definition des attributs de la session d'un utilisateur quelquonque
        request.getSession().setAttribute("questionList", quest.getSerie());
        request.getSession().setAttribute("questionnaire", quest);
        request.getSession().setAttribute("dictionnaire", dico);
        request.getSession().setAttribute("nb", nbquest);
        request.getSession().setAttribute("from", from);
        request.getSession().setAttribute("to", to);
        request.getSession().setAttribute("numero", Integer.valueOf(0));

        //debut du test
        RequestDispatcher view = request.getRequestDispatcher("question.jsp");
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
}