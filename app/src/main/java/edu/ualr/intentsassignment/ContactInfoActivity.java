package edu.ualr.intentsassignment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.WindowDecorActionBar;


import java.text.BreakIterator;

import edu.ualr.intentsassignment.databinding.ActivityContactInfoBinding;
import edu.ualr.intentsassignment.model.Contact;

public class ContactInfoActivity extends AppCompatActivity {
    // TODO 03. Create a new layout file to define the GUI elements of the ContactInfoActivity.
    // TODO 04. Define the basic skeleton of the ContactInfoActivity. Inflate the layout defined in the first step to display the GUI elements on screen.
    // TODO 07. Create a new method that reads the contact info coming from ContactFormActivity and use it to populate the several TextView elements in the layout.
    // TODO 08. Create a new method that invokes a Phone Dialer app, using as parameter the phone number included in the contact info received from ContactFormActivity in the previous step
    // TODO 09. Create a new method that invokes a Messages app, using as parameter the phone number included in the contact info received from ContactFormActivity in the 7th step
    // TODO 10. Create a new method that invokes a Maps app, using as parameter the address included in the contact info received from ContactFormActivity in the 7th step
    // TODO 11. Create a new method that invokes an Email app, using as parameter the email address included in the contact info received from ContactFormActivity in the 7th step
    // TODO 12. Create a new method that invokes an Web Browser app, using as parameter the web url included in the contact info received from ContactFormActivity in the 7th step
    private ActivityContactInfoBinding mBinding;
    private BreakIterator textViewName;
    private BreakIterator textViewEmail;
    private Object contact;
    private WindowDecorActionBar.TabImpl textViewContactInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = ActivityContactInfoBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);


        View textViewContactInfo = findViewById(R.id.textViewContactName);


        // Retrieve the Contact data from the intent
        Intent intent = getIntent();
        if (intent != null) {
            Contact contact = intent.getParcelableExtra("contact");
            //To display  the contact information
            displayContactInfo(contact);
        }



        //To invoke the Message app with the phone number
        if (contact != null) {
           // sendSmsMessage(contact.getPhoneNumber());
        }
        //To invoke the Maps app with the address
        if (contact != null) {
           // openMapsApp(contact.getAddress());
        }

        //To invoke the Email app with the email address
        if (contact != null) {
           // sendEmail(contact.getEmailAddress());
        }

        //To invoke the Web Browser app with the web URL
        if (contact != null) {
        //    openWebBrowser(contact.getWebsite());
        }


        }


    private void dialPhoneNumber(String phoneNumber) {
    }

    private void openWebBrowser(String website) {
        //To invoke the Web Browser app
        if (website != null && !website.isEmpty()) {
            //Create an intent to open the Email app with the email address provided
            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));

            //Check for Web Browser app
            if (webIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(webIntent);
            }
        }
    }

    private void sendEmail(String emailAddress) {
        //To invoke the Email app
        if (emailAddress != null && !emailAddress.isEmpty()) {
            //Create an intent to open the Email app with the email address provided
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:" + emailAddress));

            //Check for Maps app available on the device
            if (emailIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(emailIntent);
            }
        }
     }

    private void openMapsApp(String address) {
        if (address != null && !address.isEmpty()) {
            //To encode the address to create a URI for the Maps app
            Uri locationUri = Uri.parse("geo:0,0?q=" + Uri.encode(address));

            //To create an intent to open the Maps app with the location
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, locationUri);

            //Check for Maps app available on the device
            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(mapIntent);
            }

        }
     }


    private void displayContactInfo(Contact contact) {
        if (contact != null) {
            mBinding.textViewContactName.setText(contact.getFullName());
            mBinding.textPhoneNumber.setText(contact.getPhoneNumber());
            mBinding.textViewEmail.setText(contact.getEmailAddress());
            mBinding.textViewAddress.setText(contact.getAddress());
            mBinding.textViewWebsite.setText(contact.getWebsite());

        }
    }
    private void sendSmsMessage(String phoneNumber) {

        if(phoneNumber != null && !phoneNumber.isEmpty()) {
            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + phoneNumber));
            startActivity(smsIntent);
        }
    }

}
