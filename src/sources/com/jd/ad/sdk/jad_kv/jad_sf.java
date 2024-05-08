package com.jd.ad.sdk.jad_kv;

import androidx.annotation.Nullable;
import com.jd.ad.sdk.logger.Logger;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_sf extends Exception {
    public static final StackTraceElement[] jad_fs = new StackTraceElement[0];
    public final List<Throwable> jad_an;
    public com.jd.ad.sdk.jad_hs.jad_hu jad_bo;
    public com.jd.ad.sdk.jad_hs.jad_an jad_cp;
    public Class<?> jad_dq;
    public String jad_er;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class jad_an implements Appendable {
        public final Appendable jad_an;
        public boolean jad_bo = true;

        public jad_an(Appendable appendable) {
            this.jad_an = appendable;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c4) {
            if (this.jad_bo) {
                this.jad_bo = false;
                this.jad_an.append("  ");
            }
            this.jad_bo = c4 == '\n';
            this.jad_an.append(c4);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(@Nullable CharSequence charSequence) {
            if (charSequence == null) {
                charSequence = "";
            }
            return append(charSequence, 0, charSequence.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(@Nullable CharSequence charSequence, int i10, int i11) {
            if (charSequence == null) {
                charSequence = "";
            }
            boolean z10 = false;
            if (this.jad_bo) {
                this.jad_bo = false;
                this.jad_an.append("  ");
            }
            if (charSequence.length() > 0 && charSequence.charAt(i11 - 1) == '\n') {
                z10 = true;
            }
            this.jad_bo = z10;
            this.jad_an.append(charSequence, i10, i11);
            return this;
        }
    }

    public jad_sf(String str, List<Throwable> list) {
        this.jad_er = str;
        setStackTrace(jad_fs);
        this.jad_an = list;
    }

    public static void jad_an(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    public static void jad_an(List<Throwable> list, Appendable appendable) {
        try {
            jad_bo(list, appendable);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void jad_bo(List<Throwable> list, Appendable appendable) {
        int size = list.size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            appendable.append("Cause (").append(String.valueOf(i11)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i10);
            if (th instanceof jad_sf) {
                ((jad_sf) th).jad_an(appendable);
            } else {
                jad_an(th, appendable);
            }
            i10 = i11;
        }
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String str;
        String str2;
        String str3;
        StringBuilder sb2 = new StringBuilder(71);
        sb2.append(this.jad_er);
        String str4 = "";
        if (this.jad_dq != null) {
            StringBuilder jad_an2 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an(", ");
            jad_an2.append((Object) this.jad_dq);
            str = jad_an2.toString();
        } else {
            str = "";
        }
        sb2.append(str);
        if (this.jad_cp != null) {
            StringBuilder jad_an3 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an(", ");
            jad_an3.append((Object) this.jad_cp);
            str2 = jad_an3.toString();
        } else {
            str2 = "";
        }
        sb2.append(str2);
        if (this.jad_bo != null) {
            StringBuilder jad_an4 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an(", ");
            jad_an4.append((Object) this.jad_bo);
            str4 = jad_an4.toString();
        }
        sb2.append(str4);
        ArrayList arrayList = new ArrayList();
        jad_an(this, arrayList);
        if (arrayList.isEmpty()) {
            return sb2.toString();
        }
        if (arrayList.size() == 1) {
            str3 = "\nThere was 1 root cause:";
        } else {
            sb2.append("\nThere were ");
            sb2.append(arrayList.size());
            str3 = " root causes:";
        }
        sb2.append(str3);
        Iterator iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            Throwable th = (Throwable) iterator2.next();
            sb2.append('\n');
            sb2.append(th.getClass().getName());
            sb2.append('(');
            sb2.append(th.getMessage());
            sb2.append(')');
        }
        sb2.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb2.toString();
    }

    public final void jad_an(Throwable th, List<Throwable> list) {
        if (!(th instanceof jad_sf)) {
            list.add(th);
            return;
        }
        Iterator<Throwable> iterator2 = ((jad_sf) th).jad_an.iterator2();
        while (iterator2.hasNext()) {
            jad_an(iterator2.next(), list);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        jad_an(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        jad_an(printStream);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        jad_an(printWriter);
    }

    public void jad_an(String str) {
        ArrayList arrayList = new ArrayList();
        jad_an(this, arrayList);
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            StringBuilder jad_an2 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Root cause (");
            int i11 = i10 + 1;
            jad_an2.append(i11);
            jad_an2.append(" of ");
            jad_an2.append(size);
            jad_an2.append(")");
            Logger.i(str, jad_an2.toString(), arrayList.get(i10));
            i10 = i11;
        }
    }

    public final void jad_an(Appendable appendable) {
        jad_an(this, appendable);
        jad_an(this.jad_an, new jad_an(appendable));
    }
}
