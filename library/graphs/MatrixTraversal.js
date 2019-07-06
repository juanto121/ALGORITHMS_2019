function dfs(matrix, i, j, path) {
    if(!checkBounds(matrix,i,j)) return true
    if(matrix[i][j] === 0) {
        matrix[i][j] = 1
        path.push(i+" "+j)
        dfs(matrix, i+1, j, path)
        dfs(matrix, i, j+1, path)
        dfs(matrix, i-1, j, path)
        dfs(matrix, i, j-1, path)
    }
}

function checkBounds(matrix, i, j) {
    const rows = matrix.length
    const cols = matrix.length
    if(i >= rows || i < 0 || j >= cols || j < 0) return false
    return true
}

function traverse(matrix) {
    let path = []
    const rows = matrix.length
    const cols = matrix[0].length
    for(let r = 0; r < rows; r++) {
        for(let c = 0; c < cols; c++) {
            if(matrix[r][c] === 0) {
                dfs(matrix, r, c, path)
                break;
            }
        }
    }
    console.log(path)
}

function read(matrix, n, m) {
    const graph = []
    const items = matrix.split(" ")
    for(let i = 0; i < n; i++) {
        const row = []
        for(let j = 0; j < m; j++) {
            const it = Number(items[i*n+j])
            row.push(it)
        }
        graph.push(row)
    }
    return graph
}

const lab = "1 1 1 1 1 0 0 0 1 1 1 0 0 0 0 0"

traverse(read(lab, 4, 4))
