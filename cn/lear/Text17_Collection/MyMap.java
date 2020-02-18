package cn.lear.Text17_Collection;

/**
 * @description: 实现map的简易功能
 * @Time: 2018/8/10 21:51
 */
public class MyMap {
    Object key;
    Object value;

    public MyMap(Object key, Object value) {
        this.key = key;
        this.value = value;
    }


}

class MyMapList {
        MyMap[] map=new MyMap[10];

        int current=0;

        public void put(Object key, Object value){
            if(containKey(key)){
              map[IndexOf(key)].value=value;
            }
            MyMap m=new MyMap(key,value);
            map[current]=m;
            current++;
        }

        public int IndexOf(Object key) {            //获取对应的key的真实索引下标。
            for (int i = 0; i < current; i++) {
                if(map[i].key.equals(key)){
                    return i;
                }
            }
            return 0;
        }


        public Object get(Object key){
            for (MyMap m:
                 map) {             //遍历数组
                if(m.key.equals(key)){          //一般都用equals方法
                    return m.value;
                }
            }
            return null;        //如果没找到返回null
        }

        public void remove(Object key){
//            for (int i = 0; i < current; i++) {
//                int remain=current-i-1;
//                MyMap[] m=new MyMap[10];
//                System.arraycopy(map,,m,0,current);
//                map=m;
//            }
            for (int i = 0; i < current; i++) {
                if(map[i].key.equals(key)){
                    for (int j = i; j < current; j++) {
                        map[i]=map[i+1];
                    }
                }
            }
            current--;
        }


        public boolean containKey(Object key){
            for (int i = 0; i <current ; i++) {
                if (map[i].key.equals(key)) {
                    return true;
                }
            }

            return false;
        }
    public boolean containValue(Object value){
        for (int i = 0; i < current; i++) {
            if (map[i].value.equals(value)){
                return true;
            }
        }
        return false;
    }


        public static void main(String[] args){
            MyMapList ml=new MyMapList();
            ml.put(111,new Wife("陈麒涌"));        //装包
            ml.put(222,444);
            ml.put(222,4434);

//            System.out.println(ml.containKey(1222));
//            System.out.println(ml.get(222));
//
//            Wife k=(Wife)ml.get(111);
//            System.out.println(ml.current);
//            System.out.println(k.value);
            String a="hello";
            String b="hel"+new String("lo");
            System.out.println("=="+a==b);
            System.out.println("equals"+a.equals(b));
        }
}
class Wife{
    Object value;
    public Wife(Object value){
        this.value=value;
    }
}