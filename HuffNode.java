public class HuffNode <T extends Comparable>{

    int freq;
    String chrc;

    HuffNode<T> left,right;
    public HuffNode(String c,int freq){
        this.chrc=c;
        this.freq=freq;

    }
    public HuffNode(Node<T> lft,Node <T>right){
        if (lft.Hnode==null){
            this.left=new HuffNode<>(lft.charc,lft.freq);
        }else {
            this.left=lft.Hnode;
        }
        if (right.Hnode==null){
            this.right=new HuffNode<>(right.charc,right.freq);
        }else {
            this.right= right.Hnode;
        }

        this.freq= lft.freq+right.freq;
    }
    public String toString(){
        return ""+ freq;
    }



}
