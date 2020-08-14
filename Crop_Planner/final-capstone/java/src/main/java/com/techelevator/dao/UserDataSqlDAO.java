package com.techelevator.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.User;

@Component
public class UserDataSqlDAO implements UserDataDAO{
	private JdbcTemplate template;
	
	public UserDataSqlDAO(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}
	
	@Override
	public User createAccountUserData(User user) {
		String sql = "INSERT INTO user_data (user_id, first_name, last_name, email, city, state, zip) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		template.update(sql, user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getCity(), user.getState(), user.getZipcode());
		return user;
	}

	@Override
	public User getUserDataFromID(User user) {
		
		String sql = "SELECT * FROM user_data WHERE user_id=?";
		SqlRowSet rs = template.queryForRowSet(sql, user.getId());
		rs.next();
		User userData = mapRowToUser(rs);
		userData.setUsername(user.getUsername());
		return userData;
	}
	@Override
	public User editProfile(User user) {
		String sql = "UPDATE user_data SET "
				+ "first_name = ?, last_name = ?, email = ?, "
				+ "city = ?, state = ?, zip = ? "
				+ "WHERE user_id = ?";
		template.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(),
				 user.getCity(), user.getState(), user.getZipcode(), user.getId());
		
		return user;
	}
	
	@Override
	public void deleteProfile(int id) {
		String sql = "DELETE FROM user_data WHERE user_id = ?";
		template.update(sql, id);
			
	}
	
    private User mapRowToUser(SqlRowSet rs) {
        User user = new User();
        user.setId(rs.getLong("user_id"));
        user.setEmail(rs.getString("email"));
        user.setZipcode(rs.getString("zip"));
        user.setRegion(rs.getString("region"));
        user.setCity(rs.getString("city"));
        user.setState(rs.getString("state"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        return user;
    }

	
	
	
	
	
	

	
	
}
