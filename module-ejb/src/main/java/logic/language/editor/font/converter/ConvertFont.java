package logic.language.editor.font.converter;

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.google.typography.font.sfntly.FontFactory;
import com.google.typography.font.sfntly.Font;
import com.google.typography.font.sfntly.data.WritableFontData;
import com.google.typography.font.tools.conversion.eot.EOTWriter;
import com.google.typography.font.tools.conversion.woff.WoffWriter;

public class ConvertFont {

	@SuppressWarnings("serial")
	public static class Error extends Exception {

		public Error() {
		}

		public Error(String msg) {
			super(msg);
		}
	}

	public static class UsageError extends Error {
	}

	public static interface FontConverter {
		public WritableFontData convert(Font font) throws IOException;
		public String extension();
	}

	public static class EOTConverter implements FontConverter {

		private EOTWriter writer = new EOTWriter();

		public WritableFontData convert(Font font) throws IOException {
			return writer.convert(font);
		}

		public String extension() {
			return "eot";
		}
	}

	public static class WOFFConverter implements FontConverter {

		private WoffWriter writer = new WoffWriter();

		public WritableFontData convert(Font font) throws IOException {
			return writer.convert(font);
		}

		public String extension() {
			return "woff";
		}
	}

	public static FontConverter getFontConverter(String extension) {
		extension = extension.toLowerCase();
		if("woff".equals(extension)) {
			return new WOFFConverter();
		} else if("eot".equals(extension)) {
			return new EOTConverter();
		} else {
			return null;
		}
	}
}
