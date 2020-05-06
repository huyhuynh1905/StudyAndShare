<h1 align="center">Start With Git And GitHub</h1>

### Nội Dung:
1. [***Giới thiệu.***](#muc1) 
2. [***Điều khiển cơ bản.***](#muc2) (Local Repository)
3. [***Các lệnh làm việc với Github.***](#muc3) (Remote Repository)
	+ 3.1. [Lệnh git clone.](#muc31)
	+ 3.2. [Lệnh git push.](#muc32)
	+ 3.3. [Lệnh git pull.](#muc33)
	+ 3.4. [Lệnh khác.](#muc34)
4. [***Branching Và Merging.***](#muc4)
	+ 4.1. [Branching. ](#muc41)
	+ 4.2. [Merging.](#muc42)
<a name="muc1"></a>

## 1. Giới thiệu.
![Git](https://techtalk.vn/wp-content/uploads/2018/09/git-logo-1-696x348.png)
- **Hệ thống phân tán:**
-- Giả sử ta lấy ví dụ là việc xây dựng một trái đất trong MineCraft, công việc vô cùng khó khăn và một người không thể tạo ra một trái đất theo tỉ lệ `1 : 1` được. Họ cần phải có sự giúp đỡ của nhiều người ở mọi nơi trên trái đất tham gia và tái tạo lại con đường, thành phố, đất nước của họ đang sống. Làm thế nào bạn có thể cài đặt một hệ thống mà chúng có thể lấy được từng bản ghi của mỗi người một cách dễ dàng? Và tải lên cái mới hơn?
-- Đối với hệ thống quản lí tập trung thì tất cả dữ liệu lưu trữ trên một máy chủ và khi người chơi muốn chơi thì tải về dữ liệu sau đó gửi lên lại kết quả của quá trình chơi. Điều gì sẽ xảy ra nếu một người muốn tái tạo lại thành phố của họ nếu như có người đã cố tình làm sai tỉ lệ hay thực hiện phá hoại? Hoặc là họ muốn so sánh sự khác nhau giữa những lần tái tạo và chỉnh sửa của họ trong game?. Có quá nhiều lí do để yêu cầu lại lần chơi cũ hơn và họ phải thực hiện việc yêu cầu máy chủ trung tâm gửi lại các lần tái tạo, càng nhiều lịch sử thì càng nhiều lần yêu cầu.
-- Điều đó yêu cầu một hệ thống phân tán, người chơi tải về một lần các lịch sử ghi trước đó và việc họ thực hiện chỉnh sửa, tái tạo sẽ không làm ảnh hưởng quá nhiều đến những người chơi khác cho đến khi họ hoàn thành và đóng góp cho trò chơi.
> Không liên quan: Bạn có thể tìm hiểu thêm về việc tái tạo trái đất trong Minecraft [tại đây](https://www.youtube.com/watch?v=bY_O0yxdvds).
- **Git là gì?**
-- Git được biết đến như một hệ thống phân tán, và có thể coi nó là một hệ thống tập trung có mở rộng. Khi người chơi tải về từ máy chủ chính, họ lấy toàn bộ tất cả các lần đã ghi lại, không chỉ mỗi bản cuối cùng. Điều đó có nghĩa là họ trở thành bản sao của máy chủ trung tâm.
-- Git được cài trên máy tính giúp ta quản lí file, quản lí các thay đổi trên các tập tin (quản lí code và lịch sử thay đổi)
> Bạn có thể tải Git và tham khảo thêm từ trang chủ: [https://git-scm.com/](https://git-scm.com/)
- **Github là gì?**
-- Dễ hiểu thì github là một trang web, cung cấp cho chúng ta một kho lưu trữ dữ liệu online. Chúng ta có thể thông qua git để quản lí, tải lên, down xuống, thao tác trên các dự án được lưu trên github.
> Trang chủ của github: [https://github.com/](https://github.com/)

<a name="muc2"></a>
## 2. Điều khiển cơ bản trên Git. (Local Repository)

![git-staging-area](https://kiendt.me/assets/images/git-staging-area.png)

Git có rất nhiều lệnh, việc sử dụng cũng từ những yêu cầu đơn giản đến những yêu cầu phức tạp hơn. Trong phần này sẽ giới thiệu các câu lệnh đơn giản, bắt đầu nhưng tất cả chúng đều hữu dụng. (Thật ra trong quá trình tự học mình toàn dùng chủ yếu các lệnh trong phần này =]]]).
 - Lệnh thiết lập chứng thực cá nhân: (Sử dụng để kết nối git ở máy bạn với tài khoản của github)
	```
	$ git config --global user.name "yourusername" 
	$ git config --global user.email "abcxyz@gmail.com"
	```
 - Trước khi muốn thao tác quản lí trên một thư mục, bạn phải tiến hành thực hiện các lệnh sau trên thư mục bạn muốn quản lí: 
	```
	$ git init  
	$ git add .  #Lệnh này để add toàn bộ data mà thư mục này chứa (dấu .).
	$ git commit -m "Bản sao lưu đầu tiên"
	```
 - Ghi lại trạng thái:
	```
	$ git reset <commit>
	$ git reset --soft <commit>
	$ git reset --hard <commit>
	```
	-- Về cơ bản thì ba lệnh trên đều dùng để quay các commit trước nhưng có những khác nhau như:
	+ `$ git reset <commit>` sử dụng tham số mặc định `--mixed` đưa phiên làm việc về vị trí vừa có những thay đổi xong, chưa tiến hành `git add` (Đưa về commit trước commit trong lệnh).
	+ `$ git reset --soft <commit>` đưa phiên làm việc về tại `<commit>` ta vừa `add` xong (vẫn chưa commit).
	+ `$ git reset --hard <commit>` sẽ đưa phiên làm việc về vị trí `<commit>` đồng thời xoá hết các thay đổi tại commit đó (khá nguy hiểm nhỉ).
	> Tâm sự: git reset rất hữu dụng nhưng hãy cẩn thận với nó nhé, dùng sai nó sẽ trở thành thảm hoạ đấy =))))

- Lịch sử các bản ghi:
	```
	$ git log
	```
	-- Lệnh trên sẽ hiển thị cho bạn các lần đã `<commit>` trước đó dưới dạng một mã `SHA1` như sau:
![git-log](https://images.viblo.asia/53d516c7-c6df-4ae3-a053-8e00d45749db.png)

	-- Các bạn có thể sử dụng các mã commit trên kết hợp với `$ git reset` để quay lại các phiên làm việc tương ứng. Tuy nhiên các bạn có thể sử dụng lệnh `$ git checkout <commit>` để đến phiên thay đổi mà bạn muốn, tuy nhiên khi checkout thì các thay đổi của bạn vẫn coi như là một commit mới.
	-- Để xem rõ hơn các thay đổi trong một phiên làm việc (các file được thay đổi, dòng thay đổi hay thêm mới) từ các mã commit các bạn dùng lệnh:
	
	```
	$ git show <commit>
	```

- Xem trạng thái của phiên làm việc:
	```
	$ git status
	```
	-- Lệnh này sẽ show ra các tệp được sửa đổi hay thêm mới, các tệp và file nào thay đổi đã được `git add`
	![https://i.imgur.com/RAWar1B.png](https://i.imgur.com/RAWar1B.png)
	
> Ngoài ra còn có nhiều lệnh khác mà mình không thường xuyên dùng nên không chia sẽ, các bạn có thể tìm hiểu thêm như: `git diff`, `git revert`, `git rm`, `git mv`,...

<a name="muc3"></a>
## 3. Các lệnh làm việc với Github (Remote Repository)
Các bước thực hiện của mình trình bày là sau khi các bạn đã có tài khoản github, tại [trang chủ github](https://github.com) các bạn thực hiện thêm một `repository` :

![tao moi](https://i.imgur.com/MrNzZ0N.png)

Sau khi tạo xong repository thì các bạn coppy đường dẫn của nó.

![none](https://i.imgur.com/ZSHuLMn.png)

<a name="muc31"></a>
**3.1. Lệnh git clone:**
```
$ git clone <link>
```
- Lệnh này dùng để tải xuống repo về local để làm việc.

![](https://i.imgur.com/mTDnsC1.png)

> Chú ý: Lệnh này sẽ sao chép toàn bộ dữ liệu trên repository và sao chép luôn các thiết lập về repository, tức là nó sẽ tự động tạo một master branch trên máy tính của bạn. Lệnh này chỉ nên sử dụng khi bạn cần tạo mới một Git mới trên máy tính với toàn bộ dữ liệu và thiết lập của một remote repository.

<a name="muc32"></a>
**3.2. Lệnh git push**
- Nếu là lần đầu tiên bạn push các commit lên github thì dùng lệnh: `$ git push -u origin master`

![](https://i.imgur.com/TjZjgoS.png)

- Còn đối với những lần làm việc sau đó bạn chỉ cần dùng lệnh: `$ git push` là được. Sau khi push thì ta thấy trên github đã được đồng bộ hoá giống local.

![](https://i.imgur.com/s1mVhRs.png)

<a name="muc33"></a>
**3.3. Lệnh git pull**
- Khác với lệnh `git clone` thì lệnh này cho phép đồng bộ những thay đổi cuối cùng trên github về máy local: 
	```
	$ git pull <remote-name> <branch-name>
	```
- Các tham giá trị `<remote-name>` và `<branch-name>` có thể có nếu bạn muốn pull đúng với branch remote đó. (Dùng nhiều khi làm việc nhóm, chia sẽ dự án ra các modules).
> Lệnh này sẽ tự động lấy toàn bộ dữ liệu từ remote repository và gộp vào cái branch hiện tại bạn đang làm việc.

<a name="muc34"></a>
**3.4. Lệnh khác**
- Trong 3.1 thì ta thấy có `origin` trong lệnh `git clone`.`origin` trong đoạn đó chính là **tên remote repository**. Mặc định khi clone một repository thì nó tự đặt tên là `origin`.
- Các bạn có thể dùng lệnh `$ git remote -v` để xem tên trên remote.

![](https://i.imgur.com/zoIoRbB.png)

- Nếu muốn đổi tên các bạn có thể dùng lệnh:
	```
	$ git remote rename <ten_cu> <ten_moi>
	```
- Trường hợp bạn muốn thêm một remote để lấy dữ liệu thì dùng lệnh:
	```
	$ git remote add <ten-remote> <link-remote>
	```
- Và bạn muốn lấy dữ liệu từ remote mới thêm vào thì dùng lệnh `$ git fetch <ten-remote>` tuy nhiên lệnh này chỉ lấy về và lưu vào database của Git trên máy chứ không được gộp vào repository của bạn. Còn nếu muốn nó lấy về trực tiếp mà không cần gộp thì sử dụng lệnh `git pull tên_remote`.
	> Để gộp vào repository của bạn trên máy thì dùng lệnh `git merge <ten-remote>`

>  Chú ý: Lệnh `git fetch` sẽ lấy toàn bộ dữ liệu từ remote repository nhưng sẽ cho phép bạn gộp thủ công vào một branch nào đó trên thư mục Git ở máy tính.

<a name="muc4"></a>
## 4. Branching Và Merging
![](https://www.nobledesktop.com/image/gitresources/git-branches-merge.png)

<a name="muc41"></a>
**4.1. Branching**

Khi làm việc với nhiều người dùng trong một dự án thì phải chia công việc cho các thành viên. `git branch` cung cấp cho chúng ta việc phân nhánh làm việc độc lập mà không ảnh hưởng tới nhánh `master`
- Dùng lệnh `$ git checkout -b <ten-branch>` để tạo mới một branch và chuyển phiên làm việc đến branch đó. Để kiểm tra xem đang là việc với branch nào ta có thể dùng lệnh `$ git branch`.
![](https://i.imgur.com/w6meRqu.png)

- Tại branch `test` mình tiến hành code thêm một file JavaScript và  **commit** nó. Sau đó ta `$ git checkout master` thì các file làm việc trong branch `test` sẽ biến mất trong thư mục (VisualCode sẽ có dòng `deleted` cạnh mỗi file). 
![](https://i.imgur.com/ggNfUm0.png)

	> Các file có làm việc trên branch `test` và đã commit.
	
	![](https://i.imgur.com/Lpw5Z8v.png)
	> Sau khi quay lại branch `master` thì các file này biến mất (VSC có phần mở rộng là `deleted`)
	
<a name="muc42"></a>
**4.2. Merging**

Merging là hành động kéo các branch khác vào một branch nào đấy. Ví dụ như gộp branch `test` ở trên vào branch `master`. Đầu tiên các bạn phải `$ git checkout master` (checkout vào branch bạn muốn gộp) -> Sau đó dùng lệnh `$ git merge test` để gộp `test` vào `master`.

![](https://i.imgur.com/d9L1Dfz.png)

> Xem thêm: Sau khi hoàn thành công việc tại branch nào đó mình muốn xoá nó đi thì có thể dùng lệnh: `$ git branch -D <ten-branch>`.

> Về cơ bản thì mình viết những thứ cơ bản về sử dụng git và github, nếu tương lai được làm việc với các vấn đề hay hơn của git thì chắc sẽ có những bài viết kiểu tự học như này tiếp theo =)))
> > Mọi đóng góp vui lòng comment vào bên dưới nhé :P !