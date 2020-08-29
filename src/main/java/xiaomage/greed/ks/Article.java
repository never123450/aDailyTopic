package xiaomage.greed.ks;

/**
 * @description:
 * @author: xwy
 * @create: 2:50 PM 2020/8/22
 **/

public class Article {
    public int weight;
    public int value;
    public double valueDensity;

    public Article(int weight, int value) {
        this.weight = weight;
        this.value = value;
        valueDensity = value * 1.0 / weight;
    }

    @Override
    public String toString() {
        return "Article [weight=" + weight + ", value=" + value + ", valueDensity=" + valueDensity + "]";
    }
}
