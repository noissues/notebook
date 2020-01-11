function Person() {
    var age = 0;
    this.getAge = function() { return age; }
    this.growUp = function() { age++; }
}

var jack = new Person();
jack.growUp();
console.log(jack.age); // undefined 无法访问到函数内部定义的变量
console.log(jack.getAge()); // 1 可以访问
