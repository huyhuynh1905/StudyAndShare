class NhanVien {
  //Khai báo thuộc tính
  String name;
  var age;
  var salary;
  //Khai báo hàm khởi tạo, nếu thêm const trước hàm tạo thì đối tượng sinh ra sẽ không thay đổi
  NhanVien(String name, var age, var salary){
    this.name = name;
    this.age = age;
    this.salary = salary;
  }
  //Khởi tạo một đối tượng cụ thể bằng hàm tạo:
  NhanVien.thuKi(String name, var age, {var salary:2000}){
    this.name = name;
    this.age = age;
    this.salary = salary;
  }
  //Tạo một phương thức hiển thị
  @override
  String toString() {
    // TODO: implement toString
    return this.name+" - "+this.age.toString()+ " - " +this.salary.toString();
  }
  thongBao(){
    print('Đây là phương thức của lớp cha!');
  }

  //Một phương thức có static(Sử dụng trực tiếp thông qua tên class):
  static thongTin(){
    print('Đây là class Nhân Viên');
  }
}
void main(List<String> args) {
  //Sử dụng:
  NhanVien nv1 = new NhanVien('Huy', 22, 1500);
  NhanVien nv2 = NhanVien.thuKi('Thư Kí', 25);
  print(nv1.toString()); //Huy - 22 - 1500
  print(nv2.toString()); //Thư Kí - 25 - 2000
  NhanVien.thongTin(); //Đây là class Nhân Viên
}