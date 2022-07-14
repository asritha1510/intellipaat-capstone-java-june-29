package validateservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;

import excep.CurlyBraceNotMatchedException;
import excep.FileNameNotMatchedException;
import excep.KeywordCheckException;

public interface service {
	void filewrite(String str) throws FileNotFoundException, IOException, CurlyBraceNotMatchedException, FileNameNotMatchedException;
	void fileread(File f,String str,HashSet<String> hs) throws IOException, CurlyBraceNotMatchedException, FileNameNotMatchedException, KeywordCheckException;
}
