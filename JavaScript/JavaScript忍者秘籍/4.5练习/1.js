
function sum() {
    var sum = 0;
    for (var i = 0; i < arguments.length; i++) {
        sum += arguments[i];
    }
    return sum;
}
console.log(sum(1, 2, 3));

// 使用剩余参数改写
function sum(...args) {
    var sum = 0;
    
}