package validationmain;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

import validateserviceimpl.serviceimpl;

public class Main {
	public static void main(String args []) throws IOException {
		File f=new File("C:\\Users\\adiddi\\Desktop\\program.java");
		File fi=new File("C:\\Users\\adiddi\\Desktop\\program1.java");
		String str2="";
		f.createNewFile();	
		if(fi.exists()) {
			fi.delete();
			fi.createNewFile();
		}
			else
				fi.createNewFile();
		        String str="""
				public class program {
				public static void main ( String args [ ] ) {
				System.out.println( " Hello World " ) ;
				}
				}
				""";
        HashSet<String> hs=new HashSet<>(); 
        hs.add("public");hs.add("static");hs.add("void");hs.add("main");hs.add("String");hs.add("System");
        hs.add("try");hs.add("catch");hs.add("out");hs.add("float");hs.add("int");hs.add("double");hs.add("char");
        hs.add("new");hs.add("switch");hs.add("default");hs.add("for");hs.add("case");hs.add("while");hs.add("do");
        hs.add("final");hs.add("break");hs.add("boolean");hs.add("import");hs.add("super");hs.add("throw");
        hs.add("throws");hs.add("interface");hs.add("implements");hs.add("finally");hs.add("extends");hs.add("abstract");
        hs.add("continue");hs.add("private");hs.add("protected");hs.add("package");hs.add("const");hs.add("else");
        hs.add("if");hs.add("long");hs.add("goto");hs.add("class");
		
		serviceimpl si =new serviceimpl();
		try {
		si.filewrite(str);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			si.fileread(f,str,hs);
		}catch(Exception q) {
			System.out.println(q.getMessage());
		}
		
		}
	}


