public class ListNum {
    private Node head=null;
    public ListNum(){}

    //1. การหาขนาด linked list (ข้อมูลมีกี่ตัวในลิสต์)
    public String size(){
        Node trav=head;
        int count=0;
        while(trav != null){
            count++;
            trav = trav.getLink();
        }
        return "linked list size : " + count;
    }

    //2. การเพิ่มจากด้านหลังลิสต์
    public void insertTail(int newInfo){
        Node newNode = new Node(newInfo);
        Node trav1 = head;
        Node trav2 = head;
        while (trav1 != null) {
            trav2 = trav1; 
            trav1 = trav1.getLink();
        }
        if(trav1 != trav2){
            trav2.setLink(newNode);
        }else head = newNode;
    }

    //3. การเพิ่มโดยการเรียงลำดับ (แทรกในตำแหน่งที่ทำให้ลิสต์เรียงลำดับจากน้อยไปมาก)
    public void insertSort(int newInfo){
        Node newNode = new Node(newInfo);
        Node trav1 = head;
        Node trav2 = head;
        while (trav1 != null && trav1.getInfo() < newNode.getInfo()) {
            trav2 = trav1;
            trav1 = trav1.getLink();
        }
        newNode.setLink(trav1);
        if(trav1 != trav2){
            trav2.setLink(newNode);
        }else head = newNode;
    }

    //4. การลบจากด้านหน้าลิสต์
    public void deleteHead(){
        Node delNode = head;
        if(head != null) head = head.getLink();
    }

    public void addNode(int newInfo) {
    	Node newNode = new Node(newInfo);
		newNode.setLink(head);	
		head = newNode;
    }

    //5. การลบจากด้านหลังลิสต์
    public void deleteTail(){
        Node trav1 = head;
        Node trav2 = head;
        while (trav1 != null && trav1.getLink() != null) {
            trav2 = trav1;
            trav1 = trav1.getLink();
        }
        Node delNode = trav1;
        if(trav2 != null){
            trav2.setLink(null);
            if(delNode == head) head = null;
        }
    }

    //6. การค้นหาเลขที่ต้องการในลิสต์ (หากเจอ บอกว่าเป็นตัวข้อมูลตัวที่เท่าไรในลิงค์ลิสต์ (ข้อมูลตัวแรก นับเริ่มเป็นตัวที่ 1))
    public String searchInfo(int newInfo){
        Node trav1 = head;
        Node trav2 = head;
        int count=0;
        while (trav1 != null) {
            count++;
            if(trav1.getInfo() == newInfo){
                break;
            }else trav2 = trav1;
            trav1 = trav1.getLink();
        }
        
        return "Info number " + count;
    }

    //7. การลบเลขที่ต้องการในลิสต์ (ระบุเลขที่ต้องการลบ)
    public void deleteInfo(int newInfo){
        Node trav1 = head;
        Node trav2 = head;
        while (trav1 != null) {
            if(trav1.getInfo() == newInfo){
                Node delNode = trav1;
                if(trav1 != head){
                    trav2.setLink(trav1.getLink());
                }else head = trav1.getLink();
            }else trav2 = trav1;
            trav1 = trav1.getLink();
        }
    }

    public String toString() {
        Node trav=head;
	    String str="";
	    while (trav!=null) {			
		    str=str.concat(trav.toString());
		    // str=str.concat(""+trav.getInfo());
            trav=trav.getLink();
		    if(trav!=null) str=str.concat(" | ");		
	    }
	    return str;
    }

    public static void main(String[] args) {
        ListNum listNum1=new ListNum();
        listNum1.addNode(10);
        listNum1.addNode(20);
        listNum1.addNode(30);   
        System.out.println(listNum1);

        //1. การหาขนาด linked list (ข้อมูลมีกี่ตัวในลิสต์)
        System.out.println(listNum1.size());

        //2. การเพิ่มจากด้านหลังลิสต์
        listNum1.insertTail(40);    
        System.out.println(listNum1);

        //3. การเพิ่มโดยการเรียงลำดับ (แทรกในตำแหน่งที่ทำให้ลิสต์เรียงลำดับจากน้อยไปมาก)
        listNum1.insertSort(35);
        System.out.println(listNum1);

        //4. การลบจากด้านหน้าลิสต์
        listNum1.deleteHead();
        System.out.println(listNum1);

        //5. การลบจากด้านหลังลิสต์
        listNum1.deleteTail();
        System.out.println(listNum1);

        //6. การค้นหาเลขที่ต้องการในลิสต์ (หากเจอ บอกว่าเป็นตัวข้อมูลตัวที่เท่าไรในลิงค์ลิสต์ (ข้อมูลตัวแรก นับเริ่มเป็นตัวที่ 1))
        System.out.println(listNum1.searchInfo(35));

        //7. การลบเลขที่ต้องการในลิสต์ (ระบุเลขที่ต้องการลบ)
        listNum1.deleteInfo(10);
        System.out.println(listNum1);
    }    
}