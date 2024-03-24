package oy.tol.tra;

public class KeyValueBSearchTree<K extends Comparable<K>, V> implements Dictionary<K, V> {

    // This is the BST implementation, KeyValueHashTable has the hash table
    // implementation

    private TreeNode<K, V> root;
    private int count = 0;
    private int maxTreeDepth = 0;

    @Override
    public Type getType() {
        return Type.BST;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String getStatus() {
        String toReturn = "Tree has max depth of " + maxTreeDepth + ".\n";
        toReturn += "Longest collision chain in a tree node is " + TreeNode.longestCollisionChain + "\n";
        TreeAnalyzerVisitor<K, V> visitor = new TreeAnalyzerVisitor<>();
        root.accept(visitor);
        toReturn += "Min path height to bottom: " + visitor.minHeight + "\n";
        toReturn += "Max path height to bottom: " + visitor.maxHeight + "\n";
        toReturn += "Ideal height if balanced: " + Math.ceil(Math.log(count)) + "\n";
        return toReturn;
    }

    @Override
    public boolean add(K key, V value) throws IllegalArgumentException, OutOfMemoryError {
        // Remember null check.
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null!");
        }
        // If root is null, should go there.
        if (root == null) {
            root = new TreeNode<>(key, value);
            count++;
            return true;
        }

        // update the root node. But it may have children
        // so do not just replace it with this new node but set
        // the keys and values for the already existing root.

        int hash = key.hashCode();
        int added = root.insert(key, value, hash);

        // Update the maximum tree depth
        int currentDepth = TreeNode.currentAddTreeDepth;
        if (currentDepth > maxTreeDepth) {
            maxTreeDepth = currentDepth;
        }
        TreeNode.currentAddTreeDepth = 0;

        if (added > 0) {
            count++;
            return true;
        }

        return false;
    }

    @Override
    public V find(K key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null!");
        }

        if (root == null) {
            return null;
        }

        int hash = key.hashCode();
        return root.find(key, hash);
    }

    @Override
    public void ensureCapacity(int size) throws OutOfMemoryError {
        // Nothing to do here. Trees need no capacity.
    }

    @Override
    public Pair<K, V>[] toSortedArray() {
        TreeToArrayVisitor<K, V> visitor = new TreeToArrayVisitor<>(count);
        root.accept(visitor);
        Pair<K, V>[] sorted = visitor.getArray();
        Algorithms.fastSort(sorted);
        return sorted;
    }

    @Override
    public void compress() throws OutOfMemoryError {
        // Nothing to do here, since BST does not use extra space like array based structures.
    }
}