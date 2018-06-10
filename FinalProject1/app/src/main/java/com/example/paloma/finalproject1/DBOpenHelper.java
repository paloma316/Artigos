package com.example.paloma.finalproject1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DBOpenHelper  extends SQLiteOpenHelper{

    public static final String database_name="Questions.db";
    public static final String table_name="table_questions";
    public static final String col1="Id";
    public static final String col2="Question";
    public static final String col3="op1";
    public static final String col4="op2";
    public static final String col5="op3";
    public static final String col6="op4";
    public static final String col7="subject";
    public static final String col8="answer_nr";
  public SQLiteDatabase db;

    public DBOpenHelper(Context context) {
        super(context, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        this.db=sqLiteDatabase;
       //  db=getWritableDatabase();
        final String SQL_Create_Table="create table "+table_name  + "  ( Id integer primary key autoincrement ,Question text," +
                " op1 text, op2 text,op3 text,op4 text ,subject text,answer_nr integer ) " ;
        db.execSQL(SQL_Create_Table);
        fillQuestion();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
db.execSQL( "drop table if exists "+table_name);
onCreate(db);
    }
    //public Question(String question, String op1, String op2, String op3, String op4, String subject, int answer_nr)
 public void   fillQuestion(){

        Question qL1= new Question(" what is the portuguese language code?","pt","pg","en","gp","language",1);
     Question qL2=new Question("how to say \"good-bye\" in portuguese?","ola","bem-vindo","meus","adeus","language",4);
     Question qL3=new Question("how many countries has portuguese as official language?","5","10","3","6","language",2);
     Question qL4=new Question("when  was adopted the portuguese  as the official language of Portugal","1290","1390","1490","1920","language",1);
     Question qL5=new Question("which language is similar to portuguese?","chinese","german","spanish","turkish","language",3);
     Question qG1=new Question("where is Portugal located?","northern europe","southwestern europe","northeastern","north europe","geograph",2);
     Question qG2= new Question("which country borders Portugal?","France","England","Spain","Germany","geograph",3);
     Question qG3= new Question("what is the percentage of population in Portugal?","around 10,379,573","around  11,379,573","around 12,379,573","around 13,379,573 ","geograph",1);
     Question qG4= new Question("what is the capital of portugal?","lisbon","porto","coimbra","faro","geograph",1);
     Question  qG5= new Question("what kind of climate does Portugal have?","tropical","desert","a Mediterranean climate ","sub-artic","geograph",3);
     Question qH1=new Question("In what year did Portugal host the world expo?","1990","1994","1999","1998","history",3);
     Question qH2=new Question("who was Camoes?","portuguese politician","portuguese poet","portuguese painter","portuguese famous","history",2);
     Question qH3=new Question("who discovered Brasil?","Pedro Alvares Cabral","Joao de  Santarem","Vasco da Gama","Crsitovao Colombo","history",1);
       Question  qH4 = new Question("who discovered the path to India?","Pero Escobar","Vasco da Gama","Pedro Alvares Cabral","Marcelo Rebelo de Sousa","history",2);
     Question qH5= new Question("When Sao tome and principe became an independent country?","1778","1889","1775","1774","history",3);

     addQuestion(qL1);
     addQuestion(qL2);
     addQuestion(qL3);
     addQuestion(qL4);
     addQuestion(qL5);

     addQuestion(qG1);
     addQuestion(qG2);
     addQuestion(qG3);
     addQuestion(qG4);
     addQuestion(qG5);

     addQuestion(qH1);
     addQuestion(qH2);
     addQuestion(qH3);
     addQuestion(qH4);
     addQuestion(qH5);




    }

    public boolean addQuestion(Question q){
        ContentValues cv= new ContentValues();

        cv.put(col2,q.getQuestion());
        cv.put(col3,q.getOp1());
        cv.put(col4,q.getOp2());
        cv.put(col5,q.getOp3());
        cv.put(col6,q.getOp4());
        cv.put(col7,q.getSubject());
        cv.put(col8,q.getAnswer_nr());

       // db.insert(table_name,null,cv);
        long result = db.insert(table_name,null ,cv);
        if(result == -1)
           return false;
        else
            return true;
    }


    public List<Question> getAllQuestion(String subject1){
     //   public List<Question> getAllQuestion(){
        List<Question> questionList=new ArrayList<>();
        db=getReadableDatabase();
        Cursor c=db.rawQuery("Select * from "+table_name + " where   subject =  '"+subject1+"' "     ,null);
       // Cursor c=db.rawQuery("Select * from  "+table_name ,null);
        if(c.moveToFirst()){
            do{
                Question q= new Question();
                q.setQuestion(c.getString(c.getColumnIndex(col2)));
                q.setOp1(c.getString(c.getColumnIndex(col3)));
                q.setOp2(c.getString(c.getColumnIndex(col4)));
                q.setOp3(c.getString(c.getColumnIndex(col5)));
                q.setOp4(c.getString(c.getColumnIndex(col6)));
                q.setSubject(c.getString(c.getColumnIndex(col7)));
                q.setAnswer_nr(c.getInt(c.getColumnIndex(col8)));



                questionList.add(q);

            }while(c.moveToNext());

        }
        c.close();
        return  questionList;
    }

    //achieve the data from database

   /* public List<Question> getAllQuestions(String subject){

    }*/

}
