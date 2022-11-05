package Funtions

fun FunctionBasedSpec.compose(f: (Int) -> Int, g: (Int) -> Int): (Int) -> Int = { f(g(it)) }

fun <T, U, V> FunctionBasedSpec.polyCompose(f: (U) -> V, g: (T) -> U): (T) -> V = { f(g(it)) }