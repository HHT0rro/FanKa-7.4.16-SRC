package q4;

/* compiled from: Retries.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b {
    public static <TInput, TResult, TException extends Throwable> TResult a(int i10, TInput tinput, a<TInput, TResult, TException> aVar, c<TInput, TResult> cVar) throws Throwable {
        TResult apply;
        if (i10 < 1) {
            return aVar.apply(tinput);
        }
        do {
            apply = aVar.apply(tinput);
            tinput = cVar.a(tinput, apply);
            if (tinput == null) {
                break;
            }
            i10--;
        } while (i10 >= 1);
        return apply;
    }
}
