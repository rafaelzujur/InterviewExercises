package com.geeksforgeeks.amazon.easy;

import com.common.Node;

/*
	Given two linked lists sorted in ascending order. Merge them in-place and return head of the merged list.   
	For example, if first list is 10->20->30 and second list is 15->17, then the result list should be 10->15->17->20->30.
	
	It is strongly recommended to do merging in-place using O(1) extra space.
	
	Input:
	You have to complete the method which takes 2 argument: the head of the first linked list  and the head of second linked list. You should not read any input from stdin/console. There are multiple test cases. For each test case, this method will be called individually.
	
	Output:
	Your function should return a pointer to the list obtained by merging the two sorted linked list passed as argument.
	
	Constraints:
	1 <=T<= 50
	1 <= size of linked lists <= 1000
	1 <= Data in linked list nodes <= 1000
	
	Example:
	Input:
	2
	4 3
	5 10 15 40 
	2 3 20
	2 2
	1 1
	2 4 
	
	Output:
	
	2 3 5 10 15 20 40 
	1 1 2 4 
 */
public class MergeLinkedLists {

	public static void main(String[] args) {
		Node A = new Node(10, new Node(20, new Node(30, null)));
		Node B = new Node(15, new Node(19, new Node(21, null)));
		
		Node merged = MergeLists(A,B);
		
		while (merged != null)
		{
			System.out.print(merged.data + " ");
			merged = merged.next;
		}

	}
	
	public static Node MergeLists(Node headA, Node headB) 
	{
		// Check node B has reached the end
		if (headB == null)
			return headA;
		
		// Check node A has reached the end
		if (headA == null)
			return headB;
		
		// Check the element in node A is lesser than the element in node B
		if (headA.data < headB.data)
		{
			// The next element will be the next small element from both lists
			headA.next = MergeLists(headA.next, headB);
			return headA;
		}
		else
		{
			// The next element will be the next small element from both lists
			headB.next = MergeLists(headA, headB.next);
			return headB;
		}
		
	}

}
