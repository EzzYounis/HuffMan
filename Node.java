public class Node<T extends Comparable>  {
    HuffNode Hnode;
    String charc;
    String Ccode;
    Node<T>next;
    int freq;
    public Node(String val,String ccode){
        this.charc=val;
        this.next=null;
        this.freq=1;
        this.Hnode=null;
        this.Ccode=ccode;
    }

    public Node(String val){
        this.charc=val;
        this.next=null;
        this.freq=1;
        this.Hnode=null;

    }
    public Node(HuffNode node){
        this.charc=null;
        this.next=null;
        this.freq=node.freq;
        this.Hnode=node;
    }
    public String toString(){
        if (charc == null){
            return ""+freq;
        }
        return charc;
    }
}
