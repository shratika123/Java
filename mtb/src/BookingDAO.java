import java.sql.*;

public class BookingDAO {

    Connection conn = DBConnection.getConnection();

    // BOOK TICKET
    public void bookTicket(Booking booking) {

        try {

            String seatQuery =
                    "SELECT available_seats FROM movies WHERE movie_id=?";

            PreparedStatement seatPst =
                    conn.prepareStatement(seatQuery);

            seatPst.setInt(1, booking.movieId);

            ResultSet rs = seatPst.executeQuery();

            if (rs.next()) {

                int availableSeats =
                        rs.getInt("available_seats");

                if (availableSeats >= booking.seatsBooked) {

                    String insertQuery =
                            "INSERT INTO bookings(customer_name, movie_id, seats_booked) VALUES(?,?,?)";

                    PreparedStatement pst =
                            conn.prepareStatement(insertQuery);

                    pst.setString(1, booking.customerName);
                    pst.setInt(2, booking.movieId);
                    pst.setInt(3, booking.seatsBooked);

                    pst.executeUpdate();

                    int remainingSeats =
                            availableSeats - booking.seatsBooked;

                    String updateQuery =
                            "UPDATE movies SET available_seats=? WHERE movie_id=?";

                    PreparedStatement updatePst =
                            conn.prepareStatement(updateQuery);

                    updatePst.setInt(1, remainingSeats);
                    updatePst.setInt(2, booking.movieId);

                    updatePst.executeUpdate();

                    System.out.println("Ticket Booked Successfully!");

                } else {

                    System.out.println("Not Enough Seats!");
                }

            } else {

                System.out.println("Movie Not Found!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // VIEW BOOKINGS
    public void viewBookings() {

        try {

            String query = "SELECT * FROM bookings";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                System.out.println("\nBooking ID : " +
                        rs.getInt("booking_id"));

                System.out.println("Customer Name : " +
                        rs.getString("customer_name"));

                System.out.println("Movie ID : " +
                        rs.getInt("movie_id"));

                System.out.println("Seats Booked : " +
                        rs.getInt("seats_booked"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // UPDATE BOOKING
    public void updateBooking(int bookingId, int seats) {

        try {

            String query =
                    "UPDATE bookings SET seats_booked=? WHERE booking_id=?";

            PreparedStatement pst =
                    conn.prepareStatement(query);

            pst.setInt(1, seats);
            pst.setInt(2, bookingId);

            int rows = pst.executeUpdate();

            if (rows > 0) {

                System.out.println("Booking Updated Successfully!");

            } else {

                System.out.println("Booking Not Found!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // DELETE BOOKING
    public void cancelBooking(int bookingId) {

        try {

            String query =
                    "DELETE FROM bookings WHERE booking_id=?";

            PreparedStatement pst =
                    conn.prepareStatement(query);

            pst.setInt(1, bookingId);

            int rows = pst.executeUpdate();

            if (rows > 0) {

                System.out.println("Booking Cancelled Successfully!");

            } else {

                System.out.println("Booking Not Found!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}