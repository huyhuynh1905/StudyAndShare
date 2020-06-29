import 'dart:math';

main(List<String> args) {
  /** Hằng số để lưu giá trị không thể thay đổi. Trong dart có final và const là 2 từ khoá tạo hằng số.
   *  Các biến được khai báo như một property của 1 class thì có thể là final, còn const thì không.
   *  Có thể khai báo const trong class bằng cách thêm static const.
   */

  final number1 = 0; //một hằng số gán giá trị 0;
  //number1 = 1; Dòng này lỗi vì đã thay đổi giá trị của hằng số.
  //Chỉ rõ luôn kiểu dữ liệu:
  final int number2 = 123;
  print(number1);

  //Sử dụng const
  const number3 = 2;
  print(number3);

  //Ví dụ sau đây cho thấy sự khác nhau giữa final và const
  //final
  var randomNum = Random().nextInt(20);
  final random1 = randomNum * 2; //Đối với final thì dòng lệnh này hoàn toàn thực hiện được.
  //Hàm final nó cố định giá trị qua mỗi lần chạy.
  print('Giá trị của random final: $random1');

  //const
  //const random2 = randomNum * 3; //Lỗi ngày vì const cố định ngay từ khi viết code
}