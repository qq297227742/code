package adapter;

/**
 * 适配器(类适配器方式)
 * 相当于USB转PS/2转接器
 */
public class Adapter extends Adaptee implements Target{
    @Override
    public void handleReq() {
        super.request();
    }
}
