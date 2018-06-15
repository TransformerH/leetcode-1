import java.util.Iterator;
import java.util.List;

public class ZigzagIterator {
    
    private Iterator<Integer> i, j, temp;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        i = v1.iterator();
        j = v2.iterator();
    }

    public int next() {
        if (i.hasNext()){
            temp = j;
            j = i;
            i = temp;
        }
       return j.next();
    }

    public boolean hasNext() {
        return i.hasNext() || j.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */