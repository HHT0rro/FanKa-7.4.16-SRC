package com.huawei.quickcard.cardmanager.appgallery;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.quickcard.cardmanager.bean.CardBean;
import com.huawei.quickcard.cardmanager.c;
import com.huawei.quickcard.cardmanager.log.ManagerLogUtil;
import com.huawei.quickcard.cardmanager.sha.ShaUtils;
import com.huawei.quickcard.cardmanager.storage.ICardStorageManager;
import com.huawei.quickcard.cardmanager.util.CardUriUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AppGalleryCardRepository implements IAppGalleryCardRepository {

    /* renamed from: b, reason: collision with root package name */
    private static final String f33474b = "AppGalleryCardRepository";

    /* renamed from: a, reason: collision with root package name */
    private final ICardStorageManager f33475a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final Context f33476a;

        public Builder(@NonNull Context context) {
            this.f33476a = context.getApplicationContext();
        }

        public AppGalleryCardRepository build() {
            return new AppGalleryCardRepository(this);
        }
    }

    private CardBean a(CardBean cardBean) {
        CardBean cardBean2 = new CardBean();
        cardBean2.setCardId(cardBean.getCardId());
        cardBean2.setVer(cardBean.getVer());
        cardBean2.setSign(cardBean.getSign());
        cardBean2.setType(cardBean.getType());
        cardBean2.setMinPlatformVersion(cardBean.getMinPlatformVersion());
        return cardBean2;
    }

    @Override // com.huawei.quickcard.cardmanager.appgallery.IAppGalleryCardRepository
    @Nullable
    public String getCardType(@NonNull String str) {
        CardBean parse = CardUriUtils.parse(str);
        if (CardUriUtils.check(parse)) {
            return parse.getType();
        }
        return null;
    }

    @Override // com.huawei.quickcard.cardmanager.appgallery.IAppGalleryCardRepository
    public void setPresetCardStreamProvider(Context context, PresetCardStreamProvider presetCardStreamProvider) {
        PresetCardManager.INST.setPresetCardStreamProvider(context, presetCardStreamProvider);
    }

    @Override // com.huawei.quickcard.cardmanager.appgallery.IAppGalleryCardRepository
    public int storeCard(@NonNull String str, @NonNull String str2) {
        ManagerLogUtil.i(f33474b, "storageCard cardUri: " + str);
        CardBean parse = CardUriUtils.parse(str);
        if (!CardUriUtils.check(parse)) {
            ManagerLogUtil.e(f33474b, "storageCard check uri failed");
            return 1;
        }
        if (TextUtils.isEmpty(str2)) {
            ManagerLogUtil.e(f33474b, "storageCard content is empty");
            return 1;
        }
        CardBean a10 = a(parse);
        a10.setContent(str2);
        a10.setTs(System.currentTimeMillis());
        String sign = a10.getSign();
        String sha256Encrypt = ShaUtils.sha256Encrypt(str2);
        if (!TextUtils.isEmpty(sign) && !sign.equalsIgnoreCase(sha256Encrypt)) {
            ManagerLogUtil.e(f33474b, "card sign check failed");
            return 14;
        }
        a10.setSign(sha256Encrypt);
        this.f33475a.putCard(a10);
        return 0;
    }

    private AppGalleryCardRepository(Builder builder) {
        this.f33475a = new c(builder.f33476a);
    }
}
