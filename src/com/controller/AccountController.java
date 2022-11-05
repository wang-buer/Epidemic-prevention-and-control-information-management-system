package com.controller;

import com.pojo.Account;
import com.service.AccountService;
import com.util.PageUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Account/*")
public class AccountController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opt = request.getAttribute("opt")==null ?
                "" : request.getAttribute("opt").toString();
        if (opt.equalsIgnoreCase("queryAll.do")){
            queryAll(request,response);
        }else if (opt.equalsIgnoreCase("add.do")){
            add(request,response);
        }else if (opt.equalsIgnoreCase("delete.do")){
            delete(request,response);
        }else if (opt.equalsIgnoreCase("edit.do")){
            edit(request,response);
        }else if (opt.equalsIgnoreCase("update.do")){
            update(request,response);
        }else if (opt.equalsIgnoreCase("queryKeyWords.do")){
            queryKeyWords(request,response);
        }else if (opt.equalsIgnoreCase("deletes.do")){
            deletes(request,response);
        }
    }

    private void deletes(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] saccountIDs = request.getParameterValues("chk");
        int[] accountIDs = new int[saccountIDs.length];
        for (int i = 0; i < saccountIDs.length; i++) {
            String accountID = saccountIDs[i];
            accountIDs[i] = Integer.parseInt(accountID);
        }
        boolean bln = new AccountService().deletes(accountIDs);
        response.sendRedirect("/Prevention/account/AccountList.jsp");
    }

    private void queryKeyWords(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountName = request.getParameter("accountName");
        AccountService service = new AccountService();
        List<Account> aList = service.queryKeyWords(accountName);
        PageUtil pageUtil = new PageUtil();
        int totalCount = service.getCount();
        pageUtil.setTotalCount(totalCount);
        pageUtil.setPageSize(5);
        String str_currentPageIndex = request.getParameter("currentPageIndex");
        if (str_currentPageIndex == null || "".equals(str_currentPageIndex)) {
            pageUtil.setCurrentPageIndex(0);
        }else {
            int currentPageIndex = Integer.parseInt(str_currentPageIndex);
            pageUtil.setCurrentPageIndex(currentPageIndex);
        }
        request.setAttribute("aList",aList);
        request.setAttribute("pageUtil",pageUtil);
        RequestDispatcher dis = request.getRequestDispatcher("/account/AccountList.jsp");
        dis.forward(request,response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int accountID = Integer.parseInt(request.getParameter("accountID"));
        String accountName = request.getParameter("accountName");
        String accountPassword = request.getParameter("accountPassword");
        String accountIsStop = request.getParameter("accountIsStop");
        String accountRole = request.getParameter("accountRole");
        AccountService service = new AccountService();
        Account account = new Account(accountID,accountName,accountPassword,accountIsStop,accountRole);
        Boolean bln = service.update(account);
        response.sendRedirect("/Prevention/account/AccountList.jsp");
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int accountID = Integer.parseInt(request.getParameter("accountID"));
        AccountService service = new AccountService();
        Account account = service.edit(accountID);
        request.setAttribute("account",account);
        RequestDispatcher dis = request.getRequestDispatcher("/account/AccountEdit.jsp");
        dis.forward(request,response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int accountID = Integer.parseInt(request.getParameter("accountID"));
        AccountService service = new AccountService();
        boolean bln = service.delete(accountID);
        response.sendRedirect("/Prevention/account/AccountList.jsp");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String accountName = request.getParameter("accountName");
        String accountPassword = request.getParameter("accountPassword");
        String accountIsStop = request.getParameter("accountIsStop");
        String accountRole = request.getParameter("accountRole");
        AccountService service = new AccountService();
        Account account = new Account(0,accountName,accountPassword,accountIsStop,accountRole);
        boolean bln = service.add(account);
        response.sendRedirect("/Prevention/account/AccountList.jsp");
    }

    private void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageUtil pageUtil = new PageUtil();
        AccountService service = new AccountService();
        int totalCount = service.getCount();
        pageUtil.setTotalCount(totalCount);
        pageUtil.setPageSize(5);
        String str_currentPageIndex = request.getParameter("currentPageIndex");
        if (str_currentPageIndex == null || "".equals(str_currentPageIndex)) {
            pageUtil.setCurrentPageIndex(0);
        }else {
            int currentPageIndex = Integer.parseInt(str_currentPageIndex);
            pageUtil.setCurrentPageIndex(currentPageIndex);
        }
        System.out.println(pageUtil.toString());
        List<Account> aList = service.queryAll(pageUtil);
        request.setAttribute("aList",aList);
        request.setAttribute("pageUtil",pageUtil);
        RequestDispatcher dis = request.getRequestDispatcher("/account/AccountList.jsp");
        dis.forward(request,response);
    }
}
