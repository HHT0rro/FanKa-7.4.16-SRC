package ke;

/* compiled from: ConverterSet.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final c[] f50887a;

    /* renamed from: b, reason: collision with root package name */
    public a[] f50888b = new a[16];

    /* compiled from: ConverterSet.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Class<?> f50889a;

        /* renamed from: b, reason: collision with root package name */
        public final c f50890b;

        public a(Class<?> cls, c cVar) {
            this.f50889a = cls;
            this.f50890b = cVar;
        }
    }

    public e(c[] cVarArr) {
        this.f50887a = cVarArr;
    }

    public static c c(e eVar, Class<?> cls) {
        c[] cVarArr = eVar.f50887a;
        int length = cVarArr.length;
        int i10 = length;
        while (true) {
            length--;
            if (length < 0) {
                if (cls == null || i10 == 0) {
                    return null;
                }
                if (i10 == 1) {
                    return cVarArr[0];
                }
                int i11 = i10;
                while (true) {
                    i10--;
                    if (i10 < 0) {
                        break;
                    }
                    Class<?> e2 = cVarArr[i10].e();
                    int i12 = i11;
                    while (true) {
                        i11--;
                        if (i11 >= 0) {
                            if (i11 != i10 && cVarArr[i11].e().isAssignableFrom(e2)) {
                                eVar = eVar.a(i11, null);
                                cVarArr = eVar.f50887a;
                                i12 = cVarArr.length;
                                i10 = i12 - 1;
                            }
                        }
                    }
                    i11 = i12;
                }
                if (i11 == 1) {
                    return cVarArr[0];
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to find best converter for type \"");
                sb2.append(cls.getName());
                sb2.append("\" from remaining set: ");
                for (int i13 = 0; i13 < i11; i13++) {
                    c cVar = cVarArr[i13];
                    Class<?> e10 = cVar.e();
                    sb2.append(cVar.getClass().getName());
                    sb2.append('[');
                    sb2.append(e10 == null ? null : e10.getName());
                    sb2.append("], ");
                }
                throw new IllegalStateException(sb2.toString());
            }
            c cVar2 = cVarArr[length];
            Class<?> e11 = cVar2.e();
            if (e11 == cls) {
                return cVar2;
            }
            if (e11 == null || (cls != null && !e11.isAssignableFrom(cls))) {
                eVar = eVar.a(length, null);
                cVarArr = eVar.f50887a;
                i10 = cVarArr.length;
            }
        }
    }

    public e a(int i10, c[] cVarArr) {
        c[] cVarArr2 = this.f50887a;
        int length = cVarArr2.length;
        if (i10 < length) {
            if (cVarArr != null) {
                cVarArr[0] = cVarArr2[i10];
            }
            c[] cVarArr3 = new c[length - 1];
            int i11 = 0;
            for (int i12 = 0; i12 < length; i12++) {
                if (i12 != i10) {
                    cVarArr3[i11] = cVarArr2[i12];
                    i11++;
                }
            }
            return new e(cVarArr3);
        }
        throw new IndexOutOfBoundsException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0052, code lost:
    
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x000e, code lost:
    
        r3 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ke.c b(java.lang.Class<?> r10) throws java.lang.IllegalStateException {
        /*
            r9 = this;
            ke.e$a[] r0 = r9.f50888b
            int r1 = r0.length
            r2 = 0
            if (r10 != 0) goto L7
            goto L1d
        L7:
            int r3 = r10.hashCode()
            int r4 = r1 + (-1)
            r3 = r3 & r4
        Le:
            r4 = r0[r3]
            if (r4 == 0) goto L1f
            java.lang.Class<?> r5 = r4.f50889a
            if (r5 != r10) goto L19
            ke.c r10 = r4.f50890b
            return r10
        L19:
            int r3 = r3 + 1
            if (r3 < r1) goto Le
        L1d:
            r3 = 0
            goto Le
        L1f:
            ke.c r4 = c(r9, r10)
            ke.e$a r5 = new ke.e$a
            r5.<init>(r10, r4)
            java.lang.Object r10 = r0.clone()
            ke.e$a[] r10 = (ke.e.a[]) r10
            r10[r3] = r5
            r0 = 0
        L31:
            if (r0 >= r1) goto L3d
            r3 = r10[r0]
            if (r3 != 0) goto L3a
            r9.f50888b = r10
            return r4
        L3a:
            int r0 = r0 + 1
            goto L31
        L3d:
            int r0 = r1 << 1
            ke.e$a[] r3 = new ke.e.a[r0]
            r5 = 0
        L42:
            if (r5 >= r1) goto L61
            r6 = r10[r5]
            java.lang.Class<?> r7 = r6.f50889a
            if (r7 != 0) goto L4b
            goto L5a
        L4b:
            int r7 = r7.hashCode()
            int r8 = r0 + (-1)
            r7 = r7 & r8
        L52:
            r8 = r3[r7]
            if (r8 == 0) goto L5c
            int r7 = r7 + 1
            if (r7 < r0) goto L52
        L5a:
            r7 = 0
            goto L52
        L5c:
            r3[r7] = r6
            int r5 = r5 + 1
            goto L42
        L61:
            r9.f50888b = r3
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ke.e.b(java.lang.Class):ke.c");
    }

    public int d() {
        return this.f50887a.length;
    }
}
