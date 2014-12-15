package jp.co.wap.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.wap.exam.lib.Interval;

public class Problem2 {
	
	public int getMaxWorkingTime(List<Interval> intervals) {
		/** if list is empty return 0 **/
		if (intervals.isEmpty()) {	
			return 0;
		} else {
			Interval[] interval = new Interval[intervals.size()];
			for (int i = 0; i < intervals.size(); i++) {
				interval[i] = intervals.get(i);
			}
			/** performing radix sort to sort the jobs by their finish times in o(n) time **/
			interval = radixSort(interval);	

			int maxWorkingTime = 0;
			int optiSolnArr[] = new int[intervals.size() + 1];
			int compatibleIndexArr[] = new int[intervals.size() + 1];

			int bestCompatibleId;
			for (int i = 0; i < interval.length; i++) {	
				/** initializing the solution array and compatible_job_index array **/
				optiSolnArr[i] = -1;
				/** getting the largest compatible job index for a  job **/
				bestCompatibleId = compatibilitySearch(	
						interval[i].getBeginHour() * 60
								+ interval[i].getBeginMinute(), i - 1, interval);

				if (bestCompatibleId != -1)
					compatibleIndexArr[i] = bestCompatibleId;
				else
					compatibleIndexArr[i] = 0;
			}
			maxWorkingTime = computeOptSoln(intervals, optiSolnArr,
					compatibleIndexArr);

			return maxWorkingTime;
		}
	}

	public static int compatibilitySearch(int start, int high,
			Interval[] intervals) {

		if (high == -1)
			return -1;

		int low = 0;
		int bestCompatibleId = -1;
		int mid;
		int finish;
		
		/** performing binary search **/
		while (low <= high) {	
			mid = (low + high) / 2;
			finish = intervals[mid].getEndHour() * 60
					+ intervals[mid].getEndMinute();

			if (finish >= start) {
				high = mid - 1;
			} else {
				bestCompatibleId = mid + 1;
				low = mid + 1;
			}
		}

		return bestCompatibleId;
	}

	public static int computeOptSoln(List<Interval> intervals,
			int[] optiSolnArr, int[] compatibleIndexArr) {
		optiSolnArr[0] = 0;
		for (int j = 1; j < intervals.size() + 1; j++) {		
			/** computing the optimal value through dynamic programming 
			 * OPT( j) = max { v j + OPT( p( j)), OPT( j −1) } 
			 * OPT( j) = 0 if j=0;
			 */
			optiSolnArr[j] = (intervals.get(j - 1).getIntervalMinute()
					+ optiSolnArr[compatibleIndexArr[j - 1]] > optiSolnArr[j - 1]) ? (intervals
					.get(j - 1).getIntervalMinute() + optiSolnArr[compatibleIndexArr[j - 1]])
					: (optiSolnArr[j - 1]);
		}
		return optiSolnArr[optiSolnArr.length - 1];

	}

	public static Interval[] radixSort(Interval[] arr) {
		ArrayList[] buckets = new ArrayList[10];
		for (int c = 0; c < buckets.length; c++) {
			buckets[c] = new ArrayList();
		}
		for (int c = 0; c < 4; c++) {
			for (int d = 0; d < arr.length; d++) {
				int exp = (int) Math.pow(10, c);
				int j = ((arr[d].getEndHour() * 60 + arr[d].getEndMinute()) / exp) % 10;
				buckets[j].add((Interval) arr[d]);
			}
			int b = 0;
			for (int d = 0; d < arr.length; d++) {
				if (buckets[b].isEmpty()) {
					b++;
					d--;
					continue;
				}

				arr[d] = (Interval) buckets[b].remove(0);
			}
		}
		return arr;
	}

}
