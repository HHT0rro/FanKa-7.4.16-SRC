package com.ishumei.smantifraud.l111l11111lIl.l1111l111111Il;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
abstract class l111l11111lIl extends l1111l111111Il {
    private static SharedPreferences l111l11111I1l(String str) {
        Context context = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il;
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(str, 0);
    }

    @Override // com.ishumei.smantifraud.l111l11111lIl.l1111l111111Il.l1111l111111Il
    public String l1111l111111Il() {
        SharedPreferences l111l11111I1l;
        try {
            String l111l11111I1l2 = l111l11111I1l();
            String l111l11111Il = l111l11111Il();
            if (TextUtils.isEmpty(l111l11111I1l2) || TextUtils.isEmpty(l111l11111Il) || (l111l11111I1l = l111l11111I1l(l111l11111I1l2)) == null) {
                return null;
            }
            return l111l11111I1l.getString(l111l11111Il, "");
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.ishumei.smantifraud.l111l11111lIl.l1111l111111Il.l1111l111111Il
    public void l1111l111111Il(String str) {
        SharedPreferences l111l11111I1l;
        try {
            String l111l11111I1l2 = l111l11111I1l();
            String l111l11111Il = l111l11111Il();
            if (TextUtils.isEmpty(l111l11111I1l2) || TextUtils.isEmpty(l111l11111Il) || (l111l11111I1l = l111l11111I1l(l111l11111I1l2)) == null) {
                return;
            }
            SharedPreferences.Editor edit = l111l11111I1l.edit();
            edit.putString(l111l11111Il, str);
            edit.apply();
        } catch (Exception unused) {
        }
    }

    public abstract String l111l11111I1l();

    public abstract String l111l11111Il();
}
