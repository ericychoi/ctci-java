// 17.13
public class BiNode {
  public BiNode node1, node2;
  public int data;
  public static void main (String[] args) {
    BiNode root = buildTree();
    System.out.println("after:");
    BiNode head = convert(root);
    head.print();
  }

  public BiNode (int d){
    this.data = d;
  }

  void print() {
    BiNode n = this;
    BiNode prev = null;
    while (n != null) {
      System.out.print(n.data + " ");
      if (n.node1 != null && n.node1 != prev) {
        prev = n;
        n = n.node1;
      }
      else if (n.node2 != prev) {
        prev = n;
        n = n.node2;
      }
      else {
        n = null;
      }
    }
    System.out.println("");
  }

  static BiNode buildTree() {
    BiNode a = new BiNode(3);
    BiNode b = new BiNode(1);
    BiNode c = new BiNode(4);
    BiNode d = new BiNode(2);
    BiNode e = new BiNode(5);

    a.node1 = b;
    a.node2 = c;
    c.node1 = d;
    d.node2 = e;

    return a;
  }

  static BiNode convert (BiNode n, BiNode p) {
    BiNode rv = n;
    // preserve the original pointers for traversal
    BiNode originalN1 = n.node1;
    BiNode originalN2 = n.node2;

    System.out.println("visiting " + n.data);
    if (n.node1 == null) {
      n.node1 = p;
      System.out.println("pointing n.node1 => " + p.data);

      if (n.node2 == null) {
        System.out.println("returning " + n.data);
        return n;
      }
    }
    else if (n.node2 == null) {
      n.node2 = p;
      System.out.println("pointing n.node2 => " + p.data);
    }

    if (originalN1 != null) {
      System.out.println("calling n.node1, " + n.data);
      rv = convert (originalN1, n);
    }
    if (originalN2 != null) {
      System.out.println("calling n.node2, " + n.data);
      rv = convert (originalN2, n);
    }

    return rv;
  }

  // will return a "tail" (or head)
  static BiNode convert(BiNode n) {
    BiNode rv = null;
    if (n.node1 != null) rv = convert (n.node1, n);
    if (n.node2 != null) rv = convert (n.node2, n);

    return rv;
  }
}
