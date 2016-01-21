package com.amaze.filemanager.utils;

import android.content.Context;
import android.widget.Toast;

import com.amaze.filemanager.R;
import com.amaze.filemanager.filesystem.RootHelper;
import com.stericson.RootTools.RootTools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

/**
 * Created by arpitkh996 on 13-01-2016.
 */
public class Logger {

    public static void log(final Exception s,final String s1, Context context) {
        final File f = new File(context.getExternalFilesDir("internal"),"log.txt");
        new Thread(new Runnable() {
            @Override
            public void run() {
                FileWriter output = null;
                try {
                    StringWriter sw = new StringWriter();
                    PrintWriter pw = new PrintWriter(sw);
                    if(s!=null)
                    s.printStackTrace(pw);
                    output = new FileWriter(f.getPath());
                    BufferedWriter writer = new BufferedWriter(output);
                    writer.write(s1+"\n");
                    writer.write(sw.toString());
                    writer.close();
                    output.close();
                } catch (IOException e) {
                }
            }
        }).start();
    }
}
