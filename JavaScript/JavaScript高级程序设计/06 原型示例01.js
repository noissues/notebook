
// 构造函数首先是个函数
// 其实任何一个函数，只要通过 new 操作，就表明构造函数
// 按照面向对象编程语言的传统，构造函数首字母大写
function Person() {}
Person.prototype.name = "小明";
Person.prototype.age = 10;
Person.prototype.job = "程序员";
Person.prototype.sayName = function() {
    
}



var person1 = new Person();