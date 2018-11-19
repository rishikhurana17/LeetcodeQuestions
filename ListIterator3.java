package LeetcodePrograms;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by rkhurana on 10/28/18.
 */
public class ListIterator3 {

// Array List Iterator

//Given an array of arrays, implement an iterator class to allow the client to traverse and remove elements in the array list in place.  This _iterator_ should provide three public class member functions:
//
//boolean hasNext()
//    return true if there is another element in the whole structure
//
//int next()
//    return the value of the next element in the structure
//
//void remove()
//    remove the last element returned by the iterator.
//    That is, remove the element that the previous next() returned
//    This method can be called only once per call to next(),
//    otherwise an exception will be thrown.
//    See http://docs.oracle.com/javase/7/docs/api/java/util/Iterator.html#remove() for details.
//
//The code should be well structured, and robust enough to handle any access pattern.  Additionally, write code to demonstrate that the class can be used for the following basic scenarios:
//
//* *Print elements*
//
//Given:  [[],[1,2,3],[4,5],[],[],[6],[7,8],[],[9],[10],[]]
//Print:  1 2 3 4 5 6 7 8 9 10
//
//* * Remove even elements*
//
//Given:  [[],[1,2,3],[4,5],[],[],[6],[7,8],[],[9],[10],[]]
//Should result in:  [[],[1,3],[5],[],[],[],[7],[],[9],[],[]]
//Print:  1 3 5 7 9

        private int currentIndex = 0 ;
        private int currentList = 0 ;
        private boolean canRemove = false;

        ArrayList<ArrayList<Integer>> list;

        public ListIterator3(ArrayList<ArrayList<Integer>> list ){
            this.list = list;
        }

        public boolean hasNext(){
            if(this.currentList < this.list.size()) {
                while(this.currentList < this.list.size() && list.get(this.currentList).size() == 0)
                    this.currentList++;
            }

            if(this.currentList < this.list.size())
                return true;
            else
                return false;
        }

        public  int next(){
            if(hasNext()){
                List<Integer> thisList = list.get(this.currentList);

                if(this.currentIndex == thisList.size() - 1) {
                    int temp = this.currentIndex;
                    this.currentIndex =0;
                    this.currentList++;
                    canRemove = true;

                    return thisList.get(temp);
                }
                else if (this.currentIndex < thisList.size()-1){  //element is not at the last location
                    canRemove = true;
                    return thisList.get(this.currentIndex++);
                }
//			else if(this.currentIndex == thisList.size()) {
//				this.currentList++;
//				canRemove = true;
//				if(hasNext())
//					return next();
//			}
            }
            return -1;
        }

        public int remove() throws Exception {
            if(canRemove) {
                int listIndex, elementIndex;

                if(currentIndex == 0) {
                    listIndex = currentList -1;
                    elementIndex = list.get(listIndex).size() -1;
                    currentIndex = elementIndex;
                    currentList = listIndex;
                }
                else {
                    listIndex = currentList;
                    elementIndex = currentIndex - 1;
                }
                int elementToBeRemoved = list.get(listIndex).get(elementIndex);
                list.get(listIndex).remove(elementIndex);
                currentIndex--;
                canRemove = false;
                return elementToBeRemoved;
            } else {
                throw new Exception("Cannot remove");
            }
        }

        public static void main(String[] args) throws Exception {
            System.out.println("Old list looks like " + ListIterator3.getInput());
            ListIterator3 listIterator = new ListIterator3((ListIterator3.getInput()));

            System.out.println("Next element " + listIterator.next());
            System.out.println("element removed " +listIterator.remove());
            System.out.println("Next element " + listIterator.next());
            System.out.println("element removed " +listIterator.remove());
            System.out.println("Next element " + listIterator.next());
           System.out.println("element removed " + listIterator.remove());
            System.out.println("Next element " + listIterator.next());
            System.out.println("element removed " +listIterator.remove());
            System.out.println("Next element " + listIterator.next());
            System.out.println("Next element " + listIterator.next());
            System.out.println("Next element " + listIterator.next());
            System.out.println("Next element " + listIterator.next());
            System.out.println("Next element " + listIterator.next());
            System.out.println("Next element " + listIterator.next());
            System.out.println("Next element " + listIterator.next());
            System.out.println("Next element " + listIterator.next());
            System.out.println("Next element " + listIterator.next());




        }

        public static ArrayList<ArrayList<Integer>> getInput() {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>());
            list.add(new ArrayList<>(asList(1,2,3)));
            list.add(new ArrayList<>(asList(4)));
            list.add(new ArrayList<>());
            list.add(new ArrayList<>());
            list.add(new ArrayList<>(asList(5)));
//            list.add(new ArrayList<>(asList(6,7,8)));
//            list.add(new ArrayList<>());
//            list.add(new ArrayList<>(asList(9)));
//            list.add(new ArrayList<>(asList(10)));
//            list.add(new ArrayList<>());
            return list;
        }




}
