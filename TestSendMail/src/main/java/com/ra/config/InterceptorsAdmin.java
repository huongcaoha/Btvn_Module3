//package com.ra.config;
//
//import com.ra.model.entity.User;
//import com.ra.model.entity.constant.RoleEnum;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class InterceptorsAdmin implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        User user = (User) request.getSession().getAttribute("admin");
//        if(user != null){
//            if(user.getRoles().stream().anyMatch(role -> role.getRoleName().equals(RoleEnum.ADMIN))){
//                return true;
//            }else {
//                response.sendRedirect("/error/403");
//                return false ;
//            }
//        }else {
//            response.sendRedirect("/login");
//           return false ;
//        }
//    }
//}
