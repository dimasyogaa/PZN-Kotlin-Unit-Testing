package com.yogadimas._3_mengubah_nama_test.generator

import org.junit.jupiter.api.DisplayNameGenerator
import java.lang.reflect.Method

class SimpleDisplayNameGenerator : DisplayNameGenerator {
    override fun generateDisplayNameForClass(testClass: Class<*>): String {
        return testClass.packName()

    }

    override fun generateDisplayNameForNestedClass(nestedClass: Class<*>): String {
        return nestedClass.packName()
    }

    override fun generateDisplayNameForMethod(testClass: Class<*>, testMethod: Method): String {
        // return "${testClass.packName()} : ${testMethod.name}"
        var i = 0
        return "-> ${testMethod.name}"
    }


    private fun Class<*>.packName (): String {
        val packageName = this.name.split(".").toMutableList()
        packageName.removeAll(listOf("com","yogadimas"))
        return packageName.joinToString(" - ")
    }
}