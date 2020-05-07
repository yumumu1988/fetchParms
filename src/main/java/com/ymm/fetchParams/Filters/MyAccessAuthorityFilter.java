package com.ymm.fetchParams.Filters;

import com.alibaba.fastjson.JSONObject;
import com.ymm.fetchParams.utils.HttpUtil;
import com.ymm.fetchParams.wrapper.RequestWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

@Component
public class MyAccessAuthorityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        RequestWrapper requestWrapper = new RequestWrapper((HttpServletRequest) request);

        String body = HttpUtil.getBodyString(requestWrapper);

        System.out.println("FILTER: " + body);

        ArrayList<String> paramList = Collections.list(request.getParameterNames());

        TreeMap<String, String> map = getMap();

        paramList.forEach(p -> {
            System.out.println(p + ": " + request.getParameter(p));
            map.put(p, request.getParameter(p));
        });

        map.forEach((k, v)->{
            System.out.println(k + "=>" + v);
        });

        if (StringUtils.isNotEmpty(body)) {
            JSONObject jsonObject = JSONObject.parseObject(body);
            System.out.println(jsonObject.toJSONString());
        }

        filterChain.doFilter(requestWrapper, servletResponse);
    }

    private static TreeMap<String, String> getMap() {
        TreeMap<String, String> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String key1, String key2) {
                return key1.compareTo(key2);
            }
        });
        return map;
    }
}
