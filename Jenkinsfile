pipeline{
   agent any
   tools{
       maven '3.8.6'
   }
   stages{
      stage("source"){
          steps{
             git branch: 'master' ,url:'https://github.com/tallahmad047/service-client.git'
        }
      }
       stage ('Build') {
                  steps{

                      bat 'mvn package DskipTests'
                  }
              }



       stage ('Approve Deployment') {
                  input {
                      message 'Do you want to proceed for deployment?'
                  }
                  steps{
                      bat 'echo "Deploying into Server dev."'
                  }
        }
         stage('Builddocker') {
                steps {
                              // Build the Docker image
                             bat 'docker build -t tallahmad047/Nguith2022  .'
                   }
                      }
                  stage('dockertag') {
                           steps {
                                                     // Build the Docker image
                             bat 'docker tag tallahmad047/Nguith2  tallahmad047/Nguith2022:groupe3'
                                    }
                                  }


                      stage('Push') {

                            steps {
                              withDockerRegistry([credentialsId: "groupe3aws" ,url:"" ]){
                              bat 'docker push tallahmad047/Nguith2022:groupe3'
                              }
                            }
                          }

          } // stages

          post {
              aborted {
                  echo "Sending message to Agent"
              } // aborted

              failure {
                  echo "Sending message to Agent"
              } // failure

              success {
                  echo "Sending message to Agent"
              } // success
          } // post
   }
