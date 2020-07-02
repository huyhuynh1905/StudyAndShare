void main(List<String> args) {
  //Khai báo một mảng cố định:
  var listStatic = new List(2);
  listStatic[0] = 5;
  listStatic[1] = 7;
  print(listStatic);//[5, 7]

  //Mảng thay đổi được
  var listDyn = new List();
  listDyn.add('Xin');
  listDyn.add('Chào');
  listDyn.add(19);
  listDyn.add('Bạn');
  print(listDyn);
  //Ngoài ra có thể chèn thêm
  var listAdd = ['huy',12];
  listAdd.insert(0, 'chào');
  listAdd.add('Bạn');
  print(listAdd);
/**
  reversed:	Trả về một đối tượng Iterable chứa các phần tử mảng theo thứ tứ ngược lại
  add():	Thêm một phần tử vào cuối add(element)
  insert():	Chèn một phần tử vào mảng ở vị trí i insert(i,element)
  insertAll():	Chèn một một Iterable bắt đầu từ vị trí i: insertAll(i,iterable)
  remove():	Xóa bỏ phần tử đầu tiền tìm thấy có giá trị chỉ ra remove(data)
  removeAt():	Xóa bỏ phần tử ở vị trí i removeAt(i)
  removeLast():	Xóa bỏ phần tử cuối
  removeRange():	Xóa bỏ phần tử từ vị trí start đến vị trí end removeRange(start, end)*/
}