package com.cupidapp.live.base.share.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.share.model.FKShareItemModel;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.vip.model.VipType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: ShareItemMenuView.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ShareItemMenuView extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12264d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareItemMenuView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f12264d = new LinkedHashMap();
        h();
    }

    public static final void g(a listener, FKShareItemModel item, View view) {
        s.i(listener, "$listener");
        s.i(item, "$item");
        listener.Z(item.getType());
    }

    public final void f(@NotNull final FKShareItemModel item, @NotNull final a listener) {
        s.i(item, "item");
        s.i(listener, "listener");
        ShareItemView shareItemView = (ShareItemView) findViewById(R$id.share_item_view);
        String string = getContext().getString(item.getContentId());
        s.h(string, "context.getString(item.contentId)");
        shareItemView.setContent(string, item.getDrawableId());
        shareItemView.setOnClickListener(new View.OnClickListener() { // from class: com.cupidapp.live.base.share.view.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShareItemMenuView.g(a.this, item, view);
            }
        });
        ImageView imageView = (ImageView) findViewById(R$id.share_item_new_dot);
        ImageView imageView2 = (ImageView) findViewById(R$id.share_item_vip_tag);
        imageView.setVisibility(item.getShowNewDot() ? 0 : 8);
        imageView2.setVisibility(item.getNeedVipType() != VipType.NORMAL ? 8 : 0);
        listener.q(item.getType());
    }

    public final void h() {
        z.a(this, R$layout.layout_share_item_view, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareItemMenuView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f12264d = new LinkedHashMap();
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareItemMenuView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f12264d = new LinkedHashMap();
        h();
    }
}
