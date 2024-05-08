package com.kwad.components.core.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ai;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f extends FrameLayout {
    private boolean acs;
    public boolean iD;

    /* renamed from: if, reason: not valid java name */
    public g f205if;

    @NonNull
    public Context mContext;

    public f(@NonNull Context context) {
        super(context);
        this.mContext = context;
        this.iD = ai.LZ();
    }

    private void tu() {
        boolean LZ = ai.LZ();
        if (!this.acs || LZ == this.iD) {
            return;
        }
        this.iD = LZ;
        g gVar = this.f205if;
        if (gVar != null) {
            gVar.j(!LZ);
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        tu();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.acs = i10 == 0;
        tu();
    }

    public final void setOrientationChangeListener(g gVar) {
        this.f205if = gVar;
    }
}
