package com.sinan.sevice;

import com.sinan.entity.City;

import java.util.List;

public interface CityService {
    List<City> queryCity(String provinceCode);


}
