package com.bef.effectsdk.text;

import android.graphics.Typeface;
import java.io.File;
import java.util.Hashtable;
import java.util.LinkedList;

/* compiled from: FontCache.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static Hashtable<String, Typeface> f10523a = new Hashtable<>();

    /* renamed from: b, reason: collision with root package name */
    public static LinkedList<String> f10524b = new LinkedList<>();

    public static synchronized Typeface a(String str, String str2) {
        Typeface typeface;
        synchronized (a.class) {
            String str3 = "FILE_" + str + "_" + str2;
            typeface = f10523a.get(str3);
            if (typeface == null) {
                try {
                    typeface = Typeface.createFromFile(new File(str, str2));
                    if (f10524b.size() >= 32) {
                        f10523a.remove(f10524b.removeLast());
                        System.gc();
                    }
                    f10523a.put(str3, typeface);
                    f10524b.addFirst(str3);
                } catch (Exception unused) {
                    return null;
                }
            } else {
                f10524b.remove(str3);
                f10524b.addFirst(str3);
            }
        }
        return typeface;
    }

    public static synchronized Typeface b(String str, int i10) {
        Typeface typeface;
        synchronized (a.class) {
            String str2 = "SYSTEM_" + str + "_" + i10;
            typeface = f10523a.get(str2);
            if (typeface == null) {
                try {
                    typeface = Typeface.create(str, i10);
                    if (f10524b.size() >= 32) {
                        f10523a.remove(f10524b.removeLast());
                        System.gc();
                    }
                    f10523a.put(str2, typeface);
                    f10524b.addFirst(str2);
                } catch (Exception unused) {
                    return null;
                }
            } else {
                f10524b.remove(str2);
                f10524b.addFirst(str2);
            }
        }
        return typeface;
    }
}
