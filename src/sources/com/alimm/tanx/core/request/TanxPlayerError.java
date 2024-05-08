package com.alimm.tanx.core.request;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TanxPlayerError extends TanxError {
    public int extra;
    public int what;

    public TanxPlayerError(String str) {
        super(str);
    }

    @Override // com.alimm.tanx.core.request.TanxError, java.lang.Throwable
    public String toString() {
        return "TanxPlayerError : what->" + this.what + "  extra -> " + this.extra + "  message-> " + getMessage();
    }

    public TanxPlayerError(String str, String str2) {
        super(str, str2);
    }

    public TanxPlayerError(String str, int i10, int i11) {
        this(str);
        this.what = i10;
        this.extra = i11;
    }
}
