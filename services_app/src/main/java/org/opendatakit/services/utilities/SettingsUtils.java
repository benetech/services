package org.opendatakit.services.utilities;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class SettingsUtils {

    private Context context;

    public SettingsUtils(Context context){
        this.context = context;
    }

    public void saveOfficeIdToFile(String value)
    {
        try {
            String filename = "settings.txt";
            FileOutputStream file = context.openFileOutput(filename, Context.MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(file);
            if(value.equals(""))
                value = "null";
            writer.write(value);
            writer.close();
            file.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public String getOfficeIdFromFile() {
        try {
            String filename = "settings.txt";
            FileInputStream file = context.getApplicationContext().openFileInput(filename);
            InputStreamReader reader = new InputStreamReader(file);
            char[] inputBuffer = new char[100];
            int i = reader.read(inputBuffer);
            String content = new String(inputBuffer, 0, i);
            reader.close();
            file.close();
            return content;
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
