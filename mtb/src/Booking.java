public class Booking {

    String customerName;
    int movieId;
    int seatsBooked;

    public Booking(String customerName,
                   int movieId,
                   int seatsBooked) {

        this.customerName = customerName;
        this.movieId = movieId;
        this.seatsBooked = seatsBooked;
    }
}