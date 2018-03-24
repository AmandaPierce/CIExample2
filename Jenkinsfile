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
                sh 'mvn -f Tutorial3TestSuites/testData/pom.xml clean test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
