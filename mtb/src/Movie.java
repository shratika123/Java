public class Movie {

    int movieId;
    String movieName;
    String showTime;
    int totalSeats;
    int availableSeats;

    public Movie(String movieName,
                 String showTime,
                 int totalSeats,
                 int availableSeats) {

        this.movieName = movieName;
        this.showTime = showTime;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
    }
}