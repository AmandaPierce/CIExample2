pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn -f Tutorial3/pom.xml clean install'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..BBBB'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
