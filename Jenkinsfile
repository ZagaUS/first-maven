
node {
    stage('Perform CI') {
        echo 'Doing CI stuff...'
    }
    
    stage('Reporting CI Status'){
        def gitRepoUrl = env.GITHUB_REPO_GIT_URL
        def buildUrl = env.BUILD_URL
        def context = env.JOB_BASE_NAME
        def sha = env.GITHUB_PR_HEAD_SHA
        
        def message = "CI build status is: ${currentBuild.getCurrentResult()}"
        def state = currentBuild.getCurrentResult()
        
        step([
            $class: "GitHubCommitStatusSetter",
            reposSource: [$class: "ManuallyEnteredRepositorySource", url: gitRepoUrl],
            contextSource: [$class: "ManuallyEnteredCommitContextSource", context: context],
            errorHandlers: [[$class: "ChangingBuildStatusErrorHandler", result: "UNSTABLE"]],
            commitShaSource: [$class: "ManuallyEnteredShaSource", sha: sha],
            statusBackrefSource: [$class: "ManuallyEnteredBackrefSource",
                                backref: "${buildUrl}flowGraphTable/"],
            statusResultSource: [
                $class: "ConditionalStatusResultSource",
                results:[[$class: "AnyBuildResult", message: message, state: state]]
            ]
        ])
    }
}