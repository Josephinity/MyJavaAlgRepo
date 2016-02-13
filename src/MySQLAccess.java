/**
 * Created by xiaobaby on 2/5/16.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.Exception;
import java.util.*;

public class MySQLAccess {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;


    public void getConnection() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        try{
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/data_dev","root","");
        }catch(Exception e){
            close();
            System.out.println("fail to connect");
            throw e;
        }
    }

    public void deleteFromTable(String tableName){
        try{
            getConnection();
            String del = "delete from ";
            preparedStatement = connect.prepareStatement(del+tableName);
            preparedStatement.execute();
        }catch(Exception e){
            System.out.println("deletion failed");
        }finally{
            close();
        }
    }

    public void insertRows(Map<Integer,String> map){

        try {
            getConnection();
            String insert = "insert into Standard values (?,?)";
            preparedStatement = connect.prepareStatement(insert);
            for(Map.Entry entry:map.entrySet()){
                System.out.println("inserting "+entry.getKey()+" "+entry.getValue());
                preparedStatement.setInt(1, (Integer) entry.getKey());
                preparedStatement.setString(2,(String)entry.getValue());
                preparedStatement.executeUpdate();
            }
        }catch(Exception e){
            System.out.println("cannot insert");
            e.printStackTrace();
        }finally{
            close();
        }
    }

    public void dropTable(String tableName) throws Exception{
        try{
            String query = "Drop table " +tableName;
            statement = connect.createStatement();
            statement.executeUpdate(query);
        }catch(Exception e){
            System.out.println("drop table execution fail");
            throw e;
        }finally{
            close();
        }
    }

    public void createTable() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        try{
            // This will load the MySQL driver, each DB has its own driver
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/data_dev","root","");
            statement = connect.createStatement();
            String query = "CREATE TABLE Standard(" +
                    "id INT not null," +
                    "data VARCHAR(64),"+
                    "PRIMARY KEY(id)"+
                    ")";

            statement.executeUpdate(query);

        }catch(Exception e){
            close();
            throw e;
        }finally {
            close();
        }
    }

    public void readDataBase(String query) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        try{
            // This will load the MySQL driver, each DB has its own driver
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/data_dev","root","");
            statement = connect.createStatement();
            resultSet = statement
                    .executeQuery(query);
            writeMetaData(resultSet);
            printRows(resultSet);
        }catch(Exception e){
            System.out.println("cannot read");
        }finally {
            close();
        }
    }

    private void printRows(ResultSet resultSet) throws Exception{
        while(resultSet.next()){
            for(int i = 1;i<=resultSet.getMetaData().getColumnCount();i++)
                System.out.print(resultSet.getString(i)+"  ");
            System.out.println();
        }
    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //   Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");
        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));

        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i)
            +" "+ resultSet.getMetaData().getColumnTypeName(i));
        }
    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
}
