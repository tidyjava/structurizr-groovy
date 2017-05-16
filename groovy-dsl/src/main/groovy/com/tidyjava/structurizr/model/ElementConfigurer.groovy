package com.tidyjava.structurizr.model

import com.structurizr.Workspace
import com.structurizr.model.Element

import static groovy.lang.Closure.DELEGATE_FIRST

class ElementConfigurer {
    String name
    String description
    List<UsageConfigurer> usages = []

    void apply(Element element, Workspace workspace) {
        usages.forEach { it.apply(element, workspace) }
    }

    void name(String name) {
        this.name = name
    }

    void description(String description) {
        this.description = description
    }

    void uses(@DelegatesTo(value = UsageConfigurer, strategy = DELEGATE_FIRST) Closure configurer) {
        def uc = new UsageConfigurer()
        configurer.delegate = uc
        configurer.resolveStrategy = DELEGATE_FIRST
        configurer()
        usages.add(uc)
    }
}
