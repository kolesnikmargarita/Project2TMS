package tms.kolesnik.project.database;

import org.postgresql.Driver;
import tms.kolesnik.project.Source;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ConnectionPool {


    public static final String URL_PROPERTY_NAME = "url";
    public static final String USER_PROPERTY_NAME = "url";
    public static final String PASSWORD_PROPERTY_NAME = "url";
    public static final String POOL_CAPACITY_PROPERTY_NAME = "pool.size";

    public static final String PROPERTIES_FILE_NAME = "database.properties";

    public static final String DEFAULT_ERROR_MESSAGE = "Не удалось установить соединение с БД";

    private static final ConnectionPool instance = new ConnectionPool();

    private final BlockingQueue<Connection> connections;

    private ConnectionPool() {
        initializeDatabaseDriver();

        final Properties properties = readDatabaseConnectionProperties();

        final int poolCapacity = Integer.parseInt(properties.getProperty(POOL_CAPACITY_PROPERTY_NAME));
        this.connections = new ArrayBlockingQueue<>(poolCapacity);

        instantiateConnections(properties);
    }

    public static Connection getConnection() {
        try {
            return Objects.requireNonNull(instance.connections.poll(2, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            return null;
        }
    }

    public static void returnConnection(Connection connection) {
        instance.connections.add(connection);
    }

    private void initializeDatabaseDriver() {
        try {
            DriverManager.registerDriver(new Driver());
            //Class.forName("org.postgresql.Driver");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Properties readDatabaseConnectionProperties() {
        final Properties dbConnectionProperties = new Properties();

        try {
            final InputStream stream = Objects.requireNonNull(
                    Thread.currentThread().getContextClassLoader().getResource(PROPERTIES_FILE_NAME)
            ).openStream();
            dbConnectionProperties.load(stream);
        } catch (IOException e) {
            throw new RuntimeException(DEFAULT_ERROR_MESSAGE, e);
        }

        return dbConnectionProperties;
    }

    private void instantiateConnections(Properties properties) {
        try {
            for (int i = 0; i < 20; i++) {
                connections.add(DriverManager.getConnection(
                        properties.getProperty(URL_PROPERTY_NAME),
                        properties.getProperty(USER_PROPERTY_NAME),
                        properties.getProperty(PASSWORD_PROPERTY_NAME)
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(DEFAULT_ERROR_MESSAGE);
        }
    }









    /*private ConnectionPool {

        initializeDatabaseDriver();

        //read database properties
        Properties databaseProperties = new Properties();
        try {
            databaseProperties.load(
                    getClass().getClassLoader().getResourceAsStream("database.properties")
            );
        } catch (IOException exception) {
            throw new RuntimeException("Ошибка чтения конфигурации подключения БД");
        }

        final int poolSize = Integer.parseInt(databaseProperties.getProperty("pool.size"));
        connection = new ArrayBlockingQueue<>(poolSize);

        for (int i = 0; i < poolSize; i++) {
            try {
                connection.add(DriverManager.getConnection(url, username, password));
            } catch (SQLException exception) {
                throw new RuntimeException("Не удалось установить соединение с БД");
                //лог об ошибке
            }
        }
    }

    private void initializeDatabaseDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }*/






    /*private static Connection statement;
    private static ConnectionPool instance;

    private ConnectionPool() throws SQLException {
        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection(Source.DB_URL, Source.DB_USERNAME, Source.DB_PASSWORD);
            statement = connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        if(instance == null) {
            instance = new ConnectionPool();
        }
        return statement;
    }*/

    /*public void getData(String tableName) throws SQLException{
        statement.executeQuery("select * from" + tableName);
    }

    public void setData(String tableName, HashMap<String, String> fieldsValues) {
        //function of entering data in database tables
    }*/

}