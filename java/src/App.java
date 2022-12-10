import java.sql.*;

public class App {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost/railway_reservation_system";
    static final String USER = "postgres";
    static final String PASSWORD = "postgres";

    public static void main(String[] args) {
        double t1 = System.currentTimeMillis();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = connection.createStatement();
            System.out.println("Successfully connected to the database: " + DB_URL);

            // perform the required task here

            // RegisterationWrapper registerationWrapperObj = new RegisterationWrapper();
            // registerationWrapperObj.registerRoutes(connection);
            // registerationWrapperObj.registerStations(connection);
            // registerationWrapperObj.registerTrains(connection);

            TrainScheduleWrapper trainScheduleWrapperObj = new TrainScheduleWrapper();
            trainScheduleWrapperObj.init(connection);
            // trainScheduleWrapperObj.scheduleTrains(connection);
            // trainScheduleWrapperObj.relieveTrains(connection);
            // TrainSearchingProcedures obj = new TrainSearchingProcedures();
            // obj.findTrains("00017","00006", connection);

            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        System.out.println("Program executed successfully!");
        double t2 = System.currentTimeMillis();
        System.out.println("Time = "+(t2-t1));
    }
}
