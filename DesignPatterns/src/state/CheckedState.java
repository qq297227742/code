package state;

/**
 * 已入住状态
 */
public class CheckedState implements State {
    @Override
    public void handle() {
        System.out.println("房间已入住！请勿打扰");
    }
}
