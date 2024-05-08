package com.cupidapp.live.liveshow.view.bottommenu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import java.util.List;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: ReportLiveShowHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class g extends BaseAdapter {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final List<String> f15344b;

    public g(@NotNull List<String> list) {
        s.i(list, "list");
        this.f15344b = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f15344b.size();
    }

    @Override // android.widget.Adapter
    @NotNull
    public Object getItem(int i10) {
        return this.f15344b.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    @Nullable
    public View getView(int i10, @Nullable View view, @Nullable ViewGroup viewGroup) {
        if (viewGroup != null) {
            View b4 = z.b(viewGroup, R$layout.layout_live_show_report, false, 2, null);
            if (b4 != null) {
                ((TextView) b4.findViewById(R$id.reportText)).setText(this.f15344b.get(i10));
                b4.findViewById(R$id.bottomLine).setVisibility(i10 == kotlin.collections.s.l(this.f15344b) ? 8 : 0);
                return b4;
            }
        }
        return null;
    }
}
