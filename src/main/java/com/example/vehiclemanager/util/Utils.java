package com.example.vehiclemanager.util;

import javax.servlet.http.HttpServletRequest;

public class Utils {

    /**
     * This function will return request URL includes query params
     *
     * @param request HttpServletRequest
     * @return String
     */
    public static String getUrl(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder(request.getRequestURL());
        String query = request.getQueryString();
        if (null != query && !query.isEmpty()) {
            sb.append("?").append(request.getQueryString());
            return sb.toString();
        }
        return sb.toString();
    }
}
