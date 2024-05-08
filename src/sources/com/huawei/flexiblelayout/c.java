package com.huawei.flexiblelayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.huawei.flexiblelayout.b;
import com.huawei.flexiblelayout.parser.expr.ExprException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: XPathParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    private final String f27740a;

    /* renamed from: b, reason: collision with root package name */
    private final int f27741b;

    /* renamed from: c, reason: collision with root package name */
    private int f27742c = 0;

    /* renamed from: d, reason: collision with root package name */
    private List<b.a> f27743d;

    public c(@NonNull String str) {
        this.f27740a = str;
        this.f27741b = str.length();
    }

    private int e() throws ExprException {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            int i10 = this.f27742c;
            if (i10 < this.f27741b) {
                char charAt = this.f27740a.charAt(i10);
                if (Character.isDigit(charAt)) {
                    this.f27742c++;
                    sb2.append(charAt);
                }
            }
            try {
                return Integer.parseInt(sb2.toString());
            } catch (NumberFormatException unused) {
                throw new ExprException("invalid integer");
            }
        }
    }

    @NonNull
    public List<b.a> a() throws ExprException {
        List<b.a> list = this.f27743d;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        b(true);
        if (!this.f27740a.startsWith(".", this.f27742c)) {
            arrayList.add(i.f28147a);
        }
        while (this.f27742c < this.f27741b) {
            b(false);
            int i10 = this.f27742c;
            if (i10 >= this.f27741b) {
                break;
            }
            if (this.f27740a.startsWith("//", i10)) {
                arrayList.add(e.f28113a);
                this.f27742c += 2;
            } else if (this.f27740a.startsWith("/", this.f27742c)) {
                this.f27742c++;
            } else if (this.f27740a.startsWith(StringUtils.NO_PRINT_CODE, this.f27742c)) {
                arrayList.add(d.f28017a);
                this.f27742c++;
            } else if (this.f27740a.startsWith("..", this.f27742c)) {
                arrayList.add(h.f28142a);
                this.f27742c += 2;
            } else if (this.f27740a.startsWith(".", this.f27742c)) {
                arrayList.add(f.f28120a);
                this.f27742c++;
            } else if (this.f27740a.startsWith("[", this.f27742c)) {
                if (!arrayList.isEmpty()) {
                    arrayList.add(new g((b.a) arrayList.remove(arrayList.size() - 1), c()));
                } else {
                    throw new ExprException("predicate without expr");
                }
            } else if (b(this.f27740a.charAt(this.f27742c))) {
                String a10 = a(true);
                if (a10 != null) {
                    arrayList.add(new j(a10));
                } else {
                    throw new ExprException("unreachable");
                }
            } else {
                throw new ExprException("unexpected token");
            }
        }
        if (!arrayList.isEmpty()) {
            this.f27743d = arrayList;
            return arrayList;
        }
        throw new ExprException("empty xpath");
    }

    @NonNull
    public b.InterfaceC0264b b() throws ExprException {
        int e2 = e();
        b(true);
        a(']');
        return new k(e2);
    }

    @NonNull
    public b.InterfaceC0264b c() throws ExprException {
        a('[');
        b(true);
        char charAt = this.f27740a.charAt(this.f27742c);
        if (charAt == '@') {
            return d();
        }
        if (Character.isDigit(charAt)) {
            return b();
        }
        throw new ExprException("unsupported predicate");
    }

    @NonNull
    public b.InterfaceC0264b d() throws ExprException {
        a('@');
        b(true);
        String a10 = a(false);
        if (a10 != null) {
            b(true);
            a('=');
            b(true);
            String str = this.f27740a;
            int i10 = this.f27742c;
            this.f27742c = i10 + 1;
            char charAt = str.charAt(i10);
            if (charAt != '\"' && charAt != '\'') {
                throw new ExprException("missing quote mark");
            }
            String c4 = c(charAt);
            a(charAt);
            b(true);
            a(']');
            return new l(a10, c4);
        }
        throw new ExprException("missing property name");
    }

    public void b(boolean z10) throws ExprException {
        while (true) {
            int i10 = this.f27742c;
            if (i10 >= this.f27741b || !Character.isWhitespace(this.f27740a.charAt(i10))) {
                break;
            } else {
                this.f27742c++;
            }
        }
        if (z10 && this.f27742c >= this.f27741b) {
            throw new ExprException("unexpected expression end");
        }
    }

    @NonNull
    private String c(char c4) throws ExprException {
        boolean z10;
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            int i10 = this.f27742c;
            z10 = true;
            if (i10 >= this.f27741b) {
                z10 = false;
                break;
            }
            char charAt = this.f27740a.charAt(i10);
            if (charAt == c4) {
                break;
            }
            if (charAt == '\\') {
                int i11 = this.f27742c + 1;
                this.f27742c = i11;
                if (i11 < this.f27741b) {
                    sb2.append(this.f27740a.charAt(i11));
                }
            } else {
                sb2.append(charAt);
            }
            this.f27742c++;
        }
        if (z10) {
            return sb2.toString();
        }
        throw new ExprException("invalid quotation marks");
    }

    public static boolean b(char c4) {
        return Character.isLetter(c4) || c4 == '_';
    }

    @Nullable
    public String a(boolean z10) {
        int i10 = this.f27742c;
        while (true) {
            int i11 = this.f27742c;
            if (i11 >= this.f27741b || !a(this.f27740a.charAt(i11), z10)) {
                break;
            }
            this.f27742c++;
        }
        if (this.f27742c <= i10 || !b(this.f27740a.charAt(i10))) {
            return null;
        }
        return this.f27740a.substring(i10, this.f27742c);
    }

    public void a(char c4) throws ExprException {
        String str = this.f27740a;
        int i10 = this.f27742c;
        this.f27742c = i10 + 1;
        if (str.charAt(i10) == c4) {
            return;
        }
        throw new ExprException("expecting '" + c4 + "'");
    }

    public static boolean a(char c4, boolean z10) {
        return Character.isLetter(c4) || c4 == '_' || Character.isDigit(c4) || (c4 == '.' && z10);
    }
}
