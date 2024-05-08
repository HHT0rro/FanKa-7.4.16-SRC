package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.s7;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e1 {

    /* renamed from: b, reason: collision with root package name */
    public static volatile e1 f46985b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f46986c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public Context f46987a;

    public e1(Context context) {
        this.f46987a = context;
    }

    public static e1 a(Context context) {
        if (f46985b == null) {
            synchronized (e1.class) {
                if (f46985b == null) {
                    f46985b = new e1(context);
                }
            }
        }
        return f46985b;
    }

    public final File b(String str) {
        File file = new File(((Object) this.f46987a.getFilesDir()) + "/crash");
        if (!file.exists()) {
            file.mkdirs();
            return null;
        }
        File[] listFiles = file.listFiles();
        for (int i10 = 0; i10 < listFiles.length; i10++) {
            if (listFiles[i10].isFile() && listFiles[i10].getName().startsWith(str)) {
                return listFiles[i10];
            }
        }
        return null;
    }

    public String c(File file) {
        if (file == null) {
            return "";
        }
        String[] split = file.getName().split(com.huawei.openalliance.ad.constant.u.bD);
        return split.length != 2 ? "" : split[0];
    }

    public ArrayList<File> d() {
        ArrayList<File> arrayList = new ArrayList<>();
        File file = new File(((Object) this.f46987a.getFilesDir()) + "/crash");
        if (!file.exists()) {
            file.mkdirs();
            return arrayList;
        }
        File[] listFiles = file.listFiles();
        for (int i10 = 0; i10 < listFiles.length; i10++) {
            String[] split = listFiles[i10].getName().split(com.huawei.openalliance.ad.constant.u.bD);
            if (split.length >= 2 && Integer.parseInt(split[1]) >= 1 && listFiles[i10].isFile()) {
                arrayList.add(listFiles[i10]);
            }
        }
        return arrayList;
    }

    public void e(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (f46986c) {
            File b4 = b(str2);
            if (b4 != null) {
                String[] split = b4.getName().split(com.huawei.openalliance.ad.constant.u.bD);
                if (split.length < 2) {
                    return;
                }
                b4.renameTo(new File(((Object) this.f46987a.getFilesDir()) + "/crash/" + str2 + com.huawei.openalliance.ad.constant.u.bD + String.valueOf(Integer.parseInt(split[1]) + 1)));
            } else {
                FileOutputStream fileOutputStream = null;
                try {
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(new File(((Object) this.f46987a.getFilesDir()) + "/crash/" + str2 + com.huawei.openalliance.ad.constant.u.bD + "1"));
                        try {
                            fileOutputStream2.write(str.getBytes());
                            fileOutputStream2.flush();
                            s7.b(fileOutputStream2);
                        } catch (Exception e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream2;
                            fc.c.k(e);
                            s7.b(fileOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            s7.b(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e10) {
                    e = e10;
                }
            }
        }
    }
}
