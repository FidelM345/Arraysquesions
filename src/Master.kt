fun main(){
    val target = 11
    val num3: Array<Int> = arrayOf(7, 1, 2, 3, 4) // 0, 4
    val num1: Array<Int> = arrayOf(1, 3, 7, 9, 2) // 3, 4
    val num2: Array<Int> = arrayOf(0, 1, 2, 3, 4)// null, null
    val empty = arrayOf<Int>()  // null, null
    val one = arrayOf(2) // null, null

    println(findPairIndiciesWithTargetValue(num3, 11))
    println(findPairIndiciesWithTargetValue(num1, 11))
    println(findPairIndiciesWithTargetValue(num2, 11))
    println(findPairIndiciesWithTargetValue(empty, 11))
    println(findPairIndiciesWithTargetValue(one, 11))
    println(findPairIndiciesWithTargetValue(arrayOf(9, 1, 2, 7, 4), 11))

    // num1 + num2 = target  ----> return indexOf(num1, num2)

    /*
    *  index = 0
    *  lastIndex = size(numbers) - 1  // 4
    *   While (index < lastIndex) // 0< 4    O(n) + 0(n-1)  ----> O(n2)
    *        value = numbers[index] // 0
    *
    *        nextIndex = index+1 // 1

    *        while(nextIndex <= lastIndex) 4<=4
    *            sum = value + numbers[nextIndex] // 0 + 4 -> 4
    *
                if(sum == target) // 4==4
                    return (index, nextIndex) ----> (0, 4)

                nextIndex++ //4
    *
    *        index++
    *
    * */

    /*

       index = 0

       While (index <= lastIndex) // 1 < 4
           value = numbers[index]          space = 0(n), time = O(n)
           map[value] = index
           index++


        {
        0 -> 0,
        1 -> 1,
        2 -> 2,
        3 -> 3,
        4 -> 4
        }



    *  index = 0
    *  lastIndex = size(numbers) - 1  // 4
    *   While (index < lastIndex) // 0< 4     0(n)
    *        value = numbers[index] // 0

             searchTarget = target - value // 4-0 ---> 4

             if(map[searchTarget] != -1)
                return (index, map[searchTarget])  0(1)

    *        index++
    *
    * */
}

fun findPairIndiciesWithTargetValue(numbers: Array<Int>, targetValue: Int): Pair<Any?, Any?> {
    val pairIndicies = Pair<Any?, Any?>(null, null)
    pairIndicies.copy(first = 1, second = 1)

    if (numbers.isEmpty() || numbers.size ==1) return pairIndicies

    var pointer1 = 0
    val lastIndex = numbers.size -1
    val valueIndexMap = mutableMapOf<Int, Int>()

    while (pointer1 <= lastIndex) {
        val currentVal = numbers[pointer1]
        valueIndexMap[currentVal]=pointer1
        pointer1++
    }

    pointer1 = 0
    while (pointer1 < lastIndex) {
        val currentVal = numbers[pointer1]
        val numberToFind = targetValue - currentVal

        if (valueIndexMap.containsKey(numberToFind)){
            return pairIndicies.copy(first = pointer1 , second = valueIndexMap[numberToFind] )
        }
        pointer1++
    }

    return pairIndicies
}

/*un findPairIndiciesWithTargetValue(numbers: Array<Int>, targetValue: Int): Pair<Any?, Any?> {
    val pairIndicies = Pair<Any?, Any?>(null, null)
    pairIndicies.copy(first = 1, second = 1)

    if (numbers.isEmpty() || numbers.size ==1) return pairIndicies

    var pointer1 = 0
    val lastIndex = numbers.size -1

    while (pointer1 < lastIndex) {
        val currentVal = numbers[pointer1]
        var pointer2 = pointer1 + 1
        val numberToFind = targetValue - currentVal

        while (pointer2 <= lastIndex) {
            val currentNextValue = numbers[pointer2]

            if (numberToFind == currentNextValue)
                return pairIndicies.copy(first = pointer1, second = pointer2)
            pointer2++
        }

        pointer1++
    }

    return pairIndicies
}*/