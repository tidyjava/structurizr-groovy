package com.tidyjava.examples;

import com.structurizr.annotation.Component;
import com.structurizr.annotation.UsesComponent;

@Component
public class FacebookComponent {
    @UsesComponent(description = "Send an email about a Facebook update")
    private MailComponent mailComponent;
}
