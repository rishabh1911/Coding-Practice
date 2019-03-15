package advance.data.structure.heap;

public class Pair {
	
	int index1;
    int index2;
    
    Pair(int index1, int index2) {
        this.index1 = index1;
        this.index2 = index2;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index1;
		result = prime * result + index2;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Pair))
			return false;
		Pair other = (Pair) obj;
		if (index1 != other.index1)
			return false;
		if (index2 != other.index2)
			return false;
		return true;
	}
    
    

}
