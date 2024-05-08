package java.lang.invoke;

import sun.invoke.util.Wrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class MethodTypeForm {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int ERASE = 1;
    public static final int INTS = 4;
    public static final int LONGS = 5;
    public static final int NO_CHANGE = 0;
    public static final int RAW_RETURN = 6;
    public static final int UNWRAP = 3;
    public static final int WRAP = 2;
    final long argCounts;
    final int[] argToSlotTable;
    final MethodType basicType;
    final MethodType erasedType;
    final long primCounts;
    final int[] slotToArgTable;

    public MethodType erasedType() {
        return this.erasedType;
    }

    public MethodType basicType() {
        return this.basicType;
    }

    private boolean assertIsBasicType() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected MethodTypeForm(java.lang.invoke.MethodType r22) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.invoke.MethodTypeForm.<init>(java.lang.invoke.MethodType):void");
    }

    private static long pack(int a10, int b4, int c4, int d10) {
        long hw = (a10 << 16) | b4;
        long lw = (c4 << 16) | d10;
        return (hw << 32) | lw;
    }

    private static char unpack(long packed, int word) {
        return (char) (packed >> ((3 - word) * 16));
    }

    public int parameterCount() {
        return unpack(this.argCounts, 3);
    }

    public int parameterSlotCount() {
        return unpack(this.argCounts, 2);
    }

    public int returnCount() {
        return unpack(this.argCounts, 1);
    }

    public int returnSlotCount() {
        return unpack(this.argCounts, 0);
    }

    public int primitiveParameterCount() {
        return unpack(this.primCounts, 3);
    }

    public int longPrimitiveParameterCount() {
        return unpack(this.primCounts, 2);
    }

    public int primitiveReturnCount() {
        return unpack(this.primCounts, 1);
    }

    public int longPrimitiveReturnCount() {
        return unpack(this.primCounts, 0);
    }

    public boolean hasPrimitives() {
        return this.primCounts != 0;
    }

    public boolean hasNonVoidPrimitives() {
        if (this.primCounts == 0) {
            return false;
        }
        if (primitiveParameterCount() != 0) {
            return true;
        }
        return (primitiveReturnCount() == 0 || returnCount() == 0) ? false : true;
    }

    public boolean hasLongPrimitives() {
        return (longPrimitiveParameterCount() | longPrimitiveReturnCount()) != 0;
    }

    public int parameterToArgSlot(int i10) {
        return this.argToSlotTable[i10 + 1];
    }

    public int argSlotToParameter(int argSlot) {
        return this.slotToArgTable[argSlot] - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MethodTypeForm findForm(MethodType mt) {
        MethodType erased = canonicalize(mt, 1, 1);
        if (erased == null) {
            return new MethodTypeForm(mt);
        }
        return erased.form();
    }

    public static MethodType canonicalize(MethodType mt, int howRet, int howArgs) {
        Class<?>[] ptypes = mt.ptypes();
        Class<?>[] ptc = canonicalizeAll(ptypes, howArgs);
        Class<?> rtype = mt.returnType();
        Class<?> rtc = canonicalize(rtype, howRet);
        if (ptc == null && rtc == null) {
            return null;
        }
        if (rtc == null) {
            rtc = rtype;
        }
        if (ptc == null) {
            ptc = ptypes;
        }
        return MethodType.makeImpl(rtc, ptc, true);
    }

    static Class<?> canonicalize(Class<?> t2, int how) {
        if (t2 != Object.class) {
            if (!t2.isPrimitive()) {
                switch (how) {
                    case 1:
                    case 6:
                        return Object.class;
                    case 3:
                        Class<?> ct = Wrapper.asPrimitiveType(t2);
                        if (ct != t2) {
                            return ct;
                        }
                    default:
                        return null;
                }
            } else {
                if (t2 == Void.TYPE) {
                    switch (how) {
                        case 2:
                            return Void.class;
                        case 6:
                            return Integer.TYPE;
                    }
                }
                switch (how) {
                    case 2:
                        return Wrapper.asWrapperType(t2);
                    case 4:
                        if (t2 == Integer.TYPE || t2 == Long.TYPE) {
                            return null;
                        }
                        if (t2 == Double.TYPE) {
                            return Long.TYPE;
                        }
                        return Integer.TYPE;
                    case 5:
                        if (t2 == Long.TYPE) {
                            return null;
                        }
                        return Long.TYPE;
                    case 6:
                        if (t2 == Integer.TYPE || t2 == Long.TYPE || t2 == Float.TYPE || t2 == Double.TYPE) {
                            return null;
                        }
                        return Integer.TYPE;
                }
            }
        }
        return null;
    }

    static Class<?>[] canonicalizeAll(Class<?>[] ts, int how) {
        Class<?>[] cs = null;
        int imax = ts.length;
        for (int i10 = 0; i10 < imax; i10++) {
            Class<?> c4 = canonicalize(ts[i10], how);
            if (c4 == Void.TYPE) {
                c4 = null;
            }
            if (c4 != null) {
                if (cs == null) {
                    cs = (Class[]) ts.clone();
                }
                cs[i10] = c4;
            }
        }
        return cs;
    }

    public String toString() {
        return "Form" + ((Object) this.erasedType);
    }
}
