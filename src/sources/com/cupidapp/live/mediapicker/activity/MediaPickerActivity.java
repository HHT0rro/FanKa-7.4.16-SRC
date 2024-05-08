package com.cupidapp.live.mediapicker.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.android.internal.logging.nano.MetricsProto;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.ImageResizeUtils;
import com.cupidapp.live.base.view.progress.ProgressBarDialog;
import com.cupidapp.live.hashtag.model.HashTagSimpleModel;
import com.cupidapp.live.mediapicker.activity.FeedPublishActivity;
import com.cupidapp.live.mediapicker.fragment.ImageEditFragment;
import com.cupidapp.live.mediapicker.fragment.ImageTrimFragment;
import com.cupidapp.live.mediapicker.fragment.VideoEditFragment;
import com.cupidapp.live.mediapicker.model.ImageAttributeViewModel;
import com.cupidapp.live.mediapicker.model.ImageContentModel;
import com.cupidapp.live.mediapicker.model.ImageTrimModel;
import com.cupidapp.live.mediapicker.model.MediaPickerActivityModel;
import com.cupidapp.live.mediapicker.model.UpdateImageEditPathEventModel;
import com.cupidapp.live.mediapicker.model.UploadImageModel;
import com.cupidapp.live.mediapicker.newmediapicker.data.ImagePickedData;
import com.cupidapp.live.mediapicker.newmediapicker.data.PreviewMediaData;
import com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment;
import com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPreviewFragment;
import com.cupidapp.live.mediapicker.newmediapicker.model.LocalMedia;
import com.cupidapp.live.mediapicker.newmediapicker.model.MediaType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.t;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MediaPickerActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MediaPickerActivity extends FKBaseActivity {

    @NotNull
    public static final a A = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public MediaPickerActivityModel f17121q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public MediaPickerFragment f17122r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public MediaPreviewFragment f17123s;

    /* renamed from: t, reason: collision with root package name */
    @Nullable
    public ImageEditFragment f17124t;

    /* renamed from: u, reason: collision with root package name */
    @Nullable
    public ImageTrimFragment f17125u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f17126v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f17127w;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    public String f17128x;

    /* renamed from: y, reason: collision with root package name */
    public int f17129y;

    /* renamed from: z, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17130z = new LinkedHashMap();

    /* compiled from: MediaPickerActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Activity activity, @NotNull MediaPickerActivityModel actModel) {
            s.i(actModel, "actModel");
            Intent intent = new Intent(activity, (Class<?>) MediaPickerActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("MediaPickerActivityModel", actModel);
            intent.putExtras(bundle);
            if (actModel.getRequestCode() == -1) {
                if (activity != null) {
                    activity.startActivityForResult(intent, 1212);
                }
            } else if (activity != null) {
                activity.startActivityForResult(intent, actModel.getRequestCode());
            }
            FKBaseActivity.f11750o.b(activity, R$anim.anim_activity_bottom_to_top, R$anim.anim_activity_nothing);
        }
    }

    /* compiled from: MediaPickerActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements ImageEditFragment.b {
        public b() {
        }

        @Override // com.cupidapp.live.mediapicker.fragment.ImageEditFragment.b
        public void a() {
            MediaPickerActivity.this.w1();
        }

        @Override // com.cupidapp.live.mediapicker.fragment.ImageEditFragment.b
        public void b(@NotNull List<ImageAttributeViewModel> modelList, boolean z10) {
            s.i(modelList, "modelList");
            MediaPickerActivity.this.v1(modelList, z10);
        }

        @Override // com.cupidapp.live.mediapicker.fragment.ImageEditFragment.b
        public void c(@NotNull ImageAttributeViewModel model) {
            s.i(model, "model");
            MediaPickerActivity.this.A1(new ImageTrimModel(model.getCompressedImagePath(), model.getCompressedImagePath(), model.getFrameType().getRatio(), model.getAfterTrimImageBoundRectF()));
        }

        @Override // com.cupidapp.live.mediapicker.fragment.ImageEditFragment.b
        public void d() {
            MediaPickerActivity.this.f17126v = true;
            MediaPickerActivity.this.x1();
        }
    }

    /* compiled from: MediaPickerActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements MediaPickerFragment.b {
        public c() {
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment.b
        public void a() {
            MediaPickerActivity.this.onBackPressed();
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment.b
        public void b(int i10) {
            MediaPickerActivity.this.E1(new MediaPreviewFragment.Config(false, true, i10, 0L, null, 0, 57, null));
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment.b
        public void c(@NotNull List<String> pathList) {
            s.i(pathList, "pathList");
            MediaPickerActivity.this.B1(MediaType.IMAGE, pathList);
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment.b
        public void d(long j10, int i10, int i11) {
            MediaPickerActivity.this.E1(new MediaPreviewFragment.Config(false, false, i10, j10, null, i11, 17, null));
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment.b
        public void e(@NotNull LocalMedia localMedia, int i10) {
            MediaPickerFragment.b.a.c(this, localMedia, i10);
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment.b
        public void f() {
        }
    }

    /* compiled from: MediaPickerActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d implements MediaPreviewFragment.b {
        public d() {
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPreviewFragment.b
        public void a() {
            MediaPickerActivity.this.onBackPressed();
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPreviewFragment.b
        public void b(@NotNull MediaType mediaType, @NotNull List<String> pathList) {
            s.i(mediaType, "mediaType");
            s.i(pathList, "pathList");
            MediaPickerActivity.this.B1(mediaType, pathList);
        }
    }

    public static /* synthetic */ void D1(MediaPickerActivity mediaPickerActivity, boolean z10, SensorPosition sensorPosition, MediaType mediaType, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            MediaPickerActivityModel mediaPickerActivityModel = mediaPickerActivity.f17121q;
            sensorPosition = mediaPickerActivityModel != null ? mediaPickerActivityModel.getShowPosition() : null;
        }
        if ((i10 & 4) != 0) {
            mediaType = MediaType.ALL;
        }
        if ((i10 & 8) != 0) {
            z11 = true;
        }
        mediaPickerActivity.C1(z10, sensorPosition, mediaType, z11);
    }

    public final void A1(ImageTrimModel imageTrimModel) {
        ImageTrimFragment imageTrimFragment = this.f17125u;
        if (imageTrimFragment == null) {
            this.f17125u = ImageTrimFragment.f17190h.a(imageTrimModel);
        } else if (imageTrimFragment != null) {
            imageTrimFragment.V0(imageTrimModel);
        }
        y1(this.f17125u, false);
    }

    public final void B1(MediaType mediaType, List<String> list) {
        if (list.isEmpty()) {
            return;
        }
        if (mediaType == MediaType.VIDEO) {
            j1.g gVar = j1.g.f50233a;
            MediaPickerActivityModel mediaPickerActivityModel = this.f17121q;
            j1.g.b(gVar, "视频", mediaPickerActivityModel != null ? mediaPickerActivityModel.getShowPosition() : null, 1, null, 8, null);
            String str = list.get(0);
            MediaPickerActivityModel mediaPickerActivityModel2 = this.f17121q;
            HashTagSimpleModel hashTag = mediaPickerActivityModel2 != null ? mediaPickerActivityModel2.getHashTag() : null;
            MediaPickerActivityModel mediaPickerActivityModel3 = this.f17121q;
            SensorPosition showPosition = mediaPickerActivityModel3 != null ? mediaPickerActivityModel3.getShowPosition() : null;
            MediaPickerActivityModel mediaPickerActivityModel4 = this.f17121q;
            VideoFeedEditActivity.f17134r.a(this, MetricsProto.MetricsEvent.ACTION_SHORTCUTS_CHANGED, new VideoEditFragment.Config(str, hashTag, showPosition, mediaPickerActivityModel4 != null ? mediaPickerActivityModel4.getWebTitle() : null));
            return;
        }
        int size = ImagePickedData.INSTANCE.size();
        j1.g gVar2 = j1.g.f50233a;
        MediaPickerActivityModel mediaPickerActivityModel5 = this.f17121q;
        j1.g.b(gVar2, "图片", mediaPickerActivityModel5 != null ? mediaPickerActivityModel5.getShowPosition() : null, size, null, 8, null);
        if (this.f17127w && !TextUtils.isEmpty(this.f17128x)) {
            List z02 = CollectionsKt___CollectionsKt.z0(list);
            String str2 = this.f17128x;
            s.f(str2);
            z02.add(0, str2);
            list = CollectionsKt___CollectionsKt.x0(z02);
        }
        F1(list);
    }

    public final void C1(boolean z10, SensorPosition sensorPosition, MediaType mediaType, boolean z11) {
        MediaPickerActivityModel mediaPickerActivityModel = this.f17121q;
        MediaPickerFragment.Config config = new MediaPickerFragment.Config(mediaType, true, false, false, true, mediaPickerActivityModel != null ? mediaPickerActivityModel.getStartPosition() : null, sensorPosition, null, 136, null);
        MediaPickerFragment mediaPickerFragment = this.f17122r;
        if (mediaPickerFragment == null) {
            this.f17122r = MediaPickerFragment.f17279p.b(config, new c());
        } else if (mediaPickerFragment != null) {
            mediaPickerFragment.J1(config);
            mediaPickerFragment.D1();
        }
        y1(this.f17122r, z10);
    }

    public final void E1(MediaPreviewFragment.Config config) {
        MediaPreviewFragment mediaPreviewFragment = this.f17123s;
        if (mediaPreviewFragment == null) {
            this.f17123s = MediaPreviewFragment.f17298l.a(config, new d());
        } else if (mediaPreviewFragment != null) {
            mediaPreviewFragment.h1(config);
        }
        y1(this.f17123s, false);
    }

    public final void F1(List<String> list) {
        ((ProgressBarDialog) j1(R$id.progressBarLayout)).setVisibility(0);
        this.f17129y = 0;
        ImageResizeUtils.f12268a.m(this, this, list, new Function1<Map<String, String>, p>() { // from class: com.cupidapp.live.mediapicker.activity.MediaPickerActivity$zipAndShowImageEditor$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Map<String, String> map) {
                invoke2(map);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Map<String, String> map) {
                boolean z10;
                int i10;
                ((ProgressBarDialog) MediaPickerActivity.this.j1(R$id.progressBarLayout)).setVisibility(8);
                if (map == null || map.isEmpty()) {
                    com.cupidapp.live.base.view.h hVar = com.cupidapp.live.base.view.h.f12779a;
                    MediaPickerActivity mediaPickerActivity = MediaPickerActivity.this;
                    i10 = mediaPickerActivity.f17129y;
                    hVar.s(mediaPickerActivity, mediaPickerActivity.getString(R$string.compress_picture_error, new Object[]{Integer.valueOf(i10)}));
                    return;
                }
                z10 = MediaPickerActivity.this.f17127w;
                ImagePickedData.INSTANCE.setFrozenCount(map.size() - (z10 ? 1 : 0));
                MediaPickerActivity.this.z1(map, false);
            }
        }, (r16 & 16) != 0 ? null : new MediaPickerActivity$zipAndShowImageEditor$2(this), (r16 & 32) != 0 ? null : null);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        FKBaseFragment R0 = R0();
        if (!(R0 instanceof ImageEditFragment) && !(R0 instanceof ImageTrimFragment)) {
            return super.Q0();
        }
        return SensorPosition.ImageEditor;
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f17130z;
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

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i11 == -1 && i10 == 1212) {
            setResult(-1);
            finish();
        }
        if (i10 == 1717) {
            if (i11 == -1) {
                setResult(-1);
                finish();
            } else {
                if (i11 != 0) {
                    return;
                }
                w1();
            }
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        FKBaseFragment R0 = R0();
        if (R0 instanceof MediaPickerFragment) {
            if (this.f17126v) {
                this.f17126v = false;
                ImagePickedData.INSTANCE.clearNotFrozenItem();
                z1(null, true);
                return;
            } else {
                if (((MediaPickerFragment) R0).u1()) {
                    return;
                }
                super.onBackPressed();
                return;
            }
        }
        if (R0 instanceof MediaPreviewFragment) {
            ((MediaPreviewFragment) R0).l1();
            if (this.f17126v) {
                x1();
                return;
            } else {
                D1(this, true, null, null, false, 14, null);
                return;
            }
        }
        if (R0 instanceof ImageEditFragment) {
            if (((ImageEditFragment) R0).w1()) {
                w1();
            }
        } else if (R0 instanceof ImageTrimFragment) {
            EventBus.c().l(new UpdateImageEditPathEventModel(null, null, null, null, 15, null));
            z1(null, true);
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_media_select);
        d1(R$anim.anim_activity_nothing, Integer.valueOf(R$anim.anim_activity_top_to_bottom));
        Serializable serializableExtra = getIntent().getSerializableExtra("MediaPickerActivityModel");
        this.f17121q = serializableExtra instanceof MediaPickerActivityModel ? (MediaPickerActivityModel) serializableExtra : null;
        D1(this, false, null, null, false, 14, null);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ImagePickedData.INSTANCE.clear();
        PreviewMediaData.INSTANCE.clear();
    }

    public final void v1(List<ImageAttributeViewModel> list, boolean z10) {
        ArrayList arrayList = new ArrayList(t.t(list, 10));
        Iterator<ImageAttributeViewModel> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(new UploadImageModel(null, iterator2.next().getUploadImagePath(), null, 5, null));
        }
        List z02 = CollectionsKt___CollectionsKt.z0(arrayList);
        ArrayList arrayList2 = new ArrayList(t.t(list, 10));
        Iterator<ImageAttributeViewModel> iterator22 = list.iterator2();
        while (iterator22.hasNext()) {
            arrayList2.add(iterator22.next().getOriginalImageUriString());
        }
        List z03 = CollectionsKt___CollectionsKt.z0(arrayList2);
        ImageAttributeViewModel imageAttributeViewModel = (ImageAttributeViewModel) CollectionsKt___CollectionsKt.V(list);
        ImageContentModel imageContentModel = new ImageContentModel(z02, imageAttributeViewModel != null ? imageAttributeViewModel.getFrameType() : null, z03);
        MediaPickerActivityModel mediaPickerActivityModel = this.f17121q;
        String str = (mediaPickerActivityModel != null ? mediaPickerActivityModel.getHashTag() : null) != null ? "投稿" : "上传";
        FeedPublishActivity.a aVar = FeedPublishActivity.K;
        MediaPickerActivityModel mediaPickerActivityModel2 = this.f17121q;
        HashTagSimpleModel hashTag = mediaPickerActivityModel2 != null ? mediaPickerActivityModel2.getHashTag() : null;
        MediaPickerActivityModel mediaPickerActivityModel3 = this.f17121q;
        SensorPosition showPosition = mediaPickerActivityModel3 != null ? mediaPickerActivityModel3.getShowPosition() : null;
        boolean z11 = this.f17127w;
        MediaPickerActivityModel mediaPickerActivityModel4 = this.f17121q;
        aVar.a(this, imageContentModel, null, hashTag, 1212, str, showPosition, z11, z10, mediaPickerActivityModel4 != null ? mediaPickerActivityModel4.getWebTitle() : null);
    }

    public final void w1() {
        ImagePickedData.INSTANCE.setFrozenCount(0);
        this.f17127w = false;
        this.f17128x = null;
        D1(this, true, null, null, false, 14, null);
    }

    public final void x1() {
        C1(false, SensorPosition.ImageEditor, MediaType.IMAGE, false);
    }

    public final void y1(FKBaseFragment fKBaseFragment, boolean z10) {
        FKBaseActivity.g1(this, fKBaseFragment, z10, R$id.mediaPickerContainerLayout, false, false, 24, null);
    }

    public final void z1(Map<String, String> map, boolean z10) {
        if (!(map == null || map.isEmpty())) {
            ImageEditFragment imageEditFragment = this.f17124t;
            if (imageEditFragment == null) {
                this.f17124t = ImageEditFragment.f17165l.a(new ImageEditFragment.Config(map), new b());
            } else if (this.f17126v) {
                this.f17126v = false;
                if (imageEditFragment != null) {
                    imageEditFragment.q1(map);
                }
            } else if (imageEditFragment != null) {
                imageEditFragment.r1(map);
            }
        }
        y1(this.f17124t, z10);
    }
}
