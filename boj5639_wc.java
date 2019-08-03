package day0804;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_5639 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BinarySearchTree tree = new BinarySearchTree(Integer.parseInt(br.readLine()));
		String input = "";
		while( (input = br.readLine()) != null && input.length() != 0) {//EOF 만나지 않으면
			tree = tree.insertData(tree, Integer.parseInt(input));
		}
		//후위식으로 표현하기
		postOrder(tree);
		System.out.println(sb);
	
	}//end of main
	
	public static class BinarySearchTree{
		int data;
		BinarySearchTree left;
		BinarySearchTree right;
		//생성자
		BinarySearchTree(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	
		public static BinarySearchTree insertData(BinarySearchTree tree, int inputData) {
			BinarySearchTree newTree = null;
			if(tree == null) {
				return new BinarySearchTree(inputData);
			}
			if(tree.data > inputData) {
				newTree = insertData(tree.left, inputData);
				tree.left = newTree;
			} else if(tree.data < inputData) {
				newTree = insertData(tree.right, inputData);
				tree.right = newTree;
			}
			return tree;
		}
	}
	
	public static void postOrder(BinarySearchTree tree) {
		if(tree.left != null) {
			postOrder(tree.left);
		}
		if(tree.right != null) {
			postOrder(tree.right);
		}
		System.out.println(tree.data);
	}
}//end of class
