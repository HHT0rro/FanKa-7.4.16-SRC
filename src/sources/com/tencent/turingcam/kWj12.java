package com.tencent.turingcam;

import android.hardware.Camera;
import android.view.View;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class kWj12 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f45417a = WOMZP.b("MtgFbiApIVD3jXJqCLt/bt5rkOw=");

    /* renamed from: b, reason: collision with root package name */
    private static final String f45418b = WOMZP.b("+cCcc23pI7PKMKrSVgxsZsPbclBvL8nzPyVl/A==");

    /* renamed from: c, reason: collision with root package name */
    private static final String f45419c = WOMZP.b("zJ+vMS29evWmRb1DSUyS4qT5+NHKl4KpLi9JENdY++M=");

    /* renamed from: d, reason: collision with root package name */
    private static final String f45420d = WOMZP.b("F7V8SjDFWDGEHyhQJR/vmJ2PsYQvMxifBN46aQ==");

    /* renamed from: e, reason: collision with root package name */
    private static final String f45421e = WOMZP.b("loortpg4288gBQkZu13SWTiWdIoZjskllRDZLQ==");

    /* renamed from: f, reason: collision with root package name */
    private static final String f45422f = WOMZP.b("6DSRX7wn8gyuk+q/kxETe0VQRVj1BK8BZd0Lbw==");

    /* renamed from: g, reason: collision with root package name */
    private static final String f45423g = WOMZP.b("u2xfuQx4IjM=");

    /* renamed from: h, reason: collision with root package name */
    private static final String f45424h = WOMZP.b("Mnyu7C/RGC+JS0uIqev/3mXSPxY=");

    /* renamed from: i, reason: collision with root package name */
    private static final String f45425i = WOMZP.b("Z86b4PLjU2vaBVXm");

    /* renamed from: j, reason: collision with root package name */
    private static final String f45426j = WOMZP.b("E/elQq9Fz2/OYi4i");

    /* renamed from: k, reason: collision with root package name */
    private static final String f45427k = WOMZP.b("CX8j6UeNDbaimerGJKcSkIzaGUY3pwfjnkV71g==");

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f45428l = 0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class spXPg {

        /* renamed from: a, reason: collision with root package name */
        private float f45429a;

        /* renamed from: b, reason: collision with root package name */
        private Camera f45430b;

        /* renamed from: g, reason: collision with root package name */
        private String f45435g;

        /* renamed from: h, reason: collision with root package name */
        private int f45436h;

        /* renamed from: i, reason: collision with root package name */
        private View f45437i;

        /* renamed from: c, reason: collision with root package name */
        private int f45431c = 0;

        /* renamed from: d, reason: collision with root package name */
        private int f45432d = 0;

        /* renamed from: e, reason: collision with root package name */
        private int f45433e = 0;

        /* renamed from: f, reason: collision with root package name */
        private int f45434f = 0;

        /* renamed from: j, reason: collision with root package name */
        private long f45438j = 500;

        public spXPg a(Map<String, String> map) {
            if (map == null) {
                return this;
            }
            String str = map.get(kWj12.f45423g);
            if (str != null) {
                str.split("_");
            }
            String str2 = map.get(kWj12.f45417a);
            if (str2 != null) {
                this.f45429a = Float.parseFloat(str2);
            }
            String str3 = map.get(kWj12.f45421e);
            if (str3 != null) {
                str3.split("_");
            }
            String str4 = map.get(kWj12.f45420d);
            if (str4 != null) {
                try {
                    this.f45432d = Integer.parseInt(str4);
                } catch (Exception unused) {
                }
            }
            String str5 = map.get(kWj12.f45421e);
            if (str5 != null) {
                str5.split("_");
            }
            String str6 = map.get(kWj12.f45422f);
            if (str6 != null) {
                try {
                    Integer.parseInt(str6);
                } catch (Exception unused2) {
                }
            }
            String str7 = map.get(kWj12.f45424h);
            if (str7 != null) {
                try {
                    this.f45431c = Integer.parseInt(str7);
                } catch (Exception unused3) {
                }
            }
            String str8 = map.get(kWj12.f45419c);
            if (str8 != null) {
                try {
                    this.f45433e = Integer.parseInt(str8);
                } catch (Exception unused4) {
                }
            }
            String str9 = map.get(kWj12.f45418b);
            if (str9 != null) {
                try {
                    this.f45434f = Integer.parseInt(str9);
                } catch (Exception unused5) {
                }
            }
            this.f45435g = map.get(kWj12.f45425i);
            String str10 = map.get(kWj12.f45426j);
            if (str10 != null) {
                try {
                    this.f45436h = Integer.parseInt(str10);
                } catch (Exception unused6) {
                }
            }
            String str11 = map.get(kWj12.f45427k);
            if (str11 != null) {
                try {
                    this.f45438j = Long.parseLong(str11);
                } catch (Exception unused7) {
                }
            }
            return this;
        }

        public View b() {
            return this.f45437i;
        }

        public float c() {
            return this.f45429a;
        }

        public int d(int i10) {
            int i11 = this.f45432d;
            return i11 > 0 ? i11 : i10;
        }

        public int e(int i10) {
            int i11 = this.f45433e;
            return i11 > 0 ? i11 : i10;
        }

        public int b(int i10) {
            int i11 = this.f45431c;
            return i11 > 0 ? i11 : i10;
        }

        public int c(int i10) {
            int i11 = this.f45434f;
            return i11 > 0 ? i11 : i10;
        }

        public String d() {
            return this.f45435g;
        }

        public long e() {
            return this.f45438j;
        }

        public spXPg a(View view) {
            this.f45437i = view;
            return this;
        }

        public spXPg a(Camera camera) {
            this.f45430b = camera;
            return this;
        }

        public Camera a() {
            return this.f45430b;
        }

        public int a(int i10) {
            int i11 = this.f45436h;
            return i11 > 0 ? i11 : i10;
        }
    }
}
