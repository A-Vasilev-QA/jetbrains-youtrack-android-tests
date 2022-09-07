#Tests for Jetbrains Youtrack Android aplication 
https://github.com/JetBrains/youtrack-mobile

#Jenkins job
https://jenkins.autotests.cloud/job/C12-AVasilevQA-Diploma-mobile/

Also can be used for local tests with emulator or real device

#USAGE examples
For tests execution just run the Jenkins job with needed parameters.

Another way

Really, you don't need it. You won't fill the data correct, just use the Jenkins job.

OK, other way: run remote tests - fill remote.properties or to pass value:
device (default "Google Pixel 4"")
osVersion (Default 10.0)

Run tests with filled remote.properties:
gradle clean :test --tests "qa.avasilev.tests.MainTest"

Serve report:
allure serve build/allure-results

You can also add some options via -D if they're missed in the remote.properties, but who cares? Use Jenkins.
