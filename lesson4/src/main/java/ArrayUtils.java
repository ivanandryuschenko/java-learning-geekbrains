import java.util.*;

public class ArrayUtils<T> {
    public void swap(T[] array, int i1, int i2) {
        T tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }
    
    public ArrayList<T> toArrayList(T[] array) {
         ArrayList<T> aList = new ArrayList<>(array.length);
         for (T a : array)
             aList.add(a);
         return aList;
    }
}
