package local;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.logIn.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class NovelReaderActivity extends Activity {

    private static final int READ_CODE = 1;

    private Button chooseFileButton;

    private File tempFile; // 用于保存临时文件

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel_reader);

        chooseFileButton = findViewById(R.id.chooseFileButton);

        chooseFileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestReadExternalStoragePermission();
            }
        });
    }

    private void requestReadExternalStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED)
            //Manifest.permission.READ_EXTERNAL_STORAGE：是一个字符串常量，表示读取外部存储的权限。
            //PackageManager.PERMISSION_GRANTED 是一个常量，表示权限已被授予
        {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    // 权限数组，指定需要请求的权限。在这种情况下，我们请求读取外部存储的权限。
                    READ_CODE);
        } else {
            openFilePicker();
        }
    }
    //用于检查是否已经获得了读取外部存储权限。如果权限尚未授予，它将请求权限；
    // 如果权限已经授予，它将调用 openFilePicker() 方法。

    private void openFilePicker() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("text/plain");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, READ_CODE);
    }
    //调用 openFilePicker() 方法后，将会打开一个文件选择器，用户可以浏览并选择本地的纯文本文件。
    // 选择完成后，系统将会回调 onActivityResult() 方法，并传递选择的文件信息


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == READ_CODE && resultCode == RESULT_OK)
        //这个条件确保我们正在处理来自正确请求的结果，并且操作成功。
        {
            if (data != null)
            //检查data是否不为null，这意味着我们从意图中接收到了有效的数据。然后，我们从data意图中提取所选文件的URI。
            {
                Uri uri = data.getData();
                saveFileContent(uri);//这个方法负责将文件内容保存到临时文件中。
                String filePath = tempFile.getAbsolutePath();
                //获取保存内容的临时文件的绝对文件路径。这将用于将文件路径传递给startReadingActivity(filePath)方法。
                startReadingActivity(filePath);//这个方法负责启动阅读活动并使用提供的文件路径开始阅读过程。
                //将文件路径作为参数传递给它
            }
        }
    }

    private void saveFileContent(Uri uri) {
        InputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = getContentResolver().openInputStream(uri);
            //调用getContentResolver().openInputStream(uri)来获取指定URI的输入流。
            tempFile = createTempFile();
            outputStream = new FileOutputStream(tempFile);
            //我们创建一个临时文件，并将其赋值给tempFile。
            // createTempFile()方法负责创建一个唯一的临时文件，并返回对该文件的引用。
            // 然后，我们使用FileOutputStream打开临时文件的输出流，以便将数据写入其中。
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1)
                {
                    outputStream.write(buffer, 0, bytesRead);//将缓冲区中的数据写入输出流。
                }
                //在这个循环中，我们使用一个缓冲区来逐块读取输入流的数据，并将其写入输出流中。
                //每次循环，我们将读取的字节数存储在bytesRead变量中.
            } catch (IOException e)
            {
                e.printStackTrace();
            } finally {
                try {
                        if (inputStream != null) {
                        inputStream.close();
                        }
                        if (outputStream != null) {
                        outputStream.close();
                        }
                    }
                    catch (IOException e) {
                      e.printStackTrace();
                    }
                        }
        //在最后的部分，我们使用try-catch-finally块来确保在操作完成后关闭输入流和输出流。
        // 在try块中，我们捕获可能发生的IOException异常，并打印堆栈跟踪。
        // 在finally块中，我们使用close()方法关闭输入流和输出流，以确保资源的正确释放。
    }
    //此方法的作用是将从URI中读取的文件内容保存到临时文件中

    private File createTempFile() {
        try {
            File tempDir = getCacheDir();//调用getCacheDir()方法获取应用程序的缓存目录。
            File tempFile = File.createTempFile("temp", ".txt", tempDir);
            //使用File.createTempFile()方法创建一个临时文件。
            //该方法接受三个参数：前缀、后缀和目录。在这里，我们指定了前缀为"temp"，后缀为".txt"，并将目录设置为应用程序的缓存目录。
            //系统将在该目录中创建一个唯一的临时文件，并将其返回给我们。
            return tempFile;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
        //在try块中，我们尝试创建临时文件并返回其引用。
        //如果在创建过程中发生任何IOException异常，我们将打印堆栈跟踪信息。
        // 如果发生异常，我们将返回null作为文件引用。
    }
    //createTempFile()方法负责创建一个唯一的临时文件，并返回对该文件的引用

    private void startReadingActivity(String filePath) {
        Intent intent = new Intent(this, local.ReadingActivity.class);
        intent.putExtra("filePath", filePath);
        //将文件路径作为额外的参数添加到意图中。使用键值对的形式，将键设置为"filePath"，值设置为传递的文件路径。
        startActivity(intent);//启动！！！
    }
    //startReadingActivity() 方法的作用是启动阅读活动（ReadingActivity）并传递文件路径作为额外的参数。

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == READ_CODE) {
            //这里首先检查请求码（requestCode）是否与我们之前发起的读取权限请求码（READ_CODE）相匹配。
            //如果相匹配，说明我们正在处理读取权限的请求结果
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openFilePicker();
            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }//我们检查授权结果数组（grantResults）的长度是否大于0，并且第一个授权结果是否为授权成功（PackageManager.PERMISSION_GRANTED）。
            // 如果是，表示用户已授予读取权限，我们调用openFilePicker()方法打开文件选择器进行文件选择。
            // 否则，我们显示一个短暂的 Toast 提示用户权限被拒绝。
        }
    }//onRequestPermissionsResult() 方法用于处理权限请求的结果。
}
