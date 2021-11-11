package xiaomage.union;

/**
 * @description: Quick Union - 基于rank的优化 - 路径压缩(Path Compression)
 * @author: xwy
 * @create: 下午3:52 2021/11/11
 **/

public class UnionFind_QU_R_PC extends UnionFind_QU_R {

    public UnionFind_QU_R_PC(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) { // v == 1, parents[v] == 2
        rangeCheck(v);
        if (parents[v] != v) {
            parents[v] = find(parents[v]);
        }
        return parents[v];
    }
}
