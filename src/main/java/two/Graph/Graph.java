package two.Graph;

public class Graph {
    private int vertexSize;//顶点数量
    private int[] vertexs;//顶点数组
    private int[][] matrix;//矩阵
    private static final int MAX_WEIGHT = 1000;

    public Graph(int vertexSize) {
        this.vertexSize = vertexSize;
        matrix = new int[vertexSize][vertexSize];
        vertexs = new int[vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            vertexs[i] = i;
        }
    }

    public int[] getVertexs() {
        return vertexs;
    }

    public void setVertexs(int[] vertexs) {
        this.vertexs = vertexs;
    }

    /**
     * 获取某个顶点的出度
     *
     * @param index
     * @return
     */
    public int getOutDegree(int index) {
        int degree = 0;
        for (int j = 0; j < matrix[index].length; j++) {
            int weight = matrix[index][j];
            if (weight != 0 && weight != MAX_WEIGHT) {
                degree++;
            }
        }
        return degree;
    }

    /**
     * 获取某个顶点的入度
     *
     * @param index
     * @return
     */
    public int getInDegree(int index) {
        int degree = 0;
        for (int j = 0; j < matrix[index].length; j++) {
            int weight = matrix[j][index];
            if (weight != 0 && weight != MAX_WEIGHT) {
                degree++;
            }
        }
        return degree;
    }

    /**
     * 获取两个顶点之间的权值
     *
     * @param v1
     * @param v2
     * @return
     */
    public int getWeight(int v1, int v2) {
        int weight = matrix[v1][v2];
        return weight == 0 ? 0 : (weight == MAX_WEIGHT ? -1 : weight);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        int[] a1 = new int[]{0, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 6};
        int[] a2 = new int[]{9, 0, 3, MAX_WEIGHT, MAX_WEIGHT};
        int[] a3 = new int[]{2, MAX_WEIGHT, 0, 5, MAX_WEIGHT};
        int[] a4 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0, 1};
        int[] a5 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0};

        graph.matrix[0] = a1;
        graph.matrix[1] = a2;
        graph.matrix[2] = a3;
        graph.matrix[3] = a4;
        graph.matrix[4] = a5;

        int outDegree = graph.getOutDegree(0);
        System.out.println("V0的出度：" + outDegree);
        System.out.println("权值：" + graph.getWeight(0, 0));
    }
}