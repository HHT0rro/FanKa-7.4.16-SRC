package p8;

import android.content.Context;
import com.google.android.gms.internal.mlkit_vision_face.h9;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class e extends com.google.mlkit.common.sdkinternal.e<o8.d, h> {

    /* renamed from: b, reason: collision with root package name */
    public final com.google.mlkit.common.sdkinternal.i f52948b;

    public e(com.google.mlkit.common.sdkinternal.i iVar) {
        this.f52948b = iVar;
    }

    @Override // com.google.mlkit.common.sdkinternal.e
    public final /* bridge */ /* synthetic */ h a(o8.d dVar) {
        o8.d dVar2 = dVar;
        Context b4 = this.f52948b.b();
        return new h(h9.a(i.b()), dVar2, (a.b(b4) || com.google.android.gms.common.b.f().a(b4) >= 204490000) ? new a(b4, dVar2) : new l(b4, dVar2));
    }
}
