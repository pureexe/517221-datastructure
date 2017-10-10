/*
User Java built-in list instead;
 */
package week4_company;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pakkapon
 */
public class CompanyList {
    private int TotalEmployee;
    private List<Employee> EmployeeList;
    CompanyList(){
        this.TotalEmployee = 0;
        EmployeeList = new ArrayList();
    }
    public void addEmployee(Employee emp){
        this.EmployeeList.add(emp);
    }
    public Employee getEmployee(int no){
        return this.EmployeeList.get(no - 1);
    }
    public int getTotalEmployee(){
        return this.EmployeeList.size();
    }
}
