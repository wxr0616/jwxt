package ceshi;

public class Student {
    private Integer sno;
    private String sname;
    private Integer sage;
    private String ssex;
    private String smajor;
    private String sclass;
 
    public Integer getSno() {
        return sno;
    }
 
    public String getSname() {
        return sname;
    }
 
    public Integer getSage() {
        return sage;
    }
 
    public String getSsex() {
        return ssex;
    }
 
   
 
    public String getSmajor() {
        return smajor;
    }
 
    public String getSclass() {
        return sclass;
    }
 
 
    public void setSno(Integer sno) {
        this.sno = sno;
    }
 
    public void setSname(String sname) {
        this.sname = sname;
    }
 
    public void setSage(Integer sage) {
        this.sage = sage;
    }
 
    public void setSsex(String ssex) {
        this.ssex = ssex;
    }
 
 
    public void setSmajor(String smajor) {
        this.smajor = smajor;
    }
 
    public void setSclass(String sclass) {
        this.sclass = sclass;
    }
 

    public Student(Integer sno, String sname, Integer sage, String ssex,  String smajor, String sclass) {
        this.sno = sno;
        this.sname = sname;
        this.sage = sage;
        this.ssex = ssex;
        this.smajor = smajor;
        this.sclass = sclass;
    }
 
    public Student() {
        super();
    }
 
    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                ", ssex='" + ssex + '\'' +
                ", smajor='" + smajor + '\'' +
                ", sclass='" + sclass + '\'' +
                "}";
    }
}
