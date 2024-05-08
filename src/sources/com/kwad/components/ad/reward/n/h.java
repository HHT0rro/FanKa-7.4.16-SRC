package com.kwad.components.ad.reward.n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.widget.KsConvertButton;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class h extends s implements View.OnClickListener {

    @Nullable
    public KsLogoView mLogoView;
    public TextView yA;

    @Nullable
    public TextView yB;

    @Nullable
    public TextView yC;
    public a yD;

    @LayoutRes
    public int yE = R.layout.ksad_reward_apk_info_card_tag_item;
    public boolean yF = true;
    public ImageView ye;

    @Nullable
    public KsAppTagsView yi;
    public KsConvertButton yz;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void hZ();

        void ia();

        void ib();

        void ic();

        void id();

        void ie();
    }

    private void S(int i10) {
        KsConvertButton ksConvertButton = this.yz;
        if (ksConvertButton == null) {
            return;
        }
        if (i10 == 1) {
            ksConvertButton.getCornerConf().setAllCorner(true);
        } else if (i10 == 2) {
            ksConvertButton.getCornerConf().cf(false).ci(false).ch(true).cg(true);
        }
        this.yz.postInvalidate();
    }

    private void g(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.mLogoView = (KsLogoView) viewGroup.findViewById(R.id.ksad_common_app_logo);
        this.ye = (ImageView) viewGroup.findViewById(R.id.ksad_common_app_icon);
        this.yA = (TextView) viewGroup.findViewById(R.id.ksad_common_app_name);
        this.yi = (KsAppTagsView) viewGroup.findViewById(R.id.ksad_common_app_tags);
        this.yB = (TextView) viewGroup.findViewById(R.id.ksad_common_app_desc);
        this.yC = (TextView) viewGroup.findViewById(R.id.ksad_common_app_desc2);
        this.yz = (KsConvertButton) viewGroup.findViewById(R.id.ksad_common_app_action);
    }

    private static int jU() {
        return R.id.ksad_common_app_card_root;
    }

    public final void a(a aVar) {
        this.yD = aVar;
    }

    public final void f(ViewGroup viewGroup) {
        super.a(viewGroup, hY(), jU());
        g(this.sz);
        ViewGroup viewGroup2 = this.sz;
        if (viewGroup2 != null) {
            viewGroup2.setOnClickListener(this);
            this.yz.setOnClickListener(this);
            this.ye.setOnClickListener(this);
            this.yA.setOnClickListener(this);
            TextView textView = this.yB;
            if (textView != null) {
                textView.setOnClickListener(this);
            }
            TextView textView2 = this.yC;
            if (textView2 != null) {
                textView2.setOnClickListener(this);
            }
            KsAppTagsView ksAppTagsView = this.yi;
            if (ksAppTagsView != null) {
                ksAppTagsView.setOnClickListener(this);
            }
        }
    }

    public int hY() {
        return R.id.ksad_common_app_card_stub;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        if (view.equals(this.yz)) {
            a aVar2 = this.yD;
            if (aVar2 != null) {
                aVar2.hZ();
                return;
            }
            return;
        }
        if (view.equals(this.ye)) {
            a aVar3 = this.yD;
            if (aVar3 != null) {
                aVar3.ia();
                return;
            }
            return;
        }
        if (view.equals(this.yA)) {
            a aVar4 = this.yD;
            if (aVar4 != null) {
                aVar4.ib();
                return;
            }
            return;
        }
        if (!view.equals(this.yB) && !view.equals(this.yC)) {
            if (view.equals(this.yi)) {
                a aVar5 = this.yD;
                if (aVar5 != null) {
                    aVar5.id();
                    return;
                }
                return;
            }
            if (!view.equals(this.sz) || (aVar = this.yD) == null) {
                return;
            }
            aVar.ie();
            return;
        }
        a aVar6 = this.yD;
        if (aVar6 != null) {
            aVar6.ic();
        }
    }

    public final void show() {
        ViewGroup viewGroup = this.sz;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        a(com.kwad.components.ad.reward.model.a.a(rVar, this.yF));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.kwad.components.ad.reward.model.a r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L3
            return
        L3:
            int r0 = r6.hc()
            r5.S(r0)
            com.kwad.components.core.widget.KsLogoView r0 = r5.mLogoView
            if (r0 == 0) goto L15
            com.kwad.sdk.core.response.model.AdTemplate r1 = r6.gY()
            r0.aD(r1)
        L15:
            android.widget.TextView r0 = r5.yA
            java.lang.String r1 = r6.getTitle()
            r0.setText(r1)
            android.widget.TextView r0 = r5.yB
            if (r0 == 0) goto L29
            java.lang.String r1 = r6.gg()
            r0.setText(r1)
        L29:
            android.widget.TextView r0 = r5.yC
            r1 = 0
            r2 = 8
            if (r0 == 0) goto L5c
            java.lang.String r3 = r6.gg()
            r0.setText(r3)
            java.lang.String r0 = r6.gg()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L46
            r0 = 8
        L43:
            r3 = 8
            goto L52
        L46:
            boolean r0 = r6.hb()
            if (r0 == 0) goto L50
            r0 = 8
            r3 = 0
            goto L52
        L50:
            r0 = 0
            goto L43
        L52:
            android.widget.TextView r4 = r5.yB
            if (r4 == 0) goto L59
            r4.setVisibility(r0)
        L59:
            android.widget.TextView r0 = r5.yC
            goto L6e
        L5c:
            android.widget.TextView r0 = r5.yB
            if (r0 == 0) goto L71
            java.lang.String r3 = r6.gg()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L6d
            r3 = 8
            goto L6e
        L6d:
            r3 = 0
        L6e:
            r0.setVisibility(r3)
        L71:
            com.kwad.components.ad.widget.KsAppTagsView r0 = r5.yi
            if (r0 == 0) goto L8b
            java.util.List r3 = r6.ha()
            int r4 = r5.yE
            r0.a(r3, r4)
            com.kwad.components.ad.widget.KsAppTagsView r0 = r5.yi
            boolean r3 = r6.hb()
            if (r3 == 0) goto L88
            r1 = 8
        L88:
            r0.setVisibility(r1)
        L8b:
            com.kwad.components.core.widget.KsConvertButton r0 = r5.yz
            if (r0 == 0) goto L9a
            com.kwad.components.core.e.d.c r1 = r6.gZ()
            com.kwad.sdk.core.response.model.AdTemplate r2 = r6.gY()
            r0.a(r1, r2)
        L9a:
            android.widget.ImageView r0 = r5.ye
            java.lang.String r1 = r6.gf()
            com.kwad.sdk.core.response.model.AdTemplate r6 = r6.gY()
            r2 = 12
            com.kwad.sdk.core.imageloader.KSImageLoader.loadAppIcon(r0, r1, r6, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.n.h.a(com.kwad.components.ad.reward.model.a):void");
    }
}
