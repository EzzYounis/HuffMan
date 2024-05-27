import java.sql.SQLOutput;

public class Main <T>{
    public static void main(String[] args) {
        LinkedList LL=new LinkedList();
        LL.getLlFile("letter");
        LL.displayFreq();
        HuffmanTree hf=new HuffmanTree();
        hf.creattree(LL);
        LinkedList enCodeedLL=hf.enCodedLL();
        enCodeedLL.displayCode();
        //enCodeedLL.enCode("Source","encoded");
        hf.deCode("encoded","decoded");
        System.out.println(hf.test("1101"));



    }
}