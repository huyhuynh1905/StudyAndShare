void main(List<String> args) {
  int a = 5;
  var b = 7;
  
  //Câu lệnh if-else
  if(a>b){
    print('A lớn hơn B');
  }
  //if-else lồng nhau
  if (a<b){
    print('A nhỏ hơn B');
  } else if(a==b){
    print('A bằng B');
  } else {
    print('A Lớn hơn B');
  }

  //Lệnh rẽ nhánh:
  switch(a){
    case 1:
      print('A = 1');
      break;
    case 2:
      print('A = 2');
      break;
    default:
      print('A lớn hơn 2');
  }

  // Đảm bảo một đối tượng khác null
  assert(a != null);
  // Đảm bảo số lớn hơn 100
  assert(b > 100);

}