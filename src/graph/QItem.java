package graph;

class Node {
	int data;
	Node left;
	Node right;

}

class QItem {
		Node node;
		int hd;

		QItem(Node node, int hd) {
			this.node = node;
			this.hd = hd;
		}
	}

	void topView(Node root) {
      if(root == null){
          return ;
      }
        Set<Integer> s = new HashSet<Integer>();
       QItem qi = new QItem(root, 0);
       Queue q = new Queue();
       qi.add(qi);
       
       Node node;
       int hd;
       while(!q.isEmpty()){
           qi = q.remove();
           node = qi.node;
           hd = qi.hd;
           
           if(!s.contains(hd)){
               s.add(hd);
               System.out.println(node.data + " ");
           }
           
           if(node.left != null){
               q.add(new QItem(node, hd - 1));
           }
           
           if(node.right != null){
               q.add(new QItem(node, hd + 1));
           }
       }
      
      
    }
