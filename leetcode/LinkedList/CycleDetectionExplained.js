
// BEST EXPLANATION : https://www.youtube.com/watch?v=LUm2ABqAs1w

var findDuplicate = function(nums) {
    /*
     If all values of array nums had a different number, then we would traverse the array
     without repeating any index.
     When there is a repeated value, then some index will be referenced multiple times.
     Think of if as if you could check referenced indexes.

     Since an index will be referenced multiple times, then a cycle forms.

     The following is the Floyd algorithm to detect cycles in a linked list.
    */

    let slow = 0
    let fast = 0
    slow = nums[slow]
    fast = nums[nums[fast]]

    while(slow != fast) {
        slow = nums[slow]
        fast = nums[nums[fast]]
    }

    /*
     fast pointer has covered double the distance of the slow pointer.
     coveredByP = before_loop_start + length_of_loop * num_fast_revolutions + remainder_when_meeting_q(aka. k)
     coveredByQ = before_loop_start + length_of_loop * num_slow_revolutions + remainder_when_meeting_p(aka. k)
     replacing coveredByP for 2*coveredByQ:
     before_loop_start + length_of_loop * num_fast_revolutions + k =
     2*before_loop_start + 2*length_of_loop * num_slow_revolutions + 2*k

     solving for before_loop_start and k:

     before_loop_start + k = length_of_loop * SOME_INTEGER

     Then we know that when having a pointer at K steps into the start of the loop
     if we then do before_loop_start steps, the pointer will stop at the start of the loop.

    */
    let p1 = 0
    let p2 = fast

    while(nums[p1] !== nums[p2]) {
        p1 = nums[p1]
        p2 = nums[p2]
    }

    return nums[p1]
};

findDuplicate([1,2,4,5,4,4])
