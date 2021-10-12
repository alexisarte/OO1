package ar.edu.unlp.info.oo1.ejercicio10;

public class FIFOJobScheduler extends JobScheduler {

	@Override
	protected JobDescription retrieveNext() {
		return jobs.get(0);
	}

}
