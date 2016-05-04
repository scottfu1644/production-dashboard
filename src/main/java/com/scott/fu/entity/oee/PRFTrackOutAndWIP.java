package com.scott.fu.entity.oee;

import java.util.List;

/**
 * Created by ScottFu on 2016/2/23.
 */
public class PRFTrackOutAndWIP extends BaseTrackOutAndWIP {

    private Integer DNVTrackOut;
    private Integer TNVTrackOut;
    private Integer DNVWIP;
    private Integer TNVWIP;



    public Integer getDNVTrackOut() {
        return DNVTrackOut;
    }

    public void setDNVTrackOut(Integer DNVTrackOut) {
        this.DNVTrackOut = DNVTrackOut;
    }

    public Integer getTNVTrackOut() {
        return TNVTrackOut;
    }

    public void setTNVTrackOut(Integer TNVTrackOut) {
        this.TNVTrackOut = TNVTrackOut;
    }

    public Integer getDNVWIP() {
        return DNVWIP;
    }

    public void setDNVWIP(Integer DNVWIP) {
        this.DNVWIP = DNVWIP;
    }

    public Integer getTNVWIP() {
        return TNVWIP;
    }

    public void setTNVWIP(Integer TNVWIP) {
        this.TNVWIP = TNVWIP;
    }
}
