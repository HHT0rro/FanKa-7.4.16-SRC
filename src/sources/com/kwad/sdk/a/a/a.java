package com.kwad.sdk.a.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ak;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a extends com.kwad.components.core.proxy.d {
    private static a aln;

    @Nullable
    private final DialogInterface.OnDismissListener alo;
    private final AdTemplate mAdTemplate;

    @Nullable
    private final DialogInterface.OnClickListener mOnClickListener;

    private a(@NonNull Activity activity, @NonNull AdTemplate adTemplate, @Nullable DialogInterface.OnDismissListener onDismissListener, @Nullable DialogInterface.OnClickListener onClickListener) {
        super(activity);
        this.mAdTemplate = adTemplate;
        this.alo = onDismissListener;
        this.mOnClickListener = onClickListener;
    }

    public static boolean nr() {
        a aVar = aln;
        return aVar != null && aVar.isShowing();
    }

    public static boolean zH() {
        a aVar = aln;
        if (aVar == null || !aVar.isShowing()) {
            return false;
        }
        aln.dismiss();
        return true;
    }

    @Override // com.kwad.components.core.proxy.d, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        try {
            super.dismiss();
            DialogInterface.OnDismissListener onDismissListener = this.alo;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(this);
            }
            aln = null;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.d
    public final void g(View view) {
        TextView textView = (TextView) view.findViewById(R.id.ksad_install_tips_content);
        TextView textView2 = (TextView) view.findViewById(R.id.ksad_install_cancel);
        TextView textView3 = (TextView) view.findViewById(R.id.ksad_install_tv);
        final AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate);
        String F = d.F(com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate));
        if (F.equals("")) {
            F = this.mContext.getString(R.string.ksad_install_tips, com.kwad.sdk.core.response.b.a.av(dQ));
        }
        textView.setText(F);
        textView3.setText(d.zS());
        textView2.setText(d.zT());
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.a.a.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                a.this.dismiss();
                if (a.this.mOnClickListener != null) {
                    a.this.mOnClickListener.onClick(a.this, -2);
                }
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.a.a.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (a.this.mOnClickListener != null) {
                    a.this.mOnClickListener.onClick(a.this, -1);
                }
                ak.a(com.kwad.sdk.core.download.a.H(dQ), new ak.a() { // from class: com.kwad.sdk.a.a.a.2.1
                    @Override // com.kwad.sdk.utils.ak.a
                    public final void d(Throwable th) {
                        com.kwad.sdk.commercial.a.a.i(a.this.mAdTemplate, 100003, Log.getStackTraceString(th));
                    }

                    @Override // com.kwad.sdk.utils.ak.a
                    public final void ol() {
                        com.kwad.sdk.core.adlog.c.h(a.this.mAdTemplate, 1);
                        com.kwad.sdk.commercial.a.a.aY(a.this.mAdTemplate);
                    }
                });
            }
        });
    }

    @Override // com.kwad.components.core.proxy.d
    public final int getLayoutId() {
        return R.layout.ksad_install_dialog;
    }

    public static boolean a(Activity activity, AdTemplate adTemplate, @Nullable DialogInterface.OnDismissListener onDismissListener, @Nullable DialogInterface.OnClickListener onClickListener) {
        if (activity != null && !activity.isFinishing() && adTemplate != null) {
            a aVar = aln;
            if (aVar != null && aVar.isShowing()) {
                aln.dismiss();
            }
            try {
                a aVar2 = new a(activity, adTemplate, onDismissListener, onClickListener);
                aVar2.show();
                aln = aVar2;
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a(Activity activity, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnClickListener onClickListener) {
        AdTemplate zN;
        if (activity == null || activity.isFinishing() || (zN = c.zM().zN()) == null) {
            return false;
        }
        return a(activity, zN, onDismissListener, onClickListener);
    }
}
