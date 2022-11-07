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

fun <A, B, C> FunctionBasedSpec.curry(f: (A, B) -> C): (A) -> (B) -> C = { a -> { b -> f(a, b) } }

fun <T, U, V> FunctionBasedSpec.swapArg(f: (T) -> (U) -> (V)): (U) -> (T) -> (V) = { u -> { t -> f(t)(u) } }