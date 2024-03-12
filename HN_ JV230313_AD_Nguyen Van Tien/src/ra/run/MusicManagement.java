package ra.run;

import ra.model.Singer;
import ra.model.Song;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class MusicManagement {
    static Scanner scanner = new Scanner(System.in);
    static int choise;
    static Singer[] singers = new Singer[100];
    static int singerCount = 0;

    static Song[] songs = new Song[100];
    static int songCount = 0;

    public static void main(String[] args) {
        while (true) {
            System.out.println("************************MUSIC-MANAGEMENT*************************");
            System.out.println("1. Quản lý ca sĩ");
            System.out.println("2. Quản lý bài hát");
            System.out.println("3. Tìm kiếm bài hát");
            System.out.println("4. Thoát");

            System.out.println("Mời bạn nhập lựa chọn mong muốn : ");
            choise = Integer.parseInt(scanner.nextLine());

            switch (choise) {
                case 1:
                    singerManagement();
                    break;

                case 2:
                    songManagement();
                    break;

                case 3:
                    searchSong();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

    public static void singerManagement() {
        System.out.println("**********************SINGER-MANAGEMENT*************************");
        System.out.println("1.Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới (có validate dữ liệu nhập vào)");
        System.out.println("2.Hiển thị danh sách tất cả ca sĩ đã lưu trữ");
        System.out.println("3.Thay đổi thông tin ca sĩ theo mã id");
        System.out.println("4.Xóa ca sĩ theo mã id");
        System.out.println("5.Thoát");

        System.out.println("Mời bạn nhập lựa chọn mong muốn : ");
        choise = Integer.parseInt(scanner.nextLine());

        switch (choise) {
            case 1:
                System.out.println("Mời bạn nhập vào số lượng ca sĩ cần thêm :");
                int addNum = Integer.parseInt(scanner.nextLine());

                for (int i = 0; i < addNum; i++) {
                    System.out.println("Mời nhập thông tin của ca sĩ thứ " + (i + 1));
                    singers[singerCount] = new Singer();
                    singers[singerCount].inputData(scanner);
                    singers[singerCount].setSingerId(singerCount);
                    singerCount++;
                }
                break;

            case 2:
                if (singerCount <= 0) {
                    System.out.println("Hiện không có ca sĩ nào để hiển thị");
                    break;
                }
                for (int i = 0; i < singerCount; i++) {
                    singers[i].displayData();
                }
                break;

            case 3:
                System.out.println("Mời bạn nhập ID của ca sĩ muốn thay đổi thông tin : ");
                int editNum = Integer.parseInt(scanner.nextLine());
                boolean existing = false;

                for (int i = 0; i < singerCount; i++) {
                    if (singers[i].getSingerId() == editNum) {
                        //Singer Name
                        while (true) {
                            System.out.println("Nhập tên của ca sĩ: ");
                            singers[i].setSingerName(scanner.nextLine());
                            if (singers[i].getSingerName().isEmpty()) {
                                System.out.println("Tên của ca sĩ không được để trống!");
                            } else break;
                        }

                        //nationality
                        while (true) {
                            System.out.println("Nhập quốc tịch của ca sĩ : ");
                            singers[i].setNationality(scanner.nextLine());
                            if (singers[i].getNationality().isEmpty()) {
                                System.out.println("Quốc tịch không được để trống!");
                            } else break;
                        }

                        //genre
                        while (true) {
                            System.out.println("Nhập thể loại :");
                            singers[i].setGenre(scanner.nextLine());
                            if (singers[i].getGenre().isEmpty()) {
                                System.out.println("Thể loại không được để trống!");
                            } else {
                                break;
                            }
                        }

                        //age
                        while (true) {
                            System.out.println("Nhập số tuổi của ca sĩ : ");
                            singers[i].setGenre(scanner.nextLine());
                            if (singers[i].getAge() <= 0)
                                System.out.println("Tuổi nhập phải lớn hơn 0");
                            else break;
                        }

                        //gender
                        System.out.println("Giới tính(true/false) :");
                        singers[i].setGender(Boolean.parseBoolean(scanner.nextLine()));
                        if (singers[i].isGender() != true && singers[i].isGender() != false) {
                            System.out.println("Nhập giới tính true hoặc false");
                        }

                        existing = true;
                    }
                }

                if (!existing) {
                    System.out.println("ID đã nhập không tồn tại!");
                }

                break;

            case 4:
                System.out.println("Mời bạn nhập ID của ca sĩ muốn xóa :");
                int deleteNum = Integer.parseInt(scanner.nextLine());

                boolean isDelete = false;
                boolean hasSong = false;

                for (int k = 0; k < songCount; k++) {
                    if (songs[k].getSinger().getSingerId() == deleteNum) {
                        hasSong = true;
                    }
                }

                for (int i = 0; i < singerCount; i++) {
                    if (singers[i].getSingerId() == deleteNum && hasSong == false) {
                        for (int j = i; j < singerCount - 1; j++) {
                            singers[j] = singers[j + 1];
                        }
                        singers[singerCount - 1] = null;
                        singerCount--;
                        isDelete = true;
                        break;
                    }
                }
                if (!isDelete)
                    System.out.println("Ca sĩ đang có bài hát nên không thể xóa");
                break;

            case 5:
                return;
        }

    }

    //songManagement()
    public static void songManagement() {
        System.out.println("**********************SONG-MANAGEMENT*************************");
        System.out.println("1.Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới");
        System.out.println("2.Hiển thị danh sách tất cả bài hát đã lưu trữ");
        System.out.println("3.Thay đổi thông tin bài hát theo mã id");
        System.out.println("4.Xóa bài hát theo mã id");
        System.out.println("5.Thoát");

        System.out.println("Mời bạn nhập lựa chọn mong muốn : ");
        choise = Integer.parseInt(scanner.nextLine());

        switch (choise) {
            case 1:
                System.out.println("Mời bạn nhập vào số lượng bài hát cần thêm :");
                int addNum = Integer.parseInt(scanner.nextLine());

                for (int i = 0; i < addNum; i++) {
                    System.out.println("Mời nhập thông tin của bài hát thứ " + (i + 1));
                    songs[songCount] = new Song();
                    songs[songCount].inputData(scanner, singers, singerCount);
                    songCount++;
                }
                break;

            case 2:
                if (songCount <= 0) {
                    System.out.println("Hiện không có bài hát nào để hiển thị");
                    break;
                }
                for (int i = 0; i < songCount; i++) {
                    songs[i].displayData();
                }
                break;

            case 3:
                System.out.println("Mời bạn nhập ID của bài hát muốn thay đổi thông tin : ");
                String editNum = scanner.nextLine();
                boolean existing = false;

                for (int i = 0; i < songCount; i++) {
                    if (Objects.equals(songs[i].getSongId(), editNum)) {

                        //SongName
                        while (true) {
                            System.out.println("Nhập tên của bài hát :");
                            songs[i].setSongName(scanner.nextLine());
                            if (songs[i].getSongName().isEmpty()) {
                                System.out.println("Tên bài hát không được để trống!");
                            } else {
                                break;
                            }
                        }

                        //descriptions
                        System.out.println("Nhập mô tả của bài hát :");
                        songs[i].setDescriptions(scanner.nextLine());

                        //songWriter
                        while (true) {
                            System.out.println("Nhập tên người sáng tác :");
                            songs[i].setSongWrWriter(scanner.nextLine());
                            if (songs[i].getSongWrWriter().isEmpty()) {
                                System.out.println("Người sáng không được để trống!");
                            } else {
                                break;
                            }
                        }

                        //createdDate
                        songs[i].setCreatedDate(new Date());

                        //songStatus
                        System.out.println("Trạng thái (true/false) :");
                        while (true) {
                            try {
                                songs[i].setSongStatus(Boolean.parseBoolean(scanner.nextLine()));
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

                        for (int j = 0; j < singerCount; j++) {
                            System.out.println((j + 1) + " : " + singers[j].getSingerName());
                        }

                        System.out.println("Mời lựa chọn ca sĩ theo danh sách");
                        while (true) {
                            int choise = Integer.parseInt(scanner.nextLine());
                            if (choise > 0 && choise <= singerCount) {
                                singers[i].setSingerName(singers[choise - 1].getSingerName());
                                break;
                            } else {
                                System.out.println("Số nhập không hợp lệ");
                            }
                        }
                        existing = true;
                    }
                }
                if (!existing) {
                    System.out.println("Không tồn tại ID đã nhập!");
                }
                break;

            case 4:
                System.out.println("Mời bạn nhập ID của bài hát muốn xóa :");
                String deleteNum = scanner.nextLine();

                boolean isExit = false;
                for (int i = 0; i < songCount; i++) {
                    if (Objects.equals(songs[i].getSongId(), deleteNum)) {
                        for (int j = i; j < songCount - 1; j++) {
                            songs[j] = songs[j + 1];
                        }
                        songs[songCount - 1] = null;
                        songCount--;
                        isExit = true;
                        break;
                    }
                }
                if (!isExit)
                    System.out.println("Id không tồn tại");
                break;
            case 5:
                return;
        }
    }

    //searchSong()
    public static void searchSong() {
        System.out.println("*********************SEARCH-MANAGEMENT************************");
        System.out.println("1.Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại .");
        System.out.println("2.Tìm kiếm ca sĩ theo tên hoặc thể loại");
        System.out.println("3.Hiển thị danh sách bài hát theo thứ tự tên tăng dần");
        System.out.println("4.Hiển thị 10 bài hát được đăng mới nhất");
        System.out.println("5.Thoát");

        System.out.println("Mời bạn nhập lựa chọn mong muốn : ");
        choise = Integer.parseInt(scanner.nextLine());

        switch (choise) {
            case 1:
                System.out.println("Mời bạn nhập tên ca sĩ hoặc thể loại để tìm kiếm bài hát");
                String searchKey = scanner.nextLine();

                for (int i = 0; i < songCount; i++) {
                    if (songs[i].getSinger().getSingerName().contains(searchKey) || songs[i].getSinger().getGenre().contains(searchKey) ) {
                        songs[i].displayData();
                    }
                }
                break;

            case 2:
                System.out.println("Mời bạn nhập tên ca sĩ hoặc thể loại để tìm kiếm ca sĩ");
                String searchSinger = scanner.nextLine();
                for (int k = 0; k < singerCount; k++) {
                    if (singers[k].getSingerName().contains(searchSinger) || singers[k].getGenre().contains(searchSinger)) {
                        singers[k].displayData();
                    }
                }
                break;

            case 3:
                for (int i = 0; i < songCount - 1; i++) {
                    for (int j = i + 1; j < songCount; j++) {
                        if (songs[i].getSongName().compareTo(songs[j].getSongName()) > 0) {
                            Song temp = songs[j];
                            songs[j] = songs[i];
                            songs[i] = temp;
                        }
                    }
                }

                for (int i = 0; i < songCount; i++) {
                    songs[i].displayData();
                }

                break;


            case 4:
                for (int i = 0; i < songCount - 1; i++) {
                    for (int j = i + 1; j < songCount; j++) {
                        if (songs[i].getCreatedDate().compareTo(songs[j].getCreatedDate()) < 0) {
                            Song temp = songs[j];
                            songs[j] = songs[i];
                            songs[i] = temp;
                        }
                    }
                }

                int displayCount = Math.min(songCount, 10);
                for (int i = 0; i < displayCount; i++) {
                    songs[i].displayData();
                }
                break;

            case 5:
                return;
        }
    }

}
