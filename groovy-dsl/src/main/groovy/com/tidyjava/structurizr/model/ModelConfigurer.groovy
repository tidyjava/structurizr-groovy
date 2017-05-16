package com.tidyjava.structurizr.model

import com.structurizr.Workspace
import com.tidyjava.structurizr.model.element.PersonConfigurer
import com.tidyjava.structurizr.model.element.SoftwareSystemConfigurer

import static groovy.lang.Closure.DELEGATE_FIRST

class ModelConfigurer {
    List<SoftwareSystemConfigurer> softwareSystems = []
    List<PersonConfigurer> people = []

    void apply(Workspace workspace) {
        softwareSystems.forEach { it.apply(workspace) }
        people.forEach { it.apply(workspace) }
    }

    void softwareSystem(@DelegatesTo(value = SoftwareSystemConfigurer, strategy = DELEGATE_FIRST) Closure configurer) {
        def ssc = new SoftwareSystemConfigurer()
        configurer.delegate = ssc
        configurer.resolveStrategy = DELEGATE_FIRST
        configurer()
        softwareSystems.add(ssc)
    }

    void person(@DelegatesTo(value = PersonConfigurer, strategy = DELEGATE_FIRST) Closure configurer) {
        def pc = new PersonConfigurer()
        configurer.delegate = pc
        configurer.resolveStrategy = DELEGATE_FIRST
        configurer()
        people.add(pc)
    }
}
