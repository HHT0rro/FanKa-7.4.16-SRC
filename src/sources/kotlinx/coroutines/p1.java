package kotlinx.coroutines;

import org.jetbrains.annotations.Nullable;

/* compiled from: JobSupport.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class p1 extends u1 implements v {

    /* renamed from: c, reason: collision with root package name */
    public final boolean f51454c;

    public p1(@Nullable n1 n1Var) {
        super(true);
        g0(n1Var);
        this.f51454c = I0();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
    
        r0 = r0.c0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
    
        if ((r0 instanceof kotlinx.coroutines.s) == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
    
        r0 = (kotlinx.coroutines.s) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
    
        if (r0 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
    
        r0 = r0.Q();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r0 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002a, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x001d, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
    
        if (r0 != null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        if (r0.Z() == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean I0() {
        /*
            r4 = this;
            kotlinx.coroutines.r r0 = r4.c0()
            boolean r1 = r0 instanceof kotlinx.coroutines.s
            r2 = 0
            if (r1 == 0) goto Lc
            kotlinx.coroutines.s r0 = (kotlinx.coroutines.s) r0
            goto Ld
        Lc:
            r0 = r2
        Ld:
            r1 = 0
            if (r0 == 0) goto L33
            kotlinx.coroutines.u1 r0 = r0.Q()
            if (r0 != 0) goto L17
            goto L33
        L17:
            boolean r3 = r0.Z()
            if (r3 == 0) goto L1f
            r0 = 1
            return r0
        L1f:
            kotlinx.coroutines.r r0 = r0.c0()
            boolean r3 = r0 instanceof kotlinx.coroutines.s
            if (r3 == 0) goto L2a
            kotlinx.coroutines.s r0 = (kotlinx.coroutines.s) r0
            goto L2b
        L2a:
            r0 = r2
        L2b:
            if (r0 == 0) goto L33
            kotlinx.coroutines.u1 r0 = r0.Q()
            if (r0 != 0) goto L17
        L33:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.p1.I0():boolean");
    }

    @Override // kotlinx.coroutines.u1
    public boolean Z() {
        return this.f51454c;
    }

    @Override // kotlinx.coroutines.u1
    public boolean a0() {
        return true;
    }
}
