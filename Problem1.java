package jp.co.wap.exam;

import java.util.Arrays;
import java.util.List;
import jp.co.wap.exam.lib.Interval;


public class Problem1 {
	
	public int getMaxIntervalOverlapCount(List<Interval> intervals) {

		/** if list is empty return 0 **/
		if (intervals.isEmpty()) {
			System.out.println("Empty List");
			return 0;
		} else {
			int maxNoOfOverlapping = 0, noOfOverlapping = 0;
			int maxFinishTime = 0, finishTime = 0;
			/** getting the maximum possible finish time to initialize array **/
			for (Interval temp : intervals) {

				finishTime = temp.getEndHour() * 60 + temp.getEndMinute();
				if (finishTime > maxFinishTime)
					maxFinishTime = finishTime;
			}
			/** initializing time array */
			int timeArr[] = new int[maxFinishTime];
			/** plotting the points in time array */
			for (int i = 0; i < intervals.size(); i++) {
				/**
				 * +1 value in the corresponding array entry signifies start
				 * point
				 */
				timeArr[intervals.get(i).getBeginHour() * 60
						+ intervals.get(i).getBeginMinute() - 1] = 1;
				/**
				 * -1 value in the corresponding array entry signifies end point
				 */
				timeArr[intervals.get(i).getEndHour() * 60
						+ intervals.get(i).getEndMinute() - 1] = -1;
			}

			/** scanning the time points */
			for (int i = 0; i < timeArr.length; i++) {
				/** if a start point increment counter */
				if (timeArr[i] == 1)
					noOfOverlapping++;
				/** if an end point decrement counter */
				if (timeArr[i] == -1)
					noOfOverlapping--;
				/**
				 * checking max possible value of counter which is nothing but
				 * max no of overlapping
				 */
				if (noOfOverlapping > maxNoOfOverlapping)
					maxNoOfOverlapping = noOfOverlapping;

			}
			return maxNoOfOverlapping;
		}
	}

}
