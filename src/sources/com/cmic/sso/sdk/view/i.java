package com.cmic.sso.sdk.view;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static ArrayList<WeakReference<Activity>> f11575a;

    public static int a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.widthPixels;
    }

    public static int a(Context context, float f10) {
        if (f10 < 0.0f) {
            return (int) f10;
        }
        try {
            return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
        } catch (Exception unused) {
            return (int) f10;
        }
    }

    public static SpannableString a(final Context context, String str, String str2, final h hVar, final ArrayList<h> arrayList, ArrayList<String> arrayList2) {
        int i10;
        SpannableString spannableString = new SpannableString(str);
        try {
            ClickableSpan clickableSpan = new ClickableSpan() { // from class: com.cmic.sso.sdk.view.i.1
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    h hVar2 = hVar;
                    if (hVar2 == null || hVar2.isShowing()) {
                        return;
                    }
                    hVar.show();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setUnderlineText(false);
                    try {
                        textPaint.setColor(com.mobile.auth.g.a.a(context).a().X());
                    } catch (Exception unused) {
                        textPaint.setColor(-16007674);
                    }
                }
            };
            ClickableSpan clickableSpan2 = arrayList.size() >= 1 ? new ClickableSpan() { // from class: com.cmic.sso.sdk.view.i.2
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    if (arrayList.get(0) == null || ((h) arrayList.get(0)).isShowing()) {
                        return;
                    }
                    ((h) arrayList.get(0)).show();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setUnderlineText(false);
                    try {
                        textPaint.setColor(com.mobile.auth.g.a.a(context).a().X());
                    } catch (Exception unused) {
                        textPaint.setColor(-16007674);
                    }
                }
            } : null;
            ClickableSpan clickableSpan3 = arrayList.size() >= 2 ? new ClickableSpan() { // from class: com.cmic.sso.sdk.view.i.3
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    if (arrayList.get(1) == null || ((h) arrayList.get(1)).isShowing()) {
                        return;
                    }
                    ((h) arrayList.get(1)).show();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setUnderlineText(false);
                    try {
                        textPaint.setColor(com.mobile.auth.g.a.a(context).a().X());
                    } catch (Exception unused) {
                        textPaint.setColor(-16007674);
                    }
                }
            } : null;
            ClickableSpan clickableSpan4 = arrayList.size() >= 3 ? new ClickableSpan() { // from class: com.cmic.sso.sdk.view.i.4
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    if (arrayList.get(2) == null || ((h) arrayList.get(2)).isShowing()) {
                        return;
                    }
                    ((h) arrayList.get(2)).show();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setUnderlineText(false);
                    try {
                        textPaint.setColor(com.mobile.auth.g.a.a(context).a().X());
                    } catch (Exception unused) {
                        textPaint.setColor(-16007674);
                    }
                }
            } : null;
            ClickableSpan clickableSpan5 = arrayList.size() == 4 ? new ClickableSpan() { // from class: com.cmic.sso.sdk.view.i.5
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    if (arrayList.get(3) == null || ((h) arrayList.get(3)).isShowing()) {
                        return;
                    }
                    ((h) arrayList.get(3)).show();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setUnderlineText(false);
                    try {
                        textPaint.setColor(com.mobile.auth.g.a.a(context).a().X());
                    } catch (Exception unused) {
                        textPaint.setColor(-16007674);
                    }
                }
            } : null;
            com.mobile.auth.g.a.a(context).a();
            int indexOf = str.indexOf(str2);
            spannableString.setSpan(clickableSpan, indexOf, str2.length() + indexOf, 34);
            if (arrayList.size() >= 1) {
                String str3 = arrayList2.get(0);
                i10 = str.indexOf(str3);
                spannableString.setSpan(clickableSpan2, i10, str3.length() + i10, 34);
            } else {
                i10 = 0;
            }
            if (arrayList.size() >= 2) {
                int length = i10 + arrayList2.get(0).length();
                String str4 = arrayList2.get(1);
                i10 = str.indexOf(str4, length);
                spannableString.setSpan(clickableSpan3, i10, str4.length() + i10, 34);
            }
            if (arrayList.size() >= 3) {
                int length2 = arrayList2.get(1).length() + i10;
                String str5 = arrayList2.get(2);
                int indexOf2 = str.indexOf(str5, length2);
                spannableString.setSpan(clickableSpan4, indexOf2, str5.length() + indexOf2, 34);
            }
            if (arrayList.size() == 4) {
                int length3 = i10 + arrayList2.get(2).length();
                String str6 = arrayList2.get(3);
                int indexOf3 = str.indexOf(str6, length3);
                spannableString.setSpan(clickableSpan5, indexOf3, str6.length() + indexOf3, 34);
            }
            return spannableString;
        } catch (Exception e2) {
            e2.printStackTrace();
            return spannableString;
        }
    }

    public static RelativeLayout a(Context context, View view, int i10, int i11, String str, View.OnClickListener onClickListener) {
        a a10 = com.mobile.auth.g.a.a(context).a();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, view != null ? -2 : a(context, 49.0f));
        layoutParams.addRule(10, -1);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setId(i10);
        TextView textView = new TextView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13, -1);
        textView.setLayoutParams(layoutParams2);
        textView.setTextColor(a10.h());
        textView.setTextSize(2, a10.g());
        textView.setText(str);
        if (view != null) {
            relativeLayout.addView(view);
            relativeLayout.addView(textView);
            return relativeLayout;
        }
        relativeLayout.addView(textView);
        ImageButton imageButton = new ImageButton(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(a(context, a10.j()), a(context, a10.k()));
        layoutParams3.addRule(9, -1);
        layoutParams3.addRule(15, -1);
        layoutParams3.setMargins(a(context, 12.0f), 0, 0, 0);
        imageButton.setLayoutParams(layoutParams3);
        imageButton.setId(i11);
        imageButton.setOnClickListener(onClickListener);
        imageButton.setBackgroundColor(0);
        relativeLayout.addView(imageButton);
        try {
            relativeLayout.setBackgroundColor(com.mobile.auth.g.a.a(context).a().i());
        } catch (Exception unused) {
            relativeLayout.setBackgroundColor(-16742704);
        }
        imageButton.setImageResource(g.b(context, "umcsdk_return_bg"));
        return relativeLayout;
    }

    public static int b(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }
}
