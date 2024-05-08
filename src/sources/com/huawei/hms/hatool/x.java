package com.huawei.hms.hatool;

import java.io.File;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private String f30242a = q0.i().getFilesDir().getPath();

    private String a(String str) {
        return this.f30242a + "/hms/component/".replace("component", str);
    }

    private void a(String str, String str2) {
        File file = new File(a(str));
        File file2 = new File(a(str), "hianalytics_" + str);
        if (!file.exists() && file.mkdirs()) {
            v.c("hmsSdk", "file directory is mkdirs");
        }
        if (a(file2)) {
            k1.a(file2, str2);
        } else {
            v.f("hmsSdk", "refreshComponent():file is not found,and file is create failed");
        }
    }

    private boolean a(File file) {
        if (file.exists()) {
            return true;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            v.f("hmsSdk", "create new file error!");
            return false;
        }
    }

    private char[] a(String str, String str2, String str3, String str4) {
        byte[] b4 = va.c.b(str);
        byte[] b10 = va.c.b(str2);
        byte[] b11 = va.c.b(str3);
        byte[] b12 = va.c.b(str4);
        int length = b4.length;
        if (length > b10.length) {
            length = b10.length;
        }
        if (length > b11.length) {
            length = b11.length;
        }
        if (length > b12.length) {
            length = b12.length;
        }
        char[] cArr = new char[length];
        for (int i10 = 0; i10 < length; i10++) {
            cArr[i10] = (char) (((b4[i10] ^ b10[i10]) ^ b11[i10]) ^ b12[i10]);
        }
        return cArr;
    }

    private String b(String str) {
        File file = new File(a(str), "hianalytics_" + str);
        if (a(file)) {
            return k1.a(file);
        }
        String d10 = va.b.d(128);
        k1.a(file, d10);
        return d10;
    }

    private boolean b() {
        long a10 = d.a(q0.i(), "Privacy_MY", "assemblyFlash", -1L);
        if (-1 != a10) {
            return System.currentTimeMillis() - a10 > 31536000000L;
        }
        v.c("hmsSdk", "First init components");
        return true;
    }

    private static boolean b(File file) {
        File[] listFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return false;
        }
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                if (!file2.delete()) {
                    v.c("hmsSdk", "delete file failed : " + file2.getName());
                }
            } else if (file2.isDirectory()) {
                b(file2);
            }
        }
        return file.delete();
    }

    public static boolean c() {
        return b(new File(q0.i().getFilesDir().getPath() + "/hms"));
    }

    private String d() {
        return "f6040d0e807aaec325ecf44823765544e92905158169f694b282bf17388632cf95a83bae7d2d235c1f039b0df1dcca5fda619b6f7f459f2ff8d70ddb7b601592fe29fcae58c028f319b3b12495e67aa5390942a997a8cb572c8030b2df5c2b622608bea02b0c3e5d4dff3f72c9e3204049a45c0760cd3604af8d57f0e0c693cc";
    }

    public String a() {
        String b4;
        String b10;
        String b11;
        String b12;
        String d10 = d();
        if (b()) {
            v.c("hmsSdk", "refresh components");
            b4 = va.b.d(128);
            a("aprpap", b4);
            b10 = va.b.d(128);
            a("febdoc", b10);
            b11 = va.b.d(128);
            a("marfil", b11);
            b12 = va.b.d(128);
            a("maywnj", b12);
            d.b(q0.i(), "Privacy_MY", "assemblyFlash", System.currentTimeMillis());
        } else {
            b4 = b("aprpap");
            b10 = b("febdoc");
            b11 = b("marfil");
            b12 = b("maywnj");
        }
        return va.c.a(ta.a.b(a(b4, b10, b11, d10), va.c.b(b12), 10000, 16));
    }
}
