package com.example.quiz_app;

import android.content.*;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.*;

import java.util.ArrayList;

public class questions extends AppCompatActivity {

    ArrayList<String> options = new ArrayList<String>();
    ArrayList<String> a = new ArrayList<String>();
    ArrayList<String> q = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        q.add("Entomology is the science that studies?");
        a.add("Insects");
        q.add("Hitler party which came into power in 1933 is known as-");
        a.add("Nazi Party");
        q.add("First human heart transplant operation conducted by Dr. Christiaan Barnard on Louis Washkansky, was conducted in");
        a.add("1967");
        q.add("Exposure to sunlight helps a person improve his health because-");
        a.add("the ultraviolet rays convert skin oil into Vitamin D");
        q.add("Federation Cup, World Cup, Allywyn International Trophy and Challenge Cup are awarded to winners of?");
        a.add("Volleyball");
        q.add("During World War II, when did Germany attack France?");
        a.add("1940");
        q.add("The ozone layer restricts-");
        a.add("Ultraviolet radiation");
        q.add("Filaria is caused by-");
        a.add("Mosquito");
        q.add("Golden Temple, Amritsar is India's?");
        a.add("largest Gurdwara");
        q.add("For galvanizing iron which of the following metals is used?");
        a.add("Zinc");
        options.add("Labour Party");
        options.add("Nazi Party");
        options.add("Ku-Klux-Klan");
        options.add("Democratic Party");
        options.add("1967");
        options.add("1968");
        options.add("1958");
        options.add("1922");
        options.add("the infrared light kills bacteria in the body");
        options.add("resistance power increases");
        options.add("the pigment cells in the skin get stimulated and produce a healthy tan");
        options.add("the ultraviolet rays convert skin oil into Vitamin D");
        options.add("Tennis");
        options.add("Volleyball");
        options.add("Basketball");
        options.add("Cricket");
        options.add("1940");
        options.add("1941");
        options.add("1942");
        options.add("1943");
        options.add("Visible light");
        options.add("Infrared radiation");
        options.add("X-rays and gamma rays");
        options.add("Ultraviolet radiation");
        options.add("Bacteria");
        options.add("Mosquito");
        options.add("Protozoa");
        options.add("Virus");
        options.add("largest Gurdwara");
        options.add("oldest Gurudwara");
        options.add("Both option A and B are correct");
        options.add("None of the above");
        options.add("Aluminium");
        options.add("Copper");
        options.add("Lead");
        options.add("Zinc");
    }

    int i = 0;
    int correct = 0;
    int incorrect = 0;

    public void check(View view) {
        Button b = (Button) view;
        TextView tv = (TextView) findViewById(R.id.ques);
        Button b1 = (Button) findViewById(R.id.opt1);
        Button b2 = (Button) findViewById(R.id.opt2);
        Button b3 = (Button) findViewById(R.id.opt3);
        Button b4 = (Button) findViewById(R.id.opt4);
        String str1 = getIntent().getExtras().getString("email");
        String str[] = {str1};
        if (b.getText() == a.get(i)) {
            correct++;
            Context context = getApplicationContext();
            String text = "Correct Answer";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            incorrect++;
            Context context = getApplicationContext();
            String text = "Incorrect Answer";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        i++;
        if(i<10) {
            tv.setText(q.get(i));
            b1.setText(options.get((i - 1) * 4));
            b2.setText(options.get((i - 1) * 4 + 1));
            b3.setText(options.get((i - 1) * 4 + 2));
            b4.setText(options.get((i - 1) * 4 + 3));
        }

        if(i==10){
            /*Context context = getApplicationContext();
            String text = "Number Of Correct Answer " +correct+ "\nNumber Of Incorrect Answer " +incorrect;
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();*/
            String ans = "Number of Correct Answers:- " +correct+ "\n" + "Number of Incorrect Answers:- " +incorrect;
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_SUBJECT,"Result of quiz for username - " +getIntent().getExtras().getString("name"));
            intent.putExtra(Intent.EXTRA_TEXT,ans);
            intent.putExtra(Intent.EXTRA_EMAIL,str);

            if(intent.resolveActivity(getPackageManager())!= null){
                startActivity(intent);
            }
        }
    }


}

