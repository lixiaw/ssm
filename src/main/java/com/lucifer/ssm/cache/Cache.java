package com.lucifer.ssm.cache;

import com.opensymphony.oscache.base.NeedsRefreshException;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;

import java.util.Date;

/**
 * Created by nelucifer on 2017/3/4.
 */
public class Cache extends GeneralCacheAdministrator {

    static int refreshPeriod = 3 * 30 * 24 * 60 * 60;//过期时间（单位为秒）

    private static Cache cache = null;

    //静态工厂方法
    public synchronized static Cache getInstance() {
        if (cache == null) {
            cache = new Cache();
        }
        return cache;
    }

    /**
     * 添加到缓存中
     *
     * @param key
     * @param value
     */
    public void put(String key, Object value) {
        this.putInCache(key, value);
    }

    /**
     * 删除缓存(根据key)
     *
     * @param key
     */
    public void remove(String key) {
        this.flushEntry(key);
    }

    /**
     * 删除指定日期的所有缓存
     *
     * @param date
     */
    public void removeAll(Date date) {
        this.flushAll(date);
    }

    /**
     * 删除所有缓存
     */
    public void removeAll() {
        this.flushAll();
    }

    /**
     * 获取缓存
     * @param key
     * @return
     * @throws Exception
     */
    public Object getCache(String key) throws Exception {
        try {
            return this.getFromCache(key, refreshPeriod);
        } catch (NeedsRefreshException e) {
            this.cancelUpdate(key);
            e.printStackTrace();
            System.out.println("getCache is Failed ..." + e.getMessage().toString());
            throw e;
        }
    }
}
