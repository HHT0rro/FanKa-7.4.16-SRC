package com.android.internal.alsa;

import android.util.Slog;
import com.android.internal.os.PowerProfile;
import com.huawei.openalliance.ad.constant.u;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class AlsaDevicesParser {
    protected static final boolean DEBUG = false;
    public static final int SCANSTATUS_EMPTY = 2;
    public static final int SCANSTATUS_FAIL = 1;
    public static final int SCANSTATUS_NOTSCANNED = -1;
    public static final int SCANSTATUS_SUCCESS = 0;
    private static final String TAG = "AlsaDevicesParser";
    private static final String kDevicesFilePath = "/proc/asound/devices";
    private static final int kEndIndex_CardNum = 8;
    private static final int kEndIndex_DeviceNum = 11;
    private static final int kIndex_CardDeviceField = 5;
    private static final int kStartIndex_CardNum = 6;
    private static final int kStartIndex_DeviceNum = 9;
    private static final int kStartIndex_Type = 14;
    private static LineTokenizer mTokenizer = new LineTokenizer(" :[]-");
    private boolean mHasCaptureDevices = false;
    private boolean mHasPlaybackDevices = false;
    private boolean mHasMIDIDevices = false;
    private int mScanStatus = -1;
    private final ArrayList<AlsaDeviceRecord> mDeviceRecords = new ArrayList<>();

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class AlsaDeviceRecord {
        public static final int kDeviceDir_Capture = 0;
        public static final int kDeviceDir_Playback = 1;
        public static final int kDeviceDir_Unknown = -1;
        public static final int kDeviceType_Audio = 0;
        public static final int kDeviceType_Control = 1;
        public static final int kDeviceType_MIDI = 2;
        public static final int kDeviceType_Unknown = -1;
        int mCardNum = -1;
        int mDeviceNum = -1;
        int mDeviceType = -1;
        int mDeviceDir = -1;

        public AlsaDeviceRecord() {
        }

        public boolean parse(String line) {
            int delimOffset = 0;
            int tokenIndex = 0;
            while (true) {
                int tokenOffset = AlsaDevicesParser.mTokenizer.nextToken(line, delimOffset);
                if (tokenOffset == -1) {
                    return true;
                }
                delimOffset = AlsaDevicesParser.mTokenizer.nextDelimiter(line, tokenOffset);
                if (delimOffset == -1) {
                    delimOffset = line.length();
                }
                String token = line.substring(tokenOffset, delimOffset);
                switch (tokenIndex) {
                    case 1:
                        this.mCardNum = Integer.parseInt(token);
                        if (line.charAt(delimOffset) == '-') {
                            break;
                        } else {
                            tokenIndex++;
                            break;
                        }
                    case 2:
                        this.mDeviceNum = Integer.parseInt(token);
                        break;
                    case 3:
                        if (!token.equals("digital")) {
                            if (token.equals("control")) {
                                this.mDeviceType = 1;
                                break;
                            } else {
                                token.equals("raw");
                                break;
                            }
                        } else {
                            break;
                        }
                    case 4:
                        if (token.equals(PowerProfile.POWER_AUDIO)) {
                            this.mDeviceType = 0;
                            break;
                        } else if (!token.equals("midi")) {
                            break;
                        } else {
                            this.mDeviceType = 2;
                            AlsaDevicesParser.this.mHasMIDIDevices = true;
                            break;
                        }
                    case 5:
                        try {
                            if (token.equals("capture")) {
                                this.mDeviceDir = 0;
                                AlsaDevicesParser.this.mHasCaptureDevices = true;
                                break;
                            } else if (!token.equals("playback")) {
                                break;
                            } else {
                                this.mDeviceDir = 1;
                                AlsaDevicesParser.this.mHasPlaybackDevices = true;
                                break;
                            }
                        } catch (NumberFormatException e2) {
                            Slog.e(AlsaDevicesParser.TAG, "Failed to parse token " + tokenIndex + " of " + AlsaDevicesParser.kDevicesFilePath + " token: " + token);
                            return false;
                        }
                }
                tokenIndex++;
            }
        }

        public String textFormat() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[" + this.mCardNum + u.bD + this.mDeviceNum + "]");
            switch (this.mDeviceType) {
                case 0:
                    sb2.append(" Audio");
                    break;
                case 1:
                    sb2.append(" Control");
                    break;
                case 2:
                    sb2.append(" MIDI");
                    break;
                default:
                    sb2.append(" N/A");
                    break;
            }
            switch (this.mDeviceDir) {
                case 0:
                    sb2.append(" Capture");
                    break;
                case 1:
                    sb2.append(" Playback");
                    break;
                default:
                    sb2.append(" N/A");
                    break;
            }
            return sb2.toString();
        }
    }

    public int getDefaultDeviceNum(int card) {
        return 0;
    }

    public boolean hasPlaybackDevices(int card) {
        Iterator<AlsaDeviceRecord> iterator2 = this.mDeviceRecords.iterator2();
        while (iterator2.hasNext()) {
            AlsaDeviceRecord deviceRecord = iterator2.next();
            if (deviceRecord.mCardNum == card && deviceRecord.mDeviceType == 0 && deviceRecord.mDeviceDir == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCaptureDevices(int card) {
        Iterator<AlsaDeviceRecord> iterator2 = this.mDeviceRecords.iterator2();
        while (iterator2.hasNext()) {
            AlsaDeviceRecord deviceRecord = iterator2.next();
            if (deviceRecord.mCardNum == card && deviceRecord.mDeviceType == 0 && deviceRecord.mDeviceDir == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean hasMIDIDevices(int card) {
        Iterator<AlsaDeviceRecord> iterator2 = this.mDeviceRecords.iterator2();
        while (iterator2.hasNext()) {
            AlsaDeviceRecord deviceRecord = iterator2.next();
            if (deviceRecord.mCardNum == card && deviceRecord.mDeviceType == 2) {
                return true;
            }
        }
        return false;
    }

    private boolean isLineDeviceRecord(String line) {
        return line.charAt(5) == '[';
    }

    public int scan() {
        this.mDeviceRecords.clear();
        File devicesFile = new File(kDevicesFilePath);
        try {
            FileReader reader = new FileReader(devicesFile);
            BufferedReader bufferedReader = new BufferedReader(reader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                if (isLineDeviceRecord(line)) {
                    AlsaDeviceRecord deviceRecord = new AlsaDeviceRecord();
                    deviceRecord.parse(line);
                    Slog.i(TAG, deviceRecord.textFormat());
                    this.mDeviceRecords.add(deviceRecord);
                }
            }
            reader.close();
            if (this.mDeviceRecords.size() > 0) {
                this.mScanStatus = 0;
            } else {
                this.mScanStatus = 2;
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            this.mScanStatus = 1;
        } catch (IOException e10) {
            e10.printStackTrace();
            this.mScanStatus = 1;
        }
        return this.mScanStatus;
    }

    public int getScanStatus() {
        return this.mScanStatus;
    }

    private void Log(String heading) {
    }
}
