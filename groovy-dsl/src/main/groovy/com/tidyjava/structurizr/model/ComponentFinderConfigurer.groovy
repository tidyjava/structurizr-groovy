package com.tidyjava.structurizr.model

import com.structurizr.componentfinder.ComponentFinder
import com.structurizr.componentfinder.ComponentFinderStrategy
import com.structurizr.componentfinder.StructurizrAnnotationsComponentFinderStrategy
import com.structurizr.model.Container

class ComponentFinderConfigurer {
    String packageToScan
    ComponentFinderStrategy strategy

    void apply(Container container) {
        def componentFinder = new ComponentFinder(container, packageToScan, strategy)
        componentFinder.findComponents()
    }

    void packageToScan(String packageToScan) {
        this.packageToScan = packageToScan
    }

    void strategy(ComponentFinderStrategy strategy) {
        this.strategy = strategy
    }

    ComponentFinderStrategy structurizrAnnotations() {
        return new StructurizrAnnotationsComponentFinderStrategy()
    }
}
