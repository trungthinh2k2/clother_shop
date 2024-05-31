package vn.edu.iuh.fit.shopclother.services;

import javax.servlet.http.Cookie;

public interface CookieService {
    public String getCookie(String name);
    public Cookie add(String name, String value, int hours);
    public Cookie remove(String name);
}
