package com.broadcom.automic.graphql.dao;

import com.broadcom.automic.graphql.types.Status;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class StatusDao implements Dao<Status> {

    private NamedParameterJdbcTemplate template;

    public StatusDao(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Optional<Status> get(String id) {
        return getAll().stream().filter(status -> status.getId().equals(id)).findFirst();
    }

    @Override
    public List<Status> getAll() {


        return template.query("SELECT * FROM UC_ZUTYP", new ResultSetExtractor<List<Status>>() {

            @Override
            public List<Status> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Status> statusList = new ArrayList<>();

                while(rs.next()) {
                    String statusRange = rs.getString("zutyp_statusrange");
                    String statusName = rs.getString("zutyp_status");

                    Arrays.stream(statusRange.split(","))
                            .filter(str -> str.contains("-"))
                            .forEach(str -> {
                                int lowerBoundary = Integer.parseInt(str.substring(0, str.indexOf("-")));
                                int upperBoundary = Integer.parseInt(str.substring(str.indexOf("-") + 1));
                                for (int statusCode = lowerBoundary; statusCode <= upperBoundary; statusCode++) {
                                    statusList.add(new Status(String.valueOf(statusCode), statusName));
                                }
                            });

                    Arrays.stream(statusRange.split(","))
                            .filter(str -> !str.contains("-"))
                            .forEach(statusCode -> {
                                statusList.add(new Status(statusCode, statusName));
                            });
                }

                return statusList;
            }
        });
    }

    public List<Status> getAll(String id, String name) {
        return getAll();
    }
}

