pipeline {
    agent any

    stages {
        // Stage 1: Checkout code from GitHub
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/carlosRosario19/Lab2Question2.git'
            }
        }

        // Stage 2: Build the Maven project
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        // Stage 3: (Optional) Add more stages like testing or deployment
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}