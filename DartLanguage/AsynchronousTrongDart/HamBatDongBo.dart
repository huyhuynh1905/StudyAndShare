double number = 3.14;
inThongTin(){
  var num = number;
  print('Hàm In thông tin: ');
  return num;
}
inSo() async{
  var data = await inThongTin();
  print('Hàm in số!');
  print(data);
}
inThongBao(){
  print('Thông báo!');
}

hamBatDongBo() async {
  //Dùng await trong hàm có async để cho biết chờ các code trong 
  //await thực hiện xong mới thực hiện các code tiếp theo
  await {
    print('code trong await'), //dùng dấu phẩy để ngăn cách khối lệnh
    print('code khác trong await')
  };
  print('code ngoài await');
  return 1;
}


void main(List<String> args) {
  inSo();
  inThongBao();
}