package com.broadcom.automic.graphql.types;

import lombok.Data;

@Data
public class Status {

    public Status(String id, String name) {
        this.id = id;
        this.name = name;
    }

    private String id;
    private String name;

}
