package com.sinan.dao;

import com.sinan.entity.Area;

import java.util.List;

public interface AreaDao {
    List<Area> selectAreaByCityCode(String CityCode);
}
