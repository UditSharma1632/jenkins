node {
    stage('Preparation') { // for display purposes
        // Get some code from a GitHub repository
        git 'https://github.com/UditSharma1632/jenkins.git'
        
    }
    stage('Build and Package') {
                sh "mvn clean package"
    }
     
    stage('Nexus') {
        nexusArtifactUploader artifacts: [[artifactId: 'jenkins', classifier: '', file: 'target/jenkins-1.0.0.jar', type: 'jar']], 
            credentialsId: 'Nexus', groupId: 'com.maven.demo', nexusUrl: 'host.docker.internal:8110', nexusVersion: 'nexus3', 
            protocol: 'http', repository: 'nexus-repo', version: '1.0.0'
    }
    
    stage('Executing Playbook') { 
                ansiblePlaybook (credentialsId: 'id_rsa', disableHostKeyChecking: true,
                                 installation: 'ansible', inventory: 'inventory.inv', playbook: 'playbook.yml')
        
    }
    
    
}
