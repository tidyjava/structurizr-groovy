package com.tidyjava.examples;

import com.structurizr.annotation.Component;
import com.structurizr.annotation.UsesComponent;

@Component
public class TwitterComponent {
    @UsesComponent(description = "Send an email about a Twitter update")
    private MailComponent mailComponent;
}
