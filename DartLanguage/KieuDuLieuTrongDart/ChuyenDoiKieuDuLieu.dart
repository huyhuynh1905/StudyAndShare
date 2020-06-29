void main(List<String> args) {
  //Chuyển từ string qua int và double
  int a1 = int.parse('12');
  double c1 = double.parse('12.5');
  print('a1: $a1 - c1: $c1');

  //Chuyển từ int qua double và ngược lại
  var c2 = a1.toDouble();
  var a2 = c1.toInt(); //Nó sẽ chỉ nhận giá trị phần nguyên của double.
  print('c2: $c2 - a2: $a2');

  //Chuyển từ số sang chuỗi
  var s1 = (a2+c2).toString();
  print('Số sang chuỗi: $s1');
}