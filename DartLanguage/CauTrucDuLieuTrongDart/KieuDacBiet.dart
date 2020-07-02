import 'dart:collection';

void main(List<String> args) {
  //Set
  var s = Set();
  s.add(1);
  s.add('Dart');
  s.forEach((element) {
    print(element);
  });
  //Hàng đợi -- có import thư viện
  var q = new Queue();
  q.add('A');
  q.add('B');
  q.addFirst('A0');
  q.addLast('B0');
  print(q);
  q.removeFirst();
  q.removeLast();
  q.remove('B');

  /** Trong hàng đợi ngoài các phương thức của iterable thì còn có:
   * add, addLast	Thêm phần tử vào cuối hàng add(ele); hoặc addLast(ele)
   * addFirst	Thêm phần tử vào đầu hàng addFirst(ele);
   * removeFirst()	Xóa phần tử đầu tiên
   * removeLast()	Xóa phần tử cuối cùng
   * remove()	Xóa 1 phần tử remove(ele) */

  //HashMap
  var h = new HashMap();
  h['1'] = 10;
  h['2'] = 20;
  h['3'] = 'Hello';
  print(h);
  for (var item in h.keys) {
    print('${h[item]}');
  }

}