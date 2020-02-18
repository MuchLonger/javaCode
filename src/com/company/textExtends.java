package com.company;
public class textExtends {
    public static void main(String[] args){
        Student s=new Student();
        s.rest();
    }
}
class Person{
    String name;
    int height;
    public void rest(){
        System.out.println("休息一会");
    }
}
class Student extends Person {

}
