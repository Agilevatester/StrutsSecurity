package com.example;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.config.ModuleConfig;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListActionsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ModuleConfig moduleConfig = (ModuleConfig) getServletContext().getAttribute("org.apache.struts.action.MODULE");
        if (moduleConfig == null) {
            resp.getWriter().println("ModuleConfig is null. Ensure that Struts is properly configured and the struts-config.xml file is loaded.");
        } else {
            resp.getWriter().println("ModuleConfig loaded successfully.");
            resp.getWriter().println("Defined Actions:");
            for (org.apache.struts.config.ActionConfig config : moduleConfig.findActionConfigs()) {
                resp.getWriter().println(config.getPath());
            }
        }
    }
}