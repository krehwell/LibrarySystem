public abstract class ClassId {
    private String name;

    ClassId(String n){
        name = n;
    }

    public String getName() {
        return name;
    }

    abstract String getPhoneNo();

    String getMatric() {
        return null;
    }
}
