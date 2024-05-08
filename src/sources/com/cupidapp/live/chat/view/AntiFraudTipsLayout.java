package com.cupidapp.live.chat.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.LifecycleOwner;
import com.cupidapp.live.R$string;
import com.cupidapp.live.setting.activity.PrivacySettingActivity;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AntiFraudTipsLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AntiFraudTipsLayout extends AppCompatTextView {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public PurchaseDialogManager f13183b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13184c;

    /* compiled from: AntiFraudTipsLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends ClickableSpan {
        public a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            s.i(widget, "widget");
            if (com.cupidapp.live.profile.logic.c.f17839a.d()) {
                PrivacySettingActivity.a aVar = PrivacySettingActivity.B;
                Context context = AntiFraudTipsLayout.this.getContext();
                s.h(context, "context");
                aVar.a(context);
                return;
            }
            Object context2 = AntiFraudTipsLayout.this.getContext();
            LifecycleOwner lifecycleOwner = context2 instanceof LifecycleOwner ? (LifecycleOwner) context2 : null;
            if (AntiFraudTipsLayout.this.f13183b == null && lifecycleOwner != null) {
                AntiFraudTipsLayout antiFraudTipsLayout = AntiFraudTipsLayout.this;
                antiFraudTipsLayout.f13183b = new PurchaseDialogManager(antiFraudTipsLayout.getContext(), lifecycleOwner.getLifecycle());
            }
            PurchaseDialogManager purchaseDialogManager = AntiFraudTipsLayout.this.f13183b;
            if (purchaseDialogManager != null) {
                PurchaseDialogManager.q(purchaseDialogManager, VipPurchaseEntranceType.ViewPrivatelyMessageDetail, null, null, false, false, 30, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AntiFraudTipsLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13184c = new LinkedHashMap();
        c();
    }

    public final void c() {
        SpannableStringBuilder c4;
        setGravity(17);
        setTextColor(-15066598);
        setTextSize(10.0f);
        setBackgroundColor(-526345);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a());
        q1.d dVar = q1.d.f53006a;
        String string = getContext().getString(R$string.anti_fraud_and_view_message_privately);
        s.h(string, "context.getString(R.stri…d_view_message_privately)");
        String string2 = getContext().getString(R$string.view_privately);
        s.h(string2, "context.getString(R.string.view_privately)");
        c4 = dVar.c(string, kotlin.collections.s.o(string2), (r18 & 4) != 0 ? null : -49088, (r18 & 8) != 0 ? null : -526345, (r18 & 16) != 0 ? false : false, (r18 & 32) != 0 ? null : arrayList, (r18 & 64) != 0 ? null : null);
        setText(c4);
        setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AntiFraudTipsLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13184c = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AntiFraudTipsLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13184c = new LinkedHashMap();
        c();
    }
}
