import java.util.*;

public class ArraySet<T> implements Iterable<T>{
    private T[] items; 
    private int size;
    public ArraySet() {
        items = (T[])new Object[20];
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for (int i = 0; i < size; i++) {
            if (items[i] == null)
                if (x == null)
                    return true;
            if(x.equals(items[i]))
                return true;
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map. 
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if (x == null)
            throw new IllegalArgumentException("You can't add null to ArraySet");
        if (this.contains(x))
            return;
        items[size] = x;
        size++;
    }


    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int pos = 0;

            @Override
            public boolean hasNext() {
                return pos < size;
            }

            @Override
            public T next() {
                T val = items[pos];
                pos++;
                return val;
            }
        };
    }

    /*@Override
    public String toString(){
        StringBuilder out = new StringBuilder("[");
        for (int i = 0; i < size-1; i++) {
            out.append(items[i].toString());
            out.append(", ");
        }
        out.append(items[size - 1].toString());
        out.append(']');
        return out.toString();
    }*/

    @Override
    public String toString(){
        List<String> listOfItems = new ArrayList<>();
        for (T item: this){
            listOfItems.add(item.toString());
        }
        return "[" + String.join(", ", listOfItems) + "]";
//        String out;
//        for (T item : this) {
//            out = String.join(", ", (CharSequence) item);
//        }
//       out = String.join(", ", "java", "is", "cool");
//        return out;
    }

    @Override
    public boolean equals(Object other){
        if (other == this) return true;
        if (other == null)  return false;
        if (other.getClass() != this.getClass()) return false;
        ArraySet<T> otherSet = (ArraySet<T>)other;
        if (size != otherSet.size())
            return false;
        // 不一定是相同顺序插入的！
        for (T item : this){
            if(!otherSet.contains(item))
                return false;
        }
        return true;
    }

    public static <T> ArraySet<T> of(T... items){
        ArraySet<T> set = new ArraySet<>();
        for (T item: items){
            set.add(item);
        }
        return set;
    }

    public static void main(String[] args) {
//        ArraySet<Integer> set11 = ArraySet.of(2,3,4,5);
//        System.out.println(set11);

        ArraySet<String> arraySet = new ArraySet<>();
//        arraySet.add(null);
        arraySet.add("horse");
        arraySet.add("fish");
        arraySet.add("house");
        arraySet.add("fish");
        System.out.println(arraySet.contains("fish"));

        ArraySet<String> arraySet2 = new ArraySet<>();
        arraySet2.add("horse");
        arraySet2.add("house");
        arraySet2.add("fish");

//        System.out.println(arraySet.equals(arraySet2));
//        System.out.println(arraySet.equals("saf"));
//        System.out.println(s.contains("horse"));
//        System.out.println(s.size());
//        Iterator<String> iterator1 = arraySet.iterator();
//        while (iterator1.hasNext()){
//            System.out.println(iterator1.next());
//        }
//        for (String c : arraySet) {
//            System.out.println(c);
//        }
//        System.out.println(arraySet);

        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(3);
        set.add(4);
//        for (int i : set){
//            System.out.println(i);
//        }
//        System.out.println(set);

        Set<Integer> set1 = Set.of(2,3,5);
        Set<Integer> set2 = Set.of(2,3,5);
//        System.out.println(set1.equals(set2));

        throw new RuntimeException("hahah");
    }



    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
}
