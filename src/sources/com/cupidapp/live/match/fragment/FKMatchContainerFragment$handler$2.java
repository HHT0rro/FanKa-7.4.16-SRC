package com.cupidapp.live.match.fragment;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.cupidapp.live.appdialog.model.BottomTabName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKMatchContainerFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKMatchContainerFragment$handler$2 extends Lambda implements Function0<Handler> {
    public final /* synthetic */ FKMatchContainerFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKMatchContainerFragment$handler$2(FKMatchContainerFragment fKMatchContainerFragment) {
        super(0);
        this.this$0 = fKMatchContainerFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$0(FKMatchContainerFragment this$0, Message it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.i(it, "it");
        if (it.what == 1) {
            this$0.e1(BottomTabName.Match);
        }
        return true;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Handler invoke() {
        Looper mainLooper = Looper.getMainLooper();
        final FKMatchContainerFragment fKMatchContainerFragment = this.this$0;
        return new Handler(mainLooper, new Handler.Callback() { // from class: com.cupidapp.live.match.fragment.c
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean invoke$lambda$0;
                invoke$lambda$0 = FKMatchContainerFragment$handler$2.invoke$lambda$0(FKMatchContainerFragment.this, message);
                return invoke$lambda$0;
            }
        });
    }
}
