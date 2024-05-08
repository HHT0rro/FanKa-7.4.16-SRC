package com.huawei.flexiblelayout.common;

import com.huawei.flexiblelayout.FLConfig;
import com.huawei.flexiblelayout.parser.CardProvider;
import com.huawei.flexiblelayout.parser.DataKeys;
import java.util.List;

/* compiled from: DefaultConfig.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a extends FLConfig {

    /* renamed from: a, reason: collision with root package name */
    private DataKeys f27923a;

    /* renamed from: b, reason: collision with root package name */
    private List<CardProvider> f27924b;

    @Override // com.huawei.flexiblelayout.FLConfig
    public DataKeys getBindFieldAlias() {
        return this.f27923a;
    }

    @Override // com.huawei.flexiblelayout.FLConfig
    public List<CardProvider> getCardProvider() {
        return this.f27924b;
    }

    @Override // com.huawei.flexiblelayout.FLConfig
    public FLConfig setBindFieldAlias(DataKeys dataKeys) {
        this.f27923a = dataKeys;
        return this;
    }

    @Override // com.huawei.flexiblelayout.FLConfig
    public FLConfig setCardProvider(List<CardProvider> list) {
        this.f27924b = list;
        return this;
    }
}
