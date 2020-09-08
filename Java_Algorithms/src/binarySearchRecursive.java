//Class related to the Student.java class. Program that implements a recursive binary search

public class binarySearchRecursive {
	
	public static void main(String[] args) {
		//I chose Lamar as the pivot and placed him as our last element on the list		
		Student Lamar = new Student("Jamal", 88);
		Student students[] = {
				new Student("Renae", 70),
				new Student("Waleed", 86),
				new Student("Luna", 89),
				new Student("Rafael", 92),
				new Student("Leonardo", 73),
				new Student("Akash", 78),
				new Student("Pogba", 71),
				new Student("Luka", 79),
				new Student("Fatou", 82),
				new Student("Gabriela", 94),
				new Student("Ahmed", 80),
				new Student("Sophia", 84),
				new Student("Park", 90),
				Lamar
			
		};
		
		sort(students, 0, students.length);
		//before the loop that shows the list on the console, I call the sort function
		//so when I reach the loop, it reads a sorted array
		
		int found = search(students, 0, students.length, 90);
		//after sorting the array, we can use a binary search algorithm to find a specific value
		
		System.out.println("The chosen grade is in position " + found);
		
		for(int current = 0; current < students.length; current++) {
			
			Student student = students[current];
			System.out.println(student.getName() + " " + student.getGrade());
			
		}
		
	}

	private static int partition(Student[] students, int start, int end) {
	//this function allows us to know how many people have a lower grade so we can divide the array by using
		//a pivot or point of reference each time
		
		int studentsWithLowerGrades = 0;
		//this variable will count the number of students who had grades lower than our pivot
		//this will allow us to know where the pivot student should be placed with classmates having lower grades
		//on the left and classmates having higher grades on the right
		
		Student pivotStudent = students[end - 1];
		// this is our pivot's initial position before the algorithm starts to execute it's steps
		
		for(int current = 0; current < end - 1; current++) {
			
			Student currentStudent = students[current];// isolate current student as a variable so we can analyze it
			
			if(currentStudent.getGrade() <= pivotStudent.getGrade()) {
				//if the current student being analyzed has a lower grade than the current pivot student
				
				swap(students, current, studentsWithLowerGrades);//put that student to the left of our 
				//swap the current student with the student on the studentsWithLowerGrades position
				studentsWithLowerGrades++;
				//after the swap, increment the variable studentsWithLowerGrades by one and do this all over again
				//until we reach the end of the list
				
			}
		
		}
	
		swap(students, end - 1, studentsWithLowerGrades);
		//when this  function's iteration ends, place Lamar right after all the students that had worst grades than him
		
		return studentsWithLowerGrades;
		//The value contained by the variable studentsWithLowerGrades now corresponds to Lamar's place on the list

		
	}
	
	private static void swap(Student[] students, int from, int to) {
		
		Student student1 = students[from];
		Student student2 = students[to];
		students[to] = student1;
		students[from] = student2;
	
	}
	
	private static void sort(Student[] students, int from, int to) {
		//after partitioning and swaping the students according to their grades, it's time to sort them in ascending order
		
		int elements = to - from;// by doing this attribution, we will always be able to get the relative position from where
		//our analysis is going to run up until where it stops, but we have to make sure that the subtraction is always
		//going to be above one, at least. otherwise, in border cases, it would mean we have no element to analyze on the 
		//left and this could crash our code with an out of bounds exception
		
		if(elements > 1) {
			
			int newPivot = partition(students, from, to);
			sort(students, from, newPivot);
			sort(students, newPivot + 1, to);
		
		}
		
	}
	
	private static int search(Student[] students, int from, int to, double grade) {
		
		int middle = (from + to) / 2;
		
		Student student = students[middle];
		
		if(grade == student.getGrade()) {
			
			return middle;
			
		} else if(grade < student.getGrade()) {
			
			return search(students, from, middle - 1, grade);
			
		}else if(grade > student.getGrade()){
			
			return search(students,  middle + 1, to, grade);
			
		}		
			return -1;
		
	}
	
}
