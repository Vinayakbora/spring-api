pipeline{
    agent any
    stages{

        stage("Checkout for git")
        {
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Vinayakbora/spring-api']])
            }
        }
        stage("Building jar")
        {
            steps{
                sh " mvn clean install -DskipTests"
            }
        }

         stage("Create Container")
        {
            steps{
                sh "docker compose up --build"
            }
        }

    }
}