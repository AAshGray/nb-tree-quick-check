import java.util.List;
import java.util.Map;
import java.util.Stack;

public class NbQuickCheck {

  /**
   * Performs a pre-order traversal of the tree, printing each node on a separate line.
   * Does nothing if the root is not present in the tree.
   *
   * @param tree the tree represented as a map of parent nodes to child lists
   * @param root the root node to start traversal from
   */
  public static void preOrder(Map<Integer, List<Integer>> tree, int root) {
    if(!tree.containsKey(root)) {
      return;
    }

    System.out.println(root);
    List<Integer> list = tree.get(root);
    if (list != null && !list.isEmpty()) {
      for (int i = 0; i < list.size(); i++) {
        preOrder(tree, list.get(i));
      }
    }
  }

  /**
   * Returns the minimum value in the tree.
   * Returns Integer.MAX_VALUE if the root is null.
   *
   * @param root the root node of the tree
   * @return the minimum value in the tree or Integer.MAX_VALUE if root is null
   */
  public static int minVal(Node<Integer> root) {
    int min = Integer.MAX_VALUE;

    if (root == null) return min;

    return minVal(root, min);
  }
  
  public static int minVal(Node<Integer> current, int min) {
    if (current == null) return min;

    if (current.value < min) min = current.value;

    if (current.children != null && !current.children.isEmpty()) {
      for (Node<Integer> child : current.children) {
        min = Math.min(minVal(child, min), min);
      }
    }

    return min;
  }

}
