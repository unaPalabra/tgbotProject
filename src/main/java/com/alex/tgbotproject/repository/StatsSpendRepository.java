package com.alex.tgbotproject.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class StatsSpendRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public long getAllSumSpendUser(Long userId){
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("userID",userId);

        return namedParameterJdbcTemplate.
                queryForObject("SELECT SUM (spend) FROM spend WHERE CHAT_ID= :userID",  parameters, new SumSpendWrapper());
    }

    private static final class SumSpendWrapper implements RowMapper<Integer> {
        @Override
        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getInt("SUM");
        }
    }
}