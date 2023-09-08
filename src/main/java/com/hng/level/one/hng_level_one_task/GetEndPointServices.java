package com.hng.level.one.hng_level_one_task;

import org.springframework.stereotype.Service;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

@Service
public class GetEndPointServices {




    public GetEndPointResponse getEndpoint(String slackName, String track){
        GetEndPointResponse getEndPointResponse = new GetEndPointResponse();
        getEndPointResponse.setSlack_name(slackName);
        getEndPointResponse.setTrack(track);
        getEndPointResponse.setStatus_code(200);
        getEndPointResponse.setGithub_repo_url("https://github.com/jenny-Musah/HNG_LEVEL_ONE");
        getEndPointResponse.setGithub_file_url("https://github.com/jenny-Musah/HNG_LEVEL_ONE/HNG Level One Task/src/main/java/com/hng/level/one/hng_level_one_task/HngLevelOneTaskApplication.java");
        getEndPointResponse.setUtc_time(getCurrentUTCTime());
        getEndPointResponse.setCurrent_day(getCurrentDay());
        return getEndPointResponse;
    }


    private  String getCurrentDay(){
        return LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
    }
    private String getCurrentUTCTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Duration accuracyWindow = Duration.ofMinutes(2);
        Instant currentTime = Instant.now();

        LocalDateTime currentUTC = LocalDateTime.ofInstant(currentTime, ZoneId.of("UTC"));

        Instant minTime = currentTime.minus(accuracyWindow);
        Instant maxTime = currentTime.plus(accuracyWindow);

        if (currentUTC.toInstant(ZoneId.of("UTC").getRules().getOffset(currentUTC)).isBefore(minTime)) {
            return LocalDateTime.ofInstant(minTime, ZoneId.of("UTC")).format(formatter).toString();
        } else if (currentUTC.toInstant(ZoneId.of("UTC").getRules().getOffset(currentUTC)).isAfter(maxTime)) {
            return LocalDateTime.ofInstant(maxTime, ZoneId.of("UTC")).format(formatter).toString();
        } else {
            return currentUTC.format(formatter).toString();
        }
    }
}
