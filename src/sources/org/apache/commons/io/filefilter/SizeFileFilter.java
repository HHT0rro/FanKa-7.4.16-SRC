package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class SizeFileFilter extends AbstractFileFilter implements Serializable {
    private final boolean acceptLarger;
    private final long size;

    public SizeFileFilter(long j10) {
        this(j10, true);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        boolean z10 = file.length() < this.size;
        return this.acceptLarger ? !z10 : z10;
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter
    public String toString() {
        return super.toString() + "(" + (this.acceptLarger ? ">=" : "<") + this.size + ")";
    }

    public SizeFileFilter(long j10, boolean z10) {
        if (j10 >= 0) {
            this.size = j10;
            this.acceptLarger = z10;
            return;
        }
        throw new IllegalArgumentException("The size must be non-negative");
    }
}
