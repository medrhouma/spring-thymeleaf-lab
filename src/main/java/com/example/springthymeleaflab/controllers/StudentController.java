package com.example.springthymeleaflab.controllers;

import com.example.springthymeleaflab.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/students")
public class StudentController {
    // In-memory storage for students (in a real app, this would be a database)
    private List<Student> students = new ArrayList<>();

    @GetMapping("/list")
    public String listStudents(@RequestParam(required = false) String search,
                               @RequestParam(required = false) String searchBy,
                               Model model) {

        List<Student> filteredStudents = students;

        if (search != null && !search.isEmpty()) {
            String searchLower = search.toLowerCase();

            if ("name".equals(searchBy)) {
                filteredStudents = students.stream()
                        .filter(s -> s.getName().toLowerCase().contains(searchLower))
                        .collect(Collectors.toList());
            }else if ("major".equals(searchBy)) {
                filteredStudents = students.stream()
                        .filter(s -> s.getMajor().toLowerCase().contains(searchLower))
                        .collect(Collectors.toList());
            } else {
                // Default to searching all fields
                filteredStudents = students.stream()
                        .filter(s -> s.getName().toLowerCase().contains(searchLower)||
                                s.getMajor().toLowerCase().contains(searchLower)||
                                s.getEmail().toLowerCase().contains(searchLower))
                        .collect(Collectors.toList());
            }
        }
        model.addAttribute("students", filteredStudents);
        model.addAttribute("search", search);
        model.addAttribute("searchBy", searchBy);
        return "students/list";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("student", new Student());
        return "students/register";
    }

    @PostMapping("/register")
    public String registerStudent(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "students/register";
        }

        students.add(student);
        return "redirect:/students/list";
    }

    @GetMapping("/edit/{index}")
    public String showEditForm(@PathVariable int index, Model model) {
        if (index >= 0 && index < students.size()) {
            model.addAttribute("student", students.get(index));
            model.addAttribute("index", index);
            return "students/edit";
        }
        return "redirect:/students/list";
    }

    @PostMapping("/update/{index}")
    public String updateStudent(@PathVariable int index, @Valid @ModelAttribute("student") Student student,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("index", index);
            return "students/edit";
        }

        if (index >= 0 && index < students.size()) {
            students.set(index, student);
        }

        return "redirect:/students/list";
    }
    @GetMapping("/delete/{index}")
    public String deleteStudent(@PathVariable int index) {
        if (index >= 0 && index < students.size()) {
            students.remove(index);
        }
        return "redirect:/students/list";
    }

    @GetMapping("/confirm-delete/{index}")
    public String confirmDelete(@PathVariable int index, Model model) {
        if (index >= 0 && index < students.size()) {
            model.addAttribute("student", students.get(index));
            model.addAttribute("index", index);
            return "students/confirm-delete";
        }
        return "redirect:/students/list";
    }
    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        // Calculate statistics
        Map<String, Integer> majorStats = new HashMap<>();

        for (Student student : students) {
            String major = student.getMajor();
            majorStats.put(major, majorStats.getOrDefault(major, 0) + 1);
        }

        model.addAttribute("majorStats", majorStats);
        model.addAttribute("totalStudents", students.size());

        return "students/dashboard";
    }
}