package com.broadcom.automic.graphql.controller;

import com.broadcom.automic.graphql.dao.StatusDao;
import com.broadcom.automic.graphql.types.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StatusController {

    @Autowired
    private StatusDao statusRepository;

    @QueryMapping
    public List<Status> allStatus(@Argument String id, @Argument String name) {
        return statusRepository.getAll(id, name);
    }
}
