package com.hongling.schooltimetable;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * 结果回调接口
 */
public class CourseModel implements ICourseBiz {

    private SharedPreferences mSharedPreferences;
    public static SharedPreferences.Editor mEditor;
    private int courseNum;
    private Button[] mButton;

    public static String course;
    public static int courseBtnId;
    private Button feedBackBtn;
    public RelativeLayout layout;
    private Dialog mDialog;


    private Button yuwen;
    private Button shuxue;
    private Button yingyu;
    private Button wuli;
    private Button huaxue;
    private Button shengwu;
    private Button zhengzhi;
    private Button dili;
    private Button lishi;
    private Button xinxi;
    private Button tiyu;
    private Button kexue;
    private Button ziran;
    private Button meishu;
    private Button shougong;
    private Button laodong;
    private Button weiji;
    private Button zixi;
    private Button kongbai;
    private Button zidingyi;
    private Button courseSubmit;

    @Override
    public void initView(final Activity activity) {
//        获取屏幕大小
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        LogUtil.i("DisplayMetrics", width + " " + height);

        SharedPreferences sharedPreferences = activity.getSharedPreferences("TimeTable", 0);
        mSharedPreferences = sharedPreferences;
        mEditor = mSharedPreferences.edit();

        //自定义layout组件
        layout = new RelativeLayout(activity);
        mButton = new Button[35];
        //这里创建35个按钮，每行放置5个按钮
        final Button Btn[] = new Button[35];
        int j = -1;
        for (int i = 0; i <= 34; i++) {
            Btn[i] = new Button(activity);
            Btn[i].setId(2000 + i);
            mButton[i] = Btn[i];
            int num = i + 1;
            //读取数据
            String course = sharedPreferences.getString(String.valueOf(Btn[i].getId()), " ");
            Btn[i].setText(course);
            RelativeLayout.LayoutParams btParams = new RelativeLayout.LayoutParams((width - 450* width / 1920) / 5, 80 * height / 1080); //设置按钮的宽度和高度
            if (i % 5 == 0) {
                j++;
            }
            btParams.leftMargin = 350* width / 1920 + ((width - 450 * width / 1920) / 5 + 10) * (i % 5); //横坐标定位
            btParams.topMargin = 400* height / 1080 + 80 * height / 1080 * j; //纵坐标定位



//            //读取数据
//            String course = sharedPreferences.getString(String.valueOf(Btn[i].getId()), " ");
//            Btn[i].setText(course);
//            RelativeLayout.LayoutParams btParams = new RelativeLayout.LayoutParams((width - 450) / 5 * width / 1920, 80 * height / 1080); //设置按钮的宽度和高度
//            if (i % 5 == 0) {
//                j++;
//            }
//            btParams.leftMargin = 350 + ((width - 450) / 5 * width / 1920 + 10) * (i % 5); //横坐标定位
//            btParams.topMargin = 300 + 80 * height / 1080 * j; //纵坐标定位
//            btParams.leftMargin = width / 3 + ((width - 450) / 5 * width / 1920 + 10) * (i % 5); //横坐标定位
//            btParams.topMargin = height * 4 / 10 + 80 * height / 1080 * j; //纵坐标定位
            layout.addView(Btn[i], btParams); //将按钮放入layout组件
        }

        //课程表title
        final TextView textView = new TextView(activity);
        RelativeLayout.LayoutParams textViewParams = new RelativeLayout.LayoutParams(200, 150);
        textView.setText("课程表");
        textView.setTextSize(25);
        textViewParams.leftMargin = width / 2 - textView.getWidth() / 2;
        textViewParams.topMargin = 100;
        layout.addView(textView, textViewParams);
//        this.setContentView(layout);
        activity.setContentView(layout);

        //批量设置监听
        for (int k = 0; k <= Btn.length - 1; k++) {
            Btn[k].setTag(k); //为按钮设置一个标记，来确认是按下了哪一个按钮
            final int finalK = k;
            Btn[k].setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int i = (Integer) v.getTag();
                    courseNum = i + 1;
                    LogUtil.i("按键", Integer.toString(courseNum));
//                    showPopupMenu(v, courseNum);
                    courseBtnId = v.getId();
                    feedBackBtn = Btn[finalK];
                    course = null;
                    showDialog(activity);
                }
            });
        }
    }


    public void showDialog(final Activity activity) {
        //获得布局对象
        final View view = LayoutInflater.from(activity).inflate(R.layout.course_select, null);
        //设置参数等
        view.setLayoutParams(new LinearLayout.LayoutParams(1920, 1080));
        final Dialog dialog = new Dialog(activity);
        mDialog = dialog;
//        //设置是否能点击取消
        dialog.setCancelable(true);
//        //把视图加载如对话框
        dialog.setContentView(view);
        dialog.show();
        dialog.getWindow().setLayout((ScreenUtils.getScreenWidth(activity) / 4 * 3), ScreenUtils.getScreenHeight(activity) / 4 * 3);

        yuwen = (Button) view.findViewById(R.id.yuwen);
        shuxue = (Button) view.findViewById(R.id.shuxue);
        yingyu = (Button) view.findViewById(R.id.yingyu);
        wuli = (Button) view.findViewById(R.id.wuli);
        huaxue = (Button) view.findViewById(R.id.huaxue);

        shengwu = (Button) view.findViewById(R.id.shengwu);
        zhengzhi = (Button) view.findViewById(R.id.zhengzhi);
        dili = (Button) view.findViewById(R.id.dili);
        lishi = (Button) view.findViewById(R.id.lishi);
        xinxi = (Button) view.findViewById(R.id.xinxi);

        tiyu = (Button) view.findViewById(R.id.tiyu);
        kexue = (Button) view.findViewById(R.id.kexue);
        ziran = (Button) view.findViewById(R.id.ziran);
        meishu = (Button) view.findViewById(R.id.meishu);
        shougong = (Button) view.findViewById(R.id.shougong);

        laodong = (Button) view.findViewById(R.id.laodong);
        weiji = (Button) view.findViewById(R.id.weiji);
        zixi = (Button) view.findViewById(R.id.zixi);
        kongbai = (Button) view.findViewById(R.id.kongbai);
        zidingyi = (Button) view.findViewById(R.id.zidingyi);

        courseSubmit = view.findViewById(R.id.courseSubmit);

        BtnClickListener btnClickListener = new BtnClickListener();

        yuwen.setOnClickListener(btnClickListener);
        shuxue.setOnClickListener(btnClickListener);
        yingyu.setOnClickListener(btnClickListener);
        wuli.setOnClickListener(btnClickListener);
        huaxue.setOnClickListener(btnClickListener);

        shengwu.setOnClickListener(btnClickListener);
        zhengzhi.setOnClickListener(btnClickListener);
        dili.setOnClickListener(btnClickListener);
        lishi.setOnClickListener(btnClickListener);
        xinxi.setOnClickListener(btnClickListener);

        tiyu.setOnClickListener(btnClickListener);
        kexue.setOnClickListener(btnClickListener);
        ziran.setOnClickListener(btnClickListener);
        meishu.setOnClickListener(btnClickListener);
        shougong.setOnClickListener(btnClickListener);

        laodong.setOnClickListener(btnClickListener);
        weiji.setOnClickListener(btnClickListener);
        zixi.setOnClickListener(btnClickListener);

        kongbai.setOnClickListener(btnClickListener);
        zidingyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText inputServer = new EditText(activity);
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("自定义课程名称").setView(inputServer)
                        .setNegativeButton("取消", null);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        course = inputServer.getText().toString();
                        mDialog.dismiss();
                        CourseModel.mEditor.putString(String.valueOf(courseBtnId), course);
                        CourseModel.mEditor.commit();

                        feedBackBtn.setText(course);
                    }
                });
                builder.show();
            }
        });

        courseSubmit.setOnClickListener(new View.OnClickListener() {

            Button button;

            @Override
            public void onClick(View v) {

                button = layout.findViewById(courseBtnId);

                if (course != null || courseBtnId == 0) {
                    //存入到SharedPreferences
                    CourseModel.mEditor.putString(String.valueOf(courseBtnId), course);
                    CourseModel.mEditor.commit();

                    feedBackBtn.setText(course);
                    course = null;
                    courseBtnId = 0;
                }
                dialog.dismiss();

            }
        });
    }


    @Override
    public void initData(Activity activity) {

    }

}

class BtnClickListener implements View.OnClickListener {
    private Button button;
    private Button preButton = null;
    //    private String course;
    private int courseBtnId;

    @Override
    public void onClick(View v) {

        button = v.findViewById(v.getId());
        button.setBackgroundResource(R.drawable.button_shape_press);

        if (preButton != null && preButton != button) {
            preButton.setBackgroundResource(R.drawable.button_shape);
        }
        if (v.getId() == R.id.kongbai) {
            CourseModel.course = " ";
        } else {
            CourseModel.course = button.getText().toString();
        }
        LogUtil.i("BtnClickListener", CourseModel.course);

        preButton = button;
    }
}

