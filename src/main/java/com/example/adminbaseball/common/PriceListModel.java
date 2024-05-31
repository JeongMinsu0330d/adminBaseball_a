package com.example.adminbaseball.common;

import java.lang.reflect.Array;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PriceListModel {
    private String rgSectionNo;
    private Map<String, List<Integer>> rgPrice;

    public PriceListModel() {
        this.rgPrice = new LinkedHashMap<>();
    }

    public PriceListModel(String rgSectionNo) {
        this.rgSectionNo = rgSectionNo;
    }

    public PriceListModel(String rgSectionNo, Map<String, List<Integer>> rgPrice) {
        this.rgSectionNo = rgSectionNo;
        this.rgPrice = rgPrice;
    }

    public String getRgSectionNo() {
        return rgSectionNo;
    }

    public void setRgSectionNo(String rgSectionNo) {
        this.rgSectionNo = rgSectionNo;
    }

    public Map<String, List<Integer>> getRgPrice() {
        return rgPrice;
    }

    public void setRgPrice(Map<String, List<Integer>> rgPrice) {
        this.rgPrice = rgPrice;
    }
}
