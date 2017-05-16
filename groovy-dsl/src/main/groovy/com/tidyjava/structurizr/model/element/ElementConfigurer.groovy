package com.tidyjava.structurizr.model.element

import com.structurizr.Workspace
import com.structurizr.model.Element
import com.tidyjava.structurizr.model.element.relationship.UsageConfigurer

import static groovy.lang.Closure.DELEGATE_FIRST

class ElementConfigurer {
    String name
    String description
    UsageConfigurer usages = new UsageConfigurer()

    void apply(Element element, Workspace workspace) {
        usages.apply(element, workspace)
    }

    void name(String name) {
        this.name = name
    }

    void description(String description) {
        this.description = description
    }

    void uses(@DelegatesTo(value = UsageConfigurer, strategy = DELEGATE_FIRST) Closure configurer) {
        configurer.delegate = usages
        configurer.resolveStrategy = DELEGATE_FIRST
        configurer()
    }
}
