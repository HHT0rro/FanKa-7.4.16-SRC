package com.jd.ad.sdk.jad_cp;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_an implements FileFilter {
    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return Pattern.matches("cpu[0-9]+", file.getName());
    }
}
