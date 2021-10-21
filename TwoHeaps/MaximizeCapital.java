package TwoHeaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximizeCapital {
  public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital)  {
      if(numberOfProjects <= 0){
          return -1;
      };

      int n = capital.length;
      PriorityQueue<Integer> minCapitalHeap = new PriorityQueue<>();
      PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(Comparator.reverseOrder());

      // Insert all project capitals
      for(int i = 0; i < n; i++){
        minCapitalHeap.offer(capital[i]);
      };

      // Try to find a total of numberOfProjects best projects
      for(int i = 0; i < numberOfProjects; i++){
          // We can afford these projects
          while(!minCapitalHeap.isEmpty() && initialCapital >= minCapitalHeap.peek()){
              maxProfitHeap.offer(minCapitalHeap.poll());

              if(maxProfitHeap.isEmpty()){
                  break;
              };
          };

          // Increase our capital, and knock down one project
          initialCapital += profits[maxProfitHeap.poll()];
      };

      return initialCapital;
  };
};

// int result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1);
//     System.out.println("Maximum capital: " + result);
//     result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0);
//     System.out.println("Maximum capital: " + result);