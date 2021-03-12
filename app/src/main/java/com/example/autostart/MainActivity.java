package com.example.autostart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customSetComponent("xiaomi", "com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity");
        navigateAutoStartSetting();
    }

    private void customSetComponent(String manufacturer, String pkg, String cls){
        String systemManufacturer = android.os.Build.MANUFACTURER;
        try {
            Intent intent = new Intent();
            if (manufacturer.equalsIgnoreCase(systemManufacturer)) {
                intent.setComponent(new ComponentName(pkg, cls));
            }
        }catch (Exception e){
          System.out.print("Can't Navigate");
        }
    }

    private void navigateAutoStartSetting() {
        String manufacturer = android.os.Build.MANUFACTURER;
        try {
            Intent intent = new Intent();
            if ("xiaomi".equalsIgnoreCase(manufacturer)) {
                intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
            } else if ("oppo".equalsIgnoreCase(manufacturer)) {
                intent.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity"));
            } else if ("vivo".equalsIgnoreCase(manufacturer)) {
                intent.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity"));
            } else if ("Letv".equalsIgnoreCase(manufacturer)) {
                intent.setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity"));
            } else if ("Honor".equalsIgnoreCase(manufacturer)) {
                intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity"));
            }else{
                return;
            }
            startActivity(intent);
        }catch (Exception e){
            System.out.print("Can't Navigate");
        }
    }
}

