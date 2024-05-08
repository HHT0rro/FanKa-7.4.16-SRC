package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BaseSharePreference.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public Context f46413a;

    /* renamed from: b, reason: collision with root package name */
    private String f46414b;

    /* renamed from: c, reason: collision with root package name */
    private volatile SharedPreferences f46415c;

    /* renamed from: d, reason: collision with root package name */
    private HashMap<String, String> f46416d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, Long> f46417e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private HashMap<String, Integer> f46418f = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private HashMap<String, Boolean> f46419g = new HashMap<>();

    public final void a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f46414b = str;
            this.f46415c = context.getSharedPreferences(str, 0);
            this.f46413a = context;
            List<String> b4 = b("local_iv");
            if (b4 != null && b4.size() >= 4) {
                HashMap hashMap = new HashMap();
                hashMap.put("com.vivo.push.secure_sub_iv", b4.get(1));
                hashMap.put("com.vivo.push.secure_sub_key", b4.get(2));
                hashMap.put("com.vivo.push.secure_cache_iv", b4.get(3));
                hashMap.put("com.vivo.push.secure_cache_key", b4.get(0));
                a(hashMap);
                return;
            }
            u.a("BaseSharePreference", " initSecureCode error list is null ");
            return;
        }
        throw new RuntimeException("sharedFileName can't be null");
    }

    public final String b(String str, String str2) {
        String str3 = this.f46416d.get(str);
        if (str3 != null) {
            return str3;
        }
        b();
        if (this.f46415c != null) {
            str3 = this.f46415c.getString(str, str2);
            if (!TextUtils.isEmpty(str3) && !str3.equals(str2)) {
                this.f46416d.put(str, str3);
            }
        }
        return str3;
    }

    public final int b(String str, int i10) {
        Integer num = this.f46418f.get(str);
        if (num != null) {
            return num.intValue();
        }
        b();
        if (this.f46415c != null) {
            num = Integer.valueOf(this.f46415c.getInt(str, i10));
            if (!num.equals(Integer.valueOf(i10))) {
                this.f46418f.put(str, num);
            }
        }
        return num.intValue();
    }

    public final void a(String str, String str2) {
        this.f46416d.put(str, str2);
        b();
        if (this.f46415c != null) {
            SharedPreferences.Editor edit = this.f46415c.edit();
            edit.putString(str, str2);
            a(edit);
        }
    }

    public final long b(String str, long j10) {
        Long l10 = this.f46417e.get(str);
        if (l10 != null) {
            return l10.longValue();
        }
        b();
        if (this.f46415c != null) {
            l10 = Long.valueOf(this.f46415c.getLong(str, j10));
            if (!l10.equals(Long.valueOf(j10))) {
                this.f46417e.put(str, l10);
            }
        }
        return l10.longValue();
    }

    private void a(Map<String, String> map) {
        if (map.size() > 0) {
            b();
            if (this.f46415c != null) {
                SharedPreferences.Editor edit = this.f46415c.edit();
                for (String str : map.h()) {
                    String str2 = map.get(str);
                    this.f46416d.put(str, str2);
                    edit.putString(str, str2);
                }
                a(edit);
            }
        }
    }

    private synchronized void b() {
        if (this.f46415c == null) {
            Context context = this.f46413a;
            if (context != null) {
                this.f46415c = context.getSharedPreferences(this.f46414b, 0);
            } else {
                throw new RuntimeException("SharedPreferences is not init", new Throwable());
            }
        }
    }

    private List<String> b(String str) {
        Object a10;
        String[] split;
        if (this.f46413a == null) {
            u.c("BaseSharePreference", " parsLocalIv error mContext is null ");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            Context context = this.f46413a;
            a10 = ag.a(context, context.getPackageName(), str);
        } catch (Exception e2) {
            u.c("BaseSharePreference", " parsLocalIv error e =" + e2.getMessage());
            e2.printStackTrace();
        }
        if (a10 == null) {
            return null;
        }
        String str2 = new String(Base64.decode(a10.toString(), 2));
        if (!TextUtils.isEmpty(str2) && (split = str2.split(",#@")) != null && split.length >= 4) {
            for (String str3 : split) {
                arrayList.add(str3.replace(",#@", ""));
            }
            if (arrayList.size() >= 4) {
                return arrayList;
            }
        }
        return null;
    }

    public final void a(String str, int i10) {
        this.f46418f.put(str, Integer.valueOf(i10));
        b();
        if (this.f46415c != null) {
            SharedPreferences.Editor edit = this.f46415c.edit();
            edit.putInt(str, i10);
            a(edit);
        }
    }

    public final void a(String str, long j10) {
        this.f46417e.put(str, Long.valueOf(j10));
        b();
        if (this.f46415c != null) {
            SharedPreferences.Editor edit = this.f46415c.edit();
            edit.putLong(str, j10);
            a(edit);
        }
    }

    public final void a(String str) {
        this.f46417e.remove(str);
        this.f46418f.remove(str);
        this.f46419g.remove(str);
        this.f46416d.remove(str);
        b();
        if (this.f46415c != null) {
            SharedPreferences.Editor edit = this.f46415c.edit();
            if (this.f46415c.contains(str)) {
                edit.remove(str);
                a(edit);
            }
        }
    }

    public static void a(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    public final void a() {
        this.f46417e.clear();
        this.f46418f.clear();
        this.f46419g.clear();
        this.f46416d.clear();
        b();
        if (this.f46415c != null) {
            SharedPreferences.Editor edit = this.f46415c.edit();
            edit.clear();
            a(edit);
        }
    }
}
