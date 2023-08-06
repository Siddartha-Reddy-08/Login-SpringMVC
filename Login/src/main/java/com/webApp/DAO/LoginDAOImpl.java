package com.webApp.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.webApp.DTO.UserData;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<UserData> loadUserData() {
		System.out.println("DAOIMPL");
		List<UserData> userdata = new ArrayList<UserData>();
		String sql = "SELECT * FROM user";
		try {
			userdata = jdbcTemplate.query(sql, new RowMapper() {
				@Override
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					UserData userData = new UserData();

					userData.setUsername(rs.getString("username"));
					userData.setPassword(rs.getString("password"));
					return userData;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("DAOIMPL 1");
		return userdata;
	}

}
