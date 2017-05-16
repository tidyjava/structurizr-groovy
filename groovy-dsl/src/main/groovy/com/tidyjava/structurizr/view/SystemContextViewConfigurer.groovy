package com.tidyjava.structurizr.view

import com.structurizr.Workspace

class SystemContextViewConfigurer {
    String softwareSystem
    String key
    String description

    void apply(Workspace workspace) {
        def views = workspace.getViews()
        def softwareSystem = workspace.getModel().getSoftwareSystemWithName(softwareSystem)
        def view = views.createSystemContextView(softwareSystem, key, description)
        view.addAllElements()
    }

    void softwareSystem(String softwareSystem) {
        this.softwareSystem = softwareSystem
    }

    void key(String key) {
        this.key = key
    }

    void description(String description) {
        this.description = description
    }
}
