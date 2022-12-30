package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentMap;
    HashMap<String,Teacher> teacherMap;
    HashMap<String, List<String>> studentTeacherMap;

    public StudentRepository(HashMap<String, Student> studentMap, HashMap<String, Teacher> teacherMap, HashMap<String, List<String>> studentTeacherMap) {
        this.studentMap = studentMap;
        this.teacherMap = teacherMap;
        this.studentTeacherMap = studentTeacherMap;
    }

    public void addStudent(Student s){
      String name = s.getName();
      studentMap.put(name,s);
    }
    public void addTeacher(Teacher teacher){
        String name = teacher.getName();
        teacherMap.put(name,teacher);
    }
    public void addStudentTeacherPair(String student,String teacher){
        List<String> l = new ArrayList<>();
        if(studentTeacherMap.containsKey(teacher)){
            l = studentTeacherMap.get(teacher);
            l.add(student);
            studentTeacherMap.put(teacher,l);
        }else{
            l.add(student);
            studentTeacherMap.put(teacher,l);
        }
    }
    public Student getStudentByName(String name){
        for(String s : studentMap.keySet()){
            if(s.equals(name))
                return studentMap.get(s);
        }
        return null;
    }
    public Teacher getTeacherByName(String name){
        for(String s : teacherMap.keySet()){
            if(s.equals(name))
                return teacherMap.get(s);
        }
        return null;
    }
    public List<String> getStudentsByTeacherName(String name){
        List<String> l = new ArrayList<>();
        if(studentTeacherMap.containsKey(name))
            return studentTeacherMap.get(name);
            return l;

    }
    public List<String> getAllStudents(){
        List<String> l = new ArrayList<>();
        for(String s:studentMap.keySet())
            l.add(s);
        return l;
    }
public void deleteTeacherByName(String name){
        List<String >l = new ArrayList<>();
        if(studentTeacherMap.containsKey(name)) {
            l = studentTeacherMap.get(name);
            for (String s : l) {
                if (studentMap.containsKey(s)) studentMap.remove(s);
            }
            if(teacherMap.containsKey(name))
                teacherMap.remove(name);
            studentTeacherMap.remove(name);
        }
}
public void deleteAllTeachers(){
       teacherMap= new HashMap<>();
    HashSet<String> set = new HashSet<>();
       for(String s:studentTeacherMap.keySet()){
           for(String ss:studentTeacherMap.get(s))
               set.add(ss);
       }
       for(String s: set){
           if(studentMap.containsKey(s))
               studentMap.remove(s);
       }
       studentTeacherMap= new HashMap<>();
}
}
