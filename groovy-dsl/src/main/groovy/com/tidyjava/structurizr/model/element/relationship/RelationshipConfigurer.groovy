package com.tidyjava.structurizr.model.element.relationship

import com.structurizr.Workspace
import com.structurizr.model.Element

abstract class RelationshipConfigurer {
    String name
    String description

    abstract void apply(Element element, Workspace workspace)

    void name(String name) {
        this.name = name
    }

    void description(String description) {
        this.description = description
    }
}
