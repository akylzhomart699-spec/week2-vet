package MAIN.main;

public class Pat {
    private String name;
    private double age;
    private String breed;
    private String problem;


    public Pat(String name, double age, String breed, String problem) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.problem = problem;
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

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }
    // additional method
    public String check_problem(String problem) {
        if ("rabies".equalsIgnoreCase(problem)) {
            return "Kill";
        }
        else {
            return "Treat";
        }
    }
    public String chek_sell(){
        if("mongrel".equalsIgnoreCase(breed)){
            return "sell to the Chinese";
        }
        else {
            return "donate to an animal center";
        }
    }

    @Override
    public String toString() {
        return "Pet{name='" + name + '\'' +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                ", problem='" + problem + '\'' +
                '}';
    }


    }