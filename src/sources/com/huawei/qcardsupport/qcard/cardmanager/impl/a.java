package com.huawei.qcardsupport.qcard.cardmanager.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.quickcard.framework.CardLoader;

/* compiled from: CardLoaderProxy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static final String f33198b = "CardLoaderProxy";

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final CardLoader f33199a;

    public a(@NonNull Context context) {
        this.f33199a = a(context);
    }

    private CardLoader a(Context context) {
        try {
            return new CardLoader(context);
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }

    public boolean b(String str) {
        CardLoader cardLoader = this.f33199a;
        if (cardLoader != null) {
            return cardLoader.load(str);
        }
        Log.e(f33198b, "May not be imported 'quickcard:core'.");
        return false;
    }

    public boolean a(String str) {
        CardLoader cardLoader = this.f33199a;
        if (cardLoader != null) {
            return cardLoader.hasLoaded(str);
        }
        Log.e(f33198b, "May not be imported 'quickcard:core'.");
        return false;
    }
}
