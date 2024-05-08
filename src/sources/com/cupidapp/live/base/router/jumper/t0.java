package com.cupidapp.live.base.router.jumper;

import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.LifecycleOwner;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SuperlikePurchaseUrlJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class t0 implements com.cupidapp.live.base.router.h {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public PurchaseDialogManager f12166b;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable Context context, @NotNull Uri uri, @Nullable String str) {
        kotlin.jvm.internal.s.i(uri, "uri");
        boolean z10 = context instanceof LifecycleOwner;
        if (z10) {
            LifecycleOwner lifecycleOwner = z10 ? (LifecycleOwner) context : null;
            if (lifecycleOwner == null) {
                return;
            }
            if (this.f12166b == null) {
                this.f12166b = new PurchaseDialogManager(context, lifecycleOwner.getLifecycle());
            }
            PurchaseDialogManager purchaseDialogManager = this.f12166b;
            if (purchaseDialogManager != null) {
                purchaseDialogManager.m(VipPurchaseEntranceType.SuperLikeWeb);
            }
        }
    }
}
