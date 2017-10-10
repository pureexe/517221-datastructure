/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4_company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pakkapon
 */
public class CompanyApp {
    public static String INPUT_FILE = "./src/week4_company/input.txt";
    public static String OUTPUT_FILE = "./src/week4_company/output.txt";
    public static Employee EmployeeBuilder(String rawData)
    {
        String[] data = rawData.split(":");
        return new Employee(
                data[0],
                data[1].toCharArray()[0],
                Integer.parseInt(data[2]),
                Double.parseDouble(data[3]),
                Double.parseDouble(data[4]),
                data[5].equals("S"),
                Double.parseDouble(data[6]),
                Integer.parseInt(data[7])
        );
    }
    public static void printBySex(Company company,char sex){
        int i;
        Employee employee;
        for(i = 0; i < company.getTotalEmployee(); i++){
            employee = company.getEmployee(i+1);
            if(employee.getSex() == sex){
                System.out.printf("%s (%d) %.2f\n",
                        employee.getName(),
                        employee.getAge(),
                        employee.getSaraly()
                );
            }
        }        
    }
    public static void main(String[] args) throws FileNotFoundException{
        Company company = new Company(500);
        Scanner file = new Scanner(new FileReader(INPUT_FILE));
        String line;
        while(file.hasNext() && !(line = file.next()).equals("$$$") ){
            if(line.charAt(0) == '!'){
                continue;
            }
            company.addEmployee(EmployeeBuilder(line));
        }
        Employee employee;
        int i;
        System.out.println("== Female Employee ==");
        printBySex(company,'F');
        System.out.println("== Male Employee ==");
        printBySex(company,'M');
        try {
            PrintWriter writer = new PrintWriter(OUTPUT_FILE, "UTF-8");
             for(i = 0; i < company.getTotalEmployee(); i++){
                employee = company.getEmployee(i+1);
                if(employee.getAge() <= 30 
                        && employee.isSingle()
                        && employee.getBodyState() == 1 
                        && employee.getSex() == 'F' ){
                        employee.setSalary(employee.getSaraly()*105.0/100);
                }
                employee.setWorkLength(employee.getWorkLength()+1);
                writer.println(""
                        + employee.getName()
                        + ":"
                        + employee.getSex()
                        + ":"
                        + employee.getAge()
                        + ":"
                        + employee.getHeight()
                        + ":"
                        + employee.getWeight()
                        + ":"
                        + (employee.isSingle()?'S':'M')
                        + ":"
                        + employee.getSaraly()
                        + ":"
                        + employee.getWorkLength()
                );
            }
            writer.println("$$$");
            writer.close();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CompanyApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
