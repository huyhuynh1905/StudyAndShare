import 'NhanVien.dart';

class GiamDoc extends NhanVien{
  var responsible;
  //Hàm tạo
  GiamDoc(String name, age, salary, responsible) : super(name, age, salary){
    this.responsible = responsible;
  }
  //Các hàm getter và setter 
  get getResponsible{
    return this.responsible;
  }
  set setName(var name){
    this.name = name;
  }

  @override
  String toString() {
    return super.toString()+" - "+this.responsible.toString();
  }
  //Viết lại phương thức của lớp cha thể hiện tính đa hình :)))
  @override
  thongBao() {
    print('Lớp con sau khi viết lại:');
    super.thongBao(); //có sử dụng thêm phương thức của lớp cha
  }
}

void main(List<String> args) {
  GiamDoc gd = new GiamDoc('Dart', 25, 3600, 1200);
  NhanVien nv = NhanVien.thuKi('Thư Kì', 24);
  print(gd.toString()); //Dart - 25 - 3600 - 1200
  print(nv.toString()); //Thư Kì - 24 - 2000
  gd.thongBao();

  if(nv is NhanVien){
    print('Là Nhân Viên');
  }
}