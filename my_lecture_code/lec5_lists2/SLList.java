package my_lecture_code.lec5_lists2;

/** An SLList is a list of integers, contains IntNode */
public class SLList {
    private IntNode first;  // 防止被访问修改
    private int size;

    // IntNode 不会使用外部类， 可以static， 节省一点内存
    private static class IntNode {  // nested class 嵌套类
        public int item;
        public IntNode next;
    
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    /** create an empty list */
    public SLList(){
        first = null;
        size = 0;
    }

    public SLList(int x){
        first = new IntNode(x, null);
        size = 1;
    }

    /** adds x to front of List */
    public void addFirst(int x){
        first = new IntNode(x, first);
        size += 1;
    }

    public int getFirst(){
        return first.item;
    }

    /** adds an item to the end of last */
    public void addLast(int x){
        size += 1;

        if(first == null){
            first = new IntNode(x, null);
            return;
        }
        
        IntNode p = first;
        while (p.next != null) {    // scan to the end
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    public static void main(String[] args) {
        SLList L = new SLList();
        // L.addFirst(10);
        // L.addFirst(5);
        L.addLast(20);
        System.out.println(L.getFirst());
        System.out.println(L.size);
    }
}
