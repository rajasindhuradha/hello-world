def folderName = "sindhu"
def pipelineDetails = [
  [name: "01-echo-helloworld", script_path: "cicd/01-jenkinsfile-helloworld"],
  [name: "02-maven-build", script_path: "cicd/02-jenkinsfile-maven-build"],
  [name: "03-maven-build-tools", script_path: "cicd/03-jenkinsfile-maven-build-tools"],
  [name: "04-maven-triggers-hook", script_path: "cicd/04-jenkinsfile-maven-triggers-hook"],
  [name: "05-maven-triggers-poll", script_path: "cicd/05-jenkinsfile-maven-triggers-poll"],
  [name: "06-maven-triggers-cron", script_path: "cicd/06-jenkinsfile-maven-triggers-cron"],
  [name: "07-maven-build-options", script_path: "cicd/07-jenkinsfile-maven-build-options"],
  [name: "08-maven-post-cleanup", script_path: "cicd/08-jenkinsfile-maven-post-cleanup"],
  [name: "09-maven-build-parameters-string", script_path: "cicd/09-jenkinsfile-maven-build-params-string"],
  [name: "10-maven-build-parameters-choice", script_path: "cicd/10-jenkinsfile-maven-build-params-choice"]
]

folder(folderName) {
  displayName(folderName)
}

for (pipelineDetail in pipelineDetails) {
  pipelineJob("${folderName}/${pipelineDetail.name}") {
    definition {
      cpsScm {
        scm{
          git {
            branch('main')
            remote{
              url('https://github.com/rajasindhuradha/hello-world.git')
            }
          }
        }
        lightweight(true)
        scriptPath(pipelineDetail.script_path)
      }
    }
  }
}
