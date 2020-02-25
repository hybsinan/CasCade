package com.sinan.action;

import com.alibaba.fastjson.JSON;
import com.sinan.entity.City;
import com.sinan.sevice.CityService;
import com.sinan.sevice.serviceImpl.CityServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

public class CityAction {
    private String provinceCode;

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String showCity() {
        System.out.println(provinceCode);
        CityService cs = new CityServiceImpl();
        List<City> cities = cs.queryCity(provinceCode);
        String jsonString = JSON.toJSONString(cities);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        try {
            PrintWriter out = response.getWriter();
            out.print(jsonString);
        } catch (Exception e) {

        }
        return null;
    }
}
