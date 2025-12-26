package MAIN.main;

public class Service {
    private String service;
    private double duration;
    private String size;
    private String aggression;
    private float price;



    public Service(String service, double duration, String size, String aggression, float price) {
        this.service = service;
        this.duration = duration;
        this.size = size;
        this.aggression = aggression;
        this.price = price;
    }

    public String getService() {
        return service;
    }

    public void setservice(String service) {
        this.service = service;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getaggression(String aggression) {
        return aggression;
    }

    public void setaggression(String aggression) {
        this.aggression = aggression;
    }
    public float getPrice() {
        return price;
    }


    public void setprice(float price) {
        this.price = price;
    }

    public boolean apply_discount(String female){
        boolean discount=false;
        if("female".equalsIgnoreCase(female)) {
            discount=true;
        }
        return discount;

    }
    public String chek_size(){
        if("big".equalsIgnoreCase(size)){
            return "2x price";
        }
        else {
            return "ordinary price";
        }
    }

    @Override
    public String toString() {
        return "Service{service='" + service + '\'' +
                ", duration=" + duration +
                ", size='" + size + '\'' +
                ", aggression='" + aggression + '\'' +
                ", price=" + price +
                '}';
    }

}
