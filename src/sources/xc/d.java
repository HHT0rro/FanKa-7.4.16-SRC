package xc;

import com.tanx.onlyid.api.OAIDException;

/* compiled from: DefaultImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class d implements wc.d {
    @Override // wc.d
    public void a(wc.c cVar) {
        if (cVar == null) {
            return;
        }
        cVar.oaidError(new OAIDException("Unsupported"));
    }

    @Override // wc.d
    public boolean supported() {
        return false;
    }
}
