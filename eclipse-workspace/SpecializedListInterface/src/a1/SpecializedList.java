package a1;

public class SpecializedList implements SpecializedListInterface{
	private class SListNode{
		SListNode next;
		SListNode prev;
		String e;
		SListNode(String e, SListNode prev, SListNode next){
			this.e =e;
			this.prev = prev;
			this.next = next;
					
		}
		public String getElement( ) { return e; }
		public SListNode getPrev( ) { return prev; }
		public SListNode getNext( ) { return next; }
		public void setPrev(SListNode p) { prev = p; }
		public void setNext(SListNode n) { next = n; }
	}
	private SListNode header;
	private SListNode trailer;
	private int size =0;
	public SpecializedList() {
		this.header = new SListNode(null,null,null);
		this.trailer = new SListNode(null,this.header,null);
		header.setNext(trailer);
		trailer.setNext(header);
	}
	public int size() {
		return this.size;
	}
	public boolean isEmpty() {
		return this.size == 0;
	}
	public SListNode getHeader() {
		return this.header;
	}
	public SListNode getTrailer() {
		return this.trailer;
	}
	public String first() {
		if (this.isEmpty()) {
			return null;
		}else {
			return this.header.getNext().getElement();
		}
	}
	public String last() {
		if (this.isEmpty()) {
			return null;
		}else {
			return this.trailer.getPrev().getElement();
		}
	}
	private void addBetween(String e, SListNode prev, SListNode next) {
		SListNode temp = new SListNode(e,prev, next);
		next.setPrev(temp);
		prev.setNext(temp);
		this.size++;
	}
	public void addFirst(String e) {
		this.addBetween(e, header, header.getNext());
	}
	public void addLast(String e) {
		this.addBetween(e, trailer.getPrev(), trailer);
	}
	private String remove(SListNode SListNode) {
		SListNode predecessor = SListNode.getPrev();
		SListNode successor = SListNode.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		this.size--;
		return SListNode.getElement();
	}
	public String removeFirst() {
		if (isEmpty()) {
			return null;
		}else {
			return remove(header.getNext());
		}	
	}
	public String removeLast() {
		if (isEmpty()) {
			return null;
		}else {
			return this.remove(trailer.getPrev());
		}
	}
	public void display() {
		if (isEmpty()) {
			System.out.println("Nothing in list");
		}else {
			SListNode temp = this.header.getNext();
			while (temp.getElement() != null) {
				System.out.println(temp.getElement());
				temp = temp.getNext();
			}
		}
	}
	public void displayReverse() {
		SListNode temp = this.header.getNext();
		SpecializedList reverse = new SpecializedList();
		while (temp.getElement() != null) {
			reverse.addLast(temp.getElement() );
			temp =temp.getNext();
		}
		header = reverse.getHeader();
		trailer = reverse.getTrailer();
		header.setPrev(trailer);
		temp = header.getPrev();
		while (temp != header) {
			System.out.println(temp.getElement());
			temp = temp.getPrev();
		}
		
		
	}
	@Override
	public void resetForward() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public byte getNextItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void resetBackward() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public byte getPriorItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lengthIs() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insertFront(byte item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertEnd(byte item) {
		// TODO Auto-generated method stub
		
	}

}
