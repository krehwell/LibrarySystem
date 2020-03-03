public class Book {
    private String title;
    private String author;
    private String isbn;
    private String yearRelease;

    Book(String t, String a, String i, String year){
        title = t;
        author = a;
        isbn = i;
        yearRelease = year;
    }

    public String toString() {
        return "Title: "+title+"\nauthor: "+author+"\nisbn: "+isbn+"\nyear release: "+yearRelease+"\n";
    }
}

/*
    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getisbn(){
        return isbn;
    }

    public String getYearRelease()
    {
        return yearRelease;
    }

    public void setTitle(String t){
        title = t;
    }

    public void setAuthor(String a)
    {
        author = a;
    }

    public void setisbn(String i){
        isbn = i;
    }

    public void setYearRelease(String year){
        yearRelease = year;
    }
*/