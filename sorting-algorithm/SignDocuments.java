import java.util.*;

public class SignDocuments {
    public static List<DocumentSequence> order( List<DocumentSequence> unorderedList) {
        List<DocumentSequence> unorderedList_ = new ArrayList<>(unorderedList);
        LinkedList<DocumentSequence> response = new LinkedList<>();
        response.add(unorderedList_.get(0)); //initializing
        unorderedList_.remove(0);

        while(!unorderedList_.isEmpty()) {
            for(int i = 0; i <= unorderedList_.size(); i++) {
                DocumentSequence document = unorderedList_.get(i);
                if(response.getFirst().getCurrent().equals(document.getNext())) {
                    response.addFirst(document);
                    unorderedList_.remove(i);
                } else if (response.getLast().getNext().equals(document.getCurrent())) {
                    response.addLast(document);
                    unorderedList_.remove(i);
                }
            }
        }

        return response;
    }

    public static void main(String[] args) {
        List<DocumentSequence > unsorted = Arrays.asList(
            new DocumentSequence ("cfp","qwe"), 
            new DocumentSequence ("z","cfp"),
            new DocumentSequence ("123","d"), 
            new DocumentSequence ("qwe","123"));
        order(unsorted).stream().forEach((p)-> {
            System.out.println(p.getCurrent() + ", " + p.getNext());
        });
    }

}