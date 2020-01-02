package hashMap;

import java.util.Map;

/**
 * @Date:Create in 14:16 2018/2/5
 * @Description:详解JDK1.7的HashMap.put方法
 */
public class HashMap_put {
    //全局数组，每个数组的元素是一个带有后续指针(next)、key、hashcode、hashvalue的数据结构，可以说所有的操作都是为了维护这个数组
    protected transient HashMap_put.HashEntry[] data;
 
    protected static final int DEFAULT_CAPACITY = 16;//HashMap的初始大小
    protected static final float DEFAULT_LOAD_FACTOR = 0.75F;//HashMap的扩容临界点：0.75
    protected static final int MAXIMUM_CAPACITY = 1073741824;//HashMap的容量最大值
    protected transient int modCount;//修改次数；不懂的参考博客：https://www.cnblogs.com/nulisaonian/p/5946382.html
    protected transient int size;//HashMap的size属性
    protected transient int threshold;//threshold=capacity*loadFactor（扩容临界值）
    protected transient float loadFactor;//loadFactor译为装载因子。装载因子用来衡量HashMap满的程度。loadFactor的默认值为0.75f。
 
    /**
     * @Param:[key, value]
     * @Return:java.lang.Object
     * @Date:Create in 16:12 2018/2/5
     * @Description:HashMap.put方法的主体
     */
    public Object put(Object key, Object value) {
        key = this.convertKey(key);//key为null则用new Object()代替。
        int hashCode = this.hash(key);//得出key的hash值，但这个hash值不是key本身的hash值，是经过复杂运算的。
        int index = this.hashIndex(hashCode, this.data.length);//根据key的hash值和全局数组data的长度得出数组下标。
 
        //遍历下标为“index”的全局数组data，如果有“相等”key已经存在，那么替换掉。
        for(HashMap_put.HashEntry entry = this.data[index]; entry != null; entry = entry.next) {
            //判断key是否已经存在；（entry.hashCode就是key的hash值）
            if(entry.hashCode == hashCode && this.isEqualKey(key, entry.key)) {
                Object oldValue = entry.getValue();//把旧的值赋给oldValue
                this.updateEntry(entry, value);//用新的value把旧的value替换掉
                return oldValue;//把替换掉的旧value，返回
            }
        }
        //新增键值对让我们的注意力------》转移到addMapping这个方法上。
        this.addMapping(index, hashCode, key, value);
        return null;
 
 
    }
    
    /**
     * @Param:[key]
     * @Return:java.lang.Object
     * @Date:Create in 16:13 2018/2/5
     * @Description:key为null,则用new Object()来代替
     */
    protected static final Object NULL = new Object();
    protected Object convertKey(Object key) {
        return key == null?NULL:key;
    }
    
    /**
     * @Param:[key]
     * @Return:int
     * @Date:Create in 16:15 2018/2/5
     * @Description:得出key的hash值，之后进行位运算。
     * 为何要进行如此“复杂”的位运算？
     *      为了key的hash值“散列均匀”，防止频繁的“哈希冲突” 。
     *      给出相关的博客地址：https://www.cnblogs.com/liujinhong/p/6576543.html
     */
    protected int hash(Object key) {
        int h = key.hashCode();
        h += ~(h << 9);
        h ^= h >>> 14;
        h += h << 4;
        h ^= h >>> 10;
        return h;
    }
 
    /**
     * @Param:[hashCode, dataSize]
     * @Return:int
     * @Date:Create in 16:15 2018/2/5
     * @Description:key的hash值和
     */
    protected int hashIndex(int hashCode, int dataSize) {
        return hashCode & dataSize - 1;
    }
 
    /**
     * @Param:[key1, key2]
     * @Return:boolean
     * @Date:Create in 16:50 2018/2/5
     * @Description:判断两个key是否引用同一个对象，或者字面值相等。
     */
    protected boolean isEqualKey(Object key1, Object key2) {
        return key1 == key2 || key1.equals(key2);
    }
 
    /**
     * @Param:[entry, newValue]
     * @Return:void
     * @Date:Create in 16:50 2018/2/5
     * @Description:(如果key已经存在)把value替换为新的newvalue
     */
    protected void updateEntry(HashMap_put.HashEntry entry, Object newValue) {
        entry.setValue(newValue);
    }
 
    /**
     * @Param:[hashIndex, hashCode, key, value]
     * @Return:void
     * @Date:Create in 16:57 2018/2/5
     * @Description:(如果key不存在)新增键值对
     */
    protected void addMapping(int hashIndex, int hashCode, Object key, Object value) {
        ++this.modCount;//修改次数加一。
        HashMap_put.HashEntry entry = this.createEntry(this.data[hashIndex], hashCode, key, value);//创建一个内部类entry
        this.addEntry(entry, hashIndex);//为全局数组data添加一个entry
        ++this.size;//HashMap的size加一。
        this.checkCapacity();//检查HashMap是否需要扩大容量让我们的注意力转移到checkCapacity这个方法上。
    }
 
