package edu.ualr.intentsassignment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import edu.ualr.intentsassignment.databinding.ActivityContactFormBinding;
import edu.ualr.intentsassignment.model.Contact;

public class ContactFormActivity extends AppCompatActivity {

    private ActivityContactFormBinding mBinding;
    private EditText editTextName;
    private EditText editTextEmail;
    private String phone;
    private String address;
    private String website;
    private String email;
    private String firstName;
    private String lastName;
    // TODO 01. Create a new layout file to define the GUI elements of the ContactFormActivity.
    // TODO 02. Define the basic skeleton of the ContactFormActivity. Inflate the layout defined in the first step to display the GUI elements on screen.
    // TODO 06. Create a new method that reads the values in the several Edi

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = ActivityContactFormBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);



        //Initialize EditText and buttonSubmit fields
        EditText editTextFirstName = findViewById(R.id.editTextFirstName);
        EditText editTextLastName = findViewById(R.id.editTextLastName);
        EditText editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        EditText editTextAddress = findViewById(R.id.editTextAddress);
        EditText editTextWebsite = findViewById(R.id.editTextWebsite);
        Button buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Read data from EditText fields
                String firstName = editTextFirstName.getText().toString();
                String lastName = editTextLastName.getText().toString();
                String phone = editTextPhoneNumber.getText().toString();
                String email = editTextEmail.getText().toString();
                String address = editTextAddress.getText().toString();
                String website = editTextWebsite.getText().toString();

                //Create a Contact instance with the read data
                Contact contact = new Contact();
                contact.setFirstName(firstName);
                contact.setLastName(lastName);
                contact.setPhoneNumber(phone);
                contact.setEmailAddress(email);
                contact.setAddress(address);
                contact.setWebsite(website);

                //Method to send data to ContactInfoActivity is Called
                sendDataToContactInfo(contact);
            }
        });
    }


    private void dialPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
            startActivity(dialIntent);
        }
    }

    private void displayContactInfo(Contact contact) {
    }

    //Send the data to ContactInfoActivity
    private void sendDataToContactInfo(Contact contact) {
                Intent intent;
                intent = new Intent(ContactFormActivity.this, ContactInfoActivity.class);
                intent.putExtra("contact", contact);
                startActivity(intent);

            }

    }




