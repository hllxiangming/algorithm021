HashMap小结：
一、实现方式：
Java8 HashMap使用Node类替代了Entry（实现了Entry接口），一个Node数据类型的数组作为散列表（transient Node<K,V>[] table;）保存数据。当发生hash冲突时，采用拉链法处理冲突，使用链表来保存冲突的元素。但当冲突的元素个数达到一定的阈值之后（默认为8），会将链表转化成红黑树。这种作法的好处是当冲突元素数量比较少时, 遍历链表不影响查询性能,而且链表的插入操作是O(1), 所以兼顾了插入和删除;而当冲突元素数量比较多, 链表O(n)的时间复杂度会让查询操作比较耗时, 因此转化成红黑树, 提高查询性能.

二、HashMap的四种构造函数：
1、创建一个空的映射对象，使用默认的装填因子0.75
public HashMap() {
    this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
	}
2、用指定的初始容量和默认的装填因子创建一个映射对象
public HashMap(int initialCapacity) {
    this(initialCapacity, DEFAULT_LOAD_FACTOR);
}
3、用指定的初始容量和指定的装填因子创建一个映射对象
public HashMap(int initialCapacity, float loadFactor) {
    if (initialCapacity < 0) //初始容量要求非0，否则抛异常
        throw new IllegalArgumentException("Illegal initial capacity: " +
                                           initialCapacity);
    if (initialCapacity > MAXIMUM_CAPACITY) //假如，指定的初始容量不超过最大容量（2^30），否则置为最大容量
        initialCapacity = MAXIMUM_CAPACITY;
    if (loadFactor <= 0 || Float.isNaN(loadFactor)) // 装填因子非0
        throw new IllegalArgumentException("Illegal load factor: " +
                                           loadFactor);
    this.loadFactor = loadFactor;
    this.threshold = tableSizeFor(initialCapacity);   //设置HashMap的容量极限阈值，当HashMap的容量达到该极限时就会进行自动扩容操作
}
4、用指定的映射对象m创建一个新的映射对象,如下：
public HashMap(Map<? extends K, ? extends V> m) {
    this.loadFactor = DEFAULT_LOAD_FACTOR;
    putMapEntries(m, false);
}

三、HashMap的扩容机制resize():
说明：
1、如果需要存储的元素个数不超过12个键值对，可以不设置。
2、如果超出，按initialCapacity = （需要存储的元素的个数/负载因子）+1 公式计算后设置
3、官方建议是initialCapacity设置成2的次幂
正例：initialCapacity = （需要存储的元素个数/负载因子）+1、注意负载因子（即，loader factor）默认为0.75，如果暂时无法确定初始值大小，请设置为16.
反例：HashMap需要存放1024个元素，由于的没有设置容量初始大小，随着元素不断增加，容
量 7 次被迫扩大，resize 需要重建 hash 表，严重影响性能。

参考至：https://www.jianshu.com/p/e0516bf65611

四、装填因子：
装填因子 = 填入表中记录的个数/散列表长度。装填因子标志着散列表的装满程度。当填入表中的记录越多，装填因子就越大，产生冲突的可能性就越大。
eg：如散列表的长度12，而填入表中记录的个数为11，那么此时的装填因子 = 11/12=0.9167，再填入最后一个关键字产生的冲突的可能性就非常大。即，散列表的平均查找长度取决于装填因子，而不是取决于查找集合汇总的记录个数。
不管记录个数n有多大，我们总可以选择一个合适的装填因子以便将平均查找长度限定在一个范围之内，此时我们散列查找的时间复杂度就真的是O（1）。为了做到这一点，通常我们都是将散列表的控件设置得比查找集合大。


