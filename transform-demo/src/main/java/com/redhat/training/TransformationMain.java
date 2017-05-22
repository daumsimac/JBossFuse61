package com.redhat.training;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TransformationMain {
	public static void main(String[] args) throws IOException {
		FileReader file = new FileReader("in/order1.txt");
		BufferedReader reader = new BufferedReader(file);
		String line = reader.readLine();
		reader.close();
		line = line.replaceAll(",", ";");
		FileWriter writer = new FileWriter("out/order1.txt");
		writer.write(line);
		writer.flush();
		writer.close();
	}
}
