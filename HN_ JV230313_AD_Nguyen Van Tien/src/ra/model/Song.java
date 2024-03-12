package ra.model;

import java.util.Date;
import java.util.Scanner;

public class Song {
    Scanner scanner = new Scanner(System.in);

    private String songId,songName,descriptions,songWrWriter;
    private Date createdDate;
    private Boolean songStatus;

    private Singer singer;


    //Contructor

    public Song() {
    }

    public Song(Scanner scanner, String songId, String songName, String descriptions, String songWrWriter, Date createdDate, Boolean songStatus, Singer singer) {
        this.scanner = scanner;
        this.songId = songId;
        this.songName = songName;
        this.descriptions = descriptions;
        this.songWrWriter = songWrWriter;
        this.createdDate = createdDate;
        this.songStatus = songStatus;
        this.singer = singer;
    }

    //Getter

    public Scanner getScanner() {
        return scanner;
    }

    public String getSongId() {
        return songId;
    }

    public String getSongName() {
        return songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public String getSongWrWriter() {
        return songWrWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Boolean getSongStatus() {
        return songStatus;
    }

    public Singer getSinger() {
        return singer;
    }

    //setter

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void setSongWrWriter(String songWrWriter) {
        this.songWrWriter = songWrWriter;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setSongStatus(Boolean songStatus) {
        this.songStatus = songStatus;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    //inputData()
    public void inputData(Scanner scanner, Singer[] singers, int singerCount) {
        //Song ID
        while (true) {
            System.out.println("Nhập ID của bài hát : ");
            this.songId = scanner.nextLine();
            if (songId.length() == 4 && songId.startsWith("S")) {
                break;
            } else {
                System.out.println("ID của bài hát phải có 4 ký tự và bắt đầu bằng kí tự S");
            }
        }

        //SongName
        while (true) {
            System.out.println("Nhập tên của bài hát :");
            this.songName = scanner.nextLine();
            if (songName.isEmpty()) {
                System.out.println("Tên bài hát không được để trống!");
            } else {
                break;
            }
        }

        //descriptions
        System.out.println("Nhập mô tả của bài hát :");
        this.descriptions = scanner.nextLine();

        //songWriter
        while (true) {
            System.out.println("Nhập tên người sáng tác :");
            this.songWrWriter = scanner.nextLine();
            if (songWrWriter.isEmpty()) {
                System.out.println("Người sáng không được để trống!");
            } else {
                break;
            }
        }

        //createdDate
        this.createdDate = new Date();

        //songStatus
        System.out.println("Trạng thái (true/false) :");
        while (true) {
            try {
                this.songStatus = Boolean.parseBoolean(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Nhập trạng thái true hoặc false");
            }
        }

        //singer select
        System.out.println("Lựa chọn ca sĩ thể hiện : ");
        if (singerCount == 0) {
            System.out.println("Hiện không có ca sĩ để chọn");
            return;
        }

        for (int i = 0; i < singerCount; i++) {
            System.out.println((i+1)+" : " + singers[i].getSingerName());
        }

        System.out.println("Mời lựa chọn ca sĩ theo danh sách");
        while (true) {
            int choise = Integer.parseInt(scanner.nextLine());
            if (choise > 0 && choise <= singerCount) {
                this.singer = singers[choise - 1];
                break;
            } else {
                System.out.println("Số nhập không hợp lệ");
            }
        }
    }

    //displayData()
    public void displayData() {
        System.out.println("Thông tin của bài hát là : ");
        System.out.println("Mã bài hát  : " + this.songId);
        System.out.println("Tên bài hát : " + this.songName);
        System.out.println("Mô tả bài hát  : " + this.descriptions);
        System.out.println("Ca sĩ thực hiện : " + this.singer.getSingerName());
        System.out.println("Ngày tạo : " + this.createdDate);
        System.out.println("Người sáng tác : " + this.songWrWriter);
        System.out.println("Trạng thái : " + (this.songStatus? "Đang phát hành" : "Dừng phát hành"));
        System.out.println("-------------------------------------------");

    }
}

