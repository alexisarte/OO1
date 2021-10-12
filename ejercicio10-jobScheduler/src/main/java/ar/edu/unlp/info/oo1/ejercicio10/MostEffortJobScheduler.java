package ar.edu.unlp.info.oo1.ejercicio10;

public class MostEffortJobScheduler extends JobScheduler {

	@Override
	protected JobDescription retrieveNext() {
		return jobs.stream().max((j1, j2) -> Double.compare(j1.getEffort(), j2.getEffort())).orElse(null);
	}

}
