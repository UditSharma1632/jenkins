node {
    stage('Preparation') { // for display purposes
        // Get some code from a GitHub repository
        git 'https://github.com/UditSharma1632/jenkins.git'
        
    }
    stage('Build') {
                bat "mvn clean test"
    }
    
    stage('Package') {
                bat "mvn package"
    }
    
    stage('ansible') {
                bat "- hosts: 172.17.0.3
  tasks:
    - maven_artifact:
        group_id: com.maven.demo
        artifact_id: jenkins
        repository_url: 'http://localhost:8081/repository/nexus-demo/'
        username: admin
        password: November@2021
        dest: /etc/ansible/hosts"
    }
    
    stage('Nexus') {
        nexusArtifactUploader artifacts: [[artifactId: 'jenkins', classifier: '', file: 'target/jenkins-1.0.0-SNAPSHOT.jar', type: 'jar']], 
            credentialsId: 'jenkins', groupId: 'com.maven.demo', nexusUrl: 'localhost:8081', nexusVersion: 'nexus3', 
            protocol: 'http', repository: 'nexus-demo/', version: '1.0.0'
    }
}
