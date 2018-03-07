package File24;

import java.io.File;
import java.io.FilenameFilter;

public class Suffixfilter implements FilenameFilter {
private String suffix;//alt+shift+s  构造构造方法

	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return name.endsWith(suffix) ;
	}

	public Suffixfilter(String suffix) {
		super();
		this.suffix = suffix;
	}

}
