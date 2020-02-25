package com.sinan.sevice.serviceImpl;

import com.sinan.dao.AreaDao;
import com.sinan.entity.Area;
import com.sinan.sevice.AreaService;
import com.sinan.util.DBUtil;

import java.util.List;

public class AreaServiceImpl implements AreaService {
    @Override
    public List<Area> queryArea(String cityCode) {
        AreaDao dao = (AreaDao) DBUtil.getDao(AreaDao.class);
        List<Area> areas = dao.selectAreaByCityCode(cityCode);
        DBUtil.close();
        return areas;
    }
}
