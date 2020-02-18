package cn.lear.text;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @Time: 2018/8/11 15:21
 */
public class Test01 {
    public static void main(String[] args) throws ParseException {
        Employee e=new Employee();
        e.setID(0301);
        e.setName("cqy");
        e.setDepartment("外联部");
        e.setSalary(3000);
        String  strDate="2018-8";
        DateFormat format=new SimpleDateFormat("yyyy-MM");
        Date k=format.parse(strDate);
        e.setHireDate(format.parse(strDate));



        Employee e1=new Employee(0302,"cyy",3000,"外联部","2018-8");
        Employee e2=new Employee(0303,"cqq",3500,"外联部","2018-7");

        List<Employee> list =new ArrayList<Employee>();

        list.add(e);
        list.add(e2);
        list.add(e1);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getHireDate());
        }

    }
}
