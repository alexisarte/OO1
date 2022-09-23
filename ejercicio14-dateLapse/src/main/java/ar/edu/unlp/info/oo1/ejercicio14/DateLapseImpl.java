package ar.edu.unlp.info.oo1.ejercicio14;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapseImpl implements IDateLapse {

	private LocalDate from;
	private LocalDate to;

	public DateLapseImpl(LocalDate from, LocalDate to) {
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
		return other.isAfter(this.getFrom()) && other.isBefore(this.getTo()) || other.equals(this.getFrom())
				|| other.equals(this.getTo());
	}

	@Override
	public boolean overlaps(IDateLapse anotherDateLapse) {
		return !(anotherDateLapse.getFrom().isBefore(this.getFrom())
				&& anotherDateLapse.getTo().isBefore(this.getFrom())
				|| anotherDateLapse.getFrom().isAfter(this.getTo()) && anotherDateLapse.getTo().isAfter(this.getTo()));
	}

}
