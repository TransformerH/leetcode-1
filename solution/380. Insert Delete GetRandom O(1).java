import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * use a hashmap: all the vals as keys, their location in the LinkedList as values
 * use a LinkedList: add all the vals into the list one after another
 * 
 * insertion is easy, with updating both hashmap and LL only
 * as for removal, first check if the val to be removed is the tail node of the list:
 * if not, exchange it with tail
 * then, remove tail from list and the entry from map accordingly.
 */
class RandomizedSet {

    private Map<Inteter, Integer> map;
    private List<Integer> list;
    private Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        map.put(val, list.size());
        list.add(val);
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int loc = map.get(key);
        if (loc < list.size() - 1){
            // not last one in list
            int last = list.get(list.size() - 1);
            map.put(last, loc);
            list.set(loc, last);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */