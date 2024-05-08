package com.cupidapp.live.setting.fragment;

import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.track.group.GroupOthersLog;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: UserInfoNewContainerFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserInfoNewContainerFragment$initObserve$1 extends Lambda implements Function1<Pair<? extends String, ? extends String>, kotlin.p> {
    public final /* synthetic */ UserInfoNewContainerFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserInfoNewContainerFragment$initObserve$1(UserInfoNewContainerFragment userInfoNewContainerFragment) {
        super(1);
        this.this$0 = userInfoNewContainerFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(UserInfoNewContainerFragment this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        TextView textView = (TextView) this$0.u1(R$id.match_guide);
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.p invoke(Pair<? extends String, ? extends String> pair) {
        invoke2((Pair<String, String>) pair);
        return kotlin.p.f51048a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Pair<String, String> result) {
        kotlin.jvm.internal.s.i(result, "result");
        String second = result.getSecond();
        if (second == null || second.length() == 0) {
            TextView textView = (TextView) this.this$0.u1(R$id.match_guide);
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
            return;
        }
        UserInfoNewContainerFragment userInfoNewContainerFragment = this.this$0;
        int i10 = R$id.match_guide;
        TextView textView2 = (TextView) userInfoNewContainerFragment.u1(i10);
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        TextView textView3 = (TextView) this.this$0.u1(i10);
        if (textView3 != null) {
            textView3.setText(result.getSecond());
        }
        TextView textView4 = (TextView) this.this$0.u1(i10);
        if (textView4 != null) {
            final UserInfoNewContainerFragment userInfoNewContainerFragment2 = this.this$0;
            textView4.postDelayed(new Runnable() { // from class: com.cupidapp.live.setting.fragment.v
                @Override // java.lang.Runnable
                public final void run() {
                    UserInfoNewContainerFragment$initObserve$1.invoke$lambda$0(UserInfoNewContainerFragment.this);
                }
            }, 5000L);
        }
        GroupOthersLog.f18702a.J(this.this$0.O0(), result.getFirst(), result.getSecond());
    }
}
