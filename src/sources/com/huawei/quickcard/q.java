package com.huawei.quickcard;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.huawei.quickcard.framework.border.Border;
import com.huawei.quickcard.framework.unit.LengthValue;
import com.huawei.quickcard.views.image.extension.FitMode;
import com.huawei.quickcard.views.image.extension.PicType;
import com.huawei.quickcard.views.image.processor.AltAttribute;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private String f34174a;

    /* renamed from: b, reason: collision with root package name */
    private PicType f34175b;

    /* renamed from: c, reason: collision with root package name */
    private String f34176c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f34177d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f34178e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f34179f;

    /* renamed from: g, reason: collision with root package name */
    private FitMode f34180g;

    /* renamed from: h, reason: collision with root package name */
    private String f34181h;

    /* renamed from: i, reason: collision with root package name */
    private LengthValue f34182i;

    /* renamed from: j, reason: collision with root package name */
    private LengthValue f34183j;

    /* renamed from: k, reason: collision with root package name */
    private Border f34184k;

    /* renamed from: l, reason: collision with root package name */
    private final Map<String, Drawable> f34185l;

    /* renamed from: m, reason: collision with root package name */
    private int f34186m = -1;

    /* renamed from: n, reason: collision with root package name */
    private int f34187n = -1;

    public q() {
        HashMap hashMap = new HashMap();
        this.f34185l = hashMap;
        hashMap.put(null, new ColorDrawable(AltAttribute.DEFAULT_ALT));
        this.f34177d = true;
        this.f34179f = true;
    }

    public Drawable a(String str) {
        return this.f34185l.get(str);
    }

    public void b(boolean z10) {
        this.f34177d = z10;
    }

    public void c(String str) {
        this.f34174a = str;
    }

    public String d() {
        return this.f34181h;
    }

    public FitMode e() {
        return this.f34180g;
    }

    public int f() {
        return this.f34187n;
    }

    public PicType g() {
        return this.f34175b;
    }

    public Drawable h() {
        return a(this.f34176c);
    }

    public String i() {
        return this.f34176c;
    }

    public String j() {
        return this.f34174a;
    }

    public int k() {
        return this.f34186m;
    }

    public boolean l() {
        return this.f34178e;
    }

    public boolean m() {
        return this.f34177d;
    }

    public boolean n() {
        return this.f34179f;
    }

    public void a(String str, Drawable drawable) {
        this.f34176c = str;
        this.f34185l.put(str, drawable);
    }

    public void b(String str) {
        this.f34181h = str;
    }

    public void c(boolean z10) {
        this.f34179f = z10;
    }

    public LengthValue b() {
        return this.f34182i;
    }

    public LengthValue c() {
        return this.f34183j;
    }

    public void a(boolean z10) {
        this.f34178e = z10;
    }

    public void b(LengthValue lengthValue) {
        this.f34183j = lengthValue;
    }

    public void a(FitMode fitMode) {
        this.f34180g = fitMode;
    }

    public void b(int i10) {
        this.f34186m = i10;
    }

    public void a(LengthValue lengthValue) {
        this.f34182i = lengthValue;
    }

    public void a(PicType picType) {
        this.f34175b = picType;
    }

    public void a(int i10) {
        this.f34187n = i10;
    }

    public Border a() {
        return this.f34184k;
    }

    public void a(Border border) {
        this.f34184k = border;
    }
}
