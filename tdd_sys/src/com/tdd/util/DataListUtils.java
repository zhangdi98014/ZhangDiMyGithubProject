package com.tdd.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 下拉列表常用数据解释器
 * @author Administrator
 *
 */
public class DataListUtils {
    public static void main(String[] args) {
    }

    /**
    **获取登录角色列表
    */
    public static List<Map<String, Object>> getLoginTypeList() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(getMap("1", "admin"));
        list.add(getMap("3", "user"));
        list.add(getMap("2", "tz"));

        return list;
    }

    /**
    **获取tg_status数据列表
    */
    public static List<Map<String, Object>> getTgStatusList() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(getMap("1", "待审核"));
        list.add(getMap("2",
                "审核通过"));
        list.add(getMap("3",
                "审核不通过"));
        list.add(getMap("4", "未开始"));
        list.add(getMap("5", "活动中"));
        list.add(getMap("6",
                "活动已结束"));

        return list;
    }

    public static String getTgStatusNameById(String id) { //根据tg_status的key值获取名称

        List<Map<String, Object>> list = getTgStatusList();

        return getNameById(id, list);
    }

    /**
    **获取order_status数据列表
    */
    public static List<Map<String, Object>> getOrderStatusList() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(getMap("1", "待付款"));
        list.add(getMap("2", "已付款"));
        list.add(getMap("3", "已发货"));
        list.add(getMap("4",
                "已确认收货"));
        list.add(getMap("5", "已评价"));

        return list;
    }

    public static String getOrderStatusNameById(String id) { //根据order_status的key值获取名称

        List<Map<String, Object>> list = getOrderStatusList();

        return getNameById(id, list);
    }

    /**
    **获取tg_order_status数据列表
    */
    public static List<Map<String, Object>> getTgOrderStatusList() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(getMap("1", "待付款"));
        list.add(getMap("2", "已付款"));
        list.add(getMap("3", "已发货"));
        list.add(getMap("4",
                "已确认收货"));
        list.add(getMap("5", "已退款"));
        list.add(getMap("6",
                "团购成功"));
        list.add(getMap("7", "已取消"));

        return list;
    }

    public static String getTgOrderStatusNameById(String id) { //根据tg_order_status的key值获取名称

        List<Map<String, Object>> list = getTgOrderStatusList();

        return getNameById(id, list);
    }

    public static String getNameById(String id, List<Map<String, Object>> list) {
        if (id == null) {
            return null;
        }

        if (id.endsWith(",")) {
            id = id.substring(0, id.length() - 1);
        }

        String[] idsplit = id.split(",");
        String rs = "";

        for (String tmp : idsplit) {
            for (Map<String, Object> map : list) {
                if (map.get("id").toString().equals(tmp)) {
                    rs += (map.get("name").toString() + ",");
                }
            }
        }

        if (rs.endsWith(",")) {
            rs = rs.substring(0, rs.length() - 1);
        }

        return rs;
    }

    private static Map<String, Object> getMap(String id, String name) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("name", name);

        return map;
    }
}

