package sqlite.edu.uabc.com.smstest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;

public class SMSReceiver extends BroadcastReceiver {

    public SMSReceiver() {

    }

    @Override
    public void onReceive(Context context, Intent intent) {
            String smsBody=null;
        if(Telephony.Sms.Intents.getMessagesFromIntent(intent)!=null){

           if( Telephony.Sms.Intents.getMessagesFromIntent(intent).length>0){
               int lenght=Telephony.Sms.Intents.getMessagesFromIntent(intent).length;
               smsBody=Telephony.Sms.Intents.getMessagesFromIntent(intent).clone()[lenght-1].getMessageBody();
           }
        }
            SMSObservable.getInstance().setValue(smsBody);
//        if (intent.getAction().equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)) {
//            String smsSender = "";
//            String smsBody = "";
//            for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
//                smsBody += smsMessage.getMessageBody();
//            }
//
//            Log.d("SMS", "SMS detected: From " + smsSender + " With text " + smsBody);
//            Toast.makeText(context, "BroadcastReceiver caught conditional SMS: " + smsBody, Toast.LENGTH_LONG).show();
//        }

//        String smsSender = "";
//        String smsBody = "";
//        for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
//            smsBody += smsMessage.getMessageBody();
//        }
//
//        Toast.makeText(context, "BroadcastReceiver caught conditional SMS: " + smsBody, Toast.LENGTH_LONG).show();

    }


}