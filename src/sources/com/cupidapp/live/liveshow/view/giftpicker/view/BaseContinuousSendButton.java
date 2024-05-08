package com.cupidapp.live.liveshow.view.giftpicker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.cupidapp.live.liveshow.model.GiftItemModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BaseContinuousSendButton.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BaseContinuousSendButton extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public c f15478b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public GiftItemModel f15479c;

    /* renamed from: d, reason: collision with root package name */
    public int f15480d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15481e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseContinuousSendButton(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15481e = new LinkedHashMap();
    }

    public void a() {
        this.f15479c = null;
        this.f15480d = 0;
    }

    public void b(@NotNull GiftItemModel gift, int i10, @Nullable String str) {
        s.i(gift, "gift");
    }

    public final int getGiftCount() {
        return this.f15480d;
    }

    @Nullable
    public final GiftItemModel getGiftModel() {
        return this.f15479c;
    }

    @Nullable
    public final c getMListener() {
        return this.f15478b;
    }

    public final void setContinuousSendListener(@NotNull c listener) {
        s.i(listener, "listener");
        this.f15478b = listener;
    }

    public final void setGiftCount(int i10) {
        this.f15480d = i10;
    }

    public final void setGiftModel(@Nullable GiftItemModel giftItemModel) {
        this.f15479c = giftItemModel;
    }

    public final void setMListener(@Nullable c cVar) {
        this.f15478b = cVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseContinuousSendButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15481e = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseContinuousSendButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15481e = new LinkedHashMap();
    }
}
