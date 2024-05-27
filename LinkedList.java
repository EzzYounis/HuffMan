
    import java.io.*;
    import java.nio.file.Files;
    import java.nio.file.Paths;
    import java.util.Comparator;

    public class LinkedList<T extends Comparable>  {

        private Node<T> head;
        public Node<T> createNode(String val){
            return new Node<T>(val);
        }
        public void sortedInsert(Node newNode){
            if(head==null){
                head=newNode;
                return;
            }else{
                Node<T>iterator=head;
                while (iterator.next!=null){
                    iterator=iterator.next;

                }
                iterator.next=newNode;
                bubblesort();
            }}
        public void getLlFile(String file){ //A Method to create a linked-list of the characters with their frequencies

            try {
                String sc = new String(Files.readAllBytes(Paths.get(file)));
                String[] list = sc.split("");
                for (int i = 0; i <list.length ; i++) {
                    Insert(list[i]);
                }
                bubblesort();
            }catch (Exception e){
                System.out.println(e);
            }
        }
        public void Insert(String Chrc){
            Node<T> newNode = createNode(Chrc);
            if (head!=null && search(Chrc)!=null) {
                search(Chrc).freq++;
                bubblesort();
                return;
            }else if(head==null){
                head=newNode;
                return;
            }else{
            Node<T>iterator=head;
            while (iterator.next!=null){
                iterator=iterator.next;

            }
            iterator.next=newNode;

        }}

        public Node<T> getHead(){
            return head;
        }




        public void displayFreq(){
            Node<T>iterator=head;
            while (iterator!=null){
                if (iterator.charc.equals("\n"))
                {
                    System.out.println("\\n"+" "+"Frequency = "+ iterator.freq);
                } else if (iterator.charc.equals("\r")) {
                    System.out.println("\\r"+" "+"Frequency = "+ iterator.freq);
                }else{
                System.out.println(iterator+" "+"Frequency = "+ iterator.freq);}
                iterator=iterator.next;
            }
            System.out.println();
        }
        public void displayCode(){
            Node<T>iterator=head;
            while (iterator!=null){
                if (iterator.charc.equals("\n"))
                {
                    System.out.println("\\n"+" "+"Code = "+ iterator.Ccode);
                } else if (iterator.charc.equals("\r")) {
                    System.out.println("\\r"+" "+"Code = "+ iterator.Ccode);
                }else{
                    System.out.println(iterator+" "+"Code = "+ iterator.Ccode);}
                iterator=iterator.next;
            }
            System.out.println();
        }

        public Node<T> search(String val){
            Node<T> iterator=head;
            while (iterator!=null){
                if (iterator.charc.compareTo(val)==0){

                    return iterator;
                }
                iterator=iterator.next;

            }
            return null;
        }
        public int count(){
            int count=0;
            Node<T> iterator=head;
            while  (iterator!=null){
                count+=1;
                iterator=iterator.next;

            }
            return count;
        }
        public Node<T> deleteFirst(){
            Node<T>temp=head;
            head=head.next;
            return temp;
        }


    public void enCode(String fileIn,String fileOut){
            try {
                String StringIn = new String(Files.readAllBytes(Paths.get(fileIn)));
                String[]Chars=StringIn.split("");
                BufferedWriter bfw =new BufferedWriter(new FileWriter(fileOut));
                String encoded="";
                for (int i = 0; i <Chars.length ; i++) {
                    Node<T>iterator=head;
                    while(iterator != null){
                        if (iterator.charc.compareTo(Chars[i])==0){
                        encoded+=iterator.Ccode;}
                        iterator=iterator.next;
                    }
                }
                bfw.write(encoded);
                bfw.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }




        public void swapTwo(Node<T> pre,Node<T> first,Node<T>second){
            Node<T>temp=head;
            if (first==head){
                head=second;
                temp.next=head.next;
                head.next=temp;
                return;
            } else if (second.next==null) {
                second.next=first;
                first.next=null;
                pre.next=second;

            }else {
                first.next=second.next;
                pre.next=second;
                second.next=first;
            }

        }
        public void bubblesort(){
            boolean innerloop;
            boolean outerloop =true; //this boolean to see if there is any swapping happening if not then it wont check again
            while(outerloop){
                outerloop=false;
                Node<T>iterator=head;
                Node<T>previous=head;
                Node<T>tempPrev = null;
                while (iterator.next!=null){
                    innerloop=false;
                    if (iterator.freq>iterator.next.freq){
                        tempPrev=iterator.next;
                        swapTwo(previous,iterator,iterator.next);
                        innerloop=true;
                        outerloop=true;
                    }
                    if (innerloop){
                        if (previous==iterator){
                            previous=tempPrev;
                        }else if (previous.next!=iterator){
                            previous=previous.next;
                        }
                    }else{
                        previous=iterator;
                        iterator=iterator.next;}
                }
            }
        }





    }

