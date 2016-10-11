package au.com.owenwalsh.capabilityconnect.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by owenw on 11/10/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    //Database name and version
    private static final String DATABASE_NAME = "StudentsDB";
    private static final int DATABASE_VERSION = 1;

    //Students Table and columns names
    public final static String STUDENTS_TABLE = "Students";
    public final static String ZID = "zID";
    public final static String FIRST_NAME = "FirstName";
    public final static String LAST_NAME = "LastName";
    public final static String EMAIL = "Email";
    public final static String WEAKNESS = "Weakness";
    public final static String STRENGTH = "Strength";

    //Tutorials table and columns names
    public final static String TUTORIALS = "Tutorials";
    public final static String TUTORIAL_ID = "TutorialId";
    public final static String DAY = "Day";
    public final static String TIME = "Time";

    //Weeks table and columns names
    public final static String WEEKS = "Weeks";
    public final static String WEEK_ID = "WeekId";
    public final static String NAME = "Name";
    public final static String WEEK_COMMENT = "WeekComment";
    public final static String TO_DO_NEXT_WEEK = "ToDoNextWeek";

    //CLASS_WEEK_STUDENT table and columns names
    public final static String CLASS_WEEK_STUDENT = "Class_Week_Student";
    public final static String STUDENT_ID = "StudentId";
    public final static String WEEK_NAME = "WeekName";
    public final static String TUTORIAL_NAME = "TutorialName";
    public final static String ATTEND = "Attend";

    //Assessments table and columns names
    public final static String ASSESSMENTS = "Assessments";
    public final static String ASSESSMENT_ID = "AssessmentId";
    public final static String ASSESSMENT_NAME = "AssessmentName";
    public final static String DUE_DAY = "DueDay";
    public final static String DUE_MONTH = "DueMonth";
    public final static String DUE_Year = "DueYear";

    //Assessments_Students table and columns names
    public final static String STUDENTS_ASSESSMENTS = "Students_Assessments";
    public final static String ASSESSMENTS_STUDENT_ID = "AssessmentStudentId";
    public final static String STUDENT_MARK = "StudentMark";
    public final static String ASSESSMENT_COMMENT = "AssessmentComment";

    //COMPETENCIES table and columns names
    public final static String COMPETENCIES = "Competencies";
    public final static String COMPETENCY_ID = "CompetencyId";
    public final static String COMPETENCY_NAME = "CompetencyName";
    public final static String DESCRIPTION = "Description";

    //Students_Competencies table and columns names
    public final static String STUDENTS_COMPETENCIES = "Students_Competencies";
    public final static String COMPETENCY_STUDENT_ID = "CompetencyStudentId";
    public final static String RATING = "Rating";


    //Creating the Students table
    private static final String CREATE_STUDENTS_TABLE = "CREATE TABLE "
            + STUDENTS_TABLE + " (" + ZID + " TEXT PRIMARY KEY, "
            + FIRST_NAME + " TEXT NOT NULL, "
            + LAST_NAME + " TEXT NOT NULL, "
            + FIRST_NAME + " TEXT NOT NULL, "
            + EMAIL + " TEXT NOT NULL, "
            + WEAKNESS + " TEXT, "
            + STRENGTH + " TEXT )";

    //Creating the Tutorials table
    private static final String CREATE_TUTORIALS_TABLE = "CREATE TABLE "
            + TUTORIALS + " (" + TUTORIAL_ID + " INTEGER PRIMARY KEY, "
            + DAY + " TEXT NOT NULL, "
            + TIME + " REAL NOT NULL, )";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //creating the database
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_STUDENTS_TABLE);
        database.execSQL(CREATE_TUTORIALS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + POKEMON_TABLE);
        onCreate(sqLiteDatabase);
    }

    //inserting a pokemon to the database table
    public boolean insterPokemon(int id, String name, byte[] sprite) {
        boolean inserted = false;
        /*SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(POKEMON_ID, id);
        contentValues.put(POKEMON_NAME, name);
        contentValues.put(POKEMON_SPRITE, sprite);
        long result = db.insert(POKEMON_TABLE, null, contentValues);
        if (result == -1) {
            inserted = false;
        } else {
            inserted = true;
        }*/
        return inserted;
    }

    //reading all the pokemons from the database
    public Cursor getAllPokemons() {
        SQLiteDatabase db = this.getWritableDatabase();
        //Cursor result = db.rawQuery("select * from " + POKEMON_TABLE, null);
        return null;
    }

    //delete all the pokemon from the database
    public void deleteAllPokemons() {
        SQLiteDatabase db = this.getWritableDatabase();
        //db.execSQL("delete from " + POKEMON_TABLE);
    }
}
