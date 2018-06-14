public class Vector2D implements Iterator<Integer> {

    List<List<Integer>> list;
    int row;
    int item;
    public Vector2D(List<List<Integer>> vec2d) {
        list = vec2d;
        row = 0;
        item = 0;
    }

    @Override
    public Integer next() {
        return list.get(row).get(item++);
    }

    @Override
    public boolean hasNext() {
        while (row < list.size()){
            if (item < list.get(row).size()){
                return true;
            } else if (item == list.get(row).size()){
                item = 0;
                row++;
            }
        }
        return false; 
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */