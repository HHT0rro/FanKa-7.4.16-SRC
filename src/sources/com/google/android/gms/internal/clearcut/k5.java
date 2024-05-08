package com.google.android.gms.internal.clearcut;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class k5 {

    /* renamed from: f, reason: collision with root package name */
    public static HashMap<String, String> f23938f;

    /* renamed from: k, reason: collision with root package name */
    public static Object f23943k;

    /* renamed from: l, reason: collision with root package name */
    public static boolean f23944l;

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f23933a = Uri.parse("content://com.google.android.gsf.gservices");

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f23934b = Uri.parse("content://com.google.android.gsf.gservices/prefix");

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f23935c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f23936d = Pattern.compile("^(0|false|f|off|no|n)$", 2);

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicBoolean f23937e = new AtomicBoolean();

    /* renamed from: g, reason: collision with root package name */
    public static final HashMap<String, Boolean> f23939g = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    public static final HashMap<String, Integer> f23940h = new HashMap<>();

    /* renamed from: i, reason: collision with root package name */
    public static final HashMap<String, Long> f23941i = new HashMap<>();

    /* renamed from: j, reason: collision with root package name */
    public static final HashMap<String, Float> f23942j = new HashMap<>();

    /* renamed from: m, reason: collision with root package name */
    public static String[] f23945m = new String[0];

    public static long a(ContentResolver contentResolver, String str, long j10) {
        Object i10 = i(contentResolver);
        long j11 = 0;
        Long l10 = (Long) b(f23941i, str, 0L);
        if (l10 != null) {
            return l10.longValue();
        }
        String c4 = c(contentResolver, str, null);
        if (c4 != null) {
            try {
                long parseLong = Long.parseLong(c4);
                l10 = Long.valueOf(parseLong);
                j11 = parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        g(i10, f23941i, str, l10);
        return j11;
    }

    public static <T> T b(HashMap<String, T> hashMap, String str, T t2) {
        synchronized (k5.class) {
            if (!hashMap.containsKey(str)) {
                return null;
            }
            T t10 = hashMap.get(str);
            if (t10 != null) {
                t2 = t10;
            }
            return t2;
        }
    }

    public static String c(ContentResolver contentResolver, String str, String str2) {
        synchronized (k5.class) {
            e(contentResolver);
            Object obj = f23943k;
            if (f23938f.containsKey(str)) {
                String str3 = f23938f.get(str);
                return str3 != null ? str3 : null;
            }
            for (String str4 : f23945m) {
                if (str.startsWith(str4)) {
                    if (!f23944l || f23938f.isEmpty()) {
                        f23938f.putAll(d(contentResolver, f23945m));
                        f23944l = true;
                        if (f23938f.containsKey(str)) {
                            String str5 = f23938f.get(str);
                            return str5 != null ? str5 : null;
                        }
                    }
                    return null;
                }
            }
            Cursor query = contentResolver.query(f23933a, null, null, new String[]{str}, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(1);
                        if (string != null && string.equals(null)) {
                            string = null;
                        }
                        f(obj, str, string);
                        String str6 = string != null ? string : null;
                        query.close();
                        return str6;
                    }
                } finally {
                    if (query != null) {
                        query.close();
                    }
                }
            }
            f(obj, str, null);
            return null;
        }
    }

    public static Map<String, String> d(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(f23934b, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }

    public static void e(ContentResolver contentResolver) {
        if (f23938f == null) {
            f23937e.set(false);
            f23938f = new HashMap<>();
            f23943k = new Object();
            f23944l = false;
            contentResolver.registerContentObserver(f23933a, true, new l5(null));
            return;
        }
        if (f23937e.getAndSet(false)) {
            f23938f.clear();
            f23939g.clear();
            f23940h.clear();
            f23941i.clear();
            f23942j.clear();
            f23943k = new Object();
            f23944l = false;
        }
    }

    public static void f(Object obj, String str, String str2) {
        synchronized (k5.class) {
            if (obj == f23943k) {
                f23938f.put(str, str2);
            }
        }
    }

    public static <T> void g(Object obj, HashMap<String, T> hashMap, String str, T t2) {
        synchronized (k5.class) {
            if (obj == f23943k) {
                hashMap.put(str, t2);
                f23938f.remove(str);
            }
        }
    }

    public static boolean h(ContentResolver contentResolver, String str, boolean z10) {
        Object i10 = i(contentResolver);
        HashMap<String, Boolean> hashMap = f23939g;
        Boolean bool = (Boolean) b(hashMap, str, Boolean.valueOf(z10));
        if (bool != null) {
            return bool.booleanValue();
        }
        String c4 = c(contentResolver, str, null);
        if (c4 != null && !c4.equals("")) {
            if (f23935c.matcher(c4).matches()) {
                z10 = true;
                bool = Boolean.TRUE;
            } else if (f23936d.matcher(c4).matches()) {
                z10 = false;
                bool = Boolean.FALSE;
            } else {
                StringBuilder sb2 = new StringBuilder("attempt to read gservices key ");
                sb2.append(str);
                sb2.append(" (value \"");
                sb2.append(c4);
                sb2.append("\") as boolean");
            }
        }
        g(i10, hashMap, str, bool);
        return z10;
    }

    public static Object i(ContentResolver contentResolver) {
        Object obj;
        synchronized (k5.class) {
            e(contentResolver);
            obj = f23943k;
        }
        return obj;
    }
}
