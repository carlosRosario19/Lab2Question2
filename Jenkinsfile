pipeline {
    agent any

    environment {
        DOCKER_HUB_CREDENTIALS = credentials('docker-hub-credentials') // Jenkins credentials ID for Docker Hub
        DOCKER_IMAGE_NAME = 'carlosrosariocentennial/lab2question2' // Replace with your Docker Hub username and image name
        DOCKER_IMAGE_TAG = 'latest' // You can use a dynamic tag like the build number
    }

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
                bat 'mvn clean package' // Use 'sh' for Linux agents
            }
        }

        // Stage 3: Run tests
        stage('Test') {
            steps {
                bat 'mvn test' // Use 'sh' for Linux agents
            }
        }

        // Stage 4: Build Docker Image
        stage('Build Docker Image') {
            steps {
                script {
                    // Build the Docker image using the Dockerfile
                    docker.build("${env.DOCKER_IMAGE_NAME}:${env.DOCKER_IMAGE_TAG}", ".")
                }
            }
        }

        // Stage 5: Login to Docker Hub
        stage('Login to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', "${env.DOCKER_HUB_CREDENTIALS}") {
                        // No additional steps needed here, just logging in
                    }
                }
            }
        }

        // Stage 6: Push Docker Image to Docker Hub
        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', "${env.DOCKER_HUB_CREDENTIALS}") {
                        docker.image("${env.DOCKER_IMAGE_NAME}:${env.DOCKER_IMAGE_TAG}").push()
                    }
                }
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