package com.techelevator;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.model.Park;
import com.techelevator.model.jdbc.JDBCParkDAO;

public class JDBCParkIntegrationTest extends DAOIntegrationTest {

	private JDBCParkDAO dao;
	
	@Before
	public void setup() {
//		String sqlInsert = "INSERT INTO site (campground_id, site_number, max_occupancy, accessible, max_rv_length, utilities) VALUES (7, 6, 5, true, 15, true)";
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(DAOIntegrationTest.dataSource); 
//		jdbcTemplate.update(sqlInsertCampground);
		dao = new JDBCParkDAO(dataSource);
	}
	
	
	@Test
	public void test_retrieve_all_parks() {
		List<Park> results = dao.getAllParks();
		assertNotNull(results);
		assertEquals(3, results.size());
	}
	
	@Test
	public void test_retrieve_park_id_2_returns_arches() {
		Park results = dao.getParkById(2);
		assertNotNull(results);
		assertEquals("Arches", results.getName());
	}

	@Test
	public void test_search_park_by_name_arches_returns_park_id_2() {
		List<Park> results = dao.searchParkByName("Arches");
		assertNotNull(results);
		assertEquals(2, results.get(0).getParkId());
	}
	

}
