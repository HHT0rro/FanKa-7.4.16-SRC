package com.huawei.quickcard;

import android.text.TextUtils;
import android.view.View;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.base.utils.JsonUtils;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.utils.ViewUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class f1 {

    /* renamed from: k, reason: collision with root package name */
    private static final String f33670k = "QTransform";

    /* renamed from: l, reason: collision with root package name */
    private static final String f33671l = "rotate";

    /* renamed from: m, reason: collision with root package name */
    private static final String f33672m = "rotateX";

    /* renamed from: n, reason: collision with root package name */
    private static final String f33673n = "rotateY";

    /* renamed from: o, reason: collision with root package name */
    private static final String f33674o = "scale";

    /* renamed from: p, reason: collision with root package name */
    private static final String f33675p = "scaleX";

    /* renamed from: q, reason: collision with root package name */
    private static final String f33676q = "scaleY";

    /* renamed from: r, reason: collision with root package name */
    private static final String f33677r = "translate";

    /* renamed from: s, reason: collision with root package name */
    private static final String f33678s = "translateX";

    /* renamed from: t, reason: collision with root package name */
    private static final String f33679t = "translateY";

    /* renamed from: u, reason: collision with root package name */
    private static final float f33680u = 0.0f;

    /* renamed from: v, reason: collision with root package name */
    private static final float f33681v = 1.0f;

    /* renamed from: w, reason: collision with root package name */
    private static final float f33682w = 0.0f;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<View> f33683a;

    /* renamed from: b, reason: collision with root package name */
    private float f33684b;

    /* renamed from: c, reason: collision with root package name */
    private float f33685c;

    /* renamed from: d, reason: collision with root package name */
    private float f33686d;

    /* renamed from: e, reason: collision with root package name */
    private float f33687e;

    /* renamed from: f, reason: collision with root package name */
    private float f33688f;

    /* renamed from: g, reason: collision with root package name */
    private float f33689g;

    /* renamed from: h, reason: collision with root package name */
    private float f33690h;

    /* renamed from: i, reason: collision with root package name */
    private float f33691i;

    /* renamed from: j, reason: collision with root package name */
    private float f33692j;

    public f1(View view) {
        this.f33683a = new WeakReference<>(view);
        h();
    }

    private void h() {
        this.f33684b = 0.0f;
        this.f33685c = 0.0f;
        this.f33686d = 0.0f;
        this.f33687e = 1.0f;
        this.f33688f = 1.0f;
        this.f33689g = 1.0f;
        this.f33690h = 0.0f;
        this.f33691i = 0.0f;
        this.f33692j = 0.0f;
    }

    public void a() {
        View view = this.f33683a.get();
        if (view != null) {
            view.setRotation(this.f33684b);
        }
    }

    public void b() {
        View view = this.f33683a.get();
        if (view != null) {
            view.setRotationX(this.f33685c);
        }
    }

    public void c() {
        View view = this.f33683a.get();
        if (view != null) {
            view.setRotationY(this.f33686d);
        }
    }

    public void d() {
        View view = this.f33683a.get();
        if (view != null) {
            view.setScaleX(this.f33688f);
        }
    }

    public void e() {
        View view = this.f33683a.get();
        if (view != null) {
            view.setScaleY(this.f33689g);
        }
    }

    public void f() {
        View view = this.f33683a.get();
        if (view != null) {
            view.setTranslationX(this.f33691i);
        }
    }

    public void g() {
        View view = this.f33683a.get();
        if (view != null) {
            view.setTranslationY(this.f33692j);
        }
    }

    public void i() {
        View view = this.f33683a.get();
        if (view == null) {
            return;
        }
        h();
        view.setRotation(0.0f);
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        view.setTranslationZ(0.0f);
    }

    private void a(JSONObject jSONObject) {
        Float b4 = b.b(JsonUtils.getString(jSONObject, "rotate", null));
        Float b10 = b.b(JsonUtils.getString(jSONObject, f33672m, null));
        Float b11 = b.b(JsonUtils.getString(jSONObject, f33673n, null));
        if (b4 != null) {
            this.f33684b = b4.floatValue();
        }
        if (b10 != null) {
            this.f33685c = b10.floatValue();
        }
        if (b11 != null) {
            this.f33686d = b11.floatValue();
        }
        View view = this.f33683a.get();
        if (view != null) {
            view.setRotation(this.f33684b);
            view.setRotationX(this.f33685c);
            view.setRotationY(this.f33686d);
        }
    }

    private void b(JSONObject jSONObject) {
        float f10 = (float) JsonUtils.getDouble(jSONObject, "scale", 1.0d);
        this.f33687e = f10;
        this.f33688f = (float) JsonUtils.getDouble(jSONObject, "scaleX", f10);
        this.f33689g = (float) JsonUtils.getDouble(jSONObject, "scaleY", this.f33687e);
        View view = this.f33683a.get();
        if (view != null) {
            view.setScaleX(this.f33688f);
            view.setScaleY(this.f33689g);
        }
    }

    private void c(JSONObject jSONObject) {
        String string = JsonUtils.getString(jSONObject, f33677r, null);
        String string2 = JsonUtils.getString(jSONObject, f33678s, null);
        String string3 = JsonUtils.getString(jSONObject, f33679t, null);
        View view = this.f33683a.get();
        if (view == null) {
            return;
        }
        this.f33690h = a(view, string);
        this.f33691i = a(view, string2);
        float a10 = a(view, string3);
        this.f33692j = a10;
        if (this.f33691i == 0.0f) {
            float f10 = this.f33690h;
            if (f10 != 0.0f) {
                this.f33691i = f10;
            }
        }
        if (a10 == 0.0f) {
            float f11 = this.f33690h;
            if (f11 != 0.0f) {
                this.f33692j = f11;
            }
        }
        view.setTranslationX(this.f33691i);
        view.setTranslationY(this.f33692j);
    }

    public void d(JSONObject jSONObject) {
        a(jSONObject);
        b(jSONObject);
        c(jSONObject);
    }

    private float a(View view, String str) {
        return ViewUtils.dip2FloatPx(view, ParserHelper.parseToDP(str, 0.0f).getDp());
    }

    public static JSONObject a(Object obj) {
        if (obj == null) {
            return null;
        }
        String trim = obj.toString().trim();
        if (trim.length() == 0) {
            return null;
        }
        if (trim.contains("(")) {
            JSONObject jSONObject = new JSONObject();
            a(jSONObject, trim);
            return jSONObject;
        }
        try {
            return new JSONObject(trim);
        } catch (JSONException unused) {
            CardLogUtils.w(f33670k, "create json object with string failed");
            return null;
        }
    }

    private static void a(JSONObject jSONObject, String str) {
        int max = Math.max(str.indexOf("("), 0);
        LinkedList linkedList = new LinkedList();
        StringBuilder sb2 = new StringBuilder();
        int i10 = max;
        int i11 = -1;
        while (true) {
            if (i10 >= str.length()) {
                i10 = i11;
                break;
            }
            String str2 = str.charAt(i10) + "";
            if ("(".equals(str2)) {
                linkedList.push(str2);
                if (linkedList.size() != 1) {
                    sb2.append(str2);
                }
            } else if (")".equals(str2)) {
                if (linkedList.size() > 0) {
                    linkedList.pop();
                }
                if (linkedList.size() == 0) {
                    break;
                } else {
                    sb2.append(str2);
                }
            } else {
                sb2.append(str2);
            }
            i11 = i10;
            i10++;
        }
        linkedList.clear();
        String trim = str.substring(0, max).trim();
        String trim2 = sb2.toString().trim();
        if (!TextUtils.isEmpty(trim)) {
            try {
                jSONObject.put(trim, trim2);
            } catch (JSONException unused) {
                CardLogUtils.w(f33670k, "put value with key into the json object failed");
            }
        }
        if (i10 < str.length() - 1) {
            a(jSONObject, str.substring(i10 + 1).trim());
        }
    }
}
