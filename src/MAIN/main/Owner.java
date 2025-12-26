package MAIN.main;

public class Owner {
    private String name;
    private double age;
    private int id;
    private  String sex;


    public Owner(String name, double age, int id , String sex) {
        this.name = name ;
        this.age = age;
        this.id = id;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public int id() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }


    public void setsex (String sex) {
        this.sex = sex;
    }
    public String check_sex(){
        if("female".equalsIgnoreCase(sex)) {
            return "treat someone to tea";
        }
        else {
            return "nothing";
        }
    }
    public  String check_sex2(){
        if("female".equalsIgnoreCase(sex)){
            return "without waiting in line";
            }
            else{
                return "wait in line";
            }
        }

    @Override
    public String toString() {
        return "Owner{name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", sex='" + sex + '\'' +
                '}';
    }

}