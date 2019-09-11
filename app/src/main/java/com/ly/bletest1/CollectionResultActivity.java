package com.ly.bletest1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @创建者 ly
 * @创建时间 2019/9/6
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */
public class CollectionResultActivity extends Activity {

    @BindView(R.id.tv_result)
    TextView tvResult;
    @BindView(R.id.btn_start)
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btn_start)
    public void onViewClicked() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
