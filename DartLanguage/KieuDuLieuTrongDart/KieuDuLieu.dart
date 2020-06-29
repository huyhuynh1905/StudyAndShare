void main() {
  //Biến là một số nguyên:
  int n = 42;
  //Biến là chuỗi:
  String str = "Hello Dart";
  //Nhập chuỗi nhiều dòng
  String strLong = '''Hello
    Start With
    Dart''';
  //Biến double
  double d = 1.54;
  //Biến logic
  bool t = true;

  //Biến khai báo bằng var cho phép khai báo biến mà không chỉ rõ nó thuộc kiểu nào
  var s1 = 'hello world';
  //s1 = 5; //Dòng này sẽ lỗi tại vì s1 đã được định nghĩa là một string sau khi gán giá trị cho nó
  //Điều này có nghĩa là nếu s1 đổi nội dung chuỗi thì vẫn đúng.
  
  //Nếu khai báo như sau thì có thể thay đổi kiểu object của biến:
  dynamic s2 = 'dynamic variable';
  print('Biến s2 trước khi thay đổi: $s2');
  s2 = 5; //dòng này hoàn toàn thay đổi giá trị của biến.
  print('Biến s2 sau khi thay đổi: $s2');

  /**Vì mọi thứ trong dart đều là object nên nếu các biến không được khởi tạo giá trị ban đầu thì mặc định
  là null*/
  int obj1;
  var obj2;
  print('Giá trị số nguyên chưa khởi tạo: $obj1');
  print('Giá trị var chưa khởi tạo: $obj2');
}