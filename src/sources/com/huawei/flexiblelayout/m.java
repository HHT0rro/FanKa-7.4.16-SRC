package com.huawei.flexiblelayout;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.services.effect.FLEffect;
import com.huawei.quickcard.base.Attributes;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: BorderEffect.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class m implements FLEffect {

    /* renamed from: e, reason: collision with root package name */
    private static final String f28226e = "BorderEffect";

    /* renamed from: f, reason: collision with root package name */
    public static final String f28227f = "border";

    /* renamed from: a, reason: collision with root package name */
    private a f28228a;

    /* renamed from: b, reason: collision with root package name */
    public p f28229b = new p();

    /* renamed from: c, reason: collision with root package name */
    private Drawable f28230c;

    /* renamed from: d, reason: collision with root package name */
    private View f28231d;

    /* compiled from: BorderEffect.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f28232a;

        /* renamed from: b, reason: collision with root package name */
        private String f28233b;

        /* renamed from: c, reason: collision with root package name */
        private b f28234c;

        /* renamed from: d, reason: collision with root package name */
        private int f28235d;

        /* renamed from: e, reason: collision with root package name */
        private int f28236e;

        /* renamed from: f, reason: collision with root package name */
        private int f28237f;

        /* renamed from: g, reason: collision with root package name */
        private Map<String, Integer> f28238g;

        /* compiled from: BorderEffect.java */
        /* renamed from: com.huawei.flexiblelayout.m$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class C0272a {

            /* renamed from: a, reason: collision with root package name */
            private Context f28239a;

            /* renamed from: b, reason: collision with root package name */
            private String f28240b;

            /* renamed from: c, reason: collision with root package name */
            private String f28241c;

            /* renamed from: d, reason: collision with root package name */
            private b f28242d;

            /* renamed from: e, reason: collision with root package name */
            private String f28243e;

            /* renamed from: f, reason: collision with root package name */
            private String f28244f;

            /* renamed from: g, reason: collision with root package name */
            private String f28245g;

            public C0272a(Context context, String str, String str2) {
                this.f28239a = context;
                this.f28241c = str2;
                this.f28240b = str;
            }

            public C0272a a(b bVar) {
                this.f28242d = bVar;
                return this;
            }

            public C0272a b(String str) {
                this.f28245g = str;
                return this;
            }

            public C0272a c(String str) {
                this.f28243e = str;
                return this;
            }

            public C0272a a(String str) {
                this.f28244f = str;
                return this;
            }

            public a a() {
                a aVar = new a();
                aVar.f28232a = this.f28240b;
                aVar.f28233b = this.f28241c;
                aVar.f28234c = this.f28242d;
                try {
                    aVar.f28235d = com.huawei.flexiblelayout.css.util.a.a(this.f28239a, Float.parseFloat(this.f28243e));
                } catch (Exception e2) {
                    Log.w(m.f28226e, "Border Builder e:" + e2.getMessage());
                }
                try {
                    String str = this.f28244f;
                    if (str != null) {
                        aVar.f28236e = Color.parseColor(str);
                    }
                } catch (Exception e10) {
                    Log.w(m.f28226e, "Border Builder mColor, e:" + e10.getMessage());
                }
                try {
                    String str2 = this.f28245g;
                    if (str2 != null) {
                        aVar.f28237f = Color.parseColor(str2);
                    }
                } catch (Exception e11) {
                    Log.w(m.f28226e, "Border Builder mSolidColor, e:" + e11.getMessage());
                }
                return aVar;
            }
        }

        /* compiled from: BorderEffect.java */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class b {

            /* renamed from: a, reason: collision with root package name */
            private int f28246a;

            /* renamed from: b, reason: collision with root package name */
            private int f28247b;

            /* renamed from: c, reason: collision with root package name */
            private int f28248c;

            /* renamed from: d, reason: collision with root package name */
            private int f28249d;

            /* renamed from: e, reason: collision with root package name */
            private int f28250e;

            /* compiled from: BorderEffect.java */
            /* renamed from: com.huawei.flexiblelayout.m$a$b$a, reason: collision with other inner class name */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
            public static class C0273a {

                /* renamed from: a, reason: collision with root package name */
                private String f28251a;

                /* renamed from: b, reason: collision with root package name */
                private String f28252b;

                /* renamed from: c, reason: collision with root package name */
                private String f28253c;

                /* renamed from: d, reason: collision with root package name */
                private String f28254d;

                /* renamed from: e, reason: collision with root package name */
                private String f28255e;

                /* renamed from: f, reason: collision with root package name */
                private Context f28256f;

                public C0273a(Context context) {
                    this.f28256f = context;
                }

                private int f(String str) {
                    try {
                        return com.huawei.flexiblelayout.css.util.a.a(this.f28256f, Integer.parseInt(str));
                    } catch (Exception e2) {
                        Log.w(m.f28226e, "getRadius, e: " + e2.getMessage());
                        return 0;
                    }
                }

                public C0273a a(String str) {
                    if (TextUtils.isEmpty(this.f28254d)) {
                        this.f28254d = str;
                    }
                    return this;
                }

                public C0273a b(String str) {
                    if (TextUtils.isEmpty(this.f28255e)) {
                        this.f28255e = str;
                    }
                    return this;
                }

                public C0273a c(String str) {
                    this.f28251a = str;
                    this.f28252b = str;
                    this.f28253c = str;
                    this.f28254d = str;
                    this.f28255e = str;
                    return this;
                }

                public C0273a d(String str) {
                    if (TextUtils.isEmpty(this.f28252b)) {
                        this.f28252b = str;
                    }
                    return this;
                }

                public C0273a e(String str) {
                    if (TextUtils.isEmpty(this.f28253c)) {
                        this.f28253c = str;
                    }
                    return this;
                }

                public b a() {
                    b bVar = new b();
                    bVar.f28246a = f(this.f28251a);
                    bVar.f28247b = f(this.f28252b);
                    bVar.f28248c = f(this.f28253c);
                    bVar.f28249d = f(this.f28254d);
                    bVar.f28250e = f(this.f28255e);
                    return bVar;
                }
            }

            public int a() {
                return this.f28249d;
            }

            public int b() {
                return this.f28250e;
            }

            public int c() {
                return this.f28246a;
            }

            public int d() {
                return this.f28247b;
            }

            public int e() {
                return this.f28248c;
            }
        }

        public a() {
            HashMap hashMap = new HashMap();
            this.f28238g = hashMap;
            hashMap.put("rectangle", 0);
            this.f28238g.put("oval", 1);
            this.f28238g.put("line", 2);
        }

        public int d() {
            return this.f28237f;
        }

        public String e() {
            return this.f28232a;
        }

        public int f() {
            return this.f28235d;
        }

        public int c() {
            return this.f28238g.get(this.f28233b).intValue();
        }

        public b b() {
            return this.f28234c;
        }

        public int a() {
            return this.f28236e;
        }
    }

    private Drawable a(View view) {
        if (view == null || Build.VERSION.SDK_INT < 23) {
            return null;
        }
        return view.getForeground();
    }

    @Override // com.huawei.flexiblelayout.services.effect.FLEffect
    public void apply(View view, JSONObject jSONObject) {
        this.f28231d = view;
        a(jSONObject);
        a aVar = this.f28228a;
        if (aVar != null) {
            this.f28229b.a(aVar);
            if (Attributes.Style.BACKGROUND.equals(this.f28228a.e())) {
                this.f28230c = view.getBackground();
                view.setBackground(this.f28229b);
            } else {
                this.f28230c = a(view);
                a(view, this.f28229b);
            }
        }
    }

    @Override // com.huawei.flexiblelayout.services.effect.FLEffect
    public void unapply(View view) {
        a aVar = this.f28228a;
        if (aVar == null) {
            return;
        }
        if (Attributes.Style.BACKGROUND.equals(aVar.e())) {
            view.setBackground(this.f28230c);
        } else {
            a(view, this.f28230c);
        }
    }

    private void a(View view, Drawable drawable) {
        if (view == null || Build.VERSION.SDK_INT < 23) {
            return;
        }
        view.setForeground(drawable);
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("type");
            String optString2 = jSONObject.optString("shape");
            String optString3 = jSONObject.optString("radius");
            String optString4 = jSONObject.optString("topLeftRadius");
            String optString5 = jSONObject.optString("topRightRadius");
            String optString6 = jSONObject.optString("bottomLeftRadius");
            String optString7 = jSONObject.optString("bottomRightRadius");
            String optString8 = jSONObject.optString("width");
            String optString9 = jSONObject.optString("color");
            this.f28228a = new a.C0272a(this.f28231d.getContext(), optString, optString2).a(new a.b.C0273a(this.f28231d.getContext()).c(optString3).d(optString4).e(optString5).a(optString6).b(optString7).a()).c(optString8).a(optString9).b(jSONObject.optString("solidColor")).a();
        }
    }
}
