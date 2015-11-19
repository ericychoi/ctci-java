package com.rookie1.Tree

import java.util.Stack;

public class Tree {
  public static void main(String[] args) {
    Node root = buildTree();
    inOrder(root);
    System.out.println("");
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
    Stack<Node> s= new Stack<Node>();
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

}
