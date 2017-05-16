package com.tidyjava.structurizr

import com.structurizr.Workspace

import static groovy.lang.Closure.DELEGATE_FIRST

class WorkspaceConfigurerExtension {

    static void configure(Workspace workspace,
                          @DelegatesTo(value = WorkspaceConfigurer, strategy = DELEGATE_FIRST) Closure configurer) {
        def wc = new WorkspaceConfigurer()
        configurer.delegate = wc
        configurer.resolveStrategy = DELEGATE_FIRST
        configurer()
        wc.apply(workspace)
    }
}
