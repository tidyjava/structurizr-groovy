package com.tidyjava.structurizr

import com.structurizr.Workspace
import com.tidyjava.structurizr.model.PersonConfigurer
import com.tidyjava.structurizr.model.SoftwareSystemConfigurer
import com.tidyjava.structurizr.view.ComponentViewConfigurer
import com.tidyjava.structurizr.view.StylesConfigurer
import com.tidyjava.structurizr.view.SystemContextViewConfigurer

import static groovy.lang.Closure.DELEGATE_FIRST

class WorkspaceConfigurer {
    String name
    String description
    List<SoftwareSystemConfigurer> softwareSystems = []
    List<PersonConfigurer> people = []
    List<SystemContextViewConfigurer> systemContextViews = []
    List<ComponentViewConfigurer> componentViews = []
    StylesConfigurer styles = new StylesConfigurer()

    Workspace apply() {
        def workspace = new Workspace(name, description)
        applyConfigurers(workspace)
        return workspace
    }

    void apply(Workspace workspace) {
        if (name) workspace.name = name
        if (description) workspace.description = description
        applyConfigurers(workspace)
    }

    void applyConfigurers(Workspace workspace) {
        softwareSystems.forEach { it.apply(workspace) }
        people.forEach { it.apply(workspace) }
        systemContextViews.each { it.apply(workspace) }
        componentViews.each { it.apply(workspace) }
        styles.apply(workspace)
    }

    void name(String name) {
        this.name = name
    }

    void description(String description) {
        this.description = description
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

    void systemContextView(
            @DelegatesTo(value = SystemContextViewConfigurer, strategy = DELEGATE_FIRST) Closure configurer) {
        def scvc = new SystemContextViewConfigurer()
        configurer.delegate = scvc
        configurer.resolveStrategy = DELEGATE_FIRST
        configurer()
        systemContextViews.add(scvc)
    }

    void componentView(@DelegatesTo(value = ComponentViewConfigurer, strategy = DELEGATE_FIRST) Closure configurer) {
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
