package com.hspedu.mhl.view;

import com.hspedu.mhl.domain.DiningTable;
import com.hspedu.mhl.domain.Employee;
import com.hspedu.mhl.service.DiningTableService;
import com.hspedu.mhl.service.EmployeeService;
import com.hspedu.mhl.utils.Utility;

import java.util.List;

/**
 * @author 张立业
 * @version 1.0
 * 这是主界面
 */
public class MHLView {

    //控制是否退出菜单
    private boolean loop = true;
    //接收用户的选择
    private String key = "";
    //定义EmployeeService 属性
    private EmployeeService employeeService = new EmployeeService();
    //定义一个DiningTable 属性
    private DiningTableService diningTableService = new DiningTableService();

    public static void main(String[] args) {
        new MHLView().mainMenu();
    }

    //完成订座
    public void orderDiningTable(){
        System.out.println("===============预定餐桌================");
        System.out.print("请选择要预定的餐桌编号(-1退出):");
        int orderId = Utility.readInt();
        if(orderId == -1){
            System.out.println("===============取消预定餐桌================");
            return;
        }
        //该方法得到的是 Y 或者 N
        char key = Utility.readConfirmSelection();
        if (key == 'Y'){//要预定

            //根据orderId 返回 对应DiningTable对象, 如果为null, 说明该对象不存在
            DiningTable diningTable = diningTableService.getDiningTableById(orderId);
            if(diningTable == null){
                System.out.println("==============预订餐桌不存在============");
                return;
            }
            //判断该餐桌的状态是否 "空"
            if (!("空".equals(diningTable.getState()))){//说明当前这个餐桌不是 "空" 状态
                System.out.println("==============该餐桌已经预定或者就餐中============");
                return;
            }

            //接收预定信息
            System.out.print("预定人的名字: ");
            String orderName = Utility.readString(50);
            System.out.print("预定人的电话: ");
            String orderTel = Utility.readString(50);

            //更新餐桌状态
            if (diningTableService.orderDiningTable(orderId, orderName, orderTel)){
                System.out.println("==============预订餐桌成功============");
            }else {
                System.out.println("==============预订餐桌失败============");
            }
        }else {
            System.out.println("===============取消预定餐桌================");
        }
    }

    //显示所有餐桌状态
    public void listDiningTable(){
        List<DiningTable> list = diningTableService.list();
        System.out.println("\n餐桌编号\t\t餐桌状态");
        for (DiningTable diningTable : list) {
            System.out.println(diningTable);
        }
        System.out.println("===============显示完毕================");
    }
    //显示主菜单
    public void mainMenu() {

        while (loop) {
            System.out.println("\n===============满汉楼================");
            System.out.println("\t\t 1 登录满汉楼");
            System.out.println("\t\t 2 退出满汉楼");
            System.out.print("请输入你的选择: ");
            key = Utility.readString(1);
            switch (key){
                case "1":
                    System.out.print("输入员工号: ");
                    String empid = Utility.readString(50);
                    System.out.print("输入密 码: ");
                    String pwd = Utility.readString(50);
                    Employee employee = employeeService.getEmployeeByIdAndPwd(empid, pwd);
                    if (employee != null) {//说明存在该用户
                        System.out.println("===============登录成功["+employee.getName()+"]================");
                        //显示二级菜单, 这里二级菜单是循环操作，所以做成while
                        while (loop) {
                            System.out.println("\n===============满汉楼(二级菜单)================");
                            System.out.println("\t\t 1 显示餐桌状态");
                            System.out.println("\t\t 2 预定餐桌");
                            System.out.println("\t\t 3 显示所有菜品");
                            System.out.println("\t\t 4 点餐服务");
                            System.out.println("\t\t 5 查看账单");
                            System.out.println("\t\t 6 结账");
                            System.out.println("\t\t 9 退出满汉楼");
                            System.out.print("请输入你的选择: ");
                            key = Utility.readString(1);
                            switch (key){
                                case "1":
                                    listDiningTable();//显示餐桌状态
                                    break;
                                case "2":
                                    orderDiningTable();
                                    break;
                                case "3":
                                    System.out.println("显示所有菜品");
                                    break;
                                case "4":
                                    System.out.println("点餐服务");
                                    break;
                                case "5":
                                    System.out.println("查看账单");
                                    break;
                                case "6":
                                    System.out.println("结账");
                                    break;
                                case "9":
                                    loop = false;
                                    break;
                                default:
                                    System.out.println("你的输入有误，请重新输入");
                                    break;
                            }
                        }

                    }else {
                        System.out.println("===============登陆失败================");
                    }
                    break;
                case "2":
                    loop = false;
                    break;
                default:
                    System.out.println("你输入有误，请重新输入！");
            }
        }
        System.out.println("你退出了满汉楼系统");
    }
}
