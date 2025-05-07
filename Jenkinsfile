pipeline {
    agent any

    environment {
        IMAGE_NAME = 'kaviya1701/course-enrollment-app'
    }

    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', url: 'https://github.com/kaviya17-01/CourseEnrollmentSpringBoot.git'
            }
        }

        stage('Build with Maven') {
            steps {
                dir('CourseEnrollment') {
                    bat 'mvn clean package -DskipTests=true -Dmaven.test.skip=true'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                dir('CourseEnrollment') {
                    bat "docker build -t %IMAGE_NAME% ."
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                dir('CourseEnrollment') {
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                        bat 'echo %DOCKER_PASS% | docker login -u %DOCKER_USER% --password-stdin'
                        bat "docker push %IMAGE_NAME%"
                    }
                }
            }
        }

        stage('Run Container (Optional)') {
            steps {
                bat "docker run -d -p 8080:8080 %IMAGE_NAME%"
            }
        }
    }

    post {
        always {
            echo 'Cleaning workspace...'
            cleanWs()
        }

        success {
            echo ' Pipeline completed successfully!'
        }

        failure {
            echo ' Pipeline failed. Check the logs.'
        }
    }
}


