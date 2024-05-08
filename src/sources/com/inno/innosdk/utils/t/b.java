package com.inno.innosdk.utils.t;

import android.os.Environment;
import com.inno.innosdk.a.c;
import com.inno.innosdk.utils.q;
import com.kuaishou.weapon.p0.g;
import java.io.File;
import java.util.ArrayList;

/* compiled from: StorageAccessUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f35668a = q.a(c.k(), g.f36124j);

    /* renamed from: b, reason: collision with root package name */
    public static File f35669b = Environment.getExternalStorageDirectory();

    public static String a(String str, String str2) {
        if (!f35668a) {
            return "";
        }
        File file = new File(f35669b, str);
        if (!file.exists() && !file.mkdirs()) {
            return "";
        }
        File file2 = new File(file.getAbsolutePath(), str2);
        com.inno.innosdk.utils.u.a.a((Object) ("file " + ((Object) file2)));
        return a.a(file2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(String str, String str2) {
        int i10;
        int i11;
        com.inno.innosdk.utils.u.a.a((Object) ("STORAGE KEY = " + str + " kzm = " + str2));
        if (f35668a) {
            ArrayList arrayList = new ArrayList();
            File[] listFiles = f35669b.listFiles();
            int i12 = 0;
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    File file2 = new File(file.getAbsolutePath(), a(file, str2));
                    if (a.b(a.a(file2))) {
                        arrayList.add(file2);
                        if (arrayList.size() > 2) {
                            return;
                        }
                    } else {
                        continue;
                    }
                }
            }
            if (arrayList.size() >= 2) {
                a.a((File) arrayList.get(0), str);
                a.a((File) arrayList.get(1), str);
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            for (File file3 : listFiles) {
                if (file3.isDirectory()) {
                    arrayList2.add(file3);
                }
            }
            if (arrayList2.size() == 0) {
                return;
            }
            if (arrayList2.size() > 1) {
                i10 = 1;
                i11 = 1;
                while (i10 == i11) {
                    i10 = (int) (Math.random() * arrayList2.size());
                    i11 = (int) (Math.random() * arrayList2.size());
                    i12++;
                    if (i12 > 100) {
                        break;
                    }
                }
            } else {
                i10 = 1;
                i11 = 1;
            }
            a.a(new File(((File) arrayList2.get(i10)).getAbsolutePath(), a((File) arrayList2.get(i10), str2)), str);
            if (arrayList.size() == 1) {
                a.a(new File(((File) arrayList2.get(i11)).getAbsolutePath(), a((File) arrayList2.get(i11), str2)), str);
            }
        }
    }

    public static void a(String str, String str2, String str3) {
        if (f35668a) {
            String str4 = f35669b.getAbsolutePath() + File.separator + str;
            File file = new File(str4);
            if (!file.exists()) {
                file.mkdir();
            }
            a.a(new File(str4, str2), str3);
        }
    }

    public static String a(String str) {
        if (!f35668a) {
            return "";
        }
        try {
            File[] listFiles = f35669b.listFiles();
            StringBuilder sb2 = new StringBuilder();
            for (File file : listFiles) {
                if (file.isDirectory() && file.listFiles() != null && file.getName().contains("com.")) {
                    for (File file2 : file.listFiles()) {
                        if (file2.getName().contains(str)) {
                            if (sb2.length() > 2048) {
                                break;
                            }
                            sb2.append(file2.getPath());
                            sb2.append("$$$");
                        }
                    }
                }
            }
            String sb3 = sb2.toString();
            return sb3.endsWith("$$$") ? sb3.substring(0, sb3.length() - 3) : sb3;
        } catch (Exception e2) {
            com.inno.innosdk.utils.u.a.a((Throwable) e2);
            return "";
        }
    }

    public static String a(File file, String str) {
        return "." + q.b(file.getName()).substring(0, 5) + "." + str;
    }
}
