package sortingAndSearching;

public class IntStreamN{
	protected TreeNode root;

	public void track(int x){
		if(root == null){
			this.root = new TreeNode(x, 0, null, null);
		}else{
			root.insert(x);
		}
	}

	public int getRankOfNumber(int x){
		if(this.root == null){
			return -1;
		}
		return this.root.find(x, 0);
	}




	public class TreeNode{
		public int key;
		public int leftSize;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int key, int leftSize, TreeNode left, TreeNode right){
			this.key = key;
			this.leftSize = leftSize;
			this.left = left;
			this.right = right;
		}

		public void insert(int x){
			if(this.key == x){
				TreeNode node = new TreeNode(x, this.leftSize, this.left, null);
				this.left = node;
				this.leftSize++;
			}else if(this.key < x){
				if(this.right != null){
					this.right.insert(x);
				}else{
					TreeNode node = new TreeNode(x, 0, null, null);
					this.right = node;
				}
			}else{
				// x < this.key
				if(this.left != null){
					this.left.insert(x);
				}else{
					TreeNode node = new TreeNode(x, 0, null, null);
					this.left = node;
				}
				this.leftSize++;
			}
		}

		// @note: sending count like this does not give you the most clear meaning of
		// what this recursive method does, so it's not the best approach in terms
		// of recursion
		// what find does here: find the rank of the number x in the whole tree, given
		// the count which is from it's parent on the left
		public int find(int x, int count){
			if(x == this.key){
				return count + this.leftSize;
			}else if(x < this.key){
				if(this.left != null){
					return this.left.find(x, count);
				}else{
					return -1;
				}
			}else{
				if(this.right != null){
					return this.right.find(x, count + this.leftSize + 1);
				}else{
					return -1;
				}
			}
		}
	}
}