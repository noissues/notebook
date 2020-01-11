
// 要给元素是对象的数组排序，需要指定按照对象的哪个属性进行排序
// 因此比较函数的值，需要指定一个属性作为比较值
function createComparisonFunction(propertyName) {
    return function(object1, object2) {
        var value1 = object1[propertyName];
        var value2 = object2[propertyName];
        if (value1 < value2) {
            return -1;
        } else if (value1 > value2) {
            return 1;
        } else {
            return 0;
        }
    }
}

var people = [{name: "小米", age: 29}, {name: "苹果", age: 28}];
people.sort(createComparisonFunction("age")); // 这里注意要传 string
console.log(people[0].name);