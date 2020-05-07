package com.ymm.fetchParams.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/test1")
    public String test1(HttpServletRequest request) {
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String param = parameterNames.nextElement();
            System.out.println(parameterNames.nextElement());
            if (StringUtils.isNotEmpty(param)) {
                System.out.println(request.getParameter(param));
            }
        }
        return "test1";
    }

    @GetMapping("/test2")
    public String test2(@RequestParam("param1") String param1, @RequestParam("param2") Long param2,
                        @RequestParam("param3") Boolean param3, HttpServletRequest request) {
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String param = parameterNames.nextElement();
            System.out.println(param);
            if (StringUtils.isNotEmpty(param)) {
                System.out.println(request.getParameter(param));
            }
        }
        return "test2";
    }

    @PostMapping("/test3")
    public String test3(@RequestParam("p1") String p1, @RequestParam("p2") Long p2, @RequestParam("p3") Boolean p3,
                        HttpServletRequest request) {
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String param = parameterNames.nextElement();
            System.out.println(param);
            if (StringUtils.isNotEmpty(param)) {
                System.out.println(request.getParameter(param));
            }
        }
        return "test3";
    }

    @PostMapping("/test4")
    public String test4(@RequestParam("p1") String p1, @RequestParam("p2") Long p2, @RequestParam("p3") Boolean p3,
                        @RequestParam("file") MultipartFile file,
                        HttpServletRequest request) {
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String param = parameterNames.nextElement();
            System.out.println(param);
            if (StringUtils.isNotEmpty(param)) {
                System.out.println(request.getParameter(param));
            }
        }
        return "test4";
    }

    @PostMapping("/test5")
    public String test5(HttpServletRequest request, @RequestBody JSONObject jsonObject) throws IOException {
        System.out.println(jsonObject.toJSONString());
        return "test5";
    }

    @PostMapping("/test6")
    public String test6(@RequestBody JSONArray jsonArray, HttpServletRequest request) {
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String param = parameterNames.nextElement();
            System.out.println(param);
            if (StringUtils.isNotEmpty(param)) {
                System.out.println(request.getParameter(param));
            }
        }
        return "test6";
    }
}
