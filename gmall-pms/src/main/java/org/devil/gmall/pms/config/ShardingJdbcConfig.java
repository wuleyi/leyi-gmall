package org.devil.gmall.pms.config;

import io.shardingjdbc.core.api.MasterSlaveDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by leyi on 2019/6/8.
 */
@Configuration
public class ShardingJdbcConfig {

    // 使用sharding-jdbc创建具有主从库的数据源
    @Bean
    public DataSource dataSource() throws IOException, SQLException {

        return MasterSlaveDataSourceFactory
                .createDataSource(ResourceUtils.getFile("classpath:sharding-jdbc.yml"));
    }

}
