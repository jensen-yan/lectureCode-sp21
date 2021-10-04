package my_lecture_code.lec5_lists2;

/** An SLList is a list of integers, contains IntNode */
public class SLList {
    private IntNode first;  // 防止被访问修改

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
