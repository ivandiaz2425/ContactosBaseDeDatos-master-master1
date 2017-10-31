package com.example.jonmid.contactosbasededatos.Views;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jonmid.contactosbasededatos.ContactsActivity;
import com.example.jonmid.contactosbasededatos.Helpers.SqliteHelper;
import com.example.jonmid.contactosbasededatos.R;

public class DeleteActivity extends AppCompatActivity {

    TextView Id;
    TextView name;
    TextView phone;
    TextView email;
    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        Id = (TextView) findViewById(R.id.id);
        name = (TextView) findViewById(R.id.name);
        phone = (TextView) findViewById(R.id.phone);
        email = (TextView) findViewById(R.id.email);

        sqliteHelper = new SqliteHelper(this, "db.users", null,1);

        Id.setText(Integer.toString(getIntent().getExtras().getInt("id")));
        name.setText(getIntent().getExtras().getString("name"));
        phone.setText(getIntent().getExtras().getString("phone"));
        email.setText(getIntent().getExtras().getString("email"));



    }


    public void Cancelar(View view){
        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);

    }


    public void Eliminar(View view){

        //Toast.makeText(this,"Mi id:  "+Id.getText(),Toast.LENGTH_SHORT).show();

        SQLiteDatabase db = sqliteHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("Delete from users where id=",null);

        cursor.close();
        Toast.makeText(this,"Contacto Eliminado",Toast.LENGTH_SHORT).show();

        Cancelar(view);

    }


}
