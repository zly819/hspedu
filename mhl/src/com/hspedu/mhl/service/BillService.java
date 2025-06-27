package com.hspedu.mhl.service;

import com.hspedu.mhl.dao.BasicDAO;
import com.hspedu.mhl.dao.BillDAO;

import java.util.UUID;

/**
 * @author 张立业
 * @version 1.0
 * 处理和账单相关的业务逻辑
 */
public class BillService {
    //定义一个BillDAO属性
    private BillDAO billDAO = new BillDAO();
    //定义 MenuService 属性
    private MenuService menuService = new MenuService();
    //定义DiningTableService属性
    private DiningTableService diningTableService = new DiningTableService();
    //思考
    //编写点餐的方法
    //1. 生成账单
    //2. 需要更新对应餐桌的状态
    //3. 如果成功返回true, 否则返回false
    public boolean orderMenu(int menuId, int nums, int diningTableId){
        //生成一个账单号,UUID
        String billID = UUID.randomUUID().toString();

        //将账单生成到bill表, 要求直接计算账单金额
        int update = billDAO.update("insert into bill values(null,?,?,?,?,?,now(),'未结账')",
                billID, menuId, nums, menuService.getMenuById(menuId).getPrice() * nums, diningTableId);
        if (update <= 0){
            return false;
        }

        //需要更新对应餐桌的状态
        return diningTableService.updateDiningTableState(diningTableId, "就餐中");

    }
}
