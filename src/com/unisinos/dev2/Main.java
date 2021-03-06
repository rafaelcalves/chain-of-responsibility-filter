package com.unisinos.dev2;

import com.unisinos.dev2.filter.Filter;
import com.unisinos.dev2.filter.impl.*;
import com.unisinos.dev2.model.Student;

import java.util.ArrayList;
import java.util.List;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		List<Student> students = initStudents();
		System.out.println("Lista inicial:");
		printStudents(students);

		Filter<List<Student>> filterNameCourse = new NameStudentsFilter("Maria");
		filterNameCourse.setNext(new CourseStudentFilter("Direito"));

		System.out.println("Aplicado filtro de nome 'Maria' e curso 'Direito'\n");
		printStudents(filterNameCourse.doFilter(students));

		Filter<List<Student>> filterAge = new CourseStudentFilter("Ciência da Computação",
				new AgeBiggerThanStudentFilter(20));

		System.out.println("Aplicado filtro de curso 'CC' e idade '> 20' \n");
		printStudents(filterAge.doFilter(students));

		filterAge.setNext(new NotImplementedFilter());
		try
		{
			System.out.println("Ocorrendo exeção todos os filtros são cancelados em cascata \n");
			printStudents(filterAge.doFilter(students));
		} catch (IllegalAccessException e) {
			System.out.println(e.getMessage());
		}
	}

	private static List<Student> initStudents()
	{
		List<Student> students = new ArrayList<>();
		students.add(new Student("Carlos Alves", 20, "Ciência da Computação"));
		students.add(new Student("Claudia Sales", 17, "Publicidade & Propaganda"));
		students.add(new Student("Maria Clara Batista", 25, "Ciência da Computação"));
		students.add(new Student("Camila Almeida", 23, "Moda"));
		students.add(new Student("Felipe Anacleto", 23, "Análise de Sistemas"));
		students.add(new Student("Rafael Corrêa", 26, "Ciência da Computação"));
		students.add(new Student("Maria Muller", 30, "Direito"));
		return students;
	}

	private static void printStudents(List<Student> students){
		for (Student student:students) {
			System.out.println(student.toString());
		}
	}
}
