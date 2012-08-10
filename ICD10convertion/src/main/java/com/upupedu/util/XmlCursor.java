package com.upupedu.util;

public interface XmlCursor {
	public <T> void  open( Class T);
	public void  open();
	public void close();
	public <T> T next(Class T);

}
