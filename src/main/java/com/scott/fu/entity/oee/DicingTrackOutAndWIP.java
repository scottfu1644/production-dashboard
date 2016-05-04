package com.scott.fu.entity.oee;

/**
 * Created by ScottFu on 2016/2/23.
 */
public class DicingTrackOutAndWIP extends BaseTrackOutAndWIP {

    private Integer DicingTrackOut;
    private Integer DicingWIP;

    public Integer getDicingTrackOut() {
        return DicingTrackOut;
    }

    public void setDicingTrackOut(Integer dicingTrackOut) {
        DicingTrackOut = dicingTrackOut;
    }

    public Integer getDicingWIP() {
        return DicingWIP;
    }

    public void setDicingWIP(Integer dicingWIP) {
        DicingWIP = dicingWIP;
    }
}
