<h1 align="center">Decorator Pattern (Mẫu Thiết Kế)</h1>

Đặt vấn đề: Để tránh lạm dụng việc kế thừa thì bạn sẽ phải học cách "trang trí" các lớp của mình khi runtime bằng cách sử dụng việc hết hợp (compose). Decorator Pattern cho phép thêm các hành vi mới vào đối tượng mà không cần phải thay đổi code của các lớp bên trong.
**Ví dụ:** Chúng ta mở một cửa hàng Coffee và FastFood. Vì phát triển nhanh nên phải xây dựng một hệ thống đặt hàng để phù hợp với các sản phẩm của mình. Ngoài các sản phẩm tiêu chuẩn thì phải thêm các topping (trân châu, sữa, đường, gia vị,...). 
- Nếu như xây dựng theo cách kế thừa:
<div align="center"><img  src="https://i.imgur.com/BrlKos7.png"/></div>
- Việc tính giá tiền sẽ như thế này:

```java
public Double cost(){
    Double cost = Double.valueOf(0);
    if (isMilk()){
        cost += 10; //Giá của topping milk
    }
    if (isMocha()){
        cost +=5;
    }
    if (isSoy()){
        cost += 8;
    }
    if (isWhip()){
        cost += 15;
    }
    return cost;
}
```
- Các loại đồ uống, thức ăn như Coffee, MilTea,... sẽ kế thừa từ class này và chọn các giá trị cho topping thêm vào. Mặc dù đúng với việc thừa kế, tuy nhiên sử dụng thừa kế không phải lúc nào cũng sẽ làm tăng tính linh hoạt và bảo trì cho code. Giả sử như chúng ta gặp các vấn đề như:
	- Thay đổi giá của các topping -> Thay đổi code.
	- Thêm topping mới -> Thay đổi code ở class cha.
	- Các loại đồ uống có thể có các topping không dùng đến ->Trà đá không thể nào có thêm topping Tea.
	- Số lượng topping gấp đôi.
*Ta có nguyên tắc thiết kế - The Open-Closed Principle:* **Class nên mở cho việc mở rộng, nhưng đóng cho việc sửa đổi.**
> Mục tiêu là cho phép các lớp dễ dàng được mở rộng để kết hợp với hành vi mới mà không cần sửa đổi code hiện có. Điều này có thể khiến các thiết kế có khả năng phục hồi để thay đổi và đủ khả thi để đảm nhận chức năng mới đáp ứng các yêu cầu thay đổi.

> Có những kĩ thuật cho phép mở rộng code nhưng không cần sửa đổi trực tiếp. Tuy nhiên cần cẩn thận khi chọn nơi code cần được mở rộng, áp dụng nguyên tắc đóng mở MỌI NƠI là lãng phí, không cần thiết và có thể sẽ làm cho code phức tạp và khó hiểu.

### Sử dụng Decorator Pattern:
**Nội dung:** Mẫu trang trí gắn các trách nhiệm bổ sung cho một đối tượng một cách linh hoạt. Mẫu trang trí cung cấp một sự thay thế linh hoạt cho phân lớp để mở rộng chức năng.

Chúng ta bắt đầu với một loại đồ uống và "Trang trí" nó bằng ác Topping, ví dụ với Coffee ta thêm các topping Milk, Sugar:
1. Lấy một đối tượng Coffee.
2. Trang trí nó với đối tượng Milk.
3. Trang trí nó với đối tượng Sugar.
4. Gọi phương thức cost() và dựa vào uỷ quyền (delegate) để tính tiền cho các loại topping.

Được rồi, nó sẽ thể hiện ở code như sau:
B1: Chúng ta có một Class cha có phương thức cost() tính toán giá tiền của đồ uống như sau:
<div align="center"><img  src="https://i.imgur.com/I7i469h.png"/></div>
B2: Một đối tượng là một Đồ uống, thức ăn mà khách hàng muốn mua. Nó kế thừa lớp ở trên:
<div align="center"><img  src="https://i.imgur.com/AXgGbkr.png"/></div>
B3: Chúng ta cũng có một lớp trừu tượng *Decorator* cũng kế thừa từ Component trên, lớp này dùng để mô tả các loại topping và các đối tượng topping sẽ kế thừa từ lớp này:
<div align="center"><img  src="https://i.imgur.com/qDYrkyf.png"/></div>
Và các lớp toppong sẽ như sau:
<div align="center"><img  src="https://i.imgur.com/9cmGGbd.png"/></div>
B4: Giờ chúng ta có thể phục vụ sản phẩm của chúng ta và tính tiền bằng cách bọc lại bằng các đối tượng Topping. Nếu như cần thêm gấp đôi topping thì chúng ta chỉ cần bọc nó 2 lần, chúng ta cũng có thể dễ dàng sửa giá từng loại toping mà không ảnh hưởng đến các class khác cũng như có thể thêm vào topping và thức uống:
<div align="center"><img  src="https://i.imgur.com/ufdWHwT.png"/></div>


Các hạn chế của Decorator:
1. Có thể cần phải thêm rất nhiều lớp nhỏ vào một thiết kế khiến nó khó hiểu.
2. Một số code phụ thuộc vào các lớp con và khi bắt đầu đưa vào các decorators có thể dẫn đến lỗi.
> Áp dụng các Decorator có thể làm tăng độ phức tạp của code cần thiết để khởi tạo component. Decorator thường được sử dụng với các mẫu khác như **Factory** và **Builder** để giải quyết các hạn chế trên.

**Tóm tắt nội dung**:
- Kế thừa là một hình thức mở rộng, nhưng không nhất thiết là cách tốt nhất để đạt được sự linh hoạt trong các thiết kế.
- Code nên cho phép mở rộng các hành vi mà không cần sửa đổi các code hiện có.
- *Composition* và *Delegation* thường có thể sử dụng để thêm các hành vi mới *in runtime*.
- *Decorator Pattern* cung cấp một sự thay thế cho subclass để mở rộng hành vi.
- *Decorator Pattern* bao gồm một tập hợp các lớp trang trí được sử dụng để bọc các concrete component (là các class kế thừa từ lớp component)
-  Các lớp *Decorator* phản chiếu các loại thành phần mà nó trang trí. (Trên thực tế, chúng cùng loại với các component mà chúng trang trí, thông qua kế thừa hoặc implement interface.)
-   Các *Decorator* thay đổi hành vi của các component của chúng bằng cách thêm chức năng mới trước và/hoặc sau (hoặc thậm chí thay thế) các cuộc gọi phương thức đến component.
-   Bạn có thể bọc một component với bao nhiêu decorator tuỳ thích.
-   Decorator thường **transparent** (trong suốt – nghĩa là client chỉ biết đến các lớp base class trừu tượng bên trên mà không cần biết đến các lớp con cụ thể) với client của component.
-   Decorators có thể dẫn đến nhiều đối tượng nhỏ trong thiết kế của bạn và việc sử dụng quá mức có thể *phức tạp*.