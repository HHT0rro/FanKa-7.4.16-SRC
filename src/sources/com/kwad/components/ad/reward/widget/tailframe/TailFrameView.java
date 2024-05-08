package com.kwad.components.ad.reward.widget.tailframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class TailFrameView extends KSFrameLayout {
    private com.kwad.components.ad.reward.widget.tailframe.a BM;
    private g qo;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a extends com.kwad.components.ad.reward.widget.tailframe.a {
        public a() {
            super(R.layout.ksad_video_tf_view_landscape_horizontal);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            KSImageLoader.loadImage(this.BD, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b extends com.kwad.components.ad.reward.widget.tailframe.a {
        private ImageView BN;
        private ImageView BO;
        private ImageView BP;

        public b() {
            super(R.layout.ksad_video_tf_view_landscape_vertical);
        }

        private void kn() {
            KSImageLoader.loadImage(this.BN, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
            KSImageLoader.loadImage(this.BO, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
            KSImageLoader.loadImage(this.BP, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void B(Context context) {
            super.B(context);
            this.BN = (ImageView) this.BC.findViewById(R.id.ksad_video_thumb_left);
            this.BO = (ImageView) this.BC.findViewById(R.id.ksad_video_thumb_mid);
            this.BP = (ImageView) this.BC.findViewById(R.id.ksad_video_thumb_right);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            kn();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class c extends com.kwad.components.ad.reward.widget.tailframe.a {
        private View BQ;

        public c() {
            super(R.layout.ksad_video_tf_view_portrait_horizontal);
        }

        private void kn() {
            AdInfo.AdMaterialInfo.MaterialFeature aX = com.kwad.sdk.core.response.b.a.aX(this.mAdInfo);
            int i10 = aX.width;
            int i11 = aX.height;
            int screenWidth = com.kwad.sdk.d.a.a.getScreenWidth(this.BC.getContext());
            int i12 = (int) (screenWidth * (i11 / i10));
            ViewGroup.LayoutParams layoutParams = this.BD.getLayoutParams();
            layoutParams.width = screenWidth;
            layoutParams.height = i12;
            KSImageLoader.loadImage(this.BD, aX.coverUrl, this.mAdTemplate);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void B(Context context) {
            super.B(context);
            this.BQ = this.BC.findViewById(R.id.video_cover);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            if (e.F(this.mAdTemplate)) {
                this.BQ.setVisibility(8);
                this.mLogoView.setVisibility(8);
                this.BC.setBackground(null);
            }
            kn();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class d extends com.kwad.components.ad.reward.widget.tailframe.a {
        public d() {
            super(R.layout.ksad_video_tf_view_portrait_vertical);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            if (e.F(this.mAdTemplate)) {
                this.BC.setBackground(null);
                this.BD.setVisibility(8);
                this.mLogoView.setVisibility(8);
            }
            KSImageLoader.loadImage(this.BD, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
        }
    }

    public TailFrameView(@NonNull Context context) {
        super(context);
    }

    private void f(boolean z10, boolean z11) {
        if (this.BM != null) {
            return;
        }
        if (z10) {
            if (z11) {
                this.BM = new d();
                return;
            } else {
                this.BM = new c();
                return;
            }
        }
        if (z11) {
            this.BM = new b();
        } else {
            this.BM = new a();
        }
    }

    public final void a(com.kwad.components.ad.reward.widget.tailframe.b bVar) {
        this.BM.setCallerContext(this.qo);
        com.kwad.components.ad.reward.widget.tailframe.a aVar = this.BM;
        g gVar = this.qo;
        aVar.a(gVar.mAdTemplate, gVar.mReportExtData, bVar);
    }

    public final void destroy() {
        com.kwad.components.ad.reward.widget.tailframe.a aVar = this.BM;
        if (aVar != null) {
            aVar.destroy();
        }
    }

    public final void jQ() {
        this.BM.jQ();
    }

    public void setCallerContext(g gVar) {
        this.qo = gVar;
    }

    public TailFrameView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TailFrameView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    public final void a(Context context, boolean z10, boolean z11) {
        f(z10, z11);
        this.BM.B(context);
        this.BM.f(z10, z11);
        addView(this.BM.kj(), -1, -1);
    }

    public TailFrameView(@NonNull Context context, View view) {
        super(context, view);
    }
}
