package xiaomage.union;

/**
 * @description: Quick Union - 基于rank的优化 - 路径分裂(Path Spliting)
 * @author: xwy
 * @create: 下午4:18 2021/11/11
 **/

public class UnionFind_QU_R_PS extends UnionFind_QU_R {

    public UnionFind_QU_R_PS(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        while (v != parents[v]) {
            int p = parents[v];
            parents[v] = parents[parents[v]];
            v = p;
        }
        return v;
    }
}