Problem  :
-----------

Readers Writers Problem : https://en.wikipedia.org/wiki/Readers%E2%80%93writers_problem

Scenario : 
---------- 

Readers try to read the balance of a bank account while Writers try to deposit on this account.
Only one writer can write at a time.
Multiple readers can read simultaneously.
Semaphore  class of Java is used to implement the solutions. 



First Readers Writers Solution
-------------------------------

1. Reader Threads are given preference over Writer Threads. Hence, if lot of 
Readers are coming in compared to few Writers, Writer Threads will get starved.
2. Starvation of Writer Threads can result in Reader Threads reading 
old(stale) data.

****************************************************************************


Second Readers Writers Solution
---------------------------------

1. Writer Threads are given preference over Reader Threads. Hence, lot of 
Readers get starved when there are lot of writes..
2. Starvation of Reader Threads can result in inconsistent reads.

****************************************************************************


Third Readers Writers Solution
-------------------------------

No threads are allowed to starve. This is done using a common semaphore -
orderMutex for both Readers and Writers to preserve the order in which they are
arriving to access the critical section.

****************************************************************************
