package com.broadcom.automic.graphql.dao;

import com.broadcom.automic.graphql.types.Job;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JobDao implements Dao<Job> {

    @Override
    public Optional<Job> get(String id) {
        Job job = new Job();
        job.setId(id);
        job.setName("Mein erster Job");
        return Optional.of(job);
    }

    @Override
    public List<Job> getAll() {
        return null;
    }

}
