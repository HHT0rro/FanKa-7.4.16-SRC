package com.qq.e.comm.managers.plugin;

import android.text.TextUtils;
import com.qq.e.comm.managers.plugin.c;
import com.qq.e.comm.util.GDTLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final File f38302a;

    /* renamed from: b, reason: collision with root package name */
    private final File f38303b;

    /* renamed from: c, reason: collision with root package name */
    private String f38304c;

    /* renamed from: d, reason: collision with root package name */
    private int f38305d;

    /* renamed from: e, reason: collision with root package name */
    private String f38306e;

    public g(File file, File file2) {
        this.f38302a = file;
        this.f38303b = file2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.BufferedReader] */
    private String a(File file) throws IOException {
        Throwable th;
        ?? r12 = 0;
        if (file != null) {
            try {
                if (file.exists()) {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                        try {
                            StringBuilder sb2 = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb2.append(readLine);
                            }
                            String sb3 = sb2.toString();
                            try {
                                bufferedReader.close();
                            } catch (Exception unused) {
                                GDTLogger.d("Exception while close bufferreader");
                            }
                            return sb3;
                        } catch (IOException e2) {
                            throw e2;
                        }
                    } catch (IOException e10) {
                        throw e10;
                    } catch (Throwable th2) {
                        th = th2;
                        if (r12 != 0) {
                            try {
                                r12.close();
                            } catch (Exception unused2) {
                                GDTLogger.d("Exception while close bufferreader");
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                r12 = file;
                th = th3;
            }
        }
        return null;
    }

    public boolean a() {
        int i10;
        try {
            if (this.f38303b.exists() && this.f38302a.exists()) {
                String a10 = a(this.f38303b);
                this.f38306e = a10;
                if (TextUtils.isEmpty(a10)) {
                    return false;
                }
                String[] split = this.f38306e.split("#####");
                if (split.length == 2) {
                    String str = split[1];
                    try {
                        i10 = Integer.parseInt(split[0]);
                    } catch (Throwable unused) {
                        i10 = 0;
                    }
                    if (c.b.f38300a.a(str, this.f38302a)) {
                        this.f38304c = str;
                        this.f38305d = i10;
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable unused2) {
            GDTLogger.d("Exception while checking plugin");
            return false;
        }
    }

    public boolean a(File file, File file2) {
        return (file.equals(this.f38302a) || h.a(this.f38302a, file)) && (file2.equals(this.f38303b) || h.a(this.f38303b, file2));
    }

    public String b() {
        return this.f38304c;
    }

    public int c() {
        return this.f38305d;
    }

    public String d() {
        return this.f38306e;
    }
}
