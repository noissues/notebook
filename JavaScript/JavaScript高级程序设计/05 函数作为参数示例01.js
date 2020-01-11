
// 用参数2作为参数1的参数，执行参数1
function callSomeFunction(someFunction, someArgument) {
    return someFunction(someArgument);
}

function add10(num) {
    return num + 10;
}
// 调用 add10 函数，参数传 100
var result = callSomeFunction(add10, 100);
console.log(result);

function getGreeting(name) {
    return "Hello, " + name;
}
result = callSomeFunction(getGreeting, "Apple");
console.log(result);
