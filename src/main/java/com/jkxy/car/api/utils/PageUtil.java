package com.jkxy.car.api.utils;

import com.jkxy.car.api.pojo.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PageUtil {



    /**
     * 循环截取某页列表进行分页
     * @param dataList 分页数据
     * @param pageSize  页面大小
     * @param currentPage   当前页面
     */
    public static List<Map<String, Object>> page(List<Map<String, Object>> dataList, int pageSize, int currentPage) {
        List<Map<String, Object>> currentPageList = new ArrayList<>();
        if (dataList != null && dataList.size() > 0) {
            int currIdx = (currentPage > 1 ? (currentPage - 1) * pageSize : 0);
            for (int i = 0; i < pageSize && i < dataList.size() - currIdx; i++) {
                Map<String, Object> data = dataList.get(currIdx + i);
                currentPageList.add(data);
            }
        }
        return currentPageList;
    }


    /**
     * 利用subList方法进行分页
     * @param list 分页数据
     * @param pagesize  页面大小
     * @param currentPage   当前页面
     */
    public static List<Car> pageBySubList(List<Car> list, int pagesize, int currentPage) {
        List<Car> subList=null;
        if(list.size()>0 && pagesize!=0 && currentPage!=0){
            int totalcount = list.size();
            int pagecount = 0;

            if(pagesize > totalcount){//页面数量大于数据总数直接返回全部数据
                return list;
            }
            else {
                int m = totalcount % pagesize;//最后的余数
                if (m > 0) {
                    pagecount = totalcount / pagesize + 1;
                } else {
                    pagecount = totalcount / pagesize;
                }
                if (m == 0) {
                    subList = list.subList((currentPage - 1) * pagesize, pagesize * (currentPage));
                } else {
                    if (currentPage == pagecount) {
                        subList = list.subList((currentPage - 1) * pagesize, totalcount);
                    } else {
                        subList = list.subList((currentPage - 1) * pagesize, pagesize * (currentPage));
                    }
                }
            }}
        return subList;
    }


}
