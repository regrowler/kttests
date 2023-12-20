interface TypeA

interface TypeB

interface ParentBuilder {
    fun build(block: TypeA.() -> Unit)
}

interface ChildBuilder : ParentBuilder {
    fun build(block: TypeB.() -> Unit)
}

fun Main2() {
    var builder: ChildBuilder? = null
//    builder?.build(block = {} as (TypeA.() -> Unit))
}