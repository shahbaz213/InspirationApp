package com.app.inspirationlibrary.plugin

import com.app.inspirationlibrary.utils.LDocument
import com.app.inspirationlibrary.utils.Translator
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import java.io.File


abstract class LokaleNowTask: DefaultTask() {
    @get:Input
    var listLang = listOf<String>()

    @TaskAction
    fun doTranslate(){
        val path = project.layout.projectDirectory.toString()
        val file_original = File(path)
        val ldoc = LDocument
            .Builder(file_original)
            .build()
        if(ldoc.isModified()){
            ldoc.saveCurrentHash()
            val list_string = ldoc.listElements()
            val translator = Translator.Builder()
                .addNodes(list_string)
                .build()
           listLang.forEach{lang->
               println("Translating for: ${lang.uppercase()}")
               val translated = translator.translate(lang)
               ldoc.saveLocalized(lang,translated)
           }
        }
    }
}