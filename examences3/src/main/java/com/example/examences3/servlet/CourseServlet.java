package com.example.examences3.servlet;


import com.example.examences3.dao.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

// Servlet para manejar las rutas
    @WebServlet("/students")
    public class CourseServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // Obtener la lista de estudiantes y cursos (simulado aquí)
            List<Student> students = obtenerListaDeEstudiantes();

            // Convertir a JSON usando GSON
            Gson gson = new Gson();
            String jsonStudents = gson.toJson(students);

            // Enviar la respuesta
            response.setContentType("application/json");
            response.getWriter().write(jsonStudents);
        }
    }

    @WebServlet("/students-average-age")
    public class StudentAverageAgeServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // Obtener la lista de estudiantes (simulado aquí)
            List<Student> students = obtenerListaDeEstudiantes();

            // Calcular el promedio de edad
            double averageAge = students.stream().mapToInt(Student::getAge).average().orElse(0);

            // Filtrar estudiantes cuya edad es mayor que el promedio
            List<Student> filteredStudents = students.stream()
                    .filter(student -> student.getAge() > averageAge)
                    .collect(Collectors.toList());

            // Convertir a JSON usando GSON
            Gson gson = new Gson();
            String jsonFilteredStudents = gson.toJson(filteredStudents);

            // Enviar la respuesta
            response.setContentType("application/json");
            response.getWriter().write(jsonFilteredStudents);
        }
    }

