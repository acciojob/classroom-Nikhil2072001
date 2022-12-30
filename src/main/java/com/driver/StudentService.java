package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StudentService {
@Autowired
    StudentRepository studentRepository;
public void   addStudent(Student s){
    studentRepository.addStudent(s);
    return;
}
public void addTeacher(Teacher teacher){
    studentRepository.addTeacher(teacher);

}
public void addStudentTeacherPair(String student,String teacher){
    studentRepository.addStudentTeacherPair(student,teacher);
}
public Student getStudentByName(String name){
    return studentRepository.getStudentByName(name);
}
public Teacher getTeacherByName(String name){
    return studentRepository.getTeacherByName(name);
}
public List<String> getStudentsByTeacherName(String name){
    return studentRepository.getStudentsByTeacherName(name);
}
public List<String> getAllStudents(){
    return studentRepository.getAllStudents();
}
public void deleteTeacherByName(String name){
    studentRepository.deleteTeacherByName(name);
}
public void deleteAllTeachers(){
    studentRepository.deleteAllTeachers();
}
    }
