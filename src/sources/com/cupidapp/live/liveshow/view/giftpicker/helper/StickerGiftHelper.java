package com.cupidapp.live.liveshow.view.giftpicker.helper;

import com.cupidapp.live.base.utils.i;
import com.cupidapp.live.liveshow.model.GiftItemModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: StickerGiftHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class StickerGiftHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final StickerGiftHelper f15469a = new StickerGiftHelper();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final i f15470b = new i();

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final List<Pair<String, Integer>> f15471c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public static boolean f15472d;

    public final void c() {
        final Pair pair = (Pair) CollectionsKt___CollectionsKt.V(f15471c);
        if (pair == null) {
            f15472d = false;
            r2.i.f53231b.I(null);
            return;
        }
        f15472d = true;
        r2.i.f53231b.I((String) pair.getFirst());
        i iVar = f15470b;
        iVar.g();
        i.d(iVar, (Integer) pair.getSecond(), 1, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.helper.StickerGiftHelper$showStickerGift$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List list;
                List list2;
                List list3;
                list = StickerGiftHelper.f15471c;
                if (!list.isEmpty()) {
                    list2 = StickerGiftHelper.f15471c;
                    if (list2.contains(pair)) {
                        list3 = StickerGiftHelper.f15471c;
                        list3.remove(pair);
                    }
                }
                StickerGiftHelper.f15469a.c();
            }
        }, null, 8, null);
    }

    public final void d(@NotNull GiftItemModel gift) {
        s.i(gift, "gift");
        String faceAnimationPath = gift.getFaceAnimationPath();
        Integer faceAnimationDuration = gift.getFaceAnimationDuration();
        int intValue = faceAnimationDuration != null ? faceAnimationDuration.intValue() : 0;
        if ((faceAnimationPath == null || faceAnimationPath.length() == 0) || intValue == 0) {
            return;
        }
        f15471c.add(new Pair<>(faceAnimationPath, Integer.valueOf(intValue)));
        if (f15472d) {
            return;
        }
        c();
    }

    public final void e() {
        f15470b.g();
        f15471c.clear();
        f15472d = false;
    }
}
