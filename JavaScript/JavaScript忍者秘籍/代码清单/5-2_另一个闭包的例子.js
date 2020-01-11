var later;

function outerFunction() {
    var innerValue = "inner";
    function innerFunction() {
        console.log(innerValue);
    }
    later = innerFunction;
}
// 保存 innerFunction 用于外部调用
outerFunction();
// 调用 innerFunction
later();