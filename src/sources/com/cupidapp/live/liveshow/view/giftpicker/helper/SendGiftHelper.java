package com.cupidapp.live.liveshow.view.giftpicker.helper;

import android.content.Context;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.RequestErrorCode;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.g;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.j;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.constants.FKLiveType;
import com.cupidapp.live.liveshow.model.GiftItemModel;
import com.cupidapp.live.liveshow.model.GiftModel;
import com.cupidapp.live.liveshow.model.GiftRushType;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.ParcelItemModel;
import com.cupidapp.live.liveshow.model.SendGiftResult;
import com.cupidapp.live.liveshow.view.comment.LiveCommentGuideHelper;
import com.cupidapp.live.liveshow.view.giftpicker.fragment.OpenDiamondBalanceEvent;
import com.cupidapp.live.profile.model.User;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.t;

/* compiled from: SendGiftHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SendGiftHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public AtomicInteger f15466a = new AtomicInteger((int) (Math.random() * 10000));

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public GiftItemModel f15467b;

    /* renamed from: c, reason: collision with root package name */
    public int f15468c;

    public static /* synthetic */ void f(SendGiftHelper sendGiftHelper, GiftItemModel giftItemModel, boolean z10, int i10, Integer num, String str, int i11, Object obj) {
        boolean z11 = (i11 & 2) != 0 ? false : z10;
        int i12 = (i11 & 4) != 0 ? 1 : i10;
        if ((i11 & 16) != 0) {
            str = null;
        }
        sendGiftHelper.e(giftItemModel, z11, i12, num, str);
    }

    public final void c() {
        this.f15468c = 0;
        this.f15467b = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(@Nullable Context context, @NotNull final GiftItemModel gift, @Nullable final String str, final int i10, @Nullable final String str2, @NotNull final c listener) {
        String itemId;
        User X;
        String userId;
        s.i(gift, "gift");
        s.i(listener, "listener");
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null) {
            return;
        }
        String itemId2 = gift.getItemId();
        GiftItemModel giftItemModel = this.f15467b;
        boolean d10 = s.d(itemId2, giftItemModel != null ? giftItemModel.getItemId() : null);
        if (!d10) {
            c();
            listener.b();
        }
        final boolean z10 = true;
        boolean z11 = d10 && gift.getRushEnable();
        AtomicInteger atomicInteger = this.f15466a;
        int incrementAndGet = z11 ? atomicInteger.get() : atomicInteger.incrementAndGet();
        if (!s.d(gift.getRushType(), GiftRushType.Lucky.getType()) ? str != null || !gift.getRushEnable() || i10 != 1 : str != null || !gift.getRushEnable()) {
            z10 = false;
        }
        int i11 = z10 ? this.f15468c + i10 : 0;
        this.f15468c = i11;
        final Integer valueOf = i11 > 0 ? Integer.valueOf(i11) : null;
        if (gift instanceof GiftModel) {
            Observable<Result<SendGiftResult>> w3 = NetworkClient.f11868a.r().w(itemId, gift.getItemId(), Integer.valueOf(incrementAndGet), z11, str, i10, valueOf, ((GiftModel) gift).getLevel());
            Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.helper.SendGiftHelper$sendGiftToLiveShow$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    s.i(it, "it");
                    SendGiftHelper.this.c();
                    String a10 = j.f12008a.a(it);
                    boolean z12 = false;
                    if (a10 != null && t.q(a10) == RequestErrorCode.InsufficientBalance.getValue()) {
                        z12 = true;
                    }
                    if (z12) {
                        listener.b();
                        EventBus.c().l(new OpenDiamondBalanceEvent());
                        return Boolean.TRUE;
                    }
                    listener.b();
                    return Boolean.FALSE;
                }
            };
            g gVar = context instanceof g ? (g) context : null;
            Disposable disposed = w3.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<SendGiftResult, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.helper.SendGiftHelper$sendGiftToLiveShow$$inlined$handleByContext$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(SendGiftResult sendGiftResult) {
                    m2646invoke(sendGiftResult);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2646invoke(SendGiftResult sendGiftResult) {
                    p1.g.f52734a.W1(sendGiftResult.getBalance());
                    LiveCommentGuideHelper liveCommentGuideHelper = LiveCommentGuideHelper.f15387a;
                    liveCommentGuideHelper.i(liveCommentGuideHelper.e() + i10);
                    if (z10) {
                        this.f15467b = gift;
                        listener.a(str2);
                    }
                    this.e(gift, str != null, i10, valueOf, str2);
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(function1, gVar)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                if (gVar != null) {
                    gVar.H(disposed);
                }
            }
            s.h(disposed, "disposed");
            return;
        }
        if (!(gift instanceof ParcelItemModel) || (X = p1.g.f52734a.X()) == null || (userId = X.userId()) == null) {
            return;
        }
        Observable<Result<Object>> n10 = NetworkClient.f11868a.r().n(itemId, userId, gift.getItemId(), i10, Integer.valueOf(incrementAndGet), z11, valueOf);
        Function1<Throwable, Boolean> function12 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.helper.SendGiftHelper$sendGiftToLiveShow$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                SendGiftHelper.this.c();
                listener.b();
                return Boolean.FALSE;
            }
        };
        g gVar2 = context instanceof g ? (g) context : null;
        Observable observeOn = n10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread());
        final boolean z12 = z10;
        final Integer num = valueOf;
        Disposable disposed2 = observeOn.subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.helper.SendGiftHelper$sendGiftToLiveShow$$inlined$handleByContext$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                if (z12) {
                    this.f15467b = gift;
                    listener.a(null);
                }
                SendGiftHelper.f(this, gift, false, i10, num, null, 16, null);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(function12, gVar2)));
        if (disposed2 != null) {
            s.h(disposed2, "disposed");
            if (gVar2 != null) {
                gVar2.H(disposed2);
            }
        }
        s.h(disposed2, "disposed");
    }

    public final void e(GiftItemModel giftItemModel, boolean z10, int i10, Integer num, String str) {
        Integer num2;
        int i11;
        int price;
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
        if (liveShowModel == null) {
            return;
        }
        if (giftItemModel instanceof GiftModel) {
            GiftModel giftModel = (GiftModel) giftItemModel;
            if (giftModel.getFreeChance() <= 0) {
                if (z10) {
                    Integer discountPrice = giftModel.getDiscountPrice();
                    if (discountPrice != null) {
                        price = discountPrice.intValue();
                    }
                } else {
                    price = giftItemModel.getPrice();
                }
                num2 = giftModel.getLevel();
                i11 = price;
            }
            price = 0;
            num2 = giftModel.getLevel();
            i11 = price;
        } else {
            boolean z11 = giftItemModel instanceof ParcelItemModel;
            num2 = null;
            i11 = 0;
        }
        fKLiveConstantsData.setTotalDiamondCount(fKLiveConstantsData.getTotalDiamondCount() + (i11 * i10));
        Integer rushAnimationTriggerThreshold = giftItemModel.getRushAnimationTriggerThreshold();
        int intValue = rushAnimationTriggerThreshold != null ? rushAnimationTriggerThreshold.intValue() : 0;
        SensorsLogLiveShow sensorsLogLiveShow = SensorsLogLiveShow.f12212a;
        String itemId = liveShowModel.getItemId();
        String userId = liveShowModel.getUser().userId();
        String itemId2 = giftItemModel.getItemId();
        FKLiveType fkLiveType = fKLiveConstantsData.getFkLiveType();
        Integer rushAnimationTriggerThreshold2 = giftItemModel.getRushAnimationTriggerThreshold();
        sensorsLogLiveShow.a(itemId, userId, i11, i10, itemId2, fkLiveType, num, num != null && num.intValue() == (rushAnimationTriggerThreshold2 != null ? rushAnimationTriggerThreshold2.intValue() : 0), num2, intValue, str);
    }
}
