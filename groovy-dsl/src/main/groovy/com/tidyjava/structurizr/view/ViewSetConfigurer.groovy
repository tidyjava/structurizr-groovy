package com.tidyjava.structurizr.view

import com.structurizr.Workspace

import static groovy.lang.Closure.DELEGATE_FIRST

class ViewSetConfigurer {
    List<SystemContextViewConfigurer> views = []

    void apply(Workspace workspace) {
        views.each { it.apply(workspace) }
    }

    void systemContext(@DelegatesTo(value = SystemContextViewConfigurer, strategy = DELEGATE_FIRST) Closure configurer) {
        def scvc = new SystemContextViewConfigurer()
        configurer.delegate = scvc
        configurer.resolveStrategy = DELEGATE_FIRST
        configurer()
        views.add(scvc)
    }
}
