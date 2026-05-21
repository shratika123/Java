import java.sql.*;

public class MovieDAO {

    Connection conn = DBConnection.getConnection();

    // CREATE MOVIE SHOW
    public void addMovie(Movie movie) {

        try {

            String query =
                    "INSERT INTO movies(movie_name, show_time, total_seats, available_seats) VALUES(?,?,?,?)";

            PreparedStatement pst =
                    conn.prepareStatement(query);

            pst.setString(1, movie.movieName);
            pst.setString(2, movie.showTime);
            pst.setInt(3, movie.totalSeats);
            pst.setInt(4, movie.availableSeats);

            pst.executeUpdate();

            System.out.println("Movie Added Successfully!");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // READ MOVIES
    public void viewMovies() {

        try {

            String query = "SELECT * FROM movies";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                System.out.println("\nMovie ID : " +
                        rs.getInt("movie_id"));

                System.out.println("Movie Name : " +
                        rs.getString("movie_name"));

                System.out.println("Show Time : " +
                        rs.getString("show_time"));

                System.out.println("Total Seats : " +
                        rs.getInt("total_seats"));

                System.out.println("Available Seats : " +
                        rs.getInt("available_seats"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // UPDATE AVAILABLE SEATS
    public void updateSeats(int movieId, int seats) {

        try {

            String query =
                    "UPDATE movies SET available_seats=? WHERE movie_id=?";

            PreparedStatement pst =
                    conn.prepareStatement(query);

            pst.setInt(1, seats);
            pst.setInt(2, movieId);

            int rows = pst.executeUpdate();

            if (rows > 0) {
                System.out.println("Seats Updated Successfully!");
            } else {
                System.out.println("Movie Not Found!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // DELETE MOVIE
    public void deleteMovie(int movieId) {

        try {

            String query =
                    "DELETE FROM movies WHERE movie_id=?";

            PreparedStatement pst =
                    conn.prepareStatement(query);

            pst.setInt(1, movieId);

            int rows = pst.executeUpdate();

            if (rows > 0) {
                System.out.println("Movie Deleted Successfully!");
            } else {
                System.out.println("Movie Not Found!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}