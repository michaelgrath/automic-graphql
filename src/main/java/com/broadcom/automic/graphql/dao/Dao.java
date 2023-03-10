package com.broadcom.automic.graphql.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> get(String id);

    List<T> getAll();

}
