#!/usr/bin/env groovy

package com.example

class Docker implements Serializable {
    
    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo "building the docker image..."
        script.sh "docker build -t $imageName ."
    }

    def dockerLogin() {
        script.withCredentials([script.usernamePassword(credentialsId: 'dockerhub-cred', passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
            script.sh "echo '${script.DOCKERHUB_PASSWORD}' | docker login -u '${script.DOCKERHUB_USERNAME}' --password-stdin"
        }
    }

    def dockerPush(String imageName) {
        script.echo "pushing the docker image..."
        script.sh "docker push $imageName"
    }
}
