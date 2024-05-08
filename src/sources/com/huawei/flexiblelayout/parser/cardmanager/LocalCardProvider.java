package com.huawei.flexiblelayout.parser.cardmanager;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.creator.FLResolverRegistry;
import com.huawei.flexiblelayout.parser.CardProvider;
import com.huawei.flexiblelayout.parser.ParseException;
import com.huawei.flexiblelayout.parser.cardmanager.CardInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class LocalCardProvider implements CardProvider.ILocalCardProvider {

    /* renamed from: b, reason: collision with root package name */
    private static volatile LocalCardProvider f28320b;

    /* renamed from: a, reason: collision with root package name */
    private final b f28321a;

    private LocalCardProvider(@NonNull FLEngine fLEngine) {
        this.f28321a = new b(fLEngine);
    }

    public static LocalCardProvider getInstance(FLEngine fLEngine) {
        if (f28320b == null) {
            synchronized (LocalCardProvider.class) {
                if (f28320b == null) {
                    f28320b = new LocalCardProvider(fLEngine);
                }
            }
        }
        return f28320b;
    }

    public LocalCardProvider add(@NonNull String str) throws ParseException {
        this.f28321a.b(str);
        return this;
    }

    @Override // com.huawei.flexiblelayout.parser.CardProvider.ILocalCardProvider
    public CardInfo loadCard(@NonNull String str) {
        if (FLResolverRegistry.isDefinedNodeSpec(str)) {
            return new CardInfo.Builder().setName(str).setType("combo").build();
        }
        return this.f28321a.a(str);
    }

    @Override // com.huawei.flexiblelayout.parser.CardProvider
    @NonNull
    public String[] schemes() {
        return new String[0];
    }

    public LocalCardProvider add(@NonNull String str, @NonNull String str2) throws ParseException {
        this.f28321a.a(str, str2);
        return this;
    }
}
