package com.gojavaonline3.dlenchuk.ee.module08;

import javax.servlet.*;
import java.io.IOException;

public class LogInitFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
        System.out.println("    >> LogInitFilter - init");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        long inTime = System.nanoTime();
        chain.doFilter(request, response);
        long outTime = System.nanoTime();
        System.out.println("    >> LogInitFilter: dT = " + (outTime - inTime));
        System.out.println();
    }

    public void destroy() {
        System.out.println("    >> LogInitFilter - destroy");
    }

}
