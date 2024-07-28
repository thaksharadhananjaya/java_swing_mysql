package student.management.Services;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import student.management.Models.Student;
import student.management.Config.MySqlConnection;

/**
 *
 * @author thakshara
 */
public class StudentService {

    private final static String TABLE_NAME = "students";
    private final Connection connection;

    public StudentService() {
        this.connection = MySqlConnection.connect();
    }

    public ArrayList<Student> getAll() {
        String insertQuery = "SELECT * FROM " + TABLE_NAME + " ORDER BY id";
        ArrayList<Student> students = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String faculty = resultSet.getString("faculty");
                String department = resultSet.getString("department");
                students.add(new Student(id, name, age, faculty, department));
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return students;
    }

    public void create(Student student) {
        String insertQuery = "INSERT INTO " + TABLE_NAME + " (name, age, faculty, department) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            //
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, String.valueOf(student.getAge()));
            preparedStatement.setString(3, student.getFaculty());
            preparedStatement.setString(4, student.getDepartment());
            preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(int id, Student student) {
        String updateQuery = "UPDATE " + TABLE_NAME + " SET name = ?, age = ?, faculty = ?, department = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            //
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, String.valueOf(student.getAge()));
            preparedStatement.setString(3, student.getFaculty());
            preparedStatement.setString(4, student.getDepartment());
            preparedStatement.setString(5, String.valueOf(id));
            preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int id) {
        String updateQuery = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            //
            preparedStatement.setString(1, String.valueOf(id));
            preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
