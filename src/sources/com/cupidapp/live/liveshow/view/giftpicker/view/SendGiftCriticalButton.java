package com.cupidapp.live.liveshow.view.giftpicker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderUtil;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.liveshow.model.GiftItemModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.h0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sun.util.locale.LanguageTag;
import z0.y;
import z0.z;

/* compiled from: SendGiftCriticalButton.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SendGiftCriticalButton extends BaseContinuousSendButton {

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public static final a f15587j = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public Bitmap f15588f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public String f15589g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f15590h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15591i;

    /* compiled from: SendGiftCriticalButton.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendGiftCriticalButton(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15591i = new LinkedHashMap();
        h();
    }

    @Override // com.cupidapp.live.liveshow.view.giftpicker.view.BaseContinuousSendButton
    public void a() {
        super.a();
        this.f15588f = null;
        this.f15589g = null;
        ((FKSVGAImageView) c(R$id.critical_svga_img)).K();
    }

    @Override // com.cupidapp.live.liveshow.view.giftpicker.view.BaseContinuousSendButton
    public void b(@NotNull GiftItemModel gift, final int i10, @Nullable String str) {
        s.i(gift, "gift");
        String url = gift.getImage().getUrl(60);
        if (url == null || url.length() == 0) {
            c mListener = getMListener();
            if (mListener != null) {
                mListener.a();
                return;
            }
            return;
        }
        GiftItemModel giftModel = getGiftModel();
        if (s.d(giftModel != null ? giftModel.getImage() : null, gift.getImage())) {
            if (this.f15590h) {
                this.f15590h = false;
            } else if (getGiftCount() == i10) {
                ((FKSVGAImageView) c(R$id.critical_svga_img)).v(11, true);
            } else {
                i(i10);
            }
        } else {
            ImageLoaderUtil imageLoaderUtil = ImageLoaderUtil.f11832a;
            Context context = getContext();
            s.h(context, "context");
            imageLoaderUtil.b(context, url, true, new Function1<Bitmap, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.SendGiftCriticalButton$showContinuousBtn$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Bitmap bitmap) {
                    invoke2(bitmap);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Bitmap bitmap) {
                    s.i(bitmap, "bitmap");
                    SendGiftCriticalButton.this.f15588f = bitmap;
                    SendGiftCriticalButton.this.i(i10);
                }
            });
        }
        setGiftModel(gift);
        setGiftCount(i10);
        this.f15589g = str;
    }

    @Nullable
    public View c(int i10) {
        Map<Integer, View> map = this.f15591i;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void h() {
        z.a(this, R$layout.send_gift_critical_button, true);
        y.d(this, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.SendGiftCriticalButton$initView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                SendGiftCriticalButton sendGiftCriticalButton;
                c mListener;
                String str;
                SendGiftCriticalButton.this.f15590h = true;
                ((FKSVGAImageView) SendGiftCriticalButton.this.c(R$id.critical_svga_img)).v(0, true);
                GiftItemModel giftModel = SendGiftCriticalButton.this.getGiftModel();
                if (giftModel == null || (mListener = (sendGiftCriticalButton = SendGiftCriticalButton.this).getMListener()) == null) {
                    return;
                }
                int giftCount = sendGiftCriticalButton.getGiftCount();
                str = sendGiftCriticalButton.f15589g;
                mListener.b(giftModel, giftCount, str);
            }
        });
    }

    public final void i(int i10) {
        FKSVGAImageView critical_svga_img = (FKSVGAImageView) c(R$id.critical_svga_img);
        s.h(critical_svga_img, "critical_svga_img");
        Float valueOf = Float.valueOf(24.0f);
        Map d10 = h0.d(kotlin.f.a("amount", LanguageTag.PRIVATEUSE + i10));
        Bitmap bitmap = this.f15588f;
        s.f(bitmap);
        critical_svga_img.G("send_gift_critical_button.svga", (r23 & 2) != 0 ? null : valueOf, (r23 & 4) != 0 ? -1 : -1, (r23 & 8) != 0 ? false : true, (r23 & 16) != 0 ? null : null, (r23 & 32) != 0 ? null : null, (r23 & 64) != 0 ? null : d10, (r23 & 128) != 0 ? null : h0.d(kotlin.f.a("gift", bitmap)), (r23 & 256) == 0 ? 11 : 0, (r23 & 512) != 0 ? null : null, (r23 & 1024) == 0 ? new Function1<Double, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.SendGiftCriticalButton$showAnimation$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Double d11) {
                invoke(d11.doubleValue());
                return p.f51048a;
            }

            public final void invoke(double d11) {
                c mListener;
                if (!(d11 == 1.0d) || (mListener = SendGiftCriticalButton.this.getMListener()) == null) {
                    return;
                }
                mListener.a();
            }
        } : null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendGiftCriticalButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15591i = new LinkedHashMap();
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendGiftCriticalButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15591i = new LinkedHashMap();
        h();
    }
}
