package com.example.examences3.servlet;

import com.example.examences3.dao.Student;
import com.example.examences3.database.ConexionMySql;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


    @WebServlet("/students-average-age")
    public class StudentsAverageAgeServlet extends HttpServlet {

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                // establece conexión a la base de datos
                Connection connection = ConexionMySql.getConnection();
                Statement statement = connection.createStatement();

                // ejecuta consulta SQL para obtener estudiantes y cursos
                String query = "SELECT s.*, c.course_name FROM students s JOIN courses c ON s.id_course = c.id";
                ResultSet resultSet = statement.executeQuery(query);

                // lista de todos los estudiantes junto con los cursos en los que están inscritos
                List<Student> allStudents = new ArrayList<>();
                while (resultSet.next()) {
                    Student student = new Student();
                    student.setId(resultSet.getInt("id"));
                    student.setName(resultSet.getString("name"));
                    student.setLastname(resultSet.getString("lastname"));
                    student.setAge(resultSet.getInt("age"));
                    student.setId_course(resultSet.getInt("id_course"));

                    allStudents.add(student);
                }

                // calcula la edad promedio
                int totalAge = 0;
                for (Student student : allStudents) {
                    totalAge += student.getAge();
                }
                double averageAge = (allStudents.size() > 0) ? (double) totalAge / allStudents.size() : 0.0;

                // filtra estudiantes cuya edad es mayor al promedio
                List<Student> studentsAboveAverageAge = new ArrayList<>();
                for (Student student : allStudents) {
                    if (student.getAge() > averageAge) {
                        studentsAboveAverageAge.add(student);
                    }
                }

                // crea objeto JSON de respuesta
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String json = gson.toJson(studentsAboveAverageAge);

                // configura respuesta HTTP
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);

                // cierra conexión a la base de datos
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

