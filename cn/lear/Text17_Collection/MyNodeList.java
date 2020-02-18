package cn.lear.Text17_Collection;

/**
 * @description: 双链表的实现
 * @Time: 2018/8/10 17:58
 */
public class MyNodeList {

    private Node head;
    private Node last;

    private int current;


    public void add(Object obj) {
        if (head == null) {
            head = new Node(null, obj, null);

            last = head;
            current++;
        } else {
            Node n = new Node(last, obj, null);
            last.next = n;        //双向的连接
            last = n;         //保存最后一个的位置
            current++;
        }
    }

    public Object get(int index) {
        CheckException(index);
        if (head == null) {
            throw new ArrayStoreException("当前数组为空");
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp.Node;
        }
    }

    public Object get(Object obj){
        if (head == null) {
            throw new ArrayStoreException("当前数组为空");
        } else {
            Node temp = head;
            for (int i = 0; i < current; i++) {
                if(temp.Node==obj){
                    return i;
                }
                temp=temp.next;
            }
        }
        return null;
    }


    public Node indexOf(int index) {        //用于查询当前index在链表中的位置
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;

        }
        return temp;
    }

    public void remove(int index) {
        CheckException(index);
        Node temp = indexOf(index);

        if (temp != null) {         //分三步，检测是否是头，尾，身节点
            if (temp == head) {
                temp.next.previous = null;
                head = temp.next;
            } else if (temp == last) {
                temp.previous.next = null;
                last = temp.previous;
            } else {
                temp.previous.next = temp.next;
                temp.next.previous = temp.previous.next;
            }
        }
        current--;

    }

    public void remove(Object obj) {
        Node temp = head;
        for (int i = 0; i < current; i++) {
            if (temp.Node == obj) {
                remove(i);
            }
            temp = temp.next;
        }
        current--;
    }

    public void CheckException(int index) {     //异常检验
        if (index < 0 || index > current - 1) {
            try {
                throw new Exception("下标越界");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void insert(int index, Object obj) {
        CheckException(index);
        Node temp = indexOf(index);

        if (index == 0) {       //分三步，检测是否是头，尾，身节点
            Node n = new Node(null, obj, head);
            head.previous = n;
            head = n;
        } else if (index == current - 1) {
            add(obj);
        } else {
            Node n = new Node(temp.previous, obj, temp);
            temp.previous.next = n;
            temp.previous = n;
        }
        current++;
    }

    public void display() {
        Node k = head;
        while (k != null) {
            System.out.print(k.Node + " , ");
            k = k.next;
        }
        System.out.println();
    }

    public int getLength(){
        return current;
    }

}

class Node {
    Object Node;
    Node previous;
    Node next;

    public Node(Node previous, Object node, Node next) {
        this.Node = node;
        this.previous = previous;
        this.next = next;
    }

    public Node() {
        this(null, null, null);
    }
}

class Main {
    public static void main(String[] args) {
        MyNodeList L = new MyNodeList();
        L.add("ccc");
        L.add("bbb1");
        L.add("bbb2");
        L.add("bbb3");
        L.add("bbb4");
        System.out.println(L.get("bbb1"));
        L.display();
        L.insert(4, "kkk");
        L.display();
    }
}