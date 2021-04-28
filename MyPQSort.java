/*
 * IMPLEMENT YOUR SORT USING YOUR PRIORITY QUEUE HERE
 */
public class MyPQSort {
	
	PriorityQueue<String,String> myQueue = new PriorityQueueImpl();

	public String[] sort(String[] stringListToSort) throws Exception {
		for (String s : stringListToSort) {
			myQueue.insert(s,s);
		}
		return ((PriorityQueueImpl) myQueue ).toArray();
	}
	
}