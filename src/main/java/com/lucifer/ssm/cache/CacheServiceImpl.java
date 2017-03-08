package com.lucifer.ssm.cache;

import com.lucifer.ssm.dao.cache.CacheDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by nelucifer on 2017/3/4.
 */
public class CacheServiceImpl implements ICacheService {

    @Resource
    CacheDao dao;

    private Cache cache = Cache.getInstance();

    public void putInCache(String key, Object value) {
        cache.put(key, value);
    }

    /**
     * 初始化缓存
     *
     * @throws Exception
     */
    public void pushCaches() throws Exception {
        System.out.println("start Load Cache...");
        cache.removeAll();
        initSysDictionaryData();
    }

    /**
     * Loading dictionary data
     */
    private void initSysDictionaryData() {
        List<Map<String, Object>> testList = dao.queryTest();
        this.putCacheAndJudge(testList, "test");
    }

    private void putCacheAndJudge(List<Map<String, Object>> list, String cacheName) {
        if (list != null && list.size() > 0) {
            putInCache(cacheName, list);
        } else {
            this.initCacheFailed(cacheName);
        }
    }

    private void getCacheAndJudge(List<Map<String, Object>> list, String cacheName, String cacheAlias) {
        if (list != null && list.size() > 0) {
            putInCache(cacheName, list);
        } else {
            this.initCacheFailed(cacheAlias);
        }
    }

    private void initCacheFailed(String cacheName) {
        System.out.println("[****InitCache****]Loading [" + cacheName + "] Failed...");
    }
}
