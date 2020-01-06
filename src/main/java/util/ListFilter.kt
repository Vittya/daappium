package util



fun getClasses(list:Array<Any>): ArrayList<Class<*>> {
   val className = ArrayList<Class<*>>()
    list.forEach {
                className.add(it.javaClass)
    }

    return className
}