package com.example.weather2;

public class weather {
    public static void main(String[] args) {
        try {
            String city = "Busan";  // 기본값은 서울로 설정, 다른 도시로 변경 가능
            String weatherData = weatherAPI.getWeather(city);

            // 날씨 정보 파싱 및 메시지 작성
            String description = "Sunny"; // 날씨 정보에서 가져온 값으로 변경
            String temperature = "25";    // 온도 정보에서 가져온 값으로 변경
            String message = String.format("%s의 날씨: %s, 온도: %s°C", city, description, temperature);

            try {
                WeatherBot.sendMessage("C063PP84VA5", message); // CHANNEL_ID를 실제 Slack 채널 ID로 대체
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
