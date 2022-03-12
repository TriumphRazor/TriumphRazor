@Library('Venom-shared-library')_
#!/usr/bin/env groovy

def call(String name = 'human') {
  echo "Hello, ${name}."
}
