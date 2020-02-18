package cn.lear.Text4;

import java.util.*;

/**
 * @description:    main方法
 * @Time: 2018/8/12 10:59
 */
public class Demo1 {
    public static void main(String[] args){
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("bb");
        list.add("ab");

        Collections.sort(list);

        System.out.println(list);
    }



    public static void view(Map<String,ClassRoom> map){
        Set<String> s=map.keySet();     //因为Set有迭代器，Map没有所以转成Set,且是将所有的Key传过去
        Iterator<String> it=s.iterator();       //获取迭代器对象

        while(it.hasNext()){
            String no=it.next();
            ClassRoom room=map.get(no);

            double total=room.getTotal();
            double avg=total/room.getStuList().size();

            System.out.println(no+"班："+total+"--总分");
            System.out.println(no+"班："+avg+"----平均分");

        }

    }
    public static Map<String,ClassRoom> count(List<Student> list){
        Map<String,ClassRoom> map=new HashMap<>();
        //遍历容器
        for (Student s :
                list) {     //分拣存储
            ClassRoom room=map.get(s.getNo());  //返回的是ClassRoom对象

            if(room==null){
                room=new ClassRoom(s.getNo());  //班级加入编号
                map.put(s.getNo(),room);        //map存放班级
            }
            room.getStuList().add(s);   //放入学生
            room.setTotal(room.getTotal()+s.getScore());
        }

        return map;
    }

    public static List<Student> exam(){
        List<Student> list=new ArrayList<>();
        list.add(new Student("cqy","a",90));
        list.add(new Student("cqq","b",80));
        list.add(new Student("cyy","a",70));
        list.add(new Student("cyq","a",60));
        return list;
    }
}
