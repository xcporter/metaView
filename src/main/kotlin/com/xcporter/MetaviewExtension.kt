package com.xcporter

import groovy.lang.Closure
import groovy.lang.Closure.DELEGATE_FIRST
import org.gradle.api.Project
import java.io.File

open class MetaviewExtension(val proj: Project) {
    var analysisSequence = mutableListOf<AnalysisType>()

    var target: File = proj.projectDir

    var verbose : Boolean = false
    var deeplyVerbose: Boolean = false
    fun classTree(op: Closure<Unit>) {
        val obj = AnalysisType.ClassTree(proj)
        op.apply {
            resolveStrategy = DELEGATE_FIRST
            delegate = obj
            call()
        }
        analysisSequence.add (obj)
    }

    fun functionReceiverTree(op: AnalysisType.FunctionReceiverTree.()-> AnalysisType) {
        TODO()
    }
}
