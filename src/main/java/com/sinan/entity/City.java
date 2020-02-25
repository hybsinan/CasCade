package com.sinan.entity;

public class City {
    private Integer id;
    private String code;
    private String name;
    private String provinceCode;

    public City() {
    }

    public City(Integer id, String code, String name, String provinceCode) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.provinceCode = provinceCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", provinceCode='" + provinceCode + '\'' +
                '}';
    }
}
