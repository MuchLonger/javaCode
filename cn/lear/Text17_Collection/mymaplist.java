package cn.lear.Text17_Collection;

/**
 * @description:
 * @Time: 2018/8/11 10:27
 */
public class mymaplist {

    MyNodeList[] map = new MyNodeList[50];      //新建一个链表数组，用以储存Node对象

    int current = 0;

    //这里有疑点，super的hashcode的是根据内存地址获取一个值。所以这里的重写其实是相当于还是用回以前的hashcode方法
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public void put(Object key, Object value) {
        boolean flag;
        MyMap e = new MyMap(key, value);           //新建一个键值对
        int Code = key.hashCode() % map.length;         //让Code在0-50中选择，每个 对象（相同内存地址） 的哈希码是一样的

        if (map[Code] == null) {       //判断是否有值
            MyNodeList m = new MyNodeList();        //新建一个空Node对象
            m.add(e);               //添加到m的后面
            map[Code] = m;
            current++;          //只有为空的时候current才++

        } else {      //如果有值
                MyMap mymap = (MyMap) map[Code].get(getNodeMymap(key));
                if (mymap.key.equals(key)) {        //如果遇到重复的
                    mymap.value = value;
                }else{
                    map[Code].add(e);       //只有在上面都不成立的时候才添加进去
                }
        }

    }

    public int getNodeMymap(Object key) {           //取出位于对应的map[Code]所在的Node,里面的，对应的key的索引值
        int Code = key.hashCode() % map.length;

        for (int i = 0; i < map[Code].getLength(); i++) {
            MyMap mm = (MyMap) map[Code].get(i);
            if (mm.key.equals(key)) {
                return i;
            }
        }
        return -1;
    }


    public Object get(Object key) {
        int Code = key.hashCode() % map.length;

        if (map[Code] != null) {
            for (int i = 0; i < map[Code].getLength(); i++) {       //遍历数组内的Node元素
                MyMap mm = (MyMap) map[Code].get(i);      //强转型，取出 数组内的Node元素 链接的所有的Node作比较
                if (mm.key.equals(key)) {
                    return mm.value;
                }
            }
        } else {
            try {
                throw new Exception("找不到对应的value值");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        mymaplist mp = new mymaplist();
        mp.put(23, 45);
        mp.put(23, 44);
        mp.put(24, 46);
        System.out.println(mp.get(23));
        System.out.println(mp.current);
    }

}
