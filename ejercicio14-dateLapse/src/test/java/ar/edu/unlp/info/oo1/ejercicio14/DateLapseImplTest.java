package ar.edu.unlp.info.oo1.ejercicio14;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateLapseImplTest {
	
	private IDateLapse periodo;
	private IDateLapse periodo2;
	private IDateLapse periodo3;
	private IDateLapse periodo4;
	private IDateLapse periodo5;
	private IDateLapse periodo6;
	private IDateLapse periodo7;
	
	@BeforeEach
	void setUp() throws Exception {
		this.periodo = new DateLapseImpl(LocalDate.of(2001, 9, 11), LocalDate.of(2001, 10, 1));
		this.periodo2 = new DateLapseImpl(LocalDate.of(2001, 9, 21), LocalDate.of(2001, 9, 26));
		this.periodo3 = new DateLapseImpl(LocalDate.of(2001, 9, 4), LocalDate.of(2001, 9, 11));
		this.periodo4 = new DateLapseImpl(LocalDate.of(2001, 9, 15), LocalDate.of(2001, 9, 20));
		this.periodo5 = new DateLapseImpl(LocalDate.of(2001, 9, 10), LocalDate.of(2001, 10, 1));
		this.periodo6 = new DateLapseImpl(LocalDate.of(2001, 8, 11), LocalDate.of(2001, 8, 15));
		this.periodo7 = new DateLapseImpl(LocalDate.of(2001, 10, 2), LocalDate.of(2001, 10, 17));
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
		assertTrue(this.periodo.overlaps((DateLapseImpl) this.periodo));
		assertTrue(this.periodo.overlaps((DateLapseImpl) this.periodo2));
		assertTrue(this.periodo.overlaps((DateLapseImpl) this.periodo3));
		assertTrue(this.periodo.overlaps((DateLapseImpl) this.periodo4));
		assertTrue(this.periodo.overlaps((DateLapseImpl) this.periodo5));
		assertFalse(this.periodo.overlaps((DateLapseImpl) this.periodo6));
		assertFalse(this.periodo.overlaps((DateLapseImpl) this.periodo7));
	}

}
