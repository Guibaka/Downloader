package downloader.fc;

import java.net.URL;

import java.nio.file.Files;

import javax.swing.SwingWorker;

import java.net.URLConnection;
import java.net.MalformedURLException;

import java.io.File;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class Downloader extends SwingWorker<String, Integer> {
	public static final int CHUNK_SIZE = 1024;

	URL url;
	int content_length;
	BufferedInputStream in;

	String filename;
	File temp;
	FileOutputStream out;
	ReentrantLock lock = new ReentrantLock();

	private int _progress;
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	public Downloader(String uri) {
		try {

			url = new URL(uri);

			URLConnection connection = url.openConnection();
			content_length = connection.getContentLength();

			in = new BufferedInputStream(connection.getInputStream());

			String[] path = url.getFile().split("/");
			filename = path[path.length - 1];
			temp = File.createTempFile(filename, ".part");
			out = new FileOutputStream(temp);

		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public String toString() {
		return url.toString();
	}

	public String download() throws InterruptedException {
		byte buffer[] = new byte[CHUNK_SIZE];
		int size = 0;
		int count = 0;

		lock.lock();
		try {
			while (true) {
				try {
					count = in.read(buffer, 0, CHUNK_SIZE);
				} catch (IOException e) {
					continue;
				}

				if (count < 0) {
					break;
				}

				try {
					out.write(buffer, 0, count);
				} catch (IOException e) {
					continue;
				}

				size += count;
				setProgress(100 * size / content_length);
				Thread.sleep(2000);
			}
		}finally {
			lock.unlock();
		}
		

		if (size < content_length) {
			temp.delete();
			throw new InterruptedException();
		}

		// temp.renameTo(new File(filename));
		try {
			Files.move(temp.toPath(), new File(filename).toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new InterruptedException();
		}
		return filename;
	}

	@Override
	protected String doInBackground() throws Exception {
		// TODO Auto-generated method stub
		return download();
	}

	/*
	 * public int getProgress() { return _progress; }
	 * 
	 * public void setProgress(int progress) { int old_progress = _progress;
	 * _progress = progress; pcs.firePropertyChange("progress", old_progress,
	 * progress); }
	 * 
	 * public void addPropertyChangeListener(PropertyChangeListener listener) {
	 * pcs.addPropertyChangeListener(listener); }
	 * 
	 * public void removePropertyChangeListener(PropertyChangeListener listener) {
	 * pcs.removePropertyChangeListener(listener); }
	 */

	public void pause() {
		lock.lock();
	}

	public void resume() {
		lock.unlock();
	}

}
