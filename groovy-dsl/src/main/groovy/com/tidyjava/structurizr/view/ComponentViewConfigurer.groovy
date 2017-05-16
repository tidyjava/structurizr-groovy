package com.tidyjava.structurizr.view

import com.structurizr.Workspace

class ComponentViewConfigurer {
    String softwareSystem
    String container
    String key
    String description

    void apply(Workspace workspace) {
        def views = workspace.getViews()
        def softwareSystem = workspace.getModel().getSoftwareSystemWithName(softwareSystem)
        def container = softwareSystem.getContainerWithName(container)
        def view = views.createComponentView(container, key, description)
        view.addAllElements()
    }

    void softwareSystem(String softwareSystem) {
        this.softwareSystem = softwareSystem
    }

    void container(String container) {
        this.container = container
    }

    void key(String key) {
        this.key = key
    }

    void description(String description) {
        this.description = description
    }
}
