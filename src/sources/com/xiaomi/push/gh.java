package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class gh extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private m5 f47332a;

    /* renamed from: a, reason: collision with other field name */
    private n5 f287a;

    /* renamed from: a, reason: collision with other field name */
    private Throwable f288a;

    public gh() {
        this.f47332a = null;
        this.f287a = null;
        this.f288a = null;
    }

    public gh(m5 m5Var) {
        this.f287a = null;
        this.f288a = null;
        this.f47332a = m5Var;
    }

    public gh(String str) {
        super(str);
        this.f47332a = null;
        this.f287a = null;
        this.f288a = null;
    }

    public gh(String str, Throwable th) {
        super(str);
        this.f47332a = null;
        this.f287a = null;
        this.f288a = th;
    }

    public gh(Throwable th) {
        this.f47332a = null;
        this.f287a = null;
        this.f288a = th;
    }

    public Throwable a() {
        return this.f288a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        m5 m5Var;
        n5 n5Var;
        String message = super.getMessage();
        return (message != null || (n5Var = this.f287a) == null) ? (message != null || (m5Var = this.f47332a) == null) ? message : m5Var.toString() : n5Var.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f288a != null) {
            printStream.println("Nested Exception: ");
            this.f288a.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f288a != null) {
            printWriter.println("Nested Exception: ");
            this.f288a.printStackTrace(printWriter);
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb2.append(message);
            sb2.append(": ");
        }
        n5 n5Var = this.f287a;
        if (n5Var != null) {
            sb2.append((Object) n5Var);
        }
        m5 m5Var = this.f47332a;
        if (m5Var != null) {
            sb2.append((Object) m5Var);
        }
        if (this.f288a != null) {
            sb2.append("\n  -- caused by: ");
            sb2.append((Object) this.f288a);
        }
        return sb2.toString();
    }
}
