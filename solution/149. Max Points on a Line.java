class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;
        if (points.length <= 2) return points.length;
        int result = 0;
        for (int i = 0; i < points.length; i++){
            Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
            int localMax = 0;
            int samePoints = 1;  
            for (int j = i + 1; j < points.length; j++){
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if (x == 0 && y == 0){
                    samePoints++;
                    continue;
                }    
                int gcd = gcd(x, y);
                if (gcd != 0){
                    x /= gcd;
                    y /= gcd;
                }
                if (map.containsKey(x)){
                    if (map.get(x).containsKey(y)){
                        map.get(x).put(y, map.get(x).get(y)+1);
                    }else{
                        map.get(x).put(y, 1);
                    }
                }else{
                    Map<Integer, Integer> temp = new HashMap<>();
                    temp.put(y, 1);
                    map.put(x, temp);
                }
                localMax = Math.max(localMax, map.get(x).get(y));
            }
            result = Math.max(result, localMax + samePoints);     
        } 
        return result;
    }
    private int gcd(int x, int y){
        if (y == 0) return x;
        else return gcd(y, x % y);
    }
}