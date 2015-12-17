# XMLCompare
XMLCompare is a Java application that compares two XML representations of Java objects as created by XStream (http://x-stream.github.io/).

Initially you have to create the XML files to compare using XStream. You can either do this yourself, or alter the CreateTestXML.java code to import your classes and write instances of them to XML files.

You can compile XMLCompare and run on the command line, or run from eclipse, providing the paths to the two files as two arguments.

The program takes the XML files and looks through them recursively, therefore if the objects being compared contain fields that are also objects, it will compare them in the same manner and so on. The same for Lists of Lists, or Lists of Objects etc. The comparison will work as long as it knows about the objects/classes to compare, so you need to configure it to be able to use at your own project classes to create the necessary objects back out of the XML files.

It outputs to the console the results of the comparison. Either that the two files match, or that they do not match, and where they are different, with a path to the difference in dot notation and the different values, unless it is a List in which case it will display which part of the List(s) could not find any match.


