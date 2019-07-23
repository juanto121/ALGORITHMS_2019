function units(x) {
    let names = ["", "one", "two", "three", "four"]
    return names[Number(x)]
}

function tens(x, result) {
    if(Number(x) === 0) return result
    x = Number(x)
    let names = ["", "teenth", "twenty", "thirty", "forthy", "fifthy", "sixty", "ninethy"]
    if(x == 1) {
        if(result == "1"){
            return "eleven"
        } else if(result == "two") {
            return "twelve"
        } else if(result == "9"){
            return units(9)+names[x]
        }
    } else {
        return names[x] + " " + result
    }
}

function hundreds(x, result) {
    if(Number(x) === 0) return result
    let name = units(x) + " hundred " + result
    return name
}

function thousands(x, result) {
    return units(x) + " thousand " + result
}

function numToWord(string) {
    let len = string.length
    
    let map = {
        1: units,
        2: tens,
        3: hundreds,
        4: thousands
    }
    
    let power = 1
    let result = ""
    
    for(let i = len-1; i>=0; i--) {
        result = map[power++](string[i], result)
    }
    
    return result
    
}

console.log(numToWord("12"))
