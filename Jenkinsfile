pipeline {
  agent any
  stages {
    stage('Test Run On Dev') {
      parallel {
        stage('Test Run On Dev') {
          steps {
            sh 'mvn clean install -Denv="dev"'
          }
        }

        stage('Test QA') {
          steps {
            sh 'mvn clean install -Denv="qa"'
          }
        }

        stage('Test Stage') {
          steps {
            sh 'mvn clean install -Denv="stage"'
          }
        }

        stage('Test PROD') {
          steps {
            sh 'mvn clean install'
          }
        }

      }
    }

    stage('') {
      steps {
        sh 'echo "test execution is done"'
      }
    }

  }
}