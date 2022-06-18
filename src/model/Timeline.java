package model;

public class Timeline {
    private String movieName;
    private String paymentDate;
    private int adult;
    private int teen;
    private int kid;
    private int totalPrice;

    // constructor for initializing 6 variables
    public Timeline(String movieName, String paymentDate, int adult, int teen, int kid, int totalPrice) {
        this.movieName = movieName;
        this.paymentDate = paymentDate;
        this.adult = adult;
        this.teen = teen;
        this.kid = kid;
        this.totalPrice = totalPrice;
    }

    // getters and setters
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getAdult() {
        return adult;
    }

    public void setAdult(int adult) {
        this.adult = adult;
    }

    public int getTeen() {
        return teen;
    }

    public void setTeen(int teen) {
        this.teen = teen;
    }

    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override // for making values into one String
    public String toString() {
        return "Timeline{" +
                "movieName='" + movieName + '\'' +
                ", paymentDate='" + paymentDate + '\'' +
                ", adult=" + adult +
                ", teen=" + teen +
                ", kid=" + kid +
                ", totalPrice=" + totalPrice +
                '}';
    }


}
