package day51;

public class Main {
    private int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean hasPath (char[][] matrix, String word) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                boolean[][] vis = new boolean[matrix.length][matrix[0].length];
                if(dfs(matrix, word, i, j, vis, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] matrix, String word, int i, int j, boolean[][] hasVisted, int index) {
        if(word.length() == index) {//第一次进入到这里，就是第一个字符匹配，
            //那要是这个字符就是最后一个字符，就可以直接返回true了
            return true;
        }
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length
                || hasVisted[i][j] || word.charAt(index) != matrix[i][j]) {
            return false;
        }
        hasVisted[i][j] = true;
        for(int[] d : dir) {
            if(dfs(matrix, word, i + d[0], j + d[1], hasVisted, index + 1)) {
                return true;//只要有一个满足就可以了.就可以返回了
            }
        }
        //没有一个满足，就改回去，顺便返回
        hasVisted[i][j] = false;
        return false;
    }
}
