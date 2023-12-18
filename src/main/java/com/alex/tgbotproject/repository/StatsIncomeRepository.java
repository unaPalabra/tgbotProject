package com.alex.tgbotproject.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class StatsIncomeRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public long getAllSumIncomUser (BigDecimal userId){
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("userID",userId);

    return namedParameterJdbcTemplate.
            queryForObject("SELECT SUM (income) FROM INCOMES WHERE CHAT_ID='userId'", parameters, new SumIncomeWrapper());
}

    private static final class SumIncomeWrapper implements RowMapper<Integer> {
        @Override
        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getInt("SUM");
        }
    }
}
