
// 返回一个继承 p 的新对象
function inherit(p) {
    if (p == null) throw TypeError();

    // 能用 Object.create 直接用
    if (Object.create) {
        return Object.create(p);
    }

    // 不能用，先检查类型
    var t = typeof p;
    if (t != "object" && t != "function")
       throw TypeError();
    
    // 定义一个空构造函数，将其原型设为 p
    function f() {};
    f.prototype = p;
    return new f();
}

var array = inherit(Array.prototype);
console.log(typeof array);
console.log(array instanceof Array);
var object = inherit(Object.prototype);