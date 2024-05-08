package com.cupidapp.live.feed.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.view.drag.FKBaseDragLayout;
import com.cupidapp.live.chat.model.ChatStatusItemModel;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: PostLimitDragChatStateLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PostLimitDragChatStateLayout extends FKBaseDragLayout {

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14546m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostLimitDragChatStateLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14546m = new LinkedHashMap();
        i();
    }

    @Nullable
    public View g(int i10) {
        Map<Integer, View> map = this.f14546m;
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

    public final void h(@NotNull ChatStatusItemModel model) {
        kotlin.jvm.internal.s.i(model, "model");
        ImageLoaderView post_limit_chat_state_img = (ImageLoaderView) g(R$id.post_limit_chat_state_img);
        kotlin.jvm.internal.s.h(post_limit_chat_state_img, "post_limit_chat_state_img");
        ImageLoaderView.g(post_limit_chat_state_img, model.getIcon(), null, null, 6, null);
        ((TextView) g(R$id.post_limit_chat_state_content)).setText(model.getContent());
    }

    public final void i() {
        z.a(this, R$layout.layout_post_limit_drag_chat_state, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostLimitDragChatStateLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14546m = new LinkedHashMap();
        i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostLimitDragChatStateLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14546m = new LinkedHashMap();
        i();
    }
}
