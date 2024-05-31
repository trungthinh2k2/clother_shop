package vn.edu.iuh.fit.shopclother.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.shopclother.services.CookieService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class CookieServiceImpl implements CookieService {
    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpServletResponse response;

    @Override
    public String getCookie(String name) {
         Cookie[] cookies = request.getCookies();
         if (cookies != null) {
             for (Cookie cookie : cookies) {
                 if (cookie.getName().equals(name)) {
                     return cookie.getValue();
                 }
             }
         }
        return "";
    }

    @Override
    public Cookie add(String name, String value, int hours) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(hours * 3600); // Chuyển đổi thời gian từ giờ sang giây
        cookie.setPath("/"); // Đường dẫn áp dụng cho cookie, ở đây là "/" nghĩa là áp dụng cho toàn bộ ứng dụng

        response.addCookie(cookie);
        return cookie;
    }

    @Override
    public Cookie remove(String name) {
        return null;
    }
}
