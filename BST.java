import java.util.Random;
import java.util.Scanner;

class Tree {
    private int info = 0;
    private Tree left = null;
    private Tree right = null;

    public Tree(int info, Tree left, Tree right){
        this.info = info;
        this.left = left;
        this.right = right;
    }

    public Tree(int info){
        this(info, null, null);
    }

    public Tree(){
        this(0, null, null);
    }

    public int getInfo(){
        return this.info;
    }

    public void setInfo(int info){
        this.info = info;
    }

    public Tree getLeft(){
        return this.left;
    }

    public Tree getRight(){
        return this.right;
    }

    public void setLeft(Tree node){
        this.left = node;
    }

    public void setRight(Tree node){
        this.right = node;
    }
}

public class BST {
    private Tree root;
    public String trav="";

    public BST(){
        root = null;
    }

    //INSERT
    public void insert(int info){
        root = insertRec(root, info);
    }

    public Tree insertRec(Tree root, int info){
        if(root == null){
            return new Tree(info);
        }

        if(info < root.getInfo()){
            root.setLeft(insertRec(root.getLeft(), info));
        }else if(info >= root.getInfo()){
            root.setRight(insertRec(root.getRight(), info));
        }

        return root;
    }

    //PRE-ORDER TRAV
    public void preorder(){
        preorderRec(root);
        System.out.print("\n");
    }

    public void preorderRec(Tree root){
        if(root == null){
            System.out.print(" - ");
            return;
        }

        System.out.print(" " + root.getInfo() + " ");

        if(root.getRight() != null || root.getLeft() != null){
            System.out.print("[");
            preorderRec(root.getLeft());
            preorderRec(root.getRight());
            System.out.print("]");
        }
    }

    //PRE-ORDER SEARCH
    public boolean preorderSearch(int num){
        System.out.print(num + ": (");
        boolean found = preorderSearchRec(root, num);
        if(found){
            System.out.print(trav + ") Found!");
            return true;
        }else{
            System.out.print(trav.substring(0, trav.length() - 1) + ") Not Found!");
            return false;
        }
    }

    public boolean preorderSearchRec(Tree root, int num){
        if(root == null) return false;

        if(num == root.getInfo()){
            return true;
        }else if(num < root.getInfo()){
            trav += "L";
            return preorderSearchRec(root.getLeft(), num);
        }else if(num > root.getInfo()){
            trav += "R";
            return preorderSearchRec(root.getRight(), num);
        }

        return false;
    }

    //GET HEIGHT
    public int height(){
        return heightRec(root);
    }

    public static int heightRec(Tree root){
        if(root == null) return -1;

        int left = heightRec(root.getLeft());
        int right = heightRec(root.getRight());

        if(left > right){
            return left + 1;
        }else{
            return right + 1;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        BST tree = new BST();
        Scanner scan = new Scanner(System.in);
        
        int n = random.nextInt(11) + 10;
        System.out.println("--- Random number [" + n + "] ---");

        for(int i=0; i<n; i++){
            int num = random.nextInt(51);
            System.out.print(num + " ");
            tree.insert(num);
        }
        System.out.println();

        System.out.println("--- Tree (Height=" + tree.height() + ") ---");
        tree.preorder();

        System.out.println("--- Search ---");
        while(true){
            int numSearch = random.nextInt(51);
            if(tree.preorderSearch(numSearch)) break;    
            System.out.println();
        }
    }
}

