package com.ustc.myy.springdatajpademo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DataSourceInfoLogger implements ApplicationRunner {

    private final DataSource dataSource;

    public DataSourceInfoLogger(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (dataSource instanceof HikariDataSource hikariDS) {
            System.out.println("✅ 数据库连接池信息（启动后）:");
            System.out.println("Pool Name: " + hikariDS.getPoolName());
            System.out.println("JDBC URL: " + hikariDS.getJdbcUrl());
            System.out.println("Driver Class: " + hikariDS.getDriverClassName());
            System.out.println("Database Version: " + hikariDS.getConnection().getMetaData().getDatabaseProductVersion());
//            System.out.println("Active Connections: " + hikariDS.getActiveConnections());
//            System.out.println("Total Connections: " + hikariDS.getTotalConnections());
//            System.out.println("Idle Connections: " + hikariDS.getIdleConnections());
            System.out.println("Max Connections: " + hikariDS.getMaximumPoolSize());
            System.out.println("Min Connections: " + hikariDS.getMinimumIdle());
            System.out.println("Leak Detection Threshold: " + hikariDS.getLeakDetectionThreshold());
            System.out.println("Connection Timeout: " + hikariDS.getConnectionTimeout());
            System.out.println("Idle Timeout: " + hikariDS.getIdleTimeout());
        } else {
            System.out.println("⚠️ 当前数据源不是 HikariCP");
        }
    }
}
