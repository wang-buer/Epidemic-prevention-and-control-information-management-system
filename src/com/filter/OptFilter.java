package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"*.do"})
public class OptFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //测试
        System.out.println("过滤器拦截过滤！！！");
        //指定拦截资源
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse rep = (HttpServletResponse)response;
        //1.得到请求路径声明一个变量
        String url = req.getRequestURL().toString();
        //2. 按照指定分隔符将字符串进行分割，返回数组
        String[] opts = url.split("/");
        //3.在数组中取最后一个元素
        String opt = opts[opts.length - 1];
        //4.将数据放入request容器中
        req.setAttribute("opt",opt);
        //设置请求编码
        req.setCharacterEncoding("utf-8");
        System.out.println("请求编码过滤器执行！！！");
        //响应编码过滤
        rep.setContentType("text/html;charset=utf-8");
        System.out.println("响应编码过滤器执行！！！");
        //放行
        chain.doFilter(req,response);
    }

    @Override
    public void destroy() {

    }
}
