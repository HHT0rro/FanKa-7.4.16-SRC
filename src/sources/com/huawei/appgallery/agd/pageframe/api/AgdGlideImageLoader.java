package com.huawei.appgallery.agd.pageframe.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.common.utils.AESUtil;
import com.huawei.appgallery.agd.common.utils.FileUtil;
import com.huawei.appgallery.agd.pageframe.PageFrameLog;
import com.huawei.flexiblelayout.services.imageloader.ImageOptions;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.qcardsupport.qcard.image.GlideImageLoader;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class AgdGlideImageLoader extends GlideImageLoader {

    /* renamed from: b, reason: collision with root package name */
    public String f27505b;

    public AgdGlideImageLoader() {
        this.f27505b = "";
    }

    public final void b(@NonNull ImageOptions imageOptions) {
        String url = imageOptions.getUrl();
        String sha256EncryptStr = AESUtil.sha256EncryptStr(url);
        PageFrameLog pageFrameLog = PageFrameLog.LOG;
        pageFrameLog.d("AgdGlideImageLoader", this.f27505b + " getCacheImageSrc imageUrl: " + url + " sha256:" + sha256EncryptStr);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(FileUtil.getImagesResourceRootDir());
        sb2.append(sha256EncryptStr);
        String sb3 = sb2.toString();
        if (new File(sb3).exists()) {
            imageOptions.setUrl(sb3);
            pageFrameLog.i("AgdGlideImageLoader", this.f27505b + " getCacheImageSrc success");
        }
    }

    @Override // com.huawei.qcardsupport.qcard.image.GlideImageLoader, com.huawei.flexiblelayout.services.imageloader.ImageLoader
    public void load(@NonNull View view, @NonNull ImageOptions imageOptions) {
        try {
            b(imageOptions);
            super.load(view, imageOptions);
        } catch (Exception e2) {
            PageFrameLog.LOG.e("AgdGlideImageLoader", this.f27505b + " load " + e2.getMessage());
        }
    }

    public AgdGlideImageLoader(String str) {
        this.f27505b = str;
    }

    @Override // com.huawei.qcardsupport.qcard.image.GlideImageLoader, com.huawei.flexiblelayout.services.imageloader.ImageLoader
    public void load(@NonNull ImageView imageView, @NonNull ImageOptions imageOptions) {
        try {
            b(imageOptions);
            super.load(imageView, imageOptions);
        } catch (Exception e2) {
            PageFrameLog.LOG.e("AgdGlideImageLoader", this.f27505b + " load " + e2.getMessage());
        }
    }

    @Override // com.huawei.qcardsupport.qcard.image.GlideImageLoader, com.huawei.flexiblelayout.services.imageloader.ImageLoader
    public Task<Drawable> load(@NonNull Context context, @NonNull ImageOptions imageOptions) {
        try {
            b(imageOptions);
            return super.load(context, imageOptions);
        } catch (Exception e2) {
            String str = this.f27505b + " load " + e2.getMessage();
            PageFrameLog.LOG.e("AgdGlideImageLoader", str);
            return Tasks.fromException(new Exception(str));
        }
    }
}
