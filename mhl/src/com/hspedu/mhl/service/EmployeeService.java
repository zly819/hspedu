package com.hspedu.mhl.service;

import com.hspedu.mhl.dao.EmployeeDAO;
import com.hspedu.mhl.domain.Employee;
import jdk.nashorn.internal.ir.CallNode;

/**
 * @author 张立业
 * @version 1.0
 * 业务层，该类完成对employee表的各种操作(通过调用EmployeeDAO对象完成)
 */
public class EmployeeService {

    //定义一个 Employee属性
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    //方法，根据empId 和 pwd 返回一个Employee对象
    public Employee getEmployeeByIdAndPwd(String empId, String pwd) {

       return employeeDAO.querySingle("select * from employee where empId=? and pwd=md5(?)", Employee.class, empId, pwd);

    }
}
