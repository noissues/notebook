// 对象直接量每次都会创建一个新对象
var o1 = {x:0, y:0};
var o2 = {x:0, y:0};
console.log(o1 == o2);

var o3 = Object.create({x:0,y:0});
var o4 = Object.create(null);

var o5 = Object.create(Object.prototype);
var o6 = Object.create(Array.prototype);
var o7 = Object.create(Date.prototype);


var book = {};
book.author = "吴承恩";
book["main title"] = "西游记";

console.log(book.author);
console.log(book["main title"]);

