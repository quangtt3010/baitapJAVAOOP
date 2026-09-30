
class Student {

    private static int counter = 0;

    private String mssv;
    private String name;
    private double diemCC;
    private double diemGK;
    private double diemCK;
    private String email;
    private String sdt;

    public Student(String name, double diemCC, double diemGK, double diemCK) {
        counter++;
        this.mssv = String.format("B21DCCN%03d", counter); // 
        this.name = name;
        setDiemCC(diemCC);
        setDiemGK(diemGK);
        setDiemCK(diemCK);
    }

    public Student capNhatEmail(String email) {
        this.email = email;
        return this;
    }

    public Student capNhatSdt(String sdt) {
        this.sdt = sdt;
        return this;
    }

    public static int getTotalStudents() {
        return counter;
    }

    public String getMssv() {
        return mssv;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSdt() {
        return sdt;
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
        }
    }

    public void setDiemGK(double diemGK) {
        if (diemGK >= 0 && diemGK <= 10) {
            this.diemGK = diemGK;
        }
    }

    public void setDiemCK(double diemCK) {
        if (diemCK >= 0 && diemCK <= 10) {
            this.diemCK = diemCK;
        }
    }

    public double diemTrungBinh() {
        return (this.diemCC * 0.10) + (this.diemGK * 0.30) + (this.diemCK * 0.60);
    }
}

public class bai2 {

    public static void main(String[] args) {

        Student sv1 = new Student("Lan", 8.0, 7.5, 9.0);
        sv1.capNhatEmail("lan@ptit.edu.vn").capNhatSdt("0912345678");

        Student sv2 = new Student("Huy", 9.0, 8.5, 7.0);
        sv2.capNhatEmail("huy@ptit.edu.vn").capNhatSdt("0987654321");

        Student sv3 = new Student("Mai", 10.0, 9.0, 9.5);

        System.out.println("=== THÔNG TIN SINH VIÊN ===");
        System.out.println(sv1.getMssv() + " - " + sv1.getName() + " - Email: " + sv1.getEmail() + " - SĐT: " + sv1.getSdt());
        System.out.println(sv2.getMssv() + " - " + sv2.getName() + " - Email: " + sv2.getEmail() + " - SĐT: " + sv2.getSdt());
        System.out.println(sv3.getMssv() + " - " + sv3.getName());

        // Kiểm tra tổng số sinh viên gọi qua TÊN LỚP
        System.out.println("\nTổng số sinh viên đã tạo: " + Student.getTotalStudents());
    }
}
