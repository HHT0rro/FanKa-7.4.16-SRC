package com.facebook.soloader;

import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class NativeLibrary {
    private static final String TAG = "com.facebook.soloader.NativeLibrary";
    private List<String> mLibraryNames;
    private final Object mLock = new Object();
    private Boolean mLoadLibraries = Boolean.TRUE;
    private boolean mLibrariesLoaded = false;
    private volatile UnsatisfiedLinkError mLinkError = null;

    public NativeLibrary(List<String> list) {
        this.mLibraryNames = list;
    }

    public void ensureLoaded() throws UnsatisfiedLinkError {
        if (!loadLibraries()) {
            throw this.mLinkError;
        }
    }

    public UnsatisfiedLinkError getError() {
        return this.mLinkError;
    }

    public void initialNativeCheck() throws UnsatisfiedLinkError {
    }

    public boolean loadLibraries() {
        synchronized (this.mLock) {
            if (!this.mLoadLibraries.booleanValue()) {
                return this.mLibrariesLoaded;
            }
            try {
                Iterator<String> iterator2 = this.mLibraryNames.iterator2();
                while (iterator2.hasNext()) {
                    SoLoader.loadLibrary(iterator2.next());
                }
                initialNativeCheck();
                this.mLibrariesLoaded = true;
                this.mLibraryNames = null;
            } catch (UnsatisfiedLinkError e2) {
                this.mLinkError = e2;
                this.mLibrariesLoaded = false;
            }
            this.mLoadLibraries = Boolean.FALSE;
            return this.mLibrariesLoaded;
        }
    }
}
