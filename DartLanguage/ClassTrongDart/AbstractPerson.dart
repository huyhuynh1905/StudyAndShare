abstract class Person{
  String name;
  int age;

  //Viết một phương thức không định nghĩa
  hienThi();
  //Có thể viết phương thức định nghĩa
  inThongTin(){
    print('Thông tin của lớp trựu tượng!');
  }
}

//Sử dụng abstract class
class Student extends Person{
  var levelClass;
  //Tạo phương thức khởi tạo cho class này
  Student(String name, int age, var levelClass){
    this.name=name;
    this.age=age;
    this.levelClass = levelClass;
  }
  @override
  hienThi() {
    // TODO: implement hienThi
    //Bắt buộc định nghĩa ra
    print(this.name+ " - " +this.age.toString());
  }
}

void main(List<String> args) {
  //Sử dụng
  Student st1 = new Student('Học Sinh 1', 15, 9);
  st1.hienThi();
  st1.inThongTin(); //Đây là sử dụng phương thức của lớp abstract
}