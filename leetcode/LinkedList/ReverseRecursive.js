function ListNode (val) {
    this.val = val
    this.next = null
}

function printl(node) {
    const list = []
    while(node !== null) {
        list.push(node.val)
        node = node.next
    }
    console.log(list)
}

function reverse(current, prev = null) {
    let last = null
    if(current !== null) {
        last = reverse(current.next, current)
        current.next = prev
    } else {
        return prev
    }
    return last
}


const a = new ListNode(1)
const b = new ListNode(2)
const c = new ListNode(3)

a.next = b
b.next = c

const first = reverse(a)
printl(first)
