package com.tidyjava.structurizr.view

import com.structurizr.Workspace

class ElementStyleConfigurer {
    String tag
    String background
    String color

    ElementStyleConfigurer(String tag) {
        this.tag = tag
    }

    void apply(Workspace workspace) {
        def styles = workspace.views.configuration.styles
        styles.addElementStyle(tag).background(background).color(color)
    }

    void background(String background) {
        this.background = background
    }

    void color(String color) {
        this.color = color
    }
}
