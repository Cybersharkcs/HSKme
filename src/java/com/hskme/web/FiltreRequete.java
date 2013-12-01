/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hskme.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 *
 * @author root
 */
public class FiltreRequete implements Filter {
    
    private static final Logger LOGGER = Logger.getLogger(FiltreRequete.class);
    private FilterConfig fc;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.fc = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        String ip = httpReq.getRemoteAddr();
        LOGGER.info("INFO : ip " + ip);
        if(ip != null){
            fc.getServletContext().log(ip);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }


}
