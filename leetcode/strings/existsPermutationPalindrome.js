function existsPermutationPalindrome(s) {
	const characterCount = {}
	const len = s.length
	for(let i = 0; i < len; i++) {
		let count = characterCount[s[i]]
		if(!count) characterCount[s[i]] = 0
		characterCount[s[i]]++;
	}
	
	let odds = 0
	let evens = 0

	for(character in characterCount) {
		if(characterCount[character] % 2 == 0){
			evens++;
		} else {
			odds++;
		}
	}

	if(len % 2 == 0) {
		return odds == 0 && evens > 0
	} else {
		return odds == 1 && evens >= 0
	}
}


console.log(existsPermutationPalindrome("a"))
console.log(existsPermutationPalindrome("aa"))
console.log(existsPermutationPalindrome("aab"))
console.log(existsPermutationPalindrome("baa"))
console.log(existsPermutationPalindrome("abc"))
console.log(existsPermutationPalindrome("abcabc"))