public class Dormitory extends ClassId{
    private String collegeDetail;
    private String dormNo;
    Dormitory(String c){
        super(c);
     
    }

    String getPhoneNo() {
        return "60402789112";
    }

    public void setDormNo(String dormNo) {
        this.dormNo = dormNo;
    }

    public String toString() {
        return collegeDetail;
    }
}