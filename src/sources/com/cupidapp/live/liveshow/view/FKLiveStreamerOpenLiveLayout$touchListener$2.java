package com.cupidapp.live.liveshow.view;

import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.cupidapp.live.R$id;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKLiveStreamerOpenLiveLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveStreamerOpenLiveLayout$touchListener$2 extends Lambda implements Function0<View.OnTouchListener> {
    public final /* synthetic */ FKLiveStreamerOpenLiveLayout this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveStreamerOpenLiveLayout$touchListener$2(FKLiveStreamerOpenLiveLayout fKLiveStreamerOpenLiveLayout) {
        super(0);
        this.this$0 = fKLiveStreamerOpenLiveLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$0(FKLiveStreamerOpenLiveLayout this$0, View view, MotionEvent motionEvent) {
        s.i(this$0, "this$0");
        RadioButton radioButton = view instanceof RadioButton ? (RadioButton) view : null;
        if (motionEvent.getAction() == 0) {
            if (radioButton != null && radioButton.isChecked()) {
                ((RadioGroup) this$0.h(R$id.shareButtonRadioGroup)).clearCheck();
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final View.OnTouchListener invoke() {
        final FKLiveStreamerOpenLiveLayout fKLiveStreamerOpenLiveLayout = this.this$0;
        return new View.OnTouchListener() { // from class: com.cupidapp.live.liveshow.view.i
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean invoke$lambda$0;
                invoke$lambda$0 = FKLiveStreamerOpenLiveLayout$touchListener$2.invoke$lambda$0(FKLiveStreamerOpenLiveLayout.this, view, motionEvent);
                return invoke$lambda$0;
            }
        };
    }
}
