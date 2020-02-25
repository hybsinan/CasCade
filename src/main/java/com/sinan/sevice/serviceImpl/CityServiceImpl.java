package com.sinan.sevice.serviceImpl;

import com.sinan.dao.CityDao;
import com.sinan.entity.City;
import com.sinan.sevice.CityService;
import com.sinan.util.DBUtil;

import java.util.List;

public class CityServiceImpl implements CityService {
    @Override
    public List<City> queryCity(String provinceCode) {
        CityDao dao = (CityDao) DBUtil.getDao(CityDao.class);
        List<City> cities = dao.selectCityByProvinceCode(provinceCode);
        DBUtil.close();
        return cities;

    }
}
