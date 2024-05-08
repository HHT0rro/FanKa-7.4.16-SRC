package l2;

import android.content.Context;
import com.baidu.mobads.sdk.internal.bk;
import com.cupidapp.live.base.network.download.LiveBeautyDownloader;
import com.cupidapp.live.liveshow.beauty.databeauty.UserData;
import com.huawei.quickcard.framework.QuickCardField;
import java.io.File;
import java.util.Objects;

/* compiled from: ResourceHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class d implements c {

    /* renamed from: a, reason: collision with root package name */
    public Context f51601a;

    public d(Context context) {
        this.f51601a = context;
    }

    public static File h(String str) {
        return LiveBeautyDownloader.f11939a.m(str);
    }

    @Override // l2.c
    public String a() {
        File file = new File(i(), bk.f9900i);
        String absolutePath = file.getAbsolutePath();
        File file2 = new File("/data/local/tmp/EffectsARSDK/auto", bk.f9900i);
        return (file.exists() && file2.exists() && file2.isDirectory()) ? file2.getAbsolutePath() : absolutePath;
    }

    @Override // l2.c
    public String b(String str) {
        return new File(j(), str).getAbsolutePath();
    }

    @Override // l2.c
    public String c() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(g("ComposeMakeup"));
        String str = File.separator;
        sb2.append(str);
        String sb3 = sb2.toString();
        File file = new File(sb3);
        File file2 = new File(new File("/data/local/tmp/EffectsARSDK/auto", "material"), "ComposeMakeup");
        if (!file.exists() || !file2.exists() || !file2.isDirectory()) {
            return sb3;
        }
        return file2.getAbsolutePath() + str;
    }

    @Override // l2.c
    public String d(String str) {
        return new File(e(), str).getAbsolutePath();
    }

    public String e() {
        return new File(new File(h("FilterResource.bundle"), "FilterResource.bundle"), "Filter").getAbsolutePath();
    }

    public String f() {
        return new File(i(), "material").getAbsolutePath();
    }

    public String g(String str) {
        return new File(f(), str).getAbsolutePath();
    }

    public String i() {
        StringBuilder sb2 = new StringBuilder();
        File externalFilesDir = this.f51601a.getExternalFilesDir(QuickCardField.ASSETS);
        Objects.requireNonNull(externalFilesDir);
        sb2.append(externalFilesDir.getAbsolutePath());
        sb2.append(File.separator);
        sb2.append(UserData.RESOURCE_READY);
        return sb2.toString();
    }

    public String j() {
        return new File(new File(h("StickerResource.bundle"), "StickerResource.bundle"), "stickers").getAbsolutePath();
    }
}
