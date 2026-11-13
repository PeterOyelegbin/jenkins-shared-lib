#!/usr/bin/env groovy

package com.example

class Docker implements Serializable {
    
    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo "building the docker image..."
        script.withCredentials([script.usernamePassword(credentialsId: 'dockerhub-cred', passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
            script.sh "docker build -t $imageName ."
            script.sh "echo '${script.DOCKERHUB_PASSWORD}' | docker login -u '${script.DOCKERHUB_USERNAME}' --password-stdin"
            script.sh "docker push $imageName"
        }
    }
}
