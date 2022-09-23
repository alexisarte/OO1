package ar.edu.unlp.info.oo1.ejercicio14;

import java.time.LocalDate;

public class DateLapseImpl2 implements IDateLapse {

	private LocalDate from;
	private long sizeInDays;

	public DateLapseImpl2(LocalDate from, long sizeInDays) {
		this.from = from;
		this.sizeInDays = sizeInDays;
	}

	public LocalDate getFrom() {
		return from;
	}

	public LocalDate getTo() {
		return this.getFrom().plusDays(this.sizeInDays);
	}

	public long sizeInDays() {
		return this.sizeInDays;
	}

	public boolean includesDate(LocalDate other) {
		return other.isAfter(this.getFrom()) && other.isBefore(this.getTo()) || this.getFrom().equals(other)
				|| this.getTo().equals(other);
	}

	@Override
	public boolean overlaps(IDateLapse anotherDateLapse) {
		return !(anotherDateLapse.getFrom().isBefore(this.getFrom())
				&& anotherDateLapse.getTo().isBefore(this.getFrom())
				|| anotherDateLapse.getFrom().isAfter(this.getTo()) && anotherDateLapse.getTo().isAfter(this.getTo()));
	}

}
