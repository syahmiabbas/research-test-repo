class DatabaseConnection {
    private String connectionString;

    private DatabaseConnection() {
        connectionString = "jdbc:mysql://localhost:3306/mydb";
        System.out.println("Database connection established");
    }
    
    private static final DatabaseConnection INSTANCE = new DatabaseConnection();
    
    public static DatabaseConnection getInstance() {
        return INSTANCE;
    }
    
    public String getConnection() {
        return connectionString;
    }
}

public class Main {
    public static void main(String[] args) {
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();

        System.out.println("Same instance? " + (db1 == db2));
        System.out.println("Connection: " + db1.getConnection());
    }
}
