package cn.lear.Text17_Collection;

/**
 * @description: 普通顺序表的实现
 * @Time: 2018/8/10 15:37
 */
public class MyArrayList {
    private Object[] arr;

    public int getCurrent() {
        return current;
    }

    private int current=0;

    /* 默认初始化10个位置 */
    public MyArrayList(){
        this(10);
    }

    /* 创建时创建几个  */
    public MyArrayList(int initialCapacity){
        if(initialCapacity<0) {
            throw new IllegalArgumentException("下标出错");
        }
        this.arr=new Object[initialCapacity];
    }

    /* 用来扩充数组 */
    private void ensureLength(int size){
        Object[] obj=new Object[size*2+1];
        System.arraycopy(arr,0,obj,0,current);
        arr=obj;
    }

    /* 数组的最底部添加数字 */
    public void add(Object obj){
        if (current>arr.length-1){
            ensureLength(current);
        }

        this.arr[current]=obj;
        current++;
    }

    /* 是否为空 */
    public boolean isEmpty(){
        return current==0;
    }

    /* 获取对应的索引的值 */
    public Object get(int index){
        if(index<0||index>current-1){
            throw new ArrayIndexOutOfBoundsException("下标越界");
        }
        return arr[index];
    }

    /* 在相应的索引上添加值   注意：这个index是从1开始的 */
    public void insert(int index,Object obj){
        if(index<0||index>current-1){
            throw new ArrayIndexOutOfBoundsException("下标越界");
        }
        for (int i = current-1; i >=(index-1); i--) {
            arr[i+1]=arr[i];
        }
        current++;
        arr[index-1]=obj;
    }

    /* 删除相应位置的数组元素 注意：index是从1开始的 */
    public void remove(int index){
        if(index<0||index>current-1){
            throw new ArrayIndexOutOfBoundsException("下标越界");
        }
        for (int i = index-1; i <=current-1; i++) {
            arr[i]=arr[i+1];
        }
        current--;
    }

    /* 删除对应的obj元素*/
    public void remove(Object obj){
        int temp=current;
        for (int i = 0; i < temp; i++) {
            if(arr[i]==obj){
                remove(i+1);
                i--;
            }
        }
    }

    /* 删除相同的元素*/
    public void removeTheSame(){
        for (int i = 0; i < current; i++) {
            for (int j = current-1; j >i ; j--) {
                if(arr[i].equals(arr[j])){
                    remove(i+1);
                }
            }
        }

    }


    /* 显示所有的数组元素 */
    public void display(){
        System.out.print("[ ");
        for (int i = 0; i < current; i++) {
            if(i==current-1){
                System.out.print(arr[i]+" ");
            }else{
                System.out.print(arr[i]+" ,");
            }
        }
        System.out.println("]");
    }

}

