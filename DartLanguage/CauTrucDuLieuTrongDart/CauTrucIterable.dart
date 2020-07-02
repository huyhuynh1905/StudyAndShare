void main(List<String> args) {
  var itera = new Iterable.generate(10); //Sinh ra 10 phần tử từ 0-10
  for (var item in itera) {
    print(item);
  }
  //Hoặc duyệt bằng foreach
  itera.forEach((element) {
    print(element);
  });

  /**isEmpty:	Thuộc tính kiểm tra xem mảng rỗng
  isNotEmpty:	Thuộc tính kiểm tra xem mảng không rỗng
  length:	Thuộc tính trả về số lượng phần tử mảng
  irst:	Thuộc tính trả về phần tử đầu tiên, tương đương với [0], lỗi nếu mảng rỗng
  last:	Thuộc tính trả về phần tử đầu cuối
  forEach():	Duyệt qua các phần tử */
}