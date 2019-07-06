/**
 * @param {string[]} words
 * @return {string}
 */

class TrieNode {
    constructor() {
        this.end = false
        this.children = {}
    }
}

class Trie {
    constructor() {
        this.root = new TrieNode()
        this.root.end = true
    }

    insertWord(word) {
        let currentNode = this.root
        for(let c of word) {
            if(currentNode.children[c] === undefined)
                currentNode.children[c] = new TrieNode()
            currentNode = currentNode.children[c]
        }
        currentNode.end = true
    }

    searchWordOfWords(word) {
        let currentNode = this.root
        let allOk = true
        for(let c of word) {
            if(currentNode.children[c] !== undefined && currentNode.end)
                currentNode = currentNode.children[c]
            else{
                allOk = false
                break
            }
        }
        return allOk
    }
}

var longestWord = function(words) {
    const trie = new Trie()

    words.sort()

    for(let w of words) {
        trie.insertWord(w)
    }

    let maxLen = 0
    let maxWord = words[0]

    for(let w of words) {
        if(trie.searchWordOfWords(w)){
            if(maxLen < w.length){
                maxLen = w.length
                maxWord = w
            }
        }
    }

    return maxWord
};


console.log(longestWord(["a", "banana", "app", "appl", "ap", "apply", "apple"]))
