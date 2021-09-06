<h1 align="center">Factory Pattern</h1>

Có nhiều thứ để tạo ra đối tượng thay vì sử dụng toán tử **_new_**. Với **Factory Pattern** sẽ học được rằng khởi tạo là một hoạt động không phải lúc nào cũng được thực hiện công khai, và điều đó thường dẫn đến các vấn đề về sự phụ thuộc.
Khi sử dụng **_new_**, bạn chắc chắn đang tạo một object của lớp con, do đó, chắc chắn là một “programing to implement” (Khái niệm này được nhắc ở [Strategy Pattern](https://github.com/huyhuynh1905/StudyAndShare/tree/master/DesignPattern/StrategyPattern)), không phải là “programing to interface” .
### Nội dung
1. [***Factory Method.***](#muc1) 
2. [***Factory Pattern.***](#muc2)
3. [***Tóm tắt.***](#muc3)


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
**Định nghĩa chính thức**: **Factory Pattern** xác định một interface để tạo một đối tượng, nhưng cho phép các lớp con quyết định lớp nào sẽ khởi tạo. Factory Pattern giao việc khởi tạo đối tượng cụ thể cho lớp con.
**Lợi ích**: Bằng cách đặt tất cả code tạo đối tượng của mình vào một object hoặc phương thức, chúng ta tránh trùng lặp code của mình và cung cấp một nơi để thực hiện bảo trì. Điều đó có nghĩa là các client chỉ phụ thuộc vào các interface thay vì các lớp cụ thể để khởi tạo đối tượng. => Cho phép chúng ta lập trình trên một giao diện (interface), không phải là lặp trình trên một triển khai (implementation) => làm cho code linh hoạt, dễ mở rộng trong tương lai.

**Nguyên tắc nghịch đảo  phụ thuộc (Dependency Inversion - DI)**: Kiểu trừu tượng không nên phụ thuộc vào kiểu chi tiết. Ngược lại kiểu chi tiết nên phụ thuộc kiểu trừu tượng.
> + Nghe có vẻ giống với "Lập trình trên một giao diện, không phải là triển khai". Tuy nhiên thì nguyên tắc này đưa ra tuyên bố mạnh mẽ hơn, nó cho thấy rằng **các thành phần cấp cao không nên phụ thuộc vào các thành phần cấp thấp, thay vào đó thì cả 2 nên phụ thuộc vào trừu tượng.** - hơi lú tí nhưng mà kiểu như có một trừu tượng ở giữa các thành phần cấp cao và các thành phần cấp thấp vậy.
> + Gọi là nguyên tắc "sự đảo ngược" vì nó đảo ngược cách thường nghĩ về thiết kế OO.

**Một vài hướng dẫn để giúp làm theo nguyên tắc này:**(Đây là hướng dẫn cố gắng thực hiện, hơn là một nguyên tắc tuân thủ thực hiện - Vd: Các lớp không có khả năng thay đổi thì không vấn đề gì khi tạo một đối tượng cụ thể)
- Không có biến giữ một tham chiếu đến lớp cụ thể (như khi sử dụng `new` ).
- Không có lớp xuất phát từ một lớp cụ thể (như vậy sẽ khiến phụ thuộc vào một lớp cụ thể).

**Ví dụ:** Tiếp tục ví dụ ở phần 1. Chúng ta cần đảm bảo các cửa hàng nhượng quyền ở Hà Nội và Sài Gòn sử dụng các thành phần nguyên liệu chất lượng theo chính công thức của Cửa hàng. Mỗi thành phố có một bộ nguyên liệu khác nhau để dùng cho cửa hàng tại đó.
Nhớ lại ở phần 1, nguyên liệu được tạo ra trong abstract class `Pizza`, các lớp con kế thừa từ `Pizza` tuỳ ý chỉnh nguyên liệu. Vấn đề đặt ra ở đây là lớp cha `Pizza` muốn quản lí quá trình tạo nguyên liệu luôn, vì vậy mà bước tạo nguyên liệu tách ra thành 1 factory `PizzaIngredientFactory` đảm bảo rằng các lớp con tạo nguyên liệu bằng cách dùng factory mà lớp cha cung cấp. Nào chúng ta bắt đầu:
1. Sửa lại các class với cấu trúc như sau:
<div align="center"><img  src="https://github.com/huyhuynh1905/StudyAndShare/blob/master/DesignPattern/FactoryPattern/src/main/resources/cautruc.PNG"/></div>

> Giải thích: Ta có các class `ThickCrusDough`, `ThinCrusDough` extends từ abstract class `AbsDough`. Tương tự class `BrusSauce`, `TomatoSauce` extends từ abstract class `AbsSauce`.

2. Sửa lại class abstract `AbsPizza` khác với `Pizza` ở phần 1.
```java
public abstract class AbsPizza {
    String name;
    AbsDough dough;
    AbsSauce sauce;

    abstract void prepare();

    void bake(){
        System.out.println("Bake the pizza");
    }
    void cut(){
        System.out.println("Cutting the pizza");
    }
    void box(){
        System.out.println("Box the pizza");
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
```
3. Các class `CheesePizza` và `ClamPizza` extends từ abstract class `AbsPizza` . Ngoài ra có kết hợp một biến interface `PizzaIngredientFactory` như sau: 
```java
public class CheesePizza extends AbsPizza {
    PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("Preparing "+name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
    }
}
```
Đơn nhiên phải tạo các class `HNPizzaIngredientFactory` và `SGPizzaIngredientFactory` implement interface `PizzaIngredientFactory` chính là các nguyên liệu được sản xuất tại SG hay HN cho pizza:
```java
public class HNPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public AbsDough createDough() {
        return new ThinCrusDough();
    }

    @Override
    public AbsSauce createSauce() {
        return new BrusSauce();
    }
}
```
4. Cuối cùng là class `HNPizzaStore`:
```java
public class HNPizzaStore extends AbsPizzaStore {
    @Override
    protected AbsPizza createPizza(String nameOfPizza) {
        AbsPizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new HNPizzaIngredientFactory();
        if (nameOfPizza.equals("Cheese")){
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("HN Cheese Pizza");
        }
        if (nameOfPizza.equals("Clam")){
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("HN Clam Pizza");
        }

        return pizza;
    }
}
```
> **Abstract Factory Pattern:** cung cấp cho chúng ta một giao diện để tạo một "bộ sản phẩm". Bằng cách này chúng ta có thể tách code khỏi factory thực tế tạo các sản phẩm.

**Định nghĩa Abstract Factory Pattern:** cung cấp một interface có chức năng tạo một tập hợp các đối tượng liên quan phụ thuộc lẫn nhau mà không chỉ ra đó là những lớp cụ thể nào tại thời điểm thiết kế.

**So sánh giữa Factory Method và Abstract Factory:**
- Cả 2 đều tạo ra các đối tượng.
- **Factory Method:** Tạo ra đối tượng thông qua thừa kế (muốn tạo ra đối tượng cần phải extends từ một lớp và override lại phương thức factory). => Giúp chương trình độc lập với kiểu (type) cụ thể.
- **Abstract Factory:** Tạo ra đối tượng thông qua kết hợp (composition) đối tượng. Các lớp con của kiểu trừu tượng sẽ xác định cách thức các sản phẩm đó được tạo ra. => Giống Factpry Method những nơi sử dụng factory của Abstract Factory sẽ hoàn toàn độc lập với những products cụ thể.

<a name="muc3"></a>
## 3. Tóm tắt lại nội dung.
- Tất cả các factory đóng gói việc tạo ra đối tượng.
- **Simple Factory** không phải là một mẫu thiết kế thực sự, nó chỉ là một các đơn giản để tách client code của bạn khỏi concreted class.
- **Factory Method** dựa vào sự thừa kế: việc tạo đối tượng được uỷ quyền cho các lớp con thực hiện phương thức Factory để tạo đối tượng.
- **Abstract Factory** dựa vào kết hợp đối tượng: việc tạo đối tượng được thực hiện theo các phương thức được hiển thị trong interface của factory.
-   Tất cả các mẫu Factory thúc đẩy đạt tới “khớp nối lỏng lẻo” bằng cách giảm sự phụ thuộc của ứng dụng của bạn vào các lớp cụ thể.
-   Mục đích của **Factory Method**  là cho phép một lớp trì hoãn việc khởi tạo đối với các lớp con của nó.
-   Mục đích của  **Abstract Factory**  là tạo ra một bộ của các đối tượng liên quan mà không phải phụ thuộc vào các lớp cụ thể của chúng.
-   Nguyên tắc nghịch đảo phụ thuộc hướng dẫn chúng ta tránh phụ thuộc vào các loại cụ thể và cố gắng trừu tượng hóa.
-   **Factory** là một kỹ thuật mạnh mẽ để đạt tới trình độ “**_coding to abstractions_**”, không phải là “**_coding to concrete_**” nữa.
