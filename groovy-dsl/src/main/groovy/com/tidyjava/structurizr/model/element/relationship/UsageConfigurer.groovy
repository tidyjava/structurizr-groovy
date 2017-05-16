package com.tidyjava.structurizr.model.element.relationship

import com.structurizr.Workspace
import com.structurizr.model.Element

import static groovy.lang.Closure.DELEGATE_FIRST

class UsageConfigurer {
    List<RelationshipConfigurer> relationships = []

    void apply(Element element, Workspace workspace) {
        relationships.forEach { it.apply(element, workspace) }
    }

    void softwareSystem(@DelegatesTo(value = SoftwareSystemRelationshipConfigurer, strategy = DELEGATE_FIRST) Closure configurer) {
        def rc = new SoftwareSystemRelationshipConfigurer()
        configurer.delegate = rc
        configurer.resolveStrategy = DELEGATE_FIRST
        configurer()
        relationships.add(rc)
    }
}
