package com.tidyjava.examples

import com.structurizr.api.StructurizrClient
import com.tidyjava.structurizr.Structurizr

class HelloWorld {
    private static final String API_KEY = "7b35cabd-1b91-4237-8e92-b3c6c88c4eed"
    private static final String API_SECRET = "5762b36c-707e-4db8-bf83-d630a3847231"
    private static final int WORKSPACE_ID = 32541

    static void main(String[] args) {
        def ws = Structurizr.workspace {
            name "My First Workspace"
            description "I'm using this to learn about Structurizr"

            model {
                softwareSystem {
                    name "World"
                    description "Earth, to be precise."
                }
                person {
                    name "Me"
                    description "Myself."
                    uses {
                        softwareSystem {
                            name "World"
                            description "Hello, World!"
                        }
                    }
                }
            }

            views {
                systemContext {
                    softwareSystem "World"
                    key "My First View"
                    description "Just me and the world."
                }
            }
        }

        StructurizrClient structurizrClient = new StructurizrClient(API_KEY, API_SECRET);
        structurizrClient.putWorkspace(WORKSPACE_ID, ws);
    }
}
