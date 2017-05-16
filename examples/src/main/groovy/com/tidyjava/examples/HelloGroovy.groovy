package com.tidyjava.examples

import com.structurizr.api.StructurizrClient
import com.tidyjava.structurizr.Structurizr

class HelloGroovy {
    private static final String API_KEY = "7b35cabd-1b91-4237-8e92-b3c6c88c4eed"
    private static final String API_SECRET = "5762b36c-707e-4db8-bf83-d630a3847231"
    private static final int WORKSPACE_ID = 32541

    static void main(String[] args) {
        def ws = Structurizr.workspace {
            name "DSLish Workspace"
            description "DSLish Description"
            model {
                softwareSystem {
                    name "DSLish Software System"
                    description "DSLish Software System Description"
                }
                person {
                    name "Me"
                    description "Myself"
                    uses {
                        softwareSystem {
                            name "DSLish Software System"
                            description "Send a message"
                        }
                    }
                }
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
                systemContext {
                    softwareSystem "DSLish Software System"
                    key "DSLish key"
                    description "DSLish description"
                }
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
