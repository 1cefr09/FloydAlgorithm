import java.util.Arrays;
public class FloydAlgorithm {
    private static final int INF = 9999;

    public static void main(String[] args) {
        int[][] graph = {
                {0, 5, INF, 10},
                {INF, 0, 3, INF},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0}
        };

        int[][][] result = floydAlgorithm(graph);
        int[][] shortestPaths = result[0];
        int[][] nextNodes = result[1];

        System.out.println("最短路径矩阵：");
        printMatrix(shortestPaths);

        System.out.println("路径的前驱矩阵：");
        printMatrix(nextNodes);

        int source = 0;
        int destination = 3;
        System.out.println("从节点 " + source + " 到节点 " + destination + " 的最短路径：");
        printPath(source, destination, nextNodes);
    }

    public static int[][][] floydAlgorithm(int[][] graph) {
        int n = graph.length;
        int[][] dist = new int[n][n];
        int[][] next = new int[n][n];

        // 初始化距离矩阵和前驱矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
                if (graph[i][j] != INF && i != j) {
                    next[i][j] = j;
                } else {
                    next[i][j] = -1;
                }
            }
        }

        // 计算最短路径和前驱矩阵
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        return new int[][][]{dist, next};
    }

    public static void printMatrix(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printPath(int source, int destination, int[][] nextNodes) {
        StringBuilder path = new StringBuilder(source + " ");

        while (source != destination) {
            source = nextNodes[source][destination];
            path.append(source).append(" ");
        }

        System.out.println(path.toString());
    }
}
