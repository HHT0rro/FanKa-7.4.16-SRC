package com.nirvana.tools.cache;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class RepositoryTemplate {
    private int cacheVersion;
    private boolean needEncrypt;

    public RepositoryTemplate(int i10, boolean z10) {
        this.cacheVersion = i10;
        this.needEncrypt = z10;
    }

    public int getCacheVersion() {
        return this.cacheVersion;
    }

    public boolean isNeedEncrypt() {
        return this.needEncrypt;
    }

    public void setCacheVersion(int i10) {
        this.cacheVersion = i10;
    }

    public void setNeedEncrypt(boolean z10) {
        this.needEncrypt = z10;
    }
}
