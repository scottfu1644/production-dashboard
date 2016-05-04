package com.scott.fu.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by ScottFu on 2016/1/20.
 */
public class Cache implements Serializable {
    private static final long serialVersionUID = -3971709196436977492L;
    private final int DEFAULT_VALIDITY_TIME = 20;
    private String cacheKey;

    private static TrackConcurrentMap<String, List<CachedDTO>> trackConcurrentMap
            = new TrackConcurrentMap<String, List<CachedDTO>>();

    private Date date;

    public String getCacheKey() {
        return cacheKey;
    }

    public void setCacheKey(String cacheKey) {
        this.cacheKey = cacheKey;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}