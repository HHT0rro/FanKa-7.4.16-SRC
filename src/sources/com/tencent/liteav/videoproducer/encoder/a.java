package com.tencent.liteav.videoproducer.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final EncodeAbilityProvider f44495a;

    private a(EncodeAbilityProvider encodeAbilityProvider) {
        this.f44495a = encodeAbilityProvider;
    }

    public static Runnable a(EncodeAbilityProvider encodeAbilityProvider) {
        return new a(encodeAbilityProvider);
    }

    @Override // java.lang.Runnable
    public final void run() {
        EncodeAbilityProvider.lambda$new$0(this.f44495a);
    }
}
