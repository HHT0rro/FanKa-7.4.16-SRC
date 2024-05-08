package com.huawei.quickcard;

import android.text.TextUtils;
import com.huawei.quickcard.watcher.Watcher;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class j0 {

    /* renamed from: j, reason: collision with root package name */
    private static final String f34057j = "\\s+(?:in|of)\\s+";

    /* renamed from: k, reason: collision with root package name */
    private static final String f34058k = "\\(|\\)";

    /* renamed from: l, reason: collision with root package name */
    private static final String f34059l = "[\\s]*,[\\s]*";

    /* renamed from: m, reason: collision with root package name */
    private static final String f34060m = "Index";

    /* renamed from: n, reason: collision with root package name */
    private static final String f34061n = "Key";

    /* renamed from: c, reason: collision with root package name */
    private String f34064c;

    /* renamed from: e, reason: collision with root package name */
    private String f34066e;

    /* renamed from: h, reason: collision with root package name */
    private String f34069h;

    /* renamed from: i, reason: collision with root package name */
    private Watcher f34070i;

    /* renamed from: d, reason: collision with root package name */
    private String f34065d = null;

    /* renamed from: f, reason: collision with root package name */
    private String f34067f = null;

    /* renamed from: g, reason: collision with root package name */
    private String f34068g = null;

    /* renamed from: a, reason: collision with root package name */
    private final List<String> f34062a = new ArrayList(2);

    /* renamed from: b, reason: collision with root package name */
    private final List<String> f34063b = new ArrayList(2);

    public j0(String str) {
        c(str);
    }

    private String b(String str) {
        return str + f34061n;
    }

    private void c(String str) {
        String[] split = str.split(f34057j, 2);
        if (split.length != 2) {
            return;
        }
        this.f34069h = split[1].trim();
        String[] split2 = split[0].trim().replaceAll(f34058k, "").split(f34059l);
        if (split2.length == 1) {
            this.f34064c = split2[0];
            this.f34066e = split2[0];
        } else if (split2.length == 2) {
            this.f34065d = split2[0];
            this.f34068g = split2[0];
            this.f34064c = split2[1];
            this.f34066e = split2[1];
        } else {
            if (split2.length != 3) {
                return;
            }
            this.f34065d = split2[0];
            this.f34068g = split2[0];
            this.f34064c = split2[1];
            this.f34066e = split2[1];
            this.f34067f = split2[2];
        }
        if (this.f34065d != null) {
            this.f34063b.add("let " + this.f34065d + " = ");
        }
        if (this.f34064c != null) {
            String a10 = TextUtils.isEmpty(this.f34065d) ? a(this.f34064c) : this.f34065d;
            this.f34063b.add("let " + this.f34064c + " = " + this.f34069h + "[" + a10 + "]");
        }
        if (this.f34068g != null) {
            this.f34062a.add("let " + this.f34068g + " = ");
        }
        if (this.f34067f != null) {
            this.f34062a.add("let " + this.f34067f + " = '");
        }
        if (this.f34066e != null) {
            String b4 = TextUtils.isEmpty(this.f34067f) ? b(this.f34066e) : this.f34067f;
            this.f34062a.add("let " + this.f34066e + " = " + this.f34069h + "[" + b4 + "]");
        }
    }

    public String a(int i10) {
        StringBuilder sb2 = new StringBuilder();
        if (this.f34063b.size() == 2) {
            sb2.append(this.f34063b.get(0));
            sb2.append(i10);
            sb2.append(";");
            sb2.append(this.f34063b.get(1));
            sb2.append(";");
        } else if (this.f34063b.size() == 1) {
            sb2.append("let ");
            sb2.append(a(this.f34064c));
            sb2.append(" = ");
            sb2.append(i10);
            sb2.append(";");
            sb2.append(this.f34063b.get(0));
            sb2.append(";");
        }
        return sb2.toString();
    }

    public String a(String str, int i10) {
        StringBuilder sb2 = new StringBuilder();
        if (this.f34062a.size() == 3) {
            sb2.append(this.f34062a.get(0));
            sb2.append(i10);
            sb2.append(";");
            sb2.append(this.f34062a.get(1));
            sb2.append(str);
            sb2.append("';");
            sb2.append(this.f34062a.get(2));
            sb2.append(";");
        } else if (this.f34062a.size() == 2) {
            sb2.append(this.f34062a.get(0));
            sb2.append(i10);
            sb2.append(";");
            sb2.append("let ");
            sb2.append(b(this.f34066e));
            sb2.append(" = '");
            sb2.append(str);
            sb2.append("';");
            sb2.append(this.f34062a.get(1));
            sb2.append(";");
        } else if (this.f34062a.size() == 1) {
            sb2.append("let ");
            sb2.append(a(this.f34066e));
            sb2.append(" = ");
            sb2.append(i10);
            sb2.append(";");
            sb2.append("let ");
            sb2.append(b(this.f34066e));
            sb2.append(" = '");
            sb2.append(str);
            sb2.append("';");
            sb2.append(this.f34062a.get(0));
            sb2.append(";");
        }
        return sb2.toString();
    }

    public String a() {
        return this.f34069h;
    }

    public Object a(CardContext cardContext) {
        Watcher watcher = this.f34070i;
        if (watcher != null) {
            return watcher.get();
        }
        return cardContext.executeExpr(this.f34069h, false);
    }

    private String a(String str) {
        return str + f34060m;
    }

    public void a(Watcher watcher) {
        this.f34070i = watcher;
    }
}
