import java.util.StringTokenizer;

/*
 *
 * YOU NEED TO IMPLEMENT THIS!
 *
 */
public class PriorityQueueImpl implements PriorityQueue<String,String> {

	private int size = 0;
	Entry<String,String>[] entries = new ConcreteEntry[size];

	/**
	 * Returns the number of items in the priority queue.
	 *
	 * @return number of items
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Tests whether the priority queue is empty.
	 *
	 * @return true if the priority queue is empty, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Inserts a key-value pair and returns the entry created.
	 *
	 * @param key   the key of the new entry
	 * @param value the associated value of the new entry
	 * @return the entry storing the new key-value pair
	 * @throws IllegalArgumentException if the key is unacceptable for this queue
	 */
	@Override
	public Entry<String, String> insert(String key, String value) throws IllegalArgumentException {
		if (key == null || value == null ) throw new IllegalArgumentException();
		Entry<String, String> entry = new ConcreteEntry(key,value);
		this.size += 1;
		int index = findInsertIndex(entry);

		// Can optimize the and statement
		Entry<String, String>[] entries2 = (size == entries.length && (entries.length != 0)) ? new ConcreteEntry[entries.length*200] : new ConcreteEntry[entries.length+1];

		if (entries.length - 1 - index >= 0)
			System.arraycopy(entries, index + 1, entries2, index + 1 + 1, entries.length - 1 - index);

		entries2[index] = entry;
		this.entries = entries2;

		return entry;
	}

	private int findInsertIndex(Entry<String, String> entry) {
		return (size == 0) ? 0 : findFreeIndex(entry);
	}

	private int findFreeIndex(Entry<String, String> entry) {
		String key = entry.getKey();
		for (int i = 0; i < entries.length; i++) {
			if (entries[i] != null)
				if (key.compareTo(entries[i].getKey()) > 0 ) {
					return i;
				}
		}
		return entries.length;
	}

	/**
	 * Returns (but does not remove) an entry with minimal key.
	 *
	 * @return entry having a minimal key (or null if empty)
	 */
	@Override
	public Entry<String, String> min() {
		return (size == 0) ? null : entries[0];
	}

	/**
	 * Removes and returns an entry with minimal key.
	 *
	 * @return the removed entry (or null if empty)
	 */
	@Override
	public Entry<String, String> removeMin() {
		if (size == 0) return null;

		Entry<String, String> entry = entries[0];
		// Create a new array with an incremented size
		this.size -= 1;
		Entry<String,String>[] destination = new ConcreteEntry[size];
		// Copy all elements of entry into destination
		System.arraycopy(entries, 1, destination, 0, entries.length-1);
		this.entries = destination;
		return entry;
	}
	String n = null;
	public String[] toArray() {
		StringBuilder sb = new StringBuilder();
		for (Entry<String, String> entry : entries) {
			if (entry != null) {
				sb.append(entry.getKey());
				sb.append(n);
			}
		}

		return sb.toString().split("null");
	}

}