import java.util.*;

public class RecommendationSystem{
    private HashMap<String, HashSet<String>> userProductMap;

    public RecommendationSystem(){
        userProductMap = new HashMap<>();
    }

    //menambah relasi antara pelanggan dengan produk yang dibeli
    public void addPurchase(String user, String product){
        if(!userProductMap.containsKey(user)){
            userProductMap.put(user, new HashSet<>());
        }

        userProductMap.get(user).add(product);
    }

    //algoritma BFS
    public HashSet<String> recommendProducts(String targetUser){
        HashSet<String> recommendedProducts = new HashSet<>();
        HashSet<String> visitedUser = new HashSet<>();
        HashSet<String> targetUserProducts = userProductMap.getOrDefault(targetUser, new HashSet<>());
        Queue<String> queue = new LinkedList<>();

        queue.offer(targetUser);
        visitedUser.add(targetUser);

        while(!queue.isEmpty()){
            String currentUser = queue.poll();
            HashSet<String> currentProducts = userProductMap.get(currentUser);

            if(currentProducts != null){
                for(String product : currentProducts){
                    if (!targetUserProducts.contains(product)) {
                        recommendedProducts.add(product);
                    }

                    for(Map.Entry<String, HashSet<String>> entry : userProductMap.entrySet()){
                        String user = entry.getKey();
                        HashSet<String> products = entry.getValue();
                        
                        if(!visitedUser.contains(user) && products.contains(product)){
                            visitedUser.add(user);
                            queue.offer(user);
                        }
                    }
                }
            }
        }

        return recommendedProducts;
    }
}