package com.cupidapp.live.club.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.club.activity.ClubNoticeActivity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: ClubChatTopMsgLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubChatTopMsgLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13645b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubChatTopMsgLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13645b = new LinkedHashMap();
        b();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13645b;
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

    public final void b() {
        z.a(this, R$layout.layout_club_chat_top_msg, true);
    }

    public final void setTopMsg(@Nullable String str, @NotNull final String clubId, @Nullable final Integer num) {
        s.i(clubId, "clubId");
        if (str == null || str.length() == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        ((TextView) a(R$id.club_chat_top_msg_content_text)).setText(str);
        y.d(this, new Function1<View, p>() { // from class: com.cupidapp.live.club.view.ClubChatTopMsgLayout$setTopMsg$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                ClubChatTopMsgLayout.this.setVisibility(8);
                ClubNoticeActivity.a aVar = ClubNoticeActivity.f13497t;
                Context context = ClubChatTopMsgLayout.this.getContext();
                s.h(context, "context");
                aVar.a(context, clubId, num);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubChatTopMsgLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13645b = new LinkedHashMap();
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubChatTopMsgLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13645b = new LinkedHashMap();
        b();
    }
}
