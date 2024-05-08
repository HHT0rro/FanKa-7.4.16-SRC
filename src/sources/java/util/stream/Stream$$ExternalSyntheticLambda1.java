package java.util.stream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* compiled from: D8$$SyntheticClass */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final /* synthetic */ class Stream$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ Stream f$0;

    public /* synthetic */ Stream$$ExternalSyntheticLambda1(Stream stream) {
        this.f$0 = stream;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.close();
    }
}
