package com.shop.interceptor;

import com.alibaba.fastjson.JSON;
import com.shop.result.CodeMsg;
import com.shop.result.Result;
import com.shop.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author : WangYB
 * @time: 2020/11/10  16:19
 */
public class AddressInterceptor implements HandlerInterceptor {

    public static final Logger log = LoggerFactory.getLogger(AddressInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding( "UTF-8");
        response.setContentType( "application/json; charset=utf-8");
        String token = request.getHeader("X-Nideshop-Token");
        log.info(">>>>>>>>>>>>>>>>>>>>>" + token);
        if (token == null && token.length()==0) {
            log.info(">>>>>>>>>>>>>>");
            Result<CodeMsg> result = Result.success(CodeMsg.SESSION_ERROR);
            PrintWriter writer = response.getWriter();
            writer.write(JSON.toJSONString(result));
        }
        else if (token != null){
            Claims claims = JwtUtil.parseJWT(token);
            String subject = claims.getSubject();
            log.info(">>>>>>>>>>>>" + subject);
            if (subject != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
