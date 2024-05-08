package com.alibaba.security.biometrics.build;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import com.alibaba.security.biometrics.skin.model.ButtonSkinData;
import com.alibaba.security.biometrics.skin.model.ControlSkinData;
import com.alibaba.security.biometrics.skin.model.ImageViewSkinData;
import com.alibaba.security.biometrics.skin.model.TextViewSkinData;
import java.util.Map;

/* compiled from: SkinAssignUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2414a = "SkinAssignUtils";

    public static void a(Button button, ButtonSkinData buttonSkinData) {
        if (buttonSkinData == null || button == null) {
            return;
        }
        if (buttonSkinData.getBackgroundImageBitmap() != null) {
            button.setBackgroundDrawable(new BitmapDrawable(button.getResources(), buttonSkinData.getBackgroundImageBitmap()));
        } else if (buttonSkinData.getBackgroundColor() != null) {
            button.setBackgroundColor(ae.a(buttonSkinData.getBackgroundColor(), 17170450));
        }
        button.setTextColor(ae.a(buttonSkinData.getTextColor(), button.getCurrentTextColor()));
        if (buttonSkinData.getFontSize() > 0) {
            button.setTextSize(1, buttonSkinData.getFontSize() / 2);
        }
        if (buttonSkinData.getTextPadding() != null) {
            button.setPadding(a(buttonSkinData.getTextPadding()), c(buttonSkinData.getTextPadding()), b(buttonSkinData.getTextPadding()), d(buttonSkinData.getTextPadding()));
        }
    }

    private static int b(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return 0;
        }
        return map.get("right").intValue();
    }

    private static int c(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return 0;
        }
        return map.get("top").intValue();
    }

    private static int d(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return 0;
        }
        return map.get("bottom").intValue();
    }

    private static void a(View view, ControlSkinData controlSkinData) {
        if (controlSkinData == null || view == null) {
            return;
        }
        view.setBackgroundColor(ae.a(controlSkinData.getBackgroundColor(), 17170450));
    }

    public static void a(TextView textView, TextViewSkinData textViewSkinData) {
        if (textViewSkinData == null || textView == null) {
            return;
        }
        textView.setTextColor(ae.a(textViewSkinData.getTextColor(), textView.getCurrentTextColor()));
        if (textViewSkinData.getFontSize() > 0) {
            textView.setTextSize(2, textViewSkinData.getFontSize() / 2);
        }
        if (textViewSkinData.getTextPadding() != null) {
            textView.setPadding(a(textViewSkinData.getTextPadding()), c(textViewSkinData.getTextPadding()), b(textViewSkinData.getTextPadding()), d(textViewSkinData.getTextPadding()));
        }
    }

    private static int a(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return 0;
        }
        return map.get("left").intValue();
    }

    public static void a(ImageView imageView, ImageViewSkinData imageViewSkinData, @DrawableRes int i10) {
        if (imageView == null) {
            return;
        }
        imageView.setImageResource(i10);
        if (imageViewSkinData == null || imageViewSkinData.getSrc() == null) {
            return;
        }
        imageView.setImageBitmap(imageViewSkinData.getSrcImageBitmap());
    }
}
