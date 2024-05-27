import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class HuffmanTree<T extends Comparable>{
    private HuffNode headH;
    public  void creattree(LinkedList<T>ll){
        while (ll.count()>1){
            Node<T> head=ll.getHead();
            Node<T>left=ll.deleteFirst();
            Node<T> right=ll.deleteFirst();

            HuffNode hf=new HuffNode(left,right);
            if (ll.count()==0){
            this.headH=hf;}
            Node<T>newnode= new Node<>(hf);
            ll.sortedInsert(newnode);
        }

    }
    public int display(){
        return headH.freq;
    }


    public LinkedList enCodedLL(){
        LinkedList<T> LL =new LinkedList<>();
        String code="";
        return enCodedLL(headH,LL,code);
    }
    public LinkedList enCodedLL(HuffNode<T> root,LinkedList linkedlist,String code){
            if (root != null){
            enCodedLL(root.left,linkedlist,code+0);
            if (root.left==null && root.right==null){
                Node<T>newnode=new Node<>(root.chrc,code);

                 linkedlist.sortedInsert(newnode);
                 code="";

            }
            enCodedLL(root.right,linkedlist,code+1);}
            return linkedlist;
    }
    public void deCode(String fileIn,String fileOut){
        try {
            BufferedReader bf= new BufferedReader(new FileReader(fileIn));
            String[] code=bf.readLine().split("");
            bf.close();
            BufferedWriter bfw=new BufferedWriter(new FileWriter(fileOut));
            HuffNode<T> iterator =headH;
            for (int i = 0; i <code.length ; i++) {
                while (iterator.chrc==null){
                    if (code[i].compareTo("0")==0){
                        iterator=iterator.left;
                        break;
                        }else if(code[i].compareTo("1")==0) {
                        iterator=iterator.right;
                        break;
                        }
                }
                if (iterator.chrc!=null){
                bfw.write(iterator.chrc);
                iterator =headH;}
            }
            bfw.close();
        }catch (Exception e){
            System.out.println(e);
        }


    }
    public boolean test(String code){
    String[]codelist=code.split("");
    boolean test=false;
    HuffNode<T>iterator=headH;
        for (int i = 0; i < codelist.length; i++) {
            test=false;
            if (codelist[i].compareTo("0")==0){
                iterator=iterator.left;

            }
            if (codelist[i].compareTo("1")==0){
                iterator=iterator.right;

            }
            if (iterator.right==null && iterator.left==null){
                test=true;
                iterator=headH;
            }
        }
        return test;
    }

}
