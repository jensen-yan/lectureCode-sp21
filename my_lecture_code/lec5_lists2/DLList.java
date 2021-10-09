
/** 双向链表 */
public class DLList<Stuff> {
    private StuffNode sentinel;   // 哨兵节点，一直存在
    private int size;


    public class StuffNode {
        public StuffNode prev;
        public Stuff item;
        public StuffNode next;

        public StuffNode(StuffNode p, Stuff i, StuffNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    /** create an empty list */
    public DLList(){
        sentinel = new StuffNode(sentinel,null, sentinel); // data 无用
        sentinel.next = sentinel.prev = sentinel;
        size = 0;
    }

    public DLList(Stuff x){
        sentinel = new StuffNode(sentinel, null, sentinel);
        sentinel.next = sentinel.prev = sentinel;

        StuffNode p = new StuffNode(sentinel, x, sentinel);
        sentinel.next = sentinel.prev = p;
        size = 1;
    }

    /** adds x to front of List */
    public void addFirst(Stuff x){
        size += 1;
        StuffNode p = new StuffNode(sentinel, x, sentinel.next);
        sentinel.next.prev = p;
        sentinel.next = p;
    }

    public void removeFirst(){
        if(sentinel.next.item == null) return;
        size -= 1;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
    }

    public Stuff getFirst(){
        return sentinel.next.item;
    }

    /** adds an item to the end of last */
    public void addLast(Stuff x){
        size += 1;

        StuffNode p = new StuffNode(sentinel.prev, x, sentinel);
        sentinel.prev.next = p;
        sentinel.prev = p;
    }

    public void removeLast(){
        if(sentinel.next.item == null) return;
        size -= 1;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
    }

    public static void main(String[] args) {
        DLList<Integer> L = new DLList<>(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);
        L.removeFirst();
        L.removeLast();
        System.out.println(L.getFirst());
        System.out.println(L.size);
    }
}
