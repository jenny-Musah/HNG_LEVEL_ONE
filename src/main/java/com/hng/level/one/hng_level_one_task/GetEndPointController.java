package com.hng.level.one.hng_level_one_task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetEndPointController {


    @Autowired
     private GetEndPointServices getEndPointServices;


    @GetMapping("/api")
    public ResponseEntity<GetEndPointResponse> GetEndPoint(@RequestParam("slack_name") String slackName, @RequestParam("track") String track){
    return ResponseEntity.ok(getEndPointServices.getEndpoint(slackName,track));
    }
}
