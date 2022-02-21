let f1: number = 1;
let f2: number = 1;
let sum: number = 0;
console.log(f1)
for (let i = 2; i <= 10; i ++) {
    console.log(f2)
    let temp: number = f1 + f2;
    sum += temp;
    f1 = f2;
    f2 = temp;


}
console.log('Tổng các sô trong dãy Fibonacci trên là: '+sum)