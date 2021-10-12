package ar.edu.unlp.info.oo1.ejercicio10;

//import java.util.Comparator;

public class HighestPriorityJobScheduler extends JobScheduler {

	@Override
	protected JobDescription retrieveNext() {
		return jobs.stream().max((j1, j2) -> Double.compare(j1.getPriority(), j2.getPriority())).orElse(null);
	}

//	Comparator<Integer> comparadorEnteros = new Comparator<Integer>() {
//		@Override
//		public int compare(Integer o1, Integer o2) {
//			if (o1 > o2)
//				return -1;	// El primero es prioritario, es decir es mayor
//			else
//				return 1;	// El segundo es prioritario, es decir es mayor
//		}
//	};

}
