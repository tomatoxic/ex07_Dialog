package com.example.ex07_dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // 1. 다이얼로그 만들기
                // 2. 다이얼로그 옵션 설정 (아이콘, 타이틀, "내용", 버튼(ok, 취소))
                final String[] versionArray = new String[]{"젤리빈", "킷캣", "롤리팝"};
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

//                dlg.setTitle("제목입니다");
//                dlg.setMessage("이곳이 내용입니다");

//                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(MainActivity.this,"확인을 눌렀네요",Toast.LENGTH_SHORT).show();
//                    }
//                });

                // 제목과 아이콘 설정
                dlg.setTitle("좋아하는 버전은?");
                dlg.setIcon(R.drawable.ic_launcher);

                // 배열의 아이템을 선택하면 버튼의 텍스트가 선택한 아이템으로 변경
//                dlg.setItems(versionArray, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(getApplicationContext(),versionArray[i] + " 클릭했음!",Toast.LENGTH_SHORT).show();
//                        button1.setText(versionArray[i]);
//                    }
//                });

                // 배열 아이템 선택을 라디오 버튼으로 변경
//                dlg.setSingleChoiceItems(versionArray, 0, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        button1.setText(versionArray[i]);
//                    }
//                });

                // 여러 개를 동시에 선택 후 버튼의 text를 선택한 모든 아이템으로 변경
                final boolean[] checkArray = new boolean[] {false,false,false};

                dlg.setMultiChoiceItems(versionArray, checkArray, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean b) {
                        String str1 = "";
                        int cnt = 0;

                        for (int i = 0; i < versionArray.length; i++) // 배열을 돌면서
                        {
                            // 체크가 되어있으면
                            if(checkArray[i])
                            {
                                cnt++;
                                if(cnt == 1) {
                                    // cnt가 1이면 쉼표 없이 아이템만 추가
                                    // str1 문자열에 체크된 배열의 아이템 추가
                                    str1 = str1 + versionArray[i];
                                } else {
                                    //cnt가 1이 아니면 쉼표 추가
                                    str1 = str1 + ", " + versionArray[i];
                                }
                            }
                        }
                        button1.setText(str1);
                    }
                });

                // 버튼 표기순서 때문에 negativeButton을 확인으로
                dlg.setNegativeButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"확인 누름!",Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setPositiveButton("취소", null);

                dlg.show();
            }
        });
    }
}