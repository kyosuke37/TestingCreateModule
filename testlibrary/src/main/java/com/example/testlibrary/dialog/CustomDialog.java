package com.example.testlibrary.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.testlibrary.R;

public class CustomDialog extends Dialog {

     String header, message;
     int layoutId;
     Button dialogButton;
     Activity activity;
     TextView headerText, detailText;
     CustomDialogButtonInterface customDialogButtonInterface;
     CustomDialogButtonNextInterface customDialogButtonNextInterface;
     CustomDialogButtonPrevInterface customDialogButtonPrevInterface;

     public CustomDialog(@NonNull Activity activity) {
        super(activity);
        this.activity = activity;
        initialize();
     }

    public CustomDialog(@NonNull Activity activity, String message) {
        super(activity);
        this.activity = activity;
        this.message = message;
        initialize();

    }

    public CustomDialog(@NonNull Activity activity, String header, String message) {
        super(activity);
        this.activity = activity;
        this.header = header;
        this.message = message;
        initialize();

    }

    public CustomDialog(@NonNull Activity activity, int layoutId) {
        super(activity);
        this.activity = activity;
        this.layoutId = layoutId;
        initialize();

    }

    private void initialize(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            this.create();
        }
        this.setCancelable(false);
        if(layoutId == 0){
            this.setContentView(R.layout.custom_dialog_message);
        }else{
            this.setContentView(layoutId);
        }
        
        this.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogButton = (Button) this.findViewById(R.id.ok);

        dialogButton.setOnClickListener(view -> {
           this.dismiss();
            processAfterClickButton();
        });

        showMessageHeaderAndDetail();
    }

    private void showMessageHeaderAndDetail(){
         headerText = this.findViewById(R.id.header_common_dialog_text);
         detailText = this.findViewById(R.id.detail_common_dialog_text);
         if(this.header != null) headerText.setText(this.header);
         if(this.message != null) detailText.setText(this.message);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCustomDialogButtonInterface(CustomDialogButtonInterface customDialogInterface) {
        this.customDialogButtonInterface = customDialogInterface;
    }

    private void processAfterClickButton(){
         if(this.customDialogButtonInterface != null)
             customDialogButtonInterface.afterOkClicked();
    }
}
