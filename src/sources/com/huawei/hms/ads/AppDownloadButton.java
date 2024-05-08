package com.huawei.hms.ads;

import android.content.Context;
import android.util.AttributeSet;
import com.huawei.hms.ads.AppDownloadButtonStyle;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.openalliance.ad.views.AppDownloadButton;
import com.huawei.openalliance.ad.views.a;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AppDownloadButton extends com.huawei.openalliance.ad.views.AppDownloadButton implements IAppDownloadButton, AppDownloadButton.b, AppDownloadButton.c {
    private OnDownloadStatusChangedListener B;
    private OnNonWifiDownloadListener C;

    /* renamed from: com.huawei.hms.ads.AppDownloadButton$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[com.huawei.openalliance.ad.download.app.k.values().length];
            Code = iArr;
            try {
                iArr[com.huawei.openalliance.ad.download.app.k.WAITING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.RESUME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.DOWNLOADED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.DOWNLOADFAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.INSTALLING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.INSTALL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.INSTALLED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.DOWNLOAD.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    @GlobalApi
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface OnDownloadStatusChangedListener {
        void onStatusChanged(AppDownloadStatus appDownloadStatus);
    }

    @GlobalApi
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface OnNonWifiDownloadListener {
        boolean onNonWifiDownload(long j10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a extends com.huawei.openalliance.ad.views.a {
        private AppDownloadButtonStyle B;
        private a.C0341a C;

        public a(Context context, AppDownloadButtonStyle appDownloadButtonStyle) {
            super(context);
            this.C = new a.C0341a();
            this.B = appDownloadButtonStyle;
            Code(this.V, appDownloadButtonStyle.normalStyle);
            Code(this.I, this.B.processingStyle);
            Code(this.Z, this.B.installingStyle);
        }

        private void Code(a.C0341a c0341a, AppDownloadButtonStyle.Style style) {
            c0341a.Code(style.getBackground());
            c0341a.Code(style.getTextColor());
            c0341a.V(style.getTextSize());
            c0341a.Code(style.getTypeface());
        }

        @Override // com.huawei.openalliance.ad.views.a
        public a.C0341a Code(Context context, com.huawei.openalliance.ad.download.app.k kVar) {
            AppDownloadButtonStyle.Style style = this.B.getStyle(context, AppDownloadButton.this.V(kVar));
            AppDownloadButtonStyle appDownloadButtonStyle = this.B;
            if (style == appDownloadButtonStyle.processingStyle) {
                return this.I;
            }
            if (style == appDownloadButtonStyle.installingStyle) {
                return this.Z;
            }
            if (style == appDownloadButtonStyle.normalStyle) {
                return this.V;
            }
            Code(this.C, style);
            return this.C;
        }
    }

    @GlobalApi
    public AppDownloadButton(Context context) {
        super(context);
    }

    @GlobalApi
    public AppDownloadButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @GlobalApi
    public AppDownloadButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    @GlobalApi
    public AppDownloadButton(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AppDownloadStatus V(com.huawei.openalliance.ad.download.app.k kVar) {
        if (kVar == null) {
            return AppDownloadStatus.DOWNLOAD;
        }
        switch (AnonymousClass1.Code[kVar.ordinal()]) {
            case 1:
                return AppDownloadStatus.WAITING;
            case 2:
                return AppDownloadStatus.DOWNLOADING;
            case 3:
                return AppDownloadStatus.PAUSE;
            case 4:
                return AppDownloadStatus.RESUME;
            case 5:
                return AppDownloadStatus.DOWNLOADED;
            case 6:
                return AppDownloadStatus.DOWNLOADFAILED;
            case 7:
                return AppDownloadStatus.INSTALLING;
            case 8:
                return AppDownloadStatus.INSTALL;
            case 9:
                return AppDownloadStatus.INSTALLED;
            default:
                return AppDownloadStatus.DOWNLOAD;
        }
    }

    @Override // com.huawei.openalliance.ad.views.AppDownloadButton.b
    public void Code(com.huawei.openalliance.ad.download.app.k kVar) {
        OnDownloadStatusChangedListener onDownloadStatusChangedListener = this.B;
        if (onDownloadStatusChangedListener != null) {
            onDownloadStatusChangedListener.onStatusChanged(V(kVar));
        }
    }

    @Override // com.huawei.openalliance.ad.views.AppDownloadButton.c
    public boolean Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo, long j10) {
        OnNonWifiDownloadListener onNonWifiDownloadListener = this.C;
        if (onNonWifiDownloadListener != null) {
            return onNonWifiDownloadListener.onNonWifiDownload(j10);
        }
        return false;
    }

    @Override // com.huawei.openalliance.ad.views.AppDownloadButton, com.huawei.hms.ads.lg, com.huawei.hms.ads.IAppDownloadButton
    public void cancel() {
        super.cancel();
    }

    @Override // com.huawei.openalliance.ad.views.AppDownloadButton, com.huawei.hms.ads.IAppDownloadButton
    public void continueDownload() {
        super.continueDownload();
    }

    @Override // com.huawei.hms.ads.IAppDownloadButton
    public AppDownloadStatus refreshAppStatus() {
        return V(super.Code());
    }

    @Override // com.huawei.openalliance.ad.views.AppDownloadButton, com.huawei.hms.ads.IAppDownloadButton
    public void setAllowedNonWifiNetwork(boolean z10) {
        super.setAllowedNonWifiNetwork(z10);
    }

    @Override // com.huawei.hms.ads.IAppDownloadButton
    public void setAppDownloadButtonStyle(AppDownloadButtonStyle appDownloadButtonStyle) {
        if (appDownloadButtonStyle != null) {
            super.setAppDownloadButtonStyle(new a(getContext(), appDownloadButtonStyle));
        }
    }

    @Override // com.huawei.hms.ads.IAppDownloadButton
    public void setOnDownloadStatusChangedListener(OnDownloadStatusChangedListener onDownloadStatusChangedListener) {
        if (onDownloadStatusChangedListener != null) {
            this.B = onDownloadStatusChangedListener;
            super.setOnDownloadStatusChangedListener(this);
        }
    }

    @Override // com.huawei.hms.ads.IAppDownloadButton
    public void setOnNonWifiDownloadListener(OnNonWifiDownloadListener onNonWifiDownloadListener) {
        if (onNonWifiDownloadListener != null) {
            this.C = onNonWifiDownloadListener;
            super.setOnNonWifiDownloadListener(this);
        }
    }

    @Override // com.huawei.openalliance.ad.views.AppDownloadButton, com.huawei.hms.ads.IAppDownloadButton
    public void setShowPermissionDialog(boolean z10) {
        super.setShowPermissionDialog(z10);
    }
}
