pipeline{
    agent{
        node{
            label "" 
            customWorkspace "/var/lib/jenkins/workspace/${BRANCH_NAME}"
        }
    }
    stages{
        stage("Initiating"){
            steps{
                sh(script: "echo Initiating", returnStdout: false)
            }
        }
        stage("Building"){
            steps{
                parallel svc_usermng:{
                    sh(script: "echo \"Building SVC User Management\"", returnStdout: false)
                },
                svc_sellsmng:{
                    sh(script: "echo \"Building SVC Sells Management\"", returnStdout: false)
                },
                failFast: true
            }
        }
        stage("Deploying Dev"){
            steps{
                sh(script: "echo \"Deploying Dev\"")
            }
        }
        stage("Testing Dev"){
            steps{
                sh(script: "echo \"Testing Dev\"")
            }
        }
        stage("Deploying QA"){
            steps{
                sh(script: "echo \"Deploying QA\"")
            }
        }
    }
}