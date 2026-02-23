# <img src="src/jfetch/icon.png" alt="icon" width="28"/> JFectch  
A Java GUI-based Neofetch application made using Swing that supports showing info for up to 44 distros. 


## Features
- Shows system info for most Linux distros as well as FreeBSD, NetBSD, OpenBSD and Oracle Solaris
- Animated dark and light mode toggle
- Animated one-click screenshot button for specs
- Boot time display (Linux only)
- Consistent modern flat UI that doesn’t rely on any Look and Feel
  
**NOTE:** The boot time function is only available on Linux. On BSD and Solaris, it will display "Unavailable".



This app supports most Linux distros as well as FreeBSD, NetBSD, OpenBSD and Oracle Solaris


<img src="screenshots/Light.png" alt="Light mode screenshot" width="600"/>
<img src="screenshots/Toggle.png" alt="Mix screenshot" width="600"/>   <img src="screenshots/save.png" alt="SCreenshot button screenshot" width="600"/>

## Running project
To run jfetch, use `cd dist` and then `java -jar JFetch.jar`

## Common problems and solutions

**JFetch relies on bash to fetch some information from your system** <br>
If it gives off any type of error such as `/bin/bash not found`
- You will need to copy the bash binary from its original place to /bin and re run the project or create a symbolic link `ln -s /usr/local/bin/bash /bin/bash`
- You will need to make sure bash is installed on your system

## 
Copyright © 2025 AndronikosGl. All rights reserved.

This project is source-available. Modification and redistribution are not permitted.



