package com.hspedu.mhl.domain;

/**
 * @author 张立业
 * @version 1.0
 * 这是一个javabean 和diningTable 表对应
 *	id INT PRIMARY KEY AUTO_INCREMENT, #自增, 表示餐桌编号
 * 	state VARCHAR(20) NOT NULL DEFAULT '',#餐桌的状态
 * 	orderName VARCHAR(50) NOT NULL DEFAULT '',#预订人的名字
 * 	orderTel VARCHAR(20) NOT NULL DEFAULT ''
 */
public class DiningTable {
    private Integer id;
    private String state;
    private String orderName;
    private String orderTel;

    public DiningTable() {
    }

    public DiningTable(Integer id, String state, String orderName, String orderTel) {
        this.id = id;
        this.state = state;
        this.orderName = orderName;
        this.orderTel = orderTel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderTel() {
        return orderTel;
    }

    public void setOrderTel(String orderTel) {
        this.orderTel = orderTel;
    }

    @Override
    public String toString() {
        return id + "\t\t\t" + state;
    }
}
