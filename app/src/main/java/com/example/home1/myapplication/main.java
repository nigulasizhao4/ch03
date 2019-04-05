package com.example.home1.myapplication;

/**
 * Created by home1 on 2019/3/28.
 */
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class main extends AppCompatActivity{
    private EditText et_username,et_password;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alertdialog);
    }
    public void login(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("登录");
        //通过布局填充器获login_layout
        View view = getLayoutInflater().inflate(R.layout.login_layout,null);
        //获取两个文本编辑框（密码这里不做登陆实现，仅演示）
        final EditText et_username = (EditText) view.findViewById(R.id.et_username);
        final EditText et_password = (EditText) view.findViewById(R.id.et_password);
        builder.setView(view);//设置login_layout为对话提示框
        builder.setCancelable(false);//设置为不可取消
        //设置正面按钮，并做事件处理
        builder.setPositiveButton("Sing in", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String name = et_username.getText().toString().trim();
                String pass = et_password.getText().toString().trim();
                Toast.makeText(main.this,name + "正在登录....",Toast.LENGTH_SHORT).show();
            }
        });
        //设置反面按钮，并做事件处理
        builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(main.this,"取消登录",Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();//显示Dialog对话框
    }

}
