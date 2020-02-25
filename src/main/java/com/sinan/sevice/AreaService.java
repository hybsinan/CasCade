package com.sinan.sevice;


import com.sinan.entity.Area;

import java.util.List;

public interface AreaService {
    List<Area> queryArea(String cityCode);
}
