package com.alimm.tanx.core.utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class Encrypto implements NotConfused {
    static {
        System.loadLibrary("encrypto");
    }

    public static native String encrypt();
}
