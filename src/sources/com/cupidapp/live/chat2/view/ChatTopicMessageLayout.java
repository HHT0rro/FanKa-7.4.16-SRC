package com.cupidapp.live.chat2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.z;

/* compiled from: ChatTopicMessageLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatTopicMessageLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13459b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatTopicMessageLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13459b = new LinkedHashMap();
        b();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13459b;
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
        z.a(this, R$layout.layout_chat_topic_message, true);
        TextView chat_topic_msg_text = (TextView) a(R$id.chat_topic_msg_text);
        s.h(chat_topic_msg_text, "chat_topic_msg_text");
        u.a(chat_topic_msg_text);
    }

    public final void setChatTopicMessageText(@Nullable String str) {
        ((TextView) a(R$id.chat_topic_msg_text)).setText(str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatTopicMessageLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13459b = new LinkedHashMap();
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatTopicMessageLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13459b = new LinkedHashMap();
        b();
    }
}
