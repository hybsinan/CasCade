package com.sinan.dao;

import com.sinan.entity.City;

import java.util.List;

public interface CityDao {
    List<City> selectCityByProvinceCode(String provincecode);
}
