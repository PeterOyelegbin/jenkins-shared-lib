#!/usr/bin/env groovy

def call() {
    echo "building the dotnet application for branch: $BRANCH_NAME"
    sh "ls ."
    sh "docker --version"
    sh "dotnet --version"
    sh "dotnet publish HelloWorldApp.Web/HelloWorldApp.Web.csproj --configuration Release"
}

return this
