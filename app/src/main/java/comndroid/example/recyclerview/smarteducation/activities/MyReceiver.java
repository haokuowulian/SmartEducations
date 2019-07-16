package comndroid.example.recyclerview.smarteducation.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver
{
    private static final String TAG = "JPush";
    private Intent i;

    private static String printBundle(Bundle paramBundle)
    {
        return null;
    }

    private void processCustomMessage(Context paramContext, Bundle paramBundle)
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
        Bundle localBundle = paramIntent.getExtras();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[MyReceiver] onReceive - ");
        localStringBuilder.append(paramIntent.getAction());
        localStringBuilder.append(", extras: ");
        localStringBuilder.append(printBundle(localBundle));
        Log.d("JPush", localStringBuilder.toString());
        if ("cn.jpush.android.intent.REGISTRATION".equals(paramIntent.getAction()))
        {
            Log.d("JPush", paramIntent.toString());
            return;
        }
        if ("cn.jpush.android.intent.MESSAGE_RECEIVED".equals(paramIntent.getAction()))
        {

            Log.d("JPush", paramIntent.toString());
            processCustomMessage(paramContext, localBundle);
            return;
        }
        int j;
        if ("cn.jpush.android.intent.NOTIFICATION_RECEIVED".equals(paramIntent.getAction()))
        {
            Log.d("JPush", "[MyReceiver] 接收到推送下来的通知");
            j = localBundle.getInt("cn.jpush.android.NOTIFICATION_ID");

            Log.d("JPush", paramContext.toString());
            return;
        }
        if ("cn.jpush.android.intent.NOTIFICATION_OPENED".equals(paramIntent.getAction()))
        {
            Log.d("JPush", "[MyReceiver] 用户点击打开了通知");

            Log.d("JPush", paramIntent.toString());

            Log.d("JPush", paramIntent.toString());
            String s1= localBundle.getString("cn.jpush.android.ALERT");
            if(s1.contains("报修已处理")){
                Intent intent=new Intent(paramContext,WupinbaoxiuActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
                paramContext.startActivity(intent);
            }
            if(s1.contains("新的待办")){
                Intent intent=new Intent(paramContext,QjclActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
                paramContext.startActivity(intent);
            }
            if(s1.contains("请假已处理")){
                Intent intent=new Intent(paramContext,MyapproveListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
                paramContext.startActivity(intent);
            }
            if(s1.contains("新的文件")){
                Intent intent=new Intent(paramContext,GwjsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
                paramContext.startActivity(intent);
            }
            if(s1.contains("新的报警")){
                Intent intent=new Intent(paramContext,BaojingListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
                paramContext.startActivity(intent);

            }
            if(s1.contains("有新的报修信息")){
                Intent intent=new Intent(paramContext,BaoxiuActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
                paramContext.startActivity(intent);

            }

            return;
        }
        if ("cn.jpush.android.intent.ACTION_RICHPUSH_CALLBACK".equals(paramIntent.getAction()))
        {

            Log.d("JPush", paramContext.toString());
            return;
        }
        if ("cn.jpush.android.intent.CONNECTION".equals(paramIntent.getAction()))
        {

            Log.w("JPush", paramContext.toString());
            return;
        }

        Log.d("JPush", paramContext.toString());
    }
}
