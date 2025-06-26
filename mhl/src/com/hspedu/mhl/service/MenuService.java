package com.hspedu.mhl.service;

import com.hspedu.mhl.dao.MenuDAO;
import com.hspedu.mhl.domain.Menu;

import java.util.List;

/**
 * @author 张立业
 * @version 1.0
 * 完成对menu表的各种操作(通过调用MenuDAO)
 */
public class MenuService {

    //定义MenuDAO 属性
    private MenuDAO menuDAO = new MenuDAO();

    //返回所有的菜品, 返回给界面使用
    public List<Menu> list() {
        return menuDAO.queryMulti("select * from menu",Menu.class);
    }
}
