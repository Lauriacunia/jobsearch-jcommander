package com.letscodemom.api;

import com.letscodemom.JobPosition;
import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

import java.util.List;
import java.util.Map;

/**
 * This is a Feign client interface for the GitHub Jobs API.
 */
@Headers("Accept: application/json")
public interface APIJobs {
    @RequestLine("GET")
    List<JobPosition> jobs(@QueryMap Map<String, Object> queryMap);
}
