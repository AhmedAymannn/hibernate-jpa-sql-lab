package com.example.DAO;


import com.example.entity.Order;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JDBCDao {

        private final JdbcTemplate jdbcTemplate ;

        public JDBCDao(JdbcTemplate jdbcTemplate) {
                this.jdbcTemplate = jdbcTemplate;
        }

}
