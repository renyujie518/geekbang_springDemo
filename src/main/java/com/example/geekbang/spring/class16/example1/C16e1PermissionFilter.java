package com.example.geekbang.spring.class16.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：小心过滤器异常
 * 为了保证安全，这里需要给请求加一个保护，通过验证 Token 的方式来验证请求的合法 性。
 * 这个 Token 需要在每次发送请求的时候带在请求的 header 中，header 的 key 是 Token
 * @author: gao wei
 * @create: 2022-02-08 10:08
 */


//引入了一个 Filter 来处理这个校验工作
//通过简单的 Token：111111模拟验证      当 Token 校验失败时，就会抛出一个自定义的 NotAllowException
@WebFilter(urlPatterns = { "/c16/e1/*" })
@Component
public class C16e1PermissionFilter implements Filter {
    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String token = httpServletRequest.getHeader("token");

        /** 修正：在 doFilter 里捕获异常并交给 HandlerExceptionResolver 处理**/

        if (!"111111".equals(token)) {
            System.out.println("throw NotAllowException");
            resolver.resolveException(httpServletRequest, httpServletResponse, null, new NotAllowException());
            return;
            //throw new NotAllowException();
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }


}
