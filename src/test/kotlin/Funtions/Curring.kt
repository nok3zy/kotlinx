package Funtions

fun <A, B, C, D> FunctionBasedSpec.fourArgumentsCurring() = { a: A ->
    { b: B ->
        { c: C ->
            { d: D ->
                {
                    "$a $b $c $d"
                }
            }
        }
    }
}

fun <A, B, C> FunctionBasedSpec.partOne(a: A, f: (A) -> (B) -> C): (B) -> C = f(a)

fun <A, B, C> FunctionBasedSpec.partTwo(b: B, f: (A) -> (B) -> C): (A) -> C = { a: A -> f(a)(b) }