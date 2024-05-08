package com.hailiang.advlib.open.oaid.hla;

import com.hailiang.advlib.open.oaid.OAIDException;

/* compiled from: DefaultImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a implements com.hailiang.advlib.open.oaid.b {
    @Override // com.hailiang.advlib.open.oaid.b
    public void a(com.hailiang.advlib.open.oaid.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(new OAIDException("Unsupported"));
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public boolean a() {
        return false;
    }
}
