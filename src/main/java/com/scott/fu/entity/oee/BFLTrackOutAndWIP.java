package com.scott.fu.entity.oee;

/**
 * Created by ScottFu on 2016/2/23.
 */
public class BFLTrackOutAndWIP extends BaseTrackOutAndWIP {

    private Integer BFLTrackOut;
    private Integer BFLWIP;

    public Integer getBFLTrackOut() {
        return BFLTrackOut;
    }

    public void setBFLTrackOut(Integer BFLTrackOut) {
        this.BFLTrackOut = BFLTrackOut;
    }

    public Integer getBFLWIP() {
        return BFLWIP;
    }

    public void setBFLWIP(Integer BFLWIP) {
        this.BFLWIP = BFLWIP;
    }
}
