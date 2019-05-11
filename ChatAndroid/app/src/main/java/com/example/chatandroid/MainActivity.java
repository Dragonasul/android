package com.example.chatandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMensajes;
    private EditText etName;
    private EditText etMensaje;
    private ImageButton ibEnviar;

    private List<MensajeVO> lstMensajes;
    private AdapterRVMensajes mAdapterRVMensajes;

    private void setComponentes(){
        rvMensajes = findViewById(R.id.rvMensajes);
        etName = findViewById(R.id.etName);
        etMensaje = findViewById(R.id.etMensaje);
        ibEnviar = findViewById(R.id.ibEnviar);

        lstMensajes = new ArrayList<>();
        mAdapterRVMensajes = new AdapterRVMensajes(lstMensajes);
        rvMensajes.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvMensajes.setAdapter(mAdapterRVMensajes);
        rvMensajes.setHasFixedSize(true);

        // Agregamos un listener que va a estar constantemente en tiempo real si se agrega un nuevo valor en nuestra base de datos
        FirebaseFirestore.getInstance().collection("Chat").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                for (DocumentChange mDocumentChange: queryDocumentSnapshots.getDocumentChanges()){
                    //Filtramos mensajes para mostrar solamente los nuevos mensajes agregados
                    if(mDocumentChange.getType() == DocumentChange.Type.ADDED){
                        lstMensajes.add(mDocumentChange.getDocument().toObject(MensajeVO.class));
                        //Indicamos al adaptador que se actualice
                        mAdapterRVMensajes.notifyDataSetChanged();
                        //Hacemos que la lista se mueva al ultimo mensaje recibido
                        rvMensajes.smoothScrollToPosition(lstMensajes.size());
                    }
                }
            }
        });
        //Boton enviar
        ibEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Controlamos el caso de que el nombre o el mensaje este vacio
                if(etName.length() == 0 || etMensaje.length() == 0)
                    return;
                //Creamos un obejto de tipo mensaje donde vamos a mandar el mensaje y el nombre
                MensajeVO mMensajeVO = new MensajeVO();
                mMensajeVO.setMessage(etMensaje.getText().toString());
                mMensajeVO.setName(etName.getText().toString());
                //Agregamos a la istancia de Firestore y le mandamos directamente el objeto mMensajeVO
                FirebaseFirestore.getInstance().collection("Chat").add(mMensajeVO);
                //Mandamos cadenas vacias a nuestro caja de texto para que esten listas para enviar un nuevo mensaje
                //etMensaje.setText("");
                //etName.setText("");
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setComponentes();
    }
}
