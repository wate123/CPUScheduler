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
      return tree == null;
   }

   @Override
   public void insert(E obj)
   {
      tree.add(obj);
      
   }

   @Override
   public E remove() throws HeapException
   {
      if(tree.isEmpty())
          throw new HeapException("Heap is empty");
      E root = tree.get(0);
      root = tree.get(size() - 1);
      return reheapify(, size());
   }

   @Override
   public E peek() throws HeapException
   {
      //implement this method
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
      
   }

   /**
    * Rebuilds the heap to ensure that the heap property of the tree is preserved.
    * @param root the root index of the subtree to be rebuilt
    * @param eSize the size of this tree
    */
   private void reheapify(int root, int eSize)
   {
      //implement this method
   }
}
