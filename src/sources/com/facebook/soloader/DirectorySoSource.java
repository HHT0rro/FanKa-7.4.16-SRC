package com.facebook.soloader;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class DirectorySoSource extends SoSource {
    public static final int ON_LD_LIBRARY_PATH = 2;
    public static final int RESOLVE_DEPENDENCIES = 1;
    public final int flags;
    public final File soDirectory;

    public DirectorySoSource(File file, int i10) {
        this.soDirectory = file;
        this.flags = i10;
    }

    private static String[] getDependencies(File file) throws IOException {
        boolean z10 = SoLoader.SYSTRACE_LIBRARY_LOADING;
        if (z10) {
            Api18TraceUtils.beginTraceSection("SoLoader.getElfDependencies[" + file.getName() + "]");
        }
        try {
            String[] extract_DT_NEEDED = MinElf.extract_DT_NEEDED(file);
            if (z10) {
                Api18TraceUtils.endSection();
            }
            return extract_DT_NEEDED;
        } catch (Throwable th) {
            if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
                Api18TraceUtils.endSection();
            }
            throw th;
        }
    }

    @Override // com.facebook.soloader.SoSource
    public void addToLdLibraryPath(Collection<String> collection) {
        collection.add(this.soDirectory.getAbsolutePath());
    }

    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i10) throws IOException {
        return loadLibraryFrom(str, i10, this.soDirectory);
    }

    public int loadLibraryFrom(String str, int i10, File file) throws IOException {
        File file2 = new File(file, str);
        if (!file2.exists()) {
            return 0;
        }
        if ((i10 & 1) != 0 && (this.flags & 2) != 0) {
            return 2;
        }
        if ((this.flags & 1) != 0) {
            for (String str2 : getDependencies(file2)) {
                if (!str2.startsWith("/")) {
                    SoLoader.loadLibraryBySoName(str2, i10 | 1);
                }
            }
        }
        SoLoader.sSoFileLoader.load(file2.getAbsolutePath(), i10);
        return 1;
    }

    @Override // com.facebook.soloader.SoSource
    public File unpackLibrary(String str) throws IOException {
        File file = new File(this.soDirectory, str);
        if (file.exists()) {
            return file;
        }
        return null;
    }
}
