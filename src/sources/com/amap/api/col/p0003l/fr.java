package com.amap.api.col.p0003l;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: Privacy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class fr {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f5903a = b.Unknow;

    /* renamed from: b, reason: collision with root package name */
    private static volatile d f5904b = d.Unknow;

    /* renamed from: c, reason: collision with root package name */
    private static volatile String f5905c = "";

    /* renamed from: d, reason: collision with root package name */
    private static volatile String f5906d = "";

    /* renamed from: e, reason: collision with root package name */
    private static volatile long f5907e = -1;

    /* renamed from: f, reason: collision with root package name */
    private static volatile a f5908f = a.Unknow;

    /* renamed from: g, reason: collision with root package name */
    private static volatile long f5909g = -1;

    /* renamed from: h, reason: collision with root package name */
    private static volatile String f5910h = "";

    /* renamed from: i, reason: collision with root package name */
    private static volatile String f5911i = "";

    /* renamed from: j, reason: collision with root package name */
    private static volatile long f5912j = 0;

    /* renamed from: k, reason: collision with root package name */
    private static volatile long f5913k = 0;

    /* renamed from: l, reason: collision with root package name */
    private static volatile boolean f5914l = false;

    /* renamed from: m, reason: collision with root package name */
    private static volatile boolean f5915m = true;

    /* compiled from: Privacy.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum a {
        Unknow(-1),
        NotAgree(0),
        DidAgree(1);


        /* renamed from: d, reason: collision with root package name */
        private int f5925d;

        a(int i10) {
            this.f5925d = i10;
        }

        public final int a() {
            return this.f5925d;
        }

        public static a a(int i10) {
            a aVar = NotAgree;
            if (i10 == aVar.a()) {
                return aVar;
            }
            a aVar2 = DidAgree;
            return i10 == aVar2.a() ? aVar2 : Unknow;
        }
    }

    /* compiled from: Privacy.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum b {
        Unknow(-1),
        NotContain(0),
        DidContain(1);


        /* renamed from: d, reason: collision with root package name */
        private int f5930d;

        b(int i10) {
            this.f5930d = i10;
        }

        public final int a() {
            return this.f5930d;
        }

        public static b a(int i10) {
            b bVar = NotContain;
            if (i10 == bVar.a()) {
                return bVar;
            }
            b bVar2 = DidContain;
            return i10 == bVar2.a() ? bVar2 : Unknow;
        }
    }

    /* compiled from: Privacy.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum c {
        SuccessCode(0),
        ShowUnknowCode(555570),
        ShowNoShowCode(555571),
        InfoUnknowCode(555572),
        InfoNotContainCode(555573),
        AgreeUnknowCode(555574),
        AgreeNotAgreeCode(555575),
        InvaildUserKeyCode(10001),
        IllegalArgument(20001);


        /* renamed from: j, reason: collision with root package name */
        private final int f5941j;

        c(int i10) {
            this.f5941j = i10;
        }

        public final int a() {
            return this.f5941j;
        }
    }

    /* compiled from: Privacy.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum d {
        Unknow(-1),
        NotShow(0),
        DidShow(1);


        /* renamed from: d, reason: collision with root package name */
        private int f5946d;

        d(int i10) {
            this.f5946d = i10;
        }

        public final int a() {
            return this.f5946d;
        }

        public static d a(int i10) {
            d dVar = NotShow;
            if (i10 == dVar.a()) {
                return dVar;
            }
            d dVar2 = DidShow;
            return i10 == dVar2.a() ? dVar2 : Unknow;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Context context, JSONObject jSONObject) {
        try {
            hf hfVar = new hf();
            hfVar.f6248b = context;
            hfVar.f6247a = jSONObject;
            new hw();
            ie a10 = hw.a(hfVar);
            if (a10 == null) {
                return false;
            }
            JSONObject jSONObject2 = new JSONObject(fv.a(a10.f6444a));
            if (jSONObject2.has("status")) {
                return jSONObject2.getInt("status") == 1;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void d(Context context) {
        synchronized (fr.class) {
            if (context == null) {
                return;
            }
            if (!f5914l) {
                e(context);
                f5914l = true;
            }
            try {
                hl.a(context, "AMap.privacy.data", "AMap.privacy.data", String.format("%d&%d&%d&%s&%s&%d&%d&%s&%s&%d&%d", Integer.valueOf(f5903a.a()), Integer.valueOf(f5904b.a()), Long.valueOf(f5907e), f5905c, f5906d, Integer.valueOf(f5908f.a()), Long.valueOf(f5909g), f5910h, f5911i, Long.valueOf(f5912j), Long.valueOf(f5913k)));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static void e(Context context) {
        if (context == null) {
            return;
        }
        String str = null;
        try {
            str = hl.a(context, "AMap.privacy.data", "AMap.privacy.data");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (str == null) {
            return;
        }
        String[] split = str.split("&");
        if (split.length != 11) {
            return;
        }
        try {
            f5903a = b.a(Integer.parseInt(split[0]));
            f5904b = d.a(Integer.parseInt(split[1]));
            f5907e = Long.parseLong(split[2]);
            f5906d = split[3];
            f5906d = split[4];
            f5908f = a.a(Integer.parseInt(split[5]));
            f5909g = Long.parseLong(split[6]);
            f5910h = split[7];
            f5911i = split[8];
            f5912j = Long.parseLong(split[9]);
            f5913k = Long.parseLong(split[10]);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String f(Context context) {
        return context.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Upload";
    }

    private static String g(Context context) {
        return context.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Reload";
    }

    public static void a(Context context, boolean z10, boolean z11, fu fuVar) {
        d dVar;
        b bVar;
        if (z11) {
            dVar = d.DidShow;
        } else {
            dVar = d.NotShow;
        }
        if (z10) {
            bVar = b.DidContain;
        } else {
            bVar = b.NotContain;
        }
        a(context, dVar, bVar, fuVar);
    }

    private static synchronized void a(Context context, d dVar, b bVar, fu fuVar) {
        synchronized (fr.class) {
            if (context == null || fuVar == null) {
                return;
            }
            if (!f5914l) {
                e(context);
                f5914l = true;
            }
            Boolean bool = Boolean.FALSE;
            if (dVar != f5904b) {
                bool = Boolean.TRUE;
                f5904b = dVar;
            }
            if (bVar != f5903a) {
                bool = Boolean.TRUE;
                f5903a = bVar;
            }
            if (bool.booleanValue()) {
                f5905c = fuVar.a();
                f5906d = fuVar.b();
                long currentTimeMillis = System.currentTimeMillis();
                f5907e = currentTimeMillis;
                f5912j = currentTimeMillis;
                d(context);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(long j10) {
        return String.format("%d-%s", Long.valueOf(j10), "privacy.data");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayList<File> b(String str) {
        ArrayList<File> arrayList = new ArrayList<>();
        if (str != null && str.length() != 0) {
            File file = new File(str);
            if (!file.exists()) {
                return arrayList;
            }
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    arrayList.add(file2);
                }
            }
        }
        return arrayList;
    }

    public static /* synthetic */ void b(Context context) {
        try {
            Iterator<File> iterator2 = b(g(context)).iterator2();
            while (iterator2.hasNext()) {
                File next = iterator2.next();
                try {
                    String name = next.getName();
                    if (!name.endsWith("-privacy.data")) {
                        next.delete();
                    } else {
                        String[] split = name.split("-");
                        if (split == null && split.length != 2) {
                            next.delete();
                        } else if (Long.parseLong(split[0]) <= 0) {
                            next.delete();
                        } else {
                            FileInputStream fileInputStream = new FileInputStream(next);
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            if (b(context, new JSONObject(new String(hl.b(context, bArr))))) {
                                next.delete();
                            }
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(Context context, boolean z10, fu fuVar) {
        a aVar;
        if (z10) {
            aVar = a.DidAgree;
        } else {
            aVar = a.NotAgree;
        }
        a(context, aVar, fuVar);
    }

    private static synchronized void a(Context context, a aVar, fu fuVar) {
        synchronized (fr.class) {
            if (context == null || fuVar == null) {
                return;
            }
            if (!f5914l) {
                e(context);
                f5914l = true;
            }
            if (aVar != f5908f) {
                f5908f = aVar;
                f5910h = fuVar.a();
                f5911i = fuVar.b();
                long currentTimeMillis = System.currentTimeMillis();
                f5909g = currentTimeMillis;
                f5912j = currentTimeMillis;
                d(context);
            }
        }
    }

    public static synchronized fs a(final Context context, fu fuVar) {
        boolean z10;
        synchronized (fr.class) {
            fs fsVar = null;
            if (context != null && fuVar != null) {
                if (!f5914l) {
                    e(context);
                    f5914l = true;
                }
                if (f5904b != d.DidShow) {
                    if (f5904b == d.Unknow) {
                        fsVar = new fs(c.ShowUnknowCode, fuVar);
                    } else if (f5904b == d.NotShow) {
                        fsVar = new fs(c.ShowNoShowCode, fuVar);
                    }
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (z10 && f5903a != b.DidContain) {
                    if (f5903a == b.Unknow) {
                        fsVar = new fs(c.InfoUnknowCode, fuVar);
                    } else if (f5903a == b.NotContain) {
                        fsVar = new fs(c.InfoNotContainCode, fuVar);
                    }
                    z10 = false;
                }
                if (z10 && f5908f != a.DidAgree) {
                    if (f5908f == a.Unknow) {
                        fsVar = new fs(c.AgreeUnknowCode, fuVar);
                    } else if (f5908f == a.NotAgree) {
                        fsVar = new fs(c.AgreeNotAgreeCode, fuVar);
                    }
                    z10 = false;
                }
                if (f5913k != f5912j) {
                    final long j10 = f5912j;
                    f5913k = f5912j;
                    try {
                        final JSONObject jSONObject = new JSONObject();
                        jSONObject.put("privacyInfo", f5903a.a());
                        jSONObject.put("privacyShow", f5904b.a());
                        jSONObject.put("showTime", f5907e);
                        jSONObject.put("show2SDK", f5905c);
                        jSONObject.put("show2SDKVer", f5906d);
                        jSONObject.put("privacyAgree", f5908f.a());
                        jSONObject.put("agreeTime", f5909g);
                        jSONObject.put("agree2SDK", f5910h);
                        jSONObject.put("agree2SDKVer", f5911i);
                        final boolean z11 = f5915m;
                        jd.a().a(new je() { // from class: com.amap.api.col.3l.fr.2
                            @Override // com.amap.api.col.p0003l.je
                            public final void runTask() {
                                if (z11) {
                                    Iterator iterator2 = fr.b(fr.f(context)).iterator2();
                                    while (iterator2.hasNext()) {
                                        fr.a(context, ((File) iterator2.next()).getName());
                                    }
                                }
                                fr.d(context);
                                fr.a(context, jSONObject, j10);
                                boolean b4 = fr.b(context, jSONObject);
                                if (b4) {
                                    fr.b(context, fr.b(j10));
                                }
                                if (z11) {
                                    fr.b(context);
                                }
                                if (b4) {
                                    return;
                                }
                                fr.a(context, fr.b(j10));
                            }
                        });
                    } catch (Throwable unused) {
                    }
                } else if (f5915m) {
                    jd.a().a(new je() { // from class: com.amap.api.col.3l.fr.1
                        @Override // com.amap.api.col.p0003l.je
                        public final void runTask() {
                            Iterator iterator2 = fr.b(fr.f(context)).iterator2();
                            while (iterator2.hasNext()) {
                                fr.a(context, ((File) iterator2.next()).getName());
                            }
                            fr.b(context);
                        }
                    });
                }
                f5915m = false;
                String f10 = fj.f(context);
                if (f10 == null || f10.length() <= 0) {
                    fsVar = new fs(c.InvaildUserKeyCode, fuVar);
                    fuVar.a();
                    String.format("获取apikey失败：\nerrorCode : %d\n原因：%s", Integer.valueOf(fsVar.f5947a.a()), fsVar.f5948b);
                }
                if (z10) {
                    fsVar = new fs(c.SuccessCode, fuVar);
                } else {
                    fuVar.a();
                    String.format("隐私合规校验失败：\nerrorCode : %d\n原因：%s", Integer.valueOf(fsVar.f5947a.a()), fsVar.f5948b);
                }
                return fsVar;
            }
            return new fs(c.IllegalArgument, fuVar);
        }
    }

    public static /* synthetic */ void b(Context context, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            File file = new File(f(context) + "/" + str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static /* synthetic */ void a(Context context, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            File file = new File(f(context) + "/" + str);
            if (file.exists()) {
                File file2 = new File(g(context) + "/" + str);
                if (!file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                file.renameTo(file2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static /* synthetic */ void a(Context context, JSONObject jSONObject, long j10) {
        byte[] a10;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            a10 = hl.a(context, jSONObject.toString().getBytes());
            String b4 = b(j10);
            File file = new File(f(context) + "/" + b4);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(a10);
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        } catch (Throwable th3) {
            fileOutputStream2 = fileOutputStream;
            th = th3;
            try {
                th.printStackTrace();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
            } catch (Throwable th5) {
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th6) {
                        th6.printStackTrace();
                    }
                }
                throw th5;
            }
        }
    }
}
