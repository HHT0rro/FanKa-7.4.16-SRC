package com.cupidapp.live.maskparty.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.helper.widget.Layer;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.maskparty.model.CompleteInfoGuideModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: MaskPartyMatchTitleLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyMatchTitleLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public j f16419b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public CompleteInfoGuideModel f16420c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16421d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyMatchTitleLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16421d = new LinkedHashMap();
        e();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16421d;
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

    public final void d(@Nullable CompleteInfoGuideModel completeInfoGuideModel) {
        this.f16420c = completeInfoGuideModel;
        if (completeInfoGuideModel == null) {
            Layer edit_info_progress_layer = (Layer) a(R$id.edit_info_progress_layer);
            s.h(edit_info_progress_layer, "edit_info_progress_layer");
            edit_info_progress_layer.setVisibility(8);
            return;
        }
        Layer edit_info_progress_layer2 = (Layer) a(R$id.edit_info_progress_layer);
        s.h(edit_info_progress_layer2, "edit_info_progress_layer");
        edit_info_progress_layer2.setVisibility(0);
        ((ProgressBar) a(R$id.edit_info_progress)).setProgress(completeInfoGuideModel.getScore());
        ((TextView) a(R$id.edit_info_progress_textview)).setText(completeInfoGuideModel.getScore() + "%");
    }

    public final void e() {
        z.a(this, R$layout.layout_mask_party_match_title, true);
        ((TextView) a(R$id.match_title_text)).getPaint().setFakeBoldText(true);
        int i10 = R$id.mask_party_edit_info_textview;
        ((TextView) a(i10)).getPaint().setFakeBoldText(true);
        ((TextView) a(R$id.edit_info_progress_textview)).getPaint().setFakeBoldText(true);
        ImageView quit_match_imageview = (ImageView) a(R$id.quit_match_imageview);
        s.h(quit_match_imageview, "quit_match_imageview");
        y.d(quit_match_imageview, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyMatchTitleLayout$initView$1
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
                j jVar;
                jVar = MaskPartyMatchTitleLayout.this.f16419b;
                if (jVar != null) {
                    jVar.a();
                }
            }
        });
        TextView mask_party_edit_info_textview = (TextView) a(i10);
        s.h(mask_party_edit_info_textview, "mask_party_edit_info_textview");
        y.d(mask_party_edit_info_textview, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyMatchTitleLayout$initView$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:3:0x0008, code lost:
            
                r0 = r1.this$0.f16419b;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(@org.jetbrains.annotations.Nullable android.view.View r2) {
                /*
                    r1 = this;
                    com.cupidapp.live.maskparty.view.MaskPartyMatchTitleLayout r2 = com.cupidapp.live.maskparty.view.MaskPartyMatchTitleLayout.this
                    com.cupidapp.live.maskparty.model.CompleteInfoGuideModel r2 = com.cupidapp.live.maskparty.view.MaskPartyMatchTitleLayout.b(r2)
                    if (r2 == 0) goto L13
                    com.cupidapp.live.maskparty.view.MaskPartyMatchTitleLayout r0 = com.cupidapp.live.maskparty.view.MaskPartyMatchTitleLayout.this
                    com.cupidapp.live.maskparty.view.j r0 = com.cupidapp.live.maskparty.view.MaskPartyMatchTitleLayout.c(r0)
                    if (r0 == 0) goto L13
                    r0.b(r2)
                L13:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.maskparty.view.MaskPartyMatchTitleLayout$initView$2.invoke2(android.view.View):void");
            }
        });
    }

    public final void f(boolean z10) {
        ((ImageView) a(R$id.quit_match_imageview)).setVisibility(z10 ? 0 : 4);
    }

    public final void setListener(@NotNull j listener) {
        s.i(listener, "listener");
        this.f16419b = listener;
    }

    public final void setProgressVisible(boolean z10) {
        if (this.f16420c != null) {
            Layer edit_info_progress_layer = (Layer) a(R$id.edit_info_progress_layer);
            s.h(edit_info_progress_layer, "edit_info_progress_layer");
            edit_info_progress_layer.setVisibility(z10 ? 0 : 8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyMatchTitleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16421d = new LinkedHashMap();
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyMatchTitleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16421d = new LinkedHashMap();
        e();
    }
}
