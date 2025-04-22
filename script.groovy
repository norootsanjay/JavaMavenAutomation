def buildJar(){
  echo "building the application"
  sh "mvn package"
} 

def buildImage(){
   echo "building the docker image"
   withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
      sh 'docker build -t sanjay2527/demo-app:jma-2.0 .'
      sh 'echo $PASS | docker login -u $USER --password-stdin'
      sh 'docker push sanjay2527/demo-app:jma-2.0'
  }
}

def deploy(){
  echo 'deploying the application'
}

return this
