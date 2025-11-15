pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                echo "Pulling latest code from GitHub..."
                checkout scm
            }
        }

        stage('Build Project') {
            steps {
                echo "Building Maven project..."
                bat 'mvn clean install -U'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                echo "Running TestNG test suite..."
                bat 'mvn test -DsuiteXmlFile=testng.xml'
            }
        }

        stage('Publish TestNG Reports') {
            steps {
                echo "Publishing TestNG HTML report..."
                publishHTML (target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'test-output',
                    reportFiles: 'index.html',
                    reportName: 'TestNG Report'
                ])
            }
        }
    }

    post {
        success {
            echo "✅ Build & Tests executed successfully!"
        }
        failure {
            echo "❌ Build failed — check the console logs!"
        }
    }
}
