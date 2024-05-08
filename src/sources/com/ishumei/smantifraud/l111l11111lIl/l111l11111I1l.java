package com.ishumei.smantifraud.l111l11111lIl;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l111l11111I1l {
    private static final String l1111l111111Il = "seq";
    private static l111l11111I1l l111l11111lIl;
    private int l111l11111I1l = 0;
    private SharedPreferences l111l11111Il;

    private l111l11111I1l() {
        Context l1111l111111Il2 = l111l1111l1Il.l1111l111111Il();
        if (l1111l111111Il2 != null) {
            this.l111l11111Il = l1111l111111Il2.getSharedPreferences(l1111l111111Il, 0);
        }
    }

    public static synchronized l111l11111I1l l1111l111111Il() {
        l111l11111I1l l111l11111i1l;
        synchronized (l111l11111I1l.class) {
            if (l111l11111lIl == null) {
                l111l11111lIl = new l111l11111I1l();
            }
            l111l11111i1l = l111l11111lIl;
        }
        return l111l11111i1l;
    }

    private String l111l11111I1l() {
        try {
            SharedPreferences sharedPreferences = this.l111l11111Il;
            if (sharedPreferences == null) {
                return null;
            }
            return sharedPreferences.getString(l1111l111111Il, null);
        } catch (Exception unused) {
            return null;
        }
    }

    private void l111l11111lIl(String str) {
        try {
            SharedPreferences sharedPreferences = this.l111l11111Il;
            if (sharedPreferences == null) {
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(l1111l111111Il, str);
            edit.apply();
        } catch (Exception unused) {
        }
    }

    public final int l1111l111111Il(String str) {
        SharedPreferences sharedPreferences = this.l111l11111Il;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getInt(str, 0);
    }

    public final void l1111l111111Il(String str, int i10) {
        SharedPreferences sharedPreferences = this.l111l11111Il;
        if (sharedPreferences == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt(str, i10);
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    public final synchronized String l111l11111lIl() {
        StringBuilder sb2;
        if (this.l111l11111I1l == 0) {
            String l111l11111I1l = l111l11111I1l();
            if (!com.ishumei.smantifraud.l111l1111llIl.l111l11111Il.l1111l111111Il(l111l11111I1l)) {
                try {
                    this.l111l11111I1l = Integer.parseInt(l111l11111I1l);
                } catch (Exception unused) {
                }
            }
        }
        this.l111l11111I1l++;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this.l111l11111I1l);
        String sb4 = sb3.toString();
        try {
            SharedPreferences sharedPreferences = this.l111l11111Il;
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(l1111l111111Il, sb4);
                edit.apply();
            }
        } catch (Exception unused2) {
        }
        sb2 = new StringBuilder();
        sb2.append(this.l111l11111I1l);
        return sb2.toString();
    }
}
