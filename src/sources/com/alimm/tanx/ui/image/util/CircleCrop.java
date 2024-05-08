package com.alimm.tanx.ui.image.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import com.alimm.tanx.ui.image.glide.Glide;
import com.alimm.tanx.ui.image.glide.load.Transformation;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapResource;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class CircleCrop implements Transformation<Bitmap> {
    public final BitmapPool mBitmapPool;

    public CircleCrop(Context context) {
        this(Glide.get(context).getBitmapPool());
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public String getId() {
        return "CropCircleTransformation()";
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public Resource<Bitmap> transform(Resource<Bitmap> resource, int i10, int i11) {
        Bitmap bitmap = resource.get();
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        int width = (bitmap.getWidth() - min) / 2;
        int height = (bitmap.getHeight() - min) / 2;
        Bitmap bitmap2 = this.mBitmapPool.get(min, min, Bitmap.Config.ARGB_8888);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        if (width != 0 || height != 0) {
            Matrix matrix = new Matrix();
            matrix.setTranslate(-width, -height);
            bitmapShader.setLocalMatrix(matrix);
        }
        paint.setShader(bitmapShader);
        paint.setAntiAlias(true);
        float f10 = min / 2.0f;
        canvas.drawCircle(f10, f10, f10, paint);
        return BitmapResource.obtain(bitmap2, this.mBitmapPool);
    }

    public CircleCrop(BitmapPool bitmapPool) {
        this.mBitmapPool = bitmapPool;
    }
}
