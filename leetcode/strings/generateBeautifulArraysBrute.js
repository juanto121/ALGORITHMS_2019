function checkBeautiful(arr){
	let allGood = true;
	outer:
	for(let i = 0; i < arr.length; i++) {
		for(let j = i + 1; j < arr.length; j++){
			for(let k = i; k < j; k++) {
				if(2*arr[k] === arr[i] + arr[j]){
					allGood = false;
					break outer;
				}
			}
		}
	}

	return allGood
}

function generate(arr, pos, used, N) {
	if(arr.length == N && checkBeautiful(arr)) {
		console.log(arr)
		return
	}
	for(let i = 1; i <= N; i++) {
		if(used[i] !== true){
			arr.push(i)
			used[i] = true
			generate(arr, pos+1, used, N)
			used[i] = false
			arr.pop()
		}
	}
}

function beautifulArrayBruteForce(N) {
	generate([], 0, {}, N)
}


beautifulArrayBruteForce(10)
