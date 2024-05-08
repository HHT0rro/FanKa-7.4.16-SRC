package java.lang.constant;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface DirectMethodHandleDesc extends MethodHandleDesc {
    boolean isOwnerInterface();

    Kind kind();

    String lookupDescriptor();

    String methodName();

    ClassDesc owner();

    int refKind();

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum Kind {
        STATIC(6),
        INTERFACE_STATIC(6, true),
        VIRTUAL(5),
        INTERFACE_VIRTUAL(9, true),
        SPECIAL(7),
        INTERFACE_SPECIAL(7, true),
        CONSTRUCTOR(8),
        GETTER(1),
        SETTER(3),
        STATIC_GETTER(2),
        STATIC_SETTER(4);

        private static final Kind[] TABLE;
        public final boolean isInterface;
        public final int refKind;

        static {
            int max = 0;
            for (Kind k10 : values()) {
                max = Math.max(max, tableIndex(k10.refKind, true));
            }
            TABLE = new Kind[max + 1];
            for (Kind kind : values()) {
                int i10 = tableIndex(kind.refKind, kind.isInterface);
                Kind[] kindArr = TABLE;
                if (i10 >= kindArr.length || kindArr[i10] != null) {
                    throw new AssertionError((Object) ("TABLE entry for " + ((Object) kind)));
                }
                kindArr[i10] = kind;
            }
            int ii = tableIndex(9, false);
            Kind[] kindArr2 = TABLE;
            if (kindArr2[ii] != null) {
                throw new AssertionError((Object) ("TABLE entry for (invokeInterface, false) used by " + ((Object) kindArr2[ii])));
            }
            kindArr2[ii] = INTERFACE_VIRTUAL;
            for (Kind kind2 : values()) {
                if (!kind2.isInterface) {
                    int i11 = tableIndex(kind2.refKind, true);
                    Kind[] kindArr3 = TABLE;
                    if (kindArr3[i11] == null) {
                        kindArr3[i11] = kind2;
                    }
                }
            }
        }

        Kind(int refKind) {
            this(refKind, false);
        }

        Kind(int refKind, boolean isInterface) {
            this.refKind = refKind;
            this.isInterface = isInterface;
        }

        public static Kind valueOf(int refKind) {
            return valueOf(refKind, refKind == 9);
        }

        public static Kind valueOf(int refKind, boolean isInterface) {
            int i10 = tableIndex(refKind, isInterface);
            if (i10 >= 2) {
                Kind[] kindArr = TABLE;
                if (i10 < kindArr.length) {
                    return kindArr[i10];
                }
            }
            throw new IllegalArgumentException(String.format("refKind=%d isInterface=%s", Integer.valueOf(refKind), Boolean.valueOf(isInterface)));
        }

        private static int tableIndex(int i10, boolean z10) {
            if (i10 < 0) {
                return i10;
            }
            return (i10 * 2) + (z10 ? 1 : 0);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isVirtualMethod() {
            switch (AnonymousClass1.$SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    return true;
                default:
                    return false;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.lang.constant.DirectMethodHandleDesc$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind;

        static {
            int[] iArr = new int[Kind.values().length];
            $SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind = iArr;
            try {
                iArr[Kind.VIRTUAL.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[Kind.SPECIAL.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[Kind.INTERFACE_VIRTUAL.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[Kind.INTERFACE_SPECIAL.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
        }
    }
}
