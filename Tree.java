
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Tree<T extends Comparable> {

  private TreeNode<T> root;

  public Tree() {
    root = null;
  }

  public void addNode(T value) {
    TreeNode<T> new_node = new TreeNode<T>(value);

    if (root == null) {
      root = new_node;
    }
    else {
      TreeNode<T> current_node = root;
      while (current_node != null) {
        if (new_node.getValue().compareTo(current_node.getValue()) < 0) {
          if (current_node.getLeftChild() == null) {
            current_node.addLeftChild(new_node);
            return;
          }
          else {
            current_node = current_node.getLeftChild();
          }
        }
        else {
          if (current_node.getRightChild() == null) {
            current_node.addRightChild(new_node);
            return;
          }
          else {
            current_node = current_node.getRightChild();
          }
        }
      }
    }
  }

  public TreeNode<T> getRoot(){
	  return root;
  }

  private boolean containsElement = false;

  public void checkTreeHelper(TreeNode<T> currentNode, T element){
	  if(currentNode != null){
		  if(!currentNode.getValue().equals(element)){
			  checkTreeHelper(currentNode.getLeftChild(), element);
			  checkTreeHelper(currentNode.getRightChild(), element);
		  }
		  else{
			  containsElement = true;
		  }
	  }
  }

  public boolean checkTree(T element){
	  checkTreeHelper(root,element);
	  return containsElement;
  }

  private void inorderTraversalHelper(TreeNode<T> current_node) {
    if (current_node != null) {
      inorderTraversalHelper(current_node.getLeftChild());
      System.out.println(current_node);
      inorderTraversalHelper(current_node.getRightChild());
    }
  }

  public void inorderTraversal(){
    inorderTraversalHelper(root);
  }

  public boolean isEmpty(){
	  if(root==null){
		  return true;
	  }
	  else{
		  return false;
	  }
  }

  private int nodeCount = 0;

  public void getSizeHelper(TreeNode<T> currentNode){
	  if(currentNode != null){
		 nodeCount++;
		 getSizeHelper(currentNode.getLeftChild());
		 getSizeHelper(currentNode.getRightChild());
	  }
  }

  public int getSize(){
	  getSizeHelper(root);
	  return nodeCount;
  }

  private int levelCount = 1;

  public void getHeightHelper(TreeNode<T> currentNode){
	  if(currentNode != null){
		  if(currentNode.getLeftChild()!=null||currentNode.getRightChild()!=null){
			  levelCount++;
		  }
		  getHeightHelper(currentNode.getLeftChild());
		  getHeightHelper(currentNode.getRightChild());
	  }
  }

  public int getHeight(){
	  if(root!=null){
		  getHeightHelper(root);
		  return levelCount;
	  }
	  else{
		  return levelCount;
	  }
  }


  public void isBalancedHelper(Tree<T> newTree, TreeNode<T> currentNode){
	  if(currentNode != null){
		  newTree.addNode(currentNode.getValue());
		  isBalancedHelper(newTree, currentNode.getLeftChild());
		  isBalancedHelper(newTree, currentNode.getRightChild());
	  }
  }

  public boolean isBalanced(){
	  Tree<T> leftTree = new Tree();
	  Tree<T> rightTree = new Tree();
	  if(root!=null){
	  	isBalancedHelper(leftTree, root.getLeftChild());
	  	isBalancedHelper(rightTree, root.getRightChild());
	  	if(leftTree.getHeight()==rightTree.getHeight()){
	  		return true;
	  	}
	  	else{
	  		return false;
	  	}
	  }
	  else{
		  return true;
	  }
  }

  public void removeHelper(TreeNode<T> currentNode, T element){
	  boolean contains;
	  if(currentNode != null){
		  if(!currentNode.getValue().equals(element)){
			  checkTreeHelper(currentNode.getLeftChild(), element);
			  checkTreeHelper(currentNode.getRightChild(), element);
		  }
		  else{
			  contains = true;
		  }
	  }
  }

  void printLevelOrder()
  {
      int h = getHeight();
      int i;
      for (i=1; i<=h; i++)
          printGivenLevel(root, i);
  }

 public void printGivenLevel (TreeNode first ,int level)
  {
      if (first == null){
    	  return;
      }
      if (level == 1){
    	  System.out.print(first.getValue() + " ");
      }
      else if (level > 1)
      {
          printGivenLevel(first.getLeftChild(), level-1);
          printGivenLevel(first.getRightChild(), level-1);
      }
  }

 public void preOrder (TreeNode first)
 {

   if(first == null){
	   return;
   }

   System.out.println(first.getValue());
   preOrder( first.getLeftChild() );
   preOrder( first.getRightChild() );

 }

 public void postOrder (TreeNode first)
 {

   if(first == null){
	   return;
   }

   postOrder( first.getLeftChild() );
   postOrder( first.getRightChild() );
   System.out.println(first.getValue());

 }
 
}
