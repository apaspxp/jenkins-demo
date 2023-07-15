pipeline{
    agent any
//     agent {
//         docker {
//             image 'docker:latest'
//             args '-v /var/run/docker.sock:/var/run/docker.sock'
//         }
//     }
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
        stage('Docker') {
            steps {
                  // Deploy Docker image to a container orchestration platform (e.g., Kubernetes)
                  sh 'docker images'


            }
        }
    //     stage('Build Jenkinsfiles') {
    //         steps {
    //           script {
    //       // List of Jenkinsfiles to build
    //           def jenkinsfiles = [
    //           "Jenkinsfile1",
    //           "Jenkinsfile2",
    //           "Jenkinsfile3"
    //         ]
    //           for (def jenkinsfile in jenkinsfiles) {
    //         // Load and build each Jenkinsfile
    //            node {
    //            checkout scm
    //            load "${jenkinsfile}"
    //         }
    //       }
    //     }
    //   }
    // }
  }
}
    
