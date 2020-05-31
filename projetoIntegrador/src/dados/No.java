package dados;

public class No {
	private Item info;
	private No next;
	
	
	public No(Item info, No next) {
		this.info = info;
		this.next = next;
	}


	public Item getInfo() {
		return info;
	}


	public void setInfo(Item info) {
		this.info = info;
	}


	public No getNext() {
		return next;
	}


	public void setNext(No next) {
		this.next = next;
	}
	
	
	
	
}
