package model;

public class NavigableDocModel<T>{
    private Node<T> head;
    private Node<T> tail;

    private int headCount;
    private int tailCount;
    public NavigableDocModel(){
        this.head=null;
        this.tail=null;
        this.headCount=0;
        this.tailCount=0;

    }
    public void insertNewItemRt(T item){
        if(head==null){Node<T> newNode=
                new Node<>(item, null);
            head=newNode;
            headCount++;
            return;}
          Node<T> curr=head;
        while(curr.next!=null){
            curr=curr.next;}
       Node<T> newNode=
               new Node<>(item, null);
        curr.next=newNode;
        headCount++;

    } //O(n)
    public void forward(){
            if(head==null){
                throw new IllegalStateException("nothing there");
            }
            if(tail==null){
                Node<T> item= new Node<>(head.data, null);
                    tail=item;
                   head=head.next;
                    if(tail==null){
                        tail=item;
                        return;
                }
                        Node<T> current=tail;
                        while(current.next!=null){
                            current=current.next;
                            current.next=new Node<>(head.data, null);
                        head=head.next;
                        }
                tailCount++;
                headCount--;
                    }
            }

    //O(n)
    public void reset(){
        if(tail==null){
            return;
        }
        Node<T> current=tail;
        while (current.next!=null){
            current=current.next;
        }
        current.next=head;
        head=tail;
        tail=null;
        headCount+=tailCount;
        tailCount=0;
    }

    public int lenBeforeBar(){
        return tailCount;
    }
    public Pair<Side,Integer> contains(T item){
        // TODO: now use leftIndexFound to construct the appropriate Pair and return it.
        // E.g.: if both leftIndexFound and rightIndexFound are negative, you want to return a
        // pair (NONE, -1). I.e.: return new Pair<>(NONE, -1);

        Pair<Side, Integer> leftIndexFound = containsHelper(this.head, item,0, Side.LEFT);
        Pair<Side, Integer> rightIndexFound = containsHelper(this.tail,item, 0, Side.RIGHT);
        if(leftIndexFound.pair2!=-1 && rightIndexFound.pair2!=-1){
            return new Pair<>(Side.BOTH, leftIndexFound.pair2);
        }

        if(leftIndexFound.pair2!=-1){
            return new Pair<>(Side.RIGHT, leftIndexFound.pair2);
        }
        if(rightIndexFound.pair2!=-1){
            return new Pair<>(Side.LEFT, rightIndexFound.pair2);
        }
        else{
            return new Pair<>(Side.NONE, leftIndexFound.pair2);
        }
    }
    private Pair<Side, Integer> containsHelper(Node<T> current, T itemToFind, int currIndex, Side s){
        // todo ... check if toFind.equals(currNode.data) if it does, then return currIndex
// todo ... else make recursive call to findOnSide(toFind, .... ??? ...);
        if(current==null){
            return new Pair<>(Side.NONE, -1);
        }
        if (itemToFind.equals(current.data)) {
            return new Pair<>(s, currIndex);
        }
        else{
            return containsHelper(current.next, itemToFind, currIndex+1, s);
        }
    }//O(n)

    public int lenAfterBar(){ //O(1)
        return headCount;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        Node<T> curr  =tail;
        while(curr != null){
            sb.append(curr.data);
            sb.append(" ");
            curr=curr.next;
        }
        sb.append("$ ");
        curr=head;
        while (curr != null){
            sb.append(curr.data);
            sb.append(" ");
            curr = curr.next;
        }
        return sb.toString();
    }

}