    /**
     * @Param:[next, hashCode, key, value]
     * @Return:demo.JavaDemo.HashMap_put.HashEntry
     * @Date:Create in 17:03 2018/2/5
     * @Description:故名思议：创建一个Entry
     */
    protected HashMap_put.HashEntry createEntry(HashMap_put.HashEntry next, int hashCode, Object key, Object value) {
        return new HashMap_put.HashEntry(next, hashCode, key, value);//调用内部类HashEntry的构建方法。
    }
 
    /**
     * @Param:[entry, hashIndex]
     * @Return:void
     * @Date:Create in 17:09 2018/2/5
     * @Description:把内部类entry，放在全局数组data下标为hashIndex的位置上。
     */
    protected void addEntry(HashMap_put.HashEntry entry, int hashIndex) {
        this.data[hashIndex] = entry;
    }
 
    /**
     * @Param:[]
     * @Return:void
     * @Date:Create in 17:16 2018/2/5
     * @Description:检查HashMap是否需要扩大容量
     */
    protected void checkCapacity() {
        if(this.size >= this.threshold) {//如果HashMap的size大于等于了容量临界值（HashMap容量*0.75）。注意：这里的size和容量并不相等，size<容量
            int newCapacity = this.data.length * 2;//扩容两倍
            if(newCapacity <= 1073741824) {//新的容量小于等于最大容量
                this.ensureCapacity(newCapacity);//扩容方法转移注意力到ensureCapacity这个方法上。
            }
        }
    }
 
    /**
     * @Param:[newCapacity]
     * @Return:void
     * @Date:Create in 12:31 2018/2/6
     * @Description:HashMap具体的扩容方法。
     */
    protected void ensureCapacity(int newCapacity) {
        int oldCapacity = this.data.length;
        if(newCapacity > oldCapacity) {//如果新的容量大于旧的容量，那么就需要扩容
            if(this.size == 0) {//若HashMap的size为0
                //赋予新的临界值：
                this.threshold = this.calculateThreshold(newCapacity, this.loadFactor);
                //赋予新的全局数组data
                this.data = new HashMap_put.HashEntry[newCapacity];
            } else {//若HashMap的size不为0
                HashMap_put.HashEntry[] oldEntries = this.data;//老的全局数组
                //实例化一个新的容量为newCapacity的全局数组
                HashMap_put.HashEntry[] newEntries = new HashMap_put.HashEntry[newCapacity];
                ++this.modCount;//修改次数加一
                //循环遍历老的全局数组data
                for(int i = oldCapacity - 1; i >= 0; --i) {
                    HashMap_put.HashEntry entry = oldEntries[i];//把全局数组中元素赋给entry
                    if(entry != null) {
                        oldEntries[i] = null;//把这个位置的数组元素置为null
 
                        HashMap_put.HashEntry next;
                        do {
                            next = entry.next;
                            int index = this.hashIndex(entry.hashCode, newCapacity);//根据key的hash值，和newCapacity，得出下标
                            //构建next这个属性，把前后元素关联起来。
                            entry.next = newEntries[index];
                            newEntries[index] = entry;
                            entry = next;
                        } while(next != null);
                    }
                }
                //赋予新的临界值：
                this.threshold = this.calculateThreshold(newCapacity, this.loadFactor);
                //把新的全局数组赋给data
                this.data = newEntries;
            }
 
        }
    }
 
    /**
     * @Param:[newCapacity, factor]
     * @Return:int
     * @Date:Create in 12:37 2018/2/6
     * @Description:装载因子的计算规则
     */
    protected int calculateThreshold(int newCapacity, float factor) {
        return (int)((float)newCapacity * factor);
    }
 
 
 
 
    /**
     * 内部类
     * @Date:Create in 17:05 2018/2/5
     * @Description:构造一个拥有属性：key,value,hashCode,next的“容器”（我没有使用对象来形容）。
     */
    protected static class HashEntry implements Map.Entry { //, KeyValue
        protected HashMap_put.HashEntry next;
        protected int hashCode;
        protected Object key;
        protected Object value;
 
        protected HashEntry(HashMap_put.HashEntry next, int hashCode, Object key, Object value) {
            this.next = next;
            this.hashCode = hashCode;
            this.key = key;
            this.value = value;
        }
 
        public Object getKey() {
            return this.key == HashMap_put.NULL?null:this.key;
        }
 
        public Object getValue() {
            return this.value;
        }
 
        public Object setValue(Object value) {
            Object old = this.value;
            this.value = value;
            return old;
        }
 
        public boolean equals(Object obj) {
            if(obj == this) {
                return true;
            } else if(!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry other = (Map.Entry)obj;
                return (this.getKey() == null?other.getKey() == null:this.getKey().equals(other.getKey())) && (this.getValue() == null?other.getValue() == null:this.getValue().equals(other.getValue()));
            }
        }
 
        public int hashCode() {
            return (this.getKey() == null?0:this.getKey().hashCode()) ^ (this.getValue() == null?0:this.getValue().hashCode());
        }
 
        public String toString() {
            return "" + this.getKey() + '=' + this.getValue();
        }
    }
 
}