package com.scott.fu.dto;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by ScottFu on 2016/1/20.
 */
public class TrackConcurrentMap<K,V> implements Map<K,V> {

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock rLock = readWriteLock.readLock();
    private final Lock wLock = readWriteLock.writeLock();
    private Map<K,V> map = new HashMap<K, V>();

    public TrackConcurrentMap() {
    }

    public TrackConcurrentMap(Map<K,V> map) {
        this.map = map;
    }

    @Override
    public int size() {
        rLock.lock();
        try {
            return map.size();
        } finally {
            rLock.unlock();
        }
    }

    @Override
    public boolean isEmpty() {
        rLock.lock();
        try {
            return map.isEmpty();
        } finally {
            rLock.unlock();

        }
    }

    @Override
    public boolean containsKey(Object key) {
        rLock.lock();
        try {
            return map.containsKey(key);
        } finally {
            rLock.unlock();
        }
    }

    @Override
    public boolean containsValue(Object value) {
        rLock.lock();
        try {
            return map.containsValue(value);
        } finally {
            rLock.unlock();
        }
    }

    @Override
    public V get(Object key) {
        rLock.lock();
        try {
            return map.get(key);
        } finally {

            rLock.unlock();
        }
    }

    @Override
    public V put(K key, V value) {
        wLock.lock();
        try {
            return map.put(key, value);
        } finally {
            wLock.unlock();
        }
    }

    @Override
    public V remove(Object key) {
        wLock.lock();
        try {
            return map.remove(key);
        } finally {
            wLock.unlock();
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        wLock.lock();
        try {
            map.putAll(m);
        } finally {
            wLock.unlock();
        }
    }

    @Override
    public void clear() {
        wLock.lock();
        try {
            map.clear();
        } finally {
            wLock.unlock();
        }
    }

    @Override
    public Set<K> keySet() {
        rLock.lock();
        try {
            return new HashSet<K>(map.keySet());
        } finally {
            rLock.unlock();

        }
    }

    @Override
    public Collection<V> values() {
        rLock.lock();
        try {
            return new ArrayList<V>(map.values());
        } finally {
            rLock.unlock();
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }
}
