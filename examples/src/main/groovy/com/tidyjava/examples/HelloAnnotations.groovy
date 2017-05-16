package com.tidyjava.examples

import com.structurizr.Workspace
import com.structurizr.api.StructurizrClient

class HelloAnnotations {
    private static final String API_KEY = "7b35cabd-1b91-4237-8e92-b3c6c88c4eed"
    private static final String API_SECRET = "5762b36c-707e-4db8-bf83-d630a3847231"
    private static final int WORKSPACE_ID = 32541

    static void main(String[] args) {
        def ws = new Workspace("My First Workspace", "I'm using this to learn about Structurizr")

        ws.configure {
            model {
                softwareSystem {
                    name "Mail Server"
                    description "Allows sending emails"
                }
                softwareSystem {
                    name "Spammer"
                    description "Spams around"
                    container {
                        name "Some container"
                        description "Ugh"
                        technology "Oh my!"
                        componentFinder {
                            packageToScan "com.tidyjava.examples"
                            strategy structurizrAnnotations()
                        }
                    }
                }
            }
            views {
                component {
                    softwareSystem "Spammer"
                    container "Some container"
                    key "Containerish key"
                    description "Containerish description"
                }
                styles {
                    component {
                        background "#1168bd"
                        color "#ffffff"
                    }
                }
            }
        }

        StructurizrClient structurizrClient = new StructurizrClient(API_KEY, API_SECRET);
        structurizrClient.putWorkspace(WORKSPACE_ID, ws);
    }
}
