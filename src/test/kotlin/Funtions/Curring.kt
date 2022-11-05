package Funtions

fun <A, B, C, D> FunctionBasedSpec.fourArgumentsCurring()= { a: A ->
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