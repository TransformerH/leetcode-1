/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

      public class Solution extends Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Maximum number of characters to read
         * @return    The number of characters read
         */
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int i = 0;
        int len;
        while (i < n && (len = read4(temp)) > 0){
            for (int j = 0; j < len && i < n; j++){
                buf[i++] = temp[j];
            }
        }
        return i;
    }
}