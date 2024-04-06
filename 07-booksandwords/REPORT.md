1. What is your hash function like for hash table solution (if you implemented hash table).
    1. Method of calculation
        I used 'prime modulo' to calculate the hash value. The calculation method is to loop each character of a word, multiply the hash value by a prime number, and then add the ASCII value of the character. And it ensure that the index is within a valid range through modulo operations.
    1. Resolve hash conflicts
        When dealing with hash conflicts, we use linear detection method. When we calculate the hash value and find that the corresponding position in the hash table is already occupied, we will perform a linear search. It will check adjacent positions one by one until a blank slot is found for insertion operation.

1. For binary search trees (if you implemented it), how does your implementation get the top-100 list?

    > 1. If the current node is null, immediately return the current index;
    > 1. Recursively traverse the left subtree and update the index with the returned value;
    > 1. Add the current node to the array and update the index;
    > 1. Recursively traverse the right subtree and update the index with the return value.

1. What can you say about the **correctness** of your implementation? Any issues, bugs or problems you couldn't solve? Any idea why the problem persists and what could perhaps be the solution?

    The code has been debugged and modified multiple times, and there are no obvious bugs in the code. But if you need to process a large number of files or contain a lot of words at the same time, there may be performance issues. I have found that my VSC may get stuck while I am performing tests. Then a window will pop up asking if I want to continue waiting or reopen the current file. But when I looked at the test results, I found that the execution time of the test was not as long as the crash time.

1. What can you say about the **time complexity** of your implementation? How efficient is the code in reading and managing the words and their counts? How efficient is your code in getting the top-100 list? Which sorting algorithm are you using? What is the time complexity of that algorithm?

   - Time complexity
     - BST 
       > The time complexity of the insertion operation depends on the balance of the tree, in the worst-case scenario it is' O (log n) ', where' n 'is the number of nodes. The time complexity of the traversal operation (traversing in order, calculating the number of word occurrences) is also 'O (n)', where 'n' is the number of nodes.
     - HASH: 
       > The average time complexity of insertion is O (1), but it can reach O (n) when conflicts occur. Using the 'heap sorting' algorithm, the time complexity is' O (nlogn) '.

   - Efficiency in reading and managing word count and counting
     - BST
       > Fast search, insertion, and deletion operations can be performed based on key values, with a time complexity of O (log n), where n is the number of nodes in the tree.
     - HASH
       > On average, the time complexity of insertion, deletion, and search operations in a hash table is O (1), which is very efficient.

   - Efficiency in obtaining the top 100 list
     - BST
       > Efficiency depends on the size and balance of the tree, and is generally quite effective.
     - HASH
       > The efficiency depends on the sorting algorithm used, and due to the use of heap sorting, its time complexity is O (nlogn), which is acceptable for medium-sized datasets.

   - Sorting algorithm and time complexity used
     > Both implementations use the 'heap sorting' algorithm for sorting, with a time complexity of 'O (nlogn)', where 'n' is the number of nodes.
     
1. What did you find the **most difficult things** to understand and implement in this programming task? Why?
    > Optimizing hash table performance to efficiently process large amounts of data is undoubtedly one of the most challenging tasks. This requires us to understand the operation mechanism of hash functions, deal with hash conflicts, and adjust the size of hash tables. Meanwhile, implementing and understanding heap sorting algorithms is also a significant challenge.

1. What did you learn doing this?
    > Through this learning experience, I have learned how to use hash tables to calculate the number of occurrences of words, and gained a deeper understanding of hash functions, hash conflict handling, sorting algorithms and their implementation, as well as calculating the maximum depth of binary trees. At the same time, I also learned how to write heap sorting algorithms.
