package com.hng.level.one.hng_level_one_task;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetEndPointResponse {
private String slack_name;
private String current_day;
private String utc_time;
private String track;
private String github_file_url;
private String github_repo_url;
private int status_code;
}
