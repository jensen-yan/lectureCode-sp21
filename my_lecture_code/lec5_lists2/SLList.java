package my_lecture_code.lec5_lists2;

/** An SLList is a list of integers, contains IntNode */
public class SLList {
    private IntNode first;  // 防止被访问修改

    // IntNode 不会使用外部类， 可以static， 节省一点内存
    private static class IntNode {  // nested class 嵌套类
        public int item;
        public IntNode next;
    
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    public SLList(int x){
        first = new IntNode(x, null);
    }

    /** adds x to front of List */
    public void addFirst(int x){
        first = new IntNode(x, first);
    }

    public int getFirst(){
        return first.item;
    }

    public static void main(String[] args) {
        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        System.out.println(L.getFirst());
    }
}
