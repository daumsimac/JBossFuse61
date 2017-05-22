package com.redhat.training;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TransformationMain {
	public static void main(String[] args) {
		String line = null;
		boolean read = false;
		int count = 0;
		while (!read && count < 5) {
			try {
				FileReader file = new FileReader(
						"in/order1.txt");
				BufferedReader reader = new BufferedReader(file);
				line = reader.readLine();
				reader.close();
				read = true;

				line = line.replaceAll(";", ",");
				FileWriter writer = new FileWriter(
						"out/order1.txt");
				writer.write(line);
				writer.flush();
				writer.close();
			} catch (IOException e) {
				count++;
			}

		}
	}
}
