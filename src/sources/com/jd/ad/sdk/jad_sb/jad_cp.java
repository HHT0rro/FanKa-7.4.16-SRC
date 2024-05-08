package com.jd.ad.sdk.jad_sb;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum jad_cp {
    JSON(".json"),
    ZIP(".zip");

    public final String jad_an;

    jad_cp(String str) {
        this.jad_an = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.jad_an;
    }
}
