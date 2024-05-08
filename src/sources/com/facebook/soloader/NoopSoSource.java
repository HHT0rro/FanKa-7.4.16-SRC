package com.facebook.soloader;

import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class NoopSoSource extends SoSource {
    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i10) {
        return 1;
    }

    @Override // com.facebook.soloader.SoSource
    public File unpackLibrary(String str) {
        throw new UnsupportedOperationException("unpacking not supported in test mode");
    }
}
