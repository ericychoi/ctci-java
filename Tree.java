import java.util.Stack;
import java.util.LinkedList;

public class Tree {
  public static void main(String[] args) {
    Node root = buildTree();
    System.out.println("in:");
    inOrder(root);
    System.out.println("\npre:");
    preOrder(root);
    System.out.println("\npost:");
    postOrder(root);
    System.out.println("\nBFS:");
    BFS(root);
  }

  static Node buildTree() {
    Node a = new Node("a");
    Node b = new Node("b");
    Node c = new Node("c");
    Node d = new Node("d");
    Node e = new Node("e");
    Node f = new Node("f");
    Node g = new Node("g");
    Node h = new Node("h");
    Node i = new Node("i");

    f.L = b;
    f.R = g;
    b.L = a;
    b.R = d;
    d.L = c;
    d.R = e;
    g.R = i;
    i.L = h;

    return f;
  }

  public static class Node {
    Node L;
    Node R;
    String value;

    Node(String v) {
      this.value = v;
    }

    void visit() {
      System.out.print(this.value + " ");
    }
  }

  static void inOrder(Node root) {
    Stack<Node> s = new Stack<Node>();
    Node n = root;
    while (!(n == null && s.isEmpty())) {
      if (n != null) {
        s.push(n);
        n = n.L;
      }
      else {
        n = s.pop();
        n.visit();
        n = n.R;
      }
    }
  }

  static void preOrder(Node root) {
    Stack<Node> s = new Stack<Node>();
    Node n = root;
    while (!(n == null && s.isEmpty())) {
      if (n != null) {
        n.visit();
        if (n.R != null) {
          s.push(n.R);
        }
        n = n.L;
      }
      else {
        n = s.pop();
      }
    }
  }

  static void postOrder(Node root) {
    Stack<Node> s = new Stack<Node>();
    Node lastVisited = null;
    Node n = root;
    while (!(n == null && s.isEmpty())) {
      if (n != null) {
        s.push(n);
        n = n.L;
      }
      else {
        n = s.peek();
        if (n.R != null && n.R != lastVisited) {
          n = n.R;
        }
        else {
          n.visit();
          s.pop();
          lastVisited = n;
          n = null;
        }
      }
    }
  }

  static void BFS (Node root) {
    LinkedList<Node> q = new LinkedList<Node>();
    q.add(root);
    while (q.size() != 0) {
      Node n = q.remove();
      n.visit();
      if (n.L != null) {
        q.add(n.L);
      }
      if (n.R != null) {
        q.add(n.R);
      }
    }
  }
}
