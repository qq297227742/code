package observer2;

import java.util.Observable;

/**
 * 目标对象
 */
public class ConcreteSubject extends Observable {
    private int state;
    public void setState(int s) {
        state = s;

        //表示目标对象已经做了更改
        setChanged();

        //通知所有观察者
        notifyObservers(state);
    }

    public int getState() {
        return state;
    }
}
