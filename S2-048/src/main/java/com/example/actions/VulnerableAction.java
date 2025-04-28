package com.example.actions;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VulnerableAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userInput = request.getParameter("userInput");
        System.out.println("User input: " + userInput); // Potentially unsafe output
        request.setAttribute("message", "User input: " + userInput);
        return mapping.findForward("success");
    }
}