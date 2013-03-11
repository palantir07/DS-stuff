import java.util.ArrayList;
import java.util.HashMap;

import LinkedListStuff.LinkNode;

class LinkNode {
	int data;
	LinkNode link;
	LinkNode randPointer;

	public LinkNode(int data) {
		this.data = data;
		link = null;
	}

	public boolean equals(Object obj) {
		if (obj instanceof LinkNode && ((LinkNode) obj).data == this.data) {
			return true;
		} else
			return false;

	}

	public int hashCode() {
		return this.data;
	}

}

public class CopyList {
	private HashMap<LinkNode, LinkNode> hm = new HashMap<LinkNode, LinkNode>();

	public void hashMap() {
		// hm.put(key, value)

	}

	public LinkNode copyLinkedList(LinkNode start) {

		return null;
	}

	public void buildHashMap(LinkNode oldRef, LinkNode newRef) {

		hm.put(newRef, oldRef);
		// return hm;

	}

	public LinkNode createPlainList(LinkNode start) {
		LinkNode newStart = null;
		LinkNode temp = null;
		while (start != null) {
			if (newStart == null) {
				newStart = new LinkNode(start.data);
				buildHashMap(newStart,start);
				temp = newStart;
				start = start.link;
			} else {
				temp.link = new LinkNode(start.data);
				temp = temp.link;
				buildHashMap(temp,start);
				start = start.link;
			}
		}
		return newStart;
	}

	public void printList(LinkNode start) {
		while (start != null) {
			System.out.println(" " + start.data + "Rand Pointer -- >"
					+ start.randPointer.data);
			start = start.link;
		}
	}

	public static void main(String args[]) {
		LinkNode start = new LinkNode(1);
		start.link = new LinkNode(2);
		start.link.link = new LinkNode(3);
		start.link.link.link = new LinkNode(4);
		start.link.link.link.link = new LinkNode(5);
		start.randPointer = start.link.link;
		start.link.randPointer = start.link.link.link;
		start.link.link.randPointer = start.link.link;
		start.link.link.link.randPointer = start.link;
		start.randPointer = start.link.link.link.link;
		start.link.link.link.link.randPointer = start.link.link.link.link;

		CopyList cp = new CopyList();
		cp.printList(start);
		LinkNode NewStart = cp.createPlainList(start);
		System.out.println(cp.hm);
		// cp.printList(NewStart);
	}
}
