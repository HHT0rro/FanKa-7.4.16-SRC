package com.cupidapp.live.liveshow.view.remoteconnect.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: LiveConnectEntranceView.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveConnectEntranceView extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15869b;

    /* compiled from: LiveConnectEntranceView.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15870a;

        static {
            int[] iArr = new int[LiveConnectStatus.values().length];
            try {
                iArr[LiveConnectStatus.Request.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LiveConnectStatus.Wait.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LiveConnectStatus.Connect.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f15870a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveConnectEntranceView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15869b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15869b;
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

    public final void b(@NotNull LiveConnectStatus connectStatus) {
        int i10;
        String string;
        s.i(connectStatus, "connectStatus");
        int i11 = a.f15870a[connectStatus.ordinal()];
        if (i11 == 1) {
            i10 = R$mipmap.icon_request_connect;
            string = getContext().getString(R$string.request_live_connect);
            s.h(string, "context.getString(R.string.request_live_connect)");
        } else if (i11 == 2) {
            i10 = R$mipmap.icon_wait_connect;
            string = getContext().getString(R$string.wait_live_connect);
            s.h(string, "context.getString(R.string.wait_live_connect)");
        } else {
            if (i11 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            i10 = R$mipmap.icon_connecting;
            string = getContext().getString(R$string.live_connecting);
            s.h(string, "context.getString(R.string.live_connecting)");
        }
        ((ImageView) a(R$id.connect_status_imageview)).setImageResource(i10);
        ((TextView) a(R$id.connect_status_textview)).setText(string);
    }

    public final void c() {
        z.a(this, R$layout.live_connect_view, true);
        setVisibility(8);
        ((TextView) a(R$id.connect_status_textview)).getPaint().setFakeBoldText(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveConnectEntranceView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15869b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveConnectEntranceView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15869b = new LinkedHashMap();
        c();
    }
}
