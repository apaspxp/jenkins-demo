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
                script {
                    withCredentials([usernamePassword(credentialsId: 'DockerHub_Credential', passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
                        // Generate a timestamp or version number for the image tag
                        def timestamp = new Date().format("yyyyMMdd_HHmmss")
                        def imageTag = "jenkins-demo:${timestamp}"

                        // Build the Docker image using the spring-boot:build-image Maven goal
                        sh "mvn spring-boot:build-image -Dspring-boot.build-image.imageName=apaspxp/${imageTag}"
//                         sh "mvn spring-boot:build-image -Dspring-boot.build-image.imageName=apaspxp/jenkins-demo:latest"

                        // Log in to Docker Hub using the credentials
                        sh "docker login -u $DOCKERHUB_USERNAME -p $DOCKERHUB_PASSWORD"
//                         sh "echo $DOCKERHUB_PASSWORD | docker login --username $DOCKERHUB_USERNAME --password-stdin"

                        // Push the Docker image to a registry
                        sh "docker push apaspxp/${imageTag}"
//                         sh "docker push apaspxp/jenkins-demo:latest"

                        // Tag the image as "latest"
                        sh "docker tag apaspxp/${imageTag} apaspxp/jenkins-demo:latest"
                        sh "docker push apaspxp/jenkins-demo:latest"

                        // Print the image tag for reference
                        echo "Docker image tag: ${imageTag}"
                    }
                }
            }
        }
        stage('Deploy to Kubernetes'){
                steps{
//                    script{
// //                        sh "kubectl create deployment jenkins-demo-deployment --image=jenkins-demo"
//                          sh "kubectl get all"
//                 }
                script {
                withCredentials([file(credentialsId: 'Kubernetes_Credentials', variable: 'KUBECONFIG')]) {
                                    def imageName = 'jenkins-demo:latest'
//                                     def deploymentName = 'my-deployment'
//                                     def containerName = 'my-container'
                                    // def yamlContent = """
                                    //     apiVersion: apps/v1
                                    //     kind: Deployment
                                    //     metadata:
                                    //       name: ${deploymentName}
                                    //     spec:
                                    //       replicas: 1
                                    //       selector:
                                    //         matchLabels:
                                    //           app: ${deploymentName}
                                    //       template:
                                    //         metadata:
                                    //           labels:
                                    //             app: ${deploymentName}
                                    //         spec:
                                    //           containers:
                                    //           - name: ${containerName}
                                    //             image: ${imageName}
                                    //             ports:
                                    //             - containerPort: 8081
                                    //   """

                                    sh "kubectl --kubeconfig=${KUBECONFIG}"
                                    sh "echo kubectl --kubeconfig=${KUBECONFIG} apply -f -"
                                    sh "kubectl apply services.yml"
                                    sh "kubectl apply -f services.yml"
                    }
                }
             }
          }
  }
}
    
