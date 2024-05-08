package com.ishumei.smantifraud.l1111l111111Il;

import android.content.SharedPreferences;
import com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111lIIl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
final class l111l1111llIl implements l11l1111lIIl.l111l11111lIl<com.ishumei.smantifraud.l111l11111Il.l111l11111lIl> {
    private /* synthetic */ l111l1111l1Il l1111l111111Il;

    private l111l1111llIl(l111l1111l1Il l111l1111l1il) {
        this.l1111l111111Il = l111l1111l1il;
    }

    /* renamed from: l1111l111111Il, reason: avoid collision after fix types in other method */
    public final void l1111l111111Il2(com.ishumei.smantifraud.l111l11111Il.l111l11111lIl l111l11111lil) {
        l111l11111Il l111l11111I1l;
        if (l111l11111lil.l1111l111111Il() == null) {
            return;
        }
        String jSONObject = l111l11111lil.l1111l111111Il().toString();
        l111l1111l1Il l111l1111l1il = this.l1111l111111Il;
        l111l11111I1l = l111l1111l1Il.l111l11111I1l(jSONObject);
        l111l1111l1il.l111l11111Il = l111l11111I1l;
        SharedPreferences.Editor edit = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il().getSharedPreferences("cloudms.conf", 0).edit();
        edit.putString("conf", jSONObject);
        edit.apply();
    }

    @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111lIIl.l111l11111lIl
    public final /* synthetic */ void l1111l111111Il(com.ishumei.smantifraud.l111l11111Il.l111l11111lIl l111l11111lil) {
        l111l11111Il l111l11111I1l;
        com.ishumei.smantifraud.l111l11111Il.l111l11111lIl l111l11111lil2 = l111l11111lil;
        if (l111l11111lil2.l1111l111111Il() != null) {
            String jSONObject = l111l11111lil2.l1111l111111Il().toString();
            l111l1111l1Il l111l1111l1il = this.l1111l111111Il;
            l111l11111I1l = l111l1111l1Il.l111l11111I1l(jSONObject);
            l111l1111l1il.l111l11111Il = l111l11111I1l;
            SharedPreferences.Editor edit = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il().getSharedPreferences("cloudms.conf", 0).edit();
            edit.putString("conf", jSONObject);
            edit.apply();
        }
    }
}
