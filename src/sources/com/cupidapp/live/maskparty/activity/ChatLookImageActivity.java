package com.cupidapp.live.maskparty.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.utils.p0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.g;
import z0.y;

/* compiled from: ChatLookImageActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ChatLookImageActivity extends FKBaseActivity {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f16224r = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16225q = new LinkedHashMap();

    /* compiled from: ChatLookImageActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @NotNull ChatLookImageData data) {
            s.i(data, "data");
            if (context == null) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) ChatLookImageActivity.class);
            g.c(intent, data);
            context.startActivity(intent);
        }
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f16225q;
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

    public final void k1() {
        ImageLoaderView chat_look_image_view = (ImageLoaderView) j1(R$id.chat_look_image_view);
        s.h(chat_look_image_view, "chat_look_image_view");
        y.d(chat_look_image_view, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.activity.ChatLookImageActivity$bindClickEvent$1
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
                ChatLookImageActivity.this.finish();
            }
        });
    }

    public final void l1() {
        Intent intent = getIntent();
        s.h(intent, "intent");
        ChatLookImageData chatLookImageData = (ChatLookImageData) g.a(intent, ChatLookImageData.class);
        if (chatLookImageData == null) {
            finish();
            return;
        }
        if (chatLookImageData.getImage() != null) {
            ImageLoaderView chat_look_image_view = (ImageLoaderView) j1(R$id.chat_look_image_view);
            s.h(chat_look_image_view, "chat_look_image_view");
            ImageLoaderView.g(chat_look_image_view, chatLookImageData.getImage(), null, null, 6, null);
            return;
        }
        String imagePath = chatLookImageData.getImagePath();
        if (!(imagePath == null || imagePath.length() == 0)) {
            ImageLoaderView chat_look_image_view2 = (ImageLoaderView) j1(R$id.chat_look_image_view);
            s.h(chat_look_image_view2, "chat_look_image_view");
            ImageLoaderView.f(chat_look_image_view2, new com.cupidapp.live.base.imageloader.b(false, chatLookImageData.getImagePath(), null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524285, null), null, 2, null);
        } else {
            String snapImageLargeUrl = chatLookImageData.getSnapImageLargeUrl();
            if (snapImageLargeUrl == null || snapImageLargeUrl.length() == 0) {
                return;
            }
            ImageLoaderView chat_look_image_view3 = (ImageLoaderView) j1(R$id.chat_look_image_view);
            s.h(chat_look_image_view3, "chat_look_image_view");
            ImageLoaderView.f(chat_look_image_view3, new com.cupidapp.live.base.imageloader.b(false, chatLookImageData.getSnapImageLargeUrl(), null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524285, null), null, 2, null);
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_chat_look_image);
        p0.a(this);
        d1(R$anim.anim_activity_nothing, null);
        l1();
        k1();
    }
}
