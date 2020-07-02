enum DayOfWeek {
  monday,
  tuesday,
  wednesday,
  thurday,
  friday,
  saturday,
  sunday
}
void main(List<String> args) {
  var day = DayOfWeek.monday;
  switch(day){
    case DayOfWeek.monday:
      print('Thứ hai!');
      break;
    case DayOfWeek.tuesday:
      print('Thứ ba!');
      break;
    case DayOfWeek.tuesday:
      print('Thứ ba!');
      break;
    case DayOfWeek.wednesday:
      print('Thứ tư!');
      break;
    case DayOfWeek.thurday:
      print('Thứ năm!');
      break;
    case DayOfWeek.friday:
      print('Thứ sáu!');
      break;
    case DayOfWeek.saturday:
      print('Thứ bảy!');
      break;
    case DayOfWeek.sunday:
      print('Thứ chủ nhật!');
      break;
  }
}