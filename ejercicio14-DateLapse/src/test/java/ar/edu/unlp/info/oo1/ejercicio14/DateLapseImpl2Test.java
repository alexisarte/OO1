package ar.edu.unlp.info.oo1.ejercicio14;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateLapseImpl2Test {

	private IDateLapse periodo;
	private IDateLapse periodo2;
	private IDateLapse periodo3;
	private IDateLapse periodo4;
	private IDateLapse periodo5;
	private IDateLapse periodo6;
	private IDateLapse periodo7;
	
	@BeforeEach
	void setUp() throws Exception {
		this.periodo = new DateLapseImpl2(LocalDate.of(2001, 9, 11), 20);
		this.periodo2 = new DateLapseImpl2(LocalDate.of(2001, 9, 21), 5);
		this.periodo3 = new DateLapseImpl2(LocalDate.of(2001, 9, 4), 7);
		this.periodo4 = new DateLapseImpl2(LocalDate.of(2001, 9, 15), 5);
		this.periodo5 = new DateLapseImpl2(LocalDate.of(2001, 9, 10), 31);
		this.periodo6 = new DateLapseImpl2(LocalDate.of(2001, 8, 11), 30);
		this.periodo7 = new DateLapseImpl2(LocalDate.of(2001, 10, 2), 15);
	}

	@Test
	void sizeInDaysTest() {
		assertEquals(20, this.periodo.sizeInDays());
	}
	
	@Test
	void includesDateTest() {
		assertFalse(this.periodo.includesDate(LocalDate.of(2001, 9, 10)));
		assertTrue(this.periodo.includesDate(LocalDate.of(2001, 9, 11)));
		assertTrue(this.periodo.includesDate(LocalDate.of(2001, 9, 25)));
		assertTrue(this.periodo.includesDate(LocalDate.of(2001, 10, 1)));
		assertFalse(this.periodo.includesDate(LocalDate.of(2003, 9, 12)));
	}
	
	@Test
	void overlaps() {
		assertTrue(this.periodo.overlaps((DateLapseImpl2) this.periodo));
		assertTrue(this.periodo.overlaps((DateLapseImpl2) this.periodo2));
		assertTrue(this.periodo.overlaps((DateLapseImpl2) this.periodo3));
		assertTrue(this.periodo.overlaps((DateLapseImpl2) this.periodo4));
		assertTrue(this.periodo.overlaps((DateLapseImpl2) this.periodo5));
		assertFalse(this.periodo.overlaps((DateLapseImpl2) this.periodo6));
		assertFalse(this.periodo.overlaps((DateLapseImpl2) this.periodo7));
	}


}
