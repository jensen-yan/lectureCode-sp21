
/** An SLList is a list of integers, contains IntNode */
public class SLList<Stuff> {
    private StuffNode sentinel;   // 哨兵节点，一直存在
    private int size;

    // IntNode 不会使用外部类， 可以static， 节省一点内存
    public class StuffNode {  // nested class 嵌套类
        public Stuff item;
        public StuffNode next;
    
        public StuffNode(Stuff i, StuffNode n) {
            item = i;
            next = n;
        }
    }

    /** create an empty list */
    public SLList(){
        sentinel = new StuffNode(null, null); // data 无用
        size = 0;
    }

    public SLList(Stuff x){
        sentinel = new StuffNode(null, null);
        sentinel.next = new StuffNode(x, null);
        size = 1;
    }

    /** adds x to front of List */
    public void addFirst(Stuff x){
        size += 1;
        sentinel.next = new StuffNode(x, sentinel.next);
    }

    public Stuff getFirst(){
        return sentinel.next.item;
    }

    /** adds an item to the end of last */
    public void addLast(Stuff x){
        size += 1;

        StuffNode p = sentinel;
        while (p.next != null) {    // scan to the end
            p = p.next;
        }
        p.next = new StuffNode(x, null);
    }

    public static void main(String[] args) {
        SLList<Integer> L = new SLList<>(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);
        System.out.println(L.getFirst());
        System.out.println(L.size);
    }
}
