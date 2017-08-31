package main.java.net.antra.servlet.utility;

/**
 * Created by qifu on 17/8/30.
 */

import javax.servlet.http.HttpServletRequest;

public class UserUtility {

    public static boolean validateUser(String name, String pwd, HttpServletRequest req) {
        return "admin".equalsIgnoreCase(name) && "1".equals(pwd);
    }
}
