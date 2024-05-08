package com.facebook.soloader;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class SoSource {
    public static final int LOAD_FLAG_ALLOW_IMPLICIT_PROVISION = 1;
    public static final int LOAD_FLAG_MIN_CUSTOM_FLAG = 2;
    public static final int LOAD_RESULT_IMPLICITLY_PROVIDED = 2;
    public static final int LOAD_RESULT_LOADED = 1;
    public static final int LOAD_RESULT_NOT_FOUND = 0;
    public static final int PREPARE_FLAG_ALLOW_ASYNC_INIT = 1;

    public void addToLdLibraryPath(Collection<String> collection) {
    }

    public String[] getSoSourceAbis() {
        return SysUtil.getSupportedAbis();
    }

    public abstract int loadLibrary(String str, int i10) throws IOException;

    public void prepare(int i10) throws IOException {
    }

    public abstract File unpackLibrary(String str) throws IOException;
}
