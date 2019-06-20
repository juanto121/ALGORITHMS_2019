
class TreeNode {
    constructor(val) {
        this.val = val
        this.left = this.right = null
    }
}

function isLeave(root) {
    if(root.left === null && root.right === null) return true
    else return false
}

// returns min number of cameras used in the subtree
var minCameraCover = function(root, currentCovered) {
    if(root == null) return 0
    if(isLeave(root)) {
        if(currentCovered)
            return 0
        else
            return 1
    } else {

        const leftCamerasUncover = minCameraCover(root.left, false)
        const rightCamerasUncover = minCameraCover(root.right, false)

        if(currentCovered) {
            return leftCamerasUncover + rightCamerasUncover
        } else {
            const leftCamerasCovered = minCameraCover(root.left, true)
            const rightCamerasCovered = minCameraCover(root.right, true)
            return Math.min(leftCamerasCovered+rightCamerasCovered+1,
                leftCamerasUncover+rightCamerasUncover)
        }
    }
};

A = new TreeNode(0)
B = new TreeNode(0)
C = new TreeNode(0)
D = new TreeNode(0)
E = new TreeNode(0)

A.left = B
B.left = C
C.left = D
D.right = E

minCameraCover(A)
