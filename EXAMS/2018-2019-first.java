//Exercise 1

public boolean validaTags(String[] tags){
	if (tags == null) return false;
	
	if (tags[0] == null) return false;
	
	int result = validaTags(tags[0], tags, 1);
	
	if (result != -1) return true;
	return false;
}

private int validaTags(String previousTag, String[] tags, int pos){
	if (tags.size < pos + 1) return false;
	
	while (true){
		if (previousTag.equals(tags[pos].replaceAll("/", ""))) return (pos + 1);
		
		if (tags.size == pos) return -1;
		
		pos = validaTags(tags[pos], tags, pos + 1);
	}
	
	return -1;
}


//Exercise 2

	/*
		a)
			Purpose: Obtains the maximum difference between 2 numbers, considering that the lower number is prior than the highest number in the list.
			Result of the example: 8.
		
		b)	This algorithm have an complexity of O(n^2); That's due to the second for cycle, that is dependent from the first for cycle. The value of i increments each time the first for cycle, that causes an increment of time complexity, that, in large numbers, can be considered n.
		
	*/


//Exercise 3

public	static<V,E>	Graph<V,E>	kruskall(Graph<V,E>	g){
	Graph<V,E> kg = new Graph<V,E>;
	for (V vertex : g.vertices){
		kg.insertVertex(vertex);
	}
	
	Iterable<Edge<V,E>> edges = g.edges();
	ArrayList<Edge<V,E>> listEdges = new ArrayList<>();
	edges.forEach(listEdges::add);
	
	Collections.sort(listEdges);
	
	for (Edge<V,E> edge : listEdges){
		if (shortestPath(kg, edge.getVOrig(), edge.getVDest()) < 0) kg.insertEdge(edge.getVOrig, edge.getVDest, edge.getElement(), edge.getWeight());
	}
	
	return kg;
}
	
//Exercise 4	

public Map<Integer, List<E>> completeMinimalSubBST(E value1, E value2){
	if (value2 < value1){
		E temp = value2;
		value2 = value1;
		value1 = temp;
	}
	Node<E> root = this.root();
	boolean flag = true;
	while(flag){
		if (value1 <= root.getElement() && root.getElement() <= value2) flag = false;
		else if (value2 < root) root = root.getLeft();
		else root = root.getRight;
	}
	
	Map<Integer, List<E>> result = new TreeMap<Integer, List<E>>();
	
	processBstByLevel(root, result, 0);
	
	return result;
}

//Exercise 5

public List<V>	getElemsPath(int idx){
	int parent = idx;
	List<V> finalList = new ArrayList<>();
	finalList.add(this.heap.get(parent).getValue());
	do
	parent = parent(parent);
	finalList.add(this.heap.get(parent).getValue());
	while (parent != 0);
	return list;
}