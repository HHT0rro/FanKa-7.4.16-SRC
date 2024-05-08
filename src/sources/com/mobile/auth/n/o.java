package com.mobile.auth.n;

import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class o {
    public static String a() {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis()));
    }
}
