const assert = require('assert')
const ops = ['+', '-', '*', '/']
const _ops = [...ops, '(', ')']

function precedence(c) {
    return parseInt(ops.indexOf(c)/2)
}

function isOperator(c) {
    return _ops.indexOf(c) !== -1
}

function isDigit(c) {
    return c!== undefined && !isOperator(c)
}

function clean(s) {
    let len = s.length;
    let tokens = []
    for(let i = 0; i < len; i++) {
        let current = s[i]
        let currentToken =  []
        if (isDigit(current)) {
            while(isDigit(current) && i < len) {
                currentToken.push(current)
                i++
                current=s[i]
            }
            i--
        } else {
            currentToken.push(current)
        }

        tokens.push(currentToken.join(""))
    }
    return tokens
}

function operate(operation, a, b) {
    switch(operation) {
        case '+': return a + b;
        case '-': return a - b;
        case '*': return a * b;
        case '/': return b !== 0 ? parseInt(a / b) : 0;
    }
}

function evaluate(operators, values, currentOperator = null) {
    // Only evaluate when current operator has less precedence to what is already in the queue.
    // eg. if queue has [a+b*c] and current is -, evaluate the queue first until reaching the sum. (b*c)
    const precedenceCondition = () => {
        const opPeek = operators[operators.length-1]
        return currentOperator ? precedence(currentOperator) <= precedence(opPeek) : true
    }

    while(values.length > 1 && operators.length > 0 && precedenceCondition() && peek(operators) !== '(') {
        let second = values.pop()
        let first = values.pop()
        const operator = operators.pop()
        const res = operate(operator, first, second)
        values.push(res)
    }
}

function peek(arr) {
    return arr[arr.length-1]
}

var calculate = function(s) {
    const operators = []
    const values = []
    const tokens = clean(s)

    for(let t of tokens) {
        if(isDigit(t)) {
            values.push(Number(t))
        } else {
            if(t === ')') {
                evaluate(operators, values, '+')
                assert.strictEqual(peek(operators), '(')
                operators.pop()
            } else {
                //evaluate precedence greater than CURRENT_OP before adding CURRENT_OP
                if(t !== '(') evaluate(operators, values, t)
                operators.push(t)
            }
        }
    }

    // remaining
    evaluate(operators,values)

    return values[0]
};

console.log(calculate("(3+2)*(2-((2*5-2/3)+1))"))
