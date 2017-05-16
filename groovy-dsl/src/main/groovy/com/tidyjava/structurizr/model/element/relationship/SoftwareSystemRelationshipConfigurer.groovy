package com.tidyjava.structurizr.model.element.relationship

import com.structurizr.Workspace
import com.structurizr.model.Element

class SoftwareSystemRelationshipConfigurer extends RelationshipConfigurer {

    void apply(Element element, Workspace workspace) {
        def model = workspace.getModel()
        element.uses(model.getSoftwareSystemWithName(name), description)
    }
}
