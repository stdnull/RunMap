package com.stdnull.runmap.ui.activity;

import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import android.widget.TextView;

import com.skyinu.annotations.BindView;
import com.skyinu.annotations.OnTextChanged;
import com.skyinu.gradlebutterknife.GradleButterKnife;
import com.stdnull.baselib.BaseActivity;
import com.stdnull.runmap.R;


/**
 * 距离转卡路里页面
 * Created by chen on 2017/2/14.
 */

public class CalorieActivity extends BaseActivity {
    @BindView(R.id.edit_weight)
    protected EditText mEditWeight;
    @BindView(R.id.edit_distance)
    protected EditText mEditDistance;
    @BindView(R.id.text_calorie)
    protected TextView mTvCalorie;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie);
        GradleButterKnife.bind(this);
    }

    @OnTextChanged(value = {R.id.edit_weight, R.id.edit_distance},
        callback = OnTextChanged.AFTER_TEXT_CHANGED)
    public void afterTextChanged(Editable text) {
        String distance = mEditDistance.getText().toString();
        String weight = mEditWeight.getText().toString();
        try{
            float dis = Float.valueOf(distance);
            float wei = Float.valueOf(weight);
            float res = dis * wei * 1.036F;
            mTvCalorie.setText(res + "");
        }catch (Exception e){

        }
    }
}
