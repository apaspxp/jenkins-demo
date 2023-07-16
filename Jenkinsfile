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
                // Generate a timestamp or version number for the image tag
                def timestamp = new Date().format("yyyyMMdd_HHmmss")
                def imageTag = "jenkins-demo:${timestamp}"
                withCredentials([usernamePassword(credentialsId: 'DockerHub_Credential', passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
                    // Build the Docker image using the spring-boot:build-image Maven goal
                    sh "mvn spring-boot:build-image -Dspring-boot.build-image.imageName=apaspxp/${imageTag}"

                    // Log in to Docker Hub using the credentials
                    sh "docker login -u $DOCKERHUB_USERNAME -p $DOCKERHUB_PASSWORD"

                    // Push the Docker image to a registry
                    sh "docker push apaspxp/${imageTag}"

                    // Tag the image as "latest"
                    sh "docker tag apaspxp/${imageTag} apaspxp/jenkins-demo:latest"
                    sh "docker push apaspxp/jenkins-demo:latest"

                    // Print the image tag for reference
                    echo "Docker image tag: ${imageTag}"
                }
            }
        }
  }
}
    
