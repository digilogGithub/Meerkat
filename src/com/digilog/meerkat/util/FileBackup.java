package com.digilog.meerkat.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileBackup {

	public void fileBackup(String fileName) {

		File file = new File(fileName);
		if (file.exists()) {
			try {
				String fileNameSplit[] = file.getPath().split("\\.");
				long time = System.currentTimeMillis();
				SimpleDateFormat dayTime = new SimpleDateFormat("yyyy_MMdd_HHmmss");
				String strDate = dayTime.format(new Date(time));
				String backupFileName = fileNameSplit[0] + strDate + "."+fileNameSplit[1];

				FileInputStream fis;
				fis = new FileInputStream(fileName);

				FileOutputStream fos = new FileOutputStream(backupFileName);
				int data = 0;
				while ((data = fis.read()) != -1) {
					fos.write(data);
				}

				fis.close();
				fos.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
