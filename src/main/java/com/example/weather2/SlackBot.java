package com.example.weather2;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import org.json.JSONObject;
import com.slack.api.bolt.App;
import com.slack.api.bolt.AppConfig;
//import com.slack.api.bolt.jetty.SlackAppServer;
import com.slack.api.model.event.MessageEvent;
import org.json.JSONObject;
import com.slack.api.bolt.App;
import java.util.Scanner;


public class SlackBot {
    public static void main(String[] args) {
        String channel = "C063PP84VA5"; // 메시지를 보낼 Slack 채널 ID
        String userMessage = "부산 현재 온도"; // 사용자의 메시지

        try {
            String city = determineCity(userMessage);
            String temperature = getCurrentTemperature(city);

            sendMessage(channel, temperature); // Slack에 온도 정보 전송
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final String SLACK_API_TOKEN = "xoxb-5627229006183-6101326350103-0f3Sjq36joxlcuzRzJO9j5Mq";

    public static void sendMessage(String channel, String message) {
        try {
            Slack slack = Slack.getInstance();
            MethodsClient methods = slack.methods(SLACK_API_TOKEN);

            ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                    .channel(channel)
                    .text(message)
                    .build();

            ChatPostMessageResponse response = methods.chatPostMessage(request);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String determineCity(String message) {
        return "Busan"; // 기본적으로 부산으로 설정
    }

    public static String getCurrentTemperature(String city) {
        try {
            String weatherResponse = weatherAPI.getWeather(city);
            JSONObject jsonObject = new JSONObject(weatherResponse);
            JSONObject main = jsonObject.getJSONObject("main");
            double temperature = main.getDouble("temp");

            return city + "현재 온도는 " + temperature + "°C 입니다.";
        } catch (Exception e) {
            e.printStackTrace();
            return "날씨 정보를 가져오는 중에 오류가 발생했습니다.";
        }
    }
}