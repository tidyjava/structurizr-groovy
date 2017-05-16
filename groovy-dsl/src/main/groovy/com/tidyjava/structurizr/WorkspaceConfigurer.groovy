package com.tidyjava.structurizr

import com.structurizr.Workspace
import com.tidyjava.structurizr.model.ModelConfigurer
import com.tidyjava.structurizr.view.ViewSetConfigurer

import static groovy.lang.Closure.DELEGATE_FIRST

class WorkspaceConfigurer {
    String name
    String description
    ModelConfigurer modelConfigurer = new ModelConfigurer()
    ViewSetConfigurer viewSetConfigurer = new ViewSetConfigurer()

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
        modelConfigurer.apply(workspace)
        viewSetConfigurer.apply(workspace)
    }

    void name(String name) {
        this.name = name
    }

    void description(String description) {
        this.description = description
    }

    void model(@DelegatesTo(value = ModelConfigurer, strategy = DELEGATE_FIRST) Closure configurer) {
        configurer.delegate = modelConfigurer
        configurer.resolveStrategy = DELEGATE_FIRST
        configurer()
    }

    void views(@DelegatesTo(value = ViewSetConfigurer, strategy = DELEGATE_FIRST) Closure configurer) {
        configurer.delegate = viewSetConfigurer
        configurer.resolveStrategy = DELEGATE_FIRST
        configurer()
    }
}
