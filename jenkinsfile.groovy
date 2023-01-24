pipeline {
    agent any
    stages {
        stage("Git Checkout"){
            steps{
                git credentialsId: 'github', url: 'https://github.com/Karthikraja2/sample'
            }
        }
        stage('Build') {
            steps {
                // your build steps here
            }
        }
        stage('Test') {
            steps {
                // Run JUnit tests
                sh 'mvn test'
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }
}