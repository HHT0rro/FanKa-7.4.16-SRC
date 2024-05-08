package com.xiaomi.push;

import java.io.File;
import java.io.FileFilter;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class t7 implements FileFilter {
    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return file.isDirectory();
    }
}
