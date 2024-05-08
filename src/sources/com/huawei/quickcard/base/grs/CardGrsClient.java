package com.huawei.quickcard.base.grs;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CardGrsClient {

    /* renamed from: a, reason: collision with root package name */
    private final Context f33328a;

    /* renamed from: b, reason: collision with root package name */
    private final GrsBaseInfo f33329b;

    /* renamed from: c, reason: collision with root package name */
    private GrsClient f33330c;

    public CardGrsClient(@NonNull Context context, @Nullable String str) {
        this.f33328a = context.getApplicationContext();
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo(context);
        this.f33329b = grsBaseInfo;
        grsBaseInfo.setSerCountry(str);
        this.f33330c = new GrsClient(context, grsBaseInfo);
    }

    public GrsClient getGrsClient() {
        return this.f33330c;
    }

    public void updateSerCountry(String str) {
        this.f33329b.setSerCountry(str);
        this.f33330c = new GrsClient(this.f33328a, this.f33329b);
    }
}
