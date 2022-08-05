public class DocumentSequence {
	String current;
    String next;

    public DocumentSequence() {}

    public DocumentSequence(String current, String next){
        this.current = current;
        this.next = next;
    }

    public String getCurrent(){return current;}
    public String getNext(){return next;}

    public void setCurrent(String current){this.current = current;}
    public void setNext(String next){this.next = next;}
}