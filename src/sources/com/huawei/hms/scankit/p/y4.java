package com.huawei.hms.scankit.p;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: MsModel.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class y4 {

    /* renamed from: a, reason: collision with root package name */
    private static byte[] f31761a;

    /* renamed from: b, reason: collision with root package name */
    private static byte[] f31762b;

    /* renamed from: c, reason: collision with root package name */
    private static byte[] f31763c;

    public static byte[] a() {
        return f31762b;
    }

    public static byte[] b() {
        return f31763c;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0064 -> B:10:0x0067). Please report as a decompilation issue!!! */
    public static void c(Context context, String str) {
        o4.d("MsModel", "load model...." + str);
        if (f31761a != null) {
            return;
        }
        InputStream inputStream = null;
        try {
            try {
                try {
                    inputStream = context.getAssets().open(str);
                    o4.d("MsModel", "inputStream" + ((Object) inputStream));
                    byte[] bArr = new byte[inputStream.available()];
                    inputStream.read(bArr);
                    inputStream.close();
                    f31761a = bArr;
                    inputStream.close();
                } catch (IOException unused) {
                    o4.b("MsModel", "loadModel IOException");
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Exception unused2) {
                    o4.b("MsModel", "loadModel Exception");
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            } catch (IOException unused3) {
                o4.b("MsModel", "loadModel inputStream.close() IOException");
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                    o4.b("MsModel", "loadModel inputStream.close() IOException");
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0064 -> B:10:0x0067). Please report as a decompilation issue!!! */
    public static void a(Context context, String str) {
        o4.d("MsModel", "load angle model...." + str);
        if (f31762b != null) {
            return;
        }
        InputStream inputStream = null;
        try {
            try {
                try {
                    inputStream = context.getAssets().open(str);
                    o4.d("MsModel", "3inputStream" + ((Object) inputStream));
                    byte[] bArr = new byte[inputStream.available()];
                    inputStream.read(bArr);
                    inputStream.close();
                    f31762b = bArr;
                    inputStream.close();
                } catch (IOException unused) {
                    o4.b("MsModel", "loadAngleModel IOException");
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Exception unused2) {
                    o4.b("MsModel", "loadAngleModel Exception");
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            } catch (IOException unused3) {
                o4.b("MsModel", "loadAngleModel inputStream.close() IOException");
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                    o4.b("MsModel", "loadAngleModel inputStream.close() IOException");
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0064 -> B:10:0x0067). Please report as a decompilation issue!!! */
    public static void b(Context context, String str) {
        o4.d("MsModel", "load corner model...." + str);
        if (f31763c != null) {
            return;
        }
        InputStream inputStream = null;
        try {
            try {
                try {
                    inputStream = context.getAssets().open(str);
                    o4.d("MsModel", "4inputStream" + ((Object) inputStream));
                    byte[] bArr = new byte[inputStream.available()];
                    inputStream.read(bArr);
                    inputStream.close();
                    f31763c = bArr;
                    inputStream.close();
                } catch (IOException unused) {
                    o4.b("MsModel", "loadConerModel IOException");
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Exception unused2) {
                    o4.b("MsModel", "loadConerModel Exception");
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            } catch (IOException unused3) {
                o4.b("MsModel", "loadConerModel inputStream.close() IOException");
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                    o4.b("MsModel", "loadConerModel inputStream.close() IOException");
                }
            }
            throw th;
        }
    }

    public static byte[] c() {
        return f31761a;
    }
}
