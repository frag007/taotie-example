package com.frag.taotie.config;

import com.frag.taotie.core.TaotieActuator;
import com.frag.taotie.entity.DataDto;
import com.frag.taotie.service.ReportService;
import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuhj
 */
@Configuration
public class ProcessorConfiguration {

    @Value("${taotie.queuePower:6}")
    private int queuePower;

    @Value("${taotie.pollThreadPower:1}")
    private int pollThreadPower;

    @Value("${taotie.benchCommitNum:4000}")
    private int benchCommitNum;

    @Value("${taotie.commitThreadNum:10}")
    private int commitThreadNum;

    @Value("${taotie.queueCapacityFactor:1.0}")
    private float queueCapacityFactor;

    @Value("${taotie.offerTimeout:10}")
    private int offerTimeout;

    @Value("${taotie.pollTimeout:100}")
    private int pollTimeout;

    @Value("${taotie.maxKeepAliveRequests:10000}")
    private int maxKeepAliveRequests;

    @Bean
    public TaotieActuator<DataDto> dataReportProcessor(ReportService reportService) {
        return new TaotieActuator<DataDto>(queuePower, benchCommitNum, pollThreadPower, commitThreadNum, queueCapacityFactor, offerTimeout, pollTimeout,
                reportService::reportMulTable, DataDto::getUserId);
    }

    @Bean
    public TomcatServletWebServerFactory servletContainerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers(connector ->
                ((AbstractHttp11Protocol) connector.getProtocolHandler()).setMaxKeepAliveRequests(maxKeepAliveRequests));
        return factory;
    }

}
