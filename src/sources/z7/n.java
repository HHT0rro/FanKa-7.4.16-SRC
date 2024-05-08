package z7;

import com.google.firebase.events.Event;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final /* synthetic */ class n implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final Map.Entry f55010b;

    /* renamed from: c, reason: collision with root package name */
    public final Event f55011c;

    public n(Map.Entry entry, Event event) {
        this.f55010b = entry;
        this.f55011c = event;
    }

    public static Runnable a(Map.Entry entry, Event event) {
        return new n(entry, event);
    }

    @Override // java.lang.Runnable
    public void run() {
        ((d8.a) this.f55010b.getKey()).a(this.f55011c);
    }
}
