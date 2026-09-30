
public class bai1 {

    public static void main(String[] args) {
        Student sv1 = new Student("SV001", "Nguyễn Văn A", 9.0, 8.0, 7.5);
        Student sv2 = new Student("SV002", "Trần Thị B", 10.0, 9.0, 9.5);
        Student sv3 = new Student("SV003", "Lê Văn C", 8.0, 6.5, 7.0);

        System.out.println("DANH SÁCH SINH VIÊN BAN ĐẦU");
        inThongTin(sv1);
        inThongTin(sv2);
        inThongTin(sv3);

        System.out.println("\nKIỂM TRA ĐIỀU KIỆN CHẶN ĐIỂM HỢP LỆ");

        System.out.print("Thử setDiemGK(-1): ");
        sv1.setDiemGK(-1);

        System.out.print("Thử setDiemGK(11): ");
        sv1.setDiemGK(11);

        System.out.println("Điểm GK của sv1 sau khi thử gán sai: " + sv1.getDiemGK());

        System.out.println("\nTHAY ĐỔI ĐIỂM SV1");
        sv1.setDiemGK(10);

        inThongTin(sv1);
        inThongTin(sv2);
        inThongTin(sv3);
    }

    private static void inThongTin(Student sv) {
        System.out.println("MSSV: " + sv.getMssv() + "| Tên: " + sv.getName() + " | ĐTB: "
                + sv.diemTrungBinh());
    }

}

class Student {

    private String mssv;
    private String name;
    private double diemCC;
    private double diemGK;
    private double diemCK;

    public Student(String mssv, String name, double diemCC, double diemGK, double diemCK) {
        this.mssv = mssv;
        this.name = name;
        setDiemCC(diemCC);
        setDiemGK(diemGK);
        setDiemCK(diemCK);
    }

    public String getMssv() {
        return mssv;
    }

    public String getName() {
        return name;
    }

    public double getDiemCC() {
        return diemCC;
    }

    public double getDiemGK() {
        return diemGK;
    }

    public double getDiemCK() {
        return diemCK;
    }

    public void setDiemCC(double diemCC) {
        if (diemCC >= 0 && diemCC <= 10) {
            this.diemCC = diemCC;
        } else {
            System.out.println("Lỗi: Điểm chuyên cần phải nằm trong khoảng [0, 10]. Không cập nhật!");
        }
    }

    public void setDiemGK(double diemGK) {
        if (diemGK >= 0 && diemGK <= 10) {
            this.diemGK = diemGK;
        } else {
            System.out.println("Lỗi: Điểm giữa kỳ phải nằm trong khoảng [0, 10]. Không cập nhật!");
        }
    }

    public void setDiemCK(double diemCK) {
        if (diemCK >= 0 && diemCK <= 10) {
            this.diemCK = diemCK;
        } else {
            System.out.println("Lỗi: Điểm cuối kỳ phải nằm trong khoảng [0, 10]. Không cập nhật!");
        }
    }

    public double diemTrungBinh() {
        return (this.diemCC * 0.10) + (this.diemGK * 0.30) + (this.diemCK * 0.60);
    }

}
