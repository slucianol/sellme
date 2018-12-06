pipeline{
    node{
        agent none
        stages{
            stage("Initiating"){
                steps{
                    sh(script: "echo Initiating", returnStdout: false)
                }
            }
            stage("Building"){
                steps{
                    sh(script: "echo Building", returnStdout: false)
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
}