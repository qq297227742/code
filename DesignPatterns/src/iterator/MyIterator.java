package iterator;

/**
 * 自定义的迭代器接口
 */
public interface MyIterator {
    void first();

    void next();

    boolean hasNext();

    boolean isFirst();

    boolean isLast();

    Object getCurrentObj();//获取当前游标指向的对象
}
