package com.example.rock_paper_scissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //グーボタン押下時
    public void onClickRock(View view){
        game(0);
    }

    //チョキボタン押下時
    public void onClickScissors(View view){
        game(1);
    }

    //パーボタン押下時
    public void onClickPaper(View view){
        game(2);
    }

    //じゃんけんメソッド
    private void game(int playerHand){
        //
        String[] handTexts = {"✊", "✌️", "✋"};

        //ランダムクラスのインスタンスを生成
        Random r = new Random();
        //コンピュータの手をランダムに決定
        int cupHand = r.nextInt(3);

        String judge = null;

        //勝敗の判定
        if (playerHand == cupHand) {
            judge = "あいこ";
        }else if (playerHand == 0 && cupHand == 2) {
            // 「グー」対「パー」
            judge = "あなたの負け...";
        } else if (playerHand == 0 && cupHand == 1) {
            // 「グー」対「チョキ」
            judge = "あなたの勝ち！！";
        } else if (playerHand == 1 && cupHand == 0) {
            // 「チョキ」対「グー」
            judge = "あなたの負け...";
        } else if (playerHand == 1 && cupHand == 2) {
            // 「チョキ」対「パー」
            judge = "あなたの勝ち！！";
        } else if (playerHand == 2 && cupHand == 0) {
            // 「パー」対「グー」
            judge = "あなたの勝ち！！";
        } else if (playerHand == 2 && cupHand == 1) {
            // 「パー」対「チョキ」
            judge = "あなたの負け...";
        }

        TextView textViewCpu = (TextView) findViewById(R.id.cpu);
        textViewCpu.setText(handTexts[cupHand]);

        TextView textViewJudge = (TextView)findViewById(R.id.judge);
        textViewJudge.setText(judge);
    }
}