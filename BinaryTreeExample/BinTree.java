public class BinTree {
	BinTree left;
	BinTree right;
	BinTree parent;
	String value;
	private static int num = 0;

	public BinTree(String val) {
		this.value = val;
		this.left = null;
		this.right = null;
		num++;
	}

	public void setLeft(BinTree left) {
		this.left = left;
		this.left.parent = this;
	}

	public void setRight(BinTree right) {
		this.right = right;
		this.right.parent = this;
	}

	public int find(String val) {
		if (this.value.equals(val)) {
			return 0;
		}
		else {
			int l = 1, r = 1;
			if (this.left != null) {
				l = this.left.find(val);
			}
			if(this.right != null){
				r = this.right.find(val);
			}
			return l & r;
		}
	}

	public static int getNumberOfNodes() {
		return num;
	}
	
	public BinTree findNode(String val) {
		BinTree node = null;
		if (this.value.equals(val)) {
			return this;
		}
		else {
			BinTree nodeL = null, nodeR = null;
			if (this.left != null) {
				nodeL = this.left.findNode(val);
			}
			if(this.right != null){
				nodeR = this.right.findNode(val);
			}
			if (nodeL != null)
				node = nodeL;
			if (nodeR !=null)
				node = nodeR;
			return node;
		}
	}
	
	public int isSibling(String str1, String str2) {
		BinTree n1 = this.findNode(str1);
		BinTree n2 = this.findNode(str2);
		String p1, p2;
		if (n1 != null && n2 != null && n1.parent != null && n2.parent !=null) {
			p1 = n1.parent.value;
			p2 = n2.parent.value;
			if(p1.equals(p2)){
				return 0;
			}
			else {
				return 1;
			}
		}
		else
			return 1; 
	}
	
	public int isDescendent(String str1, String str2) {
		BinTree node = this.findNode(str1);
		BinTree desc = node.findNode(str2);
		if (desc == null) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public int getLevel(String str, int level) {
		BinTree node = this.findNode(str);
		if (node == null)
            		return 0;
 	        if (this == node)
 	        	return level;
 	        
	        int l = this.left.getLevel(str, level+1);
        	if (l != 0)
        		return l;
 
	        return this.right.getLevel(str, level+1);	
	}
	
	public boolean isCousin(String str1, String str2) {
		return((this.getLevel(str1,1)==this.getLevel(str2,1)) && (this.isSibling(str1,str2)!=0));	
	}
	
	public String getCommonAncestor(String str1,String str2) {
		BinTree node1 = this.findNode(str1);
		BinTree node2 = this.findNode(str2);
		if(node1==null || node2==null) {
			System.out.println("Either one or both the names are incorrect. Please try again.");
			return null;
		}
		if(isDescendent(str1, str2)==0) {
			return str1;
		}
		if(isDescendent(str2, str1)==0) {
			return str2;					
		}
		BinTree temp1=node1.parent,temp2=node2.parent;
		while(temp1!=null) {
			if(temp1==temp2)
				return temp1.value;
			temp2=temp2.parent;
			while(temp2!=null) {
				if(isDescendent(temp2.value, temp1.value)==0)
					return temp2.value;
				temp2=temp2.parent;
			}
		}
		return null;
	}
}
