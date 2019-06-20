/*
Q3: Given two Strings, pattern and str, find if str follows the pattern. This implies a full match, so there is a bijection between them both. Write such a function

Pattern: "abba", str: "dog cat cat dog" → true

Pattern: "abba", str: "dog cat cat fish" → false
*/

function checkPattern(pattern, string) {
	const matchingMap = {}
	for(s in pattern) {
		if(!matchingMap[pattern[s]]) {
			matchingMap[pattern[s]] = []
		}
		matchingMap[pattern[s]].push(s)
	}

	const tokens = string.split(" ")
	if(tokens.length !== pattern.length) return false;
	const seenKeys = {}

	for(key in matchingMap) {
		let sample = tokens[matchingMap[key][0]]

		if(seenKeys[sample]) return false
		else seenKeys[sample] = true
			
		for(position of matchingMap[key]) {
			if(tokens[position] !== sample){
				return false
			}
		}
	}

	return true
}


console.log(checkPattern("aabaa", "a a b a a"))
console.log(checkPattern("abba", "dog cat cat dog"))
console.log(checkPattern("cabbac", "pie dog cat cat dog pie"))
console.log(checkPattern("abbac", "dog cat cat dog dog"))
console.log(checkPattern("abbac", "dog cat cat dog coffe"))
console.log(checkPattern("abbac", "dog cat cat dog coffe somethingelse"))