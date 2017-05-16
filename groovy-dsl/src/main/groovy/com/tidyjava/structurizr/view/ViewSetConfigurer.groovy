package com.tidyjava.structurizr.view

import com.structurizr.Workspace

import static groovy.lang.Closure.DELEGATE_FIRST

class ViewSetConfigurer {
    List<SystemContextViewConfigurer> systemContextViews = []
    List<ComponentViewConfigurer> componentViews = []
    StylesConfigurer styles = new StylesConfigurer()

    void apply(Workspace workspace) {
        systemContextViews.each { it.apply(workspace) }
        componentViews.each { it.apply(workspace) }
        styles.apply(workspace)
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

    void styles(@DelegatesTo(value = StylesConfigurer, strategy = DELEGATE_FIRST) Closure configurer) {
        configurer.delegate = styles
        configurer.resolveStrategy = DELEGATE_FIRST
        configurer()
    }
}
