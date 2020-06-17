package javaweb.cache;

import javaweb.HttpFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "NoCacheFilter")
public class NoCacheFilter extends HttpFilter {


    @Override
    protected void ini() {

    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response,FilterChain filterChain) throws IOException, ServletException {

        System.out.println("cacheFilter's doFilter ...");

        response.setDateHeader("Expires",-1);
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("pragma","no-cache");


        filterChain.doFilter(request,response);
    }
}
