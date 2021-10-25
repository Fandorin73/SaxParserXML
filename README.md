Java Developer test assignment
Introduction
You are provided with xml file containing a representation of files hierarchy.
Example:
<node is-file="false">
<name>/</name>
<children>
<child is-file="true">
<name>file-77194797.xmml</name>
</child>
<child is-file="false">
<name>dir-88.971375</name>
<children>
<child is-file="true">
<name>file-9.738721998xaavaa</name>
</child>
<child is-file="false">
<name>dir-219753.7.95</name>
<children>
<child is-file="true">
<name>file-974847.2197xmhtml</name>
</child>
</children>
</child>
</children>
</child>
</children>
</node>
One node may be either file or directory, which is defined by attribute is-filex
What to do?
Implement command-line application which will output all full paths for the given input.
$ java -jar assignment.jar -f <xml_file> -s <input>
where <xml_file> is a path to the provided xml file; <input> is search string to filter paths with.
Examples
No search input:
$ java -jar assignment.jar -f test-files.xml
/file-77194797.xmml
/dir-88.971375/file-9.738721998xaavaa
/dir-88.971375/dir-219753.7.95/file-974847.2197xmhtml

Exact search input:
$ java -jar assignment.jar -f test-files.xml -s file-1498940214.xhtml
/dir-880176375/dir-2145307015/file-1498940214.xhtml

Simple search input:
$ java -jar assignment.jar -f test-files.xml -s ‘*.java’
/dir-88.971375/file-9.738721998xaavaa

Extended search input:
$ java -jar assignment.jar -f test-files.xml -S ‘.*?[a-z]{4}-\\d+\.[a-z]+’
/file-77194797.xmml
/dir-88.971375/file-9.738721998xaavaa
/dir-880176375/dir-2145307015/file-1498940214.xhtml

Compilation and test environment
Prepare Maven project. It is allowed to use any libraries you might find useful; Java SE 8+ or
Kotlin.

Build should run without problems with Maven 3.5.0.