package com.cupidapp.live.mediapicker.activity;

import com.cupidapp.live.R$id;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.view.progress.ProgressBarDialog;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.p;

/* compiled from: MediaPickerActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MediaPickerActivity$zipAndShowImageEditor$2 extends Lambda implements Function2<Integer, Integer, p> {
    public final /* synthetic */ MediaPickerActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaPickerActivity$zipAndShowImageEditor$2(MediaPickerActivity mediaPickerActivity) {
        super(2);
        this.this$0 = mediaPickerActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(MediaPickerActivity this$0, int i10, int i11) {
        s.i(this$0, "this$0");
        this$0.f17129y = i10;
        ProgressBarDialog progressBarDialog = (ProgressBarDialog) this$0.j1(R$id.progressBarLayout);
        String string = this$0.getString(R$string.compress_picture_progress, new Object[]{Integer.valueOf(i11 + 1), (i10 * 10) + "%"});
        s.h(string, "getString(R.string.compr…+ 1, \"${progress * 10}%\")");
        progressBarDialog.setProgress(string);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ p mo1743invoke(Integer num, Integer num2) {
        invoke(num.intValue(), num2.intValue());
        return p.f51048a;
    }

    public final void invoke(final int i10, final int i11) {
        ProgressBarDialog progressBarDialog = (ProgressBarDialog) this.this$0.j1(R$id.progressBarLayout);
        final MediaPickerActivity mediaPickerActivity = this.this$0;
        progressBarDialog.post(new Runnable() { // from class: com.cupidapp.live.mediapicker.activity.n
            @Override // java.lang.Runnable
            public final void run() {
                MediaPickerActivity$zipAndShowImageEditor$2.invoke$lambda$0(MediaPickerActivity.this, i11, i10);
            }
        });
    }
}
