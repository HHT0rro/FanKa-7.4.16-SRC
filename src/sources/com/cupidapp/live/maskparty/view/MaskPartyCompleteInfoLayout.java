package com.cupidapp.live.maskparty.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.maskparty.model.CompleteInfoGuideModel;
import com.cupidapp.live.maskparty.view.MaskPartyCompleteInfoLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: MaskPartyCompleteInfoLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyCompleteInfoLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public a f16398b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16399c;

    /* compiled from: MaskPartyCompleteInfoLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void dismiss();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyCompleteInfoLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16399c = new LinkedHashMap();
        e();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16399c;
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

    @NotNull
    public final MaskPartyCompleteInfoLayout c(@NotNull final CompleteInfoGuideModel guide, @NotNull final SensorPosition position) {
        s.i(guide, "guide");
        s.i(position, "position");
        ImageLoaderView complete_info_user_avatar = (ImageLoaderView) a(R$id.complete_info_user_avatar);
        s.h(complete_info_user_avatar, "complete_info_user_avatar");
        ImageLoaderView.g(complete_info_user_avatar, guide.getAvatar(), null, null, 6, null);
        ((TextView) a(R$id.complete_info_progress_textview)).setText(guide.getScore() + "%");
        ((TextView) a(R$id.complete_info_user_name)).setText(guide.getUsername());
        ((TextView) a(R$id.complete_info_prompt)).setText(guide.getTitle());
        ((TextView) a(R$id.complete_info_desc_textview)).setText(guide.getDesc());
        ((TextView) a(R$id.complete_info_textview)).setText(guide.getButtonText());
        LinearLayout compete_info_layout = (LinearLayout) a(R$id.compete_info_layout);
        s.h(compete_info_layout, "compete_info_layout");
        y.d(compete_info_layout, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyCompleteInfoLayout$configLayout$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                MaskPartyCompleteInfoLayout.a aVar;
                aVar = MaskPartyCompleteInfoLayout.this.f16398b;
                if (aVar != null) {
                    aVar.dismiss();
                }
                j.a.b(com.cupidapp.live.base.router.j.f12156c, MaskPartyCompleteInfoLayout.this.getContext(), guide.getJumpUrl(), null, 4, null);
                j1.i.f50236a.a(PopupName.MASK_PARTY_COMPLETE_PROFILE, PopupButtonName.TRY, position);
            }
        });
        return this;
    }

    public final void d(@NotNull a callback) {
        s.i(callback, "callback");
        this.f16398b = callback;
    }

    public final void e() {
        z.a(this, R$layout.layout_mask_party_complete_info, true);
        ((TextView) a(R$id.complete_info_prompt)).getPaint().setFakeBoldText(true);
        ImageView close_imageview = (ImageView) a(R$id.close_imageview);
        s.h(close_imageview, "close_imageview");
        y.d(close_imageview, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyCompleteInfoLayout$initView$1
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
                MaskPartyCompleteInfoLayout.a aVar;
                aVar = MaskPartyCompleteInfoLayout.this.f16398b;
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyCompleteInfoLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16399c = new LinkedHashMap();
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyCompleteInfoLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16399c = new LinkedHashMap();
        e();
    }
}
