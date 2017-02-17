package cpuscheduler;
import java.util.Random;

/**
 * A simple non-preemptive CPU Scheduler
 * @author Jun Lin
 * @since 02/14/2017
 */


public class CPUScheduler
{
   public static void main(String []args) throws HeapException
   {
      Random generator = new Random();
      Heap<PCB>pq = new Heap();
      int S = Integer.parseInt(args[0]);
      float p = Float.parseFloat(args[1]);
      int count = 0;
      int waitTotal = 0;
      int i = 1;
      int completedProcesses = 0;
      int priority, length, arrival, running;
      float q;
      while (i <= S)
      {
         System.out.printf("Cycle #: %d ***%n", i);
         q = generator.nextFloat();
         if (q < p)
         {
            count++;
            priority = generator.nextInt(40)- 19;
            length = generator.nextInt(101);
            arrival = i;
            running = 0;
            PCB thePCB = new PCB(count, priority, running, arrival, length);
            pq.insert(thePCB);
            System.out.printf("Adding job with pid #%d and priority %d and length %d%n", count,priority, length);
         }
         if (!pq.isEmpty())
         {
            if(!pq.peek().isExecuting())
            {
               pq.peek().execute();
               pq.peek().setStart(i);
               pq.peek().setWait(i - pq.peek().getArrival());
               waitTotal += pq.peek().getWait();
            }
            if (i-pq.peek().getStart() == pq.peek().getLength())
            {
               PCB temp = pq.peek();
               pq.remove();
               System.out.printf("Process # %d has just terminated. %n", temp.getPid());
               completedProcesses++;
            }
            else
            {
               System.out.printf("Procress # %d is executing %n", pq.peek().getPid());
            }
         }
         System.out.println("No new job this cycle");
         i++;
      }
      double averageTurn = (double) completedProcesses / (double) S;
      System.out.printf("The average turn around is %.3f per cycle. %n",averageTurn);
      double averageWait = (double) waitTotal/(double) completedProcesses;
      System.out.printf("The average wait time is %.6f%n",averageWait);

   }
}