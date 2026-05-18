const readline = require("readline");
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question("Enter First Number: ", (num1) => {
    rl.question("Enter Second Number: ", (num2) => {
        rl.question(
            "Choose Operation (+, -, *, /): ",
            (operator) => {

                num1 = Number(num1);
                num2 = Number(num2);

                let result;

                if (operator === "+") {

                    result = num1 + num2;

                } else if (operator === "-") {

                    result = num1 - num2;

                } else if (operator === "*") {

                    result = num1 * num2;

                } else if (operator === "/") {

                    result = num1 / num2;

                } else {

                    console.log("Invalid Operator");

                    rl.close();

                    return;
                }
                console.log("Result = " + result);

                rl.close();
            }
        );
    });
});