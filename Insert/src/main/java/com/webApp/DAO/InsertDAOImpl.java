package com.webApp.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.webApp.DTO.DisplayDTO;
import com.webApp.DTO.InputData;

@Repository
public class InsertDAOImpl implements InsertDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertUserData(InputData inputData) {

		System.out.println("Insert Data");

		String sql = "insert into insertdata(name,rollNo) value(?,?)";

		Object[] params = { inputData.getName(), inputData.getRollNo() };

		jdbcTemplate.update(sql, params);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DisplayDTO> loadInfo() {
		List<DisplayDTO> info = new ArrayList<DisplayDTO>();
		String sql = "SELECT * FROM insertdata ORDER BY rollNo";// ORDER BY rollNo
		try {
			info = jdbcTemplate.query(sql, new RowMapper() {
				@Override
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					DisplayDTO infodto = new DisplayDTO();

					infodto.setSno(rs.getInt("sno"));
					infodto.setName(rs.getString("name"));
					infodto.setRollNo(rs.getString("rollNo"));

					return infodto;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR");
		}
		System.out.println("Get Display Data");
		return info;
	}

}
