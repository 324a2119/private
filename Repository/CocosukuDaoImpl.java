package com.example.cocosuku.Repository;

import com.example.cocosuku.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class CocosukuDaoImpl implements CocosukuDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final RowMapper<User> userRowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User u = new User();
            u.setUserid(rs.getInt("userid"));
            u.setName(rs.getString("name"));
            u.setEmail(rs.getString("email"));
            u.setPassword(rs.getString("password"));
            u.setProfileImage(rs.getString("profile_image"));
            return u;
        }
    };

    @Override
    public int insertUser(User user) {
        String sql = "INSERT INTO usertb (name, email, password, profile_image) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword(), user.getProfileImage());
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        String sql = "SELECT * FROM usertb WHERE email = ? AND password = ?";
        return jdbcTemplate.query(sql, userRowMapper, email, password)
                .stream().findFirst().orElse(null);
    }
}
