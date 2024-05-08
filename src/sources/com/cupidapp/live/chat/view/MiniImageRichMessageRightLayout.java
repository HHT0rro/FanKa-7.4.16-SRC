package com.cupidapp.live.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.MessageUiType;
import com.cupidapp.live.chat2.model.ChatMessageModel;
import j1.e;
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

/* compiled from: MiniImageRichMessageLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MiniImageRichMessageRightLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13233b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniImageRichMessageRightLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13233b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13233b;
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

    public final void b(@NotNull final ChatMessageModel model) {
        s.i(model, "model");
        ImageLoaderView richImageView = (ImageLoaderView) a(R$id.richImageView);
        s.h(richImageView, "richImageView");
        ImageLoaderView.g(richImageView, model.getIcon(), null, null, 6, null);
        ((TextView) a(R$id.richTitleTextView)).setText(model.getTitle());
        ((TextView) a(R$id.richDescriptionTextView)).setText(model.getDescription());
        TextView textView = (TextView) a(R$id.richAngleTextView);
        String angleText = model.getAngleText();
        if (angleText == null) {
            angleText = getContext().getString(R$string.see_the_detail);
        }
        textView.setText(angleText);
        y.d(this, new Function1<View, p>() { // from class: com.cupidapp.live.chat.view.MiniImageRichMessageRightLayout$configMiniImageRichRightUi$1
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
                j.a.b(j.f12156c, MiniImageRichMessageRightLayout.this.getContext(), model.getUrl(), null, 4, null);
                e.f50230a.a(model.getDescription(), model.getUrl(), MessageUiType.SmallRich.getValue());
            }
        });
    }

    public final void c() {
        z.a(this, R$layout.layout_right_mini_image_rich_message_template, true);
        ((TextView) a(R$id.richTitleTextView)).getPaint().setFakeBoldText(true);
        ((TextView) a(R$id.richAngleTextView)).getPaint().setFakeBoldText(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniImageRichMessageRightLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13233b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniImageRichMessageRightLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13233b = new LinkedHashMap();
        c();
    }
}
