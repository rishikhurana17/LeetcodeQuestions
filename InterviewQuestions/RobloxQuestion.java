package LeetcodePrograms.InterviewQuestions;

/**
 * @author Rishi Khurana
 */
/*

Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique positive integer identifier.

For example, in this diagram, 6 and 8 have common ancestors of 4 and 14.

             15
             |
         14  13
         |   |
1   2    4   12
 \ /   / | \ /
  3   5  8  9
   \ / \     \
    6   7     11

parentChildPairs1 = [
    (1, 3), (2, 3), (3, 6), (5, 6), (5, 7), (4, 5),
    (4, 8), (4, 9), (9, 11), (14, 4), (13, 12),
    (12, 9),(15, 13)
]

Write a function that takes the graph, as well as two of the individuals in our dataset, as its inputs and returns true if and only if they share at least one ancestor.

Sample input and output:

hasCommonAncestor(parentChildPairs1, 3, 8) => false
hasCommonAncestor(parentChildPairs1, 5, 8) => true
hasCommonAncestor(parentChildPairs1, 6, 8) => true
hasCommonAncestor(parentChildPairs1, 6, 9) => true
hasCommonAncestor(parentChildPairs1, 1, 3) => false
hasCommonAncestor(parentChildPairs1, 3, 1) => false
hasCommonAncestor(parentChildPairs1, 7, 11) => true
hasCommonAncestor(parentChildPairs1, 6, 5) => true
hasCommonAncestor(parentChildPairs1, 5, 6) => true


Additional example: In this diagram, 4 and 12 have a common ancestor of 11.

        11
       /  \
      10   12
     /  \
1   2    5
 \ /    / \
  3    6   7
   \        \
    4        8

parentChildPairs2 = [
    (1, 3), (11, 10), (11, 12), (2, 3), (10, 2),
    (10, 5), (3, 4), (5, 6), (5, 7), (7, 8),
]

hasCommonAncestor(parentChildPairs2, 4, 12) => true
hasCommonAncestor(parentChildPairs2, 1, 6) => false
hasCommonAncestor(parentChildPairs2, 1, 12) => false

n: number of pairs in the input


*/

import java.io.*;
import java.util.*;

// map parent child -> 1->3,
//                     2->2
//     child->parent relationship

public class RobloxQuestion {

    public static void findRelationship(int [][] parentChildPairs, int child1 , int child2){
        Map<Integer, List<Integer>> childParentRelation = new HashMap<>();
        Set<Integer> peopleSet = new HashSet<>();
        for(int i = 0 ; i < parentChildPairs.length ; i++){ // o(n)
            int []parentChildPair = parentChildPairs[i];
            int parent = parentChildPair[0];
            int child = parentChildPair[1];
            peopleSet.add(parent);
            peopleSet.add(child);
            if(childParentRelation.containsKey(child)){
                List<Integer> list = childParentRelation.get(child);
                list.add(parent);
                childParentRelation.put(child, list);
            }else{
                List<Integer> parentList = new ArrayList<>();
                parentList.add(parent);
                childParentRelation.put(child,parentList);
            }
        }
        Set<Integer> setChild1 = new HashSet<>();
        Set<Integer> setChild2 = new HashSet<>();
        Set<Integer> ancestor1 = RelationshipUtil(childParentRelation, child1, setChild1 );
        Set<Integer> ancestor2 = RelationshipUtil(childParentRelation, child2, setChild2 );

        findCommonAncestors(ancestor1 , ancestor2);

    }

    private static void findCommonAncestors(final Set<Integer> ancestor1, final Set<Integer> ancestor2) {
        System.out.println(ancestor1.retainAll(ancestor2));
        System.out.println(ancestor1);
    }

    public static Set<Integer> RelationshipUtil(Map<Integer, List<Integer>> childParentRelation, int child,
            Set<Integer> setChild){
        List<Integer> list = childParentRelation.get(child);
        if(list.size()!= 0){
            for(Integer i : list){
                if(setChild.contains(i))
                    break;
                setChild.add(i);
                List<Integer> integers = childParentRelation.get(i);
                if(integers!=null ){
                    RelationshipUtil(childParentRelation , i , setChild);
                }

            }
        }
        return setChild;
    }

    //     List<Integer> childWithOneParent = new ArrayList<>();
    //     for(Integer key : childParentRelation.keySet()){ // O(n)
    //       if(childParentRelation.get(key).size() == 1) {
    //         childWithOneParent.add(key);
    //       }
    //     }

    //     for(Integer key : childParentRelation.keySet()){
    //       if(peopleSet.contains(key)) {
    //         peopleSet.remove(key);
    //       }
    //     }
    //     List<List<Integer>> resultSet = new ArrayList<>();
    //     List<Integer> resultSet1 = new ArrayList<>();
    //     for(int i = 0 ; i < childWithOneParent.size(); i++){
    //       resultSet1.add(childWithOneParent.get(i));
    //     }
    //     List<Integer> resultSet2 = new ArrayList<>();
    //     Iterator itr = peopleSet.iterator();
    //     while(itr.hasNext()){
    //       Integer i = (Integer)itr.next();
    //       resultSet2.add(i);
    //     }

    //     resultSet.add(resultSet1);
    //     resultSet.add(resultSet2);

    //     return resultSet;



    public static void main(String[] argv) {
        int[][] parentChildPairs1 = new int[][] {
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5},
                {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9},
                {15, 13}
        };

        findRelationship(parentChildPairs1 , 5,11);
        int[][] parentChildPairs2 = new int[][] {
                {1, 3}, {11, 10}, {11, 12}, {2, 3}, {10, 2},
                {10, 5}, {3, 4}, {5, 6}, {5, 7}, {7, 8}
        };


        //     List<List<Integer>> result = findRelationship(parentChildPairs);
        //     for(int i = 0 ; i < result.size(); i++){
        //       List<Integer> resultList = result.get(i);
        //       System.out.println(resultList);
        //     }

    }
}
