package com.mylsaber.mybatismultidatasource.config;

import com.mylsaber.mybatismultidatasource.utils.SwitchDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author jfw
 */
public class MultiDataSource extends AbstractRoutingDataSource {
    public MultiDataSource(DataSource defaultDataSource, Map<Object, Object> targetDataSources) {
        super.setTargetDataSources(targetDataSources);
        super.setDefaultTargetDataSource(defaultDataSource);
        // 必须添加该句，让方法根据重新赋值的targetDataSource依次根据key关键字
        // 查找数据源,返回DataSource,否则新添加数据源无法识别到
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return SwitchDataSource.getDataSource();
    }
}
