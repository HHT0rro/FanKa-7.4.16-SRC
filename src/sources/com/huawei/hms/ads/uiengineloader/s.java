package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    private static final String f29479a = "ads_ModuleCopy";

    /* renamed from: b, reason: collision with root package name */
    private static final int f29480b = 2048;

    /* renamed from: c, reason: collision with root package name */
    private static final String f29481c = "file://";

    private static int a(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            aa.b(f29479a, "No version dirs in module path, need mkdir.");
            return 0;
        }
        int i10 = 0;
        for (String str : strArr) {
            if (Integer.parseInt(str) > i10) {
                i10 = Integer.parseInt(str);
            }
        }
        return i10;
    }

    private static String a(Context context, Bundle bundle, String str, String str2) {
        String string = bundle.getString("module_name");
        String valueOf = String.valueOf(bundle.getInt("module_version"));
        String str3 = string + ".apk";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(y.a(context));
        String str4 = File.separator;
        sb2.append(str4);
        sb2.append("dynamic_modules");
        sb2.append(str4);
        sb2.append(string);
        String sb3 = sb2.toString();
        String str5 = sb3 + str4 + valueOf;
        String str6 = str5 + str4 + str3;
        if (!new File(sb3).exists()) {
            aa.b(f29479a, "checkModulePath file not exists.");
            return a(context, str5, str, str2, str6);
        }
        String[] list = new File(sb3).list();
        int a10 = a(list);
        aa.b(f29479a, "checkModulePath maxVersion:" + a10 + ", version:" + valueOf);
        if (a10 < Integer.parseInt(valueOf)) {
            return a(context, str5, str, str2, str6);
        }
        String str7 = sb3 + str4 + a10 + str4 + str3;
        if (!new File(str7).exists()) {
            return a(context, str5, str, str2, str7);
        }
        r.a(a10, sb3, list, f29479a);
        return str7;
    }

    private static String a(Context context, String str, String str2, String str3, String str4) {
        String str5;
        if (y.a(str)) {
            a(context, str2, str3, str4);
            if (TextUtils.isEmpty(str4) || !new File(str4).exists()) {
                str5 = "ModuleFile filePath doesn't exist, or not accessible.";
            } else {
                if (!x.a(context, str4) || x.a(new File(str4), y.c(str4)) == 0) {
                    return str4;
                }
                str5 = "Extract native to current dir failed.";
            }
        } else {
            str5 = "makeDirectory return false";
        }
        aa.d(f29479a, str5);
        return null;
    }

    private static void a(Context context, String str, String str2, String str3) {
        boolean a10 = a(context, str2, str3);
        aa.b(f29479a, "fromUri result:".concat(String.valueOf(a10)));
        if (a10) {
            return;
        }
        boolean a11 = a(str, str3);
        aa.b(f29479a, "fromPath result:".concat(String.valueOf(a11)));
        if (a11) {
            return;
        }
        aa.b(f29479a, "FromUriWithPrefix result:".concat(String.valueOf(b(context, str, str3))));
    }

    private static boolean a(Context context, Uri uri, String str) {
        BufferedOutputStream bufferedOutputStream;
        InputStream inputStream = null;
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            try {
                if (openInputStream == null) {
                    aa.c(f29479a, "get input stream failed: null.");
                    ae.a(openInputStream);
                    ae.a(null);
                    return false;
                }
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str));
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = openInputStream.read(bArr);
                        if (read == -1) {
                            ae.a(openInputStream);
                            ae.a(bufferedOutputStream2);
                            return true;
                        }
                        bufferedOutputStream2.write(bArr, 0, read);
                    }
                } catch (Throwable th) {
                    inputStream = openInputStream;
                    bufferedOutputStream = bufferedOutputStream2;
                    th = th;
                    try {
                        aa.d(f29479a, "ModuleFromUri exception:" + th.getClass().getSimpleName());
                        return false;
                    } finally {
                        ae.a(inputStream);
                        ae.a(bufferedOutputStream);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = openInputStream;
                bufferedOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
        }
    }

    public static boolean a(Context context, Bundle bundle) {
        if (context != null && bundle != null) {
            return b(context, bundle);
        }
        aa.d(f29479a, "The context or module info bundle is null.");
        return false;
    }

    private static boolean a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            return a(context, Uri.parse(str), str2);
        }
        aa.b(f29479a, "remote uri is null.");
        return false;
    }

    private static boolean a(String str, String str2) {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str));
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = null;
            }
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = bufferedInputStream2.read(bArr);
                    if (read == -1) {
                        ae.a(bufferedInputStream2);
                        ae.a(bufferedOutputStream);
                        return true;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = bufferedInputStream2;
                try {
                    aa.d(f29479a, "ModuleFromPath exception:" + th.getClass().getSimpleName());
                    return false;
                } finally {
                    ae.a(bufferedInputStream);
                    ae.a(bufferedOutputStream);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
        }
    }

    private static boolean b(Context context, Bundle bundle) {
        String a10 = a(context, bundle, bundle.getString("module_path"), bundle.getString("module_uri_path"));
        if (TextUtils.isEmpty(a10)) {
            aa.c(f29479a, "check Module Path failed: null.");
            return false;
        }
        bundle.putString("module_path", a10);
        return true;
    }

    private static boolean b(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            aa.b(f29479a, "remote path is null.");
            return false;
        }
        if (!str.startsWith(f29481c)) {
            str = f29481c.concat(str);
        }
        return a(context, Uri.parse(str), str2);
    }
}
