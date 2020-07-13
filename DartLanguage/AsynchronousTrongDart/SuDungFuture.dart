double number = 3.14;
ganThongTin(){
  var num = number;
  throw new Exception('Không gán được thông tin');
  return num;
}
Future<String> inSo() async{
  var data = await ganThongTin();
  print('Hàm in số!');
  print(data);
  return 'Dữ liệu được trả về';
}
inThongBao(){
  print('Thông báo!');
}
inThongTin(String s){
  print(s);
}
void main(List<String> args) {
  Future f = inSo();
  f.then((data) => inThongTin(data));
  inThongBao();
}
