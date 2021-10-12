package ar.edu.unlp.info.oo1.ejercicio10;

public class LIFOJobScheduler extends JobScheduler {

	@Override
	protected JobDescription retrieveNext() {
		return jobs.get(jobs.size() - 1);
	}

}
