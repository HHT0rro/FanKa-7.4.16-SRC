package com.inno.innosdk.utils;

import android.content.Context;
import android.database.ContentObserver;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.WindowManager;
import com.alimm.tanx.core.constant.TanxAdType;
import com.inno.innosdk.bean.FcDeviceInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ScreenShotListenManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f35615a = {"_data", "datetaken"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f35616b = {"_data", "datetaken", "width", "height"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f35617c = {TanxAdType.SPLASH_STRING, "shot", "截屏", "screenshot", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap"};

    /* renamed from: d, reason: collision with root package name */
    public static m f35618d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f35619e;

    /* renamed from: f, reason: collision with root package name */
    public static int f35620f;

    /* renamed from: g, reason: collision with root package name */
    public static int f35621g;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f35622h;

    /* renamed from: i, reason: collision with root package name */
    public static int f35623i;

    /* renamed from: j, reason: collision with root package name */
    public static Point f35624j;

    /* renamed from: k, reason: collision with root package name */
    public final List<String> f35625k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public final Handler f35626l = new Handler(com.inno.innosdk.a.c.k().getMainLooper());

    /* renamed from: m, reason: collision with root package name */
    public Context f35627m;

    /* renamed from: n, reason: collision with root package name */
    public c f35628n;

    /* renamed from: o, reason: collision with root package name */
    public long f35629o;

    /* renamed from: p, reason: collision with root package name */
    public b f35630p;

    /* renamed from: q, reason: collision with root package name */
    public b f35631q;

    /* compiled from: ScreenShotListenManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f35632a;

        public a(Context context) {
            this.f35632a = context;
        }

        @Override // com.inno.innosdk.utils.m.c
        public void a(String str) {
            m mVar;
            try {
                if (m.f35619e) {
                    int parseInt = Integer.parseInt(q.b(this.f35632a, "inno_scshot", "0")) + 1;
                    m.b();
                    q.d(this.f35632a, "inno_scshot", String.valueOf(parseInt));
                    try {
                        if (m.f35620f > 0 && m.f35623i >= m.f35620f) {
                            FcDeviceInfo fcDeviceInfo = new FcDeviceInfo(TanxAdType.SPLASH_STRING);
                            fcDeviceInfo.scshot = String.valueOf(m.f35623i);
                            int unused = m.f35623i = 0;
                            com.inno.innosdk.b.b.a(fcDeviceInfo);
                        }
                    } catch (Throwable th) {
                        com.inno.innosdk.utils.u.a.a(th);
                    }
                }
            } catch (Throwable th2) {
                com.inno.innosdk.utils.u.a.a(th2);
            }
            if (TextUtils.equals(q.b(this.f35632a, "task_check_login", "0"), "1")) {
                com.inno.innosdk.b.b.a(new FcDeviceInfo("loginShot"));
                q.d(this.f35632a, "task_check_login", "0");
                m.f35621g = 0;
                if (m.f35620f != 0 || (mVar = m.f35618d) == null) {
                    return;
                }
                mVar.f();
            }
        }
    }

    /* compiled from: ScreenShotListenManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class b extends ContentObserver {

        /* renamed from: a, reason: collision with root package name */
        public Uri f35633a;

        public b(Uri uri, Handler handler) {
            super(handler);
            this.f35633a = uri;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            super.onChange(z10);
            m.this.a(this.f35633a);
        }
    }

    /* compiled from: ScreenShotListenManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface c {
        void a(String str);
    }

    public m(Context context) {
        try {
            if (context != null) {
                this.f35627m = context;
                if (f35624j == null) {
                    f35624j = d();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("The context must not be null.");
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }

    public static /* synthetic */ int b() {
        int i10 = f35623i;
        f35623i = i10 + 1;
        return i10;
    }

    public static void c() {
        try {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                throw new IllegalStateException("Call the method must be in main thread: " + (stackTrace.length >= 4 ? stackTrace[3].toString() : null));
            }
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }

    private Point d() {
        Exception e2;
        Point point;
        WindowManager windowManager;
        try {
            try {
                point = new Point();
                try {
                    windowManager = (WindowManager) this.f35627m.getSystemService("window");
                } catch (Exception e10) {
                    e2 = e10;
                    e2.printStackTrace();
                    return point;
                }
            } catch (Throwable th) {
                com.inno.innosdk.utils.u.a.a(th);
                return null;
            }
        } catch (Exception e11) {
            e2 = e11;
            point = null;
        }
        if (windowManager == null) {
            return point;
        }
        windowManager.getDefaultDisplay().getRealSize(point);
        return point;
    }

    public void e() {
        try {
            c();
            this.f35625k.clear();
            this.f35629o = System.currentTimeMillis();
            this.f35630p = new b(MediaStore.Images.Media.INTERNAL_CONTENT_URI, this.f35626l);
            this.f35631q = new b(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.f35626l);
            this.f35627m.getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, false, this.f35630p);
            this.f35627m.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, false, this.f35631q);
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }

    public void f() {
        try {
            f35619e = false;
            c();
            if (this.f35630p != null) {
                try {
                    this.f35627m.getContentResolver().unregisterContentObserver(this.f35630p);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.f35630p = null;
            }
            if (this.f35631q != null) {
                try {
                    this.f35627m.getContentResolver().unregisterContentObserver(this.f35631q);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                this.f35631q = null;
            }
            this.f35629o = 0L;
            this.f35625k.clear();
            f35622h = false;
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }

    public static void b(Context context) {
        try {
            if ((f35620f == 0 && f35621g == 0) || f35622h) {
                return;
            }
            f35622h = true;
            f35619e = true;
            m a10 = a(context);
            f35618d = a10;
            if (a10 == null) {
                return;
            }
            a10.a(new a(context));
            if (Build.VERSION.SDK_INT > 22) {
                if (com.inno.innosdk.utils.t.b.f35668a) {
                    f35618d.e();
                    return;
                }
                return;
            }
            f35618d.e();
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }

    public static m a(Context context) {
        try {
            c();
            return new m(context);
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.net.Uri r11) {
        /*
            r10 = this;
            r0 = 0
            android.content.Context r1 = r10.f35627m     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            android.content.ContentResolver r2 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            java.lang.String[] r4 = com.inno.innosdk.utils.m.f35616b     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            r5 = 0
            r6 = 0
            java.lang.String r7 = "date_added desc limit 1"
            r3 = r11
            android.database.Cursor r0 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            if (r0 != 0) goto L20
            if (r0 == 0) goto L1f
            boolean r11 = r0.isClosed()     // Catch: java.lang.Throwable -> L8a
            if (r11 != 0) goto L1f
            r0.close()     // Catch: java.lang.Throwable -> L8a
        L1f:
            return
        L20:
            boolean r11 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            if (r11 != 0) goto L30
            boolean r11 = r0.isClosed()     // Catch: java.lang.Throwable -> L8a
            if (r11 != 0) goto L2f
            r0.close()     // Catch: java.lang.Throwable -> L8a
        L2f:
            return
        L30:
            java.lang.String r11 = "_data"
            int r11 = r0.getColumnIndex(r11)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            java.lang.String r1 = "datetaken"
            int r1 = r0.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            java.lang.String r2 = "width"
            int r2 = r0.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            java.lang.String r3 = "height"
            int r3 = r0.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            java.lang.String r5 = r0.getString(r11)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            long r6 = r0.getLong(r1)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            r11 = 0
            if (r2 < 0) goto L5e
            if (r3 < 0) goto L5e
            int r11 = r0.getInt(r2)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            int r1 = r0.getInt(r3)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            goto L68
        L5e:
            android.graphics.Point r1 = r10.b(r5)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            if (r1 == 0) goto L6b
            int r11 = r1.x     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            int r1 = r1.y     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
        L68:
            r8 = r11
            r9 = r1
            goto L6d
        L6b:
            r8 = 0
            r9 = 0
        L6d:
            r4 = r10
            r4.b(r5, r6, r8, r9)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            boolean r11 = r0.isClosed()     // Catch: java.lang.Throwable -> L8a
            if (r11 != 0) goto L9b
            goto L86
        L78:
            r11 = move-exception
            goto L8c
        L7a:
            r11 = move-exception
            r11.printStackTrace()     // Catch: java.lang.Throwable -> L78
            if (r0 == 0) goto L9b
            boolean r11 = r0.isClosed()     // Catch: java.lang.Throwable -> L8a
            if (r11 != 0) goto L9b
        L86:
            r0.close()     // Catch: java.lang.Throwable -> L8a
            goto L9b
        L8a:
            r11 = move-exception
            goto L98
        L8c:
            if (r0 == 0) goto L97
            boolean r1 = r0.isClosed()     // Catch: java.lang.Throwable -> L8a
            if (r1 != 0) goto L97
            r0.close()     // Catch: java.lang.Throwable -> L8a
        L97:
            throw r11     // Catch: java.lang.Throwable -> L8a
        L98:
            com.inno.innosdk.utils.u.a.a(r11)
        L9b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inno.innosdk.utils.m.a(android.net.Uri):void");
    }

    private Point b(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            return new Point(options.outWidth, options.outHeight);
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return null;
        }
    }

    private void b(String str, long j10, int i10, int i11) {
        try {
            if (!a(str, j10, i10, i11) || this.f35628n == null || a(str)) {
                return;
            }
            this.f35628n.a(str);
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }

    private boolean a(String str, long j10, int i10, int i11) {
        try {
            if (j10 >= this.f35629o && System.currentTimeMillis() - j10 <= 10000) {
                Point point = f35624j;
                if (point != null) {
                    int i12 = point.x;
                    if (!((i10 <= i12 && i11 <= point.y) || (i11 <= i12 && i10 <= point.y))) {
                        return false;
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                String lowerCase = str.toLowerCase();
                for (String str2 : f35617c) {
                    if (lowerCase.contains(str2)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return false;
        }
    }

    private boolean a(String str) {
        try {
            if (this.f35625k.contains(str)) {
                return true;
            }
            if (this.f35625k.size() >= 20) {
                this.f35625k.subList(0, 5).clear();
            }
            this.f35625k.add(str);
            return false;
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return false;
        }
    }

    public void a(c cVar) {
        try {
            this.f35628n = cVar;
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }
}
