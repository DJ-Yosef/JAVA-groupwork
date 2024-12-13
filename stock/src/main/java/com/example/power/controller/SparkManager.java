package com.example.power.controller;

import io.github.briqt.spark4j.SparkClient;
import io.github.briqt.spark4j.constant.SparkApiVersion;
import io.github.briqt.spark4j.model.SparkMessage;
import io.github.briqt.spark4j.model.SparkSyncChatResponse;
import io.github.briqt.spark4j.model.request.SparkRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class SparkManager {
    @Resource
    private SparkClient sparkClient;

    /**
     * AI生成问题的预设条件
     */
    public static final String PRECONDITION = "你是一个专业的股票分析师，根据我提供的数据，进行分析和预测。\n" +
            "\n" +
            "\n" +
            "\n";
    public String sendMesToAIUseXingHuo(final String content) {
        List<SparkMessage> messages = new ArrayList<>();
        messages.add(SparkMessage.systemContent(PRECONDITION));
        messages.add(SparkMessage.userContent(content));
        SparkRequest sparkRequest = SparkRequest.builder()
                .messages(messages)
                .maxTokens(2048)
                .temperature(0.2)
                .apiVersion(SparkApiVersion.V3_5)
                .build();
        // 同步调用
        SparkSyncChatResponse chatResponse = sparkClient.chatSync(sparkRequest);
        String responseContent = chatResponse.getContent();
        log.info("AI return {}", responseContent);
        return responseContent;
    }
}
