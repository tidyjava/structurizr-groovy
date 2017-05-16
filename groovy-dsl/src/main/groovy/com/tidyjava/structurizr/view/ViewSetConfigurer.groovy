package com.tidyjava.structurizr.view

import com.structurizr.Workspace

import static groovy.lang.Closure.DELEGATE_FIRST

class ViewSetConfigurer {
    List<SystemContextViewConfigurer> systemContextViews = []
    List<ComponentViewConfigurer> componentViews = []

    void apply(Workspace workspace) {
        systemContextViews.each { it.apply(workspace) }
        componentViews.each { it.apply(workspace) }
    }

    void systemContext(@DelegatesTo(value = SystemContextViewConfigurer, strategy = DELEGATE_FIRST) Closure configurer) {
        def scvc = new SystemContextViewConfigurer()
        configurer.delegate = scvc
        configurer.resolveStrategy = DELEGATE_FIRST
        configurer()
        systemContextViews.add(scvc)
    }

    void component(@DelegatesTo(value = ComponentViewConfigurer, strategy = DELEGATE_FIRST) Closure configurer) {
        def cvc = new ComponentViewConfigurer()
        configurer.delegate = cvc
        configurer.resolveStrategy = DELEGATE_FIRST
        configurer()
        componentViews.add(cvc)
    }
}
