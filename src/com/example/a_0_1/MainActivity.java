package com.example.a_0_1;

/**
 * Created by Kang on 7/26/2015.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


public class MainActivity extends Activity {
    public final static String QUESTION_LIST = "com.test.QUESTION";
    public final static String POSITION = "com.test.POSITION";
    ListView questionList;
    String[] question = {"Where are you from?","Who is your favorite athlete?","What do you like?",
            "Where are you from?","Who is your favorite athlete?","What do you like?",
            "Where are you from?","Who is your favorite athlete?","What do you like?"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //List Implementation
        questionList = (ListView)findViewById(R.id.question_list);
        //Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,question);
        //set adapter
        questionList.setAdapter(adapter);
        //set listener
        questionList.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,View view,int position,long id){
                String itemValue = (String)questionList.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),"Position :"+position+"  ListItem : " +itemValue , Toast.LENGTH_LONG).show();
                Intent openQuestion = new Intent(getApplicationContext(),QuestionDetailBox.class);
                openQuestion.putExtra(QUESTION_LIST, question);
                openQuestion.putExtra(POSITION, position);
                startActivity(openQuestion);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }


}
