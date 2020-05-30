package mediator;

/**
 * 中介者接口
 */
public interface Mediator {

    void register(String dname,Department d);

    void command(String dname);
}
