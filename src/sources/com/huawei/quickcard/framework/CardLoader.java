package com.huawei.quickcard.framework;

import android.content.Context;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.base.utils.QuickCardPlatformUtils;
import com.huawei.quickcard.cardmanager.CardRepository;
import com.huawei.quickcard.cardmanager.bean.CardBean;
import com.huawei.quickcard.framework.bean.QuickCardBean;
import com.huawei.quickcard.framework.cache.Caches;
import com.huawei.quickcard.utils.NetworkConnectivityMonitor;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CardLoader {

    /* renamed from: b, reason: collision with root package name */
    private static final String f33731b = "CardLoader";

    /* renamed from: a, reason: collision with root package name */
    private final Context f33732a;

    public CardLoader(Context context) {
        this.f33732a = context;
    }

    private QuickCardBean a(String str) {
        if (!Caches.get().beans().has(str)) {
            CardBean cardBean = new CardRepository.Builder(this.f33732a).build().getCard(str, false).cardBean;
            if (cardBean == null) {
                CardLogUtils.e(f33731b, "get card failed.");
                return null;
            }
            String content = cardBean.getContent();
            QuickCardBean quickCardBean = new QuickCardBean();
            quickCardBean.setMinPLatFormVer(QuickCardPlatformUtils.readPlatformVerFromUrl(str));
            CardJsonParser cardJsonParser = new CardJsonParser();
            cardJsonParser.setCtx(this.f33732a);
            if (!cardJsonParser.parse(content, quickCardBean)) {
                CardLogUtils.e(f33731b, "card content parse failed.");
                return null;
            }
            Caches.get().beans().put(str, quickCardBean);
            return quickCardBean;
        }
        return Caches.get().beans().get(str);
    }

    public boolean hasLoaded(String str) {
        return str != null && Caches.get().beans().has(str);
    }

    public boolean load(String str) {
        NetworkConnectivityMonitor.getInstance().registerGlobalListener(this.f33732a);
        QuickCardBean a10 = a(str);
        return (a10 == null || a10.getCard() == null) ? false : true;
    }
}
