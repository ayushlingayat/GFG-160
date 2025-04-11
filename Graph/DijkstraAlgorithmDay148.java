class Solution {
    public ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        int V = adj.size();

        ArrayList<Integer> dist = new ArrayList<>(Collections.nCopies(V, (int) 1e9));

        PriorityQueue<iPair> pq = new PriorityQueue<>(
                Comparator.comparingInt((iPair p) -> p.second).thenComparing((p -> p.first))
        ); // new iPair(node, distance)

        pq.add(new iPair(src, 0));
        dist.set(src, 0);

        while (!pq.isEmpty()) {
            iPair poll = pq.poll();
            int node = poll.first;
            int distance = poll.second;

            for (iPair neighbour : adj.get(node)) {
                int neighbourNode = neighbour.first;
                int neighbourDistance = neighbour.second;

                if (distance + neighbourDistance < dist.get(neighbourNode)) {
                    dist.set(neighbourNode, distance + neighbourDistance);
                    pq.add(new iPair(neighbourNode, dist.get(neighbourNode)));
                }
            }
        }

        return dist;
    }
}