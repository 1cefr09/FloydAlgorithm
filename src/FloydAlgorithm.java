import java.util.Arrays;
public class FloydAlgorithm {
    private static final int INF = 9999;

    public static void main(String[] args) {
        double[][] graph = {
                {0, 9.2,1.1,3.5,INF, INF},
                {1.3, 0,4.7,INF,7.2, INF},
                {2.5,INF,0,INF,1.8,INF},
                {INF, INF,5.3,0,2.4,7.5},
                {INF, 6.4,2.2,8.9,0,5.1},
                {7.7, INF,2.7,INF,2.1,0}
        };

        double[][][] result = floydAlgorithm(graph);
        double[][] shortestPaths = result[0];
        double[][] nextNodes = result[1];

        System.out.println("最短路径矩阵：");
        printMatrix(shortestPaths);

        System.out.println("路径的前驱矩阵：");
        printMatrix(nextNodes);
    }

    public static double[][][] floydAlgorithm(double[][] graph) {
        int n = graph.length;
        double[][] dist = new double[n][n];
        double[][] next = new double[n][n];
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
                        next[i][j] = k;
                    }
                }
            }
            System.out.println("W"+k);
            printMatrix(dist);
            System.out.println("P"+k);
            printMatrix(next);
        }

        return new double[][][]{dist, next};
    }

    public static void printMatrix(double[][] matrix) {
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

}
