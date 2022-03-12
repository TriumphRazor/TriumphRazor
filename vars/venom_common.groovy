#!/usr/bin/env groovy

def call(String component_name){

    pipeline{
        agent any
        options {
            timestamps()
        }
        environment {
            COMPONENT_NAME = "${component_name}"
        }

        stages {
            stage('Cleanup Workspace') {
                steps {
                    cleanWs()
                    checkout scm
                }
            }

            stage("Run Linters") {

                steps {
                    script {
                        linters "${COMPONENT_NAME}"
                    }
                }
            }

            stage("Unit Testing") {
                steps {
                    venom_unit_testing "${COMPONENT_NAME}"
                }
            }


        }
    }

}
