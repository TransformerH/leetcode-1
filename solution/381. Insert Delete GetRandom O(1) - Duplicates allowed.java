class RandomizedCollection {

    private List<Integer> list;
    private Map<Integer, Set<Integer>> map;
    private Random random;

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean result = map.containsKey(val);

        if (!result) map.put(val, new ArrayList<>());
        map.get(val).add(list.size());
        list.add(val);

        return !result;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean result = map.containsKey(val);
        if (!result) return false;

        if (!map.get(val).contains(list.size() - 1)){
            // not the last one, swap it with the last one and remove last one
            int curPos = map.get(val).iterator().next();
            int lastVal = list.get(list.size() - 1);

            map.get(lastVal).remove(list.size() - 1);
            map.get(lastVal).add(curPos);
            map.get(val).add(list.size() - 1);
            map.get(val).remove(curPos);
            list.set(curPos, lastVal);
        }
        map.get(val).remove(list.size() - 1);
        if (map.get(val).isEmpty()) map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}