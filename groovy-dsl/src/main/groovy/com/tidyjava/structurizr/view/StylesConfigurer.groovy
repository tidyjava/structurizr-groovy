package com.tidyjava.structurizr.view

import com.structurizr.Workspace
import com.structurizr.model.Tags

import static groovy.lang.Closure.DELEGATE_FIRST

class StylesConfigurer {
    List<ElementStyleConfigurer> elementStyles = []

    void apply(Workspace workspace) {
        elementStyles.each { it.apply(workspace) }
    }

    void component(@DelegatesTo(value = ElementStyleConfigurer, strategy = DELEGATE_FIRST) Closure configurer) {
        def esc = new ElementStyleConfigurer(Tags.COMPONENT)
        configurer.delegate = esc
        configurer.resolveStrategy = DELEGATE_FIRST
        configurer()
        elementStyles.add(esc)
    }
}
