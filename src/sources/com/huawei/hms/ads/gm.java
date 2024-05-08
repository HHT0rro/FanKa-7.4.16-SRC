package com.huawei.hms.ads;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class gm {
    private static final String Code = "HiAdSDKLog";
    private static final int I = 10;
    private static final String V = "HiAdSDK.";
    private static gq Z = gr.Code();
    private String C;
    private int B = 4;
    private boolean S = false;

    private gs I(int i10, String str, String str2) {
        gs gsVar = new gs(this.C, i10, str);
        gsVar.Code((gs) str2);
        return gsVar;
    }

    public gq Code() {
        return Z;
    }

    public void Code(int i10, String str, String str2) {
        this.B = i10;
        this.C = str2;
        Z.Code(str, Code);
        this.S = true;
    }

    public void Code(int i10, String str, String str2, Throwable th) {
        if (th != null) {
            Code(i10);
        }
    }

    public void Code(int i10, String str, Throwable th) {
        if (th != null) {
            Code(i10);
        }
    }

    public void Code(String str, String str2) {
        Z.Code(I(4, str, str2), 4, str);
    }

    public boolean Code(int i10) {
        return this.S && i10 >= this.B;
    }

    public void V(int i10, String str, String str2) {
        if (Code(i10)) {
            String str3 = V + str;
            Z.Code(I(i10, str3, str2), i10, str3);
        }
    }
}
