package com.example.weather2;
import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;

public class WeatherBot {
    private static final String SLACK_API_TOKEN = "xoxb-5627229006183-6101326350103-0f3Sjq36joxlcuzRzJO9j5Mq";

    public static void sendMessage(String channel, String message) throws Exception {
        Slack slack = Slack.getInstance();
        MethodsClient methods = slack.methods(SLACK_API_TOKEN);

        ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                .channel(channel)
                .text(message)
                .build();

        ChatPostMessageResponse response = methods.chatPostMessage(request);
        System.out.println(response);
    }

}
