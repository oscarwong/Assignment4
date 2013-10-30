
public class MyDisjSets implements DisjointSets{
	private int [] arr;
	
	/**
	 * Required constructor.
	 * @param numElements is the total number of elements, each element is initially in its own set.
	 */
	public MyDisjSets(int numElements) {
		arr = new int[numElements];
		for (int i = 1; i <= numElements; i++) {
			arr[i] = -1;
		}
	}
	
	@Override
	public void union(int set1, int set2) {
		try {
			find(set1);
			find(set2);
		} catch (InvalidElementException e) {
			throw new InvalidSetNameException();
		}
		if (arr[set2] < arr[set1]) {
			arr[set1] = set2;
		} else {
			if (arr[set1] == arr[set2]) {
				arr[set1] = set2;
			}
			arr[set2] = set1;
		}
	}

	@Override
	public int find(int val) {
		if (val > arr.length - 1 || val <= 0) {
			throw new InvalidElementException();
		}
		int root = val;
		while (arr[val] > 0) {
			val = arr[val];
		}
		if (val == root) {
			return root;
		}
		int oldParent = arr[val];
		while (oldParent != root) {
			arr[val] = root;
			val = oldParent;
			oldParent = arr[val];
		}
		return val;
	}

	@Override
	public int numSets() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isSetName(int x) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int numElements(int setNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void printSet(int setNum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int[] getElements(int setNum) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
