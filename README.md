ApexSwagger
=======
[![Build Status](https://travis-ci.org/ejwill/ApexSwagger.svg?branch=develop)](https://travis-ci.org/ejwill/ApexSwagger)

ApexSwagger is a java app that you can use to document your Salesforce Apex classes.  You tell ApexSwagger where your class files are, and it will generate a set of Swagger formatted JSON files that fully document each REST endpoint.  Command line parameters allow you to control many aspects of ApexSwagger.

## Credits
ApexDoc was originally created by Aslam Bari (http://techsahre.blogspot.com/2011/01/apexdoc-salesforce-code-documentation.html).  It was then taken and extended by David Habib, at Groundwire, in 2011.  It has subsequently been enhanced by David Habib of the Salesforce Foundation in late 2014 for use with Nonprofit Success Pack (https://github.com/SalesforceFoundation/Cumulus). We are unable to offer direct support of reported issues or incorporate enhancement requests at this time, however pull requests are welcome.

## Command Line Parameters
| parameter | description |
|-------------------------- | ---------------------|
| -s *source_directory* | The folder location which contains your apex .cls classes.|
| -t *target_directory* | The folder location where documentation will be generated to.|
| -g *source_url* | A URL where the source is hosted (so ApexSwagger can provide links to your source). Optional.|
| -h *home_page* | The full path to an html file that contains the contents for the home page's content area. Optional.  Not Needed|
| -a *banner_page* | The full path to an html file that contains the content for the banner section of each generated page. Optional.  Not Needed|
| -p *scope* | A semicolon separated list of scopes to document.  Defaults to 'global;public;webService'. Optional.|

## Usage
Copy apexswagger.jar file to your local machine, somewhere on your path.  Each release tag in gitHub has the matching apexswagger.jar attached to it.  Make sure that java is on your path.  Invoke ApexDoc like this example:
```
java -jar apexswagger.jar
    -s '/Users/dhabib/Workspaces/Force.com IDE/Cumulus3/src/classes'
    -t '/Users/dhabib/Dropbox/Cumulus/ApexSwagger'
    -p 'global;public;private;testmethod;webService'
    -h '/Users/dhabib/Dropbox/Cumulus/ApexDoc/homepage.htm'
    -a '/Users/dhabib/Dropbox/Cumulus/ApexDoc/projectheader.htm'
    -g 'http://github.com/SalesforceFoundation/Cumulus/blob/dev/src/classes/'
```

## Documenting Class Files
ApexSwagger scans each class file, and looks for comment blocks with special keywords to identify the documentation to include for a given class, property, or method.  The comment blocks must always begin with /** (or additional *'s) and can cover multiple lines.  Each line must start with * (or whitespace and then *).  The comment block ends with */.  Special tokens are called out with @token.
### Class Comments
Located in the lines above the class declaration.  The special tokens are all optional.

| token | description |
|-------|-------------|
| @author | the author of the class |
| @date | the date the class was first implemented |
| @group | a group to display this class under, in the menu hierarchy|
| @group-content | a relative path to a static html file that provides content about the group|
| @base-path | a base url to display this class under|
| @base-description | one or more lines that provide an overview of the API|
| @path | A relative path to an individual endpoint. The field name MUST begin with a slash. The path is appended to the base path |
| @contact | email address for the owner/support of the API|
| @version | version number of your Swagger documentation| 
| @description | one or more lines that provide an overview of the class|

Example
```
/**
* @author Salesforce.com Foundation
* @date 2014
*
* @group Accounts
* @group-content ../../ApexDocContent/Accounts.htm
*
* @base-path /customer/v1
* @base-description API for to get and write customer information
* @path /accounts
*
* @contact testemail@email.com
* @version 1.0
*
* @description Trigger Handler on Accounts that handles ensuring the correct system flags are set on
* our special accounts (Household, One-to-One), and also detects changes on Household Account that requires
* name updating.
*/
public with sharing class ACCT_Accounts_TDTM extends TDTM_Runnable {
```

### Property Comments
Located in the lines above a property.  The special tokens are all optional.

| token | description |
|-------|-------------|
| @description | one or more lines that describe the property|

Example
```
    /*******************************************************************************************************
    * @description specifies whether state and country picklists are enabled in this org.
    * returns true if enabled.
    */
    public static Boolean isStateCountryPicklistsEnabled {
        get {
```

### Method Comments
In order for ApexSwagger to identify class methods, the method line must contain an explicit scope (global, public, private, testMethod, webService).  The comment block is located in the lines above a method.  The special tokens are all optional.

| token | description |
|-------|-------------|
| @description | one or more lines that provide an overview of the method|
| @param *param name* | a description of what the parameter does|
| @return | a description of the return value from the method|
| @example | Example code usage. This will be wrapped in <code> tags to preserve whitespace|
Example
```
    /*******************************************************************************************************
    * @description Returns field describe data
    * @param objectName the name of the object to look up
    * @param fieldName the name of the field to look up
    * @return the describe field result for the given field
    * @example
    * Account a = new Account();
    */
    public static Schema.DescribeFieldResult getFieldDescribe(String objectName, String fieldName) {
```
