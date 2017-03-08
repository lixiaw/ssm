package com.lucifer.ssm.system;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 选择数据源
 * （暂未使用--20161122）
 */
public class MultipleDataSource extends AbstractRoutingDataSource {
    private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();

    public static void setDataSourceKey(String dataSource) {
        dataSourceKey.set(dataSource);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceKey.get();
    }
}
