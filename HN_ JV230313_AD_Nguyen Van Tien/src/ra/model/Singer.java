package ra.model;

import java.util.Scanner;

public class Singer {
    private int singerId, age;
    private String singerName, nationality, genre;

    private boolean gender;

    Scanner scanner = new Scanner(System.in);

    //Contructor

    public Singer() {
    }

    public Singer(int age, String singerName, String nationality, String genre, boolean gender) {
        this.age = age;
        this.singerName = singerName;
        this.nationality = nationality;
        this.genre = genre;
        this.gender = gender;
    }

    //getter

    public int getSingerId() {
        return singerId;
    }

    public int getAge() {
        return age;
    }

    public String getSingerName() {
        return singerName;
    }

    public String getNationality() {
        return nationality;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isGender() {
        return gender;
    }

    //setter

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    //inputData()
    public void inputData(Scanner scanner) {

        //Singer Name
        while (true) {
            System.out.println("Nhập tên của ca sĩ: ");
            this.singerName = scanner.nextLine();
            if (singerName.isEmpty()) {
                System.out.println("Tên của ca sĩ không được để trống!");
            } else break;
        }

        //nationality
        while (true) {
            System.out.println("Nhập quốc tịch của ca sĩ : ");
            this.nationality = scanner.nextLine();
            if (nationality.isEmpty()) {
                System.out.println("Quốc tịch không được để trống!");
            } else break;
        }

        //genre
        while (true) {
            System.out.println("Nhập thể loại :");
            this.genre = scanner.nextLine();
            if (genre.isEmpty()) {
                System.out.println("Thể loại không được để trống!");
            } else {
                break;
            }
        }

        //age
        while (true) {
            System.out.println("Nhập số tuổi của ca sĩ : ");
            this.age = Integer.parseInt(scanner.nextLine());
            if (age <= 0)
                System.out.println("Tuổi nhập phải lớn hơn 0");
            else break;
        }

        //gender
        System.out.println("Giới tính(true/false) :");
        this.gender = Boolean.parseBoolean(scanner.nextLine());
        if (this.gender != true && this.gender != false) {
            System.out.println("Nhập giới tính true hoặc false");
        }
    }

    //displayData()

    public void displayData() {
        System.out.println("Thông tin của ca sĩ là : ");
        System.out.println("ID  : " + this.singerId);
        System.out.println("Tên : " + this.singerName);
        System.out.println("Tuổi  : " + this.age);
        System.out.println("Quốc tịch : " + this.nationality);
        System.out.println("Giới tính : " + (this.gender ? "Nam" : "Nữ"));
        System.out.println("Thể loại : " + this.genre);
        System.out.println("-------------------------------------------");

    }

}
