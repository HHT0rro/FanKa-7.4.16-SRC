package com.kwad.components.ad.reward.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.b.a;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.core.proxy.g;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b extends g implements a.b {
    private AdTemplate mAdTemplate;
    private int[] qL;

    /* renamed from: rb, reason: collision with root package name */
    private com.kwad.components.ad.reward.b.a f36540rb;

    /* renamed from: rc, reason: collision with root package name */
    private a f36541rc;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void gJ();
    }

    public static void a(Activity activity, AdTemplate adTemplate, a aVar, int[] iArr) {
        if (adTemplate == null || activity == null) {
            return;
        }
        String jSONObject = adTemplate.toJson().toString();
        Bundle bundle = new Bundle();
        bundle.putString("key_template_json", jSONObject);
        bundle.putIntArray("key_end_location", iArr);
        b bVar = new b();
        bVar.a(aVar);
        bVar.setArguments(bundle);
        bVar.show(activity.getFragmentManager(), "rewardCoupon");
    }

    @Override // com.kwad.components.ad.reward.b.a.b
    public final void gJ() {
        dismiss();
        a aVar = this.f36541rc;
        if (aVar != null) {
            aVar.gJ();
        }
    }

    @Override // com.kwad.components.ad.reward.b.a.b
    public final void gK() {
        dismiss();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey("key_template_json")) {
                try {
                    String string = arguments.getString("key_template_json");
                    AdTemplate adTemplate = new AdTemplate();
                    this.mAdTemplate = adTemplate;
                    adTemplate.parseJson(new JSONObject(string));
                } catch (Exception e2) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
                }
            }
            if (arguments.containsKey("key_end_location")) {
                this.qL = arguments.getIntArray("key_end_location");
            }
        }
    }

    private void a(a aVar) {
        this.f36541rc = aVar;
    }

    @Override // com.kwad.components.core.proxy.g
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        com.kwad.components.ad.reward.b.a aVar = new com.kwad.components.ad.reward.b.a(layoutInflater.getContext(), viewGroup, this.qL);
        this.f36540rb = aVar;
        aVar.a(this);
        Window window = getDialog().getWindow();
        if (window != null) {
            window.getDecorView().setPadding(0, 0, 0, 0);
            getDialog().setCanceledOnTouchOutside(false);
            window.setLayout(-1, -1);
            window.setDimAmount(0.0f);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        this.f36540rb.b(r.R(this.mAdTemplate));
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.ad.reward.b.b.1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                return i10 == 4 && keyEvent.getAction() == 0;
            }
        });
        return this.f36540rb.gF();
    }
}
