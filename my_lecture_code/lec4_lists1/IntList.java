package my_lecture_code.lec4_lists1;

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r){
        first = f;
        rest = r;
    }

    public int size(){

        if(rest == null) return 1;
        return 1 + this.rest.size();
    }

    public int iterativeSize(){
        IntList p = this;
        int sz = 0;
        while (p != null) {
            sz += 1;
            p = p.rest;
        }
        return sz;
    }

    /** get the index i element of IntList */
    public int get(int i){
        IntList p = this;
        for (int j = 0; j < i; j++) {
            p = p.rest;
        }
        return p.first;
    }

    public int getRercursive(int i){
        if(i == 0) return first;
        return rest.getRercursive(i-1);
    }

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);

        System.out.println(L.size());
        System.out.println(L.getRercursive(2));

    }
}
