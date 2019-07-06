/**
 * @param {number[]} days
 * @param {number[]} costs
 * @return {number}
 */
let pass = [1,7, 30]
let day = []
let minCost = 0
let costos = null
let solutions = {}

function dfs(currentDay) {

    //console.log("cur " + currentDay)

    while(day[currentDay] == 0 && currentDay <= 365) {
        currentDay++
    }

    if(solutions[currentDay] !== undefined) return solutions[currentDay]

    if (currentDay <= 365) {
        let min = Number.MAX_VALUE
        for(let p = 2; p >= 0; p--) {
            const cur = dfs(currentDay + pass[p]) + costos[p]
            min = cur < min ? cur : min
        }
        solutions[currentDay] = min
    } else {
        return 0
    }

    return solutions[currentDay]
}

var mincostTickets = function(days, costs) {

    costos = costs
    day = []
    minCost = costs[2] * 12 + 2
    solutions = {}

    for(let i = 0; i <= 366; i++) {
        day[i] = 0
    }

    for(let d of days) day[d] = 1

    return dfs(1, 0)
};


const cost = mincostTickets(
    [2,7,8,10,12,13,14,17,25,28,29,34,35,37,43,44,45,53,54,58,60,61,62,63,64,65,66,71,74,82,86,88,95,97,98,102,105,106,115,117,119,120,125,129,135,136,142,143,152,153,155,158,165,166,168,181,187,189,191,192,193,194,196,197,198,201,208,209,211,212,215,224,226,236,242,243,244,245,248,252,260,261,263,266,269,272,273,274,280,284,286,287,292,297,300,303,304,312,317,323,326,328,329,332,333,337,341,348,349,351,352,355,361,364],
    [16,82,359])

console.log(cost)
