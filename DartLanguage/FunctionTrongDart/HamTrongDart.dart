
double tinhTong(var a, double b){
  return a+b;
}
//Nếu chỉ đơn giản trả về thì ta có thể viết
double tinhHieu(var a, double b) => a-b; //Chỉ sử dụng được khi có 1 tham số là var/dynamic

//hàm có giá trị mặc định
double tinhTich(var a, {double b:2, double c:3}){
  return a*b*c;
}
//Hàm có giá trị ngẫu nhiên
double tinhThuong(var a, [double b]){
  if(b!=null){
    return a/b;
  }
  return a;
}
//Hàm không có kiểu trả về
inManHinh(var name){
  print('Xin chào $name');
}

//Hàm ẩn danh dùng làm callbacl trong các hàm khác:
hamAnDanh(int a, int b, var printKetQua){
  int c = a+b;
  printKetQua(c);
}


void main(List<String> args) {

  inManHinh('Dart');

  double tong = tinhTong(5.0, 6.0);
  double hieu = tinhHieu(7.0, 3.0);
  double nhan1 = tinhTich(5.0);
  double thuong1 = tinhThuong(5.5); //Không cần truyền b
  double thuong2 = tinhThuong(9.0,3.0); //Truyền b

  //Khai báo hàm ẩn danh chạy luôn
  var c = (int a, int b){
    return a+b;
  }(5,6);

  //Gọi hàm ẩn danh callback
  hamAnDanh(10, 6, inManHinh);
  //Hoặc
  hamAnDanh(10, 11, (c){print('Tổng là: $c');});
}