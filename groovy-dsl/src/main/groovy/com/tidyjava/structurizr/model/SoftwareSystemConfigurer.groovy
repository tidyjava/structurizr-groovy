package com.tidyjava.structurizr.model

import com.structurizr.Workspace

import static groovy.lang.Closure.DELEGATE_FIRST

class SoftwareSystemConfigurer extends ElementConfigurer {
    List<ContainerConfigurer> containers = []

    void apply(Workspace workspace) {
        def model = workspace.getModel()
        def softwareSystem = model.addSoftwareSystem(name, description)
        containers.forEach { it.apply(softwareSystem, workspace) }
        apply(softwareSystem, workspace)
    }

    void container(@DelegatesTo(value = ContainerConfigurer, strategy = DELEGATE_FIRST) Closure configurer) {
        def cc = new ContainerConfigurer()
        configurer.delegate = cc
        configurer.resolveStrategy = DELEGATE_FIRST
        configurer()
        containers.add(cc)
    }
}
