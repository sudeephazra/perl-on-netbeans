# Perl On NetBeans
This plugin adds support for Perl 5 to NetBeans

---  

## Plugin Documentation
The usage documentation for each release is available under the corresponding folder in the repo at docs/user-guides

For all updates, please bookmark this [GitHub Page](https://sudeephazra.github.io/perl-on-netbeans/)

The plugin can be downloaded from [Releases](https://github.com/sudeephazra/perl-on-netbeans/releases/) under this repository. 

__Please note the supported Apache NetBeans version before downloading and installing the plugin__

---  

## Getting Started 
- Download and install Apache NetBeans from [here](https://netbeans.apache.org/download/index.html)

### Compiler and Packaging Module

**NEW** Starting release 0.8, PerlOnNetBeans will use Carton for dependency management. Please read the more about it on official documentation page for [Carton](https://metacpan.org/pod/Carton). This feature is not fully implemented in this release and is used only during code execution. 

#### Windows 
- Download and install [Strawberry Perl](https://strawberryperl.com/)
- *(Optional)* Open a Terminal and type the following command to install Carton
```bash
cpan install Carton
```
#### Linux (Ubuntu)
- Perl is installed by default on Linux
- *(Optional)* Open a Terminal and type the following commands to install Carton
```bash
curl -L http://cpanmin.us | perl - --sudo App::cpanminus
cpanm Carton
```
### Installing supporting modules
- Install the Perl::Tidy and Perl::Critic modules

### Installing the PerlOnNetBeans plugin
- Download and install the plugin from [Perl On NetBeans](https://plugins.netbeans.apache.org/catalogue/?id=98) and restart the IDE
- Create a new project
- *(Optional)* Open the project root location in your terminal and run the command
```bash
carton install
```
- Start Perlin'
- *(Optional)* If you add any new module in your code, please add the entry to the `cpanfile` and run the following command in the project root folder
```bash
carton install
```


---  

## Updates
Version: Release 0.8  
Date: 12-Jul-2024 

Features:
- Fixed autocomplete errors
- Fixed version number inconsistencies
- **Breaking change**: Added Carton as the package manager for new projects *(Not fully implemented)*

---
Version: Release 0.7   
Date: 12-May-2024  
Tested On: NetBeans 21 with Starwberry Perl 5.32.1 64-bit on Windows 11  
Recommended Perl: Starwberry Perl 5.32.1 64-bit  

Features:
- Updated release location to Maven central

---
Version: Release 0.6  
Date: 25-May-2022  
Tested On: NetBeans 13 with Starwberry Perl 5.32.1.1 64-bit on Windows 10  
Recommended Perl: Starwberry Perl 5.32.1.1 64-bit  

Features:
- Fixed highlighting issue with empty strings

---
Version: Release 0.5.1  
Date: 10-Mar-2018  
Tested On: NetBeans 8.2, 9, and 10 on Windows 7  

Features:
- Combined external libraries into the plugin to correct plugin verification issues

---
Version: Release 0.5  
Date: 27-Feb-2018  
Tested On: NetBeans 8.2, 9, and 10 on Windows 7  

Features:
- Added support for Dancer2 framework (initial stages) 
- Added code completion for keywords 
- Additional Perl::Tidy configuration options
- Corrected custom Perl binary and libraries location integration errors
- Bug fixes around syntax highlighting
- UI improvements
- Performance improvements
- Upgraded underlying helper libraries 

---
Version: Release 0.4   
Date: 19-May-2015  
Tested On: NetBeans 8.2 on Windows 7  

Features:
- Comment toggle using Ctrl+/
- Retain line indentation on new line
- Menu options to run and compile files
- Added code formatting and template under Options -> Tools
- Project copy/move/rename functions
- Theme support
- Added Dancer support
- Removed extra menu buttons

---
