package VisualCalendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @description: 可视化日历程序
 * @Time: 2018/8/9 16:41
 */
public class VisualCalendar {
    public static void main(String[] args) throws ParseException {
        String temp = "2019-6-11";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");   //用以转换为时间类型
        Date date = format.parse(temp);       //转型为date对象

        Calendar cal = new GregorianCalendar();
        int maxDay = cal.getActualMaximum(Calendar.DATE);

        cal.setTime(date);          //必须是时间对象
        int day=cal.get(Calendar.DATE);

        cal.set(Calendar.DATE, 1);       //将日期变成1号
        System.out.println(cal.get(Calendar.DAY_OF_WEEK));

        System.out.println("日\t一\t二\t三\t四\t五\t六");
        for (int k = 1; k < cal.get(Calendar.DAY_OF_WEEK); k++) {
            System.out.print("\t");
        }
        for (int i = 1; i <= maxDay; i++) {
            if(i==day){
                System.out.print("*");
            }
            System.out.print(i + "\t");
            int j=cal.get(Calendar.DAY_OF_WEEK);
            if (j==7) {
                System.out.println();
            }
            cal.add(Calendar.DATE,1);
        }
    }
}
