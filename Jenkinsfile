#!/user/bin/env groovy
@Library('jenkins-shared-library')
def gv

pipeline {
    agent any
    tools {
        maven 'MAVEN3.9'
    }
    stages {
        stage("initialize"){
            steps{
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar"){
            steps {
                script {
                    buildJar()
                }
            }
        }
        stage("build image"){
            steps {
                script {
                    buildImage()
                }
            }
        }
        stage("deploy"){
            steps{
                script{
                    gv.deploy()
                }
            }
        }
    }
}
