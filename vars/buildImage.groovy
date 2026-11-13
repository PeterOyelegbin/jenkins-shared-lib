#!/usr/bin/env groovy

import com.example.Docker

def call(String imageName) {
    // echo "building the docker image..."
    // withCredentials([usernamePassword(credentialsId: 'dockerhub-cred', passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
    //     sh "docker build -t $imageName ."
    //     sh "echo '${script.DOCKERHUB_PASSWORD}' | docker login -u '${script.DOCKERHUB_USERNAME}' --password-stdin"
    //     sh "docker push $imageName"
    // }
    return new Docker(this).buildDockerImage(imageName)
}

return this
