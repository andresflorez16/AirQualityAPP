package com.duvanjahir.airmonitoring;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.UUID;

public class RegisterActivity extends AppCompatActivity {
    private AutoCompleteTextView Typeuser;
    private EditText nameText,passwordText,passwordVerifyText,emailText,phoneText;
    FirebaseFirestore db;
    DatabaseReference database;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        database = FirebaseDatabase.getInstance().getReference();

        nameText=(EditText) findViewById(R.id.registro_nombre);
        passwordText=(EditText) findViewById(R.id.registro_password);
        passwordVerifyText=(EditText) findViewById(R.id.registro_confirmacionpassword);
        emailText=(EditText) findViewById(R.id.registro_email);
        phoneText=(EditText) findViewById(R.id.registro_telefono);
        initialize();
    }
    public  void  initialize(){
        FirebaseApp.initializeApp(this);
        db=FirebaseFirestore.getInstance();
    }
    public void Registrar(View view){

        String name = nameText.getText().toString();
        String password = passwordText.getText().toString();
        String passwordV = passwordVerifyText.getText().toString();
        String email = emailText.getText().toString();
        String phone = phoneText.getText().toString();
        //System.out.println(NomApe + " " + Con + " " + Confcon + " " + email + " " + Tele);

        if(name.equals("")||password.equals("")||passwordV.equals("")||email.equals("")||phone.equals("")){
            Toast.makeText(this, "Verifique los campos vacios", Toast.LENGTH_SHORT).show();
        }else{
            if(password.equals(passwordV)) {
                User user= new User(name,email,phone,password,"cliente");
                insertUser(view,user);
            }else{
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public  void  insertUser(View view, User myUser){
        HashMap<String,Object>user= new HashMap<>();
        user.put("name",myUser.getName());
        user.put("email",myUser.getEmail());
        user.put("password",myUser.getPassword());
        user.put("phone",myUser.getPhone());
        user.put("type",myUser.getType());
        UUID id = UUID.randomUUID();
        user.put("id", id.toString());

        DocumentReference docRef = db.collection("users").document(myUser.getEmail());

        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    DocumentSnapshot document= task.getResult();
                    if(document.exists()){
                        Toast.makeText(getApplicationContext(), "El email ya se encuentra registrado", Toast.LENGTH_SHORT).show();
                        clean();
                    }else{
                        db.collection("users").document(myUser.getEmail()).set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(getApplicationContext(), "Usuario registrado con éxito", Toast.LENGTH_SHORT).show();
                                clean();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(), "Ocurrió un error", Toast.LENGTH_SHORT).show();
                                clean();
                            }
                        });
                    }
                }
            }
        });
    }

    public void clean() {
        nameText.setText("");
        passwordText.setText("");
        passwordVerifyText.setText("");
        emailText.setText("");
        phoneText.setText("");
    }

}




