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
    
    stage('Nexus') {
        nexusArtifactUploader artifacts: [[artifactId: 'jenkins', classifier: '', file: 'target/jenkins-1.0.0-SNAPSHOT.jar', type: 'jar']], 
            credentialsId: 'jenkins', groupId: 'com.maven.demo', nexusUrl: 'localhost:8081', nexusVersion: 'nexus3', 
            protocol: 'http', repository: 'nexus-demo/', version: '1.0.0'
    }
    
    stage('ansible') {
                ansiblePlaybook(disableHostKeyChecking: true, installation: 'Ansible', inventory: 'inventory.inv', playbook: 'playbook.yml')
    }
}
