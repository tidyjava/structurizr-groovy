package com.tidyjava.structurizr.model

import com.structurizr.Workspace
import com.structurizr.model.SoftwareSystem

import static groovy.lang.Closure.DELEGATE_FIRST

class ContainerConfigurer extends ElementConfigurer {
    String technology
    ComponentFinderConfigurer componentFinder

    void apply(SoftwareSystem softwareSystem, Workspace workspace) {
        def container = softwareSystem.addContainer(name, description, technology)

        if (componentFinder != null) {
            componentFinder.apply(container)
        }

        apply(container, workspace)
    }

    void technology(String technology) {
        this.technology = technology
    }

    void componentFinder(
            @DelegatesTo(value = ComponentFinderConfigurer, strategy = DELEGATE_FIRST) Closure configurer) {
        componentFinder = new ComponentFinderConfigurer()
        configurer.delegate = componentFinder
        configurer.resolveStrategy = DELEGATE_FIRST
        configurer()
    }
}
