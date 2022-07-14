package validateserviceimpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Pattern;

import excep.CurlyBraceNotMatchedException;
import excep.FileNameNotMatchedException;
import excep.KeywordCheckException;
import validateservice.service;

public class serviceimpl implements service {

	@Override
	public void fileread(File f,String str, HashSet<String> hs) throws FileNotFoundException, IOException, CurlyBraceNotMatchedException, FileNameNotMatchedException, KeywordCheckException {
		BufferedReader br =new BufferedReader(new FileReader(f));
		BufferedReader br1 =new BufferedReader(new FileReader(f));
    	String s;
    	String temp[];String fname=f.getName();
    	boolean cb=false;
    	boolean fm=false;
    	boolean kw1=true;
    	boolean kw2=true;
   int countopenbrace=0; int countclosebrace=0;
    	while((s=br.readLine())!=null) {
    			temp = s.split(" ");
    				for(int i=0;i<temp.length;i++) {
    					if(temp[i].equals("{"))
    						countopenbrace++;
    					if(temp[i].equals("}"))
    						countclosebrace++;
    					if(temp[i].equals("String") ) {	
    						if(hs.contains(temp[i+1])) {
    							kw2=false;
    						throw new KeywordCheckException("Arguments name for main should not be keyword ");
    						}
    					}
    					if(temp[i].equals("class"))
    					{
    						if(hs.contains(temp[i+1])) {
    							kw1=false;
    							throw new KeywordCheckException("Class name should not be keyword ");
    						}
    						if(temp[i+1].equals(fname.substring(0,fname.length()-5 )))
    						{
    							
    							fm=true;
    						}
    						else
    							throw new FileNameNotMatchedException("Filename and class name not matched");
    					}				
    				}
    	}
    	
    	if(countopenbrace==countclosebrace) {
    		
    		cb=true;
    	}
    	else {
    		throw new CurlyBraceNotMatchedException("->Curly braces not matched");
    	}
   
		if(cb && fm && kw1 && kw2) {
			System.out.println("->Filename and classname matched");
			System.out.println("->curly braces matched");
			System.out.println("->Keyword Check Done");
			System.out.println("");
		while((s=br1.readLine())!=null) {
			System.out.println(s); 
			
		}	
		fiwrite(str);
		}
		br.close();
		br1.close();
		}
	
    @Override
  	public void filewrite(String str) throws IOException {
  		BufferedWriter fw = new BufferedWriter(new FileWriter("C:\\Users\\adiddi\\Desktop\\program.java"));
  		fw.write(str);
  		fw.close();
  	}
    
    public void fiwrite(String str) throws IOException {
  		BufferedWriter fw1 = new BufferedWriter(new FileWriter("C:\\Users\\adiddi\\Desktop\\program1.java"));
  		fw1.write(str);
  		fw1.close();
  		System.out.println("");
  		System.out.println("->Program copied to another file");
  	}


}
