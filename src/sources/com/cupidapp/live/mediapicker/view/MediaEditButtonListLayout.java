package com.cupidapp.live.mediapicker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.decoration.FKAddExtraSpacingDecoration;
import com.cupidapp.live.mediapicker.adapter.MediaEditButtonListAdapter;
import com.cupidapp.live.mediapicker.model.MediaEditButtonViewModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: MediaEditButtonListLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class MediaEditButtonListLayout extends CustomAnimationLayout {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Lazy f17414c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Lazy f17415d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public f f17416e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f17417f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final MediaEditButtonListAdapter f17418g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17419h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaEditButtonListLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f17419h = new LinkedHashMap();
        this.f17414c = kotlin.c.b(MediaEditButtonListLayout$imageEditButtonList$2.INSTANCE);
        this.f17415d = kotlin.c.b(MediaEditButtonListLayout$videoEditButtonList$2.INSTANCE);
        this.f17417f = true;
        MediaEditButtonListAdapter mediaEditButtonListAdapter = new MediaEditButtonListAdapter();
        mediaEditButtonListAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.mediapicker.view.MediaEditButtonListLayout$mediaEditAdapter$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                boolean z10;
                f fVar;
                if (obj instanceof MediaEditButtonViewModel) {
                    z10 = MediaEditButtonListLayout.this.f17417f;
                    if (z10) {
                        MediaEditButtonListLayout mediaEditButtonListLayout = MediaEditButtonListLayout.this;
                        Property<View, Float> ALPHA = View.ALPHA;
                        s.h(ALPHA, "ALPHA");
                        mediaEditButtonListLayout.b(ALPHA);
                        fVar = MediaEditButtonListLayout.this.f17416e;
                        if (fVar != null) {
                            fVar.a((MediaEditButtonViewModel) obj);
                        }
                    }
                }
            }
        });
        this.f17418g = mediaEditButtonListAdapter;
        j();
    }

    private final List<MediaEditButtonViewModel> getImageEditButtonList() {
        return (List) this.f17414c.getValue();
    }

    private final List<MediaEditButtonViewModel> getVideoEditButtonList() {
        return (List) this.f17415d.getValue();
    }

    @Nullable
    public View f(int i10) {
        Map<Integer, View> map = this.f17419h;
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

    public final void i(boolean z10) {
        if (z10) {
            this.f17418g.e(getImageEditButtonList());
        } else {
            this.f17418g.e(getVideoEditButtonList());
        }
        this.f17418g.notifyDataSetChanged();
    }

    public final void j() {
        z.a(this, R$layout.layout_media_edit_button_list, true);
        int i10 = R$id.buttonListRecyclerView;
        ((RecyclerView) f(i10)).setAdapter(this.f17418g);
        ((RecyclerView) f(i10)).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        int c4 = z0.h.c(this, 7.5f);
        ((RecyclerView) f(i10)).addItemDecoration(new FKAddExtraSpacingDecoration(c4, 0, c4, 0, c4, 0, 32, null));
        ((BottomConfirmAndCancelLayout) f(R$id.buttonListSelectLayout)).setVisibility(8);
    }

    public final void setMediaEditButtonListListener(@NotNull f listener) {
        s.i(listener, "listener");
        this.f17416e = listener;
    }

    public final void setRecyclerViewEnable(boolean z10) {
        ((RecyclerView) f(R$id.buttonListRecyclerView)).setAlpha(z10 ? 1.0f : 0.5f);
        this.f17417f = z10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaEditButtonListLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f17419h = new LinkedHashMap();
        this.f17414c = kotlin.c.b(MediaEditButtonListLayout$imageEditButtonList$2.INSTANCE);
        this.f17415d = kotlin.c.b(MediaEditButtonListLayout$videoEditButtonList$2.INSTANCE);
        this.f17417f = true;
        MediaEditButtonListAdapter mediaEditButtonListAdapter = new MediaEditButtonListAdapter();
        mediaEditButtonListAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.mediapicker.view.MediaEditButtonListLayout$mediaEditAdapter$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                boolean z10;
                f fVar;
                if (obj instanceof MediaEditButtonViewModel) {
                    z10 = MediaEditButtonListLayout.this.f17417f;
                    if (z10) {
                        MediaEditButtonListLayout mediaEditButtonListLayout = MediaEditButtonListLayout.this;
                        Property<View, Float> ALPHA = View.ALPHA;
                        s.h(ALPHA, "ALPHA");
                        mediaEditButtonListLayout.b(ALPHA);
                        fVar = MediaEditButtonListLayout.this.f17416e;
                        if (fVar != null) {
                            fVar.a((MediaEditButtonViewModel) obj);
                        }
                    }
                }
            }
        });
        this.f17418g = mediaEditButtonListAdapter;
        j();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaEditButtonListLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f17419h = new LinkedHashMap();
        this.f17414c = kotlin.c.b(MediaEditButtonListLayout$imageEditButtonList$2.INSTANCE);
        this.f17415d = kotlin.c.b(MediaEditButtonListLayout$videoEditButtonList$2.INSTANCE);
        this.f17417f = true;
        MediaEditButtonListAdapter mediaEditButtonListAdapter = new MediaEditButtonListAdapter();
        mediaEditButtonListAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.mediapicker.view.MediaEditButtonListLayout$mediaEditAdapter$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                boolean z10;
                f fVar;
                if (obj instanceof MediaEditButtonViewModel) {
                    z10 = MediaEditButtonListLayout.this.f17417f;
                    if (z10) {
                        MediaEditButtonListLayout mediaEditButtonListLayout = MediaEditButtonListLayout.this;
                        Property<View, Float> ALPHA = View.ALPHA;
                        s.h(ALPHA, "ALPHA");
                        mediaEditButtonListLayout.b(ALPHA);
                        fVar = MediaEditButtonListLayout.this.f17416e;
                        if (fVar != null) {
                            fVar.a((MediaEditButtonViewModel) obj);
                        }
                    }
                }
            }
        });
        this.f17418g = mediaEditButtonListAdapter;
        j();
    }
}
