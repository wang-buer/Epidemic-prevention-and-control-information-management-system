package com.controller;

import com.pojo.Community;
import com.service.CommunityService;
import com.util.PageUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Community/*")
public class CommunityController extends HttpServlet {
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
        }else if (opt.equalsIgnoreCase("deletes.do")){
            deletes(request,response);
        }else if (opt.equalsIgnoreCase("queryByKeyWords.do")){
            queryByKeyWords(request,response);
        }
    }

    private void queryByKeyWords(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cName = request.getParameter("cName");
        CommunityService service = new CommunityService();
        List<Community> list = service.queryByKeyWords(cName);
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
        request.setAttribute("list",list);
        request.setAttribute("pageUtil",pageUtil);
        RequestDispatcher dis = request.getRequestDispatcher("/community/CommunityList.jsp");
        dis.forward(request,response);
    }

    private void deletes(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] scIds = request.getParameterValues("chk");
        int[] cIds = new int[scIds.length];
        for (int i = 0; i < scIds.length; i++) {
            String cId = scIds[i];
            cIds[i] = Integer.parseInt(cId);
        }
        boolean bln = new CommunityService().deletes(cIds);
        response.sendRedirect("/Prevention/community/CommunityList.jsp?msg="+bln);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int cId = Integer.parseInt(request.getParameter("cId"));
        String cName = request.getParameter("cName");
        String province = request.getParameter("province");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String cTel = request.getParameter("cTel");
        CommunityService service = new CommunityService();
        Community community = new Community(cId,cName,province,city,street,cTel);
        boolean bln = service.update(community);
        response.sendRedirect("/Prevention/community/CommunityList.jsp?msg="+bln);
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cId = Integer.parseInt(request.getParameter("cId"));
        CommunityService service = new CommunityService();
        Community community = service.edit(cId);
        request.setAttribute("community",community);
        RequestDispatcher dis = request.getRequestDispatcher("/community/CommunityEdit.jsp");
        dis.forward(request,response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int cId = Integer.parseInt(request.getParameter("cId"));
        CommunityService service = new CommunityService();
        boolean bln = service.delete(cId);
        response.sendRedirect("/Prevention/community/CommunityList.jsp?msg="+bln);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cName = request.getParameter("cName");
        String province = request.getParameter("province");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String cTel = request.getParameter("cTel");
        CommunityService service = new CommunityService();
        Community community = new Community(0,cName,province,city,street,cTel);
        boolean bln = service.add(community);
        response.sendRedirect("/Prevention/community/CommunityList.jsp?msg="+bln);
    }

    private void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageUtil pageUtil = new PageUtil();
        CommunityService service = new CommunityService();
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
        List<Community> list = service.queryAll(pageUtil);
        request.setAttribute("list",list);
        request.setAttribute("pageUtil",pageUtil);
        RequestDispatcher dis = request.getRequestDispatcher("/community/CommunityList.jsp");
        dis.forward(request,response);
    }
}
