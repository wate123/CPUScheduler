package cpuscheduler;

import java.util.*;

/**
 * This class models an array-based binary heap that implements the 
 * HeapAPI interface. The array holds objects that implement the 
 * parameterized Comparable interface.
 * @author Duncan
 * @param <E> the heap element type
 * @date 02/14/2017
 */
public class Heap<E extends Comparable<E>> implements HeapAPI<E>
{    
   /**
    * A complete tree stored in an array list representing this 
    * binary heap
    */
   private ArrayList<E> tree;
    
   /**
    * Constructs an empty heap
   */ 
   public Heap()
   {
      tree = null;
   }

   @Override
   public boolean isEmpty()
   {
      return tree.isEmpty();
   }

   @Override
   public void insert(E item)
   {
      tree.add(item);
      reheapify(0,size());
   }

   @Override
   public E remove() throws HeapException
   {
      if(tree.isEmpty())
          throw new HeapException("Heap is empty");
      E root = tree.get(0);
      tree.set(0,tree.get(size()-1));
      tree.remove(size()-1);
      reheapify(0,size()-1);
      return root;
   }

   @Override
   public E peek() throws HeapException
   {
      if(isEmpty())
         throw new HeapException("Heap is empty");
      return tree.get(0);
   }      

   @Override
   public int size()
   {
      return tree.size();
   }
   
   /**
    * Swaps a parent and child elements of this heap at the specified indices
    * @param place an index of the child element on this heap
    * @param parent an index of the parent element on this heap
    */
   private void swap(int place, int parent)
   {
      E tmp = tree.get(place);
      tree.set(place,tree.get(parent));
      tree.set(parent,tmp);

   }

   /**
    * Rebuilds the heap to ensure that the heap property of the tree is preserved.
    * @param root the root index of the subtree to be rebuilt
    * @param eSize the size of this tree
    */
   private void reheapify(int root, int eSize)
   {
      if(root > 1){
         int child = 2*root+1;
         if(){
            if(tree.get(child+1).compareTo(tree.get(child)) > 1){
               child = child + 1;
            }
         }
         if(tree.get(root).compareTo(tree.get(child)) < 1){
            swap(root,child);
            reheapify(child,eSize);
         }
      }
   }
}
