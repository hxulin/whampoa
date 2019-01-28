package cn.huangxulin.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 功能描述: 定制 Ribbon Client
 *
 * @author hxulin
 */
@Configuration
public class TestConfiguratioon {

    @Bean
    @ConditionalOnMissingBean
    public IRule ribbonRule() {

        return new RandomRule();
    }

}
