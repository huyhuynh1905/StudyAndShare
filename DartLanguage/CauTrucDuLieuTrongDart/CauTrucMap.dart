void main(List<String> args) {
  //Tạo map bằng new
  var map1 = new Map();
  map1['id'] = '001';
  map1['name'] = 'Huy';
  map1['age'] = 22;
  //duyệt map bằng foreach
  map1.forEach((key, value) {
    print('$key : có giá trị $value');
  });
  //Duyệt map bằng for in
  for(var key in map1.keys){
    print('$key :  ${map1[key]}');
  }


  //Khởi tạo và gán phần tử:
  var map2 = { 'id':002,
              'name':'huỳnh',
              'age':22};

  /** 
   * addAll	Thêm các phần tử từ một map khác addAll(othemap)
   * clear	Làm rỗng Map clear();
   * containsKey	containsKey(key) kiểm tra phần tử với key tồn tại
   * remove()	remove(key) xóa phần tử khỏi map */
}