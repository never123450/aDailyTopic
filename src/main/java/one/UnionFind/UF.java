package one.UnionFind;

/**
 * @description: 并查集接口
 * @author: xwy
 * @create: 14:15 2021/1/14
 **/

public interface UF {

    int getSize();

    /**
     * 是否关联
     * @param p
     * @param q
     * @return
     */
    boolean isConnected(int p, int q);

    /**
     * 合并元素p,q
     * @param p
     * @param q
     */
    void unionElements(int p, int q);
}