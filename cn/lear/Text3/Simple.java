package cn.lear.Text3;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @description: 泛型练习
 * @Time: 2018/8/11 17:16
 */
public class Simple<T>  implements java.lang.Iterable<T> {   //这个要继承lang包里面，才能让main方法里面的foreach可以运行
    private Object[] ele=new Object[5];     //不能使用T[] ele，因为泛型没有数组
    private int size=0;

    private int cursor=-1;  //计数器

    public int getSize() {
        return this.size;
    }

    public void add(T str){
        if(this.size==ele.length){      //容量不够需要扩容
            ele=Arrays.copyOf(ele,ele.length+5);  //扩容新方法      //
        }
        ele[size]=str;
        size++;
    }

    /***********   内部类的实现     *******************/
    class MyIterator<T>  implements Iterator {       //封装成内部类，要在类的内部实现，不然数据储存不了。且如果不封装成内部类，迭代器就初始化不了了（虽然我觉得可以用构造函数）。

        public boolean hasNext(){
            return cursor+1<size;       //小于长度
        }
        public T next(){
            Simple.this.cursor++;
            return (T)ele[cursor];      //类型强制转换
        }
        public void remove(){
            System.arraycopy(ele,cursor+1,ele,cursor,size-(cursor+1));    //将后面的值移到前面来，移动长度是 总长度减去原下标+1（原下标+1是因为数组从0开始）;
            size--;

            Simple.this.cursor--; //删除了原本的cursor也得后移，也可以直接用cursor，现在的示范另一种方式。
        }
    }
    public Iterator iterator1(){     //每当调用iterator的时候都返回一个自定义的迭代器
        return new MyIterator();
    }


    /***********   匿名内部类的实现     *******************/
    public Iterator<T> iterator2(){
        class MyIterator<T>  implements Iterator {     //因为就使用一次，可以改成匿名内部类
            public boolean hasNext(){
                return cursor+1<size;
            }
            public T next(){
                Simple.this.cursor++;
                return (T)ele[cursor];  //类型强制转换
            }
            public void remove(){
                System.arraycopy(ele,cursor+1,ele,cursor,size-(cursor+1));
                size--;

                Simple.this.cursor--;
            }
        }
        return new MyIterator();
    }


    /***********   匿名内部类的匿名内部类的实现     *******************/
    public Iterator<T> iterator(){     //最终版
        return new Iterator<T>(){          //经过上面还可以再改进成为匿名内部类，注意名字是Iterator（因为是返回值是这个类型的）.
            public boolean hasNext(){
                return cursor+1<size;
            }
            public T next(){
                Simple.this.cursor++;
                return (T)ele[cursor];      //类型强制转换
            }
            public void remove(){
                System.arraycopy(ele,cursor+1,ele,cursor,size-(cursor+1));
                size--;

                Simple.this.cursor--;
            }
        };
    }

    public static void main(String[] args){
        Simple<String> s=new Simple<>();
        s.add("ccc");
        s.add("ccc1");
        s.add("ccc2");
        s.add("ccc3");
        s.add("ccc4");
        Iterator it=s.iterator();       //将内部类带出来
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println(s.getSize());
        for (Object str :
                s) {
            System.out.println(str);
        }
    }

}
