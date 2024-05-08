package com.cupidapp.live.base.share.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.share.model.CustomShareItemModel;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.web.model.ClubActivityInfoModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: ShareItemCustomMenuView.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ShareItemCustomMenuView extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12263d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareItemCustomMenuView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f12263d = new LinkedHashMap();
        f();
    }

    public final void e(@NotNull final CustomShareItemModel item, @NotNull final a listener) {
        s.i(item, "item");
        s.i(listener, "listener");
        ImageLoaderView imageview = (ImageLoaderView) findViewById(R$id.share_item_image);
        TextView textView = (TextView) findViewById(R$id.share_item_text);
        if (item.getClubActivityInfo() != null) {
            s.h(imageview, "imageview");
            ClubActivityInfoModel clubActivityInfo = item.getClubActivityInfo();
            ImageLoaderView.f(imageview, new com.cupidapp.live.base.imageloader.b(false, clubActivityInfo != null ? clubActivityInfo.getGroupAvatar() : null, null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524285, null), null, 2, null);
            ClubActivityInfoModel clubActivityInfo2 = item.getClubActivityInfo();
            textView.setText(clubActivityInfo2 != null ? clubActivityInfo2.getGroupName() : null);
        }
        y.d(this, new Function1<View, p>() { // from class: com.cupidapp.live.base.share.view.ShareItemCustomMenuView$configCustomShareItemView$1
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
                a.this.Z(item.getType());
            }
        });
    }

    public final void f() {
        z.a(this, R$layout.layout_custom_share_item, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareItemCustomMenuView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f12263d = new LinkedHashMap();
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareItemCustomMenuView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f12263d = new LinkedHashMap();
        f();
    }
}
