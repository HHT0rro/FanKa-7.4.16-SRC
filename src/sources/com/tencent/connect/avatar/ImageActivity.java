package com.tencent.connect.avatar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.mobile.auth.gatewayauth.Constant;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.d;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.f;
import com.tencent.open.utils.l;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ImageActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    public RelativeLayout f42498a;

    /* renamed from: b, reason: collision with root package name */
    private QQToken f42499b;

    /* renamed from: c, reason: collision with root package name */
    private String f42500c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f42501d;

    /* renamed from: e, reason: collision with root package name */
    private c f42502e;

    /* renamed from: f, reason: collision with root package name */
    private Button f42503f;

    /* renamed from: g, reason: collision with root package name */
    private Button f42504g;

    /* renamed from: h, reason: collision with root package name */
    private b f42505h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f42506i;

    /* renamed from: j, reason: collision with root package name */
    private ProgressBar f42507j;

    /* renamed from: r, reason: collision with root package name */
    private String f42515r;

    /* renamed from: s, reason: collision with root package name */
    private Bitmap f42516s;

    /* renamed from: k, reason: collision with root package name */
    private int f42508k = 0;

    /* renamed from: l, reason: collision with root package name */
    private boolean f42509l = false;

    /* renamed from: m, reason: collision with root package name */
    private long f42510m = 0;

    /* renamed from: n, reason: collision with root package name */
    private int f42511n = 0;

    /* renamed from: o, reason: collision with root package name */
    private final int f42512o = 640;

    /* renamed from: p, reason: collision with root package name */
    private final int f42513p = 640;

    /* renamed from: q, reason: collision with root package name */
    private Rect f42514q = new Rect();

    /* renamed from: t, reason: collision with root package name */
    private final View.OnClickListener f42517t = new View.OnClickListener() { // from class: com.tencent.connect.avatar.ImageActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageActivity.this.f42507j.setVisibility(0);
            ImageActivity.this.f42504g.setEnabled(false);
            ImageActivity.this.f42504g.setTextColor(Color.rgb(21, 21, 21));
            ImageActivity.this.f42503f.setEnabled(false);
            ImageActivity.this.f42503f.setTextColor(Color.rgb(36, 94, 134));
            new Thread(new Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.2.1
                @Override // java.lang.Runnable
                public void run() {
                    ImageActivity.this.c();
                }
            }).start();
            if (ImageActivity.this.f42509l) {
                ImageActivity.this.a("10657", 0L);
                return;
            }
            ImageActivity.this.a("10655", System.currentTimeMillis() - ImageActivity.this.f42510m);
            if (ImageActivity.this.f42502e.f42538b) {
                ImageActivity.this.a("10654", 0L);
            }
        }
    };

    /* renamed from: u, reason: collision with root package name */
    private final View.OnClickListener f42518u = new View.OnClickListener() { // from class: com.tencent.connect.avatar.ImageActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageActivity.this.a("10656", System.currentTimeMillis() - ImageActivity.this.f42510m);
            ImageActivity.this.setResult(0);
            ImageActivity.this.d();
        }
    };

    /* renamed from: v, reason: collision with root package name */
    private final IUiListener f42519v = new DefaultUiListener() { // from class: com.tencent.connect.avatar.ImageActivity.5
        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            ImageActivity.this.f42504g.setEnabled(true);
            int i10 = -1;
            ImageActivity.this.f42504g.setTextColor(-1);
            ImageActivity.this.f42503f.setEnabled(true);
            ImageActivity.this.f42503f.setTextColor(-1);
            ImageActivity.this.f42507j.setVisibility(8);
            JSONObject jSONObject = (JSONObject) obj;
            try {
                i10 = jSONObject.getInt("ret");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (i10 == 0) {
                ImageActivity.this.a("设置成功", 0);
                ImageActivity.this.a("10658", 0L);
                d.a().a(ImageActivity.this.f42499b.getOpenId(), ImageActivity.this.f42499b.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, Constants.VIA_REPORT_TYPE_SET_AVATAR, "3", "0");
                ImageActivity imageActivity = ImageActivity.this;
                if (imageActivity.f42500c != null && !"".equals(ImageActivity.this.f42500c)) {
                    Intent intent = new Intent();
                    intent.setClassName(imageActivity, ImageActivity.this.f42500c);
                    if (imageActivity.getPackageManager().resolveActivity(intent, 0) != null) {
                        imageActivity.startActivity(intent);
                    }
                }
                ImageActivity.this.a(0, jSONObject.toString(), null, null);
                ImageActivity.this.d();
                return;
            }
            ImageActivity.this.a("设置出错了，请重新登录再尝试下呢：）", 1);
            d.a().a(ImageActivity.this.f42499b.getOpenId(), ImageActivity.this.f42499b.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, Constants.VIA_REPORT_TYPE_SET_AVATAR, Constants.VIA_ACT_TYPE_NINETEEN, "1");
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            ImageActivity.this.f42504g.setEnabled(true);
            ImageActivity.this.f42504g.setTextColor(-1);
            ImageActivity.this.f42503f.setEnabled(true);
            ImageActivity.this.f42503f.setTextColor(-1);
            ImageActivity.this.f42503f.setText("重试");
            ImageActivity.this.f42507j.setVisibility(8);
            ImageActivity.this.f42509l = true;
            ImageActivity.this.a(uiError.errorMessage, 1);
            ImageActivity.this.a("10660", 0L);
        }
    };

    /* renamed from: w, reason: collision with root package name */
    private final IUiListener f42520w = new DefaultUiListener() { // from class: com.tencent.connect.avatar.ImageActivity.6
        private void a(int i10) {
            if (ImageActivity.this.f42508k < 2) {
                ImageActivity.this.e();
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            int i10 = -1;
            try {
                i10 = jSONObject.getInt("ret");
                if (i10 == 0) {
                    final String string = jSONObject.getString("nickname");
                    ImageActivity.this.f42501d.post(new Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ImageActivity.this.c(string);
                        }
                    });
                    ImageActivity.this.a("10659", 0L);
                } else {
                    ImageActivity.this.a("10661", 0L);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (i10 != 0) {
                a(i10);
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            a(0);
        }
    };

    /* compiled from: ProGuard */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class QQAvatarImp extends BaseApi {
        public QQAvatarImp(QQToken qQToken) {
            super(qQToken);
        }

        public void setAvator(Bitmap bitmap, IUiListener iUiListener) {
            Bundle a10 = a();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bitmap.recycle();
            BaseApi.TempRequestListener tempRequestListener = new BaseApi.TempRequestListener(iUiListener);
            a10.putByteArray("picture", byteArray);
            HttpUtils.requestAsync(this.f42565c, f.a(), "user/set_user_face", a10, "POST", tempRequestListener);
            d.a().a(this.f42565c.getOpenId(), this.f42565c.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, Constants.VIA_REPORT_TYPE_SET_AVATAR, Constants.VIA_ACT_TYPE_NINETEEN, "0");
        }
    }

    /* compiled from: ProGuard */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a extends View {
        public a(Context context) {
            super(context);
        }

        public void a(Button button) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable b4 = ImageActivity.this.b("com.tencent.plus.blue_normal.png");
            Drawable b10 = ImageActivity.this.b("com.tencent.plus.blue_down.png");
            Drawable b11 = ImageActivity.this.b("com.tencent.plus.blue_disable.png");
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, b10);
            stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, b4);
            stateListDrawable.addState(View.ENABLED_STATE_SET, b4);
            stateListDrawable.addState(View.FOCUSED_STATE_SET, b4);
            stateListDrawable.addState(View.EMPTY_STATE_SET, b11);
            button.setBackgroundDrawable(stateListDrawable);
        }

        public void b(Button button) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable b4 = ImageActivity.this.b("com.tencent.plus.gray_normal.png");
            Drawable b10 = ImageActivity.this.b("com.tencent.plus.gray_down.png");
            Drawable b11 = ImageActivity.this.b("com.tencent.plus.gray_disable.png");
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, b10);
            stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, b4);
            stateListDrawable.addState(View.ENABLED_STATE_SET, b4);
            stateListDrawable.addState(View.FOCUSED_STATE_SET, b4);
            stateListDrawable.addState(View.EMPTY_STATE_SET, b11);
            button.setBackgroundDrawable(stateListDrawable);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        d();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setRequestedOrientation(1);
        setContentView(a());
        this.f42501d = new Handler();
        Bundle bundleExtra = getIntent().getBundleExtra(Constants.KEY_PARAMS);
        this.f42515r = bundleExtra.getString("picture");
        this.f42500c = bundleExtra.getString("return_activity");
        String string = bundleExtra.getString("appid");
        String string2 = bundleExtra.getString("access_token");
        long j10 = bundleExtra.getLong("expires_in");
        String string3 = bundleExtra.getString("openid");
        this.f42511n = bundleExtra.getInt(Constant.LOGIN_ACTIVITY_EXIT_ANIM);
        QQToken qQToken = new QQToken(string);
        this.f42499b = qQToken;
        qQToken.setAccessToken(string2, ((j10 - System.currentTimeMillis()) / 1000) + "");
        this.f42499b.setOpenId(string3);
        b();
        e();
        this.f42510m = System.currentTimeMillis();
        a("10653", 0L);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f42502e.setImageBitmap(null);
        Bitmap bitmap = this.f42516s;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.f42516s.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        float width = this.f42514q.width();
        Matrix imageMatrix = this.f42502e.getImageMatrix();
        float[] fArr = new float[9];
        imageMatrix.getValues(fArr);
        float f10 = fArr[2];
        float f11 = fArr[5];
        float f12 = fArr[0];
        float f13 = 640.0f / width;
        Rect rect = this.f42514q;
        int i10 = (int) ((rect.left - f10) / f12);
        int i11 = i10 < 0 ? 0 : i10;
        int i12 = (int) ((rect.top - f11) / f12);
        int i13 = i12 < 0 ? 0 : i12;
        Matrix matrix = new Matrix();
        matrix.set(imageMatrix);
        matrix.postScale(f13, f13);
        int i14 = (int) (650.0f / f12);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(this.f42516s, i11, i13, Math.min(this.f42516s.getWidth() - i11, i14), Math.min(this.f42516s.getHeight() - i13, i14), matrix, true);
            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, 640, 640);
            createBitmap.recycle();
            a(createBitmap2);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            a(Constants.MSG_IMAGE_ERROR, 1);
            a(-5, null, Constants.MSG_IMAGE_ERROR, e2.getMessage());
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        finish();
        int i10 = this.f42511n;
        if (i10 != 0) {
            overridePendingTransition(0, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f42508k++;
        new UserInfo(this, this.f42499b).getUserInfo(this.f42520w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable b(String str) {
        return l.a(str, this);
    }

    private void b() {
        Bitmap a10;
        try {
            a10 = a(this.f42515r);
            this.f42516s = a10;
        } catch (IOException e2) {
            e2.printStackTrace();
            a(Constants.MSG_IMAGE_ERROR, 1);
            a(-5, null, Constants.MSG_IMAGE_ERROR, e2.getMessage());
            d();
        }
        if (a10 != null) {
            this.f42502e.setImageBitmap(a10);
            this.f42503f.setOnClickListener(this.f42517t);
            this.f42504g.setOnClickListener(this.f42518u);
            this.f42498a.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.connect.avatar.ImageActivity.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ImageActivity.this.f42498a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ImageActivity imageActivity = ImageActivity.this;
                    imageActivity.f42514q = imageActivity.f42505h.a();
                    ImageActivity.this.f42502e.a(ImageActivity.this.f42514q);
                }
            });
            return;
        }
        throw new IOException("cannot read picture: '" + this.f42515r + "'!");
    }

    private String d(String str) {
        return str.replaceAll("&gt;", ">").replaceAll("&lt;", "<").replaceAll("&quot;", "\"").replaceAll("&#39;", "'").replaceAll("&amp;", "&");
    }

    private Bitmap a(String str) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i10 = 1;
        options.inJustDecodeBounds = true;
        Uri parse = Uri.parse(str);
        InputStream openInputStream = getContentResolver().openInputStream(parse);
        if (openInputStream == null) {
            return null;
        }
        try {
            BitmapFactory.decodeStream(openInputStream, null, options);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
        }
        openInputStream.close();
        int i11 = options.outWidth;
        int i12 = options.outHeight;
        while (i11 * i12 > 4194304) {
            i11 /= 2;
            i12 /= 2;
            i10 *= 2;
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = i10;
        try {
            return BitmapFactory.decodeStream(getContentResolver().openInputStream(parse), null, options);
        } catch (OutOfMemoryError e10) {
            e10.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, int i10) {
        Toast makeText = Toast.makeText(this, str, 1);
        LinearLayout linearLayout = (LinearLayout) makeText.getView();
        ((TextView) linearLayout.getChildAt(0)).setPadding(8, 0, 0, 0);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 16.0f), com.tencent.connect.avatar.a.a(this, 16.0f)));
        if (i10 == 0) {
            imageView.setImageDrawable(b("com.tencent.plus.ic_success.png"));
        } else {
            imageView.setImageDrawable(b("com.tencent.plus.ic_error.png"));
        }
        linearLayout.addView(imageView, 0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        makeText.setView(linearLayout);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        String d10 = d(str);
        if ("".equals(d10)) {
            return;
        }
        this.f42506i.setText(d10);
        this.f42506i.setVisibility(0);
    }

    private View a() {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup.LayoutParams layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.f42498a = relativeLayout;
        relativeLayout.setLayoutParams(layoutParams);
        this.f42498a.setBackgroundColor(-16777216);
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        relativeLayout2.setLayoutParams(layoutParams3);
        this.f42498a.addView(relativeLayout2);
        c cVar = new c(this);
        this.f42502e = cVar;
        cVar.setLayoutParams(layoutParams2);
        this.f42502e.setScaleType(ImageView.ScaleType.MATRIX);
        relativeLayout2.addView(this.f42502e);
        this.f42505h = new b(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(layoutParams2);
        layoutParams4.addRule(14, -1);
        layoutParams4.addRule(15, -1);
        this.f42505h.setLayoutParams(layoutParams4);
        relativeLayout2.addView(this.f42505h);
        LinearLayout linearLayout = new LinearLayout(this);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, com.tencent.connect.avatar.a.a(this, 80.0f));
        layoutParams5.addRule(14, -1);
        linearLayout.setLayoutParams(layoutParams5);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        this.f42498a.addView(linearLayout);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 24.0f), com.tencent.connect.avatar.a.a(this, 24.0f)));
        imageView.setImageDrawable(b("com.tencent.plus.logo.png"));
        linearLayout.addView(imageView);
        this.f42506i = new TextView(this);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(layoutParams3);
        layoutParams6.leftMargin = com.tencent.connect.avatar.a.a(this, 7.0f);
        this.f42506i.setLayoutParams(layoutParams6);
        this.f42506i.setEllipsize(TextUtils.TruncateAt.END);
        this.f42506i.setSingleLine();
        this.f42506i.setTextColor(-1);
        this.f42506i.setTextSize(24.0f);
        this.f42506i.setVisibility(8);
        linearLayout.addView(this.f42506i);
        RelativeLayout relativeLayout3 = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, com.tencent.connect.avatar.a.a(this, 60.0f));
        layoutParams7.addRule(12, -1);
        layoutParams7.addRule(9, -1);
        relativeLayout3.setLayoutParams(layoutParams7);
        relativeLayout3.setBackgroundDrawable(b("com.tencent.plus.bar.png"));
        int a10 = com.tencent.connect.avatar.a.a(this, 10.0f);
        relativeLayout3.setPadding(a10, a10, a10, 0);
        this.f42498a.addView(relativeLayout3);
        a aVar = new a(this);
        int a11 = com.tencent.connect.avatar.a.a(this, 14.0f);
        int a12 = com.tencent.connect.avatar.a.a(this, 7.0f);
        this.f42504g = new Button(this);
        this.f42504g.setLayoutParams(new RelativeLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 78.0f), com.tencent.connect.avatar.a.a(this, 45.0f)));
        this.f42504g.setText("取消");
        this.f42504g.setTextColor(-1);
        this.f42504g.setTextSize(18.0f);
        this.f42504g.setPadding(a11, a12, a11, a12);
        aVar.b(this.f42504g);
        relativeLayout3.addView(this.f42504g);
        this.f42503f = new Button(this);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 78.0f), com.tencent.connect.avatar.a.a(this, 45.0f));
        layoutParams8.addRule(11, -1);
        this.f42503f.setLayoutParams(layoutParams8);
        this.f42503f.setTextColor(-1);
        this.f42503f.setTextSize(18.0f);
        this.f42503f.setPadding(a11, a12, a11, a12);
        this.f42503f.setText("选取");
        aVar.a(this.f42503f);
        relativeLayout3.addView(this.f42503f);
        TextView textView = new TextView(this);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(layoutParams3);
        layoutParams9.addRule(13, -1);
        textView.setLayoutParams(layoutParams9);
        textView.setText("移动和缩放");
        textView.setPadding(0, com.tencent.connect.avatar.a.a(this, 3.0f), 0, 0);
        textView.setTextSize(18.0f);
        textView.setTextColor(-1);
        relativeLayout3.addView(textView);
        this.f42507j = new ProgressBar(this);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(layoutParams3);
        layoutParams10.addRule(14, -1);
        layoutParams10.addRule(15, -1);
        this.f42507j.setLayoutParams(layoutParams10);
        this.f42507j.setVisibility(8);
        this.f42498a.addView(this.f42507j);
        return this.f42498a;
    }

    private void a(Bitmap bitmap) {
        new QQAvatarImp(this.f42499b).setAvator(bitmap, this.f42519v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final int i10) {
        this.f42501d.post(new Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.4
            @Override // java.lang.Runnable
            public void run() {
                ImageActivity.this.b(str, i10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEY_ERROR_CODE, i10);
        intent.putExtra(Constants.KEY_ERROR_MSG, str2);
        intent.putExtra(Constants.KEY_ERROR_DETAIL, str3);
        intent.putExtra(Constants.KEY_RESPONSE, str);
        setResult(-1, intent);
    }

    public void a(String str, long j10) {
        l.a(this, str, j10, this.f42499b.getAppId());
    }
}
