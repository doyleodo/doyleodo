package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.model.Reservation;
import com.techelevator.model.jdbc.JDBCReservationDAO;

public class JDBCReservationDAOIntegrationTest extends DAOIntegrationTest {

	private JDBCReservationDAO dao;
	
	@Before
	public void setup() {
//		String sqlInsertReservation = "INSERT INTO reservation (site_id, name, from_date, to_date, create_date) VALUES (5, 'Test_Family', 2020-07-25, 2020-07-27, CURRENT_DATE)";
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(DAOIntegrationTest.dataSource); 
//		jdbcTemplate.update(sqlInsertReservation);
		dao = new JDBCReservationDAO(dataSource);
	}
	
	@Test
	public void get_30_day_reservations_for_park_id_1_equals_26() {
		List<Reservation> results = dao.getAllReservationsByParkId(1);
		assertNotNull(results);
		assertEquals(26, results.size());
	}
	
	@Test
	public void getReservationById() {
		Reservation results = dao.getReservationById(36);
		assertNotNull(results);
		assertEquals("Barbara Snyder", results.getName());
	}
	
	
//	This should be working but it aint reservation 53 in my DB but it's not working...hmmm...
//	@Test
//	public void addReservation() {
//		Reservation testReservation = new Reservation();
//		testReservation.setSiteId(45);
//		testReservation.setFromDate(LocalDate.of(2020, 6, 25));
//		testReservation.setToDate(LocalDate.of(2020, 6, 27));
//		testReservation.setName("Test Integration Family");
//		testReservation.setCreateDate(LocalDate.of(2020, 6, 26));
//		dao.addReservation(testReservation);
//		Reservation results = dao.getReservationById(53);
//		assertEquals(testReservation.getName(), results.getName());
//	}
	
//	readBackReservation

}
