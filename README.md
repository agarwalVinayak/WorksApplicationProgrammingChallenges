WorksApplicationProgrammingChallenges
=====================================

Works Application Programming Challenges

Introduction
----------------------------------
We cannot do different tasks at the same time.

To manage time for our tasks, we use a “schedule chart”

Outline of this examination
-----------------------------------------
Write programs which check “intervals” to make a proper schedule chart.


1. Problem 1
-----------------------
Multiple “intervals” are to be given as tasks.

Calculate the maximum number of overlapped “intervals” at the same time . 

<Implementation>

Implement the method "getMaxIntervalOverlapCount" in the class "Problem1".

int Problem1#getMaxIntervalOverlapCount(List<Interval> intervals)

<Specifications>

 Return 0 if the argument is null or an empty list.

 The argument (a list of “intervals”) must not contain null.


2.Problem 2
-----------------------------
Multiple “intervals” are to be given as tasks.

Calculate the maximum work time (minutes) to assign to one worker.

<Implementation>

Implement the method “int Problem2#getMaxWorkingTime(List<Interval> intervals)”.

<Specifications>

 Return the maximum time to work on a task when one worker takes it.

 Time assignment unit shall be based on tasks. (i.e. Task assignment shall be either to complete the 

whole task, or to do nothing for it.)

 The length of the interval, time required to complete the task, is calculated by subtracting "end time" 

from "start time". (e.g. If [12:00, 13:00] is given, the length of the task is 60 min.)

 Return 0 if the argument is null or an empty list.

 The argument (a list of “intervals”) must not contain null.

 The number of “intervals” must not exceed 10,000.


3.Examination 2 : Implement This Skeleton Code
-----------------------------------------------------------------
package jp.co.wap.exam;

/**

 * The Queue class represents an immutable first-in-first-out (FIFO) queue of objects. 

* @param <E>

 */

public class PersistentQueue<E> {

/**

 * requires default constructor.

 */

public PersistentQueue() {

}

/**

 * Returns the queue that adds an item into the tail of this queue without modifying this queue.

 * <pre>

 * e.g.

 * When this queue represents the queue (2, 1, 2, 2, 6) and we enqueue the value 4 into this queue,

 * this method returns a new queue (2, 1, 2, 2, 6, 4)

 * and this object still represents the queue (2, 1, 2, 2, 6) .

 * </pre>

 * If the element e is null, throws IllegalArgumentException.

* @param e

 * @return

 * @throws IllegalArgumentException

 */

public PersistentQueue<E> enqueue(E e) {

}

/**

 * Returns the queue that removes the object at the head of this queue without modifying this queue.

 * <pre>

 * e.g.

 * When this queue represents the queue (7, 1, 3, 3, 5, 1) ,

 * this method returns a new queue (1, 3, 3, 5, 1)

 * and this object still represents the queue (7, 1, 3, 3, 5, 1) .

 * </pre>

 * If this queue is empty, throws java.util.NoSuchElementException.

 * @return

 * @throws java.util.NoSuchElementException

 */

public PersistentQueue<E> dequeue() {

}

/**

 * Looks at the object which is the head of this queue without removing it from the queue.

 * <pre>

 * e.g.

 * When this queue represents the queue (7, 1, 3, 3, 5, 1),

 * this method returns 7 and this object still represents the queue (7, 1, 3, 3, 5, 1) 

 * </pre>

 * If the queue is empty, throws java.util.NoSuchElementException.

 * @return 

 * @throws java.util.NoSuchElementException

 */

public E peek() {

}

/**

 * Returns the number of objects in this queue.

 * @return

 */

public int size() {

}

// TODO: implement if necessary

// TODO: implement this method

return null;

// TODO: implement this method

return null;

// TODO: implement this method

return null;

// TODO: implement this method

return 0;
}
}
