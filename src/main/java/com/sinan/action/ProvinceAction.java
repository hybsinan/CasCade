package com.sinan.action;


import com.alibaba.fastjson.JSON;
import com.sinan.entity.Province;
import com.sinan.sevice.ProvinceService;
import com.sinan.sevice.serviceImpl.ProvinceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ProvinceAction {
    public String showProvinces() {
        ProvinceService ps = new ProvinceImpl();
        List<Province> provinces = ps.queryProvinces();
        String jsonString = JSON.toJSONString(provinces);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        try {
            PrintWriter out = response.getWriter();
            out.print(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
