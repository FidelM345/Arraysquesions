fun main(){

    //
}


fun maxAreaTwo(height: IntArray): Int {
    var area = 0

    var p1 = 0
    var p2 = height.size - 1

    while (p1 < p2) {
        val firstHeight = height[p1]
        val secondHeight = height[p2]

        val width = if (firstHeight > secondHeight) {
            p2--
            secondHeight
        } else {
            p1++
            firstHeight
        }

        val length = p2 - p1

        val tempArea = length * width

        area = if (tempArea > area) {
            tempArea
        } else {
            area
        }
    }

    return area
}

fun maxArea(height: IntArray): Int {
   var area = 0

    var p1 = 0
    val lastIndex = height.size -1

    while (p1 < lastIndex){
        val firstHeight = height[p1]
        var p2 = p1 + 1

        while (p2 <= lastIndex){
            val secondHeight = height[p2]

            val width = if (firstHeight > secondHeight) {
                secondHeight
            } else {
                firstHeight
            }

            val length = p2 - p1
            val tempArea = length * width

            area = if (tempArea > area) {
                tempArea
            } else {
                area
            }
            p2++
        }

        p1++
    }

    return area
}