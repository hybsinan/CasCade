package com.sinan.action;

import com.alibaba.fastjson.JSON;
import com.sinan.entity.Area;
import com.sinan.sevice.AreaService;
import com.sinan.sevice.serviceImpl.AreaServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

public class AreaAction {
    private String cityCode;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String showArea() {
        AreaService as = new AreaServiceImpl();
        List<Area> areas = as.queryArea(cityCode);
        System.out.println(areas);
        String jsonString = JSON.toJSONString(areas);
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
