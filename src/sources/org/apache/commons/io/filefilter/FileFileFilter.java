package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class FileFileFilter extends AbstractFileFilter implements Serializable {
    public static final IOFileFilter FILE = new FileFileFilter();

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        return file.isFile();
    }
}
