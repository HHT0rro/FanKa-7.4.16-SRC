package com.cupidapp.live.mediapicker.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.extension.ImageAttributeModel;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.utils.ImageResizeUtils;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.decoration.FKAddExtraSpacingDecoration;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.base.view.progress.ProgressBarDialog;
import com.cupidapp.live.mediapicker.adapter.AddImageViewModel;
import com.cupidapp.live.mediapicker.adapter.ImageEditAdapter;
import com.cupidapp.live.mediapicker.adapter.ImageEditViewModel;
import com.cupidapp.live.mediapicker.fragment.ImageEditFragment;
import com.cupidapp.live.mediapicker.helper.ImageEditTouchHelperCallback;
import com.cupidapp.live.mediapicker.holder.AddImageViewHolder;
import com.cupidapp.live.mediapicker.holder.ImageEditViewHolder;
import com.cupidapp.live.mediapicker.model.FrameAspectRatio;
import com.cupidapp.live.mediapicker.model.ImageAttributeViewModel;
import com.cupidapp.live.mediapicker.model.MediaEditButtonViewModel;
import com.cupidapp.live.mediapicker.model.UpdateImageEditPathEventModel;
import com.cupidapp.live.mediapicker.newmediapicker.data.ImagePickedData;
import com.cupidapp.live.mediapicker.view.ImageDragDeleteButton;
import com.cupidapp.live.mediapicker.view.ImageEditFrameListLayout;
import com.cupidapp.live.mediapicker.view.MediaEditButtonListLayout;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.i0;
import kotlin.collections.t;
import kotlin.collections.x;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.z;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ImageEditFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ImageEditFragment extends FKBaseFragment {

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public static final a f17165l = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public b f17166e;

    /* renamed from: h, reason: collision with root package name */
    public int f17169h;

    /* renamed from: j, reason: collision with root package name */
    public boolean f17171j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17172k = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final ImageEditAdapter f17167f = new ImageEditAdapter();

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public List<ImageAttributeViewModel> f17168g = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public FrameAspectRatio f17170i = FrameAspectRatio.DEFAULT;

    /* compiled from: ImageEditFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class Config implements Serializable {

        @NotNull
        private final Map<String, String> pathMap;

        public Config(@NotNull Map<String, String> pathMap) {
            s.i(pathMap, "pathMap");
            this.pathMap = pathMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Config copy$default(Config config, Map map, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                map = config.pathMap;
            }
            return config.copy(map);
        }

        @NotNull
        public final Map<String, String> component1() {
            return this.pathMap;
        }

        @NotNull
        public final Config copy(@NotNull Map<String, String> pathMap) {
            s.i(pathMap, "pathMap");
            return new Config(pathMap);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Config) && s.d(this.pathMap, ((Config) obj).pathMap);
        }

        @NotNull
        public final Map<String, String> getPathMap() {
            return this.pathMap;
        }

        public int hashCode() {
            return this.pathMap.hashCode();
        }

        @NotNull
        public String toString() {
            return "Config(pathMap=" + ((Object) this.pathMap) + ")";
        }
    }

    /* compiled from: ImageEditFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ImageEditFragment a(@NotNull Config config, @NotNull b listener) {
            s.i(config, "config");
            s.i(listener, "listener");
            ImageEditFragment imageEditFragment = new ImageEditFragment();
            Bundle bundle = new Bundle();
            z0.g.d(bundle, config);
            imageEditFragment.setArguments(bundle);
            imageEditFragment.f17166e = listener;
            return imageEditFragment;
        }
    }

    /* compiled from: ImageEditFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {
        void a();

        void b(@NotNull List<ImageAttributeViewModel> list, boolean z10);

        void c(@NotNull ImageAttributeViewModel imageAttributeViewModel);

        void d();
    }

    /* compiled from: ImageEditFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements com.cupidapp.live.mediapicker.view.f {
        public c() {
        }

        @Override // com.cupidapp.live.mediapicker.view.f
        public void a(@NotNull MediaEditButtonViewModel model) {
            s.i(model, "model");
            ImageEditFragment.this.f17171j = true;
            if (model.getButtonType() == MediaEditButtonViewModel.EditButtonEnum.Frame) {
                ImageEditFragment.U1(ImageEditFragment.this, false, false, 2, null);
                ImageEditFragment imageEditFragment = ImageEditFragment.this;
                String string = imageEditFragment.getString(R$string.edit_frame);
                s.h(string, "getString(R.string.edit_frame)");
                imageEditFragment.y1(true, string);
                ImageEditFragment imageEditFragment2 = ImageEditFragment.this;
                int i10 = R$id.imageEditFrameListLayout;
                ImageEditFrameListLayout imageEditFrameListLayout = (ImageEditFrameListLayout) imageEditFragment2.T0(i10);
                Property<View, Float> Y = View.Y;
                s.h(Y, "Y");
                imageEditFrameListLayout.e(Y);
                ImageEditFrameListLayout imageEditFrameListLayout2 = (ImageEditFrameListLayout) ImageEditFragment.this.T0(i10);
                s.h(imageEditFrameListLayout2, "imageEditFrameListLayout");
                ImageAttributeViewModel C1 = ImageEditFragment.this.C1();
                ImageEditFrameListLayout.j(imageEditFrameListLayout2, C1 != null ? C1.getFrameType() : null, false, 2, null);
            }
        }
    }

    /* compiled from: ImageEditFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d implements com.cupidapp.live.mediapicker.view.e {
        public d() {
        }

        @Override // com.cupidapp.live.mediapicker.view.e
        public void a() {
            ImageEditFragment imageEditFragment = ImageEditFragment.this;
            ImageAttributeViewModel C1 = imageEditFragment.C1();
            imageEditFragment.Q1(C1 != null ? C1.getFrameType() : null);
            ImageEditFragment.U1(ImageEditFragment.this, true, false, 2, null);
            MediaEditButtonListLayout mediaEditButtonListLayout = (MediaEditButtonListLayout) ImageEditFragment.this.T0(R$id.imageEditButtonListLayout);
            Property<View, Float> ALPHA = View.ALPHA;
            s.h(ALPHA, "ALPHA");
            mediaEditButtonListLayout.e(ALPHA);
            ImageEditFragment.z1(ImageEditFragment.this, false, null, 2, null);
        }

        @Override // com.cupidapp.live.mediapicker.view.e
        public void b(@NotNull FrameAspectRatio frameType) {
            s.i(frameType, "frameType");
            ImageEditFragment.this.Q1(frameType);
        }

        @Override // com.cupidapp.live.mediapicker.view.e
        public void c(@NotNull FrameAspectRatio frameType) {
            s.i(frameType, "frameType");
            ImageEditFragment.this.f17170i = frameType;
            Iterator<E> iterator2 = ImageEditFragment.this.f17168g.iterator2();
            while (iterator2.hasNext()) {
                ((ImageAttributeViewModel) iterator2.next()).setFrameType(frameType);
            }
            ImageEditFragment.U1(ImageEditFragment.this, true, false, 2, null);
            MediaEditButtonListLayout mediaEditButtonListLayout = (MediaEditButtonListLayout) ImageEditFragment.this.T0(R$id.imageEditButtonListLayout);
            Property<View, Float> ALPHA = View.ALPHA;
            s.h(ALPHA, "ALPHA");
            mediaEditButtonListLayout.e(ALPHA);
            ImageEditFragment.z1(ImageEditFragment.this, false, null, 2, null);
        }
    }

    /* compiled from: ImageEditFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class e implements ImageEditTouchHelperCallback.b {
        public e() {
        }

        @Override // com.cupidapp.live.mediapicker.helper.ImageEditTouchHelperCallback.b
        public void a(float f10) {
            ((ImageDragDeleteButton) ImageEditFragment.this.T0(R$id.imageDragDeleteButton)).b(f10);
        }

        @Override // com.cupidapp.live.mediapicker.helper.ImageEditTouchHelperCallback.b
        public void b(@NotNull RecyclerView.ViewHolder viewHolder) {
            s.i(viewHolder, "viewHolder");
            viewHolder.itemView.setVisibility(4);
            ImageEditFragment imageEditFragment = ImageEditFragment.this;
            if (imageEditFragment.u1(imageEditFragment.f17169h)) {
                ImageEditFragment.this.f17168g.remove(ImageEditFragment.this.f17169h);
            }
            ImageEditFragment imageEditFragment2 = ImageEditFragment.this;
            if (imageEditFragment2.v1(imageEditFragment2.f17169h)) {
                ImageEditFragment.this.f17167f.j().remove(ImageEditFragment.this.f17169h);
                ImageEditFragment.this.T1(true, true);
            }
            ImagePickedData.INSTANCE.remove(ImageEditFragment.this.f17169h);
        }

        @Override // com.cupidapp.live.mediapicker.helper.ImageEditTouchHelperCallback.b
        public void c(@Nullable RecyclerView.ViewHolder viewHolder, int i10) {
            ImageEditFragment.this.x1(viewHolder, i10);
        }
    }

    public static final void R1(ImageEditFragment this$0, FrameAspectRatio frameAspectRatio) {
        s.i(this$0, "this$0");
        for (Object obj : this$0.f17167f.j()) {
            if (obj instanceof ImageEditViewModel) {
                ((ImageEditViewModel) obj).setFrameSize(frameAspectRatio.getRatio());
            } else if (obj instanceof AddImageViewModel) {
                ((AddImageViewModel) obj).setFrameSize(frameAspectRatio.getRatio());
            }
        }
        this$0.f17167f.notifyDataSetChanged();
    }

    public static /* synthetic */ void U1(ImageEditFragment imageEditFragment, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        imageEditFragment.T1(z10, z11);
    }

    public static /* synthetic */ void z1(ImageEditFragment imageEditFragment, boolean z10, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = "";
        }
        imageEditFragment.y1(z10, str);
    }

    public final void A1(boolean z10) {
        int findFirstVisibleItemPosition;
        int findLastVisibleItemPosition;
        int i10 = z10 ? 4 : 0;
        RecyclerView.LayoutManager layoutManager = ((RecyclerView) T0(R$id.imageEditRecyclerView)).getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null || (findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()) > (findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition())) {
            return;
        }
        while (true) {
            ImageEditViewHolder D1 = D1(findFirstVisibleItemPosition);
            if (D1 != null) {
                D1.t(i10);
            }
            if (findFirstVisibleItemPosition == findLastVisibleItemPosition) {
                return;
            } else {
                findFirstVisibleItemPosition++;
            }
        }
    }

    public final void B1() {
        Context context = getContext();
        if (context != null) {
            ArrayList arrayList = new ArrayList();
            List<ImageAttributeViewModel> list = this.f17168g;
            ArrayList arrayList2 = new ArrayList(t.t(list, 10));
            Iterator<ImageAttributeViewModel> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                arrayList2.add(iterator2.next().getImageViewPath());
            }
            arrayList.addAll(CollectionsKt___CollectionsKt.z0(arrayList2));
            if (!arrayList.isEmpty()) {
                ((ProgressBarDialog) T0(R$id.progressBarDialog)).setVisibility(0);
                ImageResizeUtils.f12268a.i(context, this, this.f17170i, arrayList, new Function1<Map<String, String>, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.ImageEditFragment$generateUploadImageFile$1$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Map<String, String> map) {
                        invoke2(map);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Map<String, String> map) {
                        if (!(map == null || map.isEmpty())) {
                            for (ImageAttributeViewModel imageAttributeViewModel : ImageEditFragment.this.f17168g) {
                                imageAttributeViewModel.setUploadImagePath(String.valueOf(map.get(imageAttributeViewModel.getImageViewPath())));
                            }
                        }
                        ImageEditFragment.this.E1();
                    }
                });
            }
        }
    }

    public final ImageAttributeViewModel C1() {
        if (u1(this.f17169h)) {
            return this.f17168g.get(this.f17169h);
        }
        if ((!this.f17168g.isEmpty()) && this.f17169h == this.f17168g.size()) {
            return this.f17168g.get(this.f17169h - 1);
        }
        return null;
    }

    public final ImageEditViewHolder D1(int i10) {
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = ((RecyclerView) T0(R$id.imageEditRecyclerView)).findViewHolderForLayoutPosition(i10);
        if (findViewHolderForLayoutPosition instanceof ImageEditViewHolder) {
            return (ImageEditViewHolder) findViewHolderForLayoutPosition;
        }
        return null;
    }

    public final void E1() {
        ((ProgressBarDialog) T0(R$id.progressBarDialog)).c(true, new Function0<kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.ImageEditFragment$hideProgressBar$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                invoke2();
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ImageEditFragment.b bVar;
                boolean z10;
                ((ProgressBarDialog) ImageEditFragment.this.T0(R$id.progressBarDialog)).setVisibility(8);
                bVar = ImageEditFragment.this.f17166e;
                if (bVar != null) {
                    List<ImageAttributeViewModel> list = ImageEditFragment.this.f17168g;
                    z10 = ImageEditFragment.this.f17171j;
                    bVar.b(list, z10);
                }
            }
        });
    }

    public final void F1() {
        RecyclerView.LayoutManager layoutManager = ((RecyclerView) T0(R$id.imageEditRecyclerView)).getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            return;
        }
        int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
        if (findFirstCompletelyVisibleItemPosition == linearLayoutManager.findLastCompletelyVisibleItemPosition() && findFirstCompletelyVisibleItemPosition >= 0 && findFirstCompletelyVisibleItemPosition < this.f17167f.j().size()) {
            this.f17169h = findFirstCompletelyVisibleItemPosition;
        }
        A1(t1());
        O1();
    }

    public final void G1(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        Iterator<Map.Entry<String, String>> iterator2 = map.entrySet().iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next().getValue());
        }
        ArrayList arrayList2 = new ArrayList();
        float s12 = s1(arrayList);
        FrameAspectRatio.DEFAULT.setRatio(s12);
        this.f17168g.clear();
        this.f17169h = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList2.add(new ImageEditViewModel(entry.getValue(), s12));
            this.f17168g.add(new ImageAttributeViewModel(entry.getKey(), entry.getValue(), entry.getValue(), null, entry.getValue(), FrameAspectRatio.DEFAULT, null, 64, null));
        }
        M1(arrayList2, true, 0);
    }

    public final void H1() {
        int i10 = R$id.imageEditButtonListLayout;
        ((MediaEditButtonListLayout) T0(i10)).i(true);
        ((MediaEditButtonListLayout) T0(i10)).setMediaEditButtonListListener(new c());
    }

    public final void I1() {
        ((ImageEditFrameListLayout) T0(R$id.imageEditFrameListLayout)).setImageEditFrameListListener(new d());
    }

    public final void J1() {
        int i10 = R$id.imageEditRecyclerView;
        RecyclerView initImageEditRecyclerView$lambda$10 = (RecyclerView) T0(i10);
        initImageEditRecyclerView$lambda$10.setLayoutManager(new LinearLayoutManager(initImageEditRecyclerView$lambda$10.getContext(), 0, false));
        initImageEditRecyclerView$lambda$10.setAdapter(this.f17167f);
        s.h(initImageEditRecyclerView$lambda$10, "initImageEditRecyclerView$lambda$10");
        initImageEditRecyclerView$lambda$10.addItemDecoration(new FKAddExtraSpacingDecoration(0, 0, 0, 0, (int) ((z0.h.l(initImageEditRecyclerView$lambda$10) - ImageEditViewHolder.f17252c.b(initImageEditRecyclerView$lambda$10.getContext())) / 2.0f), 0, 47, null));
        initImageEditRecyclerView$lambda$10.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.cupidapp.live.mediapicker.fragment.ImageEditFragment$initImageEditRecyclerView$1$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i11) {
                s.i(recyclerView, "recyclerView");
                if (i11 == 0) {
                    ImageEditFragment.this.F1();
                }
            }
        });
        new PagerSnapHelper().attachToRecyclerView((RecyclerView) T0(i10));
        ImageEditTouchHelperCallback imageEditTouchHelperCallback = new ImageEditTouchHelperCallback();
        imageEditTouchHelperCallback.a(new e());
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(imageEditTouchHelperCallback);
        itemTouchHelper.attachToRecyclerView((RecyclerView) T0(i10));
        this.f17167f.l().j(i0.h(kotlin.f.a(Integer.valueOf(R$id.imageTrimAndRotationImageView), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.ImageEditFragment$initImageEditRecyclerView$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:3:0x0008, code lost:
            
                r0 = r1.this$0.f17166e;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
                /*
                    r1 = this;
                    com.cupidapp.live.mediapicker.fragment.ImageEditFragment r2 = com.cupidapp.live.mediapicker.fragment.ImageEditFragment.this
                    com.cupidapp.live.mediapicker.model.ImageAttributeViewModel r2 = com.cupidapp.live.mediapicker.fragment.ImageEditFragment.a1(r2)
                    if (r2 == 0) goto L13
                    com.cupidapp.live.mediapicker.fragment.ImageEditFragment r0 = com.cupidapp.live.mediapicker.fragment.ImageEditFragment.this
                    com.cupidapp.live.mediapicker.fragment.ImageEditFragment$b r0 = com.cupidapp.live.mediapicker.fragment.ImageEditFragment.e1(r0)
                    if (r0 == 0) goto L13
                    r0.c(r2)
                L13:
                    com.cupidapp.live.mediapicker.fragment.ImageEditFragment r2 = com.cupidapp.live.mediapicker.fragment.ImageEditFragment.this
                    r0 = 1
                    com.cupidapp.live.mediapicker.fragment.ImageEditFragment.l1(r2, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.mediapicker.fragment.ImageEditFragment$initImageEditRecyclerView$2.invoke2(java.lang.Object):void");
            }
        }), kotlin.f.a(Integer.valueOf(R$id.addImageCardView), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.ImageEditFragment$initImageEditRecyclerView$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
            
                r1 = r0.this$0.f17166e;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(@org.jetbrains.annotations.Nullable java.lang.Object r1) {
                /*
                    r0 = this;
                    boolean r1 = r1 instanceof com.cupidapp.live.mediapicker.adapter.AddImageViewModel
                    if (r1 == 0) goto Lf
                    com.cupidapp.live.mediapicker.fragment.ImageEditFragment r1 = com.cupidapp.live.mediapicker.fragment.ImageEditFragment.this
                    com.cupidapp.live.mediapicker.fragment.ImageEditFragment$b r1 = com.cupidapp.live.mediapicker.fragment.ImageEditFragment.e1(r1)
                    if (r1 == 0) goto Lf
                    r1.d()
                Lf:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.mediapicker.fragment.ImageEditFragment$initImageEditRecyclerView$3.invoke2(java.lang.Object):void");
            }
        })));
        this.f17167f.l().h(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.ImageEditFragment$initImageEditRecyclerView$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:12:0x0033, code lost:
            
                r3 = r2.this$0.D1(r3);
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
                /*
                    r2 = this;
                    boolean r0 = r3 instanceof com.cupidapp.live.mediapicker.adapter.ImageEditViewModel
                    if (r0 == 0) goto L40
                    com.cupidapp.live.mediapicker.fragment.ImageEditFragment r0 = com.cupidapp.live.mediapicker.fragment.ImageEditFragment.this
                    com.cupidapp.live.mediapicker.adapter.ImageEditAdapter r0 = com.cupidapp.live.mediapicker.fragment.ImageEditFragment.d1(r0)
                    java.util.List r0 = r0.j()
                    int r3 = r0.indexOf(r3)
                    com.cupidapp.live.mediapicker.fragment.ImageEditFragment r0 = com.cupidapp.live.mediapicker.fragment.ImageEditFragment.this
                    com.cupidapp.live.mediapicker.adapter.ImageEditAdapter r0 = com.cupidapp.live.mediapicker.fragment.ImageEditFragment.d1(r0)
                    java.util.List r0 = r0.j()
                    int r0 = r0.size()
                    r1 = 0
                    if (r3 < 0) goto L26
                    if (r3 >= r0) goto L26
                    r1 = 1
                L26:
                    if (r1 == 0) goto L40
                    com.cupidapp.live.mediapicker.fragment.ImageEditFragment r1 = com.cupidapp.live.mediapicker.fragment.ImageEditFragment.this
                    boolean r1 = com.cupidapp.live.mediapicker.fragment.ImageEditFragment.U0(r1)
                    if (r1 != 0) goto L40
                    r1 = 3
                    if (r0 < r1) goto L40
                    com.cupidapp.live.mediapicker.fragment.ImageEditFragment r0 = com.cupidapp.live.mediapicker.fragment.ImageEditFragment.this
                    com.cupidapp.live.mediapicker.holder.ImageEditViewHolder r3 = com.cupidapp.live.mediapicker.fragment.ImageEditFragment.f1(r0, r3)
                    if (r3 == 0) goto L40
                    androidx.recyclerview.widget.ItemTouchHelper r0 = r2
                    r0.startDrag(r3)
                L40:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.mediapicker.fragment.ImageEditFragment$initImageEditRecyclerView$4.invoke2(java.lang.Object):void");
            }
        });
    }

    public final void K1() {
        int i10 = R$id.imageEditTitleBarLayout;
        ((FKTitleBarLayout) T0(i10)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.ImageEditFragment$initTitleBarLayoutClickEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                boolean S1;
                ImageEditFragment.b bVar;
                S1 = ImageEditFragment.this.S1();
                if (S1) {
                    ImageEditFragment.this.P1();
                    return;
                }
                bVar = ImageEditFragment.this.f17166e;
                if (bVar != null) {
                    bVar.a();
                }
            }
        });
        ((FKTitleBarLayout) T0(i10)).setRightTextClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.ImageEditFragment$initTitleBarLayoutClickEvent$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                ImageEditFragment.this.B1();
            }
        });
    }

    public final boolean L1() {
        if (!S1()) {
            return true;
        }
        P1();
        return false;
    }

    public final void M1(List<ImageEditViewModel> list, boolean z10, int i10) {
        if (z10) {
            this.f17167f.j().clear();
        }
        this.f17167f.e(list);
        U1(this, true, false, 2, null);
        ((RecyclerView) T0(R$id.imageEditRecyclerView)).scrollToPosition(i10);
        O1();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f17172k.clear();
    }

    public final void N1(int i10, String str) {
        if (v1(i10)) {
            Object obj = this.f17167f.j().get(i10);
            if (obj instanceof ImageEditViewModel) {
                ((ImageEditViewModel) obj).setPath(str);
            }
            this.f17167f.notifyItemChanged(i10);
        }
    }

    public final void O1() {
        if (this.f17169h == this.f17168g.size()) {
            ((MediaEditButtonListLayout) T0(R$id.imageEditButtonListLayout)).setRecyclerViewEnable(false);
        } else {
            ((MediaEditButtonListLayout) T0(R$id.imageEditButtonListLayout)).setRecyclerViewEnable(true);
        }
    }

    public final void P1() {
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, getContext(), false, 2, null), R$string.media_edit_back_alert, 0, 2, null), R$string.continue_to_return, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.mediapicker.fragment.ImageEditFragment$showCloseFragmentAlertDialog$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                invoke2();
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ImageEditFragment.b bVar;
                bVar = ImageEditFragment.this.f17166e;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }, 2, null), 0, null, 3, null), null, 1, null);
    }

    public final void Q1(final FrameAspectRatio frameAspectRatio) {
        if (frameAspectRatio == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = ((RecyclerView) T0(R$id.imageEditRecyclerView)).getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            return;
        }
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
            while (true) {
                ImageEditViewHolder D1 = D1(findFirstVisibleItemPosition);
                if (D1 != null) {
                    D1.w(frameAspectRatio.getRatio());
                }
                RecyclerView.ViewHolder findViewHolderForLayoutPosition = ((RecyclerView) T0(R$id.imageEditRecyclerView)).findViewHolderForLayoutPosition(findFirstVisibleItemPosition);
                AddImageViewHolder addImageViewHolder = findViewHolderForLayoutPosition instanceof AddImageViewHolder ? (AddImageViewHolder) findViewHolderForLayoutPosition : null;
                if (addImageViewHolder != null) {
                    addImageViewHolder.s(frameAspectRatio.getRatio());
                }
                if (findFirstVisibleItemPosition == findLastVisibleItemPosition) {
                    break;
                } else {
                    findFirstVisibleItemPosition++;
                }
            }
        }
        ((RecyclerView) T0(R$id.imageEditRecyclerView)).postDelayed(new Runnable() { // from class: com.cupidapp.live.mediapicker.fragment.a
            @Override // java.lang.Runnable
            public final void run() {
                ImageEditFragment.R1(ImageEditFragment.this, frameAspectRatio);
            }
        }, 300L);
    }

    public final boolean S1() {
        Iterator<ImageAttributeViewModel> iterator2 = this.f17168g.iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().getFrameType() != FrameAspectRatio.DEFAULT) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public View T0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f17172k;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i10)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void T1(boolean z10, boolean z11) {
        FrameAspectRatio frameAspectRatio;
        List<Object> j10 = this.f17167f.j();
        List<Object> j11 = this.f17167f.j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : j11) {
            if (obj instanceof AddImageViewModel) {
                arrayList.add(obj);
            }
        }
        j10.removeAll(arrayList);
        if (z10 && this.f17167f.j().size() < 9) {
            ImageAttributeViewModel C1 = C1();
            if (C1 == null || (frameAspectRatio = C1.getFrameType()) == null) {
                frameAspectRatio = FrameAspectRatio.DEFAULT;
            }
            this.f17167f.d(new AddImageViewModel(frameAspectRatio.getRatio()));
        }
        if (z11) {
            this.f17167f.notifyItemRemoved(this.f17169h);
        } else {
            this.f17167f.notifyDataSetChanged();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_image_edit, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull UpdateImageEditPathEventModel event) {
        s.i(event, "event");
        Iterator<ImageAttributeViewModel> iterator2 = this.f17168g.iterator2();
        int i10 = 0;
        while (true) {
            if (!iterator2.hasNext()) {
                i10 = -1;
                break;
            } else if (s.d(iterator2.next().getCompressedImagePath(), event.getCompressedImagePath())) {
                break;
            } else {
                i10++;
            }
        }
        if (u1(i10)) {
            String effectImagePathAfterTrim = event.getEffectImagePathAfterTrim();
            if (!(effectImagePathAfterTrim == null || effectImagePathAfterTrim.length() == 0)) {
                ImageAttributeViewModel imageAttributeViewModel = this.f17168g.get(i10);
                imageAttributeViewModel.setImageViewPath(event.getEffectImagePathAfterTrim());
                imageAttributeViewModel.setAfterTrimOriginalImagePath(event.getAfterTrimOriginalImagePath());
                imageAttributeViewModel.setAfterTrimImageBoundRectF(event.getAfterTrimImageBoundRectF());
            }
        }
        String effectImagePathAfterTrim2 = event.getEffectImagePathAfterTrim();
        if (effectImagePathAfterTrim2 == null || effectImagePathAfterTrim2.length() == 0) {
            return;
        }
        N1(i10, event.getEffectImagePathAfterTrim());
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Config config;
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        J1();
        K1();
        H1();
        I1();
        Bundle arguments = getArguments();
        if (arguments == null || (config = (Config) z0.g.b(arguments, Config.class)) == null) {
            return;
        }
        G1(config.getPathMap());
    }

    public final void q1(@NotNull Map<String, String> pathMap) {
        FrameAspectRatio frameAspectRatio;
        s.i(pathMap, "pathMap");
        if (pathMap.isEmpty()) {
            return;
        }
        List<ImageAttributeViewModel> list = this.f17168g;
        ArrayList<String> arrayList = new ArrayList(t.t(list, 10));
        Iterator<ImageAttributeViewModel> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next().getCompressedImagePath());
        }
        for (final String str : arrayList) {
            if (pathMap.containsValue(str)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, String> entry : pathMap.entrySet()) {
                    if (s.d(entry.getValue(), str)) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                z.d(pathMap).remove((String) CollectionsKt___CollectionsKt.U(linkedHashMap.h()));
            } else {
                x.B(this.f17168g, new Function1<ImageAttributeViewModel, Boolean>() { // from class: com.cupidapp.live.mediapicker.fragment.ImageEditFragment$addMoreImage$2$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull ImageAttributeViewModel it) {
                        s.i(it, "it");
                        return Boolean.valueOf(s.d(it.getCompressedImagePath(), String.this));
                    }
                });
                x.B(this.f17167f.j(), new Function1<Object, Boolean>() { // from class: com.cupidapp.live.mediapicker.fragment.ImageEditFragment$addMoreImage$2$2
                    {
                        super(1);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull Object it) {
                        s.i(it, "it");
                        return Boolean.valueOf((it instanceof ImageEditViewModel) && s.d(((ImageEditViewModel) it).getPath(), String.this));
                    }
                });
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ImageAttributeViewModel C1 = C1();
        if (C1 == null || (frameAspectRatio = C1.getFrameType()) == null) {
            frameAspectRatio = FrameAspectRatio.DEFAULT;
        }
        for (Map.Entry<String, String> entry2 : pathMap.entrySet()) {
            arrayList2.add(new ImageEditViewModel(entry2.getValue(), frameAspectRatio.getRatio()));
            this.f17168g.add(new ImageAttributeViewModel(entry2.getKey(), entry2.getValue(), entry2.getValue(), null, entry2.getValue(), frameAspectRatio, null, 64, null));
        }
        M1(arrayList2, false, this.f17169h);
    }

    public final void r1(@NotNull Map<String, String> pathMap) {
        s.i(pathMap, "pathMap");
        G1(pathMap);
    }

    public final float s1(List<String> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            ImageAttributeModel l10 = z0.f.l(getContext(), iterator2.next());
            arrayList.add(Float.valueOf(l10.getWidth() / l10.getHeight()));
        }
        Float j02 = CollectionsKt___CollectionsKt.j0(arrayList);
        if (j02 != null) {
            float floatValue = j02.floatValue();
            FrameAspectRatio frameAspectRatio = FrameAspectRatio.THREE_TO_FOUR;
            if (floatValue < frameAspectRatio.getRatio()) {
                return frameAspectRatio.getRatio();
            }
            FrameAspectRatio frameAspectRatio2 = FrameAspectRatio.SIXTEEN_TO_NINE;
            return floatValue > frameAspectRatio2.getRatio() ? frameAspectRatio2.getRatio() : floatValue;
        }
        return FrameAspectRatio.THREE_TO_FOUR.getRatio();
    }

    public final boolean t1() {
        return ((ImageEditFrameListLayout) T0(R$id.imageEditFrameListLayout)).c();
    }

    public final boolean u1(int i10) {
        return (this.f17168g.isEmpty() ^ true) && i10 >= 0 && i10 < this.f17168g.size();
    }

    public final boolean v1(int i10) {
        return (this.f17167f.j().isEmpty() ^ true) && i10 >= 0 && i10 < this.f17167f.j().size();
    }

    public final boolean w1() {
        return !((ImageEditFrameListLayout) T0(R$id.imageEditFrameListLayout)).d() && L1();
    }

    public final void x1(RecyclerView.ViewHolder viewHolder, int i10) {
        if (i10 == 2) {
            if (viewHolder instanceof ImageEditViewHolder) {
                ((ImageEditViewHolder) viewHolder).y();
            }
            String string = getString(R$string.delete);
            s.h(string, "getString(R.string.delete)");
            y1(true, string);
            ((ImageDragDeleteButton) T0(R$id.imageDragDeleteButton)).setVisibility(0);
            ((MediaEditButtonListLayout) T0(R$id.imageEditButtonListLayout)).setVisibility(8);
            return;
        }
        if (i10 == 3) {
            if (viewHolder instanceof ImageEditViewHolder) {
                ((ImageEditViewHolder) viewHolder).s(0.2f);
            }
            ((ImageDragDeleteButton) T0(R$id.imageDragDeleteButton)).c(true);
            return;
        }
        if (i10 == 4) {
            if (viewHolder instanceof ImageEditViewHolder) {
                ((ImageEditViewHolder) viewHolder).s(0.7f);
            }
            ((ImageDragDeleteButton) T0(R$id.imageDragDeleteButton)).c(false);
        } else {
            if (i10 != 5) {
                return;
            }
            if (viewHolder instanceof ImageEditViewHolder) {
                ((ImageEditViewHolder) viewHolder).u();
            }
            z1(this, false, null, 2, null);
            ((ImageDragDeleteButton) T0(R$id.imageDragDeleteButton)).setVisibility(8);
            MediaEditButtonListLayout mediaEditButtonListLayout = (MediaEditButtonListLayout) T0(R$id.imageEditButtonListLayout);
            Property<View, Float> ALPHA = View.ALPHA;
            s.h(ALPHA, "ALPHA");
            mediaEditButtonListLayout.e(ALPHA);
        }
    }

    public final void y1(boolean z10, String str) {
        FKTitleBarLayout it = (FKTitleBarLayout) T0(R$id.imageEditTitleBarLayout);
        if (z10) {
            s.h(it, "it");
            FKTitleBarLayout.setSingleTitle$default(it, str, null, 2, null);
            it.setLeftImageVisible(false);
            FKTitleBarLayout.setRightText$default(it, null, 0, 4, false, 10, null);
        } else {
            s.h(it, "it");
            FKTitleBarLayout.setSingleTitle$default(it, str, null, 2, null);
            it.setLeftImageVisible(true);
            FKTitleBarLayout.setRightText$default(it, getString(R$string.complete), 0, 0, false, 14, null);
        }
        A1(z10);
    }
}
