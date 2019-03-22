package LeetcodePrograms;
import java.util.*;
/**
 * Created by rkhurana on 3/13/19.
 */
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> graph = new HashMap<>();  //<email node, neighbor nodes>
        Map<String, String> name = new HashMap<>();        //<email, username>
        // Build the graph;
        for (List<String> account : accounts) {
            String userName = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                if (!graph.containsKey(account.get(i))) {
                    graph.put(account.get(i), new HashSet<>());
                }
                name.put(account.get(i), userName);

                if (i == 1) continue;
                graph.get(account.get(i)).add(account.get(i - 1));
                graph.get(account.get(i - 1)).add(account.get(i));
            }
        }

        Set<String> visited = new HashSet<>();
        List<List<String>> res = new LinkedList<>();
        // DFS search the graph;
        for (String email : name.keySet()) {
            List<String> list = new LinkedList<>();
            if (visited.add(email)) {
                dfs(graph, email, visited, list);
                Collections.sort(list);
                list.add(0, name.get(email));
                res.add(list);
            }
        }

        return res;
    }

    public void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> list) {
        list.add(email);
        for (String next : graph.get(email)) {
            if (visited.add(next)) {
                dfs(graph, next, visited, list);
            }
        }
    }
    public static void main(String []args){
        AccountsMerge am = new AccountsMerge();
        List<String> account1 = new ArrayList<>();
        List<String> account2 = new ArrayList<>();
        List<String> account3 = new ArrayList<>();
        List<String> account4 = new ArrayList<>();
        account1.add("John");
        account1.add("johnsmith@mail.com");
        account1.add("john00@mail.com");
        account2.add("John");
        account2.add("johnnybravo@mail.com");
        account3.add("John");
        account3.add("johnsmith@mail.com");
        account3.add("john_newyork@mail.com");
        account4.add("Mary");
        account4.add("mary@mail.com");
        List<List<String>>Accounts = new ArrayList<>();
        Accounts.add(account1);
        Accounts.add(account2);
        Accounts.add(account3);
        Accounts.add(account4);
        System.out.println(am.accountsMerge(Accounts));
    }
}
