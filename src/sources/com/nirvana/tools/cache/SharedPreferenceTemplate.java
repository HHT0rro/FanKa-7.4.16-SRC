package com.nirvana.tools.cache;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SharedPreferenceTemplate extends RepositoryTemplate {
    private String fileName;
    private String keyName;

    public SharedPreferenceTemplate(int i10, boolean z10, String str, String str2) {
        super(i10, z10);
        this.fileName = str;
        this.keyName = str2;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getKeyName() {
        return this.keyName;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setKeyName(String str) {
        this.keyName = str;
    }
}
