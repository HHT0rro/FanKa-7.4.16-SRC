package com.cupidapp.live.mediapicker.helper;

import android.content.Context;
import com.cupidapp.live.base.network.j;
import com.cupidapp.live.feed.model.PostBoostModel;
import com.cupidapp.live.mediapicker.model.PublishViewModel;
import com.cupidapp.live.mediapicker.model.UploadState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.x;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedPublishManager.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PublishManager {

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public static PublishViewModel f17236c;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final PublishManager f17234a = new PublishManager();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static List<PublishViewModel> f17235b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static List<d> f17237d = new ArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void i(PublishManager publishManager, Context context, PublishViewModel publishViewModel, Function2 function2, Function0 function0, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            function2 = null;
        }
        if ((i10 & 8) != 0) {
            function0 = null;
        }
        publishManager.h(context, publishViewModel, function2, function0);
    }

    public final void c(@NotNull d listener) {
        s.i(listener, "listener");
        f17237d.add(listener);
    }

    public final boolean d(Context context) {
        PublishViewModel publishViewModel = null;
        f17236c = null;
        Iterator<PublishViewModel> iterator2 = f17235b.iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                break;
            }
            PublishViewModel next = iterator2.next();
            if (next.getState() == UploadState.Uploading) {
                publishViewModel = next;
                break;
            }
        }
        PublishViewModel publishViewModel2 = publishViewModel;
        if (publishViewModel2 == null) {
            return true;
        }
        i(this, context, publishViewModel2, null, null, 12, null);
        return false;
    }

    public final boolean e(Context context, PublishViewModel publishViewModel) {
        if (publishViewModel.getState() != UploadState.Success) {
            publishViewModel.setState(UploadState.Error);
        }
        Iterator<d> iterator2 = f17237d.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().i0(publishViewModel);
        }
        return d(context);
    }

    public final boolean f(Context context, final PublishViewModel publishViewModel) {
        if (f17235b.contains(publishViewModel)) {
            x.B(f17235b, new Function1<PublishViewModel, Boolean>() { // from class: com.cupidapp.live.mediapicker.helper.PublishManager$publishSuccess$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull PublishViewModel it) {
                    s.i(it, "it");
                    return Boolean.valueOf(s.d(it, PublishViewModel.this));
                }
            });
        }
        UploadState state = publishViewModel.getState();
        UploadState uploadState = UploadState.Success;
        if (state != uploadState) {
            publishViewModel.setState(uploadState);
        }
        Iterator<d> iterator2 = f17237d.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().U(publishViewModel);
        }
        return d(context);
    }

    public final void g(@NotNull d listener) {
        s.i(listener, "listener");
        f17237d.remove(listener);
    }

    public final void h(@NotNull final Context context, @NotNull PublishViewModel viewModel, @Nullable final Function2<? super PostBoostModel, ? super String, p> function2, @Nullable final Function0<p> function0) {
        s.i(context, "context");
        s.i(viewModel, "viewModel");
        if (f17236c == null) {
            f17236c = viewModel;
            viewModel.startPublish(context, new Function1<PublishViewModel, p>() { // from class: com.cupidapp.live.mediapicker.helper.PublishManager$startPublish$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(PublishViewModel publishViewModel) {
                    invoke2(publishViewModel);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull PublishViewModel it) {
                    boolean f10;
                    Function2<PostBoostModel, String, p> function22;
                    s.i(it, "it");
                    f10 = PublishManager.f17234a.f(context, it);
                    if (!f10 || (function22 = function2) == null) {
                        return;
                    }
                    function22.mo1743invoke(it.getPostBoost(), it.getJumpUrl());
                }
            }, new Function2<Throwable, PublishViewModel, p>() { // from class: com.cupidapp.live.mediapicker.helper.PublishManager$startPublish$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ p mo1743invoke(Throwable th, PublishViewModel publishViewModel) {
                    invoke2(th, publishViewModel);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Throwable exception, @NotNull PublishViewModel publishModel) {
                    s.i(exception, "exception");
                    s.i(publishModel, "publishModel");
                    PublishManager.f17234a.e(context, publishModel);
                    Function0<p> function02 = function0;
                    if (function02 != null) {
                        function02.invoke();
                    }
                    j.f12008a.e(exception, null, null, null);
                }
            });
        }
        if (f17235b.contains(viewModel)) {
            return;
        }
        f17235b.add(0, viewModel);
        Iterator<d> iterator2 = f17237d.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().G(viewModel);
        }
    }
}
