import java.util.ArrayList;

class Student extends ClassId{
    private String matric;
    private Dormitory dorm;
    private String phoneNo;
    private static ArrayList<Book> book = new ArrayList<>();

    Student(String n, String p, String m, Dormitory d) {
        super(n);
        phoneNo = p;
        matric = m;
        dorm = d;
        
    }

    public void setDorm(Dormitory dorm) {
        this.dorm = dorm;
    }

    
    String getPhoneNo() {
        return phoneNo;
    }

    
    public String getMatric() {
        return matric;
    }

    public void borrow(Book b) {
        int c = 0;
        book.add(b);
    }

    public void deleteBook(int i, int n){
        if(n == 0)
            book.clear();
        else if(n == 1)
            book.remove(i-1);
    }

    public String toString() {
        System.out.println("\nStudent name: "+super.getName()+"\nPhone no: "+getPhoneNo()+"\nMatric: "+matric+"\nDormitory: "+dorm.getName()+
                "\nDormitory info num: "+dorm.getPhoneNo()+"\nBooks borrowed are:\n");
                for(int i =0; i<book.size(); i++){
                    System.out.print(i+1+") "); System.out.println(book.get(i));
                }
        return " ";
    }
}
