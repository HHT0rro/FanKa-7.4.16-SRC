package com.huawei.flexiblelayout;

import com.huawei.flexiblelayout.parser.expr.ExprException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Parser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class s0 {

    /* renamed from: d, reason: collision with root package name */
    private static final String f28440d = "{{";

    /* renamed from: e, reason: collision with root package name */
    private static final String f28441e = "}}";

    /* renamed from: a, reason: collision with root package name */
    public String f28442a;

    /* renamed from: b, reason: collision with root package name */
    public int f28443b;

    /* renamed from: c, reason: collision with root package name */
    public int f28444c = 0;

    public s0(String str) {
        this.f28442a = str;
        this.f28443b = str.length();
    }

    public static String a(int i10) {
        return "at " + (i10 + 1);
    }

    public static boolean d(char c4) {
        return Character.isWhitespace(c4);
    }

    public static boolean e(char c4) {
        return Character.isLetter(c4) || c4 == '_' || Character.isDigit(c4);
    }

    public static boolean f(char c4) {
        return Character.isLetter(c4) || c4 == '_';
    }

    public static boolean g(char c4) {
        return Character.isDigit(c4) || c4 == '.';
    }

    public static boolean h(char c4) {
        return Character.isDigit(c4);
    }

    public void b() throws ExprException {
        a(f28440d);
    }

    public boolean c(char c4) {
        if (this.f28442a.charAt(this.f28444c) != c4) {
            return false;
        }
        this.f28444c++;
        return true;
    }

    public void a(char c4) throws ExprException {
        e();
        int i10 = this.f28444c;
        if (c(c4)) {
            return;
        }
        throw new ExprException("Not found character '" + c4 + "', " + a(i10) + ".");
    }

    public boolean b(char c4) throws ExprException {
        e();
        return c(c4);
    }

    public Number d() throws ExprException {
        int i10 = this.f28444c;
        this.f28444c = i10 + 1;
        while (true) {
            int i11 = this.f28444c;
            if (i11 >= this.f28443b) {
                break;
            }
            if (g(this.f28442a.charAt(i11))) {
                this.f28444c++;
            } else if (this.f28444c > i10 && h(this.f28442a.charAt(i10))) {
                Number a10 = y0.a(this.f28442a.substring(i10, this.f28444c));
                if (a10 != null) {
                    return a10;
                }
            }
        }
        throw new ExprException("Invalid number character '" + this.f28442a.charAt(i10) + "', " + a(i10) + ".");
    }

    public void e() throws ExprException {
        while (true) {
            int i10 = this.f28444c;
            if (i10 >= this.f28443b || !d(this.f28442a.charAt(i10))) {
                break;
            } else {
                this.f28444c++;
            }
        }
        if (this.f28444c >= this.f28443b) {
            throw new ExprException("Unexpected end.");
        }
    }

    public boolean c(String str) {
        int i10 = this.f28444c;
        for (int i11 = 0; i11 < str.length(); i11++) {
            if (this.f28442a.charAt(i10) != str.charAt(i11)) {
                return false;
            }
            i10++;
        }
        this.f28444c += str.length();
        return true;
    }

    public boolean b(String str) throws ExprException {
        e();
        return c(str);
    }

    public void a(String str) throws ExprException {
        e();
        int i10 = this.f28444c;
        for (int i11 = 0; i11 < str.length(); i11++) {
            if (!c(str.charAt(i11))) {
                throw new ExprException("Not found string '" + str + "', " + a(i10) + ".");
            }
        }
    }

    public String c() throws ExprException {
        int i10 = this.f28444c;
        if (i10 >= this.f28443b) {
            throw new ExprException("Unexpected end.");
        }
        while (true) {
            int i11 = this.f28444c;
            if (i11 < this.f28443b) {
                if (e(this.f28442a.charAt(i11))) {
                    this.f28444c++;
                } else if (this.f28444c > i10 && f(this.f28442a.charAt(i10))) {
                    return this.f28442a.substring(i10, this.f28444c);
                }
            } else {
                throw new ExprException("Invalid identifier character '" + this.f28442a.charAt(i10) + "', " + a(i10) + ".");
            }
        }
    }

    public void a() throws ExprException {
        a(f28441e);
    }
}
