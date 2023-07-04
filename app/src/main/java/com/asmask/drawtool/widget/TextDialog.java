package com.asmask.drawtool.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.asmask.drawtool.R;


/**
 * 文字dialog
 */
public class TextDialog extends Dialog {
    private OnClickTextListener onClickTextListener;
    private EditText editText;
    private RadioGroup radioGroup;
    private Button btOk;

    // 构造函数
    public TextDialog(Context context, int theme) {
        super(context, theme);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.dialog_text);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        initView();
    }

    /**
     * 初始化
     */
    private void initView() {
        //设置位置
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        getWindow().setGravity(Gravity.CENTER);
        Window win = getWindow();
        win.getDecorView().setPadding(0, 0, 0, 0);
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        win.setAttributes(lp);

        editText = (EditText) findViewById(R.id.et_content);
        btOk = (Button) findViewById(R.id.btn_ok);
        radioGroup = (RadioGroup) findViewById(R.id.rg);
        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(editText.getText().toString())) {
                    if (onClickTextListener != null) {
                        onClickTextListener.conClickContent(editText.getText().toString(), radioGroup.getCheckedRadioButtonId() == R.id.rb_v);
                        editText.setText("");
                    }
                    dismiss();
                } else {
                    Toast.makeText(getContext(), "文字不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void setOnClickTextListener(OnClickTextListener onClickTextListener) {
        this.onClickTextListener = onClickTextListener;
    }

    public interface OnClickTextListener {
        void conClickContent(String content, boolean isVertical);
    }
}

