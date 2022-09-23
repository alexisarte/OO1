package ar.edu.unlp.info.oo1.ejercicio14;

import java.time.LocalDate;

public interface IDateLapse {

	LocalDate getFrom();
	
	LocalDate getTo();
	
	long sizeInDays();
	
	boolean includesDate(LocalDate other);

	boolean overlaps(IDateLapse anotherDateLapse);
	
}
