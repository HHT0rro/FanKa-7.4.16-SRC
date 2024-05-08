package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import m4.d;
import o4.c;
import o4.f;
import o4.k;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class CctBackendFactory implements c {
    @Override // o4.c
    public k create(f fVar) {
        return new d(fVar.b(), fVar.e(), fVar.d());
    }
}
