/*
HashMap + ArrayList
Insert

Add value -> its index into dictionary, average O(1) time.

Append value to array list, average \O(1) time as well.

Delete

Retrieve an index of element to delete from the hashmap.

Move the last element to the place of the element to delete, O(1) time.

Pop the last element out,O(1) time.

GetRandom could be implemented in O(1) time with the help of standard  and Random object in Java.

*/
class RandomizedSet {
	// map contains value with it's index
	Map<Integer, Integer> map;
	// contains values
	List<Integer> allValues;
    private Random random = new Random();

	public RandomizedSet() {
		map = new HashMap<>();
		allValues = new ArrayList<>();
	}

	public boolean insert(int val) {
        //insert an element only if it is not present, if it is already present return
		if (map.containsKey(val)) return false;

        //other wise add to the list
		allValues.add(val);
		// keep track of index in array
		map.put(val, allValues.size() - 1);

		return true;
	}

	public boolean remove(int val) {
		if (!map.containsKey(val)) return false;

        /*We know one thing that remove last element from a arraylist is O(1) operation .
will try to remove in such a way that we will get the idx of value which to be remove in arraylist and then swap it with last value in arraylist and then remove (O(1)).
we need to store every value with their index . -> HashMap<Integer,Integer> best fit.
If getrandom function was not there then we can solve it using hashmap only just remove the value and insert the value in O(1) but because of getRandom we need to maintain values in arraylist.

public E set(int index, E element)
Parameters: This method takes the following argument as a parameter.

index- index of the element to replace
element- element to be stored at the specified position
        */
		// set the index of val with last element
        
        //replace the value to be deleted by the last element and remove the last element afterwards.update map
		allValues.set(map.get(val), allValues.get(allValues.size() - 1));
		// update index in map
		map.put(allValues.get(allValues.size() - 1), map.get(val));

		map.remove(val);
		// O(1) remove
		allValues.remove(allValues.size() - 1);

		return true;
	}

	public int getRandom() {
		// [0, size - 1]
        return allValues.get(random.nextInt(allValues.size()));
	}
}
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */