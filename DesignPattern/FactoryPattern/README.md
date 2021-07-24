<h1 align="center">Factory Pattern</h1>

Có nhiều thứ để tạo ra đối tượng thay vì sử dụng toán tử **_new_**. Với **Factory Pattern** sẽ học được rằng khởi tạo là một hoạt động không phải lúc nào cũng được thực hiện công khai, và điều đó thường dẫn đến các vấn đề về sự phụ thuộc.
Khi sử dụng **_new_**, bạn chắc chắn đang tạo một object của lớp con, do đó, chắc chắn là một “programing to implement” (Khái niệm này được nhắc ở [Strategy Pattern](https://github.com/huyhuynh1905/StudyAndShare/tree/master/DesignPattern/StrategyPattern)), không phải là “programing to interface” .
### Nội dung
1. [***Factory Method.***](#muc1) 
2. [***Factory Pattern.***](#muc2)


<a name="muc1"></a>
## 1. Factory Method.
Factory method định nghĩa interface giúp client tạo object nhưng ủy quyền cho các concreate factory để xác định class nào được trả về cho client. Được sử dụng với mục đích: 
-   Đưa toàn bộ logic của việc tạo mới object vào trong factory, che giấu logic của việc khởi tạo.
-   Giảm sự phụ thuộc nhằm tăng tính mở rộng.

**Ví dụ:** Chúng ta kinh doanh một cửa hàng Pizza với nhiều loại Pizza, chúng ta sẽ sử dụng phương thức factory để định nghĩa loại pizza mà khách order. Tuy nhiên thì cửa hàng chúng ta có nhiều chi nhánh ở nhiều thành phố cho nên các cửa hàng ở các thành phố có những đặc điểm của loại pizza khác nhau. Chỉ với một vài biến đổi cho **PizzaStore**, chúng ta đã chuyển từ việc chỉ có một đối tượng xử lý việc khởi tạo các lớp cụ thể của chúng tôi thành một tập hợp các lớp con hiện đang đảm nhận trách nhiệm đó. Được rồi, chúng ta bắt đầu với ví dụ này thôi:

1. Đầu tiên chúng ta cần có Pizza và các loại Pizza kế thừa từ nó:
```java
abstract public class Pizza {
    String name;
    String dough;
    String sauce;
    ArrayList<String> toping = new ArrayList();

    void prepare(){
        System.out.println("Prepare pizza with name: "+name);
        System.out.println("... Dough");
        System.out.println("... Sauce");
        for (int i =0;i<toping.size();i++){
            System.out.println("    ... "+toping.get(i));
        }
    }

    void bake(){
        System.out.println("Bake the pizza");
    }

    void cut(){
        System.out.println("Cutting the pizza");
    }

    void box(){
        System.out.println("Box the pizza");
    }

    public String getName() {
        return name;
    }
}
```
```java
public class HNStyleCheesePizza extends Pizza {
    public HNStyleCheesePizza() {
        name = "HNStyleCheesePizza";
        dough = "Thin";
        sauce = "Many";

        toping.add("Topping cheese fomat HN");
    }
}
```
```java
public class HNStyleClamPizza extends Pizza {
    public HNStyleClamPizza(){
        name = "HNStyleClamPizza";
        dough = "Litte";
        sauce = "Many";

        toping.add("Topping Clam HN");
    }
}
```
> Uhm! chúng ta đang tạo các loại Pizza với cách chế biến phù hợp với sở thích của người Hà Nội (HN). Đây là các loại Pizza được bán ở cửa hàng ở Hà Nội trong bước tiếp theo.

2. Để bán Pizza thì chúng ta có một lớp cửa hàng nhằm mục đích order Pizza cho khách hàng, trong lớp đó chúng ta sẽ có một factory method đảm nhận việc tạo ra đối tượng mà method order sẽ không biết được. Nó là một abstract method được viết lại ở mỗi cửa hàng implements nó.
```java
abstract public class PizzaStore {

    Pizza orderPizza(String nameOfPizza){
        Pizza pizza;
        pizza = createPizza(nameOfPizza);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract Pizza createPizza(String nameOfPizza);
}
```
```java
public class HNPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String nameOfPizza) {
        Pizza pizza;
        switch (nameOfPizza){
            case "cheese":
                pizza = new HNStyleCheesePizza();
                break;
            case "clam":
                pizza = new HNStyleClamPizza();
                break;
            default:
                pizza = null;
        }
        return pizza;
    }
}
```
3. Chúng ta chạy thử để xem kết quả:
```java
public class TestMain {
    public static void main(String[] args) {
        PizzaStore hnS = new HNPizzaStore();
        PizzaStore sgS = new SGPizzaStore();

        Pizza pzhnCheese = hnS.orderPizza("cheese");
        System.out.println();
        System.out.println("==================================");
        Pizza pzsgClam = sgS.orderPizza("clam");
    }
}
```
> class SGPizzaStore ta tạo tương tự như HNPizzaStore.
 
 
<a name="muc2"></a>
## 2. Factory Pattern.

