public class Student {
    // 필드
    private String name;
    private int age;
    private int grade;

    // 생성자
    public Student(String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // 메소드
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void printInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Grade: " + grade);
    }
}
