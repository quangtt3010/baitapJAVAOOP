
import java.util.ArrayList;

class Student {

    private String mssv, name;
    private double diemCC, diemGK, diemCK;

    public Student(String mssv, String name, double diemCC, double diemGK, double diemCK) {
        this.mssv = mssv;
        this.name = name;
        this.diemCC = diemCC;
        this.diemGK = diemGK;
        this.diemCK = diemCK;
    }

    public String getMssv() {
        return mssv;
    }

    public String getName() {
        return name;
    }

    public double diemTrungBinh() {
        return diemCC * 0.1 + diemGK * 0.3 + diemCK * 0.6;
    }
}

class Classroom {

    private String tenLop;
    private ArrayList<Student> danhSach = new ArrayList<>();

    public Classroom(String tenLop) {
        this.tenLop = tenLop;
    }

    public void addStudent(Student s) {
        for (Student item : danhSach) {
            if (item.getMssv().equals(s.getMssv())) {
                throw new IllegalArgumentException("Trùng MSSV: " + s.getMssv());
            }
        }
        danhSach.add(s);
    }

    public String xepLoai(Student s) {
        double dtb = s.diemTrungBinh();
        if (dtb >= 8.0) {
            return "Giỏi";
        }
        if (dtb >= 6.5) {
            return "Khá";
        }
        if (dtb >= 5.0) {
            return "Trung bình";
        }
        return "Yếu";
    }

    public void inBangDiem() {
        System.out.println("=== BẢNG ĐIỂM LỚP " + tenLop + " ===");
        for (Student s : danhSach) {
            System.out.println(s.getMssv() + " - " + s.getName()
                    + " | ĐTB: " + String.format("%.2f", s.diemTrungBinh())
                    + " | Xếp loại: " + xepLoai(s));
        }
        System.out.println("Sĩ số: " + danhSach.size());
    }
}

public class bai3 {

    public static void main(String[] args) {
        Classroom lop = new Classroom("CNTT1");

        // Thêm các sinh viên bình thường
        lop.addStudent(new Student("SV01", "An", 8, 9, 8.5));
        lop.addStudent(new Student("SV02", "Bình", 7, 6, 7));
        lop.addStudent(new Student("SV03", "Cường", 5, 4, 4));

        try {
            lop.addStudent(new Student("SV01", "Dũng", 9, 9, 9));
        } catch (IllegalArgumentException e) {
            System.out.println("Bắt lỗi: " + e.getMessage());
        }

        lop.inBangDiem();
    }
}
