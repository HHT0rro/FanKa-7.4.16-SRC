package com.cupidapp.live.liveshow.view.privilege;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.grpc.LiveAnchorPrivilegeHintConnectorMessage;
import com.cupidapp.live.base.grpc.LivePrivilegeType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.b;
import z0.z;

/* compiled from: FKLivePrivilegeDialogLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLivePrivilegeDialogLayout extends FrameLayout {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f15837c = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15838b;

    /* compiled from: FKLivePrivilegeDialogLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull LiveAnchorPrivilegeHintConnectorMessage hintModel) {
            s.i(context, "context");
            s.i(hintModel, "hintModel");
            FKLivePrivilegeDialogLayout fKLivePrivilegeDialogLayout = new FKLivePrivilegeDialogLayout(context);
            fKLivePrivilegeDialogLayout.c(hintModel);
            AlertDialog create = b.f54812a.e(context).setView(fKLivePrivilegeDialogLayout).create();
            create.show();
            Window window = create.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
                window.setLayout(-2, -2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLivePrivilegeDialogLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15838b = new LinkedHashMap();
        d();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15838b;
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

    public final void c(LiveAnchorPrivilegeHintConnectorMessage liveAnchorPrivilegeHintConnectorMessage) {
        String str;
        String string;
        String string2 = getContext().getString(R$string.live_level, Integer.valueOf(liveAnchorPrivilegeHintConnectorMessage.getLevel()));
        s.h(string2, "context.getString(R.stri…e_level, hintModel.level)");
        String valueOf = String.valueOf(liveAnchorPrivilegeHintConnectorMessage.getUsefulLife());
        int privilegeType = liveAnchorPrivilegeHintConnectorMessage.getPrivilegeType();
        String str2 = "";
        if (privilegeType == LivePrivilegeType.ExposureType.getType()) {
            str2 = getContext().getString(R$string.exposure_privilege);
            s.h(str2, "context.getString(R.string.exposure_privilege)");
            string = getContext().getString(R$string.exposure_privilege_description, string2);
            s.h(string, "context.getString(R.stri…ilege_description, level)");
        } else if (privilegeType == LivePrivilegeType.RecommendType.getType()) {
            str2 = getContext().getString(R$string.popular_recommendation_card);
            s.h(str2, "context.getString(R.stri…ular_recommendation_card)");
            string = getContext().getString(R$string.popular_recommendation_card_description, string2, valueOf);
            s.h(string, "context.getString(R.stri…ption, level, usefulLife)");
        } else {
            str = "";
            ((TextView) a(R$id.livePrivilegeText)).setText(q1.d.f53006a.h(str, kotlin.collections.s.m(string2, str2, valueOf), -49088, null, true));
        }
        str = string;
        ((TextView) a(R$id.livePrivilegeText)).setText(q1.d.f53006a.h(str, kotlin.collections.s.m(string2, str2, valueOf), -49088, null, true));
    }

    public final void d() {
        z.a(this, R$layout.layout_live_privilege_dialog, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLivePrivilegeDialogLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15838b = new LinkedHashMap();
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLivePrivilegeDialogLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15838b = new LinkedHashMap();
        d();
    }
}
