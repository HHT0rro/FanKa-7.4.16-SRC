package com.cupidapp.live.feed.layout;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.feed.model.CustomTag;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.hashtag.model.HashTag;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Ref$IntRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FeedTagLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedTagLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Lazy f14487b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14488c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedTagLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14488c = new LinkedHashMap();
        this.f14487b = kotlin.c.b(FeedTagLayout$bgShape$2.INSTANCE);
        d();
    }

    public static final void e(FeedTagLayout this$0, Ref$IntRef residueWidth, int i10, Ref$IntRef leftMargin, int i11, Ref$IntRef topMargin) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.i(residueWidth, "$residueWidth");
        kotlin.jvm.internal.s.i(leftMargin, "$leftMargin");
        kotlin.jvm.internal.s.i(topMargin, "$topMargin");
        int i12 = R$id.hashTagNameTextView;
        int width = ((TextView) this$0.b(i12)).getWidth();
        if (width != 0) {
            if (residueWidth.element >= width) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, i10);
                layoutParams.addRule(17, R$id.customTagNameLayout);
                layoutParams.setMargins(leftMargin.element, i11, i11, 0);
                ((TextView) this$0.b(i12)).setLayoutParams(layoutParams);
                return;
            }
            topMargin.element += i10 + i11;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, i10);
            layoutParams2.setMargins(i11, topMargin.element, i11, 0);
            ((TextView) this$0.b(i12)).setLayoutParams(layoutParams2);
        }
    }

    private final GradientDrawable getBgShape() {
        return (GradientDrawable) this.f14487b.getValue();
    }

    @Nullable
    public View b(int i10) {
        Map<Integer, View> map = this.f14488c;
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

    public final int c(Object obj, int i10) {
        if (obj == null) {
            return 0;
        }
        return z0.h.c(this, 17.0f) + i10 + z0.h.c(this, 15.0f);
    }

    public final void d() {
        z.a(this, R$layout.layout_tag_feed, true);
    }

    public final void setData(@Nullable FeedModel feedModel) {
        String str;
        String label;
        ImageModel hashTagBaseImage;
        if (feedModel != null) {
            int i10 = R$id.hashTagNameTextView;
            boolean z10 = true;
            ((TextView) b(i10)).getPaint().setFakeBoldText(true);
            int i11 = R$id.customTagNameTextView;
            ((TextView) b(i11)).getPaint().setFakeBoldText(true);
            int i12 = R$id.hashtag_base_con;
            ((TextView) b(i12)).getPaint().setFakeBoldText(true);
            if (feedModel.getHashtag() != null) {
                HashTag hashtag = feedModel.getHashtag();
                if ((hashtag != null ? hashtag.getHashTagBaseImage() : null) != null) {
                    ((RelativeLayout) b(R$id.hashtag_base_rl)).setVisibility(0);
                    ((TextView) b(i10)).setVisibility(8);
                    HashTag hashtag2 = feedModel.getHashtag();
                    Integer valueOf = (hashtag2 == null || (hashTagBaseImage = hashtag2.getHashTagBaseImage()) == null) ? null : Integer.valueOf(hashTagBaseImage.getScaleWidthByHeight(z0.h.c(this, 24.0f)));
                    int i13 = R$id.hashtag_base_img;
                    ImageLoaderView hashtag_base_img = (ImageLoaderView) b(i13);
                    kotlin.jvm.internal.s.h(hashtag_base_img, "hashtag_base_img");
                    y.o(hashtag_base_img, valueOf, null, 2, null);
                    ImageLoaderView hashtag_base_img2 = (ImageLoaderView) b(i13);
                    kotlin.jvm.internal.s.h(hashtag_base_img2, "hashtag_base_img");
                    HashTag hashtag3 = feedModel.getHashtag();
                    ImageLoaderView.g(hashtag_base_img2, hashtag3 != null ? hashtag3.getHashTagBaseImage() : null, null, null, 6, null);
                    HashTag hashtag4 = feedModel.getHashtag();
                    if (hashtag4 != null && hashtag4.getHashTagBaseImageSwitch()) {
                        ((TextView) b(i12)).setVisibility(0);
                        TextView textView = (TextView) b(i12);
                        HashTag hashtag5 = feedModel.getHashtag();
                        textView.setText(hashtag5 != null ? hashtag5.getName() : null);
                    } else {
                        ((TextView) b(i12)).setVisibility(8);
                    }
                } else {
                    ((RelativeLayout) b(R$id.hashtag_base_rl)).setVisibility(8);
                    ((TextView) b(i10)).setVisibility(0);
                    TextView textView2 = (TextView) b(i10);
                    HashTag hashtag6 = feedModel.getHashtag();
                    textView2.setText(hashtag6 != null ? hashtag6.getName() : null);
                }
            } else {
                ((TextView) b(i10)).setVisibility(8);
                ((RelativeLayout) b(R$id.hashtag_base_rl)).setVisibility(8);
            }
            if (feedModel.getCustomTag() != null) {
                CustomTag customTag = feedModel.getCustomTag();
                kotlin.jvm.internal.s.f(customTag);
                int i14 = R$id.customTagNameLayout;
                ((RelativeLayout) b(i14)).setVisibility(0);
                CustomTag customTag2 = feedModel.getCustomTag();
                if (customTag2 != null && (label = customTag2.getLabel()) != null) {
                    ((TextView) b(i11)).setText(label);
                }
                String foregroundColor = customTag.getForegroundColor();
                if (!(foregroundColor == null || foregroundColor.length() == 0)) {
                    ((TextView) b(i11)).setTextColor(com.cupidapp.live.base.utils.h.b(customTag.getForegroundColor()));
                } else {
                    ((TextView) b(i11)).setTextColor(-15066598);
                }
                String backgroundColor = customTag.getBackgroundColor();
                if (backgroundColor != null && backgroundColor.length() != 0) {
                    z10 = false;
                }
                if (!z10) {
                    getBgShape().setColor(com.cupidapp.live.base.utils.h.b(customTag.getBackgroundColor()));
                    ((RelativeLayout) b(i14)).setBackground(getBgShape());
                } else {
                    getBgShape().setColor(-49088);
                    ((RelativeLayout) b(i14)).setBackground(getBgShape());
                }
                if (customTag.getIcon() != null) {
                    int i15 = R$id.customTagNameIcon;
                    ((ImageLoaderView) b(i15)).setVisibility(0);
                    ImageLoaderView customTagNameIcon = (ImageLoaderView) b(i15);
                    kotlin.jvm.internal.s.h(customTagNameIcon, "customTagNameIcon");
                    ImageLoaderView.g(customTagNameIcon, customTag.getIcon(), null, null, 4, null);
                } else {
                    ((ImageLoaderView) b(R$id.customTagNameIcon)).setVisibility(8);
                    ViewGroup.LayoutParams layoutParams = ((TextView) b(i11)).getLayoutParams();
                    RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
                    if (layoutParams2 != null) {
                        layoutParams2.setMargins(z0.h.c(this, 6.0f), 0, 0, 0);
                    }
                }
            } else {
                ((RelativeLayout) b(R$id.customTagNameLayout)).setVisibility(8);
            }
            int l10 = z0.h.l(this);
            final int c4 = z0.h.c(this, 25.0f);
            final Ref$IntRef ref$IntRef = new Ref$IntRef();
            ref$IntRef.element = z0.h.c(this, 12.0f);
            final Ref$IntRef ref$IntRef2 = new Ref$IntRef();
            ref$IntRef2.element = z0.h.c(this, 12.0f);
            final Ref$IntRef ref$IntRef3 = new Ref$IntRef();
            ref$IntRef3.element = l10;
            final int c10 = z0.h.c(this, 12.0f);
            TextPaint paint = ((TextView) b(i11)).getPaint();
            CustomTag customTag3 = feedModel.getCustomTag();
            if (customTag3 == null || (str = customTag3.getLabel()) == null) {
                str = "";
            }
            int c11 = c(feedModel.getCustomTag(), (int) paint.measureText(str));
            if (c11 != 0) {
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, c4);
                layoutParams3.setMargins(c10, c10, c10, 0);
                ((RelativeLayout) b(R$id.customTagNameLayout)).setLayoutParams(layoutParams3);
                ref$IntRef3.element = (l10 - c11) - (c10 * 3);
                ref$IntRef2.element = 0;
            }
            ((TextView) b(i10)).post(new Runnable() { // from class: com.cupidapp.live.feed.layout.f
                @Override // java.lang.Runnable
                public final void run() {
                    FeedTagLayout.e(FeedTagLayout.this, ref$IntRef3, c4, ref$IntRef2, c10, ref$IntRef);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedTagLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14488c = new LinkedHashMap();
        this.f14487b = kotlin.c.b(FeedTagLayout$bgShape$2.INSTANCE);
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedTagLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14488c = new LinkedHashMap();
        this.f14487b = kotlin.c.b(FeedTagLayout$bgShape$2.INSTANCE);
        d();
    }
}
