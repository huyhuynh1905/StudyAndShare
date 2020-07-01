import 'NhanVien.dart';

class HoatDong implements NhanVien{
  @override
  var age;

  @override
  String name;

  @override
  var salary;

  @override
  thongBao() {
    // TODO: implement thongBao
    throw UnimplementedError();
  }
}

mixin M {
  String namemixin;
  displayMixin(){
    print('Đây là mixin');
  }
}
class Merge with M{
  String nameMerge;

  Merge(String nameMerge, String nameMixin){
    this.namemixin = nameMixin;
    this.nameMerge = nameMerge;
  }
  displayMerge() {
    print('Đây là Merger');
  }
}
void main(List<String> args) {
  Merge mer = new Merge('Merger', 'Mixin');
  mer.displayMixin();
  mer.displayMerge();
}