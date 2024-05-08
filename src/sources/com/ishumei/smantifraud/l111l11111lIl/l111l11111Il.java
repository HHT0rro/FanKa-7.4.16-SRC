package com.ishumei.smantifraud.l111l11111lIl;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l111l11111Il {
    private static final String l1111l111111Il = "fc_times";
    private static final int l111l11111I1l = 2880;
    private static final String l111l11111Il = "ttl";
    private static final String l111l11111lIl = "l";
    private static final int l111l1111l1Il = 100;
    private static final String l111l1111lI1l = "t";
    private static l111l11111Il l111l1111lIl = null;
    private static final String l111l1111llIl = "cnt";
    private SharedPreferences.Editor l11l1111I11l;
    private List<String> l11l1111I1l = null;
    private SharedPreferences l11l1111lIIl;

    private l111l11111Il() {
        try {
            Context l1111l111111Il2 = l111l1111l1Il.l1111l111111Il();
            if (l1111l111111Il2 != null) {
                SharedPreferences sharedPreferences = l1111l111111Il2.getSharedPreferences(l1111l111111Il, 0);
                this.l11l1111lIIl = sharedPreferences;
                this.l11l1111I11l = sharedPreferences.edit();
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized l111l11111Il l1111l111111Il() {
        l111l11111Il l111l11111il;
        synchronized (l111l11111Il.class) {
            if (l111l1111lIl == null) {
                l111l1111lIl = new l111l11111Il();
            }
            l111l11111il = l111l1111lIl;
        }
        return l111l11111il;
    }

    private void l111l11111Il() {
        HashSet hashSet = new HashSet(this.l11l1111lIIl.getStringSet(l111l1111lI1l, new HashSet()));
        hashSet.add(String.valueOf(System.currentTimeMillis()));
        this.l11l1111I11l.putStringSet(l111l1111lI1l, hashSet);
        this.l11l1111I11l.apply();
    }

    private void l111l1111l1Il() {
        this.l11l1111I1l = new ArrayList(this.l11l1111lIIl.getStringSet(l111l1111lI1l, new HashSet()));
        this.l11l1111I11l.putLong("l", System.currentTimeMillis());
        this.l11l1111I11l.putStringSet(l111l1111lI1l, new HashSet());
        this.l11l1111I11l.apply();
    }

    public final synchronized void l1111l111111Il(int i10, int i11) {
        SharedPreferences.Editor editor = this.l11l1111I11l;
        if (editor != null) {
            if (i10 > 0) {
                editor.putInt("ttl", i10);
            }
            if (i11 > 0) {
                this.l11l1111I11l.putInt(l111l1111llIl, i11);
            }
            this.l11l1111I11l.apply();
        }
    }

    public final synchronized List<String> l111l11111I1l() {
        ArrayList arrayList = new ArrayList();
        List<String> list = this.l11l1111I1l;
        if (list == null) {
            return arrayList;
        }
        arrayList.addAll(list);
        this.l11l1111I1l = null;
        return arrayList;
    }

    public final synchronized boolean l111l11111lIl() {
        try {
            try {
                SharedPreferences sharedPreferences = this.l11l1111lIIl;
                if (sharedPreferences != null && this.l11l1111I11l != null) {
                    int min = Math.min(sharedPreferences.getInt("ttl", 0), l111l11111I1l);
                    if (min == 0) {
                        l111l1111l1Il();
                        return true;
                    }
                    if (min * 60000 < Math.abs(System.currentTimeMillis() - this.l11l1111lIIl.getLong("l", 0L))) {
                        l111l1111l1Il();
                        return true;
                    }
                    if (this.l11l1111lIIl.getStringSet(l111l1111lI1l, new HashSet()).size() >= Math.min(this.l11l1111lIIl.getInt(l111l1111llIl, 0), 100)) {
                        l111l1111l1Il();
                        return true;
                    }
                    HashSet hashSet = new HashSet(this.l11l1111lIIl.getStringSet(l111l1111lI1l, new HashSet()));
                    hashSet.add(String.valueOf(System.currentTimeMillis()));
                    this.l11l1111I11l.putStringSet(l111l1111lI1l, hashSet);
                    this.l11l1111I11l.apply();
                    return false;
                }
                return true;
            } catch (Throwable unused) {
                return true;
            }
        } catch (Throwable unused2) {
            l111l1111l1Il();
            return true;
        }
    }
}
