pipeline {
    agent any
    tools {
        maven 'MAVEN3.9'
    }
    stages {
        stage("build jar"){
            steps {
                script {
                    echo "building the application"
                    sh "mvn package"
                }
            }
        }
        stage("build image"){
            steps {
                script {
                    echo "building the docker image"
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh 'docker build -t sanjay2527/demo-app:jma-2.0 .'
                        sh 'echo $PASSWORD | docker login -u $USER --password-stdin'
                        sh 'docker push sanjay2527/demo-app:jma-2.0'
                    }
                }
            }
        }
        stage("deploy"){
            steps{
                script{
                    echo "deploying the application"
                }
            }
        }
    }
}
