package com.ofb.javaSession;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class JavaCopyFile {
	   public static void main(String[] args) throws InterruptedException, IOException {
		final Logger logger = Logger.getLogger(JavaCopyFile.class);
		PropertyConfigurator
				.configure("/home/ofb-140/workspace/JavaSession/src/config/log4j.properties");
		File source = new File("/home/ofb-140/Downloads/pancard.pdf");
		File tempfile = new File("/home/ofb-140/Music/tempfile.pdf");
		File newfile = new File("/home/ofb-140/Music/pancard.pdf");
		FileUtils.copyFile(source, tempfile);
		Files.deleteIfExists(newfile.toPath());
		URI tempFileUri = tempfile.toURI();
		URI newfileUri = newfile.toURI();
		Path temp = Files.move(Paths.get(tempFileUri), Paths.get(newfileUri));
		if (temp != null) {
			logger.debug("File renamed and moved successfully");
		} else {
			logger.debug("Failed to move the file");
		}

	}
	}
