class LockingTree {

    int[] parent;
    int[] locked;
    List<Integer>[] children;

    public LockingTree(int[] parent) {

        this.parent = parent;
        int n = parent.length;

        locked = new int[n];

        children = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        // Build the tree
        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }
    }

    // Lock node
    public boolean lock(int num, int user) {

        if (locked[num] != 0) {
            return false;
        }

        locked[num] = user;
        return true;
    }

    // Unlock node
    public boolean unlock(int num, int user) {

        if (locked[num] != user) {
            return false;
        }

        locked[num] = 0;
        return true;
    }

    // Upgrade node
    public boolean upgrade(int num, int user) {

        // Condition 1:
        // Node itself must be unlocked
        if (locked[num] != 0) {
            return false;
        }

        // Condition 2:
        // No locked ancestor
        int curr = parent[num];

        while (curr != -1) {

            if (locked[curr] != 0) {
                return false;
            }

            curr = parent[curr];
        }

        // Condition 3:
        // At least one locked descendant
        boolean found = unlockDescendants(num);

        if (!found) {
            return false;
        }

        // Lock current node
        locked[num] = user;

        return true;
    }

    // DFS to find and unlock locked descendants
    private boolean unlockDescendants(int node) {

        boolean found = false;

        for (int child : children[node]) {

            if (locked[child] != 0) {
                locked[child] = 0;
                found = true;
            }

            if (unlockDescendants(child)) {
                found = true;
            }
        }

        return found;
    }
}