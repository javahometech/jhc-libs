def call(tomcatIp,warName,credentials){
  sshagent(["${credentials}"]) {
      sh "scp -o StrictHostKeyChecking=no target/${warName} ec2-user@${tomcatIp}:/opt/tomcat9/webapps/"
      sh "ssh ec2-user@${tomcatIp} /opt/tomcat9/bin/shutdown.sh"
      sh "ssh ec2-user@${tomcatIp} /opt/tomcat9/bin/startup.sh"
  }
}
