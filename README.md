# Perl On NetBeans
This plugin adds support for Perl 5 to NetBeans

---  

## Plugin Documentation
The usage documentation for each release is available under the corresponding folder in the repo at docs/user-guides

For all updates, please subscribe to the page on [Facebook](https://www.facebook.com/PerlOnNetBeans) and follow the plugin updates on [Twitter](https://twitter.com/perlonnetbeans)

The plugin can be downloaded from Releases folder under this repository for the corresponding version of your NetBeans installation. 

__Please note the supported version before downloading and installing the plugin__

---  

## Getting Started (Pre-Requisites)
- Download and install the plugin for the corresponding supported version of NetBeans from https://netbeans.apache.org/download/index.html
- Download and install Strawberry Perl 5.32.1.1 from https://strawberryperl.com/ *(Perl::Tidy v20210111 is installed by default)*
- Install Perl::Critic using the command *$> cpan install Perl::Critic*
- Copy the files *"perlcritic"* and *"perlcritic.bat"* from *{PERL_INSTALLED_LOCATION}/perl/site/bin* to *{PERL_INSTALLED_LOCATION}/perl/bin*
- Start Perlin'

### Optional (For Dancer web aplications)
- Install Dancer2 using the command *$> cpan install Dancer2*  
- Copy the files *"plackup"* and *"plackup.bat"* from *{PERL_INSTALLED_LOCATION}/perl/site/bin* to *{PERL_INSTALLED_LOCATION}/perl/bin*  

*N.B. - Perl::Critic v1.140 is the latest as of writing this guide*  

---  

## Updates

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
