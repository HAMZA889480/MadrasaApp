package Model;

public class Student {
    private String id;
    private String name;
    private String sabak;
    private String sabki;


    public Student(String Name, String Sabak, String Sabki, String Id)
    {
        this.name=Name;
        this.sabak=Sabak;
        this.sabki=Sabki;
        this.id=Id;
    }


    public Student(String Name, String Sabak, String Sabki)
    {
        this.name=Name;
        this.sabak=Sabak;
        this.sabki=Sabki;
    }

    public Student(String Name)
    {
        this.name=Name;
        this.sabak="0";
        this.sabki="0";
    }
    public Student()
    {
        this.name="";
        this.sabak="";
        this.sabki="";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSabak() {
        return sabak;
    }

    public void setSabak(String sabak) {
        this.sabak = sabak;
    }

    public String getSabki() {
        return sabki;
    }

    public void setSabki(String sabki) {
        this.sabki = sabki;
    }
}
