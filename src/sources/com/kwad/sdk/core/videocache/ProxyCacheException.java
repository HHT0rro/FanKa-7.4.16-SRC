package com.kwad.sdk.core.videocache;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ProxyCacheException extends Exception {
    private static final String LIBRARY_VERSION = ". Version: 3.3.59.1";

    public ProxyCacheException(String str) {
        super(str + LIBRARY_VERSION);
    }

    public ProxyCacheException(String str, Throwable th) {
        super(str + LIBRARY_VERSION, th);
    }

    public ProxyCacheException(Throwable th) {
        super("No explanation error. Version: 3.3.59.1", th);
    }
}
