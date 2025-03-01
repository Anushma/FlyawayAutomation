pipeline {
    agent any

    stages {
        stage('Checkout') {  // Added a stage for Checkout
            steps {
                git branch: 'main', url: 'https://github.com/Anushma/FlyawayAutomation.git'

                // Run Maven Wrapper Commands
                echo 'Building the Project with maven compile'
            }
        }

        stage('Build') {
            steps {
                // Run Maven Wrapper Commands
                echo 'Building the Project with maven compile'
            }
        }

        stage('Test') {
            steps {
                // Run Maven Wrapper Commands
                echo 'Testing the Project with maven test'
            }
        }

        stage('Package') {
            steps {
                // Run Maven Wrapper Commands
                echo 'Packaging the Project with maven package'
            }
        }

        stage('Containerize') {
            steps {
                // Docker build command
                echo 'Containerize the App with docker'
            }
        }

        stage('Deploy') {
            steps {
                // Docker run command with detached mode
                echo 'Deploy the App with Docker'
            }
        }
    }
}
