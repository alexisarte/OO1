package ar.edu.unlp.info.oo1.ejercicio10;

import java.util.ArrayList;
import java.util.List;

public abstract class JobScheduler {
	
	protected List<JobDescription> jobs;

	public JobScheduler() {
		this.jobs = new ArrayList<>();
	}

	public void schedule(JobDescription job) {
		this.jobs.add(job);
	}

	public void unschedule(JobDescription job) {
		if (job != null) {
			this.jobs.remove(job);
		}
	}

	public List<JobDescription> getJobs() {
		return jobs;
	}
	
	protected abstract JobDescription retrieveNext();
	
	public JobDescription next() {
		JobDescription nextJob = this.retrieveNext();
		this.unschedule(nextJob);
		return nextJob;
	}

}
