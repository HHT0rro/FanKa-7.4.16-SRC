package com.danlan.android.cognition.sensor;

import androidx.annotation.Nullable;
import com.danlan.android.cognition.StringFog;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class Volunteer {
    private static String TAG = StringFog.decrypt("d0xIVk9XQURT");
    private static Volunteer instance = null;
    private final ArrayList<CognitionDataOpt> volunteers = new ArrayList<>(Arrays.asList(CognitionDataOpt.SENSOR_ACCELEROMETER));

    public static Volunteer getInstance() {
        if (instance == null) {
            instance = new Volunteer();
        }
        return instance;
    }

    public void add(CognitionDataOpt cognitionDataOpt) {
        if (this.volunteers.contains(cognitionDataOpt)) {
            return;
        }
        this.volunteers.add(cognitionDataOpt);
    }

    public boolean ready(@Nullable CognitionDataOpt cognitionDataOpt) {
        if (cognitionDataOpt != null) {
            return this.volunteers.contains(cognitionDataOpt);
        }
        return false;
    }

    public void remove(CognitionDataOpt cognitionDataOpt) {
        int indexOf = this.volunteers.indexOf(cognitionDataOpt);
        if (indexOf >= 0) {
            this.volunteers.remove(indexOf);
        }
    }
}
