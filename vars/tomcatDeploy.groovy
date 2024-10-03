def call(){
  sshagent(['tomcat']) {
      sh "scp -o StrictHostKeyChecking=no target/ai-leads.war ec2-user@172.31.2.203:/opt/tomcat9/webapps/"
      sh "ssh ec2-user@172.31.2.203 /opt/tomcat9/bin/shutdown.sh"
      sh "ssh ec2-user@172.31.2.203 /opt/tomcat9/bin/startup.sh"
  }
}
