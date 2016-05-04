package com.scott.fu.entity.oee;

/**
 * Created by ScottFu on 2016/2/23.
 */
public class LACTrackOutAndWIP extends BaseTrackOutAndWIP {

    private Integer LACTrackOut;
    private Integer LACWIP;

    public Integer getLACTrackOut() {
        return LACTrackOut;
    }

    public void setLACTrackOut(Integer LACTrackOut) {
        this.LACTrackOut = LACTrackOut;
    }

    public Integer getLACWIP() {
        return LACWIP;
    }

    public void setLACWIP(Integer LACWIP) {
        this.LACWIP = LACWIP;
    }
}
