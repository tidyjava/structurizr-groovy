package com.tidyjava.structurizr.model

import com.structurizr.Workspace
import com.structurizr.model.Element

class UsageConfigurer {
    String softwareSystem
    String description

    void apply(Element element, Workspace workspace) {
        def model = workspace.getModel()
        def softwareSystem = model.getSoftwareSystemWithName(softwareSystem)
        element.uses(softwareSystem, description)
    }

    void description(String description) {
        this.description = description
    }

    void softwareSystem(String softwareSystem) {
        this.softwareSystem = softwareSystem
    }
}
