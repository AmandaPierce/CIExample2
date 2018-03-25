pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn -f Tutorial3/pom.xml clean'
                sh 'mvn -f Tutorial3TestSuites/testData/pom.xml clean'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn -f Tutorial3/pom.xml install'
                sh 'mvn -f Tutorial3TestSuites/testData/pom.xml test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....CCC'
            }
        }
    }
}
