//package com.project.interceptors;
//
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//
//public class RedirectOutOfContextRequests implements HandlerInterceptor {
//
//    Logger logger = LoggerFactory.getLogger(RedirectOutOfContextRequests.class);
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
////        logger.info("{} {}", request.getContextPath(), request.getRequestURL());
//
//        response.sendRedirect("/movie");
//        return false;
//
//    }
//}
