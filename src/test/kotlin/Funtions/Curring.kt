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
