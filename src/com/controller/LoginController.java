package com.controller;

import com.pojo.Account;
import com.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Login.do")
public class LoginController extends HttpServlet {
	AccountService service = new AccountService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //从request中获取accountName的值，赋给accountName
    	String accountName = request.getParameter("accountName");
    	//从request中获取accountPassword的值，赋值给accountPassword
        String accountPassword = request.getParameter("accountPassword");
        
        
        Account account = service.login(accountName,accountPassword);
        if (account==null){
            response.sendRedirect("/Prevention/login.jsp?msg=no");
        }else {
            if (account.getAccountIsStop().equals("1")){
                response.sendRedirect("/Prevention/login.jsp?msg=stop");
            }else {
                HttpSession session = request.getSession();
                session.setAttribute("role",account.getAccountRole());
                session.setAttribute("username",account.getAccountName());
                response.sendRedirect("/Prevention/index.jsp");
            }//可以再写一个else判断role吗
        }

    }
}
