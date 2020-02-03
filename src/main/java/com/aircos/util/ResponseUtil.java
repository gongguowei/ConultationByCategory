package com.aircos.util;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 响应结果工具类
 *
 * @author 龚国玮
 */
public class ResponseUtil {
    /**
     * 使用response输出JSON
     *
     * @param response
     * @param resultMap
     */
    public static void out(HttpServletResponse response, Map<String, Object> resultMap){

        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.setStatus(Integer.parseInt(String.valueOf(resultMap.get("code"))));
            out = response.getWriter();
            out.println(JSON.toJSONString(resultMap));
        } catch (Exception e) {
        }finally{
            if(out!=null){
                out.flush();
                out.close();
            }
        }
    }

    public static Map<String, Object> resultMap(boolean flag, Integer code, String msg){

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("success", flag);
        resultMap.put("message", msg);
        resultMap.put("code", code);
        resultMap.put("timestamp", System.currentTimeMillis());
        return resultMap;
    }

    public static Map<String, Object> resultMap(boolean flag, Integer code, String msg, Object data){

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("success", flag);
        resultMap.put("message", msg);
        resultMap.put("code", code);
        resultMap.put("timestamp", System.currentTimeMillis());
        resultMap.put("data", data);
        return resultMap;
    }
}
