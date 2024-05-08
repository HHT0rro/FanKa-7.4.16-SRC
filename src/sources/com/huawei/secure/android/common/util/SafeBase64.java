package com.huawei.secure.android.common.util;

import android.util.Base64;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SafeBase64 {
    public static byte[] decode(byte[] bArr, int i10) {
        try {
            return Base64.decode(bArr, i10);
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(e2.getClass().getSimpleName());
            sb2.append(" , message0 : ");
            sb2.append(e2.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encode(byte[] bArr, int i10) {
        try {
            return Base64.encode(bArr, i10);
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(e2.getClass().getSimpleName());
            sb2.append(" , message3 : ");
            sb2.append(e2.getMessage());
            return new byte[0];
        }
    }

    public static String encodeToString(byte[] bArr, int i10) {
        try {
            return Base64.encodeToString(bArr, i10);
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(e2.getClass().getSimpleName());
            sb2.append(" , message5 : ");
            sb2.append(e2.getMessage());
            return "";
        }
    }

    public static byte[] decode(byte[] bArr, int i10, int i11, int i12) {
        try {
            return Base64.decode(bArr, i10, i11, i12);
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(e2.getClass().getSimpleName());
            sb2.append(" , message1 : ");
            sb2.append(e2.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encode(byte[] bArr, int i10, int i11, int i12) {
        try {
            return Base64.encode(bArr, i10, i11, i12);
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(e2.getClass().getSimpleName());
            sb2.append(" , message4 : ");
            sb2.append(e2.getMessage());
            return new byte[0];
        }
    }

    public static String encodeToString(byte[] bArr, int i10, int i11, int i12) {
        try {
            return Base64.encodeToString(bArr, i10, i11, i12);
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(e2.getClass().getSimpleName());
            sb2.append(" , message6 : ");
            sb2.append(e2.getMessage());
            return "";
        }
    }

    public static byte[] decode(String str, int i10) {
        try {
            return Base64.decode(str, i10);
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(e2.getClass().getSimpleName());
            sb2.append(" , message2 : ");
            sb2.append(e2.getMessage());
            return new byte[0];
        }
    }
}
