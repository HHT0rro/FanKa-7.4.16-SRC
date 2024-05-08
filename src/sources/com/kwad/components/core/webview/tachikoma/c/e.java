package com.kwad.components.core.webview.tachikoma.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.proxy.g;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.components.k;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e extends g {
    public StyleTemplate SA;
    public com.kwad.components.core.webview.tachikoma.e.c Sy;
    public k aaA;
    public com.kwad.components.core.webview.tachikoma.k aaB;
    public boolean aaC;
    public a aaD;
    private com.kwad.components.core.webview.tachikoma.e.d aaG;
    private d aaJ;
    private KSFrameLayout aaK;
    public List<DialogInterface.OnDismissListener> aaL = new CopyOnWriteArrayList();
    public boolean aaM = false;
    public com.kwad.components.core.webview.tachikoma.c.b aay;
    public AdResultData mAdResultData;
    private Presenter mPresenter;
    public String xn;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        boolean fT();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b {
        private k aaA;
        private boolean aaC;
        private boolean aaM;
        private StyleTemplate aaO;
        private com.kwad.components.core.webview.tachikoma.k aaP;
        private AdResultData mAdResultData;
        private String templateId;

        public final void a(StyleTemplate styleTemplate) {
            this.aaO = styleTemplate;
        }

        public final void aU(String str) {
            this.templateId = str;
        }

        public final void aW(boolean z10) {
            this.aaC = false;
        }

        public final void aX(boolean z10) {
            this.aaM = true;
        }

        public final String getTemplateId() {
            return this.templateId;
        }

        public final AdResultData hk() {
            return this.mAdResultData;
        }

        public final boolean ke() {
            return this.aaC;
        }

        public final boolean sX() {
            return this.aaM;
        }

        public final void a(com.kwad.components.core.webview.tachikoma.k kVar) {
            this.aaP = kVar;
        }

        public final void c(k kVar) {
            this.aaA = kVar;
        }

        public final void d(AdResultData adResultData) {
            this.mAdResultData = adResultData;
        }
    }

    private Presenter af() {
        Presenter presenter = new Presenter();
        this.mPresenter = presenter;
        if (this.aay.aaB != null) {
            presenter.a(sW());
        } else {
            presenter.a(jl());
        }
        return this.mPresenter;
    }

    public static e b(b bVar) {
        e eVar = new e();
        eVar.mAdResultData = bVar.hk();
        eVar.xn = bVar.getTemplateId();
        eVar.aaC = bVar.aaC;
        eVar.aaM = bVar.aaM;
        eVar.SA = bVar.aaO;
        eVar.aaA = bVar.aaA;
        eVar.aaB = bVar.aaP;
        Bundle bundle = new Bundle();
        bundle.putString("templateId", bVar.getTemplateId());
        eVar.setArguments(bundle);
        return eVar;
    }

    private d sW() {
        if (this.aaJ == null) {
            this.aaJ = new d();
        }
        return this.aaJ;
    }

    private void z(View view) {
        if (this.aay == null) {
            this.aay = jk();
        }
        jm();
        if (this.mPresenter == null) {
            Presenter af = af();
            this.mPresenter = af;
            af.G(view);
        }
        this.mPresenter.k(this.aay);
    }

    public final void d(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.aaL.add(onDismissListener);
        }
    }

    public final void e(DialogInterface.OnDismissListener onDismissListener) {
        this.aaL.remove(onDismissListener);
    }

    public com.kwad.components.core.webview.tachikoma.c.b jk() {
        return new com.kwad.components.core.webview.tachikoma.c.b();
    }

    public c jl() {
        return new c();
    }

    public void jm() {
        this.aay.d(this.mAdResultData);
        this.aay.mActivity = getActivity();
        com.kwad.components.core.webview.tachikoma.c.b bVar = this.aay;
        bVar.YI = this;
        bVar.aaz = this.aaK;
        bVar.xn = this.xn;
        bVar.SA = this.SA;
        bVar.aaC = this.aaC;
        bVar.aaA = this.aaA;
        bVar.aaB = this.aaB;
        bVar.aaD = this.aaD;
        bVar.Sy = this.Sy;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        Window window;
        try {
            super.onActivityCreated(bundle);
        } catch (Throwable unused) {
        }
        if (getDialog() == null || (window = getDialog().getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.0f;
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        getDialog().setCanceledOnTouchOutside(false);
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        window.setSoftInputMode(16);
        if (b(getDialog().getOwnerActivity())) {
            window.setFlags(1024, 1024);
        }
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.core.webview.tachikoma.c.e.1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                if (i10 != 4 || keyEvent.getAction() != 0) {
                    return false;
                }
                e eVar = e.this;
                if (eVar.aaM) {
                    return true;
                }
                if (eVar.aaJ != null) {
                    return e.this.aaJ.onBackPressed();
                }
                return false;
            }
        });
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.xn = getArguments().getString("templateId");
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
            this.mPresenter = null;
        }
        com.kwad.components.core.webview.tachikoma.c.b bVar = this.aay;
        if (bVar != null) {
            bVar.release();
            this.aay = null;
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        KSFrameLayout kSFrameLayout = this.aaK;
        if (kSFrameLayout != null && (kSFrameLayout.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.aaK.getParent()).removeView(this.aaK);
            this.aaK = null;
        }
        com.kwad.components.core.webview.tachikoma.e.d dVar = this.aaG;
        if (dVar != null) {
            dVar.fZ();
        }
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        com.kwad.components.core.webview.tachikoma.e.c cVar = this.Sy;
        if (cVar != null) {
            cVar.fZ();
        }
        for (DialogInterface.OnDismissListener onDismissListener : this.aaL) {
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
        }
        k kVar = this.aaA;
        if (kVar != null) {
            kVar.callbackDialogDismiss();
        }
    }

    @Override // android.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        z(view);
        com.kwad.components.core.webview.tachikoma.e.c cVar = this.Sy;
        if (cVar != null) {
            cVar.fR();
        }
        com.kwad.components.core.webview.tachikoma.e.d dVar = this.aaG;
        if (dVar != null) {
            dVar.fR();
        }
    }

    public final void a(com.kwad.components.core.webview.tachikoma.e.d dVar) {
        this.aaG = dVar;
    }

    @Override // com.kwad.components.core.proxy.g
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        if (this.aaK == null) {
            this.aaK = (KSFrameLayout) layoutInflater.inflate(R.layout.ksad_video_tk_dialog_layout, viewGroup, false);
        }
        return this.aaK;
    }

    private static boolean b(Activity activity) {
        return activity != null && (activity.getWindow().getAttributes().flags & 1024) == 1024;
    }
}
