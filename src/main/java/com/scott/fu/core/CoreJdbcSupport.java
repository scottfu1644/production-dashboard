package com.scott.fu.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

/**
 * Created by ScottFu on 2016/2/24.
 */
public abstract class CoreJdbcSupport {
    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Autowired
    protected SimpleJdbcTemplate simpleJdbcTemplate;
}
