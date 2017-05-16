package com.tidyjava.structurizr.model.element

import com.structurizr.Workspace

class PersonConfigurer extends ElementConfigurer {

    void apply(Workspace workspace) {
        def model = workspace.getModel()
        def person = model.addPerson(name, description)
        apply(person, workspace)
    }
}
