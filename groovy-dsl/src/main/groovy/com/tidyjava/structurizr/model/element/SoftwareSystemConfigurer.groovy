package com.tidyjava.structurizr.model.element

import com.structurizr.Workspace


class SoftwareSystemConfigurer extends ElementConfigurer {

    void apply(Workspace workspace) {
        def model = workspace.getModel()
        def softwareSystem = model.addSoftwareSystem(name, description)
        apply(softwareSystem, workspace)
    }
}
