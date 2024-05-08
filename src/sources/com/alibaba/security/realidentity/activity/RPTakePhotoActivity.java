package com.alibaba.security.realidentity.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import com.alibaba.security.common.track.RPTrack;
import com.alibaba.security.common.track.model.LastExitTrackMsg;
import com.alibaba.security.common.track.model.LastExitTrackMsgPage;
import com.alibaba.security.common.track.model.TrackConstants;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.common.utils.CommonUtils;
import com.alibaba.security.common.utils.FileUtils;
import com.alibaba.security.common.utils.ImageUtils;
import com.alibaba.security.common.utils.JsonUtils;
import com.alibaba.security.common.utils.LocalBroadcastManagerUtils;
import com.alibaba.security.common.utils.PermissionsManager;
import com.alibaba.security.common.utils.UIUtils;
import com.alibaba.security.realidentity.R;
import com.alibaba.security.realidentity.build.ak;
import com.alibaba.security.realidentity.build.aq;
import com.alibaba.security.realidentity.build.d;
import com.alibaba.security.realidentity.build.hf;
import com.alibaba.security.realidentity.build.j;
import com.alibaba.security.realidentity.utils.ImageData;
import com.huawei.appgallery.agd.pageframe.api.CardEventType;
import com.zego.zegoliveroom.constants.ZegoConstants;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RPTakePhotoActivity extends RPBaseActivity implements DialogInterface.OnClickListener, SensorEventListener, ActivityCompat.OnRequestPermissionsResultCallback, SurfaceHolder.Callback, View.OnClickListener, hf.a {
    private static final int A = 102;
    private static final int B = 1;

    /* renamed from: a, reason: collision with root package name */
    private static final String f2926a = "RPTakePhotoActivity";

    /* renamed from: b, reason: collision with root package name */
    private static final int f2927b = -1;

    /* renamed from: c, reason: collision with root package name */
    private static final int f2928c = 0;

    /* renamed from: d, reason: collision with root package name */
    private static final int f2929d = 1;

    /* renamed from: e, reason: collision with root package name */
    private static final int f2930e = 2;

    /* renamed from: f, reason: collision with root package name */
    private static final int f2931f = 3;

    /* renamed from: g, reason: collision with root package name */
    private static final int f2932g = 4;

    /* renamed from: h, reason: collision with root package name */
    private static final int f2933h = 5;

    /* renamed from: i, reason: collision with root package name */
    private static final int f2934i = 6;

    /* renamed from: j, reason: collision with root package name */
    private static final int f2935j = 7;

    /* renamed from: k, reason: collision with root package name */
    private static final int f2936k = 8;

    /* renamed from: l, reason: collision with root package name */
    private static final int f2937l = 9;

    /* renamed from: m, reason: collision with root package name */
    private static final int f2938m = 10;

    /* renamed from: n, reason: collision with root package name */
    private static final int f2939n = 11;

    /* renamed from: o, reason: collision with root package name */
    private static final int f2940o = 12;

    /* renamed from: p, reason: collision with root package name */
    private static final int f2941p = 13;

    /* renamed from: q, reason: collision with root package name */
    private static final int f2942q = 14;

    /* renamed from: r, reason: collision with root package name */
    private static final int f2943r = -1000;

    /* renamed from: s, reason: collision with root package name */
    private static final int f2944s = -100;

    /* renamed from: t, reason: collision with root package name */
    private static final int f2945t = 1;

    /* renamed from: u, reason: collision with root package name */
    private static final int f2946u = 2;

    /* renamed from: v, reason: collision with root package name */
    private static final int f2947v = 3;

    /* renamed from: w, reason: collision with root package name */
    private static final int f2948w = 4;

    /* renamed from: x, reason: collision with root package name */
    private static final int f2949x = 6;

    /* renamed from: y, reason: collision with root package name */
    private static final int f2950y = 100;

    /* renamed from: z, reason: collision with root package name */
    private static final int f2951z = 101;
    private ak E;
    private hf F;
    private WindowManager G;
    private SurfaceView H;
    private SurfaceHolder I;
    private ImageView J;
    private Intent K;
    private int[] P;
    private int Q;
    private String[] U;
    private String V;
    private ArrayList<ImageData> W;
    private HashMap<String, String> X;
    private TextView Y;
    private TextView Z;

    /* renamed from: aa, reason: collision with root package name */
    private TextView f2952aa;

    /* renamed from: ab, reason: collision with root package name */
    private TextView f2953ab;

    /* renamed from: ac, reason: collision with root package name */
    private View f2954ac;

    /* renamed from: ad, reason: collision with root package name */
    private ViewGroup f2955ad;

    /* renamed from: ae, reason: collision with root package name */
    private ViewGroup f2956ae;
    private TextView af;
    private ImageView ag;
    private TextView ah;
    private int ai;
    private ViewGroup aj;
    private ImageView ak;
    private TextView al;
    private boolean ao;
    private a ap;
    private SensorManager at;
    private Sensor aw;
    private float ax;
    private float ay;
    private float az;
    private int C = 0;
    private int D = 0;
    private boolean L = false;
    private boolean M = false;
    private boolean N = false;
    private boolean O = false;
    private String R = "";
    private int S = 1;
    private int T = 0;
    private int am = 0;
    private int an = 0;
    private final Camera.ShutterCallback aq = new Camera.ShutterCallback() { // from class: com.alibaba.security.realidentity.activity.RPTakePhotoActivity.4
        @Override // android.hardware.Camera.ShutterCallback
        public final void onShutter() {
        }
    };

    /* renamed from: ar, reason: collision with root package name */
    private Camera.PictureCallback f2957ar = new Camera.PictureCallback() { // from class: com.alibaba.security.realidentity.activity.RPTakePhotoActivity.5
        @Override // android.hardware.Camera.PictureCallback
        public final void onPictureTaken(byte[] bArr, Camera camera) {
            if (bArr == null) {
                return;
            }
            try {
                Bitmap a10 = RPTakePhotoActivity.a(ImageUtils.loadBitmap(ImageUtils.saveImage(bArr, RPTakePhotoActivity.this), 800, 480));
                RPTakePhotoActivity.this.V = ImageUtils.saveImage(ImageUtils.compressImage(a10), RPTakePhotoActivity.this);
                if (RPTakePhotoActivity.this.V != null) {
                    RPTakePhotoActivity.this.R = ZegoConstants.DeviceNameType.DeviceNameCamera;
                    RPTakePhotoActivity.this.ap.sendEmptyMessage(2);
                    return;
                }
                RPTakePhotoActivity.b(new TakePhotoTrackParams("exit", RPTakePhotoActivity.this.Q), new TakePhotoResult("Camera.PictureCallback filePath is null"));
                d.a().a("RPTakePhotoPage", "ViewExit", new Integer(RPTakePhotoActivity.this.Q).toString(), "error", "5", null);
                RPTakePhotoActivity.this.K.putExtra("errorMsg", aq.ag);
                RPTakePhotoActivity rPTakePhotoActivity = RPTakePhotoActivity.this;
                rPTakePhotoActivity.a(rPTakePhotoActivity.K);
                RPTakePhotoActivity.this.finish();
            } catch (Exception e2) {
                RPTakePhotoActivity.b("Take Photo Camera.PictureCallback", CommonUtils.getStackTrace(e2));
                RPTakePhotoActivity.b(new TakePhotoTrackParams("exit", RPTakePhotoActivity.this.Q), new TakePhotoResult("Camera.PictureCallback exception"));
                d.a().a("RPTakePhotoPage", "ViewExit", new Integer(RPTakePhotoActivity.this.Q).toString(), "error", "5", null);
                RPTakePhotoActivity.this.K.putExtra("errorMsg", aq.ag);
                RPTakePhotoActivity rPTakePhotoActivity2 = RPTakePhotoActivity.this;
                rPTakePhotoActivity2.a(rPTakePhotoActivity2.K);
                RPTakePhotoActivity.this.finish();
            }
        }
    };
    private boolean as = false;
    private final boolean au = false;
    private boolean av = false;
    private Camera.AutoFocusCallback aA = new Camera.AutoFocusCallback() { // from class: com.alibaba.security.realidentity.activity.RPTakePhotoActivity.9
        @Override // android.hardware.Camera.AutoFocusCallback
        public final void onAutoFocus(boolean z10, Camera camera) {
        }
    };

    /* renamed from: com.alibaba.security.realidentity.activity.RPTakePhotoActivity$3, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class AnonymousClass3 implements View.OnTouchListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (RPTakePhotoActivity.this.Q != 3 || RPTakePhotoActivity.this.L) {
                    RPTakePhotoActivity.this.ap.sendEmptyMessage(6);
                } else {
                    RPTakePhotoActivity.this.l();
                }
            }
            return true;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class TakePhotoResult implements Serializable {
        private String reason;

        public String getReason() {
            return this.reason;
        }

        public void setReason(String str) {
            this.reason = str;
        }

        private TakePhotoResult(String str) {
            this.reason = str;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class TakePhotoTrackParams implements Serializable {
        private String action;
        private int cart_type;

        public TakePhotoTrackParams(String str, int i10) {
            this.action = str;
            this.cart_type = i10;
        }

        public String getAction() {
            return this.action;
        }

        public int getCart_type() {
            return this.cart_type;
        }

        public void setAction(String str) {
            this.action = str;
        }

        public void setCart_type(int i10) {
            this.cart_type = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final RPTakePhotoActivity f2967a;

        public a(RPTakePhotoActivity rPTakePhotoActivity) {
            super(Looper.getMainLooper());
            this.f2967a = rPTakePhotoActivity;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 2) {
                RPTakePhotoActivity.j(this.f2967a);
                return;
            }
            if (i10 == 3) {
                RPTakePhotoActivity.a(this.f2967a, message);
            } else if (i10 == 4) {
                RPTakePhotoActivity.k(this.f2967a);
            } else {
                if (i10 != 6) {
                    return;
                }
                RPTakePhotoActivity.i(this.f2967a);
            }
        }
    }

    private void i() {
        this.J.setEnabled(false);
        SensorManager sensorManager = this.at;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        if (this.as) {
            this.as = false;
            if (this.Q == 3) {
                this.N = false;
                this.f2953ab.setEnabled(false);
            }
            try {
                this.E.f3069a.takePicture(this.aq, null, this.f2957ar);
            } catch (Exception e2) {
                j.a.f3944a.a(TrackLog.createSdkExceptionLog("takePhoto camera exception", CommonUtils.getStackTrace(e2), ""));
                a(this.K);
                d.a().a("RPTakePhotoPage", "ViewExit", Integer.valueOf(this.Q).toString(), "error", "3", null);
                finish();
            }
        }
    }

    private void j() {
        Intent intent = getIntent();
        this.K = intent;
        if (intent != null) {
            this.X = new HashMap<>();
            this.W = new ArrayList<>();
            String stringExtra = this.K.getStringExtra(aq.G);
            this.U = this.K.getStringArrayExtra(aq.f3129y);
            this.ao = this.K.getBooleanExtra(aq.f3128x, false);
            this.K.setAction(stringExtra);
            int[] intArrayExtra = this.K.getIntArrayExtra(aq.f3130z);
            this.P = intArrayExtra;
            int i10 = (intArrayExtra == null || intArrayExtra.length <= 0) ? -1000 : intArrayExtra[0];
            this.Q = i10;
            if (i10 == -1000) {
                b(new TakePhotoTrackParams("exit", i10), new TakePhotoResult("NoType"));
                d.a().a("RPTakePhotoPage", "ViewExit", Integer.valueOf(this.Q).toString(), "error", "4", null);
                finish();
                return;
            }
            return;
        }
        b(new TakePhotoTrackParams("exit", this.Q), new TakePhotoResult("Intent is null"));
        d.a().a("RPTakePhotoPage", "ViewExit", Integer.valueOf(this.Q).toString(), "error", "4", null);
        finish();
    }

    private void k() {
        if (this.L) {
            this.ak.setVisibility(0);
            this.f2952aa.setVisibility(0);
            if (this.U.length == 1) {
                this.f2952aa.setVisibility(8);
            }
            this.f2954ac.setVisibility(0);
            this.f2953ab.setText(getString(R.string.close_gesture));
            this.L = false;
            return;
        }
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.ak.setVisibility(8);
        this.f2952aa.setVisibility(8);
        this.f2954ac.setVisibility(8);
        this.f2953ab.setText(getString(R.string.open_gesture));
        this.L = true;
    }

    private void m() {
        this.ak.setVisibility(0);
        this.f2952aa.setVisibility(0);
        if (this.U.length == 1) {
            this.f2952aa.setVisibility(8);
        }
        this.f2954ac.setVisibility(0);
        this.f2953ab.setText(getString(R.string.close_gesture));
        this.L = false;
    }

    private void n() {
        Iterator<Map.Entry<String, String>> iterator2 = this.X.entrySet().iterator2();
        Set<Map.Entry<String, String>> entrySet = this.X.entrySet();
        int i10 = this.S;
        String[] strArr = this.U;
        if (i10 == strArr.length || i10 > strArr.length) {
            this.S = 0;
        }
        if (entrySet.size() == 1) {
            this.f2952aa.setVisibility(8);
            return;
        }
        while (iterator2.hasNext()) {
            String str = this.X.get(this.U[this.S]);
            if (!TextUtils.isEmpty(str)) {
                this.ak.setImageURI(Uri.fromFile(new File(str)));
                int i11 = this.S;
                this.T = i11;
                this.S = i11 + 1;
                return;
            }
            int i12 = this.S + 1;
            this.S = i12;
            if (i12 == this.U.length) {
                this.S = 0;
            }
        }
    }

    private void o() {
        d.a().a("RPPreviewPhotoPage", "ViewExit", Integer.valueOf(this.Q).toString(), CardEventType.CLICK_ACTION_CANCEL, null, null);
        this.af.setEnabled(false);
        this.N = false;
        if (this.Q == 3) {
            this.f2953ab.setEnabled(true);
        }
        a(this.ag);
        this.f2956ae.setVisibility(8);
        this.f2955ad.setVisibility(0);
        if (this.N) {
            return;
        }
        this.H.setVisibility(0);
    }

    private void p() {
        String[] strArr;
        ImageData imageData = new ImageData();
        imageData.f4052a = this.V;
        int i10 = this.Q;
        imageData.f4053b = i10;
        imageData.f4055d = this.R;
        if (i10 == 3 && (strArr = this.U) != null && strArr.length > 0) {
            imageData.f4054c = strArr[this.T];
        }
        this.W.add(imageData);
        this.K.putExtra(aq.H, this.W);
    }

    private void q() {
        int[] iArr = this.P;
        if (iArr.length > 0) {
            int i10 = this.ai;
            iArr[i10] = -100;
            if (i10 < iArr.length - 1) {
                this.Q = iArr[i10 + 1];
                this.ai = i10 + 1;
            }
        }
        if (iArr[iArr.length - 1] == -100) {
            a(this.K);
            finish();
            return;
        }
        if (!this.N) {
            a(this.Q);
            this.H.setVisibility(0);
        }
        this.f2956ae.setVisibility(8);
        this.f2955ad.setVisibility(0);
    }

    private void r() {
        int i10 = 0;
        while (true) {
            String[] strArr = this.U;
            if (i10 >= strArr.length) {
                return;
            }
            String str = this.X.get(strArr[i10]);
            if (!TextUtils.isEmpty(str)) {
                this.ak.setImageURI(Uri.fromFile(new File(str)));
                this.ak.setBackgroundColor(getResources().getColor(R.color.rpsdk_transparency_65));
                this.ak.setScaleType(ImageView.ScaleType.FIT_CENTER);
                this.f2953ab.setVisibility(0);
                this.T = i10;
                this.S = i10 + 1;
                return;
            }
            if (i10 == this.U.length - 1) {
                b(new TakePhotoTrackParams("exit", this.Q), new TakePhotoResult("imgDownloadFail"));
                d.a().a("RPTakePhotoPage", "ViewExit", Integer.valueOf(this.Q).toString(), "error", "2", null);
                Toast.makeText(this, getString(R.string.load_gesture_img_faild), 0).show();
                a(this.K);
                finish();
            }
            i10++;
        }
    }

    private static LastExitTrackMsg s() {
        LastExitTrackMsg lastExitTrackMsg = new LastExitTrackMsg();
        lastExitTrackMsg.setPage(LastExitTrackMsgPage.TAKE_PHOTO.getMsg());
        lastExitTrackMsg.setView("");
        lastExitTrackMsg.setParams("");
        return lastExitTrackMsg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.O) {
            return;
        }
        String[] strArr = {"android.permission.CAMERA"};
        if (this.C <= 0 && !PermissionsManager.hasPermissions(this, strArr)) {
            this.C++;
            PermissionsManager.requestPermissions(this, strArr, 102, "人脸识别服务需要您授权相机权限", new Runnable() { // from class: com.alibaba.security.realidentity.activity.RPTakePhotoActivity.6
                @Override // java.lang.Runnable
                public final void run() {
                    RPTakePhotoActivity.this.t();
                }
            }, new Runnable() { // from class: com.alibaba.security.realidentity.activity.RPTakePhotoActivity.7
                @Override // java.lang.Runnable
                public final void run() {
                    RPTakePhotoActivity.this.t();
                }
            });
            return;
        }
        if (!PermissionsManager.hasPermissions(this, strArr)) {
            AlertDialog create = new AlertDialog.Builder(this).setTitle("无法连接相机").setMessage("无法打开摄像头，请检查是否开启了相关权限").setPositiveButton("确定", this).setNeutralButton("退出", new DialogInterface.OnClickListener() { // from class: com.alibaba.security.realidentity.activity.RPTakePhotoActivity.8
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    dialogInterface.dismiss();
                }
            }).create();
            create.setCancelable(false);
            create.show();
            return;
        }
        this.E = null;
        this.E = new ak(this);
        this.E.a(ak.d());
        Build.MODEL.toLowerCase(Locale.US).replace(" ", "");
        try {
            ak akVar = this.E;
            if (akVar != null) {
                akVar.a(this.I);
                this.O = true;
                this.E.b();
                this.J.setEnabled(true);
            }
        } catch (Exception unused) {
            AlertDialog create2 = new AlertDialog.Builder(this).setTitle("无法连接相机").setMessage("无法打开摄像头，请检查是否开启了相关权限").setPositiveButton("确定", this).setNeutralButton("退出", this).create();
            create2.setCancelable(false);
            create2.show();
        }
    }

    private void u() {
        String num = Integer.valueOf(this.Q).toString();
        d.a().a("RPTakePhotoPage", "ViewExit", num, "goPreview", null, null);
        d.a().a("RPPreviewPhotoPage", "ViewEnter", num, null, null, null);
        this.H.setVisibility(8);
        this.ah.setEnabled(true);
        this.af.setEnabled(true);
        this.N = true;
        this.O = false;
        ViewGroup viewGroup = this.f2956ae;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        ViewGroup viewGroup2 = this.f2955ad;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(8);
        }
        this.ag.setImageBitmap(BitmapFactory.decodeFile(this.V));
    }

    private void v() {
        Build.MODEL.toLowerCase(Locale.US).replace(" ", "");
        SensorManager sensorManager = (SensorManager) getSystemService("sensor");
        this.at = sensorManager;
        if (sensorManager != null) {
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            this.aw = defaultSensor;
            this.at.registerListener(this, defaultSensor, 3);
            this.F = new hf(this);
        }
    }

    private void w() {
        d.a().a("RPTakePhotoPage", "ViewExit", Integer.valueOf(this.Q).toString(), "error", "1", null);
        finish();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (i10 == 101 && i11 == -1) {
            String realPathFromUri = FileUtils.getRealPathFromUri(this, intent.getData());
            this.V = realPathFromUri;
            if (realPathFromUri != null) {
                this.R = "photoAlbum";
                this.ap.sendEmptyMessage(2);
            } else {
                b(new TakePhotoTrackParams("exit", this.Q), new TakePhotoResult("onActivityResult filePath is null"));
                d.a().a("RPTakePhotoPage", "ViewExit", Integer.valueOf(this.Q).toString(), "error", "5", null);
                this.K.putExtra("errorMsg", aq.ag);
                finish();
                a(this.K);
            }
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        int id2 = view.getId();
        if (id2 == R.id.cancel_text) {
            b(new TakePhotoTrackParams("exit", this.Q), new TakePhotoResult(CardEventType.CLICK_ACTION_CANCEL));
            d.a().a("RPTakePhotoPage", "ViewExit", Integer.valueOf(this.Q).toString(), CardEventType.CLICK_ACTION_CANCEL, null, null);
            this.K.putExtra(aq.Z, true);
            a(this.K);
            finish();
            return;
        }
        if (id2 == R.id.tv_close_examples) {
            if (this.L) {
                this.ak.setVisibility(0);
                this.f2952aa.setVisibility(0);
                if (this.U.length == 1) {
                    this.f2952aa.setVisibility(8);
                }
                this.f2954ac.setVisibility(0);
                this.f2953ab.setText(getString(R.string.close_gesture));
                this.L = false;
                return;
            }
            l();
            return;
        }
        if (id2 == R.id.tv_switch_gesture) {
            Iterator<Map.Entry<String, String>> iterator2 = this.X.entrySet().iterator2();
            Set<Map.Entry<String, String>> entrySet = this.X.entrySet();
            int i10 = this.S;
            String[] strArr2 = this.U;
            if (i10 == strArr2.length || i10 > strArr2.length) {
                this.S = 0;
            }
            if (entrySet.size() == 1) {
                this.f2952aa.setVisibility(8);
                return;
            }
            while (iterator2.hasNext()) {
                String str = this.X.get(this.U[this.S]);
                if (!TextUtils.isEmpty(str)) {
                    this.ak.setImageURI(Uri.fromFile(new File(str)));
                    int i11 = this.S;
                    this.T = i11;
                    this.S = i11 + 1;
                    return;
                }
                int i12 = this.S + 1;
                this.S = i12;
                if (i12 == this.U.length) {
                    this.S = 0;
                }
            }
            return;
        }
        if (id2 == R.id.reget_button) {
            o();
            return;
        }
        if (id2 == R.id.next_button) {
            d.a().a("RPPreviewPhotoPage", "ViewExit", Integer.valueOf(this.Q).toString(), "confirm", null, null);
            this.ah.setEnabled(false);
            this.N = false;
            a(this.ag);
            a(this.ak);
            ImageData imageData = new ImageData();
            imageData.f4052a = this.V;
            int i13 = this.Q;
            imageData.f4053b = i13;
            imageData.f4055d = this.R;
            if (i13 == 3 && (strArr = this.U) != null && strArr.length > 0) {
                imageData.f4054c = strArr[this.T];
            }
            this.W.add(imageData);
            this.K.putExtra(aq.H, this.W);
            int[] iArr = this.P;
            if (iArr.length > 0) {
                int i14 = this.ai;
                iArr[i14] = -100;
                if (i14 < iArr.length - 1) {
                    this.Q = iArr[i14 + 1];
                    this.ai = i14 + 1;
                }
            }
            if (iArr[iArr.length - 1] == -100) {
                a(this.K);
                finish();
                return;
            }
            if (!this.N) {
                a(this.Q);
                this.H.setVisibility(0);
            }
            this.f2956ae.setVisibility(8);
            this.f2955ad.setVisibility(0);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        setContentView(R.layout.rp_alrealidentity_activity_rp_take_photo);
        this.G = (WindowManager) getApplicationContext().getSystemService("window");
        this.ap = new a(this);
        this.f2955ad = (ViewGroup) findViewById(R.id.rp_take_photo_layout);
        this.aj = (ViewGroup) findViewById(R.id.take_modle_parent);
        this.f2954ac = findViewById(R.id.detile_parent);
        this.ak = (ImageView) findViewById(R.id.take_photo_background_img);
        TextView textView = (TextView) findViewById(R.id.tv_switch_gesture);
        this.f2952aa = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.tv_close_examples);
        this.f2953ab = textView2;
        textView2.setOnClickListener(this);
        this.Y = (TextView) findViewById(R.id.tv_card_tips);
        this.Z = (TextView) findViewById(R.id.tv_take_photo_hint);
        findViewById(R.id.cancel_text).setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.take_photo);
        this.J = imageView;
        imageView.setEnabled(false);
        TextView textView3 = (TextView) findViewById(R.id.pick_photo_text);
        this.al = textView3;
        textView3.setOnClickListener(this);
        this.H = (SurfaceView) findViewById(R.id.my_surfaceView);
        this.am = this.f2954ac.getLayoutParams().height;
        this.an = ((RelativeLayout.LayoutParams) this.aj.getLayoutParams()).leftMargin;
        this.f2956ae = (ViewGroup) findViewById(R.id.rp_preview_layout);
        TextView textView4 = (TextView) findViewById(R.id.reget_button);
        this.af = textView4;
        textView4.setOnClickListener(this);
        TextView textView5 = (TextView) findViewById(R.id.next_button);
        this.ah = textView5;
        textView5.setOnClickListener(this);
        this.ag = (ImageView) findViewById(R.id.picture);
        SurfaceHolder holder = this.H.getHolder();
        this.I = holder;
        holder.addCallback(this);
        Intent intent = getIntent();
        this.K = intent;
        if (intent != null) {
            this.X = new HashMap<>();
            this.W = new ArrayList<>();
            String stringExtra = this.K.getStringExtra(aq.G);
            this.U = this.K.getStringArrayExtra(aq.f3129y);
            this.ao = this.K.getBooleanExtra(aq.f3128x, false);
            this.K.setAction(stringExtra);
            int[] intArrayExtra = this.K.getIntArrayExtra(aq.f3130z);
            this.P = intArrayExtra;
            int i10 = (intArrayExtra == null || intArrayExtra.length <= 0) ? -1000 : intArrayExtra[0];
            this.Q = i10;
            if (i10 == -1000) {
                b(new TakePhotoTrackParams("exit", i10), new TakePhotoResult("NoType"));
                d.a().a("RPTakePhotoPage", "ViewExit", Integer.valueOf(this.Q).toString(), "error", "4", null);
                finish();
            }
        } else {
            b(new TakePhotoTrackParams("exit", this.Q), new TakePhotoResult("Intent is null"));
            d.a().a("RPTakePhotoPage", "ViewExit", Integer.valueOf(this.Q).toString(), "error", "4", null);
            finish();
        }
        a(this.Q);
        a(this.U);
        this.J.setOnTouchListener(new AnonymousClass3());
        this.H.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.realidentity.activity.RPTakePhotoActivity.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RPTakePhotoActivity.this.a();
            }
        });
        a();
        UIUtils.setForceDarkAllowed(getWindow().getDecorView(), false);
        b(new TakePhotoTrackParams(TrackConstants.Method.ENTER, this.Q), (TakePhotoResult) null);
        RPTrack.setLastStepTrackMsg(null);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        SensorManager sensorManager = this.at;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
            this.aA = null;
        }
        this.X.clear();
        this.X = null;
        this.W.clear();
        this.W = null;
        ak akVar = this.E;
        if (akVar != null) {
            akVar.a();
            this.E = null;
        }
        this.K = null;
        this.ap.removeCallbacksAndMessages(null);
        this.U = null;
        this.P = null;
        this.f2957ar = null;
        this.aj.removeAllViews();
        this.f2956ae.removeAllViews();
        this.f2955ad.removeAllViews();
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            if (this.N) {
                o();
                return true;
            }
            d.a().a("RPTakePhotoPage", "ViewExit", Integer.valueOf(this.Q).toString(), CardEventType.CLICK_ACTION_CANCEL, null, null);
            b(new TakePhotoTrackParams("exit", this.Q), new TakePhotoResult("album cancel"));
            this.K.putExtra(aq.Z, true);
            a(this.K);
            LastExitTrackMsg lastExitTrackMsg = new LastExitTrackMsg();
            lastExitTrackMsg.setPage(LastExitTrackMsgPage.TAKE_PHOTO.getMsg());
            lastExitTrackMsg.setView("");
            lastExitTrackMsg.setParams("");
            RPTrack.setLastStepTrackMsg(lastExitTrackMsg);
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (i10 == 102) {
            t();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.N) {
            return;
        }
        this.H.setVisibility(0);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor;
        hf hfVar = this.F;
        if (hfVar == null || (sensor = sensorEvent.sensor) == null) {
            return;
        }
        if (hfVar.f3818f) {
            hfVar.f3821m = 0;
            hfVar.f3819g = false;
            hfVar.f3813a = 0;
            hfVar.f3814b = 0;
            hfVar.f3815c = 0;
            return;
        }
        if (sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            int i10 = (int) fArr[0];
            int i11 = (int) fArr[1];
            int i12 = (int) fArr[2];
            Calendar calendar = Calendar.getInstance();
            hfVar.f3817e = calendar;
            long timeInMillis = calendar.getTimeInMillis();
            hfVar.f3817e.get(13);
            if (hfVar.f3821m != 0) {
                int abs = Math.abs(hfVar.f3813a - i10);
                int abs2 = Math.abs(hfVar.f3814b - i11);
                int abs3 = Math.abs(hfVar.f3815c - i12);
                if (Math.sqrt((abs * abs) + (abs2 * abs2) + (abs3 * abs3)) > 1.4d) {
                    hfVar.f3821m = 2;
                } else {
                    if (hfVar.f3821m == 2) {
                        hfVar.f3816d = timeInMillis;
                        hfVar.f3819g = true;
                    }
                    if (hfVar.f3819g && timeInMillis - hfVar.f3816d > 500 && !hfVar.f3818f) {
                        hfVar.f3819g = false;
                        hf.a aVar = hfVar.f3822n;
                        if (aVar != null) {
                            aVar.a();
                        }
                    }
                    hfVar.f3821m = 1;
                }
            } else {
                hfVar.f3816d = timeInMillis;
                hfVar.f3821m = 1;
            }
            hfVar.f3813a = i10;
            hfVar.f3814b = i11;
            hfVar.f3815c = i12;
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.N) {
            return;
        }
        this.H.setVisibility(8);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (this.N) {
            return;
        }
        t();
        this.av = false;
        Build.MODEL.toLowerCase(Locale.US).replace(" ", "");
        SensorManager sensorManager = (SensorManager) getSystemService("sensor");
        this.at = sensorManager;
        if (sensorManager != null) {
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            this.aw = defaultSensor;
            this.at.registerListener(this, defaultSensor, 3);
            this.F = new hf(this);
        }
        this.as = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (this.N) {
            return;
        }
        SensorManager sensorManager = this.at;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        ak akVar = this.E;
        if (akVar != null) {
            akVar.c();
            this.E.a();
            this.E = null;
            this.O = false;
        }
        this.as = false;
    }

    private void c() {
        this.f2955ad = (ViewGroup) findViewById(R.id.rp_take_photo_layout);
        this.aj = (ViewGroup) findViewById(R.id.take_modle_parent);
        this.f2954ac = findViewById(R.id.detile_parent);
        this.ak = (ImageView) findViewById(R.id.take_photo_background_img);
        TextView textView = (TextView) findViewById(R.id.tv_switch_gesture);
        this.f2952aa = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.tv_close_examples);
        this.f2953ab = textView2;
        textView2.setOnClickListener(this);
        this.Y = (TextView) findViewById(R.id.tv_card_tips);
        this.Z = (TextView) findViewById(R.id.tv_take_photo_hint);
        findViewById(R.id.cancel_text).setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.take_photo);
        this.J = imageView;
        imageView.setEnabled(false);
        TextView textView3 = (TextView) findViewById(R.id.pick_photo_text);
        this.al = textView3;
        textView3.setOnClickListener(this);
        this.H = (SurfaceView) findViewById(R.id.my_surfaceView);
        this.am = this.f2954ac.getLayoutParams().height;
        this.an = ((RelativeLayout.LayoutParams) this.aj.getLayoutParams()).leftMargin;
        this.f2956ae = (ViewGroup) findViewById(R.id.rp_preview_layout);
        TextView textView4 = (TextView) findViewById(R.id.reget_button);
        this.af = textView4;
        textView4.setOnClickListener(this);
        TextView textView5 = (TextView) findViewById(R.id.next_button);
        this.ah = textView5;
        textView5.setOnClickListener(this);
        this.ag = (ImageView) findViewById(R.id.picture);
    }

    private void d() {
        this.f2955ad = (ViewGroup) findViewById(R.id.rp_take_photo_layout);
        this.aj = (ViewGroup) findViewById(R.id.take_modle_parent);
        this.f2954ac = findViewById(R.id.detile_parent);
        this.ak = (ImageView) findViewById(R.id.take_photo_background_img);
        TextView textView = (TextView) findViewById(R.id.tv_switch_gesture);
        this.f2952aa = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.tv_close_examples);
        this.f2953ab = textView2;
        textView2.setOnClickListener(this);
        this.Y = (TextView) findViewById(R.id.tv_card_tips);
        this.Z = (TextView) findViewById(R.id.tv_take_photo_hint);
        findViewById(R.id.cancel_text).setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.take_photo);
        this.J = imageView;
        imageView.setEnabled(false);
        TextView textView3 = (TextView) findViewById(R.id.pick_photo_text);
        this.al = textView3;
        textView3.setOnClickListener(this);
        this.H = (SurfaceView) findViewById(R.id.my_surfaceView);
        this.am = this.f2954ac.getLayoutParams().height;
        this.an = ((RelativeLayout.LayoutParams) this.aj.getLayoutParams()).leftMargin;
    }

    private void e() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = this.am;
        layoutParams.addRule(15);
        this.f2954ac.setLayoutParams(layoutParams);
        this.f2954ac.setRotation(90.0f);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.G.getDefaultDisplay().getMetrics(displayMetrics);
        int i10 = displayMetrics.widthPixels;
        int i11 = this.f2954ac.getLayoutParams().height;
        this.f2954ac.setTranslationX((i10 - (i11 + (i11 / 2))) / 2.0f);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aj.getLayoutParams();
        layoutParams2.leftMargin = this.an;
        this.aj.setLayoutParams(layoutParams2);
    }

    private void f() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = this.am;
        layoutParams.addRule(10);
        this.f2954ac.setLayoutParams(layoutParams);
        this.f2954ac.setRotation(0.0f);
        this.f2954ac.setTranslationX(0.0f);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aj.getLayoutParams();
        layoutParams2.leftMargin = 0;
        this.aj.setLayoutParams(layoutParams2);
    }

    private void g() {
        this.f2956ae = (ViewGroup) findViewById(R.id.rp_preview_layout);
        TextView textView = (TextView) findViewById(R.id.reget_button);
        this.af = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.next_button);
        this.ah = textView2;
        textView2.setOnClickListener(this);
        this.ag = (ImageView) findViewById(R.id.picture);
    }

    private void h() {
        this.J.setOnTouchListener(new AnonymousClass3());
    }

    private void b() {
        SurfaceHolder holder = this.H.getHolder();
        this.I = holder;
        holder.addCallback(this);
    }

    private static Bitmap b(Bitmap bitmap) {
        if (Build.MODEL.toLowerCase(Locale.US).replace(" ", "").contains("nexus5x")) {
            return ImageUtils.rotateBitmap(bitmap, 270);
        }
        return ImageUtils.rotateBitmap(bitmap, 90);
    }

    private void a(String[] strArr) {
        if (strArr != null) {
            for (String str : strArr) {
                new AsyncTask<String, Void, Void>() { // from class: com.alibaba.security.realidentity.activity.RPTakePhotoActivity.2
                    private Void a(String... strArr2) {
                        String imagePathByUrlSync = ImageUtils.getImagePathByUrlSync(strArr2[0], RPTakePhotoActivity.this);
                        if (TextUtils.isEmpty(imagePathByUrlSync) || RPTakePhotoActivity.this.X == null) {
                            return null;
                        }
                        RPTakePhotoActivity.this.X.put(strArr2[0], imagePathByUrlSync);
                        return null;
                    }

                    @Override // android.os.AsyncTask
                    public final /* synthetic */ Void doInBackground(String[] strArr2) {
                        String[] strArr3 = strArr2;
                        String imagePathByUrlSync = ImageUtils.getImagePathByUrlSync(strArr3[0], RPTakePhotoActivity.this);
                        if (TextUtils.isEmpty(imagePathByUrlSync) || RPTakePhotoActivity.this.X == null) {
                            return null;
                        }
                        RPTakePhotoActivity.this.X.put(strArr3[0], imagePathByUrlSync);
                        return null;
                    }
                }.execute(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, String str2) {
        TrackLog createSdkExceptionLog = TrackLog.createSdkExceptionLog(str, str2, "");
        createSdkExceptionLog.setCode(-1);
        j.a.f3944a.a(createSdkExceptionLog);
    }

    private static int a(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return -1000;
        }
        return iArr[0];
    }

    public static /* synthetic */ void k(RPTakePhotoActivity rPTakePhotoActivity) {
        d.a().a("RPTakePhotoPage", "ViewExit", Integer.valueOf(rPTakePhotoActivity.Q).toString(), "error", "1", null);
        rPTakePhotoActivity.finish();
    }

    private void a(int i10) {
        String num = Integer.valueOf(i10).toString();
        d.a().a("RPTakePhotoPage", "ViewEnter", num, null, null, null);
        this.f2954ac.setBackgroundResource(R.color.rpsdk_detile_parent_normalbg);
        this.f2952aa.setVisibility(8);
        this.f2953ab.setVisibility(8);
        this.f2954ac.setVisibility(0);
        this.ak.setVisibility(0);
        this.ak.setScaleType(ImageView.ScaleType.FIT_XY);
        this.ak.setBackgroundResource(0);
        this.f2953ab.setText(getString(R.string.close_gesture));
        this.L = false;
        a(false);
        if (i10 == 1) {
            this.Y.setText(getString(R.string.identity_front_title));
            this.Z.setText(getString(R.string.identity_hint));
            this.ak.setImageResource(R.drawable.rp_frontcardpic);
            a(true);
            e();
            return;
        }
        if (i10 == 2) {
            this.Y.setText(getString(R.string.identity_back_title));
            this.Z.setText(getString(R.string.identity_hint));
            this.ak.setImageResource(R.drawable.rp_backcardpic);
            a(true);
            e();
            return;
        }
        if (i10 == 3) {
            this.Y.setText(getString(R.string.gesture_tips_title));
            this.Z.setText(getString(R.string.gesture_tips_hint));
            this.f2952aa.setVisibility(0);
            if (this.U.length == 1) {
                this.f2952aa.setVisibility(8);
            }
            this.ap.sendEmptyMessageDelayed(3, 300L);
            f();
            return;
        }
        if (i10 == 4) {
            this.Y.setText(getString(R.string.passport_tips_title));
            this.Z.setText(getString(R.string.passport_tips_hint));
            this.ak.setImageResource(R.drawable.rp_backcardhk);
            f();
            return;
        }
        if (i10 == 5) {
            this.Y.setText(getString(R.string.id_hk_front_title));
            this.Z.setText(getString(R.string.id_hk_hint));
            this.ak.setImageResource(R.drawable.rp_hkpassport_bg);
            e();
            return;
        }
        if (i10 == 6) {
            this.Y.setText(getString(R.string.hk_id_tips_title));
            this.Z.setText(getString(R.string.hk_id_tips_hint));
            this.ak.setImageResource(R.drawable.rp_hkpassport_bg);
            e();
            return;
        }
        if (i10 == 7) {
            this.Y.setText(getString(R.string.id_tw_back_title));
            this.Z.setText(getString(R.string.id_tw_hint));
            this.ak.setImageResource(R.drawable.rp_backcardhk);
            e();
            return;
        }
        if (i10 == 8) {
            this.Y.setText(getString(R.string.id_hk_back_title));
            this.Z.setText(getString(R.string.id_hk_hint));
            this.ak.setImageResource(R.drawable.rp_backcardhk);
            e();
            return;
        }
        if (i10 == 9) {
            this.Y.setText(getString(R.string.identity_fg_front_title));
            this.Z.setText(getString(R.string.identity_fg_hint));
            this.ak.setImageResource(R.drawable.rp_backcardpic);
            e();
            return;
        }
        if (i10 == 10) {
            this.Y.setText(getString(R.string.identity_fg_back_title));
            this.Z.setText(getString(R.string.identity_fg_hint));
            this.ak.setImageResource(R.drawable.rp_backcardpic);
            e();
            return;
        }
        if (i10 == 11) {
            this.Y.setText(getString(R.string.identity_hk_front_title));
            this.Z.setText(getString(R.string.identity_hk_hint));
            this.ak.setImageResource(R.drawable.rp_frontcardpic);
            e();
            return;
        }
        if (i10 == 12) {
            this.Y.setText(getString(R.string.identity_hk_back_title));
            this.Z.setText(getString(R.string.identity_hk_hint));
            this.ak.setImageResource(R.drawable.rp_backcardpic);
            e();
            return;
        }
        if (i10 == 13) {
            this.Y.setText(getString(R.string.identity_tw_front_title));
            this.Z.setText(getString(R.string.identity_tw_hint));
            this.ak.setImageResource(R.drawable.rp_frontcardpic);
            e();
            return;
        }
        if (i10 == 14) {
            this.Y.setText(getString(R.string.identity_tw_back_title));
            this.Z.setText(getString(R.string.identity_tw_hint));
            this.ak.setImageResource(R.drawable.rp_backcardpic);
            e();
            return;
        }
        if (i10 == -1) {
            this.ak.setVisibility(8);
            this.f2954ac.setVisibility(8);
            f();
        } else {
            Toast.makeText(getApplicationContext(), "没有该拍照类型，type=".concat(String.valueOf(i10)), 0).show();
            d.a().a("RPTakePhotoPage", "ViewExit", num, "error", null, null);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(TakePhotoTrackParams takePhotoTrackParams, TakePhotoResult takePhotoResult) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer("sdk");
        trackLog.setService("identity");
        trackLog.setMethod("takePhoto");
        trackLog.setParams(JsonUtils.toJSON(takePhotoTrackParams));
        trackLog.setMsg("");
        trackLog.setResult(takePhotoResult != null ? JsonUtils.toJSON(takePhotoResult) : "");
        j.a.f3944a.a(trackLog);
    }

    public static /* synthetic */ void i(RPTakePhotoActivity rPTakePhotoActivity) {
        rPTakePhotoActivity.J.setEnabled(false);
        SensorManager sensorManager = rPTakePhotoActivity.at;
        if (sensorManager != null) {
            sensorManager.unregisterListener(rPTakePhotoActivity);
        }
        if (rPTakePhotoActivity.as) {
            rPTakePhotoActivity.as = false;
            if (rPTakePhotoActivity.Q == 3) {
                rPTakePhotoActivity.N = false;
                rPTakePhotoActivity.f2953ab.setEnabled(false);
            }
            try {
                rPTakePhotoActivity.E.f3069a.takePicture(rPTakePhotoActivity.aq, null, rPTakePhotoActivity.f2957ar);
            } catch (Exception e2) {
                j.a.f3944a.a(TrackLog.createSdkExceptionLog("takePhoto camera exception", CommonUtils.getStackTrace(e2), ""));
                rPTakePhotoActivity.a(rPTakePhotoActivity.K);
                d.a().a("RPTakePhotoPage", "ViewExit", Integer.valueOf(rPTakePhotoActivity.Q).toString(), "error", "3", null);
                rPTakePhotoActivity.finish();
            }
        }
    }

    public static /* synthetic */ void j(RPTakePhotoActivity rPTakePhotoActivity) {
        String num = Integer.valueOf(rPTakePhotoActivity.Q).toString();
        d.a().a("RPTakePhotoPage", "ViewExit", num, "goPreview", null, null);
        d.a().a("RPPreviewPhotoPage", "ViewEnter", num, null, null, null);
        rPTakePhotoActivity.H.setVisibility(8);
        rPTakePhotoActivity.ah.setEnabled(true);
        rPTakePhotoActivity.af.setEnabled(true);
        rPTakePhotoActivity.N = true;
        rPTakePhotoActivity.O = false;
        ViewGroup viewGroup = rPTakePhotoActivity.f2956ae;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        ViewGroup viewGroup2 = rPTakePhotoActivity.f2955ad;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(8);
        }
        rPTakePhotoActivity.ag.setImageBitmap(BitmapFactory.decodeFile(rPTakePhotoActivity.V));
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        this.K.putExtra("errorMsg", aq.ai);
        d.a().a("RPTakePhotoPage", "ViewExit", Integer.valueOf(this.Q).toString(), "error", "1", null);
        if (i10 == -1) {
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", getPackageName(), null));
            startActivity(intent);
        }
        a(this.K);
        finish();
    }

    private void a(boolean z10) {
        if (z10 && this.ao) {
            this.al.setVisibility(0);
        } else {
            this.al.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent) {
        LocalBroadcastManagerUtils.getInstance(this).sendBroadcast(intent);
    }

    private static void a(ImageView imageView) {
        Bitmap bitmap;
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                bitmap.recycle();
            }
            imageView.setImageBitmap(null);
            if (drawable != null) {
                drawable.setCallback(null);
            }
        }
    }

    @Override // com.alibaba.security.realidentity.build.hf.a
    public final void a() {
        try {
            ak akVar = this.E;
            if (akVar != null) {
                akVar.a(this.aA);
            }
        } catch (Exception e2) {
            b("onFocus exception", CommonUtils.getStackTrace(e2));
        }
    }

    private static void a(String str, Exception exc) {
        j.a.f3944a.a(TrackLog.createSdkExceptionLog(str, CommonUtils.getStackTrace(exc), ""));
    }

    private void a(Message message) {
        int i10 = message.arg1;
        if (i10 != 100 && !this.M) {
            if (this.ap != null) {
                this.J.setEnabled(false);
                this.f2953ab.setEnabled(false);
                this.f2952aa.setText("示例图加载中，请稍等...");
                this.ap.sendEmptyMessageDelayed(3, 100L);
                return;
            }
            return;
        }
        if (this.M && i10 == 100) {
            return;
        }
        this.M = true;
        if (this.Q != 3) {
            return;
        }
        this.J.setEnabled(true);
        this.f2953ab.setEnabled(true);
        this.f2952aa.setText("换一张");
        int i11 = 0;
        while (true) {
            String[] strArr = this.U;
            if (i11 >= strArr.length) {
                return;
            }
            String str = this.X.get(strArr[i11]);
            if (!TextUtils.isEmpty(str)) {
                this.ak.setImageURI(Uri.fromFile(new File(str)));
                this.ak.setBackgroundColor(getResources().getColor(R.color.rpsdk_transparency_65));
                this.ak.setScaleType(ImageView.ScaleType.FIT_CENTER);
                this.f2953ab.setVisibility(0);
                this.T = i11;
                this.S = i11 + 1;
                return;
            }
            if (i11 == this.U.length - 1) {
                b(new TakePhotoTrackParams("exit", this.Q), new TakePhotoResult("imgDownloadFail"));
                d.a().a("RPTakePhotoPage", "ViewExit", Integer.valueOf(this.Q).toString(), "error", "2", null);
                Toast.makeText(this, getString(R.string.load_gesture_img_faild), 0).show();
                a(this.K);
                finish();
            }
            i11++;
        }
    }

    private static void a(TrackLog trackLog) {
        j.a.f3944a.a(trackLog);
    }

    public static /* synthetic */ Bitmap a(Bitmap bitmap) {
        if (Build.MODEL.toLowerCase(Locale.US).replace(" ", "").contains("nexus5x")) {
            return ImageUtils.rotateBitmap(bitmap, 270);
        }
        return ImageUtils.rotateBitmap(bitmap, 90);
    }

    public static /* synthetic */ void a(RPTakePhotoActivity rPTakePhotoActivity, Message message) {
        int i10 = message.arg1;
        if (i10 != 100 && !rPTakePhotoActivity.M) {
            if (rPTakePhotoActivity.ap != null) {
                rPTakePhotoActivity.J.setEnabled(false);
                rPTakePhotoActivity.f2953ab.setEnabled(false);
                rPTakePhotoActivity.f2952aa.setText("示例图加载中，请稍等...");
                rPTakePhotoActivity.ap.sendEmptyMessageDelayed(3, 100L);
                return;
            }
            return;
        }
        if (rPTakePhotoActivity.M && i10 == 100) {
            return;
        }
        rPTakePhotoActivity.M = true;
        if (rPTakePhotoActivity.Q != 3) {
            return;
        }
        rPTakePhotoActivity.J.setEnabled(true);
        rPTakePhotoActivity.f2953ab.setEnabled(true);
        rPTakePhotoActivity.f2952aa.setText("换一张");
        int i11 = 0;
        while (true) {
            String[] strArr = rPTakePhotoActivity.U;
            if (i11 >= strArr.length) {
                return;
            }
            String str = rPTakePhotoActivity.X.get(strArr[i11]);
            if (!TextUtils.isEmpty(str)) {
                rPTakePhotoActivity.ak.setImageURI(Uri.fromFile(new File(str)));
                rPTakePhotoActivity.ak.setBackgroundColor(rPTakePhotoActivity.getResources().getColor(R.color.rpsdk_transparency_65));
                rPTakePhotoActivity.ak.setScaleType(ImageView.ScaleType.FIT_CENTER);
                rPTakePhotoActivity.f2953ab.setVisibility(0);
                rPTakePhotoActivity.T = i11;
                rPTakePhotoActivity.S = i11 + 1;
                return;
            }
            if (i11 == rPTakePhotoActivity.U.length - 1) {
                b(new TakePhotoTrackParams("exit", rPTakePhotoActivity.Q), new TakePhotoResult("imgDownloadFail"));
                d.a().a("RPTakePhotoPage", "ViewExit", Integer.valueOf(rPTakePhotoActivity.Q).toString(), "error", "2", null);
                Toast.makeText(rPTakePhotoActivity, rPTakePhotoActivity.getString(R.string.load_gesture_img_faild), 0).show();
                rPTakePhotoActivity.a(rPTakePhotoActivity.K);
                rPTakePhotoActivity.finish();
            }
            i11++;
        }
    }
}
