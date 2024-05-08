package com.amap.api.col.s;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: Privacy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class cf {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f7458a = b.Unknow;

    /* renamed from: b, reason: collision with root package name */
    private static volatile d f7459b = d.Unknow;

    /* renamed from: c, reason: collision with root package name */
    private static volatile String f7460c = "";

    /* renamed from: d, reason: collision with root package name */
    private static volatile String f7461d = "";

    /* renamed from: e, reason: collision with root package name */
    private static volatile long f7462e = -1;

    /* renamed from: f, reason: collision with root package name */
    private static volatile a f7463f = a.Unknow;

    /* renamed from: g, reason: collision with root package name */
    private static volatile long f7464g = -1;

    /* renamed from: h, reason: collision with root package name */
    private static volatile String f7465h = "";

    /* renamed from: i, reason: collision with root package name */
    private static volatile String f7466i = "";

    /* renamed from: j, reason: collision with root package name */
    private static volatile long f7467j = 0;

    /* renamed from: k, reason: collision with root package name */
    private static volatile long f7468k = 0;

    /* renamed from: l, reason: collision with root package name */
    private static volatile boolean f7469l = false;

    /* renamed from: m, reason: collision with root package name */
    private static volatile boolean f7470m = true;

    /* compiled from: Privacy.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum a {
        Unknow(-1),
        NotAgree(0),
        DidAgree(1);


        /* renamed from: d, reason: collision with root package name */
        private int f7480d;

        a(int i10) {
            this.f7480d = i10;
        }

        public final int a() {
            return this.f7480d;
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
        private int f7485d;

        b(int i10) {
            this.f7485d = i10;
        }

        public final int a() {
            return this.f7485d;
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
        private final int f7496j;

        c(int i10) {
            this.f7496j = i10;
        }

        public final int a() {
            return this.f7496j;
        }
    }

    /* compiled from: Privacy.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum d {
        Unknow(-1),
        NotShow(0),
        DidShow(1);


        /* renamed from: d, reason: collision with root package name */
        private int f7501d;

        d(int i10) {
            this.f7501d = i10;
        }

        public final int a() {
            return this.f7501d;
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
            dh dhVar = new dh();
            dhVar.f7687b = context;
            dhVar.f7686a = jSONObject;
            new dt();
            ea a10 = dt.a(dhVar);
            if (a10 == null) {
                return false;
            }
            JSONObject jSONObject2 = new JSONObject(ci.a(a10.f7866a));
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
        synchronized (cf.class) {
            if (context == null) {
                return;
            }
            if (!f7469l) {
                e(context);
                f7469l = true;
            }
            try {
                di.a(context, "AMap.privacy.data", "AMap.privacy.data", String.format("%d&%d&%d&%s&%s&%d&%d&%s&%s&%d&%d", Integer.valueOf(f7458a.a()), Integer.valueOf(f7459b.a()), Long.valueOf(f7462e), f7460c, f7461d, Integer.valueOf(f7463f.a()), Long.valueOf(f7464g), f7465h, f7466i, Long.valueOf(f7467j), Long.valueOf(f7468k)));
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
            str = di.a(context, "AMap.privacy.data", "AMap.privacy.data");
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
            f7458a = b.a(Integer.parseInt(split[0]));
            f7459b = d.a(Integer.parseInt(split[1]));
            f7462e = Long.parseLong(split[2]);
            f7461d = split[3];
            f7461d = split[4];
            f7463f = a.a(Integer.parseInt(split[5]));
            f7464g = Long.parseLong(split[6]);
            f7465h = split[7];
            f7466i = split[8];
            f7467j = Long.parseLong(split[9]);
            f7468k = Long.parseLong(split[10]);
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

    public static void a(Context context, boolean z10, boolean z11, ch chVar) {
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
        a(context, dVar, bVar, chVar);
    }

    private static synchronized void a(Context context, d dVar, b bVar, ch chVar) {
        synchronized (cf.class) {
            if (context == null || chVar == null) {
                return;
            }
            if (!f7469l) {
                e(context);
                f7469l = true;
            }
            Boolean bool = Boolean.FALSE;
            if (dVar != f7459b) {
                bool = Boolean.TRUE;
                f7459b = dVar;
            }
            if (bVar != f7458a) {
                bool = Boolean.TRUE;
                f7458a = bVar;
            }
            if (bool.booleanValue()) {
                f7460c = chVar.b();
                f7461d = chVar.c();
                long currentTimeMillis = System.currentTimeMillis();
                f7462e = currentTimeMillis;
                f7467j = currentTimeMillis;
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
                            if (b(context, new JSONObject(new String(di.b(context, bArr))))) {
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

    public static void a(Context context, boolean z10, ch chVar) {
        a aVar;
        if (z10) {
            aVar = a.DidAgree;
        } else {
            aVar = a.NotAgree;
        }
        a(context, aVar, chVar);
    }

    private static synchronized void a(Context context, a aVar, ch chVar) {
        synchronized (cf.class) {
            if (context == null || chVar == null) {
                return;
            }
            if (!f7469l) {
                e(context);
                f7469l = true;
            }
            if (aVar != f7463f) {
                f7463f = aVar;
                f7465h = chVar.b();
                f7466i = chVar.c();
                long currentTimeMillis = System.currentTimeMillis();
                f7464g = currentTimeMillis;
                f7467j = currentTimeMillis;
                d(context);
            }
        }
    }

    public static synchronized cg a(final Context context, ch chVar) {
        boolean z10;
        synchronized (cf.class) {
            cg cgVar = null;
            if (context != null && chVar != null) {
                if (!f7469l) {
                    e(context);
                    f7469l = true;
                }
                if (f7459b != d.DidShow) {
                    if (f7459b == d.Unknow) {
                        cgVar = new cg(c.ShowUnknowCode, chVar);
                    } else if (f7459b == d.NotShow) {
                        cgVar = new cg(c.ShowNoShowCode, chVar);
                    }
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (z10 && f7458a != b.DidContain) {
                    if (f7458a == b.Unknow) {
                        cgVar = new cg(c.InfoUnknowCode, chVar);
                    } else if (f7458a == b.NotContain) {
                        cgVar = new cg(c.InfoNotContainCode, chVar);
                    }
                    z10 = false;
                }
                if (z10 && f7463f != a.DidAgree) {
                    if (f7463f == a.Unknow) {
                        cgVar = new cg(c.AgreeUnknowCode, chVar);
                    } else if (f7463f == a.NotAgree) {
                        cgVar = new cg(c.AgreeNotAgreeCode, chVar);
                    }
                    z10 = false;
                }
                if (f7468k != f7467j) {
                    final long j10 = f7467j;
                    f7468k = f7467j;
                    try {
                        final JSONObject jSONObject = new JSONObject();
                        jSONObject.put("privacyInfo", f7458a.a());
                        jSONObject.put("privacyShow", f7459b.a());
                        jSONObject.put("showTime", f7462e);
                        jSONObject.put("show2SDK", f7460c);
                        jSONObject.put("show2SDKVer", f7461d);
                        jSONObject.put("privacyAgree", f7463f.a());
                        jSONObject.put("agreeTime", f7464g);
                        jSONObject.put("agree2SDK", f7465h);
                        jSONObject.put("agree2SDKVer", f7466i);
                        final boolean z11 = f7470m;
                        ex.a().b(new ey() { // from class: com.amap.api.col.s.cf.2
                            @Override // com.amap.api.col.s.ey
                            public final void a() {
                                if (z11) {
                                    Iterator iterator2 = cf.b(cf.f(context)).iterator2();
                                    while (iterator2.hasNext()) {
                                        cf.a(context, ((File) iterator2.next()).getName());
                                    }
                                }
                                cf.d(context);
                                cf.a(context, jSONObject, j10);
                                boolean b4 = cf.b(context, jSONObject);
                                if (b4) {
                                    cf.b(context, cf.b(j10));
                                }
                                if (z11) {
                                    cf.b(context);
                                }
                                if (b4) {
                                    return;
                                }
                                cf.a(context, cf.b(j10));
                            }
                        });
                    } catch (Throwable unused) {
                    }
                } else if (f7470m) {
                    ex.a().b(new ey() { // from class: com.amap.api.col.s.cf.1
                        @Override // com.amap.api.col.s.ey
                        public final void a() {
                            Iterator iterator2 = cf.b(cf.f(context)).iterator2();
                            while (iterator2.hasNext()) {
                                cf.a(context, ((File) iterator2.next()).getName());
                            }
                            cf.b(context);
                        }
                    });
                }
                f7470m = false;
                String f10 = bw.f(context);
                if (f10 == null || f10.length() <= 0) {
                    cgVar = new cg(c.InvaildUserKeyCode, chVar);
                    chVar.b();
                    String.format("获取apikey失败：\nerrorCode : %d\n原因：%s", Integer.valueOf(cgVar.f7502a.a()), cgVar.f7503b);
                }
                if (z10) {
                    cgVar = new cg(c.SuccessCode, chVar);
                } else {
                    chVar.b();
                    String.format("隐私合规校验失败：\nerrorCode : %d\n原因：%s", Integer.valueOf(cgVar.f7502a.a()), cgVar.f7503b);
                }
                return cgVar;
            }
            return new cg(c.IllegalArgument, chVar);
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
            a10 = di.a(context, jSONObject.toString().getBytes());
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
