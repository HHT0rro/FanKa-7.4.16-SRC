package kotlin.jvm.internal;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class FunctionReferenceImpl extends FunctionReference {
    public FunctionReferenceImpl(int i10, kotlin.reflect.d dVar, String str, String str2) {
        super(i10, CallableReference.NO_RECEIVER, ((l) dVar).a(), str, str2, !(dVar instanceof kotlin.reflect.c) ? 1 : 0);
    }

    public FunctionReferenceImpl(int i10, Class cls, String str, String str2, int i11) {
        super(i10, CallableReference.NO_RECEIVER, cls, str, str2, i11);
    }

    public FunctionReferenceImpl(int i10, Object obj, Class cls, String str, String str2, int i11) {
        super(i10, obj, cls, str, str2, i11);
    }
}
