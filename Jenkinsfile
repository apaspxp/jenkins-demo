pipeline {
  agent any
  
  stages {
    stage('Checkout') {
      steps {
        git 'https://github.com/apaspxp/jenkins-demo'
      }
    }
    
    stage('Build') {
      steps {
        sh 'mvn clean install'
      }
    }
    
    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }
    
    stage('Deploy') {
      steps {
        sh 'mvn clean package'
      }
    }
  }
}
