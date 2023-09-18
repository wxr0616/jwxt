package ceshi;

public class teacher {
	private Integer tno;
    private String tname;
    private String tsex;
    private String dept;
    
 
    public Integer getTno() {
        return tno;
    }
 
    public String getTname() {
        return tname;
    }
 
    public String getTsex() {
        return tsex;
    }
 
    public String getDept() {
        return dept;
    }
 
 
    public void setTno(Integer tno) {
        this.tno = tno;
    }
 
    public void setSname(String tname) {
        this.tname = tname;
    }
 
    public void setTsex(String tsex) {
        this.tsex = tsex;
    }
 
 
    public void setDept(String dept) {
        this.dept = dept;
    }
 

 

    public teacher(Integer tno, String tname, String tsex,  String dept) {
        this.tno = tno;
        this.tname = tname;
        this.tsex = tsex;
        this.dept = dept;
    }
 
    public teacher() {
        super();
    }
 
    @Override
    public String toString() {
        return "teacher{" +
                "tno=" + tno +
                ", tname='" + tname + '\'' +
                ", tsex='" + tsex + '\'' +
                ",dept='" + dept + '\'' +
                "}";
    }
}
