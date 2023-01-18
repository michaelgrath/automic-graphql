package com.broadcom.automic.graphql.controller;

import com.broadcom.automic.graphql.dao.JobDao;
import com.broadcom.automic.graphql.types.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class JobController {

    @Autowired
    private JobDao jobRepository;

    @QueryMapping
    public Job jobById(@Argument String jobId) {
        return jobRepository.get(jobId).get();
    }
}