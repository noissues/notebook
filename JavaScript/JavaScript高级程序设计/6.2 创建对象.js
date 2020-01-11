// 3 原型模式
function Person() {}
Person.prototype.name = "佚名";
Person.prototype.sayName = function() {
    console.log(this.name);
};
var p3_1 = new Person();
var p3_2 = new Person();
console.log(p3_1.sayName == p3_2.sayName);


// 6 寄生构造函数模式
// function Person(name) {
//     var o = new Object();
//     o.name = name;
//     o.sayName = function() {
//         console.log(this.name);
//     }
//     return o;
// }
// var p6 = new Person("小白");
// p6.sayName();

// function SpecialArray() {
//     var array = new Array();
//     array.push.apply(array, arguments);
//     // 添加新方法
//     array.toPipedString = function() {
//         return this.join("/");
//     }
//     return array;
// }
// var jobs = new SpecialArray("插画家", "程序员", "声优");
// console.log(jobs.toPipedString());



// 7 稳妥构造函数模式
// function Person(name, age, job) {
//     // 创建要返回的对象
//     var o = new Object();

//     // 可以在这里定义私有变量和函数

//     // 添加方法
//     o.sayName = function() {
//         console.log(name);
//     }
//     return o;
// }
// var p7 = Person("小白", 29, "编辑");
// p7.sayName();