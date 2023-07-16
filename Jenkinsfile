pipeline{
    agent any
    tools{
        maven 'maven'
    }
    stages{
//         stage('build maven'){
//             steps{
//                 checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'git_credential', url: 'https://github.com/apaspxp/jenkins-demo']])
//                 sh 'mvn clean install'
//             }
//         }
        stage('Build Docker Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'DockerHub_Credential', passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
                    // Build the Docker image using the spring-boot:build-image Maven goal
                    sh "mvn spring-boot:build-image -Dspring-boot.build-image.imageName=apaspxp/jenkins-demo:latest"

                    // Log in to Docker Hub using the credentials
                    sh "docker login -u $DOCKERHUB_USERNAME -p $DOCKERHUB_PASSWORD"

                    // Push the Docker image to a registry
                    sh "docker push apaspxp/jenkins-demo:latest"
                }
            }
        }
  }
}
    
