package com.huawei.flexiblelayout.creator;

import com.huawei.flexiblelayout.card.FLCell;
import com.huawei.flexiblelayout.common.b;
import com.huawei.flexiblelayout.data.FLCardData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CardResolver {

    /* renamed from: a, reason: collision with root package name */
    private final CardClassHolder f27931a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class CardClassHolderImpl extends CardClassHolder {

        /* renamed from: a, reason: collision with root package name */
        private String f27932a;

        /* renamed from: b, reason: collision with root package name */
        private Class f27933b;

        /* renamed from: c, reason: collision with root package name */
        private Class f27934c;

        public CardClassHolderImpl(String str, Class cls) {
            this.f27932a = str;
            this.f27933b = cls;
        }

        @Override // com.huawei.flexiblelayout.creator.CardClassHolder
        public Class<?> getCardClazz() {
            return this.f27933b;
        }

        @Override // com.huawei.flexiblelayout.creator.CardClassHolder
        public Class<?> getDataClazz() {
            if (this.f27934c == null) {
                this.f27934c = b.a(this.f27933b);
            }
            return this.f27934c;
        }

        @Override // com.huawei.flexiblelayout.creator.CardClassHolder
        public String getName() {
            return this.f27932a;
        }
    }

    public CardResolver(String str, Class<? extends FLCell> cls) {
        this.f27931a = new CardClassHolderImpl(str, cls);
    }

    public <T extends FLCell> T create() {
        Class<?> cardClazz = this.f27931a.getCardClazz();
        if (cardClazz == null) {
            return null;
        }
        return (T) ObjectCreator.create(cardClazz);
    }

    public <T extends FLCardData> T createData() {
        Class<?> dataClazz = this.f27931a.getDataClazz();
        if (dataClazz == null) {
            dataClazz = FLCardData.class;
        }
        return (T) ObjectCreator.create(dataClazz, this.f27931a.getName());
    }

    public CardResolver(CardClassHolder cardClassHolder) {
        this.f27931a = cardClassHolder;
    }
}
