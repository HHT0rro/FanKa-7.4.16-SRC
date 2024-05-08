package com.huawei.quickcard.views.image;

import android.content.Context;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.framework.processor.AspectRatioProcessor;
import com.huawei.quickcard.framework.ui.Component;
import com.huawei.quickcard.views.image.extension.IImageViewFactory;
import com.huawei.quickcard.views.image.processor.AltAttribute;
import com.huawei.quickcard.views.image.processor.BorderStyle;
import com.huawei.quickcard.views.image.processor.CommonAttribute;
import com.huawei.quickcard.views.image.processor.HeightProcessor;
import com.huawei.quickcard.views.image.processor.ScaleStyle;
import com.huawei.quickcard.views.image.processor.WidthProcessor;
import com.huawei.quickcard.views.image.view.BaseImageView;
import com.huawei.quickcard.views.image.view.FlexImageView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Image extends Component<ImageView> {
    public Image() {
        CommonAttribute commonAttribute = new CommonAttribute();
        addProcessor("src", commonAttribute);
        addProcessor(Attributes.Style.NO_CACHE, commonAttribute);
        addProcessor(Attributes.Style.NET_WORK_ENHANCE, commonAttribute);
        addProcessor(Attributes.Style.CLIP_X, commonAttribute);
        addProcessor(Attributes.Style.CLIP_Y, commonAttribute);
        addProcessor(Attributes.Style.ALT, new AltAttribute());
        addProcessor(Attributes.Style.ASPECT_RATIO, new AspectRatioProcessor());
        addProcessor("objectFit", new ScaleStyle());
        addProcessor("width", new WidthProcessor());
        addProcessor("height", new HeightProcessor());
        BorderStyle borderStyle = new BorderStyle();
        addProcessor(Attributes.Style.BORDER_COLOR, borderStyle);
        addProcessor(Attributes.Style.BORDER_LEFT_COLOR, borderStyle);
        addProcessor(Attributes.Style.BORDER_TOP_COLOR, borderStyle);
        addProcessor(Attributes.Style.BORDER_RIGHT_COLOR, borderStyle);
        addProcessor(Attributes.Style.BORDER_BOTTOM_COLOR, borderStyle);
        addProcessor(Attributes.Style.BORDER_WIDTH, borderStyle);
        addProcessor(Attributes.Style.BORDER_LEFT_WIDTH, borderStyle);
        addProcessor(Attributes.Style.BORDER_TOP_WIDTH, borderStyle);
        addProcessor(Attributes.Style.BORDER_RIGHT_WIDTH, borderStyle);
        addProcessor(Attributes.Style.BORDER_BOTTOM_WIDTH, borderStyle);
        addProcessor(Attributes.Style.BORDER_STYLE, borderStyle);
        addProcessor(Attributes.Style.BORDER_LEFT_STYLE, borderStyle);
        addProcessor(Attributes.Style.BORDER_TOP_STYLE, borderStyle);
        addProcessor(Attributes.Style.BORDER_RIGHT_STYLE, borderStyle);
        addProcessor(Attributes.Style.BORDER_BOTTOM_STYLE, borderStyle);
        addProcessor(Attributes.Style.BORDER_RADIUS, borderStyle);
        addProcessor(Attributes.Style.BORDER_BOTTOM_LEFT_RADIUS, borderStyle);
        addProcessor(Attributes.Style.BORDER_BOTTOM_RIGHT_RADIUS, borderStyle);
        addProcessor(Attributes.Style.BORDER_TOP_LEFT_RADIUS, borderStyle);
        addProcessor(Attributes.Style.BORDER_TOP_RIGHT_RADIUS, borderStyle);
    }

    @Override // com.huawei.quickcard.framework.ui.Component
    @NonNull
    public String getName() {
        return Attributes.Component.IMAGE;
    }

    @Override // com.huawei.quickcard.framework.ui.Component
    public ImageView createViewImpl(Context context) {
        IImageViewFactory<? extends BaseImageView> imageFactory = ImageConfig.getImageFactory();
        return imageFactory == null ? new FlexImageView(context) : imageFactory.create(context);
    }
}
