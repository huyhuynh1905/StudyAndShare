void main(List<String> args) {
  //Vòng lặp for
  for(var i=0;i<3;i++){
    print('Giá trị của i: $i');
  }

  //Duyệt danh sách (for each)
  var arrays = {'xin', 'chào', 'dart'};
  for (var item in arrays) {
    print('$item');
  }

  //lệnh while
  var count = 0;
  while (count<5) {
    count++;
  }
  print('$count'); //kết quả in ra 5
  //vòng lặp do-while
  do{
    count--;
  } while(count>0);
  print('$count'); //kết quả in ra 0
}