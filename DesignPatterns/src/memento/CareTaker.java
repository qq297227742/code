package memento;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 负责人类
 * 负责管理备忘录对象
 */
public class CareTaker {
    private EmpMemento memento;
    private Stack<EmpMemento> stack=new Stack<>();
//    private List<EmpMemento> list=new ArrayList<>();

    public EmpMemento getMemento() {
        return memento;
    }

    public void setMemento(EmpMemento memento) {
        this.memento = memento;
    }
}
