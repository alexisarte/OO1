package ar.edu.unlp.info.oo1.ejercicio16;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse {

	private LocalDate from;
	private LocalDate to;

	public DateLapse(LocalDate from, LocalDate to) {
		this.from = from;
		this.to = to;
	}

	public LocalDate getFrom() {
		return from;
	}

	public LocalDate getTo() {
		return to;
	}

	public long sizeInDays() {
		return ChronoUnit.DAYS.between(this.getFrom(), this.getTo());
	}

	public boolean includesDate(LocalDate other) {
		return other.isAfter(this.getFrom()) && other.isBefore(this.getTo()) || this.getFrom().equals(other)
				|| this.getTo().equals(other);
	}

	public boolean overlaps(DateLapse anotherDateLapse) {
		return !(anotherDateLapse.getFrom().isBefore(this.getFrom()) && anotherDateLapse.getTo().isBefore(this.getFrom())
				|| anotherDateLapse.getFrom().isAfter(this.getTo()) && anotherDateLapse.getTo().isAfter(this.getTo()));
	}
	
}
