public class Lists1Exercises {
    /** Returns an IntList identical to L, but with
      * each element incremented by x. L is not allowed
      * to change. */
    public static IntList incrList(IntList L, int x) {
        if(L == null) return L;
        L.first += x;
        L.rest = incrList(L.rest, x);
        return L;        
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x. Not allowed to use
      * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        IntList L_copy = L;
        while(L != null){
          L.first -= x;
          L = L.rest;
        }
        return L_copy;
    }

    public static void show(IntList L){
        while(L != null){
          System.out.print(L.first);
          L = L.rest;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(7, null);
        L.rest.rest = new IntList(9, null);

        System.out.println(L.get(0));
        System.out.println(L.size());
        System.out.println(L.iterativeSize());
        show(L);

        // Test your answers by uncommenting. Or copy and paste the
        // code for incrList and dincrList into IntList.java and
        // run it in the visualizer.
        System.out.println(L.get(1));
        show(dincrList(L, 3));
        show(incrList(L, 3));    
    }
}