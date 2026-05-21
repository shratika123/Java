import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MovieDAO movieDAO = new MovieDAO();
        BookingDAO bookingDAO = new BookingDAO();

        while (true) {

            System.out.println("\n===== MOVIE TICKET BOOKING SYSTEM =====");

            System.out.println("1. Add Movie Show");
            System.out.println("2. View Movie Shows");
            System.out.println("3. Update Seats");
            System.out.println("4. Delete Movie Show");

            System.out.println("5. Book Ticket");
            System.out.println("6. View Bookings");
            System.out.println("7. Update Booking");
            System.out.println("8. Cancel Booking");

            System.out.println("9. Exit");

            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    sc.nextLine();

                    System.out.print("Enter Movie Name : ");
                    String movieName = sc.nextLine();

                    System.out.print("Enter Show Time : ");
                    String showTime = sc.nextLine();

                    System.out.print("Enter Total Seats : ");
                    int totalSeats = sc.nextInt();

                    Movie movie =
                            new Movie(movieName,
                                    showTime,
                                    totalSeats,
                                    totalSeats);

                    movieDAO.addMovie(movie);

                    break;

                case 2:

                    movieDAO.viewMovies();

                    break;

                case 3:

                    System.out.print("Enter Movie ID : ");
                    int movieId = sc.nextInt();

                    System.out.print("Enter New Available Seats : ");
                    int seats = sc.nextInt();

                    movieDAO.updateSeats(movieId, seats);

                    break;

                case 4:

                    System.out.print("Enter Movie ID : ");
                    int deleteId = sc.nextInt();

                    movieDAO.deleteMovie(deleteId);

                    break;

                case 5:

                    sc.nextLine();

                    System.out.print("Enter Customer Name : ");
                    String customerName = sc.nextLine();

                    System.out.print("Enter Movie ID : ");
                    int mId = sc.nextInt();

                    System.out.print("Enter Seats To Book : ");
                    int seatsBooked = sc.nextInt();

                    Booking booking =
                            new Booking(customerName,
                                    mId,
                                    seatsBooked);

                    bookingDAO.bookTicket(booking);

                    break;

                case 6:

                    bookingDAO.viewBookings();

                    break;

                case 7:

                    System.out.print("Enter Booking ID : ");
                    int bookingId = sc.nextInt();

                    System.out.print("Enter New Seat Count : ");
                    int newSeats = sc.nextInt();

                    bookingDAO.updateBooking(bookingId, newSeats);

                    break;

                case 8:

                    System.out.print("Enter Booking ID : ");
                    int cancelId = sc.nextInt();

                    bookingDAO.cancelBooking(cancelId);

                    break;

                case 9:

                    System.out.println("Thank You!");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}