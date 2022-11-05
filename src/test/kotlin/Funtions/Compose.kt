package Funtions

fun FunctionBasedSpec.compose(f: IntUnOp, g: IntUnOp): IntUnOp = { f(g(it)) }

fun <T, U, V> FunctionBasedSpec.polyCompose(f: (U) -> V, g: (T) -> U): (T) -> V = { f(g(it)) }

fun <T, U, V> FunctionBasedSpec.higherCompose() = { f: (U) -> V -> { g: (T) -> U -> { x: T -> f(g(x)) } } }