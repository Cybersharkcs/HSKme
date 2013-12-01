#! /bin/sh

ssh root@192.168.1.147 '/etc/init.d/tomcat7 stop'
ssh root@192.168.1.147 'rm /var/lib/tomcat7/webapps/HSKme.war'
scp /home/maxime/NetBeansProjects/HSKme/dist/HSKme.war root@192.168.1.147:/var/lib/tomcat7/webapps
ssh root@192.168.1.147 '/etc/init.d/tomcat7 start'