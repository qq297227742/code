package chainOfResp;

/**
 * 凑想类
 */
public abstract class Leader {
    protected String name;
    protected Leader nextLeader;//责任链上的后继对象

    public Leader(String name) {
        this.name = name;
    }

    public Leader getNextLeader() {
        return nextLeader;
    }

    /**
     * 设置责任链上的后继对象
     * @param nextLeader
     */
    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    /**
     *
     * @param request
     */
    public abstract void handleRequest(LeaveRequest request);
}
