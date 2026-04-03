public class KMP {

    public static int[] getNext(String pattern) {
        int m = pattern.length();
        int[] next = new int[m];
        int j = 0;
        next[0] = 0;

        for (int i = 1; i < m; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static int[] getNextVal(String pattern) {
        int m = pattern.length();
        int[] next = getNext(pattern);
        int[] nextVal = new int[m];
        nextVal[0] = 0;

        for (int i = 1; i < m; i++) {
            int k = next[i];
            while (k > 0 && pattern.charAt(i) == pattern.charAt(k)) {
                k = next[k - 1];
            }
            nextVal[i] = k;
        }
        return nextVal;
    }

    public static int kmpSearch(String text, String pattern) {
        if (pattern.isEmpty()) return 0;

        int[] next = getNext(pattern);
        int j = 0;

        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == pattern.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String text = "ababcabcacbab";
        String pattern = "abcac";

        int index = kmpSearch(text, pattern);
        System.out.println("匹配位置: " + index);
    }
}
