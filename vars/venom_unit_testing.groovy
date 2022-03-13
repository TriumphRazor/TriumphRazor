#!/usr/bin/env groovy

def call(String COMPONENT_NAME) {
    UNIT_TEST_RESULT = sh (
        script: 'pytest project_dirs/${COMPONENT_NAME}/ -vv -p -s no:warnings',
        returnStdout: true
    )
    println "${UNIT_TEST_RESULT}"

    publishHTML target: ([
        allowMissing: false,
        alwaysLinkToLastBuild: false,
        keepAll: true,
        reportDir: './',
        reportFiles: 'pytest_html_report.html',
        reportName: 'UnitTest Report'
    ])
}
