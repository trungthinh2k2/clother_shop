const app = angular.module('app', []);

app.controller('ctrl', function($scope, $http) {
    var $cart = $scope.cart = {
        items: [],
        add(id) { // thêm sản phẩm vào giỏ hàng
            var item = this.items.find(item => item.id === id); // tìm sản phẩm trong giỏ hàng
            if(item) { // nếu sản phẩm đã có trong giỏ hàng
                item.quantity++; // tăng số lượng + lưu vào giỏ hàng
                this.saveToLocalStorage();
            }
            else {
                $http.get(`/rest/product/${id}`).then(resp => { // lấy thông tin sản phẩm từ server
                    resp.data.quantity = 1;
                    this.items.push(resp.data);
                    console.log(resp.data)
                    this.saveToLocalStorage();
                })
            }
        },
        remove(id) { // xóa sản phẩm khỏi giỏ hàng
            var index = this.items.findIndex(item => item.id === id);
            this.items.splice(index, 1);
            this.saveToLocalStorage();
        },
        clear() { // Xóa sạch các mặt hàng trong giỏ
            this.items = [];
            this.saveToLocalStorage();
        },
        amountItem(item) { // tính thành tiền của 1 sản phẩm
            return item.price * item.quantity;
        },
        get count() {
            return this.items.map(item => item.quantity).reduce((total, quantity) => total += quantity, 0);
        },
        get amount() { // tổng thành tiền các mặt hàng trong giỏ
            return this.items.map(item => this.amountItem(item)).reduce((total, amount) => total += amount, 0);
        },
        loadImage(id) {
            $http.get(`/rest/product/${id}/image`).then(resp => {
                var item = this.items.find(item => item.id === id);
                if(item) {
                    item.image = resp.data.image;
                    this.saveToLocalStorage();
                    console.log(item.image)
                }
            }).catch(error => {
                console.log("Error", error)
            })
        },
        loadColor(id) {
            $http.get(`/rest/product/${id}/color`).then(resp => {
                var item = this.items.find(item => item.id === id);
                if(item) {
                    item.color = resp.data.color;
                    this.saveToLocalStorage();
                    console.log(item.color)
                }
            }).catch(error => {
                console.log("Error", error)
            })
        },
        loadSize(id) {
            $http.get(`/rest/product/${id}/size`).then(resp => {
                var item = this.items.find(item => item.id === id);
                if(item) {
                    item.size = resp.data.size;
                    this.saveToLocalStorage();
                    console.log(item.size)
                }
            }).catch(error => {
                console.log("Error", error)
            })
        },
        saveToLocalStorage() {// lưu giỏ hàng vào local storage
            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart", json)
        },
        loadFromLocalStorage() { // đọc giỏ hàng từ local storage
            var json = localStorage.getItem("cart");
            this.items = json ? JSON.parse(json) : [];
            this.items.forEach(item => {
                this.loadImage(item.id); // Call the loadColor function for each item's ID
            });
            this.items.forEach(item => {
                this.loadColor(item.id); // Call the loadColor function for each item's ID
            });
            this.items.forEach(item => {
                this.loadSize(item.id); // Call the loadColor function for each item's ID
            });
        },
    }

    $cart.loadFromLocalStorage();


    // Đặt hàng
    $scope.order = {
        get account() {
            return { userName: $auth.user.userName }
        },
        createdDate: new Date(),
        address: "",
        get orderDetailList() {
            return $cart.items.map(item => {
                return {
                    product: { id: item.id },
                    price: item.price,
                    quantity: item.quantity
                }
            });
        },
        purchase() {
            console.log("Purchase đã được gọi");
            var order = angular.copy(this);
            // Thực hiện đặt hàng
            $http.post("/rest/order/create", order).then(resp => {
                alert("Đặt hàng thành công!");
                $cart.clear();
                location.href = "/order/detail/" + resp.data.id;
            }).catch(error => {
                alert("Đặt hàng lỗi!")
                console.log(error)
            })
        }
    }
});
