pipeline{
    agent any
    tools{
        maven 'maven'
    }
    stages{
        stage('build maven'){
            steps{
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'git_credential', url: 'https://github.com/apaspxp/jenkins-demo']])
                sh 'mvn clean install'
            }
        }
        stage('Build Docker Image') {
            steps {
                // Build the Docker image using the spring-boot:build-image Maven goal
                sh "mvn spring-boot:build-image -Dspring-boot.build-image.imageName=apaspxp/jenkins-demo:latest"

                // Push the Docker image to a registry
                sh "docker push apaspxp/jenkins-demo:latest"
            }
        }
  }
}
    
