package com.cupidapp.live.liveshow.view.giftpicker.helper;

import com.cupidapp.live.base.network.gson.GsonUtil;
import com.cupidapp.live.liveshow.model.GiftModel;
import com.cupidapp.live.liveshow.model.UpgradeGiftModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: LiveUpgradeGiftHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f15473a = new b();

    @NotNull
    public final List<GiftModel> a(@NotNull GiftModel oldGiftModel) {
        s.i(oldGiftModel, "oldGiftModel");
        ArrayList arrayList = new ArrayList();
        String json = GsonUtil.f12000a.b().toJson(oldGiftModel);
        List<UpgradeGiftModel> upgradeGiftList = oldGiftModel.getUpgradeGiftList();
        if (upgradeGiftList != null) {
            for (UpgradeGiftModel upgradeGiftModel : upgradeGiftList) {
                GiftModel newGiftModel = (GiftModel) GsonUtil.f12000a.b().fromJson(json, GiftModel.class);
                newGiftModel.setItemId(upgradeGiftModel.getItemId());
                newGiftModel.setName(upgradeGiftModel.getName());
                newGiftModel.setPrice(upgradeGiftModel.getPrice());
                newGiftModel.setImage(upgradeGiftModel.getImage());
                newGiftModel.setUnlocked(upgradeGiftModel.getUnlocked());
                newGiftModel.setLevel(upgradeGiftModel.getLevel());
                newGiftModel.setLevelIcon(upgradeGiftModel.getLevelIcon());
                newGiftModel.setUpgradeGiftList(null);
                newGiftModel.setGiftTag(null);
                s.h(newGiftModel, "newGiftModel");
                arrayList.add(newGiftModel);
            }
        }
        return arrayList;
    }
}
