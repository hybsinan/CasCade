package com.sinan.sevice.serviceImpl;

import com.sinan.dao.ProvinceDao;
import com.sinan.entity.Province;
import com.sinan.sevice.ProvinceService;
import com.sinan.util.DBUtil;

import java.util.List;

public class ProvinceImpl implements ProvinceService {
    @Override
    public List<Province> queryProvinces() {
        ProvinceDao dao = (ProvinceDao) DBUtil.getDao(ProvinceDao.class);
        List<Province> provinces = dao.selectProvinces();
        DBUtil.close();
        return provinces;
    }
}
