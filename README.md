Getting Started 
===============

1. Install JDK 8 or higher and set JAVA_HOME environment variable
2. Install Maven 3.5 or higher and add M2_HOME/bin folder to path


Note : 
======
This automation suit should triggered :
Either,
when Wanderly code will deploy 
Or,
if we can have access in Jenkins only for execution purpose, then we can procced with manually.

Steps to configure the job : 
============================
Step 1:- Click New Items -> Enter Project Name -> Select Maven Project -> Click OK

Step 2:- Provide the job description as "Wanderly Automation Suite"

Step 3:- In Source Code Management, Select 'Git' option. (This should be visible once you have successfully installed Git Plugin).

Step 4:- Seelct GitHub Project ans enter the below URL "https://github.com/orionhcs/automation-tests.git"

Step 5:- In "source Code management" select "git" and enter URL "https://github.com/orionhcs/automation-tests.git"

Step 6:- Int Build section "Root POM is "pom.xml"
	Goals & options : Clean Compile Test
	
Step 7:-Save


    
  
    