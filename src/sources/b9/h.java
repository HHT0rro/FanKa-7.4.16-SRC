package b9;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class h implements a9.b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1445a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1446b;

    /* renamed from: c, reason: collision with root package name */
    public a9.d f1447c;

    public h(Context context, String str) {
        this.f1445a = context;
        this.f1446b = str;
    }

    public a9.d a() {
        return new g(new e(m.b(this.f1445a, this.f1446b, "agc_", "/AD91D45E3E72DB6989DDCB13287E75061FABCB933D886E6C6ABEF0939B577138"), m.b(this.f1445a, this.f1446b, "agc_", "/B314B3BF013DF5AC4134E880AF3D2B7C9FFBE8F0305EAC1C898145E2BCF1F21C"), m.b(this.f1445a, this.f1446b, "agc_", "/C767BD8FDF53E53D059BE95B09E2A71056F5F180AECC62836B287ACA5793421B"), m.b(this.f1445a, this.f1446b, "agc_", "/DCB3E6D4C2CF80F30D89CDBC412C964DA8381BB84668769391FBCC3E329AD0FD"), "PBKDF2WithHmacSHA1", 5000));
    }

    @Override // a9.b
    public String decrypt(String str, String str2) {
        if (this.f1447c == null) {
            this.f1447c = a();
        }
        return this.f1447c.decrypt(m.b(this.f1445a, this.f1446b, "agc_", str), str2);
    }
}
