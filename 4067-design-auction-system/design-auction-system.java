class AuctionSystem {

    // itemId -> all bids for that item
    Map<Integer, TreeSet<int[]>> items;

    // userId -> (itemId -> bidAmount)
    Map<Integer, Map<Integer, Integer>> users;

    public AuctionSystem() {
        items = new HashMap<>();
        users = new HashMap<>();
    }

    public void addBid(int userId, int itemId, int bidAmount) {

        // If this user already has a bid on this item,
        // remove the old bid first.
        if (users.containsKey(userId)
                && users.get(userId).containsKey(itemId)) {

            removeBid(userId, itemId);
        }

        // Create user's map if it doesn't exist
        users.putIfAbsent(userId, new HashMap<>());

        // Store the new bid
        users.get(userId).put(itemId, bidAmount);

        // Create TreeSet for this item if necessary
        items.putIfAbsent(
            itemId,
            new TreeSet<>(
                (a, b) -> {
                    if (a[0] != b[0]) {
                        return Integer.compare(a[0], b[0]);
                    }

                    return Integer.compare(a[1], b[1]);
                }
            )
        );

        // Add [bidAmount, userId]
        items.get(itemId).add(
            new int[]{bidAmount, userId}
        );
    }

    public void updateBid(int userId, int itemId, int newAmount) {

        int oldAmount = users.get(userId).get(itemId);

        // Remove old [bidAmount, userId]
        items.get(itemId).remove(
            new int[]{oldAmount, userId}
        );

        // Add new [newAmount, userId]
        items.get(itemId).add(
            new int[]{newAmount, userId}
        );

        // Update HashMap
        users.get(userId).put(itemId, newAmount);
    }

    public void removeBid(int userId, int itemId) {

        int oldAmount = users.get(userId).get(itemId);

        // Remove from TreeSet
        items.get(itemId).remove(
            new int[]{oldAmount, userId}
        );

        // Remove from user's map
        users.get(userId).remove(itemId);
    }

    public int getHighestBidder(int itemId) {

        if (!items.containsKey(itemId)
                || items.get(itemId).isEmpty()) {

            return -1;
        }

        // Last element has:
        // highest bid amount
        // and highest userId in case of tie
        int[] highest = items.get(itemId).last();

        return highest[1];
    }
}