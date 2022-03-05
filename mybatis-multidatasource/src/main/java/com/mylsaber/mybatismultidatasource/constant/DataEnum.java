package com.mylsaber.mybatismultidatasource.constant;

/**
 * @author jfw
 */

public enum DataEnum {
    /**
     * 数据库1
     */
    DATASOURCE1("1", "dataSource1"),
    /**
     * 数据库1
     */
    DATASOURCE2("2", "dataSource2");

    private String id;
    private String name;

    DataEnum(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static String getDataSourceName(String id) {
        for (DataEnum dataEnum : DataEnum.values()) {
            if (dataEnum.id.equals(id)) {
                return dataEnum.name;
            }
        }
        return null;
    }
}
